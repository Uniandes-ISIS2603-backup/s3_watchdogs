/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.watchdogs.persistence;

import co.edu.uniandes.csw.watchdogs.entities.EmpleadoEntity;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *  Clase que maneja la persistencia para Empleado.
 * Se conecta a traves del Entity Manager de javax.persistance con la base de datos
 * SQL.
 * @author ca.beltran10
 */
@Stateless
public class EmpleadoPersistence {
    
    private static final Logger LOGGER = Logger.getLogger(EmpleadoPersistence.class.getName());
    
    @PersistenceContext(unitName = "WatchdogsPU")
    protected EntityManager em;
    
    /**
     * Crea un empleado en la base de datos
     * 
     * @param entity objeto empleado que se creara en la base de datos
     * @return devuelve la entidad creada con un id dado por la base de datos.
     */
    public EmpleadoEntity create(EmpleadoEntity entity) {
        LOGGER.info("Creando un empleado nuevo");
        em.persist(entity);
        LOGGER.info("Creando un empleado nuevo");
        return entity;
    }
    
    /**
     * Busca si hay algun empleado con el nombre que se envia de argumento
     * 
     * @param name: Nombre del empleado que se esta buscando
     * @return null si no existe ningun empleado con el nombre del argumento. Si
     * existe alguno devuelve el primero.
     */
    public EmpleadoEntity findByName(String name) {
        LOGGER.log(Level.INFO, "Consultando empleado por nombre ", name);
        
        //Se crea un query para buscar empleados con el nombre que recibe el metodo como argumento. ":name" es un placeholder que debe ser remplazado
        TypedQuery query = em.createQuery("Select e From EmpleadoEntity e where e.nombre = :name", EmpleadoEntity.class);
        // Se remplaza el placeholder ":name" con el valor del argumento 
        query = query.setParameter("name", name);
        // Se invoca el query se obtiene la lista resultado
        List<EmpleadoEntity> sameName = query.getResultList();
        if (sameName.isEmpty()) {
            return null;
        } else {
            return sameName.get(0);
        }
    }
    
    /**
     * Devuelve todos los empleados de la base de datos.
     * 
     * @return una lista con todos los empleados que encuentre en la base de
     * datos, "select u from ClienteEntity u" ec como un "select * from
     * ClienteEntity" - "SELECT * FROM table_name" en SQL.
     */
     public List<EmpleadoEntity> findAll() {
        LOGGER.info("Consultando todos los empleados");
        TypedQuery query = em.createQuery("select u from EmpleadoEntity u", EmpleadoEntity.class);
        return query.getResultList();
    }

     /**
      * Busca si hay algun empleado con el id que se envia de argumento.
      * 
      * @param id: id correspondiente al empleado buscado.
      * @return un empleado.
      */
    public EmpleadoEntity find(Long id) {
        LOGGER.log(Level.INFO, "Consultando empleado con id = {0}", id);
        return em.find(EmpleadoEntity.class, id);
    }

    /**
     * Actualiza un empleado.
     * 
     * @param entity: el empleado que viene con los nuevos cambios. Por ejemplo
     * el nombre pudo cambiar. En ese caso, se haria uso del metodo update.
     * @return un empleado con los cambios aplicados.
     */
    public EmpleadoEntity update(EmpleadoEntity entity) {
        LOGGER.log(Level.INFO, "Actualizando Empleado con id={0}", entity.getId());
         return em.merge(entity);
    }
    
    /**
     * Borra un empleado de la base de datos recibiendo como argumento el id
     * del empleado.
     * 
     * @param id: id correspondiente al empleado a borrar.
     */
    public void delete(Long id) {
        LOGGER.log(Level.INFO, "Borrando el Empleado con id = {0}", id);
        EmpleadoEntity entity = em.find(EmpleadoEntity.class, id);
        em.remove(entity);
    }
}
