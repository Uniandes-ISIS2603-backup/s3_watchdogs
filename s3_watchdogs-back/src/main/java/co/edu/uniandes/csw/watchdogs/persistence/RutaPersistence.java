/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.watchdogs.persistence;

import co.edu.uniandes.csw.watchdogs.entities.RutaEntity;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import javax.persistence.TypedQuery;

/**
 *
 * @author id.salazar
 */

@Stateless
public class RutaPersistence {
    
    private static final Logger LOGGER = Logger.getLogger(RutaPersistence.class.getName());
    
    @PersistenceContext(unitName = "WatchdogsPU")
    protected EntityManager em;
    
    /**
     * 
     * @param entity objeto ruta que se creara en la base de datos
     * @return devuelve la entidad creada con un id dado por la base de datos.
     */
    public RutaEntity create(RutaEntity entity) {
        LOGGER.info("Creando una ruta nueva");
        em.persist(entity);
        LOGGER.info("Creando una ruta nueva");
        return entity;
    }
    
    
     public List<RutaEntity> findAll() {
        LOGGER.info("Consultando todas las rutas");
        TypedQuery query = em.createQuery("select u from RutaEntity u", RutaEntity.class);
        return query.getResultList();
    }

    public RutaEntity find(Long id) {
        return em.find(RutaEntity.class, id);
    }

    public RutaEntity update(RutaEntity entity) {
         return em.merge(entity);
    }
    
    public void delete(Long id) {
        RutaEntity entity = find(id);
        em.remove(entity);
    }
}
