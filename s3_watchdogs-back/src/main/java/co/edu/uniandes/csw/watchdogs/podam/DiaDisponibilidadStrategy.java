/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.watchdogs.podam;

import co.edu.uniandes.csw.watchdogs.entities.Estado;
import java.util.Random;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;
import uk.co.jemos.podam.common.AttributeStrategy;
import uk.co.jemos.podam.common.PodamIntValue;
import uk.co.jemos.podam.exceptions.PodamMockeryException;

/**
 *
 * @author id.salazar
 */
public class DiaDisponibilidadStrategy implements AttributeStrategy<Estado[]>{

    /**
     * 
     * Retorna un Arreglo que representa un día (12 horas) de Estado
     * 
     * {@inheritDoc}
     */
    
    
    public Estado[] getValue() throws PodamMockeryException{
        
        Estado[] rta = new Estado[12];
        Random newMachetazo = new Random();
        
        for(int i =0; i < rta.length; i++){     
            rta[i] = Estado.values()[newMachetazo.nextInt(3)];
        } 
       
        return rta;
    }
    
}