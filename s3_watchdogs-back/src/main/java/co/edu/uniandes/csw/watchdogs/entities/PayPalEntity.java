/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.watchdogs.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author jc.pulido
 */
@Entity
public class PayPalEntity extends BaseEntity implements Serializable {

    private String correo;
    private String contrasenha;
    
    /**
     * 
     * @return Correo asociado a la cuenta
     */
    public String getCorreo()
    {
        return correo;
    }
    
    /**
     * 
     * @param correo Nuevo correo a asignar 
     */
    public void setCorreo(String correo)
    {
        this.correo = correo;
    }
    
    /**
     * 
     * @return Contraseña asociada a la cuenta
     */
    public String getContrasenha()
    {
        return contrasenha;
    }
    
    /**
     * 
     * @param contrasenha Contraseña nueva a asignar
     */
    public void setContrasenha(String contrasenha)
    {
        this.contrasenha = contrasenha;
    }
    
}
