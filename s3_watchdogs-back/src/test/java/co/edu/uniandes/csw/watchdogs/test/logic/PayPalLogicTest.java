/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.watchdogs.test.logic;

import co.edu.uniandes.csw.watchdogs.ejb.PayPalLogic;
import co.edu.uniandes.csw.watchdogs.entities.PayPalEntity;
import co.edu.uniandes.csw.watchdogs.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.watchdogs.persistence.PayPalPersistence;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
import org.apache.derby.iapi.types.UserType;
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
 * @author mac
 */
@RunWith(Arquillian.class)
public class PayPalLogicTest {
    
    private PodamFactory factory = new PodamFactoryImpl();
    
    @Inject
    private PayPalLogic payPalLogic;
    
    @PersistenceContext
    private EntityManager em;
    
    @Inject
    private UserTransaction utx;
    
    private List<PayPalEntity> data = new ArrayList<PayPalEntity>();
    
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(PayPalEntity.class.getPackage())
                .addPackage(PayPalLogic.class.getPackage())
                .addPackage(PayPalPersistence.class.getPackage())
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
        em.createQuery("delete from PayPalEntity").executeUpdate();
    }

    /**
     * Inserta los datos iniciales para el correcto funcionamiento de las
     * pruebas.
     *
     *
     */
    private void insertData() {
        for (int i = 0; i < 3; i++) {
            PayPalEntity tarjeta = factory.manufacturePojo(PayPalEntity.class);
            em.persist(tarjeta);
            data.add(tarjeta);
        }
    }
    
    /**
     * Prueba para crear una tarjeta
     *
     *
     */
    @Test
    public void createPayPalTest() throws BusinessLogicException {
        PayPalEntity newEntity = factory.manufacturePojo(PayPalEntity.class);
        PayPalEntity result = payPalLogic.createPse(newEntity);
        Assert.assertNotNull(result);
        PayPalEntity entity = em.find(PayPalEntity.class, result.getId());
        Assert.assertEquals(newEntity.getId(), entity.getId());
        Assert.assertEquals(newEntity.getNombre(), entity.getNombre());
        Assert.assertEquals(newEntity.getCorreo(), entity.getCorreo());
        
        }
    
    
    /**
     * Prueba para consultar la lista de tarjetas
     *
     *
     */
    @Test
    public void getPayPalsTest() {
        List<PayPalEntity> list = payPalLogic.getPayPals();
        Assert.assertEquals(data.size(), list.size());
        for (PayPalEntity entity : list) {
            boolean found = false;
            for (PayPalEntity storedEntity : data) {
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
    public void getPayPalTest() {
        PayPalEntity entity = data.get(0);
        PayPalEntity resultEntity = payPalLogic.getPayPal(entity.getId());
        Assert.assertNotNull(resultEntity);
        Assert.assertEquals(entity.getId(), resultEntity.getId());
        Assert.assertEquals(entity.getNombre(), resultEntity.getNombre());
        Assert.assertEquals(entity.getCorreo(), resultEntity.getCorreo());
        
    }
    
    /**
     * Prueba para eliminar una tarjeta
     *
     *
     */
    @Test
    public void deletePayPalTest() {
        PayPalEntity entity = data.get(0);
        payPalLogic.deletePayPal(entity.getId());
        PayPalEntity deleted = em.find(PayPalEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }
    
    /**
     * Prueba para actualizar una tarjeta
     *
     *
     */
    @Test
    public void updatePayPalTest() throws BusinessLogicException {
        PayPalEntity entity = data.get(0);
        PayPalEntity pojoEntity = factory.manufacturePojo(PayPalEntity.class);

        pojoEntity.setId(entity.getId());

        payPalLogic.updateEntity(pojoEntity.getId(), pojoEntity);

        PayPalEntity resp = em.find(PayPalEntity.class, entity.getId());

        Assert.assertEquals(pojoEntity.getId(), resp.getId());
        Assert.assertEquals(pojoEntity.getNombre(), resp.getNombre());
        Assert.assertEquals(pojoEntity.getCorreo(), resp.getCorreo());
    }
}
