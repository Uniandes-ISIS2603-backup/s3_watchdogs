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
        checkValoresNulos(entity);
        checkFacturaRepetida(entity);
        checkValorCorrecto(entity);
        checkConcordanciaCliente(entity);
    }
    
    
    /**
     * verifica que el valor de la factura sea superior a 0
     * @param entity La factura a revisar
     * @throws BusinessLogicException si la factura tiene valor menor a 0
     */
    public void checkValorValido(FacturaEntity entity) throws BusinessLogicException{
        if( entity.getValor()< 0){
            throw new BusinessLogicException("El valor de la factura no es válido");
        }
    }
    
    /**
     * verifica que no exista otra factura con el mismo servicio
     * @param entity La factura a revisar
     * @throws BusinessLogicException si el servicio ya tiene una factura
     */
    
    public void checkFacturaRepetida(FacturaEntity entity) throws BusinessLogicException{
        
        List<FacturaEntity> verificacion = getFacturas();
        //verificador = entity.getServicio().getId();
        for(int i = 0; i < verificacion.size(); i++){
            
            //if(verificacion.get(i).getServicio().getId() == verificador){
               // throw new BusinessLogicException("Ya existe una factura para ese servicio");
            //}
            
        }

    }
    
    public void checkValoresNulos(FacturaEntity entity) throws BusinessLogicException{
        /*
        if(entity.getCliente() == null ||entity.getServicio() || entity.getMetodoDePago() )
            throw new BusinessLogicException("No se pueden crear facturas con entidades nulas");
        */
    }
    
    /**
     * verifica que el valor de la factura sea el mismo del servicio
     * @param entity La factura a revisar
     * @throws BusinessLogicException si la factura tiene un valor diferente al costo del servicio
     */
    public void checkValorCorrecto(FacturaEntity entity) throws BusinessLogicException{
        /*if( entity.getValor() != entity.getServicio().getCosto()){
            throw new BusinessLogicException("El valor de la factura no es válido");
        }*/
    }
    
    
    /**
     * verifica que la concordancia del cliente sea adecuada
     * @param entity La factura a revisar
     * @throws BusinessLogicException si el método de Pago o el Servicio tienen clientes diferentes a la factura
     */
     public void checkConcordanciaCliente(FacturaEntity entity) throws BusinessLogicException{
        /*if( entity.getCliente().getId() != entity.getMetodoDePago().getCliente().getId(){
            throw new BusinessLogicException("El metodo de Pago no pertenece al cliente");
        }
        
        if( entity.getCliente().getId() != entity.getServicio().getCliente().getId(){
            throw new BusinessLogicException("El servicio no pertenece al cliente");
        }*/
    }
    
    
}
