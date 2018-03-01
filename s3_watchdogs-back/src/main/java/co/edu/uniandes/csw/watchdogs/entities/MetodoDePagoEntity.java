/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.watchdogs.entities;

import co.edu.uniandes.csw.bookstore.podam.DateStrategy;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import uk.co.jemos.podam.common.PodamStrategyValue;

/**
 *
 * @author jc.pulido
 */
@MappedSuperclass
public abstract class MetodoDePagoEntity extends BaseEntity implements Serializable {
    
   // @PodamStrategyValue(Bool.class)
    
    protected Boolean aprobado;
    
    protected String nombre;
    
    public MetodoDePagoEntity(){}

    public Boolean getAprobado() {
        return aprobado;
    }

    public void setAprobado(Boolean aprobado) {
        this.aprobado = aprobado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
    
}