/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.watchdogs.persistence;

import co.edu.uniandes.csw.watchdogs.entities.CalificacionEntity;
import java.util.List;
import java.util.logging.Level;
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
public class CalificacionPersistence {
    private static final Logger LOGGER = Logger.getLogger(CalificacionPersistence.class.getName());
    
    @PersistenceContext(unitName = "WatchdogsPU")
    protected EntityManager em;
    
    /**
     *
     * @param entity objeto transporte que se creará en la base de datos
     * @return devuelve la entidad creada con un id dado por la base de datos.
     */
    public CalificacionEntity create(CalificacionEntity entity) {
        LOGGER.info("Creando una calificacion nueva");
        em.persist(entity);
        LOGGER.info("Calificacion persistida");
        return entity;
    }
    
    public List<CalificacionEntity> findAll() {
        LOGGER.info("Consultando todas las calificaciones");
        TypedQuery query = em.createQuery("select u from CalificacionEntity u", CalificacionEntity.class);
        return query.getResultList();
    }
    
    public CalificacionEntity find(Long id) {
        LOGGER.log(Level.INFO, "Consultando calificacion con id={0}", id);
        return em.find(CalificacionEntity.class, id);
    }

    public CalificacionEntity update(CalificacionEntity entity) {
        LOGGER.log(Level.INFO, "Actualizando Calificacion con id={0}", entity.getId());
        return em.merge(entity);
    }
    
    public void delete(Long id) {
        LOGGER.log(Level.INFO, "Borrando el Calificacion con id={0}", id);
        CalificacionEntity entity = em.find(CalificacionEntity.class, id);
        em.remove(entity);
    }
}
