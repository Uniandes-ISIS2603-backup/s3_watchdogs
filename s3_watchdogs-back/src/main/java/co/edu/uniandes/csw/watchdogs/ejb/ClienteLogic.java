/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.watchdogs.ejb;

import co.edu.uniandes.csw.watchdogs.entities.ClienteEntity;
import co.edu.uniandes.csw.watchdogs.entities.MetodoDePagoEntity;
import co.edu.uniandes.csw.watchdogs.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.watchdogs.persistence.ClientePersistence;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * Clase que implementa la conexion con la persistencia para la entidad Cliente.
 * @author ca.beltran10
 */
@Stateless
public class ClienteLogic {
    
    private static final Logger LOGGER = Logger.getLogger(ClienteLogic.class.getName());
    
    @Inject
    private ClientePersistence persistence;
    
    /**
     * Crea un cliente en la persistencia.
     * 
     * @param entity La entidad que representa el cliente a persistir.
     * @return La entidad del cliente luego de persistirla.
     * @throws BusinessLogicException Si el cliente a persistir ya existe.
     */
    public ClienteEntity createCliente(ClienteEntity entity) throws BusinessLogicException {
        LOGGER.info("Inicia proceso de creacion de cliente");
        if(persistence.findByCedula(entity.getCedula()) != null){
            throw new BusinessLogicException("Ya existe un Cliente con la cedula \"" + entity.getCedula() + "\"");
        }
        LOGGER.info("Termina el proceso de creacion de cliente");
        return persistence.create(entity);
    }
    
    /**
     * Obtener todos los clientes existentes en la base de datos.
     * 
     * @return una lista de clientes.
     */
    public List<ClienteEntity> getClientes() {
        LOGGER.info("Inicia proceso de consultar todos los cliente");
        List<ClienteEntity> clientes = persistence.findAll();
        LOGGER.info("Termina proceso de cosultar todos los clientes");
        return clientes;
    }
    
    /**
     * Obtener un cliente por medio de su id.
     * 
     * @param id: id del cliente para ser buscado.
     * @return el cliente solicitado por medio de su id.
     */
    public ClienteEntity getCliente(Long id) {
        LOGGER.log(Level.INFO, "Inicia proceso de busqueda de cliente con id={0}", id);
        ClienteEntity entity = persistence.find(id);
        if(entity == null) {
            LOGGER.log(Level.SEVERE, "El cliente con el id {0} no existe", id);
        }
        LOGGER.log(Level.INFO, "Termina proceso de busqueda de cliente con id={0}", id);
        return entity;
    }
    
    public ClienteEntity updateCliente(ClienteEntity entity) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "Inicia el proceso de actualizacion de un cliente con id={0}", entity.getId());
        if( persistence.find(entity.getId()) == null ) {
            throw new BusinessLogicException("No existe un Cliente con la cedula \"" + entity.getCedula() + "\"");
        }
        LOGGER.log(Level.INFO, "Termina el proceso de actualizacion de un cliente con id={0}", entity.getId());
        return persistence.update(entity);
    }
    
    public void deleteCliente(ClienteEntity entity) throws BusinessLogicException {
        if(persistence.find(entity.getId()) == null) {
            throw new BusinessLogicException("No existe un cliente con la cedula \"" + entity.getCedula() + "\"");
        }
        LOGGER.log(Level.INFO, "Inicia proceso de borrar un cliente con id={0}", entity.getId());
        persistence.delete(entity.getId());
        LOGGER.log(Level.INFO, "Termina proceso de borrar un cliente con id={0}", entity.getId());
    }
    
}
