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
public class PayPalEntity extends MetodoDePagoEntity implements Serializable{
    
    private String correo;
    private String contrasenha;

    /**
     * Método que retorna el correo
     * @return El correo asociado 
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * Método que asinga un nuevo valor al correo
     * @param correo Correo nuevo a asignar 
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * Método que retorna la contrasenha 
     * @return La contrasenha
     */
    public String getContrasenha() {
        return contrasenha;
    }

    /**
     * Método que asigna un nuevo valor a la contrasenha 
     * @param contrasenha Contraseña nueva a asignar
     */
    public void setContrasenha(String contrasenha) {
        this.contrasenha = contrasenha;
    }
    
    
    
}
