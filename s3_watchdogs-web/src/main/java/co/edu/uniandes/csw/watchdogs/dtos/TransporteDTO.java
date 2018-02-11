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
public class TransporteDTO {
    
    private Long id;
    
    private String direccion;
    
    private int recogida;
    
    private int devuelta;
    
    public TransporteDTO(){
        
    }
    public TransporteDTO(TransporteEntity entity){
        this.id = entity.getId();
        this.devuelta = entity.getDevuelta();
        this.direccion = entity.getDireccion();
        this.recogida = entity.getRecogida();
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setRecogida(int recogida) {
        this.recogida = recogida;
    }

    public void setDevuelta(int devuelta) {
        this.devuelta = devuelta;
    }

    public Long getId() {
        return id;
    }

    public String getDireccion() {
        return direccion;
    }

    public int getRecogida() {
        return recogida;
    }

    public int getDevuelta() {
        return devuelta;
    }
    
    public TransporteEntity toEntity(){
        TransporteEntity entity = new TransporteEntity();
        entity.setDevuelta(devuelta);
        entity.setDireccion(direccion);
        entity.setRecogida(recogida);
        return entity;
    }
}
