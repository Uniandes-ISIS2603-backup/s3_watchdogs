/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.watchdogs.test.logic;

import co.edu.uniandes.csw.watchdogs.ejb.MascotaLogic;
import co.edu.uniandes.csw.watchdogs.entities.MascotaEntity;
import co.edu.uniandes.csw.watchdogs.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.watchdogs.persistence.MascotaPersistence;
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
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

/**
 *
 * @author ca.beltran10
 */
@RunWith(Arquillian.class)
public class MascotaLogicTest {
    
    private PodamFactory factory = new PodamFactoryImpl();

    @Inject
    private MascotaLogic mascotaLogic;

    @PersistenceContext
    private EntityManager em;

    @Inject
    private UserTransaction utx;

    private List<MascotaEntity> data = new ArrayList<MascotaEntity>();

    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(MascotaEntity.class.getPackage())
                .addPackage(MascotaLogic.class.getPackage())
                .addPackage(MascotaPersistence.class.getPackage())
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
        em.createQuery("delete from MascotaEntity").executeUpdate();
        em.createQuery("delete from ClienteEntity").executeUpdate();
    }

    /**
     * Inserta los datos iniciales para el correcto funcionamiento de las
     * pruebas.
     */
    private void insertData() {

        for (int i = 0; i < 3; i++) {
            MascotaEntity entity = factory.manufacturePojo(MascotaEntity.class);
            em.persist(entity);
            data.add(entity);

        }

    }

    /**
     * Prueba para crear un Mascota
     */
    @Test
    public void createMascotaTest() {
        try {
            MascotaEntity newEntity = factory.manufacturePojo(MascotaEntity.class);
            MascotaEntity result = mascotaLogic.createMascota(newEntity);
            Assert.assertNotNull(result);
            MascotaEntity entity = em.find(MascotaEntity.class, result.getId());
            Assert.assertEquals(newEntity.getId(), entity.getId());
            Assert.assertEquals(newEntity.getName(), entity.getName());
        } catch (BusinessLogicException e) {
            fail();
        }

    }

    /**
     * Prueba para consultar la lista de Mascota
     */
    @Test
    public void getMascotasTest() {
        List<MascotaEntity> list = mascotaLogic.getMascotas();
        Assert.assertEquals(data.size(), list.size());
        for (MascotaEntity entity : list) {
            boolean found = false;
            for (MascotaEntity storedEntity : data) {
                if (entity.getId().equals(storedEntity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }

    /**
     * Prueba para consultar un Mascota
     */
    @Test
    public void getMascotaTest() {
        MascotaEntity entity = data.get(0);
        MascotaEntity resultEntity = mascotaLogic.getMascota(entity.getId());
        Assert.assertNotNull(resultEntity);
        Assert.assertEquals(entity.getId(), resultEntity.getId());
        Assert.assertEquals(entity.getName(), resultEntity.getName());
    }

    /**
     * Prueba para eliminar un Empleado
     */
    @Test
    public void deleteAuthorTest() {
        try {
            MascotaEntity entity = data.get(0);
            mascotaLogic.deleteMascota(entity.getId());
            MascotaEntity deleted = em.find(MascotaEntity.class, entity.getId());
            Assert.assertNull(deleted);
        } catch (BusinessLogicException e) {
            fail();
        }

    }

    /**
     * Prueba para actualizar un Empleado
     */
    @Test
    public void updateAuthorTest() {
        MascotaEntity entity = data.get(0);
        MascotaEntity pojoEntity = factory.manufacturePojo(MascotaEntity.class);

        pojoEntity.setId(entity.getId());

        mascotaLogic.updateMascota(entity.getId(), pojoEntity);

        MascotaEntity resp = em.find(MascotaEntity.class, entity.getId());

        Assert.assertEquals(pojoEntity.getId(), resp.getId());
        Assert.assertEquals(pojoEntity.getName(), resp.getName());
    }
}
