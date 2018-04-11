/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.watchdogs.ejb;

import co.edu.uniandes.csw.watchdogs.entities.ClienteEntity;
import co.edu.uniandes.csw.watchdogs.entities.MascotaEntity;
import co.edu.uniandes.csw.watchdogs.entities.ServicioEntity;
import co.edu.uniandes.csw.watchdogs.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.watchdogs.persistence.MascotaPersistence;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * Clase que implementa la conexion con a persistencia para la entidad Mascota.
 *
 * @author ca.beltran10
 */
@Stateless
public class MascotaLogic {

    private static final Logger LOGGER = Logger.getLogger(MascotaLogic.class.getName());

    @Inject
    private MascotaPersistence persistence;

    @Inject
    private ClienteLogic clienteLogic;

    /**
     * Crea una mascota en la persistencia.
     *
     * @param entity La entidad que representa la mascota a persistir.
     * @return La entidad de la mascota luedo de persistirla.
     * @throws BusinessLogicException Si la mascota a persistir ya existe.
     */
    public MascotaEntity createMascota(MascotaEntity entity) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "Inicia proceso de creacion de mascota");
        LOGGER.log(Level.INFO, "Termina proceso de creacion de mascota");
        return persistence.create(entity);
    }

    /**
     * Obtener todas las mascotas existentes en la base de datos.
     *
     * @return una lista de mascotas.
     */
    public List<MascotaEntity> getMascotas() {
        LOGGER.info("Inicia proceso de consultar todas las mascotas");
        List<MascotaEntity> mascotas = persistence.findAll();
        LOGGER.info("Termina proceso de consultar las mascotas");
        return mascotas;
    }

    /**
     * Obtener una mascota por medio de su id.
     *
     * @param id: id de la mascota para ser buscada.
     * @return la mascota solicitada por medio de su id.
     */
    public MascotaEntity getMascota(Long id) {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar mascota con id ={0}", id);
        MascotaEntity mascota = persistence.find(id);
        if (mascota == null) {
            LOGGER.log(Level.SEVERE, "La mascota con el id {0} no existe", id);
        }
        LOGGER.log(Level.INFO, "Termina proceso de consultar mascota con id={0}", id);
        return mascota;
    }

    /**
     * Actualizar una mascota.
     *
     * @param id: id de la mascota para buscarla en la base de datos.
     * @param entity: mascota con los cambios para ser actualizada, por ejemplo
     * el nombre.
     * @return la mascota con los cambios actualizados en la base de datos.
     */
    public MascotaEntity updateMascota(Long id, MascotaEntity entity) {
        LOGGER.log(Level.INFO, "Inicia proceso de actualizar mascta con id={0}", id);
        MascotaEntity newEntity = persistence.update(entity);
        LOGGER.log(Level.INFO, "Termina proceso de actualizar mascota con id={0}", id);
        return newEntity;
    }

    /**
     * Borrar una mascota.
     *
     * @param id: id de la mascota a borrar.
     * @throws BusinessLogicException Si la mascota tiene servicios.
     */
    public void deleteMascota(Long id) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "Inicia proceso de borrar mascota con id={0}", id);
        ServicioEntity servicio = getServicio(id);
        if (servicio == null) {
            persistence.delete(id);
        } else {
            throw new BusinessLogicException("No se puede borrar la mascota con id " + id + " porque tiene servicios asociados.");
        }
        LOGGER.log(Level.INFO, "Termina proceso de borrar mascota con id={0}", id);
    }

    /**
     * Agrega un cliente a la mascota.
     *
     * @param clienteId El id del cliente a guardar.
     * @param mascotaId El id de la mascota en la que se va a guardar el
     * cliente.
     * @return El cliente que fue agregado a la mascota.
     */
    public ClienteEntity addCliente(Long clienteId, Long mascotaId) throws BusinessLogicException {
        MascotaEntity mascotaEntity = getMascota(mascotaId);
        ClienteEntity clienteEntity = clienteLogic.getCliente(clienteId);
        List<MascotaEntity> lista = clienteEntity.getMascotas();
        lista.add(mascotaEntity);
        clienteEntity.setMascotas(lista);
        return clienteEntity;
    }

    /**
     * Borrar un cliente de una mascota.
     *
     * @param clienteId El cliente que se desea borrar de la mascota.
     * @param mascotaId La mascota de la cual se desea eliminar.
     */
    public void removeCliente(Long clienteId, Long mascotaId) throws BusinessLogicException {
        MascotaEntity mascotaEntity = getMascota(mascotaId);
        ClienteEntity cliente = clienteLogic.getCliente(clienteId);
        List<MascotaEntity> lista = cliente.getMascotas();
        lista.remove(mascotaEntity);
        cliente.setMascotas(lista);
        mascotaEntity.setCliente(null);
    }

    /**
     * Retorna el clientee asociado a la mascota.
     *
     * @param mascotaId El id de la mascota buscada.
     * @return El cliente de la mascota.
     */
    public ClienteEntity getCliente(Long mascotaId) {
        return getMascota(mascotaId).getCliente();
    }

    /**
     * Obtiene una instancia de ServicioEntity asociadas a una Mascota.
     *
     * @param id: Identificador de la instancia Mascota.
     * @return Instancia de ServicioEntity asociada a la instancia de Mascota.
     */
    public ServicioEntity getServicio(Long id) {
        return getMascota(id).getServicio();
    }

}
