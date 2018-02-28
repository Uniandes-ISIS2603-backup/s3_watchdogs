/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.watchdogs.ejb;

import co.edu.uniandes.csw.watchdogs.entities.TarjetaCreditoEntity;
import co.edu.uniandes.csw.watchdogs.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.watchdogs.persistence.TarjetaCreditoPersistence;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;


/**
 *
 * @author jc.pulido
 */
@Stateless
public class TarjetaCreditoLogic {
    
    private static final Logger LOGGER = Logger.getLogger(TarjetaCreditoLogic.class.getName());
    
    @Inject 
    private TarjetaCreditoPersistence persistence;
    
    public TarjetaCreditoEntity createTarjeta(TarjetaCreditoEntity entity) throws BusinessLogicException
    {
        LOGGER.info("Inicia proceso de creación de una tarjeta");
        validateDate(entity.getFechaVencimiento());
        validateNum(entity.getNumeroTarjeta());
        persistence.create(entity);
        LOGGER.info("Termina proceso de creación de tarjeta");
        return entity;
    }
    
    public TarjetaCreditoEntity updateTarjeta(Long id, TarjetaCreditoEntity entity)throws BusinessLogicException
    {
        LOGGER.log(Level.INFO, "Inicia proceso de actualización de tarjeta con id{0}", id);
        validateDate(entity.getFechaVencimiento());
        validateNum(entity.getNumeroTarjeta());
        TarjetaCreditoEntity newEntity = persistence.update(entity);
        LOGGER.log(Level.INFO, "termina proceso de actualización de tarjeta con id{0}", entity.getId());
        return newEntity;
    }
    
    public void deleteTarjeta(Long id)
    {
        LOGGER.log(Level.INFO, "Inicia proceso de borrar tarjeta con id={0}", id);
        persistence.delete(id);
        LOGGER.log(Level.INFO, "Termina proceso de borrar tarjeta con id={0}", id);
    }
    
    public TarjetaCreditoEntity getTarjeta(Long id)
    {
        LOGGER.log(Level.INFO, "Inicia proceso para obtener una tarjeta", id);
        TarjetaCreditoEntity tarjeta = persistence.find(id);
        if(tarjeta == null)
        {
            LOGGER.log(Level.SEVERE, "La tarjeta con el id {0} no existe", id);
        }
        LOGGER.log(Level.INFO, "Termina e proceso de consultar una tarjeta con el id {0}", id);
        return tarjeta;
    }
    
    public List<TarjetaCreditoEntity> getTarjetas(){
        LOGGER.info("Inicia proceso de consultar todas las tarjetas");
        List<TarjetaCreditoEntity> tarjetas = persistence.findAll();
        LOGGER.info("Termina proceso de consultar todas las tarjetas");
        return tarjetas;
    }
    
    private void validateNum(String pNum) throws BusinessLogicException
    {
        if(pNum.length()!= 16)
        {
            throw new BusinessLogicException("El número de la tarjeta debe tener 16 dígitos");
        }
       
        String pr = pNum.substring(0, 4);
        String se = pNum.substring(4, 8);
        String te = pNum.substring(8, 12);
        String cu = pNum.substring(12,15);
        
        try{
            Integer.parseInt(pr);
            Integer.parseInt(se);
            Integer.parseInt(te);
            Integer.parseInt(cu);
        }
        catch(Exception e)
        {
            throw new BusinessLogicException("El número de la tarjeta debe contener solo dígitos");
        }
        
    }
    
    private void validateDate(String date) throws BusinessLogicException
    {
        String[] fecha = date.split("/");
        Date vencimientoTarjeta = new Date(Integer.parseInt(fecha[1]), Integer.parseInt(fecha[0]), 0);
        if(!vencimientoTarjeta.after(Calendar.getInstance().getTime()))
        {
           throw new BusinessLogicException("La tarjeta ya se venció");
        }
    }
    
    
}
