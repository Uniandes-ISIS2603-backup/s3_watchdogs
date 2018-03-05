/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.watchdogs.test.logic;

import co.edu.uniandes.csw.watchdogs.ejb.EntrenamientoLogic;
import co.edu.uniandes.csw.watchdogs.entities.ClienteEntity;
import co.edu.uniandes.csw.watchdogs.entities.EmpleadoEntity;
import co.edu.uniandes.csw.watchdogs.entities.EntrenamientoEntity;
import co.edu.uniandes.csw.watchdogs.entities.MascotaEntity;
import co.edu.uniandes.csw.watchdogs.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.watchdogs.persistence.EntrenamientoPersistence;
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
 * @author c.martinezc1
 */
@RunWith(Arquillian.class)
public class EntrenamientoLogicTest {
    
    private PodamFactory factory = new PodamFactoryImpl();

    @Inject
    private EntrenamientoLogic entrenamientoLogic;

    @PersistenceContext
    private EntityManager em;

    @Inject
    private UserTransaction utx;

    private List<EntrenamientoEntity> data = new ArrayList<>();
    
    private List<MascotaEntity> dataMascota = new ArrayList<MascotaEntity>();
    
    private List<EmpleadoEntity> dataEmpleado = new ArrayList<EmpleadoEntity>();
    
    private List<ClienteEntity> dataCliente = new ArrayList<ClienteEntity>();




    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(EntrenamientoEntity.class.getPackage())
                .addPackage(EntrenamientoLogic.class.getPackage())
                .addPackage(EntrenamientoPersistence.class.getPackage())
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
     *
     *
     */
    private void clearData() {
        em.createQuery("delete from EntrenamientoEntity").executeUpdate();
        em.createQuery("delete from ClienteEntity").executeUpdate();
        em.createQuery("delete from MascotaEntity").executeUpdate();
        em.createQuery("delete from EmpleadoEntity").executeUpdate();
    }

    /**
     * Inserta los datos iniciales para el correcto funcionamiento de las
     * pruebas.
     *
     *
     */
    private void insertData() {  
        for (int i = 0; i < 3; i++) {
            EntrenamientoEntity entity = factory.manufacturePojo(EntrenamientoEntity.class);
            em.persist(entity);
            data.add(entity);
        }
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
    }
    
    /**
     * Prueba para crear un Book
     *
     *
     * @throws co.edu.uniandes.csw.watchdogs.exceptions.BusinessLogicException
     */
    @Test
    public void createEntrenamientoTest() throws BusinessLogicException {
        EntrenamientoEntity newEntity = factory.manufacturePojo(EntrenamientoEntity.class);
        EntrenamientoEntity result = entrenamientoLogic.createEntrenamiento(newEntity,dataCliente.get(0).getId(),dataMascota.get(0).getId(),dataEmpleado.get(0).getId());
        Assert.assertNotNull(result);
        EntrenamientoEntity entity = em.find(EntrenamientoEntity.class, result.getId());
        Assert.assertEquals(newEntity.getId(), entity.getId());
        Assert.assertEquals(newEntity.getFecha(), entity.getFecha());
        Assert.assertEquals(newEntity.getTransporte(), entity.getTransporte());
        Assert.assertEquals(newEntity.getTipo(), entity.getTipo());
    }

    /**
     * Prueba para consultar la lista de Calificaciones
     *
     *
     */
    @Test
    public void getEntrenamientosTest() {
        List<EntrenamientoEntity> list = entrenamientoLogic.getEntrenamientos();
        Assert.assertEquals(data.size(), list.size());
        for (EntrenamientoEntity entity : list) {
            boolean found = false;
            for (EntrenamientoEntity storedEntity : data) {
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
    public void getEntrenamientoTest() {
        EntrenamientoEntity entity = data.get(0);
        EntrenamientoEntity resultEntity = entrenamientoLogic.getEntrenamiento(entity.getId());
        Assert.assertNotNull(resultEntity);
        Assert.assertEquals(entity.getId(), resultEntity.getId());
        Assert.assertEquals(entity.getFecha(), resultEntity.getFecha());
        Assert.assertEquals(entity.getTransporte(), resultEntity.getTransporte());
        Assert.assertEquals(entity.getTipo(), resultEntity.getTipo());

    }

    /**
     * Prueba para eliminar un Book
     *
     *
     */
    @Test
    public void deleteEntrenamientoTest() {
        EntrenamientoEntity entity = data.get(0);
        entrenamientoLogic.deleteEntrenamiento(entity.getId());
        EntrenamientoEntity deleted = em.find(EntrenamientoEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }

    /**
     * Prueba para actualizar un Book
     *
     *
     * @throws co.edu.uniandes.csw.watchdogs.exceptions.BusinessLogicException
     */
    @Test
    public void updateEntrenamientoTest() throws BusinessLogicException {
        EntrenamientoEntity entity = data.get(0);
        EntrenamientoEntity pojoEntity = factory.manufacturePojo(EntrenamientoEntity.class);

        pojoEntity.setId(entity.getId());

        entrenamientoLogic.updateEntrenamiento(pojoEntity.getId(), pojoEntity,dataCliente.get(0).getId(),dataMascota.get(0).getId(),dataEmpleado.get(0).getId());

        EntrenamientoEntity resp = em.find(EntrenamientoEntity.class, entity.getId());

        Assert.assertEquals(pojoEntity.getId(), resp.getId());
        Assert.assertEquals(pojoEntity.getFecha(), resp.getFecha());
        Assert.assertEquals(pojoEntity.getHora(), resp.getHora());
        Assert.assertEquals(pojoEntity.getTransporte(), resp.getTransporte());
    }
}
