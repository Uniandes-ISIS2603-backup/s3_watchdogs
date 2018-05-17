/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.watchdogs.test.persistence;

import co.edu.uniandes.csw.watchdogs.entities.TransporteEntity;
import co.edu.uniandes.csw.watchdogs.persistence.TransportePersistence;
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
public class TransportePersistenceTest {

    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(TransporteEntity.class.getPackage())
                .addPackage(TransportePersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }
    @Inject
    private TransportePersistence transportePersistence;

    @PersistenceContext
    private EntityManager em;

    @Inject
    UserTransaction utx;

    private List<TransporteEntity> data = new ArrayList<TransporteEntity>();

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
        em.createQuery("delete from TransporteEntity").executeUpdate();
    }

    /**
     * Inserta los datos iniciales para el correcto funcionamiento de las
     * pruebas.
     */
    private void insertData() {
        PodamFactory factory = new PodamFactoryImpl();
        for (int i = 0; i < 3; i++) {
            TransporteEntity entity = factory.manufacturePojo(TransporteEntity.class);
            em.persist(entity);
            data.add(entity);
        }
    }

    @Test
    public void createTransporteTest() {
        PodamFactory factory = new PodamFactoryImpl();
        TransporteEntity newEntity = factory.manufacturePojo(TransporteEntity.class);
        TransporteEntity result = transportePersistence.create(newEntity);

        Assert.assertNotNull(result);

        TransporteEntity entity = em.find(TransporteEntity.class, result.getId());

        Assert.assertEquals(newEntity.getRecogida(), entity.getRecogida());
        Assert.assertEquals(newEntity.getDevuelta(), entity.getDevuelta());
        Assert.assertEquals(newEntity.getDireccion(), entity.getDireccion());
    }

    @Test
    public void getTransportesTest() {
        List<TransporteEntity> list = transportePersistence.findAll();
        Assert.assertEquals(data.size(), list.size());
        for (TransporteEntity ent : list) {
            boolean found = false;
            for (TransporteEntity entity : data) {
                if (ent.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }

    @Test
    public void getTransporteTest() {
        TransporteEntity entity = data.get(0);
        TransporteEntity newEntity = transportePersistence.find(entity.getId());
        Assert.assertNotNull(newEntity);
        Assert.assertEquals(entity.getDevuelta(), newEntity.getDevuelta());
        Assert.assertEquals(entity.getDireccion(), newEntity.getDireccion());
        Assert.assertEquals(entity.getRecogida(), newEntity.getRecogida());
    }

    @Test
    public void deleteTransporteTest() {
        TransporteEntity entity = data.get(0);
        transportePersistence.delete(entity.getId());
        TransporteEntity deleted = em.find(TransporteEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }

    @Test
    public void updateTransporteTest() {
        TransporteEntity entity = data.get(0);
        PodamFactory factory = new PodamFactoryImpl();
        TransporteEntity newEntity = factory.manufacturePojo(TransporteEntity.class);

        newEntity.setId(entity.getId());

        transportePersistence.update(newEntity);

        TransporteEntity resp = em.find(TransporteEntity.class, entity.getId());

        Assert.assertEquals(newEntity.getDevuelta(), resp.getDevuelta());
        Assert.assertEquals(newEntity.getDireccion(), resp.getDireccion());
        Assert.assertEquals(newEntity.getRecogida(), resp.getRecogida());
    }
}
