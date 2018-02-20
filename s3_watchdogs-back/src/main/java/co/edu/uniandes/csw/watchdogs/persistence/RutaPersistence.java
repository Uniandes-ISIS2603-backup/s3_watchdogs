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
import java.util.logging.Level;
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
    
    /**
     * Busca si hay alguna ruta con la duracion que se envia por argumento
     * 
     * @param duracion: Duracion de la ruta que ese está buscando
     * @return null si no existe ninguna ruta con la duracion del argumento. Si
     * existe alguna devuelve la primera.
     */
    public RutaEntity findByLenght(String duracion) {
        
        LOGGER.log(Level.INFO, "Consultando ruta por duracion ", duracion);
        
        //Se crea un query para buscar facturas con el valoe que recibe el metodo como argumento. ":valor" es un placeholder que debe ser remplazado
        TypedQuery query = em.createQuery("Select e From RutaEntity e where e.duracion = :duracion", RutaEntity.class);
        // Se remplaza el placeholder ":valor" con el valor del argumento 
        query = query.setParameter("valor", duracion);
        // Se invoca el query se obtiene la lista resultado
        List<RutaEntity> sameName = query.getResultList();
        if (sameName.isEmpty()) {
            return null;
            
        } else {
            return sameName.get(0);
        }
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
    
    public void delete(RutaEntity entity) {
        em.remove(entity);
    }
}
