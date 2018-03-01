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
import uk.co.jemos.podam.common.PodamExclude;

/**
 *
 * @author id.salazar
 */

@Entity
public class FacturaEntity extends BaseEntity implements Serializable{
    
    private Double valor;
    private Boolean pagado;
    
    //@PodamExclude
    //@OneToOne
    //private MetodoDePagoEntity metodoDePago;
    
    @PodamExclude
    @ManyToOne
    private ClienteEntity cliente;
    
    //@PodamExclude
    //@OneToOne
    //private ServicioEntity servicio;
    
    
    public FacturaEntity(){
        
    }
    
    /**
     * @param valor El nuevo valor de la factura
     */
    
    public void setValor(double valor){
        this.valor = valor;
    }
    
    /**
     * @param pagado El nuevo estado de pago
     */
    
    
    public void setPago(boolean pagado){
        this.pagado = pagado;
    }
    
    /**
     * 
     * @return El valor de la factura 
     */
    
    public double getValor(){
        return valor;
    }
    
     /**
     * 
     * @return El estatus de pago de la factura 
     */
    
    public boolean getPagado(){
        return pagado;
    }
}

