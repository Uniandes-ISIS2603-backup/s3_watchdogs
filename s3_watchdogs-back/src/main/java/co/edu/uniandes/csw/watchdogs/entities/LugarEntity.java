/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.watchdogs.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import uk.co.jemos.podam.common.PodamIntValue;

/**
 *
 * @author js.vacat
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class LugarEntity extends BaseEntity  implements Serializable{
    
    
    private String direccion;
    private List<String> fotos;
    @PodamIntValue(minValue = 120, maxValue = 120)
    private Integer capacidadMaxima;
    @PodamIntValue(maxValue = 120)
    private Integer usuariosEnServicio;
    
    public LugarEntity(){}
    
    /**
     * @return La direccion del lugar
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * @param direccion la direccion del lugar
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * @return las fotos del lugar
     */
    public List<String> getFotos() {
        return fotos;
    }

    /**
     * @param fotos las fotos del lugar
     */
    public void setFotos(List<String> fotos) {
        this.fotos = fotos;
    }

    /**
     * @return la capacidad maxima
     */
    public Integer getCapacidadMaxima() {
        return capacidadMaxima;
    }

    /**
     * @param capacidadMaxima la capacidad maxima que entra por parametro
     */
    public void setCapacidadMaxima(Integer capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
    }

    /**
     * @return la usuarios En Servicio
     */
    public Integer getUsuariosEnServicio() {
        return usuariosEnServicio;
    }

    /**
     * @param usuariosEnServicio usuarios En Servicio que entra por parametro
     */
    public void setUsuariosEnServicio(Integer usuariosEnServicio) {
        this.usuariosEnServicio = usuariosEnServicio;
    }

}
