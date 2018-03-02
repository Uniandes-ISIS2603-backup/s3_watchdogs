/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.watchdogs.ejb;

import co.edu.uniandes.csw.watchdogs.entities.FacturaEntity;
import co.edu.uniandes.csw.watchdogs.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.watchdogs.persistence.FacturaPersistence;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author id.salazar
 */

@Stateless
public class FacturaLogic {
    
    private static final Logger LOGGER = Logger.getLogger(FacturaLogic.class.getName());
    
    @Inject
    private FacturaPersistence persistence;

    /**
     * Devuelve todas las facturas que hay en la base de datos.
     * @return Lista de entidades de tipo factura.
     */
    public List<FacturaEntity> getFacturas() {
        LOGGER.info("Inicia proceso de consultar todas las Facturas");
        List<FacturaEntity> facturas = persistence.findAll();
        LOGGER.info("Termina proceso de consultar todas las Facturas");
        return facturas;
    }
    
    /**
     * Busca una factura por ID
     * @param id El id de la factura a buscar
     * @return La factura encontrada, null si no la encuentra.
     */
    public FacturaEntity getFactura(Long id) {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar Factura con id={0}", id);
        FacturaEntity factura = persistence.find(id);
        if (factura == null) {
            LOGGER.log(Level.SEVERE, "La Factura con el id {0} no existe", id);
        }
        LOGGER.log(Level.INFO, "Termina proceso de consultar factura con id={0}", id);
        return factura;
    }
    
    /**
     * Guardar una nueva Factura
     * @param entity La nueva entidad de tipo Factura a persistir.
     * @return La entidad luego de persistirla
     * @throws BusinessLogicException 
     */
    public FacturaEntity createFactura(FacturaEntity entity) throws BusinessLogicException {
        LOGGER.info("Inicia proceso de creación de Factura");
        check(entity);
        persistence.create(entity);
        LOGGER.info("Termina proceso de creación de Factura");
        return entity;
    }
    
    /**
     * Actualizar una Factura por ID
     * @param id El ID de la Factura a actualizar
     * @param entity La entidad de la Factura con los cambios deseados
     * @return La entidad de la Factura luego de actualizarla
     * @throws BusinessLogicException 
     */
    public FacturaEntity updateFactura(Long id, FacturaEntity entity) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "Inicia proceso de actualizar Factura con id={0}", id);
        check(entity);
        FacturaEntity newEntity = persistence.update(entity);
        LOGGER.log(Level.INFO, "Termina proceso de actualizar Factura con id={0}", entity.getId());
        return newEntity;
    }
    
    /**
     * Eliminar una Factura por ID
     * @param id El ID de la Factura a eliminar
     */
    public void deleteFactura(Long id) {
        LOGGER.log(Level.INFO, "Inicia proceso de borrar Factura con id={0}", id);
        persistence.delete(id);
        LOGGER.log(Level.INFO, "Termina proceso de borrar Factura con id={0}", id);
    }
    
    public void check(FacturaEntity entity)throws BusinessLogicException{
        checkValorValido(entity);
    }
    
    
    /**
     * verifica que el valor de la factura sea superior a 0
     */
    public void checkValorValido(FacturaEntity entity) throws BusinessLogicException{
        if( entity.getValor()< 0){
            throw new BusinessLogicException("El valor de la factura no es válido");
        }
    }
    
}
