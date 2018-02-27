/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.watchdogs.dtos;

import co.edu.uniandes.csw.watchdogs.entities.EmpleadoEntity;


/**
 * Clase que extiende de {@link EmpleadoDTO} para manejar la transformacion entre
 * los objetos JSON y las Entidades de la base de datos. Para conocer el
 * contenido de la ciudad vaya a la documentacion de {@link EmpleadoDTO}
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
     * Constructor para transformar un Entity a un DTO
     * 
     * @param entity La entidad del empleado de la cual se construye el objeto
     */
    public EmpleadoDetailDTO(EmpleadoEntity entity){
        super(entity);
    }
    
    /**
     * Transformar un DTO a un Entity
     * 
     * @return La entidad construida a partir del DTO
     */
    @Override
    public EmpleadoEntity toEntity() {
        EmpleadoEntity empleadoE = super.toEntity();
        return empleadoE;
    }
}
