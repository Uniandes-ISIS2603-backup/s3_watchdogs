/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.watchdogs.entities;

import co.edu.uniandes.csw.watchdogs.podam.CorreoStrategy;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import uk.co.jemos.podam.common.PodamExclude;
import uk.co.jemos.podam.common.PodamStrategyValue;

/**
 *
 * @author jc.pulido
 */
@Entity
public class PseEntity extends BaseEntity implements Serializable {

    /**
     * Correo del PSE
     */
    @PodamStrategyValue(CorreoStrategy.class)
    private String correo;

    /**
     * Cliente dueño del PSE
     */
    @PodamExclude
    @ManyToOne
    private ClienteEntity cliente;

    /**
     * Atributo temporal de factura
     */
    @PodamExclude
    @OneToOne(mappedBy = "pse", fetch = FetchType.LAZY)
    private FacturaEntity factura;

    /**
     * Método que retorna la factura asociado
     *
     * @return El factura
     */
    public FacturaEntity getFactura() {
        return factura;
    }

    /**
     * Método que asigna un nuevo valor a factura
     *
     * @param factura factura a asignar
     */
    public void setFactura(FacturaEntity factura) {
        this.factura = factura;
    }

    /**
     * Método que retorna el correo asociado
     *
     * @return El correo
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * Método que asigna un nuevo valor al correo
     *
     * @param correo Correo a asignar
     */
    public void setCorreo(String correo) {
        this.correo = correo;
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
