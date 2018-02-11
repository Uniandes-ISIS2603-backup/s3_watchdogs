/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.watchdogs.dtos;

import co.edu.uniandes.csw.watchdogs.entities.EntrenamientoEntity;

/**
 *
 * @author c.martinezc1
 */
public class EntrenamientoDetailDTO extends EntrenamientoDTO{
    
    /**
     * Constructor
     */
    public EntrenamientoDetailDTO() {
        super();
    }
    
    public EntrenamientoDetailDTO(EntrenamientoEntity entity){
        super(entity);
    }

    /**
     * 
     * @return 
     */
    @Override
    public EntrenamientoEntity toEntity(){
        EntrenamientoEntity entity = super.toEntity();
        return entity;
    }
}