/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.watchdogs.test.persistence;

import co.edu.uniandes.csw.watchdogs.entities.EntrenamientoEntity;
import co.edu.uniandes.csw.watchdogs.persistence.EntrenamientoPersistence;
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
 * @author c.martinezc1
 */
@RunWith(Arquillian.class)
public class EntrenamientoPersistenceTest {
    
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(EntrenamientoEntity.class.getPackage())
                .addPackage(EntrenamientoPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }
    @Inject
    private EntrenamientoPersistence entrenamientoPersistence;
    
    @PersistenceContext
    private EntityManager em;

    @Inject
    UserTransaction utx;
    
    private List<EntrenamientoEntity> data = new ArrayList<EntrenamientoEntity>();
    
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
        em.createQuery("delete from EntrenamientoEntity").executeUpdate();
    }
    
    /**
     * Inserta los datos iniciales para el correcto funcionamiento de las pruebas.
     */
    private void insertData() {
        PodamFactory factory = new PodamFactoryImpl();
        for (int i = 0; i < 3; i++) {
            EntrenamientoEntity entity = factory.manufacturePojo(EntrenamientoEntity.class);
            
            em.persist(entity);
            data.add(entity);
        }
    }
    
    @Test
    public void createEntrenamientoTest(){
        PodamFactory factory = new PodamFactoryImpl();
        EntrenamientoEntity newEntity = factory.manufacturePojo(EntrenamientoEntity.class);
        EntrenamientoEntity result = entrenamientoPersistence.create(newEntity);

        Assert.assertNotNull(result);

        EntrenamientoEntity entity = em.find(EntrenamientoEntity.class, result.getId());

        Assert.assertEquals(entity.getId(), newEntity.getId());
        Assert.assertEquals(entity.getFecha(), newEntity.getFecha());
        Assert.assertEquals(entity.getHora(), newEntity.getHora());
        Assert.assertEquals(entity.getTransporte(), newEntity.getTransporte());
        Assert.assertEquals(entity.getRango(), newEntity.getRango());
        Assert.assertEquals(entity.getEmpleado(), newEntity.getEmpleado());
        Assert.assertEquals(entity.getCentroDeEntrenamiento(), newEntity.getCentroDeEntrenamiento());
        Assert.assertEquals(entity.getCliente(), newEntity.getCliente());
        Assert.assertEquals(entity.getMascota(), newEntity.getMascota());
        Assert.assertEquals(entity.getDuracion(), newEntity.getDuracion());
        Assert.assertEquals(entity.getHora(), newEntity.getHora());
    }
    
    @Test
    public void getEntrenamientosTest() {
        List<EntrenamientoEntity> list = entrenamientoPersistence.findAll();
        Assert.assertEquals(data.size(), list.size());
        for (EntrenamientoEntity ent : list) {
            boolean found = false;
            for (EntrenamientoEntity entity : data) {
                if (ent.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }
    
    @Test
    public void getEntrenamientoTest() {
        EntrenamientoEntity entity = data.get(0);
        EntrenamientoEntity newEntity = entrenamientoPersistence.find(entity.getId());
        Assert.assertNotNull(newEntity);
        Assert.assertEquals(entity.getId(), newEntity.getId());
        Assert.assertEquals(entity.getFecha(), newEntity.getFecha());
        Assert.assertEquals(entity.getHora(), newEntity.getHora());
        Assert.assertEquals(entity.getTransporte(), newEntity.getTransporte());
        Assert.assertEquals(entity.getRango(), newEntity.getRango());
        Assert.assertEquals(entity.getEmpleado(), newEntity.getEmpleado());
        Assert.assertEquals(entity.getCentroDeEntrenamiento(), newEntity.getCentroDeEntrenamiento());
        Assert.assertEquals(entity.getCliente(), newEntity.getCliente());
        Assert.assertEquals(entity.getMascota(), newEntity.getMascota());
        Assert.assertEquals(entity.getDuracion(), newEntity.getDuracion());
        Assert.assertEquals(entity.getHora(), newEntity.getHora());

    }
    
    @Test
    public void deleteEntrenamientoTest() {
        EntrenamientoEntity entity = data.get(0);
        entrenamientoPersistence.delete(entity.getId());
        EntrenamientoEntity deleted = em.find(EntrenamientoEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }
    
    @Test
    public void updateEntrenamientoTest() {
        EntrenamientoEntity entity = data.get(0);
        PodamFactory factory = new PodamFactoryImpl();
        EntrenamientoEntity newEntity = factory.manufacturePojo(EntrenamientoEntity.class);

        newEntity.setId(entity.getId());

        entrenamientoPersistence.update(newEntity);

        EntrenamientoEntity resp = em.find(EntrenamientoEntity.class, entity.getId());

        Assert.assertEquals(newEntity.getId(), resp.getId());
        Assert.assertEquals(newEntity.getFecha(), resp.getFecha());
        Assert.assertEquals(newEntity.getHora(), resp.getHora());
        Assert.assertEquals(newEntity.getTransporte(), resp.getTransporte());
        Assert.assertEquals(newEntity.getRango(), resp.getRango());
        Assert.assertEquals(newEntity.getEmpleado(), resp.getEmpleado());
        Assert.assertEquals(newEntity.getCentroDeEntrenamiento(), resp.getCentroDeEntrenamiento());
        Assert.assertEquals(newEntity.getCliente(), resp.getCliente());
        Assert.assertEquals(newEntity.getMascota(), resp.getMascota());
        Assert.assertEquals(newEntity.getDuracion(), resp.getDuracion());
        Assert.assertEquals(newEntity.getHora(), resp.getHora());
    }
}