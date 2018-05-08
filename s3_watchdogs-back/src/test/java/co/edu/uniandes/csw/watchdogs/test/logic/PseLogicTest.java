///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package co.edu.uniandes.csw.watchdogs.test.logic;
//
//import co.edu.uniandes.csw.watchdogs.ejb.PseLogic;
//import co.edu.uniandes.csw.watchdogs.entities.ClienteEntity;
//import co.edu.uniandes.csw.watchdogs.entities.PseEntity;
//import co.edu.uniandes.csw.watchdogs.exceptions.BusinessLogicException;
//import co.edu.uniandes.csw.watchdogs.persistence.PsePersistence;
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
// * @author mac
// */
//@RunWith(Arquillian.class)
//public class PseLogicTest {
//
//    private PodamFactory factory = new PodamFactoryImpl();
//
//    @Inject
//    private PseLogic pseLogic;
//
//    @PersistenceContext
//    private EntityManager em;
//
//    @Inject
//    private UserTransaction utx;
//
//    private List<PseEntity> data = new ArrayList<PseEntity>();
//
//    private List<ClienteEntity> dataCliente = new ArrayList<ClienteEntity>();
//
//    @Deployment
//    public static JavaArchive createDeployment() {
//        return ShrinkWrap.create(JavaArchive.class)
//                .addPackage(PseEntity.class.getPackage())
//                .addPackage(PseLogic.class.getPackage())
//                .addPackage(PsePersistence.class.getPackage())
//                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
//                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
//    }
//
//    /**
//     * Configuración inicial de la prueba.
//     *
//     *
//     */
//    @Before
//    public void configTest() {
//        try {
//            utx.begin();
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
//     *
//     *
//     */
//    private void clearData() {
//        em.createQuery("delete from PseEntity").executeUpdate();
//        em.createQuery("delete from ClienteEntity").executeUpdate();
//
//    }
//
//    /**
//     * Inserta los datos iniciales para el correcto funcionamiento de las
//     * pruebas.
//     *
//     *
//     */
//    private void insertData() {
//        for (int i = 0; i < 3; i++) {
//            PseEntity pse = factory.manufacturePojo(PseEntity.class);
//            em.persist(pse);
//            data.add(pse);
//        }
//        for (int i = 0; i < 3; i++) {
//            ClienteEntity entity = factory.manufacturePojo(ClienteEntity.class);
//            em.persist(entity);
//            dataCliente.add(entity);
//        }
//    }
//
//    /**
//     * Prueba para crear una PSE
//     *
//     *
//     */
//    @Test
//    public void CreatePseTest() throws BusinessLogicException {
//        PseEntity newEntity = factory.manufacturePojo(PseEntity.class);
//        PseEntity result = pseLogic.createPse(data.get(0).getCliente().getId(), newEntity);
//        Assert.assertNotNull(result);
//        PseEntity entity = em.find(PseEntity.class, result.getId());
//        Assert.assertEquals(newEntity.getId(), entity.getId());
//        Assert.assertEquals(newEntity.getName(), entity.getName());
//        Assert.assertEquals(newEntity.getCorreo(), entity.getCorreo());
//    }
//
//    /**
//     * Prueba para consultar la lista de PSE
//     *
//     *
//     */
//    @Test
//    public void getPsesTest() throws BusinessLogicException {
//        List<PseEntity> list = pseLogic.getPses(dataCliente.get(1).getId());
//        Assert.assertEquals(data.size(), list.size());
//        for (PseEntity entity : list) {
//            boolean found = false;
//            for (PseEntity storedEntity : data) {
//                if (entity.getId().equals(storedEntity.getId())) {
//                    found = true;
//                }
//            }
//            Assert.assertTrue(found);
//        }
//    }
//
//    /**
//     * Prueba para consultar un PSE
//     *
//     *
//     */
//    @Test
//    public void getPseTest() {
//        PseEntity entity = data.get(0);
//        PseEntity resultEntity = pseLogic.getPse(dataCliente.get(1).getId(), entity.getId());
//        Assert.assertNotNull(resultEntity);
//        Assert.assertEquals(entity.getId(), resultEntity.getId());
//        Assert.assertEquals(entity.getName(), resultEntity.getName());
//        Assert.assertEquals(entity.getCorreo(), resultEntity.getCorreo());
//    }
//
//    /**
//     * Prueba para eliminar un pse
//     *
//     *
//     */
//    @Test
//    public void deletePseTest() {
//        PseEntity entity = data.get(0);
//        pseLogic.deletePse(dataCliente.get(1).getId(), entity.getId());
//        PseEntity deleted = em.find(PseEntity.class, entity.getId());
//        Assert.assertNull(deleted);
//    }
//
//    /**
//     * Prueba para actualizar un PSE
//     *
//     *
//     */
//    @Test
//    public void updatePseTest() throws BusinessLogicException {
//        PseEntity entity = data.get(0);
//        PseEntity pojoEntity = factory.manufacturePojo(PseEntity.class);
//
//        pojoEntity.setId(entity.getId());
//
//        pseLogic.updateEntity(pojoEntity.getId(), pojoEntity);
//
//        PseEntity resp = em.find(PseEntity.class, entity.getId());
//
//        Assert.assertEquals(pojoEntity.getId(), resp.getId());
//        Assert.assertEquals(pojoEntity.getName(), resp.getName());
//        Assert.assertEquals(pojoEntity.getCorreo(), resp.getCorreo());
//    }
//
//}
