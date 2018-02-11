/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.watchdogs.dtos;

import co.edu.uniandes.csw.watchdogs.entities.ServicioEntity;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author c.martinezc1
 */
public abstract class ServicioDTO {
    
    private Long id;
    
    /**
     * Fecha en que se presto un servicio
     */
    private Date fecha;
    
    /**
     * Costo por hora del servicio
     */
    private double costo;
    
    /**
     * Estado actual del servicio
     */
    private boolean estado;
    
    /**
     * Duración del servicio
     */
    private double duracion;
    
    private ArrayList<String> rango;
    
    /**
     * Constructor por defecto
     */
    public ServicioDTO(){
    }
    
    /**
     * Constructor basico de un servicio
     * @param entity 
     */
    public ServicioDTO(ServicioEntity entity){
        this.id = entity.getId();
        this.costo = entity.getCosto();
        this.duracion = entity.getDuracion();
        this.estado = entity.isEstado();
        this.fecha = entity.getFecha();
        this.rango = entity.getRango();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    

    public Date getFecha() {
        return fecha;
    }

    public double getCosto() {
        return costo;
    }

    public boolean isEstado() {
        return estado;
    }

    public double getDuracion() {
        return duracion;
    }

    public ArrayList<String> getRango() {
        return rango;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public void setDuracion(double duracion) {
        this.duracion = duracion;
    }

    public void setRango(ArrayList<String> rango) {
        this.rango = rango;
    }
    
}
