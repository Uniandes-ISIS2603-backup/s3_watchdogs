/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.watchdogs.test.persistence;

import co.edu.uniandes.csw.watchdogs.entities.AseoEntity;
import co.edu.uniandes.csw.watchdogs.persistence.AseoPersistence;
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
 * @author js.vacat
 */
@RunWith(Arquillian.class)
public class AseoPersistenceTest {
    
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(AseoEntity.class.getPackage())
                .addPackage(AseoPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }
    @Inject
    private AseoPersistence aseoPersistence;
    
    @PersistenceContext
    private EntityManager em;

    @Inject
    UserTransaction utx;
    
    private List<AseoEntity> data = new ArrayList<AseoEntity>();
    
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
        em.createQuery("delete from AseoEntity").executeUpdate();
    }
    
     /**
     * Inserta los datos iniciales para el correcto funcionamiento de las pruebas.
     */
    private void insertData() {
        PodamFactory factory = new PodamFactoryImpl();
        for (int i = 0; i < 3; i++) {
            AseoEntity entity = factory.manufacturePojo(AseoEntity.class);  
            em.persist(entity);
            data.add(entity);
        }
    }

    @Test
    public void createAseoTest(){
        PodamFactory factory = new PodamFactoryImpl();
        AseoEntity newEntity = factory.manufacturePojo(AseoEntity.class);
        AseoEntity result = aseoPersistence.create(newEntity);

        Assert.assertNotNull(result);

        AseoEntity entity = em.find(AseoEntity.class, result.getId());

        Assert.assertEquals(newEntity.getId(), entity.getId());
        Assert.assertEquals(newEntity.getFecha(), entity.getFecha());
        Assert.assertEquals(newEntity.getCosto(),entity.getCosto(),0);
        Assert.assertEquals(newEntity.isEstado(), entity.isEstado());
        Assert.assertEquals(newEntity.getRango(), entity.getRango());
        Assert.assertEquals(newEntity.getDuracion(), entity.getDuracion(),0);
        Assert.assertEquals(newEntity.getHora(), entity.getHora());
        Assert.assertEquals(newEntity.getBanho(), entity.getBanho());
        Assert.assertEquals(newEntity.getDientes(), entity.getDientes());
        Assert.assertEquals(newEntity.getPeluqueria(), entity.getPeluqueria());
        
    }
    
    @Test
    public void getAseosTest() {
        List<AseoEntity> list = aseoPersistence.findAll();
        Assert.assertEquals(data.size(), list.size());
        for (AseoEntity ent : list) {
            boolean found = false;
            for (AseoEntity entity : data) {
                if (ent.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }
    
     @Test
    public void getAseoTest() {
        AseoEntity entity = data.get(0);
        AseoEntity newEntity = aseoPersistence.find(entity.getId());
        Assert.assertNotNull(newEntity);
        Assert.assertEquals(entity.getId(), newEntity.getId());
        Assert.assertEquals(entity.getFecha(), newEntity.getFecha());
        Assert.assertEquals(entity.getCosto(), newEntity.getCosto(),0);
        Assert.assertEquals(entity.isEstado(), newEntity.isEstado());
        Assert.assertEquals(entity.getRango(), newEntity.getRango());
        Assert.assertEquals(entity.getDuracion(), newEntity.getDuracion(),0);
        Assert.assertEquals(entity.getHora(), newEntity.getHora());
        Assert.assertEquals(entity.getBanho(), newEntity.getBanho());
        Assert.assertEquals(entity.getDientes(), newEntity.getDientes());
        Assert.assertEquals(entity.getPeluqueria(), newEntity.getPeluqueria());
    }
    
    @Test
    public void deleteAseoTest() {
        AseoEntity entity = data.get(0);
        aseoPersistence.delete(entity.getId());
        AseoEntity deleted = em.find(AseoEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }

    @Test
    public void updateAseoTest() {
        AseoEntity entity = data.get(0);
        PodamFactory factory = new PodamFactoryImpl();
        AseoEntity newEntity = factory.manufacturePojo(AseoEntity.class);

        newEntity.setId(entity.getId());

        aseoPersistence.update(newEntity);

        AseoEntity resp = em.find(AseoEntity.class, entity.getId());

        Assert.assertEquals(newEntity.getId(), resp.getId());
        Assert.assertEquals(newEntity.getFecha(), resp.getFecha());
        Assert.assertEquals(newEntity.getCosto(), resp.getCosto(),0);
        Assert.assertEquals(newEntity.isEstado(), resp.isEstado());
        Assert.assertEquals(newEntity.getRango(), resp.getRango());
        Assert.assertEquals(newEntity.getDuracion(), resp.getDuracion(),0);
        Assert.assertEquals(newEntity.getHora(), resp.getHora());
        Assert.assertEquals(newEntity.getBanho(), resp.getBanho());
        Assert.assertEquals(newEntity.getDientes(), resp.getDientes());
        Assert.assertEquals(newEntity.getPeluqueria(), resp.getPeluqueria());
    }
}
