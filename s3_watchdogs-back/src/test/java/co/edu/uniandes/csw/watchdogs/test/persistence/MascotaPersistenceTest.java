/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.watchdogs.test.persistence;

import co.edu.uniandes.csw.watchdogs.entities.MascotaEntity;
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
public class MascotaPersistenceTest {

    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(MascotaEntity.class.getPackage())
                .addPackage(MascotaPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }

    @Inject
    private MascotaPersistence mascotaPersistence;

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
        em.createQuery("Delete from MascotaEntity").executeUpdate();
    }

    private List<MascotaEntity> data = new ArrayList<>();

    /**
     * Inserta los datos iniciales para el correcto funcionamiento de las
     * pruebas.
     */
    private void insertData() {
        PodamFactory factory = new PodamFactoryImpl();
        for (int i = 0; i < 3; i++) {
            MascotaEntity entity = factory.manufacturePojo(MascotaEntity.class);
            em.persist(entity);
            data.add(entity);
        }
    }

    /**
     * Prueba para crear una Mascota.
     */
    @Test
    public void createMascotaTest() {
        PodamFactory factory = new PodamFactoryImpl();
        MascotaEntity newEntity = factory.manufacturePojo(MascotaEntity.class);
        MascotaEntity result = mascotaPersistence.create(newEntity);

        Assert.assertNotNull(result);

        MascotaEntity entity = em.find(MascotaEntity.class, result.getId());

        Assert.assertEquals(newEntity.getId(), entity.getId());
    }

    /**
     * Prueba para consultar la lista de Mascotas
     */
    @Test
    public void findMascotasTest() {
        List<MascotaEntity> list = mascotaPersistence.findAll();
        for (MascotaEntity ent : list) {
            boolean found = false;
            for (MascotaEntity entity : data) {
                if (ent.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }

    /**
     * Prueba para consultar una Mascota por id.
     */
    @Test
    public void findTest() {
        MascotaEntity entity = data.get(0);
        MascotaEntity newEntity = mascotaPersistence.find(entity.getId());
        Assert.assertNotNull(newEntity);
        Assert.assertEquals(entity.getName(), newEntity.getName());
        Assert.assertEquals(entity.getRaza(), newEntity.getRaza());
        Assert.assertEquals(entity.getId(), newEntity.getId());
    }

    /**
     * Prueba para eliminar una Mascota.
     */
    @Test
    public void deleteTest() {
        MascotaEntity entity = data.get(0);
        mascotaPersistence.delete(entity.getId());
        MascotaEntity deleted = em.find(MascotaEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }

    /**
     * Prueba para actualizar una Mascota.
     */
    @Test
    public void updateTest() {
        MascotaEntity entity = data.get(0);
        PodamFactory factory = new PodamFactoryImpl();
        MascotaEntity newEntity = factory.manufacturePojo(MascotaEntity.class);

        newEntity.setId(entity.getId());

        mascotaPersistence.update(newEntity);

        MascotaEntity resp = em.find(MascotaEntity.class, entity.getId());

        Assert.assertEquals(newEntity.getId(), resp.getId());
    }

    /**
     * Prueba para buscar por nombre.
     */
    @Test
    public void findByNameTest() {
        PodamFactory factory = new PodamFactoryImpl();
        MascotaEntity newEntity = factory.manufacturePojo(MascotaEntity.class);
        MascotaEntity result = mascotaPersistence.create(newEntity);

        Assert.assertNotNull(result);

        Assert.assertNotNull(mascotaPersistence.findByName(result.getName()));
    }

}
