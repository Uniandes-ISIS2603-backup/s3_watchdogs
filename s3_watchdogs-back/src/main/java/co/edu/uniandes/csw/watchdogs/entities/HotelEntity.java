/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.watchdogs.entities;

import java.io.Serializable;
import javax.persistence.Entity;

/**
 *
 * @author m.diazt
 */
@Entity
public class HotelEntity extends ServicioEntity implements Serializable {
    
    private Integer tiempoHospedaje;

    public Integer getTiempoHospedaje() {
        return tiempoHospedaje;
    }

    public void setTiempoHospedaje(Integer tiempoHospedaje) {
        this.tiempoHospedaje = tiempoHospedaje;
    }
    
    
}
