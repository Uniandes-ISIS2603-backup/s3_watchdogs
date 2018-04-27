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
 * Clase que maneja la persistencia para Cliente. Se conecta a traves del Entity
 * Manager de javax.persistance con la base de datos SQL.
 *
 * @author ca.beltran10
 */
@Stateless
public class ClientePersistence {

    /**
     * Constante que representa el Logger de la persistencia.
     */
    private static final Logger LOGGER = Logger.getLogger(EmpleadoPersistence.class.getName());

    /**
     * Relacion con el entity manager.
     */
    @PersistenceContext(unitName = "WatchdogsPU")
    protected EntityManager em;

    /**
     * Crea un cliente en la base de datos.
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
        LOGGER.log(Level.INFO, "Consultando cliente por nombre ", name);

        //Se crea un query para buscar clientes con el nombre que recibe el metodo como argumento. ":name" es un placeholder que debe ser remplazado
        TypedQuery query = em.createQuery("Select e From ClienteEntity e where e.name = :name", ClienteEntity.class);
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

    /**
     * Busca si hay algun cliente con la cedula que se envia de argumento
     *
     * @param cedula: Nombre del cliente que se esta buscando
     * @return null si no existe ningun empleado con el nombre del argumento. Si
     * existe alguno devuelve el primero.
     */
    public ClienteEntity findByCedula(String cedula) {
        LOGGER.log(Level.INFO, "Consultando cliente por cedula ", cedula);

        //Se crea un query para buscar clientes con el nombre que recibe el metodo como argumento. ":name" es un placeholder que debe ser remplazado
        TypedQuery query = em.createQuery("Select e From ClienteEntity e where e.cedula = :cedula", ClienteEntity.class);
        // Se remplaza el placeholder ":name" con el valor del argumento 
        query = query.setParameter("cedula", cedula);
        // Se invoca el query se obtiene la lista resultado
        List<ClienteEntity> sameName = query.getResultList();
        if (sameName.isEmpty()) {
            return null;
        } else {
            return sameName.get(0);
        }
    }

    /**
     * Devuelte todos los clientes de la base de datos.
     *
     * @return una lista con todos los clientes que se encuentren en la base de
     * datos, "select u from ClienteEnity u" es como un "select * from
     * ClienteEntity;" - "SELECT * FROM table_name" en SQL.
     */
    public List<ClienteEntity> findAll() {
        LOGGER.info("Consultando todos los clientes");
        TypedQuery query = em.createQuery("select u from ClienteEntity u", ClienteEntity.class);
        return query.getResultList();
    }

    /**
     * Busca si hay algun cliente con el id que se envia de argumento.
     *
     * @param id: id correspondiente al cliente buscado.
     * @return un cliente
     */
    public ClienteEntity find(Long id) {
        LOGGER.log(Level.INFO, "Consultando Cliente con id = {0}", id);
        return em.find(ClienteEntity.class, id);
    }

    /**
     * Actualiza un cliente.
     *
     * @param entity: el cliente que viene con los nuevos cambios. Por ejemplo
     * el nombre pudo cambiar. En ese caso, se haria uso del metodo update.
     * @return un cliente con los cambios aplicados.
     */
    public ClienteEntity update(ClienteEntity entity) {
        LOGGER.log(Level.INFO, "Actualizando Cliente con id={0}", entity.getId());
        return em.merge(entity);
    }

    /**
     * Borra un cliente de la base de datos recibiendo como argumento el id del
     * cliente.
     *
     * @param id: id correspondiente al cliente a borrar.
     */
    public void delete(Long id) {
        LOGGER.log(Level.INFO, "Borrando el Cliente con id = {0}", id);
        ClienteEntity entity = em.find(ClienteEntity.class, id);
        em.remove(entity);
    }
}
