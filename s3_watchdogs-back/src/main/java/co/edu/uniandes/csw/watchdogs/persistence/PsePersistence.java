/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.watchdogs.persistence;

import co.edu.uniandes.csw.watchdogs.entities.PseEntity;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author jc.pulido
 */
@Stateless
public class PsePersistence {

    private static final Logger LOGGER = Logger.getLogger(PsePersistence.class.getName());

    @PersistenceContext(unitName = "WatchdogsPU")
    protected EntityManager em;

    public PseEntity create(PseEntity entity) {
        LOGGER.info("Creando un nuevo PSE");
        em.persist(entity);
        LOGGER.info("Creando un nuevo PSE");
        return entity;
    }

    /**
     * Busca si hay algún pse con el nombre que se envía por párámetro
     *
     * @param name Nombre del pse a buscar
     * @return Null si no hay un pse con el nombre entrado, si existe alguno,
     * devuelve el primero
     */
    public PseEntity findByName(String name) {
        LOGGER.log(Level.INFO, "Consultando pse por nombre", name);
        TypedQuery query = em.createQuery("Select e From PseEntity e where e.name = :name", PseEntity.class);
        query = query.setParameter("name", name);
        List<PseEntity> sameName = query.getResultList();
        if (sameName.isEmpty()) {
            return null;
        } else {
            return sameName.get(0);
        }
    }

    public List<PseEntity> findAll() {
        LOGGER.info("Consultando todos los pse");
        TypedQuery query = em.createQuery("Select u from PseEntity u", PseEntity.class);
        return query.getResultList();
    }

    public PseEntity find(Long idCliente, Long id) {
        TypedQuery<PseEntity> q = em.createQuery("select p from PseEntity p where (p.cliente.id = :clienteid) and (p.id = :pseid)", PseEntity.class);
        q.setParameter("clienteid", idCliente);
        q.setParameter("pseid", id);
        List<PseEntity> results = q.getResultList();
        PseEntity pse = null;
        if (results != null && !results.isEmpty()) {
            pse = results.get(0);
        }

        return pse;
    }

    public PseEntity update(PseEntity entity) {
        return em.merge(entity);
    }

    public void delete(Long id) {
        PseEntity entity = em.find(PseEntity.class, id);
        em.remove(entity);
    }

}
