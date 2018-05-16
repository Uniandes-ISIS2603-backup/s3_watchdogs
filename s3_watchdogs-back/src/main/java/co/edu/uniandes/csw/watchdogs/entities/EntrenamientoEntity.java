/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.watchdogs.entities;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import uk.co.jemos.podam.common.PodamExclude;

/**
 *
 * @author c.martinezc1
 */
@Entity
public class EntrenamientoEntity extends ServicioEntity implements Serializable {
  
    /**
     * Tipo del entrenamiento 
     */  
    private String tipo;
    
    /**
     * Centro de entrenamiento asociado
     */
    @PodamExclude
    @ManyToOne
    private CentroDeEntrenamientoEntity centroDeEntrenamiento;
    
    /**
     * Transporte asociado
     */
    @PodamExclude
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private TransporteEntity transporte;
    
    /**
     * Constructor vacío por deceto
     */
    public EntrenamientoEntity(){
        
    }
    
    /**
     * 
     * @return el transporte
     */
    
    public TransporteEntity getTransporte() {
        return transporte;
    }

    /**
     * 
     * @param transporte el nuevo transporte
     */
    public void setTransporte(TransporteEntity transporte) {
        this.transporte = transporte;
    }

    /**
     * 
     * @return el centro de entrenamiento
     */
    public CentroDeEntrenamientoEntity getCentroDeEntrenamiento() {
        return centroDeEntrenamiento;
    }

    /**
     * 
     * @param centroDeEntrenamiento el nuevo centro de entrenamiento
     */
    public void setCentroDeEntrenamiento(CentroDeEntrenamientoEntity centroDeEntrenamiento) {
        this.centroDeEntrenamiento = centroDeEntrenamiento;
    }
    
    /**
     * 
     * @param tipo el nuevo tipo
     */
    
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    /**
     * 
     * @return el tipo de entrenamiento
     */
    
    public String getTipo() {
        return tipo;
    }
       
}
