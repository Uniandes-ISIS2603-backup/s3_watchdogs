/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.watchdogs.entities;

import java.io.Serializable;
import java.util.ArrayList;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import uk.co.jemos.podam.common.PodamExclude;
import uk.co.jemos.podam.common.PodamIntValue;

/**
 *
 * @author m.diazt
 */
@Entity
public class CentroDeEntrenamientoEntity extends LugarEntity implements Serializable {
    
     @PodamIntValue(minValue = 1)
     private Integer tiempoEntreno;
     
     @PodamExclude
     @OneToMany(mappedBy = "centroDeEntrenamiento")
     private ArrayList<EntrenamientoEntity> entrenamientos;
     
     @PodamExclude
     @OneToMany(mappedBy = "centroDeEntrenamiento")
     private ArrayList<HotelEntity> hoteles;

    public Integer getTiempoEntreno() {
        return tiempoEntreno;
    }

    public void setTiempoEntreno(Integer tiempoEntreno) {
        this.tiempoEntreno = tiempoEntreno;
    }

    public ArrayList<EntrenamientoEntity> getEntrenamientos() {
        return entrenamientos;
    }

    public void setEntrenamientos(ArrayList<EntrenamientoEntity> entrenamientos) {
        this.entrenamientos = entrenamientos;
    }

    public ArrayList<HotelEntity> getHoteles() {
        return hoteles;
    }

    public void setHoteles(ArrayList<HotelEntity> hoteles) {
        this.hoteles = hoteles;
    }
    
    
    
     
}
