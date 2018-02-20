/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.watchdogs.persistence;

import co.edu.uniandes.csw.watchdogs.entities.FacturaEntity;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.logging.Level;
import javax.persistence.TypedQuery;

/**
 *
 * @author id.salazar
 */

@Stateless
public class FacturaPersistence {
    
    private static final Logger LOGGER = Logger.getLogger(FacturaPersistence.class.getName());
    
    @PersistenceContext(unitName = "WatchdogsPU")
    protected EntityManager em;
    
    /**
     * 
     * @param entity objeto factura que se creara en la base de datos
     * @return devuelve la entidad creada con un id dado por la base de datos.
     */
    public FacturaEntity create(FacturaEntity entity) {
        LOGGER.info("Creando una factura nueva");
        em.persist(entity);
        LOGGER.info("Creando una factura nueva");
        return entity;
    }
    
    /**
     * Busca si hay alguna factura con el valor que se envia por argumento
     * 
     * @param valor: Valor de la factura que se está buscando
     * @return null si no existe ninguna factura con el valor del argumento. Si
     * existe alguno devuelve la primera.
     */
    public FacturaEntity findByPrice(String valor) {
        
        LOGGER.log(Level.INFO, "Consultando factura por precio ", valor);
        
        //Se crea un query para buscar facturas con el valoe que recibe el metodo como argumento. ":valor" es un placeholder que debe ser remplazado
        TypedQuery query = em.createQuery("Select e From FacturaEntity e where e.valor = :valor", FacturaEntity.class);
        // Se remplaza el placeholder ":valor" con el valor del argumento 
        query = query.setParameter("valor", valor);
        // Se invoca el query se obtiene la lista resultado
        List<FacturaEntity> sameName = query.getResultList();
        if (sameName.isEmpty()) {
            return null;
            
        } else {
            return sameName.get(0);
        }
    }
    
     public List<FacturaEntity> findAll() {
        LOGGER.info("Consultando todas las facturas");
        TypedQuery query = em.createQuery("select u from FacturaEntity u", FacturaEntity.class);
        return query.getResultList();
    }

    public FacturaEntity find(Long id) {
        return em.find(FacturaEntity.class, id);
    }

    public FacturaEntity update(FacturaEntity entity) {
         return em.merge(entity);
    }
    
    public void delete(FacturaEntity entity) {
        em.remove(entity);
    }
    
}
