/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.watchdogs.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Temporal;

/**
 *
 * @author c.martinezc1
 */
@Entity
public abstract class ServicioEntity extends BaseEntity implements Serializable{
    /**
     * identificador
     */
    private Long id;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fecha;
    
    private double costo;
    
    private boolean estado;
    
    private ArrayList<String> rango;
    
    private double duracion;
    
    public ServicioEntity(){
        
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
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

    public void setRango(ArrayList<String> rango) {
        this.rango = rango;
    }

    public void setDuracion(double duracion) {
        this.duracion = duracion;
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

    public ArrayList<String> getRango() {
        return rango;
    }

    public double getDuracion() {
        return duracion;
    }
}
