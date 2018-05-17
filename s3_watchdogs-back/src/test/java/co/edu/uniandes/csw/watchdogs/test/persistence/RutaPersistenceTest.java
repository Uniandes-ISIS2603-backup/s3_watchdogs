/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.watchdogs.test.persistence;

import co.edu.uniandes.csw.watchdogs.entities.RutaEntity;
import co.edu.uniandes.csw.watchdogs.persistence.RutaPersistence;
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
 * @author id.salazar
 */

@RunWith(Arquillian.class)
public class RutaPersistenceTest {
    
    @Deployment
    public static JavaArchive createDeployement() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(RutaEntity.class.getPackage())
                .addPackage(RutaPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }
    
    @Inject
    private RutaPersistence rutaPersistence;
    
    @PersistenceContext
    private EntityManager em;
    
    @Inject
    UserTransaction utx;
    
    private List<RutaEntity> data = new ArrayList<RutaEntity>();
    
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
        em.createQuery("Delete from RutaEntity").executeUpdate();
    }
    
    /**
     * Inserta los datos iniciales para el correcto funcionamiento de las pruebas.
     */
    private void insertData() {
        PodamFactory factory = new PodamFactoryImpl();
        for (int i = 0; i < 3; i++) {
            RutaEntity entity = factory.manufacturePojo(RutaEntity.class);  
            em.persist(entity);
            data.add(entity);
        }
    }
    
    @Test
    public void createRutaTest() {
        PodamFactory factory = new PodamFactoryImpl();
        RutaEntity newEntity = factory.manufacturePojo(RutaEntity.class);
        RutaEntity result = rutaPersistence.create(newEntity);
        
        Assert.assertNotNull(result);
        
        RutaEntity entity = em.find(RutaEntity.class, result.getId());
        
        Assert.assertEquals(newEntity.getId(), entity.getId());
    }
    
    @Test
    public void findAllTest() {
        List<RutaEntity> list = rutaPersistence.findAll();
        for (RutaEntity ent : list) {
            boolean found = false;
            for (RutaEntity entity : data) {
                if (ent.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }
    
    @Test
    public void findTest() {
        RutaEntity entity = data.get(0);
        RutaEntity newEntity = rutaPersistence.find(entity.getId());
        Assert.assertNotNull(newEntity);
        Assert.assertEquals(entity.getId(), newEntity.getId());
        Assert.assertEquals(entity.getPaseos(), newEntity.getPaseos());
    }
    
    @Test
    public void updateTest() {
        RutaEntity entity = data.get(0);
        PodamFactory factory = new PodamFactoryImpl();
        RutaEntity newEntity = factory.manufacturePojo(RutaEntity.class);

        newEntity.setId(entity.getId());

        rutaPersistence.update(newEntity);

        RutaEntity resp = em.find(RutaEntity.class, entity.getId());

        Assert.assertEquals(newEntity.getId(), resp.getId());
    }
    
    @Test
    public void deleteTest() {
        RutaEntity entity = data.get(0);
        rutaPersistence.delete(entity.getId());
        RutaEntity deleted = em.find(RutaEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }
}
