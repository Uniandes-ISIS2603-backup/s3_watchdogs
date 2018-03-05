/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.watchdogs.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import uk.co.jemos.podam.common.PodamIntValue;

/**
 *
 * @author id.salazar
 */

@Entity
public class RutaEntity extends BaseEntity implements Serializable{
    
    @PodamIntValue(minValue = 1, maxValue = 120)
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
    public Integer getDuracion(){
        return duracion;
    }
}
