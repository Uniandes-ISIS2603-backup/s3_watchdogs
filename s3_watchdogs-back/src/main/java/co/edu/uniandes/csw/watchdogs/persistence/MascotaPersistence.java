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
 * Clase que maneja la persistencia para Mascota. Se conecta a traves del Entity
 * Manager de javax.persistance con la base de datos SQL.
 *
 * @author ca.beltran10
 */
@Stateless
public class MascotaPersistence {

    private static final Logger LOGGER = Logger.getLogger(EmpleadoPersistence.class.getName());

    @PersistenceContext(unitName = "WatchdogsPU")
    protected EntityManager em;

    /**
     * Crea una mascota en la base de datos.
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

    /**
     * Devuelve todas las mascotas de la base de datos.
     *
     * @return una lista con todas las mascotas que encuentre en la base de
     * datos, "select u from MascotaEntity u" es como un "select * from
     * MascotaEntity;" - "SELECT * FROM table_name" en SQL.
     */
    public List<MascotaEntity> findAll() {
        LOGGER.info("Consultando todas las mascotas");
        TypedQuery query = em.createQuery("select u from MascotaEntity u", MascotaEntity.class);
        return query.getResultList();
    }

    /**
     * Busca si hay alguna mascota con el id que se envía de argumento.
     *
     * @param id: id correspondiente a la mascota buscada.
     * @return una mascota.
     */
    public MascotaEntity find(Long id) {
        LOGGER.log(Level.INFO, "Consultando mascota con id={0}", id);
        return em.find(MascotaEntity.class, id);
    }

    /**
     * Actualiza una mascota.
     *
     * @param entity: la mascota que viene con los nuevos cambios. Por ejemplo
     * el nombre pudo cambiar. En ese caso, se haria uso del método update.
     * @return una mascota con los cambios aplicados.
     */
    public MascotaEntity update(MascotaEntity entity) {
        LOGGER.log(Level.INFO, "Actualizando Mascota con id={0}", entity.getId());
        return em.merge(entity);
    }

    /**
     * Borra una mascota de la base de datos recibiendo como argumento el id de
     * la mascota
     *
     * @param id: id correspondiente a la mascota a borrar.
     */
    public void delete(Long id) {
        LOGGER.log(Level.INFO, "Borrando la Mascota con id={0}", id);
        MascotaEntity entity = em.find(MascotaEntity.class, id);
        em.remove(entity);
    }
}
