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
 * @author jc.pulido
 */
@Entity
public class PseEntity extends BaseEntity implements Serializable {
    
    private String correo;
    
    /**
     * @return correo asociado a la cuenta PSE 
     */
    public String getCorreo(){
        return correo;
    }
    
    /**
     * @param correo nuevo correo a asignar
     */
    public void setCorreo(String correo){
        this.correo = correo;
    }
}
