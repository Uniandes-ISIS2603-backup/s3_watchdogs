/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.watchdogs.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import uk.co.jemos.podam.common.PodamExclude;
import uk.co.jemos.podam.common.PodamIntValue;
import uk.co.jemos.podam.common.PodamStringValue;

/**
 *
 * @author m.diazt
 */
@Entity
public class PaseoEntity extends ServicioEntity implements Serializable {
    
   /**
    * Capacidad maxima de mascotas
    */
    @PodamIntValue(minValue = 1)
    private Integer capMax;
    
    /**
     * 
     */
    @PodamStringValue(length = 11)
    private List<String> horas;
    
    /**
     * Ruta del paseo
     */
    @PodamExclude
    @ManyToOne
    private RutaEntity ruta;
    
    /**
     * Veterinaria del paseo
     */
    @PodamExclude
    @ManyToOne
    private VeterinariaEntity veterinaria;

    /**
     * 
     * @return la capacidad maxima 
     */
    
    public Integer getCapMax() {
        return capMax;
    }

    /**
     * 
     * @param capMax la nueva capacida maxima del paseo
     */
    public void setCapMax(Integer capMax) {
        this.capMax = capMax;
    }

    /**
     * 
     * @return  
     */
    public List<String> getHoras() {
        return horas;
    }
    /**
     * 
     * @param horas 
     */
    public void setHoras(List<String> horas) {
        this.horas = horas;
    }

    /**
     * 
     * @return la ruta del paseo 
     */
    public RutaEntity getRuta() {
        return ruta;
    }

    /**
     * 
     * @param ruta la nueva ruta del paseo
     */
    public void setRuta(RutaEntity ruta) {
        this.ruta = ruta;
    }

    /**
     * 
     * @return la veterinaria del paseo 
     */
    public VeterinariaEntity getVeterinaria() {
        return veterinaria;
    }

    /**
     * 
     * @param veterinaria la nueva veterinaria del paseo
     */
    public void setVeterinaria(VeterinariaEntity veterinaria) {
        this.veterinaria = veterinaria;
    }
    
    
    
    
}
