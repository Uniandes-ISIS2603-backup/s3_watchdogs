/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.watchdogs.test.logic;

import co.edu.uniandes.csw.watchdogs.ejb.DisponibilidadLogic;
import co.edu.uniandes.csw.watchdogs.entities.DisponibilidadEntity;
import co.edu.uniandes.csw.watchdogs.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.watchdogs.persistence.DisponibilidadPersistence;
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
 * @author id.salazar
 */

@RunWith(Arquillian.class)
public class DisponibilidadLogicTest {
    
    private PodamFactory factory = new PodamFactoryImpl();

    @Inject
    private DisponibilidadLogic disponibilidadLogic;

    @PersistenceContext
    private EntityManager em;

    @Inject
    private UserTransaction utx;

    private List<DisponibilidadEntity> data = new ArrayList<DisponibilidadEntity>();

    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(DisponibilidadEntity.class.getPackage())
                .addPackage(DisponibilidadLogic.class.getPackage())
                .addPackage(DisponibilidadPersistence.class.getPackage())
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
        em.createQuery("delete from DisponibilidadEntity").executeUpdate();
    }

    /**
     * Inserta los datos iniciales para el correcto funcionamiento de las
     * pruebas.
     *
     *
     */
    private void insertData() {
        for (int i = 0; i < 3; i++) {
            DisponibilidadEntity entity = factory.manufacturePojo(DisponibilidadEntity.class);
            em.persist(entity);
            data.add(entity);
        }
    }

    /**
     * Prueba para crear una disponibilidad
     *
     *
     */
    @Test
    public void createDisponibilidadTest() throws BusinessLogicException {
        DisponibilidadEntity newEntity = factory.manufacturePojo(DisponibilidadEntity.class);
        DisponibilidadEntity result = disponibilidadLogic.createDisponibilidad(newEntity);
        Assert.assertNotNull(result);
        DisponibilidadEntity entity = em.find(DisponibilidadEntity.class, result.getId());
        Assert.assertEquals(newEntity.getId(), entity.getId());
        Assert.assertEquals(newEntity.getName(), entity.getName());
        Assert.assertEquals(newEntity.getMatrizHorarios(), entity.getMatrizHorarios());
    }

    /**
     * Prueba para consultar la lista de Disponibilidades
     *
     *
     */
    @Test
    public void getDisponibilidadesTest() {
        List<DisponibilidadEntity> list = disponibilidadLogic.getDisponibilidades();
        Assert.assertEquals(data.size(), list.size());
        for (DisponibilidadEntity entity : list) {
            boolean found = false;
            for (DisponibilidadEntity storedEntity : data) {
                if (entity.getId().equals(storedEntity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }

    /**
     * Prueba para consultar una Disponibilidad
     *
     *
     */
    @Test
    public void getDisponibilidadTest() {
        DisponibilidadEntity entity = data.get(0);
        DisponibilidadEntity resultEntity = disponibilidadLogic.getDisponibilidad(entity.getId());
        Assert.assertNotNull(resultEntity);
        Assert.assertEquals(entity.getId(), resultEntity.getId());
        Assert.assertEquals(entity.getName(), resultEntity.getName());
        Assert.assertEquals(entity.getMatrizHorarios(), resultEntity.getMatrizHorarios());

        Assert.assertNull(disponibilidadLogic.getDisponibilidad(Long.MIN_VALUE));
    }

    /**
     * Prueba para eliminar una Disponibilidad
     *
     *
     */
    @Test
    public void deleteDisponibilidadTest() {
        DisponibilidadEntity entity = data.get(0);
        disponibilidadLogic.deleteDisponibilidad(entity.getId());
        DisponibilidadEntity deleted = em.find(DisponibilidadEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }

    /**
     * Prueba para actualizar una Disponibilidad
     *
     *
     */
    @Test
    public void updateDisponibilidadTest() throws BusinessLogicException {
        DisponibilidadEntity entity = data.get(0);
        DisponibilidadEntity pojoEntity = factory.manufacturePojo(DisponibilidadEntity.class);

        pojoEntity.setId(entity.getId());
        
        disponibilidadLogic.updateDisponibilidad(pojoEntity.getId(), pojoEntity);

        DisponibilidadEntity resp = em.find(DisponibilidadEntity.class, entity.getId());

        Assert.assertEquals(pojoEntity.getId(), resp.getId());
        Assert.assertEquals(pojoEntity.getName(), resp.getName());
        Assert.assertEquals(pojoEntity.getMatrizHorarios(), resp.getMatrizHorarios());
        
        pojoEntity.setMatrizHorarios("ADDDDDDDDLDD LLLLLLLJLLLL LLLLLLLLLLLL LLLLLLLLLLLL LLLLLLLDLLLL LLLLLALLLLLL LLLLDLLLLLLL ");
        try{
           disponibilidadLogic.updateDisponibilidad(pojoEntity.getId(), pojoEntity);
           Assert.fail();
        }catch(BusinessLogicException e){
             
        }
        
        pojoEntity.setMatrizHorarios("hola");
        try{
           disponibilidadLogic.updateDisponibilidad(pojoEntity.getId(), pojoEntity);
           Assert.fail();
        }catch(BusinessLogicException e){
             
        }

    }
    
}
