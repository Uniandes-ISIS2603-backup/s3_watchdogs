/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.watchdogs.dtos;

import co.edu.uniandes.csw.watchdogs.entities.ServicioEntity;
import java.util.Date;
import java.util.List;

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
    protected Double costo;
    
    /**
     * Estado actual del servicio
     */
    protected Boolean estado;
    
    /**
     * Duración del servicio
     */
    protected Double duracion;
    
    /**
     * Rango de horas libres
     */
    protected List<String> rango;
    
    protected Integer hora;
    
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
        if(entity!=null){
            this.id = entity.getId();
            this.costo = entity.getCosto();
            this.duracion = entity.getDuracion();
            this.estado = entity.isEstado();
            this.fecha = entity.getFecha();
            this.rango = entity.getRango();
            this.hora = entity.getHora();
        }
        
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
    public Double getCosto() {
        return costo;
    }

    /**
     * Getter estado
     * @return estado
     */
    public Boolean isEstado() {
        return estado;
    }

    /**
     * Getter duracion
     * @return duracion
     */
    public Double getDuracion() {
        return duracion;
    }

    /**
     * Getter rango
     * @return rango
     */
    public List<String> getRango() {
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
    public void setCosto(Double costo) {
        this.costo = costo;
    }

    /**
     * Setter estado
     * @param estado 
     */
    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    /**
     * Setter duracion
     * @param duracion 
     */
    public void setDuracion(Double duracion) {
        this.duracion = duracion;
    }

    /**
     * Setter rango
     * @param rango 
     */
    public void setRango(List<String> rango) {
        this.rango = rango;
    }

    public Integer getHora() {
        return hora;
    }

    public void setHora(Integer hora) {
        this.hora = hora;
    }
    
    
    
    public ServicioEntity toEntity(){
        ServicioEntity servicio = new ServicioEntity();
        servicio.setCosto(costo);
        servicio.setDuracion(duracion);
        servicio.setEstado(estado);
        servicio.setFecha(fecha);
        servicio.setId(id);
        servicio.setRango(rango);
        return servicio;
    }
     
}
