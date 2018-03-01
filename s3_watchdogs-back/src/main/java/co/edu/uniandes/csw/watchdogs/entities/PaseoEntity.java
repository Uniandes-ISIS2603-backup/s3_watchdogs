/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.watchdogs.entities;

import java.io.Serializable;
import java.util.ArrayList;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import uk.co.jemos.podam.common.PodamExclude;

/**
 *
 * @author m.diazt
 */
@Entity
public class PaseoEntity extends ServicioEntity implements Serializable {
    
    private Integer capMax;
    private ArrayList<String> horas;
    
    @PodamExclude
    //TODO: mappedBy
    @OneToMany
    private ArrayList<RutaEntity> rutas;
    
    @PodamExclude
    @ManyToOne
    private VeterinariaEntity veterinaria;

    public Integer getCapMax() {
        return capMax;
    }

    public void setCapMax(Integer capMax) {
        this.capMax = capMax;
    }

    public ArrayList<String> getHoras() {
        return horas;
    }

    public void setHoras(ArrayList<String> horas) {
        this.horas = horas;
    }

    public ArrayList<RutaEntity> getRutas() {
        return rutas;
    }

    public void setRutas(ArrayList<RutaEntity> rutas) {
        this.rutas = rutas;
    }

    public VeterinariaEntity getVeterinaria() {
        return veterinaria;
    }

    public void setVeterinaria(VeterinariaEntity veterinaria) {
        this.veterinaria = veterinaria;
    }
    
    
    
    
}
