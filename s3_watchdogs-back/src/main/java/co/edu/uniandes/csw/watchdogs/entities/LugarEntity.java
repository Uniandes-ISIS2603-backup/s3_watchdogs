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
public abstract class LugarEntity implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
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

    /**
     * @return el id del lugar
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id el ide del lugar que entra por parametro
     */
    public void setId(Long id) {
        this.id = id;
    }
    
    @Override
    public boolean equals(Object obj) {
                if (this.getId() != null && ((LugarEntity) obj).getId() != null) {
            return this.getId().equals(((LugarEntity) obj).getId());
        }
        return super.equals(obj);
    }
    
    @Override
    public int hashCode() {
        if (this.getId() != null) {
            return this.getId().hashCode();
        }
        return super.hashCode();
    }
}
