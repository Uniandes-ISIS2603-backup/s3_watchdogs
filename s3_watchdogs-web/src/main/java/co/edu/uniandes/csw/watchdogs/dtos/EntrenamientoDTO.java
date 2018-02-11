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
    
    private String tipo;
    
    public EntrenamientoDTO(){
        
    }
    
    public EntrenamientoDTO(EntrenamientoEntity entity){
        super(entity);
        this.tipo = entity.getTipo();
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

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