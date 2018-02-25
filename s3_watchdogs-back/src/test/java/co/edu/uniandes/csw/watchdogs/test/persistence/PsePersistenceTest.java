/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.watchdogs.test.persistence;

import co.edu.uniandes.csw.watchdogs.entities.CalificacionEntity;
import co.edu.uniandes.csw.watchdogs.entities.PayPalEntity;
import co.edu.uniandes.csw.watchdogs.entities.PseEntity;
import co.edu.uniandes.csw.watchdogs.persistence.CalificacionPersistence;
import co.edu.uniandes.csw.watchdogs.persistence.PsePersistence;
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
 * @author jc.pulido
 */
@RunWith(Arquillian.class)

public class PsePersistenceTest {
    
     @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(CalificacionEntity.class.getPackage())
                .addPackage(CalificacionPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }
    
    @Inject
    private PsePersistence psePersistence;
    
    @PersistenceContext
    private EntityManager em;
    
    @Inject
    UserTransaction utx;
    
    private List<PseEntity> data = new ArrayList<PseEntity>();
    
    
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
        em.createQuery("delete from PayPalEntity").executeUpdate();
    }
    
     /**
     * Inserta los datos iniciales para el correcto funcionamiento de las pruebas.
     */
    private void insertData() {
        PodamFactory factory = new PodamFactoryImpl();
        for (int i = 0; i < 3; i++) {
            PseEntity entity = factory.manufacturePojo(PseEntity.class);  
            em.persist(entity);
            data.add(entity);
        }
    }
    
    @Test
    public void createPseTest(){
        PodamFactory factory = new PodamFactoryImpl();
        PseEntity newEntity = factory.manufacturePojo(PseEntity.class);
        PseEntity result = psePersistence.create(newEntity);

        Assert.assertNotNull(result);

        PseEntity entity = em.find(PseEntity.class, result.getId());

        Assert.assertEquals(newEntity.getCorreo(), entity.getCorreo());
    }
    
     @Test
    public void getPsesTest() {
        List<PseEntity> list = psePersistence.findAll();
        Assert.assertEquals(data.size(), list.size());
        for (PseEntity ent : list) {
            boolean found = false;
            for (PseEntity entity : data) {
                if (ent.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }
    
    @Test
    public void getPseTest() {
        PseEntity entity = data.get(0);
        PseEntity newEntity = psePersistence.find(entity.getId());
        Assert.assertNotNull(newEntity);
        Assert.assertEquals(entity.getCorreo(), newEntity.getCorreo());
    }
    
     @Test
    public void deletePseTest() {
        PseEntity entity = data.get(0);
        psePersistence.delete(entity.getId());
        PayPalEntity deleted = em.find(PayPalEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }
    
     @Test
    public void updatePseTest() {
        PseEntity entity = data.get(0);
        PodamFactory factory = new PodamFactoryImpl();
        PseEntity newEntity = factory.manufacturePojo(PseEntity.class);

        newEntity.setId(entity.getId());

        psePersistence.update(newEntity);

        PseEntity resp = em.find(PseEntity.class, entity.getId());

        Assert.assertEquals(newEntity.getCorreo(), resp.getCorreo());
    }
}
