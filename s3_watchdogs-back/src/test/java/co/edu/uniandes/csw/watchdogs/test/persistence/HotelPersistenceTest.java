/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.watchdogs.test.persistence;

import co.edu.uniandes.csw.watchdogs.entities.HotelEntity;
import co.edu.uniandes.csw.watchdogs.persistence.HotelPersistence;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

/**
 *
 * @author m.diazt
 */
@RunWith(Arquillian.class)
public class HotelPersistenceTest {
    
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(HotelEntity.class.getPackage())
                .addPackage(HotelPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }
    @Inject
    private HotelPersistence hotelPersistence;
    
    @PersistenceContext
    private EntityManager em;

    @Inject
    UserTransaction utx;
    
    private List<HotelEntity> data = new ArrayList<HotelEntity>();
    
    @Before
    public void configTest() {
        try {
            utx.begin();
            em.joinTransaction();
            clearData();
            insertData();
            utx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            try {
                utx.rollback();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
    }
    
    /**
     * Limpia las tablas que están implicadas en la prueba.
     */
    private void clearData() {
        em.createQuery("delete from HotelEntity").executeUpdate();
    }
    
    /**
     * Inserta los datos iniciales para el correcto funcionamiento de las pruebas.
     */
    private void insertData() {
        PodamFactory factory = new PodamFactoryImpl();
        for (int i = 0; i < 3; i++) {
            HotelEntity entity = factory.manufacturePojo(HotelEntity.class);
            
            em.persist(entity);
            data.add(entity);
        }
    }
    
    @Test
    public void createHotelTest(){
        PodamFactory factory = new PodamFactoryImpl();
        HotelEntity newEntity = factory.manufacturePojo(HotelEntity.class);
        HotelEntity result = hotelPersistence.create(newEntity);

        Assert.assertNotNull(result);

        HotelEntity entity = em.find(HotelEntity.class, result.getId());

        Assert.assertEquals(newEntity.getId(), entity.getId());
        Assert.assertEquals(newEntity.getTiempoHospedaje(), entity.getTiempoHospedaje());
    }
    
    @Test
    public void getHotelesTest() {
        List<HotelEntity> list = hotelPersistence.findAll();
        Assert.assertEquals(data.size(), list.size());
        for (HotelEntity ent : list) {
            boolean found = false;
            for (HotelEntity entity : data) {
                if (ent.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }
    
    @Test
    public void getHotelTest() {
        HotelEntity entity = data.get(0);
        HotelEntity newEntity = hotelPersistence.find(entity.getId());
        Assert.assertNotNull(newEntity);
        Assert.assertEquals(newEntity.getId(), entity.getId());
        Assert.assertEquals(newEntity.getTiempoHospedaje(), entity.getTiempoHospedaje());

    }
    
    @Test
    public void deleteHotelTest() {
        HotelEntity entity = data.get(0);
        hotelPersistence.delete(entity.getId());
        HotelEntity deleted = em.find(HotelEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }
    
    @Test
    public void updateHotelTest() {
        HotelEntity entity = data.get(0);
        PodamFactory factory = new PodamFactoryImpl();
        HotelEntity newEntity = factory.manufacturePojo(HotelEntity.class);

        newEntity.setId(entity.getId());

        hotelPersistence.update(newEntity);

        HotelEntity resp = em.find(HotelEntity.class, entity.getId());

        Assert.assertEquals(newEntity.getId(), resp.getId());
        Assert.assertEquals(newEntity.getTiempoHospedaje(), resp.getTiempoHospedaje());
    }
}
