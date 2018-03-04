/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.watchdogs.ejb;

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
    
    
    public List<PayPalEntity> getPayPals()
    {
        LOGGER.info("Inicia proceso de consultar todos los PayPals");
        List<PayPalEntity> paypals = persistence.findAll();
        LOGGER.info("Termina proceso de consultar todos lso libros");
        return paypals;
    }
    
    public PayPalEntity getPayPal(Long id)
    {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar un PayPal con id = {0}", id);
        PayPalEntity payPal = persistence.find(id);
        if(payPal == null)
        {
            LOGGER.log(Level.SEVERE, "El paypal con el id {0} no existe", id);
        }
        LOGGER.log(Level.INFO,"Termina proceso de consultar paypal con id = {0}", id);
        return payPal;
    }
    
    public PayPalEntity updateEntity(Long id, PayPalEntity entity) throws BusinessLogicException
    {
        LOGGER.log(Level.INFO, "Inicia proceso de actualizar PayPal con id = {0}", id);
        return persistence.update(entity);
    }
    
    public void deletePayPal(Long id)
    {
        LOGGER.log(Level.INFO, "Inicia proceso de borrar PayPal con id = {0}", id);
        persistence.delete(id);
        LOGGER.log(Level.INFO, "Termina proceso de borrar PayPal con id {0}", id);
    }
    
    public PayPalEntity createPse(PayPalEntity entity)throws BusinessLogicException
    {
        LOGGER.info("Inicia proceso de creacion de un PayPal");
        validateEmail(entity.getCorreo());
        persistence.create(entity);
        LOGGER.info("Termina proceso de creacion de PSE");
        return entity;
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
