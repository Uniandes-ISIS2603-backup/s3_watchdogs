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
 * @author c.martinezc1
 */
public abstract class ServicioDTO {
    /**
     * identificador
     */
    protected Long id;
    
    /**
     * Fecha en que se presto un servicio
     */
    protected Date fecha;
    
    /**
     * Costo por hora del servicio
     */
    protected double costo;
    
    /**
     * Estado actual del servicio
     */
    protected boolean estado;
    
    /**
     * Duración del servicio
     */
    protected double duracion;
    
    /**
     * Rango de horas libres
     */
    protected ArrayList<String> rango;
    
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

    /**
     * Getter id
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * Setter id
     * @param id 
     */
    public void setId(Long id) {
        this.id = id;
    }
    
    /**
     * Getter fecha
     * @return fecha
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * GEtter costo
     * @return costo
     */
    public double getCosto() {
        return costo;
    }

    /**
     * Getter estado
     * @return estado
     */
    public boolean isEstado() {
        return estado;
    }

    /**
     * Getter duracion
     * @return duracion
     */
    public double getDuracion() {
        return duracion;
    }

    /**
     * Getter rango
     * @return rango
     */
    public ArrayList<String> getRango() {
        return rango;
    }

    /**
     * Setter fecha
     * @param fecha 
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    /**
     * Setter costo
     * @param costo 
     */
    public void setCosto(double costo) {
        this.costo = costo;
    }

    /**
     * Setter estado
     * @param estado 
     */
    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    /**
     * Setter duracion
     * @param duracion 
     */
    public void setDuracion(double duracion) {
        this.duracion = duracion;
    }

    /**
     * Setter rango
     * @param rango 
     */
    public void setRango(ArrayList<String> rango) {
        this.rango = rango;
    }
    
}
