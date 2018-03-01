/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.watchdogs.test.persistence;

import co.edu.uniandes.csw.watchdogs.entities.CentroDeEntrenamientoEntity;
import co.edu.uniandes.csw.watchdogs.persistence.CentroDeEntrenamientoPersistence;
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
public class CentroDeEntrenamientoTest {
    
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(CentroDeEntrenamientoEntity.class.getPackage())
                .addPackage(CentroDeEntrenamientoPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }
    @Inject
    private CentroDeEntrenamientoPersistence centroDeEntrenamientoPersistence;
    
    @PersistenceContext
    private EntityManager em;

    @Inject
    UserTransaction utx;
    
    private List<CentroDeEntrenamientoEntity> data = new ArrayList<CentroDeEntrenamientoEntity>();
    
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
        em.createQuery("delete from CentroDeEntrenamientoEntity").executeUpdate();
    }
    
    /**
     * Inserta los datos iniciales para el correcto funcionamiento de las pruebas.
     */
    private void insertData() {
        PodamFactory factory = new PodamFactoryImpl();
        for (int i = 0; i < 3; i++) {
            CentroDeEntrenamientoEntity entity = factory.manufacturePojo(CentroDeEntrenamientoEntity.class);
            
            em.persist(entity);
            data.add(entity);
        }
    }
    
    @Test
    public void createEntrenamientoTest(){
        PodamFactory factory = new PodamFactoryImpl();
        CentroDeEntrenamientoEntity newEntity = factory.manufacturePojo(CentroDeEntrenamientoEntity.class);
        CentroDeEntrenamientoEntity result = centroDeEntrenamientoPersistence.create(newEntity);

        Assert.assertNotNull(result);

        CentroDeEntrenamientoEntity entity = em.find(CentroDeEntrenamientoEntity.class, result.getId());

        Assert.assertEquals(newEntity.getId(), entity.getId());
        Assert.assertEquals(newEntity.getTiempoEntreno(), entity.getTiempoEntreno());
    }
    
    @Test
    public void getEntrenamientosTest() {
        List<CentroDeEntrenamientoEntity> list = centroDeEntrenamientoPersistence.findAll();
        Assert.assertEquals(data.size(), list.size());
        for (CentroDeEntrenamientoEntity ent : list) {
            boolean found = false;
            for (CentroDeEntrenamientoEntity entity : data) {
                if (ent.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }
    
    @Test
    public void getEntrenamientoTest() {
        CentroDeEntrenamientoEntity entity = data.get(0);
        CentroDeEntrenamientoEntity newEntity = centroDeEntrenamientoPersistence.find(entity.getId());
        Assert.assertNotNull(newEntity);
        Assert.assertEquals(newEntity.getId(), entity.getId());
        Assert.assertEquals(newEntity.getTiempoEntreno(), entity.getTiempoEntreno());

    }
    
    @Test
    public void deleteEntrenamientoTest() {
        CentroDeEntrenamientoEntity entity = data.get(0);
        centroDeEntrenamientoPersistence.delete(entity.getId());
        CentroDeEntrenamientoEntity deleted = em.find(CentroDeEntrenamientoEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }
    
    @Test
    public void updateEntrenamientoTest() {
        CentroDeEntrenamientoEntity entity = data.get(0);
        PodamFactory factory = new PodamFactoryImpl();
        CentroDeEntrenamientoEntity newEntity = factory.manufacturePojo(CentroDeEntrenamientoEntity.class);

        newEntity.setId(entity.getId());

        centroDeEntrenamientoPersistence.update(newEntity);

        CentroDeEntrenamientoEntity resp = em.find(CentroDeEntrenamientoEntity.class, entity.getId());

        Assert.assertEquals(newEntity.getId(), resp.getId());
        Assert.assertEquals(newEntity.getTiempoEntreno(), resp.getTiempoEntreno());
    }
}
