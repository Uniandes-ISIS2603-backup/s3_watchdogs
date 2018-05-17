/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.watchdogs.entities;

import co.edu.uniandes.csw.watchdogs.podam.CorreoStrategy;
import java.io.Serializable;
import javax.persistence.CascadeType;
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
public class PayPalEntity extends BaseEntity implements Serializable{
    
    /**
     * Correo del paypal
     */
    @PodamStrategyValue(CorreoStrategy.class)
    private String correo;
    
    /**
     * Cliente dueño del payPal
     */
    @PodamExclude
    @ManyToOne
    private ClienteEntity cliente;
    
    /**
     * Atributo temporal de factura
     */
    @PodamExclude
    @OneToOne(mappedBy = "payPal", fetch = FetchType.LAZY)
    private FacturaEntity factura;

    /**
     * Método que retorna la factura
     * @return El factura asociadoa
     */
    public FacturaEntity getFactura() {
        return factura;
    }

    /**
     * Método que asinga un nuevo valor a factura
     * @param factura Factura nueva a asignar 
     */
    public void setFactura(FacturaEntity factura) {
        this.factura = factura;
    }

    /**
     * Método que retorna el correo
     * @return El correo asociado 
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * Método que asinga un nuevo valor al correo
     * @param correo Correo nuevo a asignar 
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }    
    
    /**
     * M'etodo que retorna el cliente asignaod a la cuenta de paypal
     * @return El cliente asociado a la cuenta de paypal
     */
    public ClienteEntity getCliente(){
        return cliente;
    }
    
    /**
     * Metodo que asigan un nuevo cliente a la cuenta de paypal
     * @param cliente cliente a asignar
     */
    public void setCliente(ClienteEntity cliente)
    {
        this.cliente = cliente;
    }
}
