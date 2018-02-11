/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.watchdogs.dtos;

import co.edu.uniandes.csw.watchdogs.entities.ServicioEntity;

/**
 *
 * @author c.martinezc1
 */
public abstract class ServicioDetailDTO extends ServicioDTO{
    
    /**
     * Constructor por defecto
     * @param entity
     */
    public ServicioDetailDTO(ServicioEntity entity){
    super(entity);
    }
    
    
}
