/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.watchdogs.dtos;

import java.util.ArrayList;
import java.util.Date;

/**
 ** Al serializarse como JSON esta clase implementa el siguiente modelo: <br>
 * <pre>
 *   {
 *      "id": long,
 *      "fecha: date,
 *      "costo": double
 *      "estado": boolean
 *      "duración": double
 *      "rango": List'String'
 *   }
 * </pre>
 * Por ejemplo un entrenamiento se representa asi:<br>
 * 
 * <pre>
 * 
 *   {
 *      "id": 815373,
 *      "fecha: "10-10-2010",
 *      "costo": 25
 *      "estado": "1"
 *      "duración": 20.5
 *      "rango": ""
 *   }
 *
 * </pre>
 * @author c.martinezc1
 */
public abstract class ServicioDTO {
    /**
     * identificador
     */
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
