/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.watchdogs.test.logic;

import co.edu.uniandes.csw.watchdogs.ejb.TarjetaCreditoLogic;
import co.edu.uniandes.csw.watchdogs.entities.ClienteEntity;
import co.edu.uniandes.csw.watchdogs.entities.TarjetaCreditoEntity;
import co.edu.uniandes.csw.watchdogs.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.watchdogs.persistence.TarjetaCreditoPersistence;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.inject.Model;
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
 * @author jc.pulido
 */
@RunWith(Arquillian.class)
public class TarjetaCreditoLogicTest {

    private PodamFactory factory = new PodamFactoryImpl();

    @Inject
    private TarjetaCreditoLogic tarjetaLogic;

    @PersistenceContext
    private EntityManager em;

    @Inject
    private UserTransaction utx;

    private List<TarjetaCreditoEntity> data = new ArrayList<TarjetaCreditoEntity>();

    private List<ClienteEntity> dataCliente = new ArrayList<ClienteEntity>();

    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(TarjetaCreditoEntity.class.getPackage())
                .addPackage(TarjetaCreditoLogic.class.getPackage())
                .addPackage(TarjetaCreditoPersistence.class.getPackage())
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
     *
     *
     */
    private void clearData() {
        em.createQuery("delete from TarjetaCreditoEntity").executeUpdate();
        em.createQuery("delete from ClienteEntity").executeUpdate();
    }

    /**
     * Inserta los datos iniciales para el correcto funcionamiento de las
     * pruebas.
     *
     *
     */
    private void insertData() {
        for (int i = 0; i < 3; i++) {
            TarjetaCreditoEntity tarjeta = factory.manufacturePojo(TarjetaCreditoEntity.class);
            em.persist(tarjeta);
            data.add(tarjeta);
        }
        for (int i = 0; i < 3; i++) {
            ClienteEntity entity = factory.manufacturePojo(ClienteEntity.class);
            em.persist(entity);
            dataCliente.add(entity);
        }
    }

    /**
     * Prueba para crear una tarjeta
     *
     *
     */
    @Test
    public void createTarjetaTest() throws BusinessLogicException {
        TarjetaCreditoEntity newEntity = factory.manufacturePojo(TarjetaCreditoEntity.class);
        TarjetaCreditoEntity result = tarjetaLogic.createTarjeta(data.get(0).getCliente().getId(), newEntity);
        Assert.assertNotNull(result);
        TarjetaCreditoEntity entity = em.find(TarjetaCreditoEntity.class, result.getId());
        Assert.assertEquals(newEntity.getId(), entity.getId());
        Assert.assertEquals(newEntity.getName(), entity.getName());
        Assert.assertEquals(newEntity.getCodigoSeguridad(), entity.getCodigoSeguridad());
        Assert.assertEquals(newEntity.getFechaVencimiento(), entity.getFechaVencimiento());
        Assert.assertEquals(newEntity.getNumeroTarjeta(), entity.getNumeroTarjeta());
    }

    /**
     * Prueba para consultar la lista de tarjetas
     *
     *
     */
    @Test
    public void getTarjetasTest() throws BusinessLogicException {
        List<TarjetaCreditoEntity> list = tarjetaLogic.getTarjetas(dataCliente.get(1).getId());
        Assert.assertEquals(data.size(), list.size());
        for (TarjetaCreditoEntity entity : list) {
            boolean found = false;
            for (TarjetaCreditoEntity storedEntity : data) {
                if (entity.getId().equals(storedEntity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }

    /**
     * Prueba para consultar una tarjeta
     *
     *
     */
    @Test
    public void getTarjetaTest() {
        TarjetaCreditoEntity entity = data.get(0);
        TarjetaCreditoEntity resultEntity = tarjetaLogic.getTarjeta(dataCliente.get(1).getId(), entity.getId());
        Assert.assertNotNull(resultEntity);
        Assert.assertEquals(entity.getId(), resultEntity.getId());
        Assert.assertEquals(entity.getName(), resultEntity.getName());
        Assert.assertEquals(entity.getCodigoSeguridad(), resultEntity.getCodigoSeguridad());
        Assert.assertEquals(entity.getFechaVencimiento(), resultEntity.getFechaVencimiento());
        Assert.assertEquals(entity.getNumeroTarjeta(), resultEntity.getNumeroTarjeta());
    }

    /**
     * Prueba para eliminar una tarjeta
     *
     *
     */
    @Test
    public void deleteTarjetaTest() {
        TarjetaCreditoEntity entity = data.get(0);
        tarjetaLogic.deleteTarjeta(dataCliente.get(1).getId(), entity.getId());
        TarjetaCreditoEntity deleted = em.find(TarjetaCreditoEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }

    /**
     * Prueba para actualizar una tarjeta
     *
     *
     */
    @Test
    public void updateTarjetaTest() throws BusinessLogicException {
        TarjetaCreditoEntity entity = data.get(0);
        TarjetaCreditoEntity pojoEntity = factory.manufacturePojo(TarjetaCreditoEntity.class);

        pojoEntity.setId(entity.getId());

        tarjetaLogic.updateTarjeta(pojoEntity.getId(), pojoEntity);

        TarjetaCreditoEntity resp = em.find(TarjetaCreditoEntity.class, entity.getId());

        Assert.assertEquals(pojoEntity.getId(), resp.getId());
        Assert.assertEquals(pojoEntity.getName(), resp.getName());
        Assert.assertEquals(pojoEntity.getCodigoSeguridad(), resp.getCodigoSeguridad());
        Assert.assertEquals(pojoEntity.getFechaVencimiento(), resp.getFechaVencimiento());
        Assert.assertEquals(pojoEntity.getNumeroTarjeta(), resp.getNumeroTarjeta());
    }

}
