/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.watchdogs.entities;

import co.edu.uniandes.csw.watchdogs.podam.DateStrategy;
import co.edu.uniandes.csw.watchdogs.podam.NumTarjetaStrategy;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import uk.co.jemos.podam.common.PodamExclude;
import uk.co.jemos.podam.common.PodamStrategyValue;

/**
 *
 * @author jc.pulido
 */
@Entity
public class TarjetaCreditoEntity extends BaseEntity implements Serializable {

    /**
     * Numero de la tarjeta de crédito
     */
    @PodamStrategyValue(NumTarjetaStrategy.class)
    private String numeroTarjeta;

    /**
     * Fecha de vencimiento de la tarjeta
     */
    @Temporal(TemporalType.DATE)
    @PodamStrategyValue(DateStrategy.class)
    private Date fechaVencimiento;

    /**
     * Codigo de seguridad de la tarjeta
     */
    private String codigoSeguridad;

    /**
     * Cliente dueño de la tarjeta
     */
    @PodamExclude
    @ManyToOne
    private ClienteEntity cliente;

    /**
     * Atributo factura que evita que todo colapse
     */
    @PodamExclude
    @OneToOne(mappedBy = "tarjeta", fetch = FetchType.LAZY)
    private FacturaEntity factura;

    /**
     * @return la factura asociada
     */
    public FacturaEntity getFactura() {
        return factura;
    }

    /**
     *
     * @param factura nueva factura asociada
     */
    public void setFactura(FacturaEntity factura) {
        this.factura = factura;
    }

    /**
     * Método que retorna el número de la tarjeta
     *
     * @return El npumero de la tarjeta
     */
    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    /**
     * Método que asigna un nuevo valor al número de la tarjeta
     *
     * @param numeroTarjeta El nuevo número de tarjeta a asignar
     */
    public void setNumeroTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    /**
     * Método que retorna la fecha de vencimiento
     *
     * @return La fechca de vencimiento
     */
    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    /**
     * Método que asigna un nuevo valor a la fecha de vencimiento
     *
     * @param fechaVencimiento Nueva fecha a asignar
     */
    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    /**
     * Método que retorna el código de seguridad
     *
     * @return El código de seguridad
     */
    public String getCodigoSeguridad() {
        return codigoSeguridad;
    }

    /**
     * Método que asigna un nuevo valor al código de seguridad
     *
     * @param codigoSeguridad El código nuevo a asignar
     */
    public void setCodigoSeguridad(String codigoSeguridad) {
        this.codigoSeguridad = codigoSeguridad;
    }

    /**
     * M'etodo que retorna el cliente asignaod a la cuenta de paypal
     *
     * @return El cliente asociado a la cuenta de paypal
     */
    public ClienteEntity getCliente() {
        return cliente;
    }

    /**
     * Metodo que asigan un nuevo cliente a la cuenta de paypal
     *
     * @param cliente cliente a asignar
     */
    public void setCliente(ClienteEntity cliente) {
        this.cliente = cliente;
    }

}
