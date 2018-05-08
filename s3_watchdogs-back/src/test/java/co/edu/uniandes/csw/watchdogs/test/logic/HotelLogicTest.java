/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.watchdogs.test.logic;

import co.edu.uniandes.csw.watchdogs.ejb.HotelLogic;
import co.edu.uniandes.csw.watchdogs.entities.ClienteEntity;
import co.edu.uniandes.csw.watchdogs.entities.EmpleadoEntity;
import co.edu.uniandes.csw.watchdogs.entities.HotelEntity;
import co.edu.uniandes.csw.watchdogs.entities.MascotaEntity;
import co.edu.uniandes.csw.watchdogs.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.watchdogs.persistence.HotelPersistence;
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
public class HotelLogicTest {
    
    private PodamFactory factory = new PodamFactoryImpl();

    @Inject
    private HotelLogic hotelLogic;

    @PersistenceContext
    private EntityManager em;

    @Inject
    private UserTransaction utx;

    private List<HotelEntity> data = new ArrayList<>();
    
    private List<MascotaEntity> dataMascota = new ArrayList<MascotaEntity>();
    
    private List<EmpleadoEntity> dataEmpleado = new ArrayList<EmpleadoEntity>();
    
    private List<ClienteEntity> dataCliente = new ArrayList<ClienteEntity>();

    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(HotelEntity.class.getPackage())
                .addPackage(HotelLogic.class.getPackage())
                .addPackage(HotelPersistence.class.getPackage())
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
        em.createQuery("delete from HotelEntity").executeUpdate();
        em.createQuery("delete from ClienteEntity").executeUpdate();
        em.createQuery("delete from MascotaEntity").executeUpdate();
        em.createQuery("delete from EmpleadoEntity").executeUpdate();
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
            HotelEntity entity = factory.manufacturePojo(HotelEntity.class);
            entity.setCliente(dataCliente.get(1));
            entity.setMascota(dataMascota.get(1));
            entity.setEmpleado(dataEmpleado.get(1));
            em.persist(entity);
            data.add(entity);
        }
    }
    
    /**
     * Prueba para crear un Hotel
     * @throws co.edu.uniandes.csw.watchdogs.exceptions.BusinessLogicException
     */
    @Test
    public void createHotelTest() throws BusinessLogicException {
        HotelEntity newEntity = factory.manufacturePojo(HotelEntity.class);
        newEntity.setCliente(dataCliente.get(0));
        newEntity.setMascota(dataMascota.get(0));
        newEntity.setEmpleado(dataEmpleado.get(0));
        HotelEntity result = hotelLogic.createHotel(newEntity);
        Assert.assertNotNull(result);
        HotelEntity entity = em.find(HotelEntity.class, result.getId());
        Assert.assertEquals(newEntity.getId(), entity.getId());
        Assert.assertEquals(newEntity.getTiempoHospedaje(), entity.getTiempoHospedaje());
    }

    /**
     * Prueba para consultar la lista de hoteles
     */
    @Test
    public void getHotelesTest() {
        List<HotelEntity> list = hotelLogic.getHoteles();
        Assert.assertEquals(data.size(), list.size());
        for (HotelEntity entity : list) {
            boolean found = false;
            for (HotelEntity storedEntity : data) {
                if (entity.getId().equals(storedEntity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }

    /**
     * Prueba para consultar un Hotel
     */
    @Test
    public void getHotelTest() {
        HotelEntity entity = data.get(0);
        HotelEntity resultEntity = hotelLogic.getHotel(entity.getId());
        Assert.assertNotNull(resultEntity);
        Assert.assertEquals(entity.getId(), resultEntity.getId());
        Assert.assertEquals(entity.getTiempoHospedaje(), resultEntity.getTiempoHospedaje());
    }

    /**
     * Prueba para eliminar un Hotel
     */
    @Test
    public void deleteHotelTest() {
        HotelEntity entity = data.get(0);
        hotelLogic.deleteHotel(entity.getId());
        HotelEntity deleted = em.find(HotelEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }

    /**
     * Prueba para actualizar un Hotel
     */
    @Test
    public void updateHotelTest() throws BusinessLogicException {
        HotelEntity entity = data.get(0);
        HotelEntity pojoEntity = factory.manufacturePojo(HotelEntity.class);
        
        pojoEntity.setId(entity.getId());
        pojoEntity.setCliente(dataCliente.get(0));
        pojoEntity.setMascota(dataMascota.get(0));
        pojoEntity.setEmpleado(dataEmpleado.get(0));

        hotelLogic.updateHotel(pojoEntity.getId(), pojoEntity);

        HotelEntity resp = em.find(HotelEntity.class, entity.getId());

        Assert.assertEquals(pojoEntity.getId(), resp.getId());
        Assert.assertEquals(pojoEntity.getTiempoHospedaje(), resp.getTiempoHospedaje());
    }
}
