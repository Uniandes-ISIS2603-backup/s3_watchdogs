/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.watchdogs.dtos;

import co.edu.uniandes.csw.watchdogs.entities.CalificacionEntity;

/**
 *
 * @author c.martinezc1
 */
public class CalificacionDetailDTO extends CalificacionDTO{
    
    public CalificacionDetailDTO(CalificacionEntity entity) {
        super(entity);
    }
    
    public CalificacionDetailDTO(){
    }

    @Override
    public CalificacionEntity toEntity(){
        CalificacionEntity entity = super.toEntity();
        return entity;
    }
}