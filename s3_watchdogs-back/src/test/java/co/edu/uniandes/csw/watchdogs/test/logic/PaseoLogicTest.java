/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.watchdogs.test.logic;

import co.edu.uniandes.csw.watchdogs.ejb.PaseoLogic;
import co.edu.uniandes.csw.watchdogs.entities.CalificacionEntity;
import co.edu.uniandes.csw.watchdogs.entities.ClienteEntity;
import co.edu.uniandes.csw.watchdogs.entities.EmpleadoEntity;
import co.edu.uniandes.csw.watchdogs.entities.MascotaEntity;
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
import static org.junit.Assert.fail;
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

    private List<MascotaEntity> dataMascota = new ArrayList<MascotaEntity>();

    private List<EmpleadoEntity> dataEmpleado = new ArrayList<EmpleadoEntity>();

    private List<ClienteEntity> dataCliente = new ArrayList<ClienteEntity>();

    private List<CalificacionEntity> dataCalificacion = new ArrayList<CalificacionEntity>();

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
        em.createQuery("delete from ServicioEntity").executeUpdate();
        em.createQuery("delete from ClienteEntity").executeUpdate();
        em.createQuery("delete from MascotaEntity").executeUpdate();
        em.createQuery("delete from EmpleadoEntity").executeUpdate();
        em.createQuery("delete from CalificacionEntity").executeUpdate();
    }

    /**
     * Inserta los datos iniciales para el correcto funcionamiento de las
     * pruebas.
     */
    private void insertData() {
        for (int i = 0; i < 3; i++) {
            ClienteEntity clienteEntity = factory.manufacturePojo(ClienteEntity.class);
            em.persist(clienteEntity);
            dataCliente.add(clienteEntity);
        }
        for (int i = 0; i < 3; i++) {
            MascotaEntity mascotaEntity = factory.manufacturePojo(MascotaEntity.class);
            em.persist(mascotaEntity);
            dataMascota.add(mascotaEntity);
        }
        for (int i = 0; i < 3; i++) {
            EmpleadoEntity empleadoEntity = factory.manufacturePojo(EmpleadoEntity.class);
            em.persist(empleadoEntity);
            dataEmpleado.add(empleadoEntity);
        }
        for (int i = 0; i < 3; i++) {
            CalificacionEntity calificacion = factory.manufacturePojo(CalificacionEntity.class);
            em.persist(calificacion);
            dataCalificacion.add(calificacion);
        }
        for (int i = 0; i < 3; i++) {
            PaseoEntity entity = factory.manufacturePojo(PaseoEntity.class);
            if (i == 0) {
                entity.setEstado(Boolean.FALSE);
            } else {
                entity.setCalificacion(dataCalificacion.get(1));
            }
            em.persist(entity);
            data.add(entity);
        }
    }

    /**
     * Prueba para crear un Paseo
     *
     * @throws co.edu.uniandes.csw.watchdogs.exceptions.BusinessLogicException
     */
    @Test
    public void createPaseoTest() throws BusinessLogicException {
        PaseoEntity newEntity = factory.manufacturePojo(PaseoEntity.class);
        newEntity.setCliente(dataCliente.get(0));
        newEntity.setMascota(dataMascota.get(0));
        newEntity.setEmpleado(dataEmpleado.get(0));
        PaseoEntity result = paseoLogic.createPaseo(newEntity);
        Assert.assertNotNull(result);
        PaseoEntity entity = em.find(PaseoEntity.class, result.getId());
        Assert.assertEquals(newEntity.getId(), entity.getId());
        Assert.assertEquals(newEntity.getCapMax(), entity.getCapMax());
        Assert.assertEquals(newEntity.getCliente(), entity.getCliente());
        Assert.assertEquals(newEntity.getMascota(), entity.getMascota());
    }

    /**
     * Prueba para crear un paseo
     *
     * @throws co.edu.uniandes.csw.watchdogs.exceptions.BusinessLogicException
     */
    @Test
    public void createClientePaseoTest() throws BusinessLogicException {
        PaseoEntity newEntity = factory.manufacturePojo(PaseoEntity.class);
        newEntity.setCliente(dataCliente.get(0));
        newEntity.setMascota(dataMascota.get(0));
        newEntity.setEmpleado(dataEmpleado.get(0));
        PaseoEntity result = paseoLogic.createClientePaseo(dataCliente.get(0).getId(), newEntity);
        Assert.assertNotNull(result);
        PaseoEntity entity = em.find(PaseoEntity.class, result.getId());
        Assert.assertEquals(newEntity.getId(), entity.getId());
        Assert.assertEquals(newEntity.getCliente(), entity.getCliente());
        Assert.assertEquals(newEntity.getMascota(), entity.getMascota());
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

        Assert.assertNull(paseoLogic.getPaseo(Long.MIN_VALUE));
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
        pojoEntity.setCliente(dataCliente.get(0));
        pojoEntity.setMascota(dataMascota.get(0));
        pojoEntity.setEmpleado(dataEmpleado.get(0));
        paseoLogic.updatePaseo(pojoEntity.getId(), pojoEntity);

        PaseoEntity resp = em.find(PaseoEntity.class, entity.getId());

        Assert.assertEquals(pojoEntity.getId(), resp.getId());
        Assert.assertEquals(pojoEntity.getCapMax(), resp.getCapMax());
        Assert.assertEquals(pojoEntity.getCliente(), resp.getCliente());
        Assert.assertEquals(pojoEntity.getMascota(), resp.getMascota());
        Assert.assertEquals(pojoEntity.getEmpleado(), resp.getEmpleado());
    }

    @Test
    public void addCalificacionTest() {
        try {
            PaseoEntity paseo = data.get(0);
            CalificacionEntity pojoEntity = factory.manufacturePojo(CalificacionEntity.class);

            paseoLogic.addCalificacion(paseo.getId(), pojoEntity);

            PaseoEntity resultado = em.find(PaseoEntity.class, paseo.getId());

            Assert.assertEquals(resultado.getCalificacion().getPuntaje(), pojoEntity.getPuntaje());

        } catch (BusinessLogicException ex) {
            fail();
        }

    }

    @Test
    public void getCalificacionTest() {
        PaseoEntity paseo = data.get(1);
        CalificacionEntity calificacion = dataCalificacion.get(1);
        paseo.setCalificacion(calificacion);
        CalificacionEntity resultado = paseoLogic.getCalificacion(paseo.getId());

        Assert.assertEquals(resultado.getPuntaje(), calificacion.getPuntaje());
    }
}
