/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.watchdogs.persistence;

import co.edu.uniandes.csw.watchdogs.entities.ClienteEntity;
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
public class ClientePersistence {
        
    private static final Logger LOGGER = Logger.getLogger(EmpleadoPersistence.class.getName());
    
    @PersistenceContext(unitName = "WatchdogsPU")
    protected EntityManager em;
    
    /**
     * 
     * @param entity objeto cliente que se creara en la base de datos
     * @return devuelve la entidad creada con un id dado por la base de datos.
     */
    public ClienteEntity create(ClienteEntity entity) {
        LOGGER.info("Creando un cliente nuevo");
        em.persist(entity);
        LOGGER.info("Creando un cliente nuevo");
        return entity;
    }
    
    /**
     * Busca si hay algun cliente con el nombre que se envia de argumento
     * 
     * @param name: Nombre del cliente que se esta buscando
     * @return null si no existe ningun empleado con el nombre del argumento. Si
     * existe alguno devuelve el primero.
     */
    public ClienteEntity findByName(String name) {
        LOGGER.log(Level.INFO, "Consultando empleado por nombre ", name);
        
        //Se crea un query para buscar clientes con el nombre que recibe el metodo como argumento. ":name" es un placeholder que debe ser remplazado
        TypedQuery query = em.createQuery("Select e From EmpleadoEntity e where e.nombre = :name", ClienteEntity.class);
        // Se remplaza el placeholder ":name" con el valor del argumento 
        query = query.setParameter("name", name);
        // Se invoca el query se obtiene la lista resultado
        List<ClienteEntity> sameName = query.getResultList();
        if (sameName.isEmpty()) {
            return null;
        } else {
            return sameName.get(0);
        }
    }
    
     public List<ClienteEntity> findAll() {
        LOGGER.info("Consultando todos clientes");
        TypedQuery query = em.createQuery("select u from ClienteEntity u", ClienteEntity.class);
        return query.getResultList();
    }

    public ClienteEntity find(Long id) {
        return em.find(ClienteEntity.class, id);
    }

    public ClienteEntity update(ClienteEntity entity) {
         return em.merge(entity);
    }
    
    public void delete(ClienteEntity entity) {
        em.remove(entity);
    }
}
