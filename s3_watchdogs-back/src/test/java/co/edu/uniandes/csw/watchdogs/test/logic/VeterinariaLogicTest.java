/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.watchdogs.test.logic;

import co.edu.uniandes.csw.watchdogs.ejb.VeterinariaLogic;
import co.edu.uniandes.csw.watchdogs.entities.AseoEntity;
import co.edu.uniandes.csw.watchdogs.entities.PaseoEntity;
import co.edu.uniandes.csw.watchdogs.entities.VeterinariaEntity;
import co.edu.uniandes.csw.watchdogs.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.watchdogs.persistence.VeterinariaPersistence;
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
 * @author js.vacat
 */
@RunWith(Arquillian.class)
public class VeterinariaLogicTest {

    private PodamFactory factory = new PodamFactoryImpl();

    @Inject
    private VeterinariaLogic veterinariaLogic;

    @PersistenceContext
    private EntityManager em;

    @Inject
    private UserTransaction utx;

    private List<VeterinariaEntity> data = new ArrayList<>();

    private List<PaseoEntity> paseosData = new ArrayList<>();

    private List<AseoEntity> aseosData = new ArrayList<>();

    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(VeterinariaEntity.class.getPackage())
                .addPackage(VeterinariaLogic.class.getPackage())
                .addPackage(VeterinariaPersistence.class.getPackage())
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
        em.createQuery("delete from AseoEntity").executeUpdate();
        em.createQuery("delete from VeterinariaEntity").executeUpdate();

    }

    /**
     * Inserta los datos iniciales para el correcto funcionamiento de las
     * pruebas.
     */
    private void insertData() {
        for (int i = 0; i < 3; i++) {
            PaseoEntity entity = factory.manufacturePojo(PaseoEntity.class);
            em.persist(entity);
            paseosData.add(entity);
        }
        for (int i = 0; i < 3; i++) {
            AseoEntity entity = factory.manufacturePojo(AseoEntity.class);
            em.persist(entity);
            aseosData.add(entity);
        }
        for (int i = 0; i < 3; i++) {
            VeterinariaEntity entity = factory.manufacturePojo(VeterinariaEntity.class);
            em.persist(entity);
            data.add(entity);
        }
    }

    /**
     * Prueba para crear una Veterinaria
     *
     * @throws co.edu.uniandes.csw.watchdogs.exceptions.BusinessLogicException
     */
    @Test
    public void createVeterinariaTest() throws BusinessLogicException {
        VeterinariaEntity newEntity = factory.manufacturePojo(VeterinariaEntity.class);
        VeterinariaEntity result = veterinariaLogic.createVeterinaria(newEntity);
        Assert.assertNotNull(result);
        VeterinariaEntity entity = em.find(VeterinariaEntity.class, result.getId());
        Assert.assertEquals(newEntity.getId(), entity.getId());
    }

    /**
     * Prueba para consultar la lista de Veterinarias
     */
    @Test
    public void getVeterinariasTest() {
        List<VeterinariaEntity> list = veterinariaLogic.getVeterinarias();
        Assert.assertEquals(data.size(), list.size());
        for (VeterinariaEntity entity : list) {
            boolean found = false;
            for (VeterinariaEntity storedEntity : data) {
                if (entity.getId().equals(storedEntity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }

    /**
     * Prueba para consultar una Veterinaria
     */
    @Test
    public void getVeterinariaTest() {
        VeterinariaEntity entity = data.get(0);
        VeterinariaEntity resultEntity = veterinariaLogic.getVeterinaria(entity.getId());
        Assert.assertNotNull(resultEntity);
        Assert.assertEquals(entity.getId(), resultEntity.getId());
        Assert.assertEquals(entity.getUsuariosEnServicio(), resultEntity.getUsuariosEnServicio());
        Assert.assertEquals(entity.getCapacidadMaxima(), resultEntity.getCapacidadMaxima());
        Assert.assertEquals(entity.getFotos(), resultEntity.getFotos());
        Assert.assertEquals(entity.getDireccion(), resultEntity.getDireccion());

        Assert.assertNull(veterinariaLogic.getVeterinaria(Long.MIN_VALUE));
    }

    /**
     * Prueba para eliminar una Veterinaria
     */
    @Test
    public void deleteVeterinariaTest() {
        VeterinariaEntity entity = data.get(0);
        veterinariaLogic.deleteVeterinaria(entity.getId());
        VeterinariaEntity deleted = em.find(VeterinariaEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }

    /**
     * Prueba para actualizar una Veterinaria
     *
     * @throws co.edu.uniandes.csw.watchdogs.exceptions.BusinessLogicException
     */
    @Test
    public void updateCentroDeEntrenamientoTest() throws BusinessLogicException {
        VeterinariaEntity entity = data.get(0);
        VeterinariaEntity pojoEntity = factory.manufacturePojo(VeterinariaEntity.class);

        pojoEntity.setId(entity.getId());

        veterinariaLogic.updateVeterinaria(pojoEntity.getId(), pojoEntity);

        VeterinariaEntity resp = em.find(VeterinariaEntity.class, entity.getId());

        Assert.assertEquals(pojoEntity.getId(), resp.getId());
        Assert.assertEquals(pojoEntity.getUsuariosEnServicio(), resp.getUsuariosEnServicio());
        Assert.assertEquals(pojoEntity.getCapacidadMaxima(), resp.getCapacidadMaxima());
        Assert.assertEquals(pojoEntity.getFotos(), resp.getFotos());
        Assert.assertEquals(pojoEntity.getDireccion(), resp.getDireccion());
    }

    /**
     * Prueba para el añadido correcto de aseos
     */
    @Test
    public void addAseoTest() throws BusinessLogicException {
        VeterinariaEntity entity = data.get(0);
        AseoEntity aseo = aseosData.get(0);
        veterinariaLogic.addAseo(entity.getId(), aseo.getId());
        VeterinariaEntity resultEntity = veterinariaLogic.getVeterinaria(entity.getId());
        Assert.assertTrue(!resultEntity.getAseos().isEmpty());
        Assert.assertTrue(aseo.getId().equals(resultEntity.getAseos().get(0).getId()));

    }

    /**
     * Prueba para el añadido correcto de paseos
     */
    //@Test
    public void addPaseoTest() throws BusinessLogicException {
        VeterinariaEntity entity = data.get(0);
        PaseoEntity paseo = paseosData.get(0);
        veterinariaLogic.addPaseo(entity.getId(), paseo.getId());
        VeterinariaEntity resultEntity = veterinariaLogic.getVeterinaria(entity.getId());
        Assert.assertTrue(!resultEntity.getPaseos().isEmpty());
        Assert.assertTrue(paseo.getId().equals(resultEntity.getPaseos().get(0).getId()));

    }
}
