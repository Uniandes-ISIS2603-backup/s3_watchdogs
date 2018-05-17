/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.watchdogs.test.logic;

import co.edu.uniandes.csw.watchdogs.ejb.CentroDeEntrenamientoLogic;
import co.edu.uniandes.csw.watchdogs.entities.CentroDeEntrenamientoEntity;
import co.edu.uniandes.csw.watchdogs.entities.EntrenamientoEntity;
import co.edu.uniandes.csw.watchdogs.entities.HotelEntity;
import co.edu.uniandes.csw.watchdogs.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.watchdogs.persistence.CentroDeEntrenamientoPersistence;
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
import static org.junit.Assert.fail;
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
public class CentroDeEntrenamientoLogicTest {
    
    private PodamFactory factory = new PodamFactoryImpl();
    
    @Inject
    private CentroDeEntrenamientoLogic centroDeEntrenamientoLogic;
    
    @PersistenceContext
    private EntityManager em;
    
    @Inject
    private UserTransaction utx;
    
    private List<CentroDeEntrenamientoEntity> data = new ArrayList<>();
    
    private List<EntrenamientoEntity> entrenamientosData = new ArrayList<>();
    
    private List<HotelEntity> hotelesData = new ArrayList<>();
    
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(CentroDeEntrenamientoEntity.class.getPackage())
                .addPackage(CentroDeEntrenamientoLogic.class.getPackage())
                .addPackage(CentroDeEntrenamientoPersistence.class.getPackage())
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
        em.createQuery("delete from EntrenamientoEntity").executeUpdate();
        em.createQuery("delete from HotelEntity").executeUpdate();
        em.createQuery("delete from ServicioEntity").executeUpdate();
        em.createQuery("delete from CentroDeEntrenamientoEntity").executeUpdate();
        em.createQuery("delete from LugarEntity").executeUpdate();
    }

    /**
     * Inserta los datos iniciales para el correcto funcionamiento de las
     * pruebas.
     */
    private void insertData() {
        for (int i = 0; i < 3; i++) {
            CentroDeEntrenamientoEntity entity = factory.manufacturePojo(CentroDeEntrenamientoEntity.class);
            em.persist(entity);
            data.add(entity);
        }
        for (int i = 0; i < 3; i++) {
            EntrenamientoEntity entity = factory.manufacturePojo(EntrenamientoEntity.class);
            if (i != 1) {
                entity.setCentroDeEntrenamiento(data.get(0));
                data.get(0).getEntrenamientos().add(entity);
            }
            em.persist(entity);
            entrenamientosData.add(entity);
        }
        for (int i = 0; i < 3; i++) {
            HotelEntity entity = factory.manufacturePojo(HotelEntity.class);
            entity.setCentroDeEntrenamiento(data.get(0));
            em.persist(entity);
            hotelesData.add(entity);
        }
    }

    /**
     * Prueba para crear un CentroDeEntrenamiento
     *
     * @throws co.edu.uniandes.csw.watchdogs.exceptions.BusinessLogicException
     */
    @Test
    public void createCentroDeEntrenamientoTest() throws BusinessLogicException {
        CentroDeEntrenamientoEntity newEntity = factory.manufacturePojo(CentroDeEntrenamientoEntity.class);
        CentroDeEntrenamientoEntity result = centroDeEntrenamientoLogic.createCentroDeEntrenamiento(newEntity);
        Assert.assertNotNull(result);
        CentroDeEntrenamientoEntity entity = em.find(CentroDeEntrenamientoEntity.class, result.getId());
        Assert.assertEquals(newEntity.getId(), entity.getId());
    }

    /**
     * Prueba para consultar la lista de Centros De Entrenamientos
     */
    @Test
    public void getCentrosDeEntrenamientoesTest() {
        List<CentroDeEntrenamientoEntity> list = centroDeEntrenamientoLogic.getCentrosDeEntrenamientos();
        Assert.assertEquals(data.size(), list.size());
        for (CentroDeEntrenamientoEntity entity : list) {
            boolean found = false;
            for (CentroDeEntrenamientoEntity storedEntity : data) {
                if (entity.getId().equals(storedEntity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }

    /**
     * Prueba para consultar un CentroDeEntrenamiento
     */
    @Test
    public void getCentroDeEntrenamientoTest() {
        CentroDeEntrenamientoEntity entity = data.get(0);
        CentroDeEntrenamientoEntity resultEntity = centroDeEntrenamientoLogic.getCentroDeEntrenamiento(entity.getId());
        Assert.assertNotNull(resultEntity);
        Assert.assertEquals(entity.getId(), resultEntity.getId());
        
        Assert.assertNull(centroDeEntrenamientoLogic.getCentroDeEntrenamiento(Long.MIN_VALUE));
    }

    /**
     * Prueba para eliminar un CentroDeEntrenamiento
     */
    @Test
    public void deleteCentroDeEntrenamientoTest() {
        CentroDeEntrenamientoEntity entity = data.get(0);
        centroDeEntrenamientoLogic.deleteCentroDeEntrenamiento(entity.getId());
        CentroDeEntrenamientoEntity deleted = em.find(CentroDeEntrenamientoEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }

    /**
     * Prueba para actualizar un CentroDeEntrenamiento
     */
    @Test
    public void updateCentroDeEntrenamientoTest() throws BusinessLogicException {
        CentroDeEntrenamientoEntity entity = data.get(0);
        CentroDeEntrenamientoEntity pojoEntity = factory.manufacturePojo(CentroDeEntrenamientoEntity.class);
        
        pojoEntity.setId(entity.getId());
        
        centroDeEntrenamientoLogic.updateCentroDeEntrenamiento(pojoEntity.getId(), pojoEntity);
        
        CentroDeEntrenamientoEntity resp = em.find(CentroDeEntrenamientoEntity.class, entity.getId());
        
        Assert.assertEquals(pojoEntity.getId(), resp.getId());
    }

    /*
     * Prueba para obtener una instancia de Entrenamientos asociada a una instancia
     * CentroDeEntrenamiento
     *
     * 
     */
    @Test
    public void getEntrenamientoTest() throws BusinessLogicException {
        CentroDeEntrenamientoEntity entity = data.get(0);
        EntrenamientoEntity entrenamientoEntity = entrenamientosData.get(0);
        EntrenamientoEntity response = centroDeEntrenamientoLogic.getEntrenamiento(entity.getId(), entrenamientoEntity.getId());
        
        Assert.assertEquals(entrenamientoEntity.getId(), response.getId());
        Assert.assertEquals(entrenamientoEntity.getName(), response.getName());
    }

    /**
     * Prueba para asociar un Entrenamientos existente a un
     * CentroDeEntrenamiento
     */
    @Test
    public void addEntrenamientosTest() {
        try {
            CentroDeEntrenamientoEntity entity = data.get(1);
            EntrenamientoEntity entrenamiento = entrenamientosData.get(1);
            EntrenamientoEntity response = centroDeEntrenamientoLogic.addEntrenamiento(entity.getId(), entrenamiento.getId());
            
            Assert.assertNotNull(response);
            Assert.assertEquals(entrenamiento.getId(), response.getId());
            Assert.assertEquals(entrenamiento.getDuracion(), response.getDuracion());
        } catch (BusinessLogicException ex) {
            fail();
        }
    }

    /**
     * Prueba para remplazar las instancias de Entrenamientos asociadas a una
     * instancia de CentroDeEntrenamiento
     *
     *
     */
    @Test
    public void replaceEntrenamientosTest() {
        CentroDeEntrenamientoEntity entity = data.get(0);
        List<EntrenamientoEntity> list = entrenamientosData.subList(1, 3);
        centroDeEntrenamientoLogic.replaceEntrenamientos(entity.getId(), list);
        
        entity
                = centroDeEntrenamientoLogic.getCentroDeEntrenamiento(entity.getId());
        Assert.assertFalse(entity.getEntrenamientos().contains(entrenamientosData.get(0)));
        Assert.assertTrue(entity.getEntrenamientos().contains(entrenamientosData.get(1)));
        Assert.assertTrue(entity.getEntrenamientos().contains(entrenamientosData.get(2)));
    }

    /**
     * Prueba para desasociar un Entrenamiento existente de un
     * CentroDeEntrenamiento existente
     *
     *
     *
     * @Test public void removeEntrenamientosTest() throws
     * BusinessLogicException { try {
     * centroDeEntrenamientoLogic.removeEntrenamiento(data.get(0).getId(),
     * entrenamientosData.get(0).getId()); EntrenamientoEntity response =
     * centroDeEntrenamientoLogic.getEntrenamiento(data.get(0).getId(),
     * entrenamientosData.get(0).getId()); } catch (BusinessLogicException e) {
     * }
     *
     * }
     */
}
