/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.watchdogs.test.logic;

import co.edu.uniandes.csw.watchdogs.ejb.ClienteLogic;
import co.edu.uniandes.csw.watchdogs.entities.ClienteEntity;
import co.edu.uniandes.csw.watchdogs.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.watchdogs.persistence.ClientePersistence;
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
public class ClienteLogicTest {

    private PodamFactory factory = new PodamFactoryImpl();

    @Inject
    private ClienteLogic clienteLogic;

    @PersistenceContext
    private EntityManager em;

    @Inject
    private UserTransaction utx;

    private List<ClienteEntity> data = new ArrayList<ClienteEntity>();

    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(ClienteEntity.class.getPackage())
                .addPackage(ClienteLogic.class.getPackage())
                .addPackage(ClientePersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }

    /**
     * Configuracion inicial de la prueba.
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
        em.createQuery("delete from ClienteEntity").executeUpdate();
        em.createQuery("delete from MascotaEntity").executeUpdate();
        em.createQuery("delete from FacturaEntity").executeUpdate();
        em.createQuery("delete from CalificacionEntity").executeUpdate();

    }

    /**
     * Inserta los datos iniciales para el correcto funcionamiento de las
     * pruebas.
     */
    private void insertData() {
        for (int i = 0; i < 3; i++) {
            ClienteEntity entity = factory.manufacturePojo(ClienteEntity.class);
            em.persist(entity);
            data.add(entity);
        }
    }

    /**
     * Prueba para crear un Cliente
     */
    @Test
    public void createClienteTest() {
        try {
            ClienteEntity newEntity = factory.manufacturePojo(ClienteEntity.class);
            ClienteEntity result = clienteLogic.createCliente(newEntity);
            Assert.assertNotNull(result);
            ClienteEntity entity = em.find(ClienteEntity.class, result.getId());
            Assert.assertEquals(newEntity.getId(), entity.getId());
            Assert.assertEquals(newEntity.getName(), entity.getName());
            Assert.assertEquals(newEntity.getCedula(), entity.getCedula());
        } catch (BusinessLogicException e) {
            fail();
        }

    }

    /**
     * Prueba para consultar la lista de Clientes.
     */
    @Test
    public void getClientesTest() {
        List<ClienteEntity> list = clienteLogic.getClientes();
        Assert.assertEquals(data.size(), list.size());
        for (ClienteEntity entity : list) {
            boolean found = false;
            for (ClienteEntity storedEntity : data) {
                if (entity.getId().equals(storedEntity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }

    /**
     * Prueba para consultar un Cliente.
     */
    @Test
    public void getClienteTest() {
        try {
        ClienteEntity entity = data.get(0);
        ClienteEntity resultEntity = clienteLogic.getCliente(entity.getId());
        Assert.assertNotNull(resultEntity);
        Assert.assertEquals(entity.getId(), resultEntity.getId());
        Assert.assertEquals(entity.getName(), resultEntity.getName());
        Assert.assertEquals(entity.getCedula(), resultEntity.getCedula());
        }
        catch(Exception e) {
            fail();
        }
    }

    /**
     * Prueba para eliminar un Cliente.
     */
    @Test
    public void deleteClienteTest() {
        try {
            ClienteEntity entity = data.get(0);
            clienteLogic.deleteCliente(entity.getId());
            ClienteEntity deleted = em.find(ClienteEntity.class, entity.getId());
            Assert.assertNull(deleted);
        } catch (BusinessLogicException e) {
            fail();
        }
    }

    /**
     * Prueba para actualizar un Cliente.
     */
    public void updateClienteTest() {
        ClienteEntity entity = data.get(0);
        ClienteEntity pojoEntity = factory.manufacturePojo(ClienteEntity.class);

        pojoEntity.setId(entity.getId());

        clienteLogic.updateCliente(entity.getId(), pojoEntity);

        ClienteEntity resp = em.find(ClienteEntity.class, entity.getId());

        Assert.assertEquals(pojoEntity.getId(), resp.getId());
        Assert.assertEquals(pojoEntity.getName(), resp.getName());
        Assert.assertEquals(pojoEntity.getCedula(), resp.getCedula());
    }
}
