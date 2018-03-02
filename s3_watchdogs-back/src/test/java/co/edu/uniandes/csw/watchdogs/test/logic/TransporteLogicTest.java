/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.watchdogs.test.logic;

import co.edu.uniandes.csw.watchdogs.ejb.TransporteLogic;
import co.edu.uniandes.csw.watchdogs.entities.TransporteEntity;
import co.edu.uniandes.csw.watchdogs.exceptions.BusinessLogicException;
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
public class TransporteLogicTest {
    
    private PodamFactory factory = new PodamFactoryImpl();

    @Inject
    private TransporteLogic transporteLogic;

    @PersistenceContext
    private EntityManager em;

    @Inject
    private UserTransaction utx;

    private List<TransporteEntity> data = new ArrayList<TransporteEntity>();

    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(TransporteEntity.class.getPackage())
                .addPackage(TransporteLogic.class.getPackage())
                .addPackage(TransportePersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }

    /**
     * Configuración inicial de la prueba.
     *
     *
     */
    @Before
    public void configTest() {
        try {
            utx.begin();
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
     *
     *
     */
    private void clearData() {
        em.createQuery("delete from TransporteEntity").executeUpdate();
    }

    /**
     * Inserta los datos iniciales para el correcto funcionamiento de las
     * pruebas.
     *
     *
     */
    private void insertData() {  
        for (int i = 0; i < 3; i++) {
            TransporteEntity entity = factory.manufacturePojo(TransporteEntity.class);
            em.persist(entity);
            data.add(entity);
        }
    }
    
    /**
     * Prueba para crear un Book
     *
     *
     */
    @Test
    public void createTransporteTest() throws BusinessLogicException {
        TransporteEntity newEntity = factory.manufacturePojo(TransporteEntity.class);
        TransporteEntity result = transporteLogic.createTransporte(newEntity);
        Assert.assertNotNull(result);
        TransporteEntity entity = em.find(TransporteEntity.class, result.getId());
        Assert.assertEquals(newEntity.getId(), entity.getId());
        Assert.assertEquals(newEntity.getDevuelta(), entity.getDevuelta());
        Assert.assertEquals(newEntity.getDireccion(), entity.getDireccion());
        Assert.assertEquals(newEntity.getRecogida(), entity.getRecogida());

    }

    /**
     * Prueba para consultar la lista de Calificaciones
     *
     *
     */
    @Test
    public void getTransportesTest() {
        List<TransporteEntity> list = transporteLogic.getTransportes();
        Assert.assertEquals(data.size(), list.size());
        for (TransporteEntity entity : list) {
            boolean found = false;
            for (TransporteEntity storedEntity : data) {
                if (entity.getId().equals(storedEntity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }

    /**
     * Prueba para consultar un Calificacion
     *
     *
     */
    @Test
    public void getTransporteTest() {
        TransporteEntity entity = data.get(0);
        TransporteEntity resultEntity = transporteLogic.getTransporte(entity.getId());
        Assert.assertNotNull(resultEntity);
        Assert.assertEquals(entity.getId(), resultEntity.getId());
        Assert.assertEquals(entity.getDevuelta(), resultEntity.getDevuelta());
        Assert.assertEquals(entity.getDireccion(), resultEntity.getDireccion());
        Assert.assertEquals(entity.getRecogida(), resultEntity.getRecogida());


    }

    /**
     * Prueba para eliminar un Book
     *
     *
     */
    @Test
    public void deleteTransporteTest() {
        TransporteEntity entity = data.get(0);
        transporteLogic.deleteTransporte(entity.getId());
        TransporteEntity deleted = em.find(TransporteEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }

    /**
     * Prueba para actualizar un Book
     *
     *
     */
    @Test
    public void updateTransporteTest() throws BusinessLogicException {
        TransporteEntity entity = data.get(0);
        TransporteEntity pojoEntity = factory.manufacturePojo(TransporteEntity.class);

        pojoEntity.setId(entity.getId());

        transporteLogic.updateTransporte(pojoEntity.getId(), pojoEntity);

        TransporteEntity resp = em.find(TransporteEntity.class, entity.getId());

        Assert.assertEquals(pojoEntity.getId(), resp.getId());
        Assert.assertEquals(pojoEntity.getDevuelta(), resp.getDevuelta());
        Assert.assertEquals(pojoEntity.getDireccion(), resp.getDireccion());
        Assert.assertEquals(pojoEntity.getRecogida(), resp.getRecogida());

    }
}
