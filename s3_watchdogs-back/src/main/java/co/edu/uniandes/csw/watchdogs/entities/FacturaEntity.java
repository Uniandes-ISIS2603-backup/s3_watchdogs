/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.watchdogs.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import uk.co.jemos.podam.common.PodamDoubleValue;
import uk.co.jemos.podam.common.PodamExclude;

/**
 *
 * @author id.salazar
 */
@Entity
public class FacturaEntity extends BaseEntity implements Serializable {

    /**
     * valor de la factura
     */
    @PodamDoubleValue(minValue = 0)
    private Double valor;

    /**
     * Estado de pagado de la factura
     */
    private Boolean pagado;

    /**
     * Cliente asociado a la factura
     */
    @PodamExclude
    @ManyToOne
    private ClienteEntity cliente;

    /**
     * Servicio Asociado a la factura
     */
    @PodamExclude
    @OneToOne
    private ServicioEntity servicio;

    /**
     * Relacion con los metodos de pago del cliente.
     */
    @PodamExclude
    @OneToOne
    private PayPalEntity payPal;

    /**
     * Relacion con los metodos de pago del cliente.
     */
    @PodamExclude
    @OneToOne
    private PseEntity pse;

    /**
     * Relacion con los metodos de pago del cliente.
     */
    @PodamExclude
    @OneToOne
    private TarjetaCreditoEntity tarjeta;

    /**
     * Constructor por defecto
     */
    public FacturaEntity() {
        super();
    }

    /**
     * @param valor El nuevo valor de la factura
     */
    public void setValor(Double valor) {
        this.valor = valor;
    }

    /**
     * @param pagado El nuevo estado de pago
     */
    public void setPagado(Boolean pagado) {
        this.pagado = pagado;
    }

    /**
     *
     * @return El valor de la factura
     */
    public Double getValor() {
        return valor;
    }

    /**
     *
     * @return El estatus de pago de la factura
     */
    public Boolean getPagado() {
        return pagado;
    }

    /**
     *
     * @return El cliente de la factura
     */
    public ClienteEntity getCliente() {
        return cliente;
    }

    /**
     * @param cliente El nuevo cliente
     */
    public void setCliente(ClienteEntity cliente) {
        this.cliente = cliente;
    }

    /**
     * @return the servicio
     */
    public ServicioEntity getServicio() {
        return servicio;
    }

    /**
     * @param servicio the servicio to set
     */
    public void setServicio(ServicioEntity servicio) {
        this.servicio = servicio;
    }

    /**
     * @return the paypal
     */
    public PayPalEntity getPayPal() {
        return payPal;
    }

    /**
     * @param payPal the paypal to set
     */
    public void setPayPal(PayPalEntity payPal) {
        this.payPal = payPal;
    }

    /**
     * @return the pse
     */
    public PseEntity getPse() {
        return pse;
    }

    /**
     * @param pse the pse to set
     */
    public void setPse(PseEntity pse) {
        this.pse = pse;
    }

    /**
     * @return the tarjeta
     */
    public TarjetaCreditoEntity getTarjeta() {
        return tarjeta;
    }

    /**
     * @param tarjeta the tarjeta to set
     */
    public void setTarjeta(TarjetaCreditoEntity tarjeta) {
        this.tarjeta = tarjeta;
    }

}
