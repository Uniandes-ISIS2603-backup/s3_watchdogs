/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.watchdogs.ejb;

import co.edu.uniandes.csw.watchdogs.entities.ClienteEntity;
import co.edu.uniandes.csw.watchdogs.entities.PayPalEntity;
import co.edu.uniandes.csw.watchdogs.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.watchdogs.persistence.PayPalPersistence;
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
public class PayPalLogic {
    
    private static final Logger LOGGER = Logger.getLogger(PayPalLogic.class.getName());
    
    @Inject
    private PayPalPersistence persistence;
    
    @Inject
    private ClienteLogic clienteLogic;
    
    
    public List<PayPalEntity> getPayPals(Long idCliente) throws BusinessLogicException
    {
        LOGGER.info("Inicia proceso de consultar todos los PayPals");
        ClienteEntity cliente = clienteLogic.getCliente(idCliente);
        if(cliente.getPayPals()==null){
            throw new BusinessLogicException("El cliente que consulta aun no tiene cuentas de paypal");
        }
        if(cliente.getPayPals().isEmpty()){
            throw new BusinessLogicException("El cliente que consulta aun no tiene cuentas de paypal asociadas");
        }
        return cliente.getPayPals();
    }
    
    public PayPalEntity getPayPal(Long clienteId ,Long id)
    {
        return persistence.find(clienteId, id);
    }
    
    public PayPalEntity updateEntity(Long id, PayPalEntity entity) throws BusinessLogicException
    {
        LOGGER.log(Level.INFO, "Inicia proceso de actualizar PayPal con id = {0}", id);
        return persistence.update(entity);
    }
    
    public void deletePayPal(Long clienteId,Long id)
    {
        LOGGER.log(Level.INFO, "Inicia proceso de borrar PayPal con id = {0}", id);
        PayPalEntity old = getPayPal(clienteId, id);
        persistence.delete(old.getId());
    }
    
    public PayPalEntity createPayPal(Long idCliente, PayPalEntity entity)throws BusinessLogicException
    {
        LOGGER.info("Inicia proceso de creacion de un PayPal");
        validateEmail(entity.getCorreo());
        ClienteEntity cliente = clienteLogic.getCliente(idCliente);
        entity.setCliente(cliente);
        return persistence.create(entity);

    }
    
     private void validateEmail(String correo) throws BusinessLogicException {
        if(!correo.contains("@"))
        {
            throw new BusinessLogicException("El correo no es valido");
        }
        if(correo.split("@")[0].length() < 1)
        {
            throw new BusinessLogicException("El correo de es valido");
        }
    }
    
}
