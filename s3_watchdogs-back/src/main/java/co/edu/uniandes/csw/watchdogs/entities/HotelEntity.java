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
import uk.co.jemos.podam.common.PodamDoubleValue;
import uk.co.jemos.podam.common.PodamExclude;
import uk.co.jemos.podam.common.PodamIntValue;

/**
 *
 * @author m.diazt
 */
@Entity
public class HotelEntity extends ServicioEntity implements Serializable {
    private Integer tiempoHospedaje;
    
    @PodamExclude
    @OneToOne(cascade = CascadeType.PERSIST, orphanRemoval = true)
    private TransporteEntity transporte;
    
    @PodamExclude
    @ManyToOne
    private CentroDeEntrenamientoEntity centroDeEntrenamiento;
    
    public HotelEntity(){
    
    }

    public Integer getTiempoHospedaje() {
        return tiempoHospedaje;
    }

    public void setTiempoHospedaje(Integer tiempoHospedaje) {
        this.tiempoHospedaje = tiempoHospedaje;
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
    
    
    
    
}
