/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.watchdogs.dtos;

import co.edu.uniandes.csw.watchdogs.entities.LugarEntity;

/**
 *
 * @author js.vacat
 */
public abstract class LugarDetailDTO extends LugarDTO{
    
   /**
     * Constructor por defecto
     */
    public LugarDetailDTO( ) {
    } 
    
    /**
     * Constructor para transformar un Entity a un DTO
     * 
     * @param entity La entidad del Lugar de la cual se construye el objeto
     */
    public LugarDetailDTO(LugarEntity entity){
        super(entity);
    }
    
     /**
     * Transformar un DTO a un Entity
     * 
     * @return La entidad construida a partir del DTO
     */
    @Override
    public LugarEntity toEntity() {
        LugarEntity empleadoE = super.toEntity();
        return empleadoE;
    }
}
