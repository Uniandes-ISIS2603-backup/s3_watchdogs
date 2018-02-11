/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.watchdogs.dtos;

import co.edu.uniandes.csw.watchdogs.entities.TransporteEntity;

/**
 *
 * @author c.martinezc1
 */
public class TransporteDetailDTO extends TransporteDTO{
    
    /**
     *
     * @param entity
     */
    public TransporteDetailDTO(TransporteEntity entity){
        super(entity);
    }

    public TransporteDetailDTO() {
    }
    
    @Override
    public TransporteEntity toEntity(){
        TransporteEntity entity = super.toEntity();
        return entity;
    }
}
