/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.watchdogs.dtos;

import co.edu.uniandes.csw.watchdogs.entities.DisponibilidadEntity;

/**
 * Clase que extiende de {@link DisponibilidadDTO} para manejar la transformacion entre
 * los objetos JSON y las Entidades de la base de datos. Para conocer el
 * contenido de la ciudad vaya a la documentacion de {@link DisponibilidadDTO}
 * @author id.salazar
 */
public class DisponibilidadDetailDTO extends DisponibilidadDTO{
    
    
      /**
     * Constructor por defecto
     */
    
    public DisponibilidadDetailDTO(){
        
    }
    
    
    public DisponibilidadDetailDTO(DisponibilidadEntity entity){
        
        super(entity);
    }
    
  
    
}
