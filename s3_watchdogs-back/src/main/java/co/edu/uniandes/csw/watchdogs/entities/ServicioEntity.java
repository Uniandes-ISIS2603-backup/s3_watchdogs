/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.watchdogs.entities;

import co.edu.uniandes.csw.bookstore.podam.DateStrategy;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import uk.co.jemos.podam.common.PodamExclude;
import uk.co.jemos.podam.common.PodamStrategyValue;

/**
 *
 * @author c.martinezc1
 */
@MappedSuperclass
public abstract class ServicioEntity extends BaseEntity implements Serializable{
      
    @Temporal(TemporalType.DATE)
    @PodamStrategyValue(DateStrategy.class)
    protected Date fecha;
    
    protected Double costo;
    
    protected boolean estado;
    
    protected ArrayList<String> rango;
    
    protected Double duracion;
    /*
    @PodamExclude
    @ManyToOne
    protected MascotaEntity mascota;
    
    @PodamExclude
    @ManyToOne
    protected ClienteEntity cliente;
    
    @PodamExclude
    @OneToOne
    protected FacturaEntity factura;
    
    @PodamExclude
    @OneToOne
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
    */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public void setRango(ArrayList<String> rango) {
        this.rango = rango;
    }

    public void setDuracion(double duracion) {
        this.duracion = duracion;
    }

    public Date getFecha() {
        return fecha;
    }

    public double getCosto() {
        return costo;
    }

    public boolean isEstado() {
        return estado;
    }

    public ArrayList<String> getRango() {
        return rango;
    }

    public double getDuracion() {
        return duracion;
    }
}
