/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.watchdogs.ejb;

import co.edu.uniandes.csw.watchdogs.entities.ClienteEntity;
import co.edu.uniandes.csw.watchdogs.entities.PseEntity;
import co.edu.uniandes.csw.watchdogs.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.watchdogs.persistence.PsePersistence;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author mac
 */
@Stateless
public class PseLogic {

    private static final Logger LOGGER = Logger.getLogger(PseLogic.class.getName());

    @Inject
    private PsePersistence persistence;

    @Inject
    private ClienteLogic clienteLogic;

    public PseEntity createPse(Long idCliente, PseEntity entity) throws BusinessLogicException {
        LOGGER.info("Inicia proceso de creacion de un PSE");
        validateEmail(entity.getCorreo());
        ClienteEntity cliente = clienteLogic.getCliente(idCliente);
        entity.setCliente(cliente);
        return persistence.create(entity);
    }

    public PseEntity getPse(Long clienteId, Long id) {
        return persistence.find(clienteId, id);
    }

    public List<PseEntity> getPses(Long idCliente) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar todos los pse");
        ClienteEntity cliente = clienteLogic.getCliente(idCliente);
        if (cliente.getPses() == null) {
            throw new BusinessLogicException("El cliente que consulta aun no tiene cuentas de pse");
        }
        if (cliente.getPses().isEmpty()) {
            throw new BusinessLogicException("El cliente que consulta aun no tiene cuentas de pse asociadas");
        }
        return cliente.getPses();
    }

    public PseEntity updateEntity(Long id, PseEntity entity) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "Inicia proceso de actualizar PSE con id = {0}", id);
        validateEmail(entity.getCorreo());
        ClienteEntity cliente = clienteLogic.getCliente(id);
        entity.setCliente(cliente);
        return persistence.update(entity);
    }

    public void deletePse(Long clienteId, Long id) {
        LOGGER.log(Level.INFO, "Inicia proceso de borrar PSE con id = {0}", id);
        PseEntity old = getPse(clienteId, id);
        persistence.delete(old.getId());
    }

    private void validateEmail(String correo) throws BusinessLogicException {
        if (!correo.contains("@")) {
            throw new BusinessLogicException("El correo no es valido");
        }
        if (correo.split("@")[0].length() < 1) {
            throw new BusinessLogicException("El correo de es valido");
        }
    }
}
