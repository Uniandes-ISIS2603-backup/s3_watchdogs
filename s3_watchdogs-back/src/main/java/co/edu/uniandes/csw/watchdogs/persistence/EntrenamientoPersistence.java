/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.watchdogs.persistence;

import co.edu.uniandes.csw.watchdogs.entities.EntrenamientoEntity;
import java.util.List;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author c.martinezc1
 */
@Stateless
public class EntrenamientoPersistence {
    private static final Logger LOGGER = Logger.getLogger(CityPersistence.class.getName());
    
    @PersistenceContext(unitName = "WatchdogsPU")
    protected EntityManager em;
    
    /**
     *
     * @param entity objeto entrenamiento que se creará en la base de datos
     * @return devuelve la entidad creada con un id dado por la base de datos.
     */
    public EntrenamientoEntity create(EntrenamientoEntity entity) {
        LOGGER.info("Creando un entrenamiento nuevo");
        em.persist(entity);
        LOGGER.info("Creando un entrenamiento nuevo");
        return entity;
    }
    
    public List<EntrenamientoEntity> findAll() {
        LOGGER.info("Consultando todas los transportes");
        TypedQuery query = em.createQuery("select u from EntrenamientoEntity u", EntrenamientoEntity.class);
        return query.getResultList();
    }
    
    public EntrenamientoEntity find(Long id) {
        return em.find(EntrenamientoEntity.class, id);
    }

    public EntrenamientoEntity update(EntrenamientoEntity entity) {
         return em.merge(entity);
    }
    
    public void delete(Long id) {
        EntrenamientoEntity entity = find(id);
        em.remove(entity);
    }
}
