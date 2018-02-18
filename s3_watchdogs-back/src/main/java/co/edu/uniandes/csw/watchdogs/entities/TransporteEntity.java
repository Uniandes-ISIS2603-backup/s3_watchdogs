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
public class TransporteEntity extends BaseEntity implements Serializable{
    
    
    private String direccion;
    
    private int recogida;
    
    private int devuelta;

    public TransporteEntity(){
        
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setRecogida(int recogida) {
        this.recogida = recogida;
    }

    public void setDevuelta(int devuelta) {
        this.devuelta = devuelta;
    }

    public String getDireccion() {
        return direccion;
    }

    public int getRecogida() {
        return recogida;
    }

    public int getDevuelta() {
        return devuelta;
    }
    
    
}