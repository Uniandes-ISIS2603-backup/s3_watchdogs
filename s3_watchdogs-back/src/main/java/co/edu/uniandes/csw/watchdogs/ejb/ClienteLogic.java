/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.watchdogs.ejb;

import co.edu.uniandes.csw.watchdogs.entities.ClienteEntity;
import co.edu.uniandes.csw.watchdogs.entities.FacturaEntity;
import co.edu.uniandes.csw.watchdogs.entities.MascotaEntity;
import co.edu.uniandes.csw.watchdogs.entities.ServicioEntity;
import co.edu.uniandes.csw.watchdogs.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.watchdogs.persistence.ClientePersistence;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * Clase que implementa la conexion con la persistencia para la entidad Cliente.
 *
 * @author ca.beltran10
 */
@Stateless
public class ClienteLogic {

    private static final Logger LOGGER = Logger.getLogger(ClienteLogic.class.getName());

    @Inject
    private ClientePersistence persistence;

    @Inject
    private MascotaLogic mascotaLogic;

    @Inject
    private FacturaLogic facturaLogic;

    /**
     * Crea un cliente en la persistencia.
     *
     * @param entity La entidad que representa el cliente a persistir.
     * @return La entidad del cliente luego de persistirla.
     * @throws BusinessLogicException Si el cliente a persistir ya existe.
     */
    public ClienteEntity createCliente(ClienteEntity entity) throws BusinessLogicException {
        LOGGER.info("Inicia proceso de creacion de cliente");
        if (persistence.findByCedula(entity.getCedula()) != null) {
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
        if (entity == null) {
            LOGGER.log(Level.SEVERE, "El cliente con el id {0} no existe", id);
        }
        LOGGER.log(Level.INFO, "Termina proceso de busqueda de cliente con id={0}", id);
        return entity;
    }

    /**
     * Actualizar un cliente.
     *
     * @param id: id del cliente para buscarlo en la base de datos.
     * @param entity: cliente con los cambios para ser actualizado, por ejemplo
     * nombre.
     * @return el cliente con los cambios actualizados en la base de datos.
     */
    public ClienteEntity updateCliente(Long id, ClienteEntity entity) {
        LOGGER.log(Level.INFO, "Inicia el proceso de actualizacion de un cliente con id={0}", id);
        if (persistence.find(id) == null) {
            LOGGER.log(Level.SEVERE, "El cliente con el id {0} no existe", id);
        }
        LOGGER.log(Level.INFO, "Termina el proceso de actualizacion de un cliente con id={0}", id);
        return persistence.update(entity);
    }

    /**
     * Borra un cliente.
     *
     * @param id: id del cliente a borrar.
     * @throws BusinessLogicException Si el cliente a eliminar tiene facturas
     * pendientes.
     */
    public void deleteCliente(Long id) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "Inicia proceso de borrar cliente con id={0}", id);
        List<FacturaEntity> facturas = getFacturas(id);
        if (facturas == null) {
            persistence.delete(id);
        } else {
            boolean deuda = false;
            for (FacturaEntity facturaActual : facturas) {
                if (!facturaActual.getPagado()) {
                    deuda = true;
                }
            }
            if (!deuda) {
                persistence.delete(id);
            } else {
                throw new BusinessLogicException("No se puede borrar el cliente con id " + id + " porque tiene facturas pendientes.");
            }
        }
        LOGGER.log(Level.INFO, "Termina proceso de borrar un cliente con id={0}", id);
    }

    /**
     * Agregar una factura a un cliente.
     *
     * @param facturaId El id de la factura a guardar.
     * @param clienteId El id del cliente en el cual se va a guardar la factura.
     * @return La factura que fue guardada al cliente.
     */
    public FacturaEntity addFactura(Long facturaId, Long clienteId) {
        ClienteEntity clienteEntity = getCliente(clienteId);
        FacturaEntity facturaEntity = facturaLogic.getFactura(facturaId);
        facturaEntity.setCliente(clienteEntity);
        return facturaEntity;
    }

    /**
     * Borra una factura de un cliente.
     *
     * @param facturaId El id de la factura que se desea borrar del cliente.
     * @param clienteId El id del clente del cual se desea eliminar.
     */
    public void removeFactura(Long facturaId, Long clienteId) {
        ClienteEntity clienteEntity = getCliente(clienteId);
        FacturaEntity factura = facturaLogic.getFactura(facturaId);
        factura.setCliente(null);
        clienteEntity.getFacturas().remove(factura);
    }

    /**
     * Agregar una mascota al cliente.
     *
     * @param mascotaId El id de la mascota a guardar.
     * @param clienteId El id del cliente en el cual se va a guardar la mascota.
     * @return La mascota que fue agregada al cliente.
     */
    public MascotaEntity addMascota(Long mascotaId, Long clienteId) {
        ClienteEntity clienteEntity = getCliente(clienteId);
        MascotaEntity mascotaEntity = mascotaLogic.getMascota(mascotaId);
        mascotaEntity.setCliente(clienteEntity);
        return mascotaEntity;
    }

    /**
     * Borra una mascota de un cliente.
     *
     * @param mascotaId El id de la mascota que se dea borrar del cliente.
     * @param clienteId El id del cliente del cual se desea eliminar.
     */
    public void removeMascota(Long mascotaId, Long clienteId) {
        ClienteEntity clienteEntity = getCliente(clienteId);
        MascotaEntity mascota = mascotaLogic.getMascota(mascotaId);
        mascota.setCliente(null);
        clienteEntity.getMascotas().remove(mascota);
    }

    /**
     * Retorna todas las facturas asociadas a un cliente.
     *
     * @param clienteId El id del cliente buscado.
     * @return La lista de facturas del cliente.
     */
    public List<FacturaEntity> getFacturas(Long clienteId) {
        return getCliente(clienteId).getFacturas();
    }

    /**
     * Retorna todos los servicios asociados a un cliente.
     *
     * @param clienteId El id del cliente buscado.
     * @return La lista de servicios del cliente.
     */
    public List<ServicioEntity> getServicios(Long clienteId) {
        return getCliente(clienteId).getServicios();
    }
}
