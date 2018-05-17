/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.watchdogs.test.persistence;

import co.edu.uniandes.csw.watchdogs.entities.CalificacionEntity;
import co.edu.uniandes.csw.watchdogs.entities.ClienteEntity;
import co.edu.uniandes.csw.watchdogs.entities.TarjetaCreditoEntity;
import co.edu.uniandes.csw.watchdogs.persistence.CalificacionPersistence;
import co.edu.uniandes.csw.watchdogs.persistence.TarjetaCreditoPersistence;
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
 * @author jc.pulido
 */
@RunWith(Arquillian.class)
public class TarjetaCreditoPersistenceTest {

    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(CalificacionEntity.class.getPackage())
                .addPackage(CalificacionPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }

    @Inject
    private TarjetaCreditoPersistence tarjetaCreditoPersistence;

    @PersistenceContext
    private EntityManager em;

    @Inject
    UserTransaction utx;

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
        em.createQuery("delete from TarjetaCreditoEntity").executeUpdate();
        em.createQuery("delete from ClienteEntity").executeUpdate();
    }

    private List<TarjetaCreditoEntity> data = new ArrayList<TarjetaCreditoEntity>();
    private List<ClienteEntity> clienteData = new ArrayList<ClienteEntity>();

    /**
     * Inserta los datos iniciales para el correcto funcionamiento de las
     * pruebas.
     */
    private void insertData() {
        PodamFactory factory = new PodamFactoryImpl();
        for (int i = 0; i < 3; i++) {
            ClienteEntity entity = factory.manufacturePojo(ClienteEntity.class);
            em.persist(entity);
            clienteData.add(entity);
        }
        for (int i = 0; i < 3; i++) {
            TarjetaCreditoEntity entity = factory.manufacturePojo(TarjetaCreditoEntity.class);
            if (i == 0) {
                entity.setCliente(clienteData.get(0));
            }
            em.persist(entity);
            data.add(entity);
        }
    }

    @Test
    public void createTarjetaCreditoTest() {
        PodamFactory factory = new PodamFactoryImpl();
        TarjetaCreditoEntity newEntity = factory.manufacturePojo(TarjetaCreditoEntity.class);
        TarjetaCreditoEntity result = tarjetaCreditoPersistence.create(newEntity);

        Assert.assertNotNull(result);

        TarjetaCreditoEntity entity = em.find(TarjetaCreditoEntity.class, result.getId());

        Assert.assertEquals(newEntity.getNumeroTarjeta(), entity.getNumeroTarjeta());
    }

    @Test
    public void getTarjetasTest() {
        List<TarjetaCreditoEntity> list = tarjetaCreditoPersistence.findAll();
        Assert.assertEquals(data.size(), list.size());
        for (TarjetaCreditoEntity ent : list) {
            boolean found = false;
            for (TarjetaCreditoEntity entity : data) {
                if (ent.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }

    @Test
    public void getTarjetaTest() {
        TarjetaCreditoEntity entity = data.get(0);
        TarjetaCreditoEntity newEntity = tarjetaCreditoPersistence.find(clienteData.get(0).getId(),entity.getId());
        Assert.assertNotNull(newEntity);
        Assert.assertEquals(entity.getNumeroTarjeta(), newEntity.getNumeroTarjeta());
        Assert.assertEquals(entity.getFactura(), newEntity.getFactura());
    }

    @Test
    public void deleteTarjetaTest() {
        TarjetaCreditoEntity entity = data.get(0);
        tarjetaCreditoPersistence.delete(entity.getId());
        TarjetaCreditoEntity deleted = em.find(TarjetaCreditoEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }

    @Test
    public void updateTarjetaTest() {
        TarjetaCreditoEntity entity = data.get(0);
        PodamFactory factory = new PodamFactoryImpl();
        TarjetaCreditoEntity newEntity = factory.manufacturePojo(TarjetaCreditoEntity.class);

        newEntity.setId(entity.getId());

        tarjetaCreditoPersistence.update(newEntity);

        TarjetaCreditoEntity resp = em.find(TarjetaCreditoEntity.class, entity.getId());

        Assert.assertEquals(newEntity.getNumeroTarjeta(), resp.getNumeroTarjeta());
    }
}
