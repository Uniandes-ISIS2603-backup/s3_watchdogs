/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.watchdogs.ejb;

import co.edu.uniandes.csw.watchdogs.persistence.VeterinariaPersistence;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author js.vacat
 */
@Stateless
public class VeterinariaLogic {
    
    private static final Logger LOGGER = Logger.getLogger(VeterinariaLogic.class.getName());
    
    @Inject
    private VeterinariaPersistence persistence;
    
    @Inject
    private EntrenamientoLogic entrenamientoLogic;
    
    @Inject
    private HotelLogic hotelLogic;
}
