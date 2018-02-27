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
 * @author id.salazar
 */

@Entity
public class RutaEntity extends BaseEntity implements Serializable{
    
    private Integer duracion;
    
    public RutaEntity(){
        
    }
    
     
    /**
     * @param duracion La nueva duración de la ruta
     */
    
    
    public void setDuracion(Integer duracion){
        this.duracion = duracion;
    }
    
     /**
     * 
     * @return La duración de la ruta
     */
    public int getDuracion(){
        return duracion;
    }
}
