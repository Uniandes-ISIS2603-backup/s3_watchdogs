/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.watchdogs.ejb;

import co.edu.uniandes.csw.watchdogs.entities.ClienteEntity;
import co.edu.uniandes.csw.watchdogs.entities.TarjetaCreditoEntity;
import co.edu.uniandes.csw.watchdogs.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.watchdogs.persistence.TarjetaCreditoPersistence;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author jc.pulido
 */
@Stateless
public class TarjetaCreditoLogic {

    private static final Logger LOGGER = Logger.getLogger(TarjetaCreditoLogic.class.getName());

    @Inject
    private TarjetaCreditoPersistence persistence;

    @Inject
    private ClienteLogic clienteLogic;

    public TarjetaCreditoEntity createTarjeta(Long idCliente ,TarjetaCreditoEntity entity) throws BusinessLogicException {
        LOGGER.info("Inicia proceso de creación de una tarjeta " + entity.getNumeroTarjeta());
        validateDate(entity.getFechaVencimiento());
        validateNum(entity.getNumeroTarjeta());
        ClienteEntity cliente = clienteLogic.getCliente(idCliente);
        entity.setCliente(cliente);
        return persistence.create(entity);
    }

    public TarjetaCreditoEntity updateTarjeta(Long id, TarjetaCreditoEntity entity) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "Inicia proceso de actualización de tarjeta con id{0}", id);
        validateDate(entity.getFechaVencimiento());
        validateNum(entity.getNumeroTarjeta());
        ClienteEntity cliente = clienteLogic.getCliente(id);
        entity.setCliente(cliente);
        LOGGER.log(Level.INFO, "termina proceso de actualización de tarjeta con id{0}", entity.getId());
        return persistence.update(entity);
    }

    public void deleteTarjeta(Long clienteId,Long id) {
        LOGGER.log(Level.INFO, "Inicia proceso de borrar tarjeta con id={0}", id);
        TarjetaCreditoEntity old = getTarjeta(clienteId, id);
        persistence.delete(old.getId());
    }

    public TarjetaCreditoEntity getTarjeta(Long idCliente,Long id) {
        LOGGER.log(Level.INFO, "Inicia proceso para obtener una tarjeta", id);
        TarjetaCreditoEntity tarjeta = persistence.find(idCliente,id);
        if (tarjeta == null) {
            LOGGER.log(Level.SEVERE, "La tarjeta con el id {0} no existe", id);
        }
        LOGGER.log(Level.INFO, "Termina e proceso de consultar una tarjeta con el id {0}", id);
        return tarjeta;
    }

    public List<TarjetaCreditoEntity> getTarjetas(Long idCliente) throws BusinessLogicException {
        ClienteEntity cliente = clienteLogic.getCliente(idCliente);
        if(cliente.getTarjetas()==null){
            throw new BusinessLogicException("El cliente que consulta aun no tiene tarjetas de credito asociadas");
        }
        if(cliente.getTarjetas().isEmpty()){
            throw new BusinessLogicException("El cliente que consulta aun no tiene tarjetas de credito asociadas");
        }
        return cliente.getTarjetas();
    }

    private void validateNum(String pNum) throws BusinessLogicException {
        //LOGGER.info(pNum + "mirar aquiiiiiiii-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        if (pNum.length() != 16) {
            throw new BusinessLogicException("El número de la tarjeta debe tener 16 dígitos fue" + pNum.length());
        }

        String pr = pNum.substring(0, 4);
        String se = pNum.substring(4, 8);
        String te = pNum.substring(8, 12);
        String cu = pNum.substring(12, 15);

        try {
            Integer.parseInt(pr);
            Integer.parseInt(se);
            Integer.parseInt(te);
            Integer.parseInt(cu);
        } catch (Exception e) {
            throw new BusinessLogicException("El número de la tarjeta debe contener solo dígitos");
        }

    }

    private void validateDate(Date date) throws BusinessLogicException {
        if (date.before(Calendar.getInstance().getTime())) {
            throw new BusinessLogicException("La tarjeta ya se venció");
        }
    }

}
