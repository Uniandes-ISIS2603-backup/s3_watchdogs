/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.watchdogs.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import uk.co.jemos.podam.common.PodamExclude;

/**
 *
 * @author m.diazt
 */
@Entity
public class CentroDeEntrenamientoEntity extends LugarEntity implements Serializable {
     
    /**
     * Lista de Entrenamientos en el centro
     */
     @PodamExclude
     @OneToMany(mappedBy = "centroDeEntrenamiento",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
     private List<EntrenamientoEntity> entrenamientos;
     
     /**
     * Lista de servicios de Hotel en el centro
     */
     @PodamExclude
     @OneToMany(mappedBy = "centroDeEntrenamiento",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
     private List<HotelEntity> hoteles;

     /**
      * @return La lista de entrenamientos en el hotel
      */
    public List<EntrenamientoEntity> getEntrenamientos() {
        return entrenamientos;
    }

    /**
     * @param entrenamientos la nueva lista de entrenamientos
     */
    public void setEntrenamientos(List<EntrenamientoEntity> entrenamientos) {
        this.entrenamientos = entrenamientos;
    }

    /**
      * @return La lista de servidios de hotel en el hotel
      */
    public List<HotelEntity> getHoteles() {
        return hoteles;
    }

    /**
     * @param hoteles la nueva lista de servicios de hotel
     */
    public void setHoteles(List<HotelEntity> hoteles) {
        this.hoteles = hoteles;
    }
    
    
    
     
}
