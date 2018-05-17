/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.watchdogs.test.persistence;

import co.edu.uniandes.csw.watchdogs.entities.DisponibilidadEntity;
import co.edu.uniandes.csw.watchdogs.persistence.DisponibilidadPersistence;
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
public class DisponibilidadPersistenceTest {

    @Deployment
    public static JavaArchive createDeployement() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(DisponibilidadEntity.class.getPackage())
                .addPackage(DisponibilidadPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }

    @Inject
    private DisponibilidadPersistence disponibilidadPersistence;

    @PersistenceContext
    private EntityManager em;

    @Inject
    UserTransaction utx;

    private List<DisponibilidadEntity> data = new ArrayList<DisponibilidadEntity>();

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
        em.createQuery("Delete from DisponibilidadEntity").executeUpdate();
    }

    /**
     * Inserta los datos iniciales para el correcto funcionamiento de las
     * pruebas.
     */
    private void insertData() {
        PodamFactory factory = new PodamFactoryImpl();
        for (int i = 0; i < 3; i++) {
            DisponibilidadEntity entity = factory.manufacturePojo(DisponibilidadEntity.class);
            em.persist(entity);
            data.add(entity);
        }
    }

    @Test
    public void createEmpleadoTest() {
        PodamFactory factory = new PodamFactoryImpl();
        DisponibilidadEntity newEntity = factory.manufacturePojo(DisponibilidadEntity.class);
        DisponibilidadEntity result = disponibilidadPersistence.create(newEntity);

        Assert.assertNotNull(result);

        DisponibilidadEntity entity = em.find(DisponibilidadEntity.class, result.getId());

        Assert.assertEquals(newEntity.getId(), entity.getId());
    }

    @Test
    public void findAllTest() {
        List<DisponibilidadEntity> list = disponibilidadPersistence.findAll();
        for (DisponibilidadEntity ent : list) {
            boolean found = false;
            for (DisponibilidadEntity entity : data) {
                if (ent.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }

    @Test
    public void findTest() {
        DisponibilidadEntity entity = data.get(0);
        DisponibilidadEntity newEntity = disponibilidadPersistence.find(entity.getId());
        Assert.assertNotNull(newEntity);
        Assert.assertEquals(entity.getId(), newEntity.getId());
    }

    @Test
    public void updateTest() {
        DisponibilidadEntity entity = data.get(0);
        PodamFactory factory = new PodamFactoryImpl();
        DisponibilidadEntity newEntity = factory.manufacturePojo(DisponibilidadEntity.class);

        newEntity.setId(entity.getId());

        disponibilidadPersistence.update(newEntity);

        DisponibilidadEntity resp = em.find(DisponibilidadEntity.class, entity.getId());

        Assert.assertEquals(newEntity.getId(), resp.getId());
    }

    @Test
    public void deleteTest() {
        DisponibilidadEntity entity = data.get(0);
        disponibilidadPersistence.delete(entity.getId());
        DisponibilidadEntity deleted = em.find(DisponibilidadEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }

}
