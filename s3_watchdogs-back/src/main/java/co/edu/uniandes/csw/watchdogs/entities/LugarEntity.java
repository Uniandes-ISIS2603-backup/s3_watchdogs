/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.watchdogs.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 *
 * @author js.vacat
 */
@MappedSuperclass
public abstract class LugarEntity extends BaseEntity  implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    protected String direccion;
    protected List<String> fotos;
    
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

}
