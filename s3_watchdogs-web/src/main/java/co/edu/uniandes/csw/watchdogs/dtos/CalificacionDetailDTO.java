/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.watchdogs.dtos;

import co.edu.uniandes.csw.watchdogs.entities.CalificacionEntity;
import co.edu.uniandes.csw.watchdogs.entities.EntrenamientoEntity;


/**
 *
 * @author c.martinezc1
 */
public class CalificacionDetailDTO extends CalificacionDTO{
    
    public CalificacionDetailDTO() {
        super();
    }
    
    public CalificacionDetailDTO(CalificacionEntity entity){
        super(entity);
        
    }
    
    @Override
    public CalificacionEntity toEntity(){
        CalificacionEntity entity = super.toEntity();
        return entity;
    }
   
}
