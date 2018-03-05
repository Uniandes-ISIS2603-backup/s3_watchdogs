/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.watchdogs.test.logic;

import co.edu.uniandes.csw.watchdogs.ejb.AseoLogic;
import co.edu.uniandes.csw.watchdogs.ejb.EntrenamientoLogic;
import co.edu.uniandes.csw.watchdogs.entities.AseoEntity;
import co.edu.uniandes.csw.watchdogs.entities.ClienteEntity;
import co.edu.uniandes.csw.watchdogs.entities.EmpleadoEntity;
import co.edu.uniandes.csw.watchdogs.entities.EntrenamientoEntity;
import co.edu.uniandes.csw.watchdogs.entities.MascotaEntity;
import co.edu.uniandes.csw.watchdogs.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.watchdogs.persistence.AseoPersistence;
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
 * @author js.vacat
 */
@RunWith(Arquillian.class)
public class AseoLogicTest {
    
    private PodamFactory factory = new PodamFactoryImpl();

    @Inject
    private AseoLogic aseoLogic;

    @PersistenceContext
    private EntityManager em;

    @Inject
    private UserTransaction utx;

    private List<AseoEntity> data = new ArrayList<AseoEntity>();
    
    private List<MascotaEntity> dataMascota = new ArrayList<MascotaEntity>();
    
    private List<EmpleadoEntity> dataEmpleado = new ArrayList<EmpleadoEntity>();
    
    private List<ClienteEntity> dataCliente = new ArrayList<ClienteEntity>();


    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(AseoEntity.class.getPackage())
                .addPackage(AseoLogic.class.getPackage())
                .addPackage(AseoPersistence.class.getPackage())
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
        em.createQuery("delete from AseoEntity").executeUpdate();
        em.createQuery("delete from ClienteEntity").executeUpdate();
        em.createQuery("delete from MascotaEntity").executeUpdate();
        em.createQuery("delete from EmpleadoEntity").executeUpdate();
    }
    
    private void insertData() {  
        for (int i = 0; i < 3; i++) {
            AseoEntity entity = factory.manufacturePojo(AseoEntity.class);
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
     * Prueba para crear un Aseo
     *
     *
     * @throws co.edu.uniandes.csw.watchdogs.exceptions.BusinessLogicException
     */
    @Test
    public void createAseoTest() throws BusinessLogicException {
        AseoEntity newEntity = factory.manufacturePojo(AseoEntity.class);
        AseoEntity result = aseoLogic.createAseo(newEntity,dataCliente.get(0).getId(),dataMascota.get(0).getId(),dataEmpleado.get(0).getId());
        Assert.assertNotNull(result);
        AseoEntity entity = em.find(AseoEntity.class, result.getId());
        Assert.assertEquals(newEntity.getId(), entity.getId());
        Assert.assertEquals(newEntity.getFecha(), entity.getFecha());
        Assert.assertEquals(newEntity.getCosto(),entity.getCosto(),0);
        Assert.assertEquals(newEntity.isEstado(), entity.isEstado());
        Assert.assertEquals(newEntity.getRango(), entity.getRango());
        Assert.assertEquals(newEntity.getDuracion(), entity.getDuracion(),0);
        Assert.assertEquals(newEntity.getHora(), entity.getHora());
        Assert.assertEquals(newEntity.getBanho(), entity.getBanho());
        Assert.assertEquals(newEntity.getDientes(), entity.getDientes());
        Assert.assertEquals(newEntity.getPeluqueria(), entity.getPeluqueria());
    }

    /**
     * Prueba para consultar la lista de Calificaciones
     *
     *
     */
    @Test
    public void getAseosTest() {
        List<AseoEntity> list = aseoLogic.getAseos();
        Assert.assertEquals(data.size(), list.size());
        for (AseoEntity entity : list) {
            boolean found = false;
            for (AseoEntity storedEntity : data) {
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
    public void getAseoTest() {
        AseoEntity entity = data.get(0);
        AseoEntity resultEntity = aseoLogic.getAseo(entity.getId());
        Assert.assertNotNull(resultEntity);
        Assert.assertEquals(entity.getId(), resultEntity.getId());
        Assert.assertEquals(entity.getFecha(), resultEntity.getFecha());
        Assert.assertEquals(entity.getCosto(), resultEntity.getCosto(),0);
        Assert.assertEquals(entity.isEstado(), resultEntity.isEstado());
        Assert.assertEquals(entity.getRango(), resultEntity.getRango());
        Assert.assertEquals(entity.getDuracion(), resultEntity.getDuracion(),0);
        Assert.assertEquals(entity.getHora(), resultEntity.getHora());
        Assert.assertEquals(entity.getBanho(), resultEntity.getBanho());
        Assert.assertEquals(entity.getDientes(), resultEntity.getDientes());
        Assert.assertEquals(entity.getPeluqueria(), resultEntity.getPeluqueria());

    }

    /**
     * Prueba para eliminar un Book
     *
     *
     */
    @Test
    public void deleteAseoTest() {
        AseoEntity entity = data.get(0);
        aseoLogic.deleteAseo(entity.getId());
        AseoEntity deleted = em.find(AseoEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }

    /**
     * Prueba para actualizar un Book
     *
     *
     * @throws co.edu.uniandes.csw.watchdogs.exceptions.BusinessLogicException
     */
    @Test
    public void updateAseoTest() throws BusinessLogicException {
        AseoEntity entity = data.get(0);
        AseoEntity pojoEntity = factory.manufacturePojo(AseoEntity.class);

        pojoEntity.setId(entity.getId());

        aseoLogic.updateAseo(pojoEntity.getId(), pojoEntity,dataCliente.get(0).getId(),dataMascota.get(0).getId(),dataEmpleado.get(0).getId());

        AseoEntity resp = em.find(AseoEntity.class, entity.getId());

        Assert.assertEquals(pojoEntity.getId(), resp.getId());
        Assert.assertEquals(pojoEntity.getFecha(), resp.getFecha());
         Assert.assertEquals(pojoEntity.getCosto(), resp.getCosto(),0);
        Assert.assertEquals(pojoEntity.isEstado(), resp.isEstado());
        Assert.assertEquals(pojoEntity.getRango(), resp.getRango());
        Assert.assertEquals(pojoEntity.getDuracion(), resp.getDuracion(),0);
        Assert.assertEquals(pojoEntity.getHora(), resp.getHora());
        Assert.assertEquals(pojoEntity.getBanho(), resp.getBanho());
        Assert.assertEquals(pojoEntity.getDientes(), resp.getDientes());
        Assert.assertEquals(pojoEntity.getPeluqueria(), resp.getPeluqueria());
    }
}
