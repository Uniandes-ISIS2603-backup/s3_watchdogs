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
import uk.co.jemos.podam.common.PodamIntValue;

/**
 *
 * @author m.diazt
 */
@Entity
public class HotelEntity extends ServicioEntity implements Serializable {
    
    /**
     * El tiempo de hospedaje
     */
    @PodamIntValue(minValue = 12)
    private Integer tiempoHospedaje;
    
    /**
     * El transporte asociado al Hotel
     */
    @PodamExclude
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private TransporteEntity transporte;
    
    /**
     * El centro de entrenamiento asociado al hotel 
     */

    @PodamExclude
    @ManyToOne
    private CentroDeEntrenamientoEntity centroDeEntrenamiento;

    /**
     * 
     * @return el tiempo de hospedaje
     */
    public Integer getTiempoHospedaje() {
        return tiempoHospedaje;
    }
    
    /**
     * @param tiempoHospedaje el nuevo tiempo de hospedaje
     */

    public void setTiempoHospedaje(Integer tiempoHospedaje) {
        this.tiempoHospedaje = tiempoHospedaje;
    }

    /**
     * 
     * @return el transporte asociado
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
     * @return el centro de entrenamiento asociado
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
    
    
    
    
}
