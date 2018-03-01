/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.watchdogs.test.persistence;

import co.edu.uniandes.csw.watchdogs.entities.VeterinariaEntity;
import co.edu.uniandes.csw.watchdogs.persistence.VeterinariaPersistence;
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
public class VeterinariaPersistenceTest {
    
     @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(VeterinariaEntity.class.getPackage())
                .addPackage(VeterinariaPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }
    @Inject
    private VeterinariaPersistence veterinariaPersistence ;
    
    @PersistenceContext
    private EntityManager em;

    @Inject
    UserTransaction utx;
    
    private List<VeterinariaEntity> data = new ArrayList<VeterinariaEntity>();
    
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
        em.createQuery("delete from VeterinariaEntity").executeUpdate();
    }
    
     /**
     * Inserta los datos iniciales para el correcto funcionamiento de las pruebas.
     */
    private void insertData() {
        PodamFactory factory = new PodamFactoryImpl();
        for (int i = 0; i < 3; i++) {
            VeterinariaEntity entity = factory.manufacturePojo(VeterinariaEntity.class);  
            em.persist(entity);
            data.add(entity);
        }
    }

    @Test
    public void creatVeterinariaTest(){
        PodamFactory factory = new PodamFactoryImpl();
        VeterinariaEntity newEntity = factory.manufacturePojo(VeterinariaEntity.class);
        VeterinariaEntity result = veterinariaPersistence.create(newEntity);

        Assert.assertNotNull(result);

        VeterinariaEntity entity = em.find(VeterinariaEntity.class, result.getId());

        Assert.assertEquals(newEntity.getId(), entity.getId());
        Assert.assertEquals(newEntity.getCapacidad(), entity.getCapacidad());
        Assert.assertEquals(newEntity.getFotos(), entity.getFotos());
        Assert.assertEquals(newEntity.getDireccion(), entity.getDireccion());   
    }
    
    @Test
    public void getVeterinariasTest() {
        List<VeterinariaEntity> list = veterinariaPersistence.findAll();
        Assert.assertEquals(data.size(), list.size());
        for (VeterinariaEntity ent : list) {
            boolean found = false;
            for (VeterinariaEntity entity : data) {
                if (ent.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }
    
     @Test
    public void getVeterinariaTest() {
        VeterinariaEntity entity = data.get(0);
        VeterinariaEntity newEntity = veterinariaPersistence.find(entity.getId());
        Assert.assertNotNull(newEntity);
        Assert.assertEquals(entity.getId(), newEntity.getId());
        Assert.assertEquals(entity.getCapacidad(), newEntity.getCapacidad());
        Assert.assertEquals(entity.getFotos(), newEntity.getFotos());
        Assert.assertEquals(entity.getDireccion(), newEntity.getDireccion());
    }
    
    @Test
    public void deleteVeterinariaTest() {
        VeterinariaEntity entity = data.get(0);
        veterinariaPersistence.delete(entity.getId());
        VeterinariaEntity deleted = em.find(VeterinariaEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }

    @Test
    public void updateVeterinariaTest() {
        VeterinariaEntity entity = data.get(0);
        PodamFactory factory = new PodamFactoryImpl();
        VeterinariaEntity newEntity = factory.manufacturePojo(VeterinariaEntity.class);

        newEntity.setId(entity.getId());

        veterinariaPersistence.update(newEntity);

        VeterinariaEntity resp = em.find(VeterinariaEntity.class, entity.getId());

        Assert.assertEquals(newEntity.getId(), resp.getId());
        Assert.assertEquals(newEntity.getCapacidad(), resp.getCapacidad());
        Assert.assertEquals(newEntity.getFotos(), resp.getFotos());
        Assert.assertEquals(newEntity.getDireccion(), resp.getDireccion());
    }
}

