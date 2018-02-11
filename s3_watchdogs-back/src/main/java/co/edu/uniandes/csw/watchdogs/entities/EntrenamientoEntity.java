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
public class EntrenamientoEntity extends ServicioEntity implements Serializable {
  
    private String tipo;
    
    public EntrenamientoEntity(){
        
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }
       
}
