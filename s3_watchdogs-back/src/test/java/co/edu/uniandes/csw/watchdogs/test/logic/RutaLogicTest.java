/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.watchdogs.test.logic;

import co.edu.uniandes.csw.watchdogs.ejb.RutaLogic;
import co.edu.uniandes.csw.watchdogs.entities.RutaEntity;
import co.edu.uniandes.csw.watchdogs.exceptions.BusinessLogicException;
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
public class RutaLogicTest {
    
    private PodamFactory factory = new PodamFactoryImpl();

    @Inject
    private RutaLogic rutaLogic;

    @PersistenceContext
    private EntityManager em;

    @Inject
    private UserTransaction utx;

    private List<RutaEntity> data = new ArrayList<RutaEntity>();

    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(RutaEntity.class.getPackage())
                .addPackage(RutaLogic.class.getPackage())
                .addPackage(RutaPersistence.class.getPackage())
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
        em.createQuery("delete from RutaEntity").executeUpdate();
    }

    /**
     * Inserta los datos iniciales para el correcto funcionamiento de las
     * pruebas.
     *
     *
     */
    private void insertData() {
        for (int i = 0; i < 3; i++) {
            RutaEntity entity = factory.manufacturePojo(RutaEntity.class);
            em.persist(entity);
            data.add(entity);
        }
    }

    /**
     * Prueba para crear una ruta
     *
     *
     */
    @Test
    public void createRutaTest() throws BusinessLogicException {
        RutaEntity newEntity = factory.manufacturePojo(RutaEntity.class);
        RutaEntity result = rutaLogic.createRuta(newEntity);
        Assert.assertNotNull(result);
        RutaEntity entity = em.find(RutaEntity.class, result.getId());
        Assert.assertEquals(newEntity.getId(), entity.getId());
        Assert.assertEquals(newEntity.getName(), entity.getName());
        Assert.assertEquals(newEntity.getDuracion(), entity.getDuracion(),0);
    }

    /**
     * Prueba para consultar la lista de Rutas
     *
     *
     */
    @Test
    public void getRutasTest() {
        List<RutaEntity> list = rutaLogic.getRutas();
        Assert.assertEquals(data.size(), list.size());
        for (RutaEntity entity : list) {
            boolean found = false;
            for (RutaEntity storedEntity : data) {
                if (entity.getId().equals(storedEntity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }

    /**
     * Prueba para consultar una Factura
     *
     *
     */
    @Test
    public void getRutaTest() {
        RutaEntity entity = data.get(0);
        RutaEntity resultEntity = rutaLogic.getRuta(entity.getId());
        Assert.assertNotNull(resultEntity);
        Assert.assertEquals(entity.getId(), resultEntity.getId());
        Assert.assertEquals(entity.getName(), resultEntity.getName());
        Assert.assertEquals(resultEntity.getDuracion(), entity.getDuracion(),0);

    }

    /**
     * Prueba para eliminar una Ruta
     *
     *
     */
    @Test
    public void deleteRutaTest() {
        RutaEntity entity = data.get(0);
        rutaLogic.deleteRuta(entity.getId());
        RutaEntity deleted = em.find(RutaEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }

    /**
     * Prueba para actualizar una Ruta
     *
     *
     */
    @Test
    public void updateRutaTest() throws BusinessLogicException {
        RutaEntity entity = data.get(0);
        RutaEntity pojoEntity = factory.manufacturePojo(RutaEntity.class);

        pojoEntity.setId(entity.getId());

        rutaLogic.updateRuta(pojoEntity.getId(), pojoEntity);

        RutaEntity resp = em.find(RutaEntity.class, entity.getId());

        Assert.assertEquals(pojoEntity.getId(), resp.getId());
        Assert.assertEquals(pojoEntity.getName(), resp.getName());
        Assert.assertEquals(pojoEntity.getDuracion(), resp.getDuracion(),0);

    }
    
}
