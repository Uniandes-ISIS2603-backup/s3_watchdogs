/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.watchdogs.persistence;

import co.edu.uniandes.csw.watchdogs.entities.MascotaEntity;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author ca.beltran10
 */
@Stateless
public class MascotaPersistence {
    
        private static final Logger LOGGER = Logger.getLogger(EmpleadoPersistence.class.getName());
    
    @PersistenceContext(unitName = "WatchdogsPU")
    protected EntityManager em;
    
    /**
     * 
     * @param entity objeto mascota que se creara en la base de datos
     * @return devuelve la entidad creada con un id dado por la base de datos.
     */
    public MascotaEntity create(MascotaEntity entity) {
        LOGGER.info("Creando una mascota nueva");
        em.persist(entity);
        LOGGER.info("Creando una mascota nueva");
        return entity;
    }
    
    /**
     * Busca si hay alguna mascota con el nombre que se envia de argumento
     * 
     * @param name: Nombre de la mascota que se esta buscando
     * @return null si no existe ninguna mascota con el nombre del argumento. Si
     * existe alguno devuelve la primera.
     */
    public MascotaEntity findByName(String name) {
        LOGGER.log(Level.INFO, "Consultando mascotas por nombre ", name);
        
        //Se crea un query para buscar mascotas con el nombre que recibe el metodo como argumento. ":name" es un placeholder que debe ser remplazado
        TypedQuery query = em.createQuery("Select e From MascotaEntity e where e.nombre = :name", MascotaEntity.class);
        // Se remplaza el placeholder ":name" con el valor del argumento 
        query = query.setParameter("name", name);
        // Se invoca el query se obtiene la lista resultado
        List<MascotaEntity> sameName = query.getResultList();
        if (sameName.isEmpty()) {
            return null;
        } else {
            return sameName.get(0);
        }
    }
    
     public List<MascotaEntity> findAll() {
        LOGGER.info("Consultando todas las mascotas");
        TypedQuery query = em.createQuery("select u from MascotaEntity u", MascotaEntity.class);
        return query.getResultList();
    }

    public MascotaEntity find(Long id) {
        return em.find(MascotaEntity.class, id);
    }

    public MascotaEntity update(MascotaEntity entity) {
         return em.merge(entity);
    }
    
    public void delete(MascotaEntity entity) {
        em.remove(entity);
    }
}
