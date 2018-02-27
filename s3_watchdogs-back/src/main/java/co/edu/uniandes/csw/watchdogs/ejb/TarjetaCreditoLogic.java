/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.watchdogs.ejb;

import co.edu.uniandes.csw.watchdogs.entities.TarjetaCreditoEntity;
import co.edu.uniandes.csw.watchdogs.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.watchdogs.persistence.TarjetaCreditoPersistence;
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
        if(persistence.find(entity.getId())!=null)
        {
            throw new BusinessLogicException("Ya existe una tarjeta con ese número registrada en el sistema");
        }
        return null;
    }
}
