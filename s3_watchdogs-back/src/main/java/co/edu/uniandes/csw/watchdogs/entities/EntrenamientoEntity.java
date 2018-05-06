/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.watchdogs.entities;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import uk.co.jemos.podam.common.PodamExclude;

/**
 *
 * @author c.martinezc1
 */
@Entity
public class EntrenamientoEntity extends ServicioEntity implements Serializable {
  
    private String tipo;
    
    @PodamExclude
    @ManyToOne
    private CentroDeEntrenamientoEntity centroDeEntrenamiento;
    
    @PodamExclude
    @OneToOne(cascade = CascadeType.PERSIST, orphanRemoval = true)
    private TransporteEntity transporte;
    
    public EntrenamientoEntity(){
        
    }
    
    public TransporteEntity getTransporte() {
        return transporte;
    }

    public void setTransporte(TransporteEntity transporte) {
        this.transporte = transporte;
    }

    public CentroDeEntrenamientoEntity getCentroDeEntrenamiento() {
        return centroDeEntrenamiento;
    }

    public void setCentroDeEntrenamiento(CentroDeEntrenamientoEntity centroDeEntrenamiento) {
        this.centroDeEntrenamiento = centroDeEntrenamiento;
    }
    
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }
       
}
