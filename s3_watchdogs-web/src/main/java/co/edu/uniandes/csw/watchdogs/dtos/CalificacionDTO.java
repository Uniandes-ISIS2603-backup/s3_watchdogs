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
public class CalificacionDTO {
    
    private Long id;
    
    private int puntaje;

    public CalificacionDTO(CalificacionEntity entity) {
        this.id = entity.getId();
        this.puntaje = entity.getPuntaje();
    }  
    
    public Long getId() {
        return id;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }
    
    /**
     * Metodo que pasa de un DTO a un Entity
     * @return 
     */
    public CalificacionEntity toEntity(){
        CalificacionEntity entity = new CalificacionEntity();
        entity.setId(id);
        entity.setPuntaje(puntaje);
        return entity;
    }
}
