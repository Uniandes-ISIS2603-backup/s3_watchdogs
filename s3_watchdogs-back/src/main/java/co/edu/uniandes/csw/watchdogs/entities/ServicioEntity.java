/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.watchdogs.entities;

import co.edu.uniandes.csw.bookstore.podam.DateStrategy;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import uk.co.jemos.podam.common.PodamStrategyValue;

/**
 *
 * @author c.martinezc1
 */
@Entity
public abstract class ServicioEntity extends BaseEntity implements Serializable{
      
    @Temporal(TemporalType.DATE)
    @PodamStrategyValue(DateStrategy.class)
    protected Date fecha;
    
    protected double costo;
    
    protected boolean estado;
    
    protected ArrayList<String> rango;
    
    protected double duracion;
    
    public ServicioEntity(){
        
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
