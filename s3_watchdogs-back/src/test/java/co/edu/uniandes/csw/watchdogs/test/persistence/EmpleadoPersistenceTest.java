/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.watchdogs.test.persistence;

import co.edu.uniandes.csw.watchdogs.entities.EmpleadoEntity;
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
public class EmpleadoPersistenceTest {

    @Deployment
    public static JavaArchive createDeployement() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(EmpleadoEntity.class.getPackage())
                .addPackage(EmpleadoPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }

    @Inject
    private EmpleadoPersistence empleadoPersistence;

    @PersistenceContext
    private EntityManager em;

    @Inject
    UserTransaction utx;

    /**
     * Configuracion inicial de prueba.
     */
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
        em.createQuery("Delete from EmpleadoEntity").executeUpdate();
    }

    private List<EmpleadoEntity> data = new ArrayList<>();

    /**
     * Inserta los datos iniciales para el correcto funcionamiento de las
     * pruebas.
     */
    private void insertData() {
        PodamFactory factory = new PodamFactoryImpl();
        for (int i = 0; i < 3; i++) {
            EmpleadoEntity entity = factory.manufacturePojo(EmpleadoEntity.class);
            em.persist(entity);
            data.add(entity);
        }
    }

    /**
     * Prueba para crear un Empleado.
     */
    @Test
    public void createEmpleadoTest() {
        PodamFactory factory = new PodamFactoryImpl();
        EmpleadoEntity newEntity = factory.manufacturePojo(EmpleadoEntity.class);
        EmpleadoEntity result = empleadoPersistence.create(newEntity);

        Assert.assertNotNull(result);

        EmpleadoEntity entity = em.find(EmpleadoEntity.class, result.getId());

        Assert.assertEquals(newEntity.getId(), entity.getId());
    }

    /**
     * Prueba para consultar la lista de Empleados.
     */
    @Test
    public void findEmpleadosTest() {
        List<EmpleadoEntity> list = empleadoPersistence.findAll();
        for (EmpleadoEntity ent : list) {
            boolean found = false;
            for (EmpleadoEntity entity : data) {
                if (ent.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }

    /**
     * Prueba para consultar un Empleado por id.
     */
    @Test
    public void findEmpleadoTest() {
        EmpleadoEntity entity = data.get(0);
        EmpleadoEntity newEntity = empleadoPersistence.find(entity.getId());
        Assert.assertNotNull(newEntity);
        Assert.assertEquals(entity.getName(), newEntity.getName());
        Assert.assertEquals(entity.getCedula(), newEntity.getCedula());
        Assert.assertEquals(entity.getId(), newEntity.getId());
    }

    /**
     * Prueba para eliminar un Empleado.
     */
    @Test
    public void deleteTest() {
        EmpleadoEntity entity = data.get(0);
        empleadoPersistence.delete(entity.getId());
        EmpleadoEntity deleted = em.find(EmpleadoEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }

    /**
     * Prueba para actualizar un empleado.
     */
    @Test
    public void updateTest() {
        EmpleadoEntity entity = data.get(0);
        PodamFactory factory = new PodamFactoryImpl();
        EmpleadoEntity newEntity = factory.manufacturePojo(EmpleadoEntity.class);

        newEntity.setId(entity.getId());

        empleadoPersistence.update(newEntity);

        EmpleadoEntity resp = em.find(EmpleadoEntity.class, entity.getId());

        Assert.assertEquals(newEntity.getId(), resp.getId());
    }

    /**
     * Prueba para buscar por cedula.
     */
    @Test
    public void findByCedulaTest() {
        PodamFactory factory = new PodamFactoryImpl();
        EmpleadoEntity newEntity = factory.manufacturePojo(EmpleadoEntity.class);
        EmpleadoEntity result = empleadoPersistence.create(newEntity);

        Assert.assertNotNull(result);

        Assert.assertNotNull(empleadoPersistence.findByCedula(result.getCedula()));
    }

}
