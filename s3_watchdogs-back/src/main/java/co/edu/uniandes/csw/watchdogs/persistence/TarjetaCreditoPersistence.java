/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.watchdogs.persistence;

import co.edu.uniandes.csw.watchdogs.entities.TarjetaCreditoEntity;

import java.util.List;
import javax.ejb.Stateless;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author jc.pulido
 */
@Stateless
public class TarjetaCreditoPersistence {
    
    private static final Logger LOGGER = Logger.getLogger(TarjetaCreditoPersistence.class.getName());

    @PersistenceContext(unitName = "WatchdogsPU")
    protected EntityManager em;

    /**
     * 
     * @param entity objeto que se creará en la base de datos
     * @return devuelve la entidad creada con un id dado por la base de datos
     */
    public TarjetaCreditoEntity create(TarjetaCreditoEntity entity)
     {
         LOGGER.info("Creando una tarjeta nueva");
         em.persist(entity);
         LOGGER.info("Creando una tarjeta nueva");
      return entity;           
     }
    
    /**
     * Busca si hay alguna tarjeta con el nombre que se envía de argumento
     *
     * @param name: Nombre de la tarjeta que se está buscando
     * @return null si no existe ninguna tarjeta con el nombre del argumento. Si
     * existe alguna devuelve la primera.
     */
    public TarjetaCreditoEntity findByName(String name) {
        LOGGER.log(Level.INFO, "Consultando city por nombre ", name);

        TypedQuery query = em.createQuery("Select e From TarjetaCreditoEntity e where e.name = :name", TarjetaCreditoEntity.class);
        query = query.setParameter("name", name);
        List<TarjetaCreditoEntity> sameName = query.getResultList();
        if (sameName.isEmpty()) {
            return null;
        } else {
            return sameName.get(0);
        }
    } 
    
    public List<TarjetaCreditoEntity> findAll()
    {
        LOGGER.info("Consultando todas las tarjetas de crédito");
        TypedQuery query = em.createQuery("Select u from TarjetaCreditoEntity u", TarjetaCreditoEntity.class);
        return query.getResultList();
    }
    
    
    public TarjetaCreditoEntity find(Long id)
    {
        return em.find(TarjetaCreditoEntity.class, id);
    }
    
    public TarjetaCreditoEntity update(TarjetaCreditoEntity entity)
    {
        return em.merge(entity);
    }
    
    public void delete(Long id)
    {
        TarjetaCreditoEntity entity = em.find(TarjetaCreditoEntity.class, id);
        em.remove(entity);
    }
     
     

    
}
