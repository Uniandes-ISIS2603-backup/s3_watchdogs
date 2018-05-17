/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.watchdogs.persistence;

import co.edu.uniandes.csw.watchdogs.entities.CentroDeEntrenamientoEntity;
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
public class CentroDeEntrenamientoPersistence {

    private static final Logger LOGGER = Logger.getLogger(CentroDeEntrenamientoPersistence.class.getName());

    @PersistenceContext(unitName = "WatchdogsPU")
    protected EntityManager em;

    /**
     *
     * @param entity objeto paseo que se creará en la base de datos
     * @return devuelve la entidad creada con un id dado por la base de datos.
     */
    public CentroDeEntrenamientoEntity create(CentroDeEntrenamientoEntity entity) {
        LOGGER.info("Creando un centro de entrenamiento nuevo");
        em.persist(entity);
        LOGGER.info("Paseo creado");
        return entity;
    }

    public List<CentroDeEntrenamientoEntity> findAll() {
        LOGGER.info("Consultando todos los centros de entrenamiento");
        TypedQuery query = em.createQuery("select u from CentroDeEntrenamientoEntity u", CentroDeEntrenamientoEntity.class);
        return query.getResultList();
    }

    public CentroDeEntrenamientoEntity find(Long id) {
        return em.find(CentroDeEntrenamientoEntity.class, id);
    }

    public CentroDeEntrenamientoEntity update(CentroDeEntrenamientoEntity entity) {
        return em.merge(entity);
    }

    public void delete(Long id) {
        CentroDeEntrenamientoEntity entity = find(id);
        em.remove(entity);
    }
}
