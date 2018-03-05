/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.watchdogs.test.logic;

import co.edu.uniandes.csw.watchdogs.ejb.EmpleadoLogic;
import co.edu.uniandes.csw.watchdogs.entities.EmpleadoEntity;
import co.edu.uniandes.csw.watchdogs.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.watchdogs.persistence.EmpleadoPersistence;
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
public class EmpleadoLogicTest {

    private PodamFactory factory = new PodamFactoryImpl();

    @Inject
    private EmpleadoLogic empleadoLogic;

    @PersistenceContext
    private EntityManager em;

    @Inject
    private UserTransaction utx;

    private List<EmpleadoEntity> data = new ArrayList<>();

    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(EmpleadoEntity.class.getPackage())
                .addPackage(EmpleadoLogic.class.getPackage())
                .addPackage(EmpleadoPersistence.class.getPackage())
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
        em.createQuery("delete from EmpleadoEntity").executeUpdate();
        em.createQuery("delete from DisponibilidadEntity").executeUpdate();
        em.createQuery("delete from CalificacionEntity").executeUpdate();
    }

    /**
     * Inserta los datos iniciales para el correcto funcionamiento de las
     * pruebas.
     */
    private void insertData() {

        for (int i = 0; i < 3; i++) {
            EmpleadoEntity entity = factory.manufacturePojo(EmpleadoEntity.class);
            em.persist(entity);
            data.add(entity);

        }

    }

    /**
     * Prueba para crear un Empleado
     */
    @Test
    public void createEmpleadoTest() {
        try {
            EmpleadoEntity newEntity = factory.manufacturePojo(EmpleadoEntity.class);
            EmpleadoEntity result = empleadoLogic.createEmpleado(newEntity);
            Assert.assertNotNull(result);
            EmpleadoEntity entity = em.find(EmpleadoEntity.class, result.getId());
            Assert.assertEquals(newEntity.getId(), entity.getId());
            Assert.assertEquals(newEntity.getName(), entity.getName());
            Assert.assertEquals(newEntity.getCedula(), entity.getCedula());
        } catch (BusinessLogicException e) {
            fail();
        }

    }

    /**
     * Prueba para consultar la lista de Empleados
     */
    @Test
    public void getEmpleadosTest() {
        List<EmpleadoEntity> list = empleadoLogic.getEmpleados();
        Assert.assertEquals(data.size(), list.size());
        for (EmpleadoEntity entity : list) {
            boolean found = false;
            for (EmpleadoEntity storedEntity : data) {
                if (entity.getId().equals(storedEntity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }

    /**
     * Prueba para consultar un Empleado
     */
    @Test
    public void getEmpleadoTest() {
        EmpleadoEntity entity = data.get(0);
        EmpleadoEntity resultEntity = empleadoLogic.getEmpleado(entity.getId());
        Assert.assertNotNull(resultEntity);
        Assert.assertEquals(entity.getId(), resultEntity.getId());
        Assert.assertEquals(entity.getName(), resultEntity.getName());
        Assert.assertEquals(entity.getCedula(), resultEntity.getCedula());
    }

    /**
     * Prueba para eliminar un Empleado
     */
    @Test
    public void deleteEmpleadoTest() {
        try {
            EmpleadoEntity entity = data.get(0);
            empleadoLogic.deleteEmpleado(entity.getId());
            EmpleadoEntity deleted = em.find(EmpleadoEntity.class, entity.getId());
            Assert.assertNull(deleted);
        } catch (BusinessLogicException e) {
            fail();
        }

    }

    /**
     * Prueba para actualizar un Empleado
     */
    @Test
    public void updateEmpleadoTest() {
        EmpleadoEntity entity = data.get(0);
        EmpleadoEntity pojoEntity = factory.manufacturePojo(EmpleadoEntity.class);

        pojoEntity.setId(entity.getId());

        empleadoLogic.updateEmpleado(entity.getId(), pojoEntity);

        EmpleadoEntity resp = em.find(EmpleadoEntity.class, entity.getId());

        Assert.assertEquals(pojoEntity.getId(), resp.getId());
        Assert.assertEquals(pojoEntity.getName(), resp.getName());
        Assert.assertEquals(pojoEntity.getCedula(), resp.getCedula());
    }

}
