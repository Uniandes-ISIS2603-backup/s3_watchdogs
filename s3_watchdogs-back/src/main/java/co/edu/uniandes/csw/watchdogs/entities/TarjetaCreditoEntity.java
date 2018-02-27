/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.watchdogs.entities;

import java.io.Serializable;
import javax.persistence.Entity;


/**
 *
 * @author jc.pulido
 */
@Entity
public class TarjetaCreditoEntity extends MetodoDePagoEntity implements Serializable {
    
    private String numeroTarjeta;
    private String fechaVencimiento;
    private String codigoSeguridad;

    /**
     * Método que retorna el número de la tarjeta
     * @return El npumero de la tarjeta
     */
    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    /**
     * Método que asigna un nuevo valor al número de la tarjeta
     * @param numeroTarjeta El nuevo número de tarjeta a asignar
     */
    public void setNumeroTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    /**
     * Método que retorna la fecha de vencimiento 
     * @return La fechca de vencimiento 
     */
    public String getFechaVencimiento() {
        return fechaVencimiento;
    }

    /**
     * Método que asigna un nuevo valor a la fecha de vencimiento 
     * @param fechaVencimiento Nueva fecha a asignar 
     */
    public void setFechaVencimiento(String fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    /**
     * Método que retorna el código de seguridad 
     * @return El código de seguridad 
     */
    public String getCodigoSeguridad() {
        return codigoSeguridad;
    }

    /**
     * Método que asigna un nuevo valor al código de seguridad 
     * @param codigoSeguridad El código nuevo a asignar
     */
    public void setCodigoSeguridad(String codigoSeguridad) {
        this.codigoSeguridad = codigoSeguridad;
    }
    
    
    
}
