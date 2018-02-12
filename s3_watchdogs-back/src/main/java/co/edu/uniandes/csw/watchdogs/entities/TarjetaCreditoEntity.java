/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.watchdogs.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author jc.pulido
 */
@Entity
public class TarjetaCreditoEntity extends BaseEntity implements Serializable {

    private String numTarjeta;
    private String nombre;
    private String fechaVencimiento;
    private String codigoSeguridad;
    
    /**
     * 
     * @return número asosciado al número de la tarjeta de créito
     */
    public String getNumTarjeta()
    {
        return numTarjeta;
    }
    
    /**
     * Método que asigna un nuevo número de tarjeta
     * @param num número a asignar
     */
    public void setNumTarjeta(String num)
    {
        this.numTarjeta = num;
    }
    
    /**
     * 
     * @return nombre asignado a la tarjeta de crédito
     */
    public String getNombre()
    {
        return nombre;
    }
    
    /**
     * 
     * @param nombre nombre nuevo a asignar
     */
    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }
    
    /**
     * 
     * @return fecha de vencimiento de la tarjeta 
     */
    public String getFechaVencimiento()
    {
        return fechaVencimiento;
    }
    
    /**
     * 
     * @param fecha Fecha nueva de la tarjeta a asignar
     */
    public void setFechaVencimiento(String fecha)
    {
        this.fechaVencimiento = fecha;
    }
    
    /**
     * 
     * @return Código de seguridad asociado a la tarjeta
     */
    public String getCodigoSeguridad()
    {
        return codigoSeguridad;
    }
    
    /**
     * Método que asigna un nuevo valor al código de seguridad 
     * @param codSeg nuevo valor a asignar
     */
    public void setCodigoSeguridad(String codSeg)
    {
        this.codigoSeguridad = codSeg;
    }
}
