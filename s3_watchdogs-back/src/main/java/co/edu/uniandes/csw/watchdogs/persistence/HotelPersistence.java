/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.watchdogs.persistence;

import co.edu.uniandes.csw.watchdogs.entities.HotelEntity;
import java.util.List;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author m.diazt
 */
@Stateless
public class HotelPersistence {

    private static final Logger LOGGER = Logger.getLogger(HotelPersistence.class.getName());

    @PersistenceContext(unitName = "WatchdogsPU")
    protected EntityManager em;

    /**
     *
     * @param entity objeto hotel que se creará en la base de datos
     * @return devuelve la entidad creada con un id dado por la base de datos.
     */
    public HotelEntity create(HotelEntity entity) {
        LOGGER.info("Creando un hotel nuevo");
        em.persist(entity);
        LOGGER.info("Hotel creado");
        return entity;
    }

    public List<HotelEntity> findAll() {
        LOGGER.info("Consultando todos los hoteles");
        TypedQuery query = em.createQuery("select u from HotelEntity u", HotelEntity.class);
        return query.getResultList();
    }

    public HotelEntity find(Long id) {
        return em.find(HotelEntity.class, id);
    }

    public HotelEntity update(HotelEntity entity) {
        return em.merge(entity);
    }

    public void delete(Long id) {
        HotelEntity entity = find(id);
        em.remove(entity);
    }
}
