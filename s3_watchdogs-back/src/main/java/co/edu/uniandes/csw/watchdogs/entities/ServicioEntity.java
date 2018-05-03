/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.watchdogs.entities;

import co.edu.uniandes.csw.watchdogs.podam.DateStrategy;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import uk.co.jemos.podam.common.PodamExclude;
import uk.co.jemos.podam.common.PodamStrategyValue;

/**
 *
 * @author c.martinezc1
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public  class ServicioEntity extends BaseEntity implements Serializable{
      
    @Temporal(TemporalType.DATE)
    @PodamStrategyValue(DateStrategy.class)
    protected Date fecha;
    
    protected Double costo;
    
    protected Boolean estado;
    
    protected List<String> rango;
    
    protected Double duracion;
    
    protected Integer hora;
    
    @PodamExclude
    @ManyToOne
    protected MascotaEntity mascota;
    
    @PodamExclude
    @ManyToOne
    protected ClienteEntity cliente;
    
    @PodamExclude
    @OneToOne(mappedBy = "servicio")
    protected FacturaEntity factura;
    
    @PodamExclude
    @OneToOne(cascade = CascadeType.PERSIST, orphanRemoval = true)
    protected CalificacionEntity calificacion;
    
    @PodamExclude
    @ManyToOne
    protected EmpleadoEntity empleado;
    
    public MascotaEntity getMascota() {
        return mascota;
    }

    public void setMascota(MascotaEntity mascota) {
        this.mascota = mascota;
    }

    public ClienteEntity getCliente() {
        return cliente;
    }

    public void setCliente(ClienteEntity cliente) {
        this.cliente = cliente;
    }

    public FacturaEntity getFactura() {
        return factura;
    }

    public void setFactura(FacturaEntity factura) {
        this.factura = factura;
    }

    public CalificacionEntity getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(CalificacionEntity calificacion) {
        this.calificacion = calificacion;
    }

    public EmpleadoEntity getEmpleado() {
        return empleado;
    }

    public void setEmpleado(EmpleadoEntity empleado) {
        this.empleado = empleado;
    }
    
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setCosto(Double costo) {
        this.costo = costo;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public void setRango(List<String> rango) {
        this.rango = rango;
    }

    public void setDuracion(Double duracion) {
        this.duracion = duracion;
    }

    public Date getFecha() {
        return fecha;
    }

    public Double getCosto() {
        return costo;
    }

    public Boolean isEstado() {
        return estado;
    }

    public List<String> getRango() {
        return rango;
    }

    public Double getDuracion() {
        return duracion;
    }

    public Integer getHora() {
        return hora;
    }

    public void setHora(Integer hora) {
        this.hora = hora;
    }
    
    public final boolean tipoClase(final Object obj){
        if (obj == null) return false;
        if (this == obj) return true;
        return getClass() == obj.getClass();
    }
}
