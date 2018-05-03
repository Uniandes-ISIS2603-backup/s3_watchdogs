/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.watchdogs.entities;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import uk.co.jemos.podam.common.PodamDoubleValue;
import uk.co.jemos.podam.common.PodamExclude;

/**
 *
 * @author id.salazar
 */

@Entity
public class FacturaEntity extends BaseEntity implements Serializable{
    
    
    @PodamDoubleValue(minValue = 0)
    private Double valor;
    private Boolean pagado;
    
    
    @PodamExclude
    @ManyToOne
    private ClienteEntity cliente;
    
    @PodamExclude
    @OneToOne
    private ServicioEntity servicio;
    
     /**
     * Relacion con los metodos de pago del cliente.
     */
    @PodamExclude
    @OneToOne(mappedBy = "cliente")
    private List<PayPalEntity> payPals = new ArrayList<>();

    /**
     * Relacion con los metodos de pago del cliente.
     */
    @PodamExclude
    @OneToOne(mappedBy = "cliente")
    private List<PseEntity> pses = new ArrayList<>();

    /**
     * Relacion con los metodos de pago del cliente.
     */
    @PodamExclude
    @OneToOne(mappedBy = "cliente")
    private List<TarjetaCreditoEntity> tarjetas = new ArrayList<>();

    
    
    public FacturaEntity(){
        
    }
    
    /**
     * @param valor El nuevo valor de la factura
     */
    
    public void setValor(Double valor){
        this.valor = valor;
    }
    
    /**
     * @param pagado El nuevo estado de pago
     */
    
    
    public void setPago(Boolean pagado){
        this.pagado = pagado;
    }
    
    /**
     * 
     * @return El valor de la factura 
     */
    
    public Double getValor(){
        return valor;
    }
    
     /**
     * 
     * @return El estatus de pago de la factura 
     */
    
    public Boolean getPagado(){
        return pagado;
    }
    
    /**
     * 
     * @return El cliente de la factura 
     */
    
    public ClienteEntity getCliente(){
        return cliente;
    }
    
     /**
     * @param cliente El nuevo cliente
     */
    
    
    public void setCliente(ClienteEntity cliente){
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
    
    
}

