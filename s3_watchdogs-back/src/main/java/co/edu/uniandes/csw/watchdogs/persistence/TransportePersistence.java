/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.watchdogs.persistence;

import co.edu.uniandes.csw.watchdogs.entities.TransporteEntity;
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
public class TransportePersistence {
    
    private static final Logger LOGGER = Logger.getLogger(TransportePersistence.class.getName());
    
    @PersistenceContext(unitName = "WatchdogsPU")
    protected EntityManager em;
    
    /**
     *
     * @param entity objeto transporte que se creará en la base de datos
     * @return devuelve la entidad creada con un id dado por la base de datos.
     */
    public TransporteEntity create(TransporteEntity entity) {
        LOGGER.info("Creando un transporte nueva");
        em.persist(entity);
        LOGGER.info("Creando un transporte nueva");
        return entity;
    }
    
    public List<TransporteEntity> findAll() {
        LOGGER.info("Consultando todas los transportes");
        TypedQuery query = em.createQuery("select u from TransporteEntity u", TransporteEntity.class);
        return query.getResultList();
    }
    
    public TransporteEntity find(Long id) {
        LOGGER.log(Level.INFO, "Consultando transporte con id={0}", id);
        return em.find(TransporteEntity.class, id);
    }

    public TransporteEntity update(TransporteEntity entity) {
        LOGGER.log(Level.INFO, "Actualizando transporte con id={0}", entity.getId());
        return em.merge(entity);
    }
    
    public void delete(Long id) {
        LOGGER.log(Level.INFO, "Borrando el transporte con id={0}", id);
        TransporteEntity entity = em.find(TransporteEntity.class, id);
        em.remove(entity);
    }
}
