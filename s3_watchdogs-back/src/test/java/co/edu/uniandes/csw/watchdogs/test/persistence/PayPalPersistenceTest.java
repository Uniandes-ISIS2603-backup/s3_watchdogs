///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package co.edu.uniandes.csw.watchdogs.test.persistence;
//
//import co.edu.uniandes.csw.watchdogs.entities.CalificacionEntity;
//import co.edu.uniandes.csw.watchdogs.entities.ClienteEntity;
//import co.edu.uniandes.csw.watchdogs.entities.PayPalEntity;
//import co.edu.uniandes.csw.watchdogs.entities.TarjetaCreditoEntity;
//import co.edu.uniandes.csw.watchdogs.persistence.CalificacionPersistence;
//import co.edu.uniandes.csw.watchdogs.persistence.PayPalPersistence;
//import java.util.ArrayList;
//import java.util.List;
//import javax.inject.Inject;
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//import javax.transaction.UserTransaction;
//import org.jboss.arquillian.container.test.api.Deployment;
//import org.jboss.arquillian.junit.Arquillian;
//import org.jboss.shrinkwrap.api.ShrinkWrap;
//import org.jboss.shrinkwrap.api.spec.JavaArchive;
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import uk.co.jemos.podam.api.PodamFactory;
//import uk.co.jemos.podam.api.PodamFactoryImpl;
//
///**
// *
// * @author jc.pulido
// */
//@RunWith(Arquillian.class)
//public class PayPalPersistenceTest {
//
//    @Deployment
//    public static JavaArchive createDeployment() {
//        return ShrinkWrap.create(JavaArchive.class)
//                .addPackage(CalificacionEntity.class.getPackage())
//                .addPackage(CalificacionPersistence.class.getPackage())
//                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
//                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
//    }
//
//    @Inject
//    private PayPalPersistence payPalPersistence;
//
//    @PersistenceContext
//    private EntityManager em;
//
//    @Inject
//    UserTransaction utx;
//
//    @Before
//    public void configTest() {
//        try {
//            utx.begin();
//            em.joinTransaction();
//            clearData();
//            insertData();
//            utx.commit();
//        } catch (Exception e) {
//            e.printStackTrace();
//            try {
//                utx.rollback();
//            } catch (Exception e1) {
//                e1.printStackTrace();
//            }
//        }
//    }
//
//    /**
//     * Limpia las tablas que están implicadas en la prueba.
//     */
//    private void clearData() {
//        em.createQuery("delete from PayPalEntity").executeUpdate();
//        em.createQuery("delete from ClienteEntity").executeUpdate();
//    }
//
//    private List<PayPalEntity> data = new ArrayList<PayPalEntity>();
//    private List<ClienteEntity> clienteData = new ArrayList<ClienteEntity>();
//
//    /**
//     * Inserta los datos iniciales para el correcto funcionamiento de las
//     * pruebas.
//     */
//    private void insertData() {
//        PodamFactory factory = new PodamFactoryImpl();
//        for (int i = 0; i < 3; i++) {
//            ClienteEntity entity = factory.manufacturePojo(ClienteEntity.class);
//            em.persist(entity);
//            clienteData.add(entity);
//        }
//        for (int i = 0; i < 3; i++) {
//            PayPalEntity entity = factory.manufacturePojo(PayPalEntity.class);
//            if (i == 0) {
//                entity.setCliente(clienteData.get(0));
//            }
//            em.persist(entity);
//            data.add(entity);
//        }
//    }
//
//    @Test
//    public void createPayPalTest() {
//        PodamFactory factory = new PodamFactoryImpl();
//        PayPalEntity newEntity = factory.manufacturePojo(PayPalEntity.class);
//        PayPalEntity result = payPalPersistence.create(newEntity);
//
//        Assert.assertNotNull(result);
//
//        PayPalEntity entity = em.find(PayPalEntity.class, result.getId());
//
//        Assert.assertEquals(newEntity.getCorreo(), entity.getCorreo());
//        Assert.assertEquals(newEntity.getName(), entity.getName());
//        Assert.assertEquals(newEntity.getId(), entity.getId());
//
//    }
//
//    @Test
//    public void getPayPalsTest() {
//        List<PayPalEntity> list = payPalPersistence.findAll();
//        Assert.assertEquals(data.size(), list.size());
//        for (PayPalEntity ent : list) {
//            boolean found = false;
//            for (PayPalEntity entity : data) {
//                if (ent.getId().equals(entity.getId())) {
//                    found = true;
//                }
//            }
//            Assert.assertTrue(found);
//        }
//    }
//
//    @Test
//    public void getPayPalTest() {
//        PayPalEntity entity = data.get(0);
//        PayPalEntity newEntity = payPalPersistence.find(clienteData.get(0).getId(),entity.getId());
//        Assert.assertNotNull(newEntity);
//        Assert.assertEquals(entity.getCorreo(), newEntity.getCorreo());
//        Assert.assertEquals(entity.getName(), newEntity.getName());
//        Assert.assertEquals(entity.getId(), newEntity.getId());
//        
//    }
//
//    @Test
//    public void deletePayPalTest() {
//        PayPalEntity entity = data.get(0);
//        payPalPersistence.delete(entity.getId());
//        PayPalEntity deleted = em.find(PayPalEntity.class, entity.getId());
//        Assert.assertNull(deleted);
//    }
//
//    @Test
//    public void updatePayPalTest() {
//        PayPalEntity entity = data.get(0);
//        PodamFactory factory = new PodamFactoryImpl();
//        PayPalEntity newEntity = factory.manufacturePojo(PayPalEntity.class);
//
//        newEntity.setId(entity.getId());
//
//        payPalPersistence.update(newEntity);
//
//        PayPalEntity resp = em.find(PayPalEntity.class, entity.getId());
//
//        Assert.assertEquals(newEntity.getCorreo(), resp.getCorreo());
//    }
//}
