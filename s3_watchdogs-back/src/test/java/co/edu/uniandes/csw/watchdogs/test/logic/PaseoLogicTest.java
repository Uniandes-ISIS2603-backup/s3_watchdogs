/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.watchdogs.test.logic;

import co.edu.uniandes.csw.watchdogs.ejb.PaseoLogic;
import co.edu.uniandes.csw.watchdogs.entities.PaseoEntity;
import co.edu.uniandes.csw.watchdogs.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.watchdogs.persistence.PaseoPersistence;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
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
public class PaseoLogicTest {
    
    private PodamFactory factory = new PodamFactoryImpl();

    @Inject
    private PaseoLogic paseoLogic;

    @PersistenceContext
    private EntityManager em;

    @Inject
    private UserTransaction utx;

    private List<PaseoEntity> data = new ArrayList<>();

    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(PaseoEntity.class.getPackage())
                .addPackage(PaseoLogic.class.getPackage())
                .addPackage(PaseoPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }

    /**
     * Configuración inicial de la prueba.
     */
    @Before
    public void configTest() {
        try {
            utx.begin();
            clearData();
            insertData();
            utx.commit();
        } catch (IllegalStateException | SecurityException | HeuristicMixedException | HeuristicRollbackException | NotSupportedException | RollbackException | SystemException e) {
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
     * Inserta los datos iniciales para el correcto funcionamiento de las
     * pruebas.
     */
    private void insertData() {  
        for (int i = 0; i < 3; i++) {
            PaseoEntity entity = factory.manufacturePojo(PaseoEntity.class);
            em.persist(entity);
            data.add(entity);
        }
    }
    
    /**
     * Prueba para crear un Paseo
     * @throws co.edu.uniandes.csw.watchdogs.exceptions.BusinessLogicException
     */
    @Test
    public void createPaseoTest() throws BusinessLogicException {
        PaseoEntity newEntity = factory.manufacturePojo(PaseoEntity.class);
        PaseoEntity result = paseoLogic.createPaseo(newEntity);
        Assert.assertNotNull(result);
        PaseoEntity entity = em.find(PaseoEntity.class, result.getId());
        Assert.assertEquals(newEntity.getId(), entity.getId());
        Assert.assertEquals(newEntity.getCapMax(), entity.getCapMax());
    }

    /**
     * Prueba para consultar la lista de Paseos
     */
    @Test
    public void getPaseosTest() {
        List<PaseoEntity> list = paseoLogic.getPaseos();
        Assert.assertEquals(data.size(), list.size());
        for (PaseoEntity entity : list) {
            boolean found = false;
            for (PaseoEntity storedEntity : data) {
                if (entity.getId().equals(storedEntity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }

    /**
     * Prueba para consultar un Paseo
     */
    @Test
    public void getPaseoTest() {
        PaseoEntity entity = data.get(0);
        PaseoEntity resultEntity = paseoLogic.getPaseo(entity.getId());
        Assert.assertNotNull(resultEntity);
        Assert.assertEquals(entity.getId(), resultEntity.getId());
        Assert.assertEquals(entity.getCapMax(), resultEntity.getCapMax());
    }

    /**
     * Prueba para eliminar un Paseo
     */
    @Test
    public void deletePaseoTest() {
        PaseoEntity entity = data.get(0);
        paseoLogic.deletePaseo(entity.getId());
        PaseoEntity deleted = em.find(PaseoEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }

    /**
     * Prueba para actualizar un Paseo
     */
    @Test
    public void updatePaseoTest() throws BusinessLogicException {
        PaseoEntity entity = data.get(0);
        PaseoEntity pojoEntity = factory.manufacturePojo(PaseoEntity.class);

        pojoEntity.setId(entity.getId());

        paseoLogic.updatePaseo(pojoEntity.getId(), pojoEntity);

        PaseoEntity resp = em.find(PaseoEntity.class, entity.getId());

        Assert.assertEquals(pojoEntity.getId(), resp.getId());
        Assert.assertEquals(pojoEntity.getCapMax(), resp.getCapMax());
    }
}
