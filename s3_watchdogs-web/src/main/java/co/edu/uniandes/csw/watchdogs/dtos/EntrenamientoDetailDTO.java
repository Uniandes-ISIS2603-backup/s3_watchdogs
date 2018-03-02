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
    
    private CentroDeEntrenamientoDTO centroDeEntrenamiento;
    
    /**
     * Constructor por defecto
     */
    public EntrenamientoDetailDTO() {
        super();
    }
    
    /**
     * Constructor que recibe un entity
     * @param entity
     */
    public EntrenamientoDetailDTO(EntrenamientoEntity entity){
        super(entity);
        if(entity.getClass() != null){
            this.centroDeEntrenamiento = new CentroDeEntrenamientoDTO(entity.getCentroDeEntrenamiento());
        }
        else centroDeEntrenamiento = null;
        
    }
    
    public CentroDeEntrenamientoDTO getCentroDeEntrenamiento() {
        return centroDeEntrenamiento;
    }

    public void setCentroDeEntrenamiento(CentroDeEntrenamientoDTO centroDeEntrenamiento) {
        this.centroDeEntrenamiento = centroDeEntrenamiento;
    }
    
    

    /**
     * Metodo que convierte un DTO a ENtity
     * @return EntrenamientoEntity
     */
    @Override
    public EntrenamientoEntity toEntity(){
        EntrenamientoEntity entity = super.toEntity();
        entity.setCentroDeEntrenamiento(centroDeEntrenamiento.toEntity());
        return entity;
    }
}