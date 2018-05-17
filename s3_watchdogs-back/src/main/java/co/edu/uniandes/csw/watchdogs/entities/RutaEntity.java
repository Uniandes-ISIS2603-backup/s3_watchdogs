/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.watchdogs.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import uk.co.jemos.podam.common.PodamExclude;
import uk.co.jemos.podam.common.PodamIntValue;

/**
 *
 * @author id.salazar
 */

@Entity
public class RutaEntity extends BaseEntity implements Serializable{
    
    /**
     * La duracion de la ruta
     */
    @PodamIntValue(minValue = 1, maxValue = 120)
    private Integer duracion;
    
    /**
     * Lista de paseos que poseen la ruta
     */
    @PodamExclude
    @OneToMany(mappedBy="ruta",cascade = CascadeType.ALL,fetch =FetchType.LAZY)
    private List<PaseoEntity> paseos;
    
    /**
     * Constructor por defecto
     */
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

    /**
     * @return Lista de paseos con esta ruta 
     */
    public List<PaseoEntity> getPaseos() {
        return paseos;
    }

    /**
     * @param paseos nueva lista de paseos con esta ruta 
     */
    public void setPaseos(List<PaseoEntity> paseos) {
        this.paseos = paseos;
    }
    
    
}
