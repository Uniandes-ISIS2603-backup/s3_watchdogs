/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.watchdogs.persistence;

import co.edu.uniandes.csw.watchdogs.entities.VeterinariaEntity;
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
public class VeterinariaPersistence {

    private static final Logger LOGGER = Logger.getLogger(VeterinariaPersistence.class.getName());

    @PersistenceContext(unitName = "WatchdogsPU")
    protected EntityManager em;

    /**
     *
     * @param entity objeto veterinaria que se creará en la base de datos
     * @return devuelve la entidad creada con un id dado por la base de datos.
     */
    public VeterinariaEntity create(VeterinariaEntity entity) {
        LOGGER.info("Creando una veterinaria nueva");
        em.persist(entity);
        LOGGER.info("Creando una veterinaria nueva");
        return entity;
    }

    /**
     * Busca si hay alguna Veterianria con el nombre que se envía de argumento
     *
     * @param name: Nombre de la veterinaria que se está buscando
     * @return null si no existe ninguna veterinaria con el nombre del
     * argumento. Si existe alguna devuelve el primero.
     */
    public VeterinariaEntity findByName(String name) {
        LOGGER.log(Level.INFO, "Consultando la veterinaria por nombre ", name);

        // Se crea un query para buscar veterinarias con el nombre que recibe el método como argumento. ":name" es un placeholder que debe ser remplazado
        TypedQuery query = em.createQuery("Select e From VeterinariaEntity e where e.name = :name", VeterinariaEntity.class);
        // Se remplaza el placeholder ":name" con el valor del argumento 
        query = query.setParameter("name", name);
        // Se invoca el query se obtiene la lista resultado
        List<VeterinariaEntity> sameName = query.getResultList();
        if (sameName.isEmpty()) {
            return null;
        } else {
            return sameName.get(0);
        }
    }

    public List<VeterinariaEntity> findAll() {
        LOGGER.info("Consultando todas las veterinarias");
        TypedQuery query = em.createQuery("select u from VeterinariaEntity u", VeterinariaEntity.class);
        return query.getResultList();
    }

    public VeterinariaEntity find(Long id) {
        LOGGER.log(Level.INFO, "Consultando veterianria con id={0}", id);
        return em.find(VeterinariaEntity.class, id);
    }

    public VeterinariaEntity update(VeterinariaEntity entity) {
        LOGGER.log(Level.INFO, "Actualizando veterinaria con id={0}", entity.getId());
        return em.merge(entity);
    }

    public void delete(Long id) {
        LOGGER.log(Level.INFO, "Borrando la veterinaria con id={0}", id);
        VeterinariaEntity entity = em.find(VeterinariaEntity.class, id);
        em.remove(entity);
    }
}
