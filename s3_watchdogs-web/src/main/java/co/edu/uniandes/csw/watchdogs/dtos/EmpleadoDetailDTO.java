/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.watchdogs.dtos;

import co.edu.uniandes.csw.watchdogs.entities.EmpleadoEntity;

/**
 *
 * @author ca.beltran10
 */
public class EmpleadoDetailDTO extends EmpleadoDTO{
    
    //----- Constructor -----
    
    /**
     * Constructor por defecto
     */
    public EmpleadoDetailDTO() {
    }
    
    /**
     * Constructo para transformar un Entity a un DTO
     * 
     * @param entity La entidad de empleado a partir de la cual se construira un objeto
     */
    public EmpleadoDetailDTO( EmpleadoEntity entity ) {
        super(entity);
    }
    
    /**
     * Transforamr un DTO a un Entity
     * 
     * @return La entidad construida a partir del DTO.
     */
    @Override
    public EmpleadoEntity toEntity() {
        EmpleadoEntity empleadoE = super.toEntity();
        return empleadoE;
    }
    
    
}
