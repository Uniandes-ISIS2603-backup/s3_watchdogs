/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.watchdogs.podam;

import co.edu.uniandes.csw.watchdogs.entities.Estado;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;
import uk.co.jemos.podam.common.AttributeStrategy;
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
        
        PodamFactory factory = new PodamFactoryImpl();
        Estado[] rta = new Estado[12];
        
        for(int i =0; i < rta.length; i++){
            
            rta[i] = Estado.values()[(int)Math.random()*3];
        } 
       
        //TODO Es legítimo usa un Math.Random??
       
        return rta;
    }
    
}