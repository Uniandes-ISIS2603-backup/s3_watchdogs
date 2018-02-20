/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.watchdogs.persistence;

import co.edu.uniandes.csw.watchdogs.entities.DisponibilidadEntity;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.logging.Level;
import javax.persistence.TypedQuery;


/**
 *
 * @author id.salazar
 */

@Stateless
public class DisponibilidadPersistence {
     private static final Logger LOGGER = Logger.getLogger(DisponibilidadPersistence.class.getName());
    
    @PersistenceContext(unitName = "WatchdogsPU")
    protected EntityManager em;
    
    /**
     * 
     * @param entity objeto disponibilidad que se creara en la base de datos
     * @return devuelve la entidad creada con un id dado por la base de datos.
     */
    public DisponibilidadEntity create(DisponibilidadEntity entity) {
        LOGGER.info("Creando una disponibilidad nueva");
        em.persist(entity);
        LOGGER.info("Creando una disponibilidad nueva");
        return entity;
    }
    
    
     public List<DisponibilidadEntity> findAll() {
        LOGGER.info("Consultando todas las disponibilidades");
        TypedQuery query = em.createQuery("select u from DisponibilidadEntity u", DisponibilidadEntity.class);
        return query.getResultList();
    }

    public DisponibilidadEntity find(Long id) {
        return em.find(DisponibilidadEntity.class, id);
    }

    public DisponibilidadEntity update(DisponibilidadEntity entity) {
         return em.merge(entity);
    }
    
    public void delete(DisponibilidadEntity entity) {
        em.remove(entity);
    }
}
