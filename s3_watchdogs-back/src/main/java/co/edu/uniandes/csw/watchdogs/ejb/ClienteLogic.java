/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.watchdogs.ejb;

import co.edu.uniandes.csw.watchdogs.entities.ClienteEntity;
import co.edu.uniandes.csw.watchdogs.entities.FacturaEntity;
import co.edu.uniandes.csw.watchdogs.entities.MascotaEntity;
import co.edu.uniandes.csw.watchdogs.entities.PayPalEntity;
import co.edu.uniandes.csw.watchdogs.entities.ServicioEntity;
import co.edu.uniandes.csw.watchdogs.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.watchdogs.persistence.ClientePersistence;
import java.util.ArrayList;
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

    /**
     * Constante que representa el Logger de la logica.
     */
    private static final Logger LOGGER = Logger.getLogger(ClienteLogic.class.getName());

    /**
     * Conexion con la persistencia del cliente.
     */
    @Inject
    private ClientePersistence persistence;

    /**
     * Conexion con la logica de la factura.
     */
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
        LOGGER.info("Termina proceso de creacion de cliente");
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
    public ClienteEntity getCliente(Long id) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "Inicia proceso de busqueda de cliente con id={0}", id);
        ClienteEntity entity = persistence.find(id);
        if (entity == null) {
            LOGGER.log(Level.SEVERE, "El cliente con el id {0} no existe", id);
            throw new BusinessLogicException("No existe un cliente con id \"" + id + "\"");
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

        ClienteEntity newEntity = persistence.update(entity);
        LOGGER.log(Level.INFO, "Termina el proceso de actualizacion de un cliente con id={0}", entity.getId());
        return newEntity;
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
        if (getCliente(id) == null) {
            throw new BusinessLogicException("No se puede borrar el cliente con el id: " + id + " porque no existe.");
        }
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
    public FacturaEntity addFactura(Long facturaId, Long clienteId) throws BusinessLogicException {
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
    public void removeFactura(Long facturaId, Long clienteId) throws BusinessLogicException {
        ClienteEntity clienteEntity = getCliente(clienteId);
        FacturaEntity factura = facturaLogic.getFactura(facturaId);
        factura.setCliente(null);
        clienteEntity.getFacturas().remove(factura);
    }

    /**
     * Retorna todas las facturas asociadas a un cliente.
     *
     * @param clienteId El id del cliente buscado.
     * @return La lista de facturas del cliente.
     * @throws co.edu.uniandes.csw.watchdogs.exceptions.BusinessLogicException
     */
    public List<FacturaEntity> getFacturas(Long clienteId) throws BusinessLogicException {
        return getCliente(clienteId).getFacturas();
    }

    /**
     * Retorna todos los servicios asociados a un cliente.
     *
     * @param clienteId El id del cliente buscado.
     * @return La lista de servicios del cliente.
     * @throws co.edu.uniandes.csw.watchdogs.exceptions.BusinessLogicException
     */
    public List<ServicioEntity> getServicios(Long clienteId) throws BusinessLogicException {
        ClienteEntity cliente = getCliente(clienteId);
        return cliente.getServicios();
    }

    public ServicioEntity getServicio(Long clienteId, Long servicioId) throws BusinessLogicException {

        List<ServicioEntity> list = getCliente(clienteId).getServicios();
        ServicioEntity serviciosEntity = new ServicioEntity();
        serviciosEntity.setId(servicioId);
        for (ServicioEntity servicio : list) {
            if (servicio.getId().equals(servicioId)) {
                return servicio;
            }
        }
        return null;

    }

    public List<PayPalEntity> listPayPal(Long clienteId) {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar todos los payPal del cliente con id = {0}", clienteId);
        List<PayPalEntity> payPals = new ArrayList<>();
        try {
            payPals = getCliente(clienteId).getPayPals();
        } catch (BusinessLogicException ex) {
            Logger.getLogger(ClienteLogic.class.getName()).log(Level.SEVERE, null, ex);
        }
        return payPals;
    }

    public PayPalEntity getPayPal(Long clienteId, Long payPalId) {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar un payPal del cliente con id = {0}", clienteId);
        List<PayPalEntity> list = new ArrayList<>();
        try {
            list = getCliente(clienteId).getPayPals();
        } catch (BusinessLogicException ex) {
            Logger.getLogger(ClienteLogic.class.getName()).log(Level.SEVERE, null, ex);
        }
        PayPalEntity payPalEntity = new PayPalEntity();
        payPalEntity.setId(payPalId);
        int index = list.indexOf(payPalEntity);
        if (index >= 0) {
            return list.get(index);
        }
        return null;
    }

    public PayPalEntity addPayPal(Long clienteId, Long payPalId) {
        LOGGER.log(Level.INFO, "Inicia proceso de asociar una cuenta de PayPal al cliente con id = {0}", clienteId);
        try {
            ClienteEntity clienteEntity = getCliente(clienteId);
            PayPalEntity payPalEntity = new PayPalEntity();
            payPalEntity.setId(payPalId);
            clienteEntity.getPayPals().add(payPalEntity);
            return getPayPal(clienteId, payPalId);
        } catch (BusinessLogicException ex) {
            Logger.getLogger(ClienteLogic.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    public void removePayPal(Long clienteId, Long payPalId) {
        try {
            LOGGER.log(Level.INFO, "Inicia proceso de borrar un payPal del cliente con id = {0}", clienteId);
            ClienteEntity entity = getCliente(clienteId);
            PayPalEntity payPalEntity = new PayPalEntity();
            payPalEntity.setId(payPalId);
            entity.getPayPals().remove(payPalEntity);
        } catch (BusinessLogicException ex) {
            Logger.getLogger(ClienteLogic.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<MascotaEntity> listMascotas(Long clienteId) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar todos las mascotas del cliente con id = {0}", clienteId);
        return getCliente(clienteId).getMascotas();
    }

    public MascotaEntity getMascota(Long clientesId, Long mascotasId) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar una mascota del cliente con id = {0}", clientesId);
        List<MascotaEntity> list = getCliente(clientesId).getMascotas();
        MascotaEntity mascotaEntity = new MascotaEntity();
        mascotaEntity.setId(mascotasId);
        int index = list.indexOf(mascotaEntity);
        if (index >= 0) {
            return list.get(index);
        }
        return null;
    }

    public MascotaEntity addMascota(Long clientesId, Long mascotasId) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "Inicia proceso de asociar una mascota al cliente con id = {0}", clientesId);
        ClienteEntity clienteEntity = getCliente(clientesId);
        MascotaEntity mascotaEntity = new MascotaEntity();
        mascotaEntity.setId(mascotasId);
        clienteEntity.getMascotas().add(mascotaEntity);
        return getMascota(clientesId, mascotasId);
    }

    public void removeMascota(Long clientesId, Long mascotasId) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "Inicia proceso de borrar una mascota del cliente con id = {0}", clientesId);
        ClienteEntity entity = getCliente(clientesId);
        MascotaEntity mascotaEntity = new MascotaEntity();
        mascotaEntity.setId(mascotasId);
        entity.getMascotas().remove(mascotaEntity);
    }

}
