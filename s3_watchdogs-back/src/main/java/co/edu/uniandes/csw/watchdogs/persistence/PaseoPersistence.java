/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.watchdogs.persistence;

import co.edu.uniandes.csw.watchdogs.entities.PaseoEntity;
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
public class PaseoPersistence {

    private static final Logger LOGGER = Logger.getLogger(PaseoPersistence.class.getName());

    @PersistenceContext(unitName = "WatchdogsPU")
    protected EntityManager em;

    /**
     *
     * @param entity objeto paseo que se creará en la base de datos
     * @return devuelve la entidad creada con un id dado por la base de datos.
     */
    public PaseoEntity create(PaseoEntity entity) {
        LOGGER.info("Creando un paseo nuevo");
        em.persist(entity);
        LOGGER.info("Paseo creado");
        return entity;
    }

    public List<PaseoEntity> findAll() {
        LOGGER.info("Consultando todos los paseos");
        TypedQuery query = em.createQuery("select u from PaseoEntity u", PaseoEntity.class);
        return query.getResultList();
    }

    public PaseoEntity find(Long id) {
        return em.find(PaseoEntity.class, id);
    }

    public PaseoEntity update(PaseoEntity entity) {
        return em.merge(entity);
    }

    public void delete(Long id) {
        PaseoEntity entity = find(id);
        em.remove(entity);
    }
}
