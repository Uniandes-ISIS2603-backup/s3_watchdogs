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
    
    public PayPalEntity find(Long idCliente,Long id)
    {
        TypedQuery<PayPalEntity> q = em.createQuery("select p from PayPalEntity p where (p.cliente.id = :clienteid) and (p.id = :paypalid)", PayPalEntity.class);
        q.setParameter("clienteid", idCliente);
        q.setParameter("paypalid", id);
        List<PayPalEntity> results = q.getResultList();
        PayPalEntity payPal = null;
        if(results == null){
            payPal = null;
        }
        else if(results.isEmpty())
        {
            payPal = null;
        }
        else if(results.size()>= 1)
        {
            payPal = results.get(0);
        }
        
        return payPal;
    }
    
    public PayPalEntity update(PayPalEntity entity)
    {
        return em.merge(entity);
    }
    
    public void delete(Long id)
    {
        PayPalEntity entity = em.find(PayPalEntity.class, id);
        em.remove(entity);
    }
}
