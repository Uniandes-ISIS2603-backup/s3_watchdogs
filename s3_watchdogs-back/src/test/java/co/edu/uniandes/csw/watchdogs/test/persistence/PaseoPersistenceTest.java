/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.watchdogs.test.persistence;

import co.edu.uniandes.csw.watchdogs.entities.PaseoEntity;
import co.edu.uniandes.csw.watchdogs.persistence.PaseoPersistence;
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
public class PaseoPersistenceTest {
    
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(PaseoEntity.class.getPackage())
                .addPackage(PaseoPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }
    @Inject
    private PaseoPersistence PaseoPersistence;
    
    @PersistenceContext
    private EntityManager em;

    @Inject
    UserTransaction utx;
    
    private List<PaseoEntity> data = new ArrayList<PaseoEntity>();
    
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
        em.createQuery("delete from PaseoEntity").executeUpdate();
    }
    
    /**
     * Inserta los datos iniciales para el correcto funcionamiento de las pruebas.
     */
    private void insertData() {
        PodamFactory factory = new PodamFactoryImpl();
        for (int i = 0; i < 3; i++) {
            PaseoEntity entity = factory.manufacturePojo(PaseoEntity.class);
            
            em.persist(entity);
            data.add(entity);
        }
    }
    
    @Test
    public void createEntrenamientoTest(){
        PodamFactory factory = new PodamFactoryImpl();
        PaseoEntity newEntity = factory.manufacturePojo(PaseoEntity.class);
        PaseoEntity result = PaseoPersistence.create(newEntity);

        Assert.assertNotNull(result);

        PaseoEntity entity = em.find(PaseoEntity.class, result.getId());

        Assert.assertEquals(newEntity.getId(), entity.getId());
        Assert.assertEquals(newEntity.getCapMax(), entity.getCapMax());
    }
    
    @Test
    public void getEntrenamientosTest() {
        List<PaseoEntity> list = PaseoPersistence.findAll();
        Assert.assertEquals(data.size(), list.size());
        for (PaseoEntity ent : list) {
            boolean found = false;
            for (PaseoEntity entity : data) {
                if (ent.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }
    
    @Test
    public void getEntrenamientoTest() {
        PaseoEntity entity = data.get(0);
        PaseoEntity newEntity = PaseoPersistence.find(entity.getId());
        Assert.assertNotNull(newEntity);
        Assert.assertEquals(newEntity.getId(), entity.getId());
        Assert.assertEquals(newEntity.getCapMax(), entity.getCapMax());

    }
    
    @Test
    public void deleteEntrenamientoTest() {
        PaseoEntity entity = data.get(0);
        PaseoPersistence.delete(entity.getId());
        PaseoEntity deleted = em.find(PaseoEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }
    
    @Test
    public void updateEntrenamientoTest() {
        PaseoEntity entity = data.get(0);
        PodamFactory factory = new PodamFactoryImpl();
        PaseoEntity newEntity = factory.manufacturePojo(PaseoEntity.class);

        newEntity.setId(entity.getId());

        PaseoPersistence.update(newEntity);

        PaseoEntity resp = em.find(PaseoEntity.class, entity.getId());

        Assert.assertEquals(newEntity.getId(), resp.getId());
        Assert.assertEquals(newEntity.getCapMax(), resp.getCapMax());
    }
}
