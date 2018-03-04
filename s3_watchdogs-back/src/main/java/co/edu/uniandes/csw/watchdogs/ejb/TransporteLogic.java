/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.watchdogs.ejb;

import co.edu.uniandes.csw.watchdogs.entities.TransporteEntity;
import co.edu.uniandes.csw.watchdogs.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.watchdogs.persistence.TransportePersistence;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author c.martinezc1
 */
@Stateless
public class TransporteLogic {
    
    private static final Logger LOGGER = Logger.getLogger(TransporteLogic.class.getName());
    
    @Inject
    private TransportePersistence persistence;     

    /**
     * Devuelve todos los transportes que hay en la base de datos.
     * @return Lista de entidades de tipo transporte.
     */
    public List<TransporteEntity> getTransportes() {
        LOGGER.info("Inicia proceso de consultar todos los Transporte");
        List<TransporteEntity> transportes = persistence.findAll();
        LOGGER.info("Termina proceso de consultar todos los Transporte");
        return transportes;
    }
    
    /**
     * Busca un transporte por ID
     * @param id El id del transporte a buscar
     * @return El Transporte encontrado, null si no lo encuentra.
     */
    public TransporteEntity getTransporte(Long id) {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar Transporte con id={0}", id);
        TransporteEntity transporte = persistence.find(id);
        if (transporte == null) {
            LOGGER.log(Level.SEVERE, "El Transporte con el id {0} no existe", id);
        }
        LOGGER.log(Level.INFO, "Termina proceso de consultar Transporte con id={0}", id);
        return transporte;
    }
    
    /**
     * Guardar un nuevo Transporte
     * @param entity La entidad de tipo Transporte del nuevo libro a persistir.
     * @return La entidad luego de persistirla
     * @throws BusinessLogicException 
     */
    public TransporteEntity createTransporte(TransporteEntity entity) throws BusinessLogicException {
        LOGGER.info("Inicia proceso de creación de Transporte");
        persistence.create(entity);
        LOGGER.info("Termina proceso de creación de Transporte");
        return entity;
    }
    
    /**
     * Actualizar un Transporte por ID
     * @param id El ID del Transporte a actualizar
     * @param entity La entidad del Transporte con los cambios deseados
     * @return La entidad del Transporte luego de actualizarla
     * @throws BusinessLogicException 
     */
    public TransporteEntity updateTransporte(Long id, TransporteEntity entity) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "Inicia proceso de actualizar Transporte con id={0}", id);
        
        TransporteEntity newEntity = persistence.update(entity);
        LOGGER.log(Level.INFO, "Termina proceso de actualizar Transporte con id={0}", entity.getId());
        return newEntity;
    }
    
    /**
     * Eliminar un Transporte por ID
     * @param id El ID del Transporte a eliminar
     */
    public void deleteTransporte(Long id) {
        LOGGER.log(Level.INFO, "Inicia proceso de borrar Transporte con id={0}", id);
        persistence.delete(id);
        LOGGER.log(Level.INFO, "Termina proceso de borrar Transporte con id={0}", id);
    }
}
