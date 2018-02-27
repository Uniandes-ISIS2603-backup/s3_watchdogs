/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.watchdogs.dtos;

import co.edu.uniandes.csw.watchdogs.entities.MetodoDePagoEntity;

/**
 *
 * @author jc.pulido
 */
public abstract class MetodoDePagoDTO {
    
    protected Long id;
    protected Boolean aprobado;
    protected String nombre;
    
    public MetodoDePagoDTO(){}
    
    public MetodoDePagoDTO(MetodoDePagoEntity entity)
    {
        this.id = entity.getId();
        this.aprobado = entity.getAprobado();
        this.nombre = entity.getNombre();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getAprobado() {
        return aprobado;
    }

    public void setAprobado(Boolean aprobado) {
        this.aprobado = aprobado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
    
}
