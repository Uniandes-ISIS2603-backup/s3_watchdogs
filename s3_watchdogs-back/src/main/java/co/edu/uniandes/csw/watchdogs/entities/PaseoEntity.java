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
    
    @PodamIntValue(minValue = 1)
    private Integer capMax;
    @PodamStringValue(length = 11)
    private List<String> horas;
    
    
    @PodamExclude
    //TODO: mappedBy
    @ManyToOne
    private RutaEntity ruta;
    
    @PodamExclude
    @ManyToOne
    private VeterinariaEntity veterinaria;

    public Integer getCapMax() {
        return capMax;
    }

    public void setCapMax(Integer capMax) {
        this.capMax = capMax;
    }

    public List<String> getHoras() {
        return horas;
    }

    public void setHoras(List<String> horas) {
        this.horas = horas;
    }

    public RutaEntity getRuta() {
        return ruta;
    }

    public void setRuta(RutaEntity ruta) {
        this.ruta = ruta;
    }

    public VeterinariaEntity getVeterinaria() {
        return veterinaria;
    }

    public void setVeterinaria(VeterinariaEntity veterinaria) {
        this.veterinaria = veterinaria;
    }
    
    
    
    
}
