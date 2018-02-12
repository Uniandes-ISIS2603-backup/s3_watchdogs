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
public class EntrenamientoDTO extends ServicioDTO {
    
    
    /**
     * Atributo que representa el tipo de entrenamiento
     */
    private String tipo;
    
    /**
     * Constructor por defecto
     */
    public EntrenamientoDTO(){
        
    }
    
    /**
     * Constructor donde recibe un entity
     * @param entity
     */
    public EntrenamientoDTO(EntrenamientoEntity entity){
        super(entity);
        this.tipo = entity.getTipo();
    }


    /**
     * Getter del tipo
     * @return tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Setter de tipo
     * @param tipo
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * Metodo que cambia de DTO a Entity
     * @return
     */
    public EntrenamientoEntity toEntity(){
        EntrenamientoEntity entity = new EntrenamientoEntity();
        entity.setCosto(this.getCosto());
        entity.setDuracion(this.getDuracion());
        entity.setEstado(this.isEstado());
        entity.setFecha(this.getFecha());
        entity.setRango(this.getRango());
        entity.setTipo(this.tipo);
        return entity;
    }
}