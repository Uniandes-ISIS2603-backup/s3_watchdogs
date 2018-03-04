/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.watchdogs.ejb;

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
    
    public PseEntity createPse(PseEntity entity)throws BusinessLogicException
    {
        LOGGER.info("Inicia proceso de creacion de un PSE");
        validateEmail(entity.getCorreo());
        persistence.create(entity);
        LOGGER.info("Termina proceso de creacion de PSE");
        return entity;
    }
    
    public PseEntity getPse(Long id)
    {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar un autor con id = {0}", id);
        PseEntity pse = persistence.find(id);
        if(pse == null)
        {
            
            LOGGER.log(Level.SEVERE, "El pse con el id {0} no existe", id);

        }
            LOGGER.log(Level.INFO, "Termina proceso de consultar pse con id={0}", id);
            return pse;
    }
    
    public List<PseEntity> getPses()
    {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar todos los pse");
        return persistence.findAll();
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
