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
    
    public final static String TARJETA_CREDITO = "Tarjeta de credito";
    public final static String PSE = "Pse";
    public final static String PAYPAL = "PayPal";

    
    protected Long id;
    protected Boolean aprobado;
    protected String nombre;

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public MetodoDePagoDTO(){}
    
    public MetodoDePagoDTO(MetodoDePagoEntity entity)
    {
        if(entity != null)
        {
            this.id = entity.getId();
            this.aprobado = entity.getAprobado();
        }
    }
    
    public MetodoDePagoEntity toEntity()
    {
        MetodoDePagoEntity metodoPago = null;
        return metodoPago;
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

   
    
    
    
}
