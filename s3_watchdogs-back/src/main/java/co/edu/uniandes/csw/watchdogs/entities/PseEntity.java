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
public class PseEntity extends MetodoDePagoEntity implements Serializable {
    
    private String correo;
    
    /**
     * Método que retorna el correo asociado
     * @return El correo 
     */
    public String getCorreo()
    {
        return correo;
    }
    
    /**
     * Método que asigna un nuevo valor al correo
     * @param correo Correo a asignar 
     */
    public void setCorreo(String correo)
    {
        this.correo = correo;
    }
    
}
