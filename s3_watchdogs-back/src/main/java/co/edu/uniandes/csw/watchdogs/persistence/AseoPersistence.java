/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.watchdogs.persistence;

import co.edu.uniandes.csw.watchdogs.entities.AseoEntity;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author js.vacat
 */
@Stateless
public class AseoPersistence {
    
    private static final Logger LOGGER = Logger.getLogger(AseoPersistence.class.getName());
    
    @PersistenceContext(unitName = "WatchdogsPU")
    protected EntityManager em;
    
    /**
     *
     * @param entity objeto aseo que se creará en la base de datos
     * @return devuelve la entidad creada con un id dado por la base de datos.
     */
    public AseoEntity create(AseoEntity entity) {
        LOGGER.info("Creando un servicio de aseo nuevo");
        em.persist(entity);
        LOGGER.info("Creando un servicio de aseo nuevo");
        return entity;
    }
    
    /**
     * Busca si hay algun Aseo con el nombre que se envía de argumento
     *
     * @param name: Nombre del servicio de aseo que se está buscando
     * @return null si no existe ningun servicio de aseo con el nombre del argumento. Si
     * existe alguna devuelve el primero.
     */
    public AseoEntity findByName(String name) {
        LOGGER.log(Level.INFO, "Consultando servicio de aseo por nombre ", name);

        // Se crea un query para buscar aseos con el nombre que recibe el método como argumento. ":name" es un placeholder que debe ser remplazado
        TypedQuery query = em.createQuery("Select e From AseoEntity e where e.name = :name", AseoEntity.class);
        // Se remplaza el placeholder ":name" con el valor del argumento 
        query = query.setParameter("name", name);
        // Se invoca el query se obtiene la lista resultado
        List<AseoEntity> sameName = query.getResultList();
        if (sameName.isEmpty()) {
            return null;
        } else {
            return sameName.get(0);
        }
    }

    
      public List<AseoEntity> findAll() {
        LOGGER.info("Consultando todos los servicios de aseo");
        TypedQuery query = em.createQuery("select u from TransporteEntity u", AseoEntity.class);
        return query.getResultList();
    }
    
    public AseoEntity find(Long id) {
        LOGGER.log(Level.INFO, "Consultando servicio de aseo con id={0}", id);
        return em.find(AseoEntity.class, id);
    }

    public AseoEntity update(AseoEntity entity) {
        LOGGER.log(Level.INFO, "Actualizando servicio de id con id={0}", entity.getId());
        return em.merge(entity);
    }
    
    public void delete(Long id) {
        LOGGER.log(Level.INFO, "Borrando el servicio de aseo con id={0}", id);
        AseoEntity entity = em.find(AseoEntity.class, id);
        em.remove(entity);
    }
}
