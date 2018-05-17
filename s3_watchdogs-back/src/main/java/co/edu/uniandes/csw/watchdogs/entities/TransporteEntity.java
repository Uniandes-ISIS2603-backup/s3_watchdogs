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
 * @author c.martinezc1
 */
@Entity
public class TransporteEntity extends BaseEntity implements Serializable {

    private String direccion;

    private Integer recogida;

    private Integer devuelta;

    public TransporteEntity() {

    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setRecogida(Integer recogida) {
        this.recogida = recogida;
    }

    public void setDevuelta(Integer devuelta) {
        this.devuelta = devuelta;
    }

    public String getDireccion() {
        return direccion;
    }

    public Integer getRecogida() {
        return recogida;
    }

    public Integer getDevuelta() {
        return devuelta;
    }

}
