/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.watchdogs.persistence;

import co.edu.uniandes.csw.watchdogs.entities.PayPalEntity;
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
public class PayPalPersistence {
    
    private static final Logger LOGGER = Logger.getLogger(PayPalPersistence.class.getName());
    
    @PersistenceContext(unitName = "WatchdogsPU")
    protected EntityManager em;
    
    public PayPalEntity create(PayPalEntity entity)
    {
        LOGGER.info("Creando un PayPal nuevo");
        em.persist(entity);
        LOGGER.info("Creando un PayPal nuevo");
        return entity;
    }
    
 /**
     * Busca si hay algun PayPal con el nombre que se envía de argumento
     *
     * @param name: Nombre del PayPal que se está buscando
     * @return null si no existe ningun PayPal con el nombre del argumento. Si
     * existe alguna devuelve el primero.
     */
    public PayPalEntity findByName(String name) {
        LOGGER.log(Level.INFO, "Consultando PayPal por nombre ", name);

        TypedQuery query = em.createQuery("Select e From PayPälEntity e where e.name = :name", PayPalEntity.class);
        query = query.setParameter("name", name);
        List<PayPalEntity> sameName = query.getResultList();
        if (sameName.isEmpty()) {
            return null;
        } else {
            return sameName.get(0);
        }
    }    
    
    public List<PayPalEntity> findAll()
    {
        LOGGER.info("Consultando todos los PayPal");
        TypedQuery query = em.createQuery("Select u from PayPalEntity u", PayPalEntity.class);
        return query.getResultList();
    }
    
    public PayPalEntity find(Long id)
    {
        return em.find(PayPalEntity.class, id);
    }
    
    public PayPalEntity update(PayPalEntity entity)
    {
        return em.merge(entity);
    }
    
    public void delete(PayPalEntity entity)
    {
        em.remove(entity);
    }
}
