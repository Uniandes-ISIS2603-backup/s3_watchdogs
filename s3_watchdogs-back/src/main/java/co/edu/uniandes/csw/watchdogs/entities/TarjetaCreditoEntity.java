/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.watchdogs.entities;

import co.edu.uniandes.csw.watchdogs.podam.DateStrategy;
import co.edu.uniandes.csw.watchdogs.podam.DateTarjetaStrategy;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import uk.co.jemos.podam.common.PodamStrategyValue;


/**
 *
 * @author jc.pulido
 */
@Entity
public class TarjetaCreditoEntity extends MetodoDePagoEntity implements Serializable {
    
    private String numeroTarjeta;
    @Temporal(TemporalType.DATE)
    @PodamStrategyValue(DateTarjetaStrategy.class)
    private Date fechaVencimiento;
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
    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    /**
     * Método que asigna un nuevo valor a la fecha de vencimiento 
     * @param fechaVencimiento Nueva fecha a asignar 
     */
    public void setFechaVencimiento(Date fechaVencimiento) {
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
