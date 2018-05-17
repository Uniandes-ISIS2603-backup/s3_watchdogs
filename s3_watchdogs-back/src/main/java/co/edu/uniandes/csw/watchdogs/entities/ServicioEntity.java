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
import javax.persistence.FetchType;
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
public class ServicioEntity extends BaseEntity implements Serializable {

    /**
     * Fecha del servicio
     */
    @Temporal(TemporalType.DATE)
    @PodamStrategyValue(DateStrategy.class)
    protected Date fecha;

    /**
     * Costo del servicio
     */
    protected Double costo;

    /**
     * Estado del servicio
     */
    protected Boolean estado;

    /**
     * Rango del servicio
     */
    private List<String> rango;

    /**
     * Duracion del servicio
     */
    protected Double duracion;

    /**
     * Hora a la que se realizara el servicio
     */
    protected Integer hora;

    /**
     * Mascota asociada al servicio
     */
    @PodamExclude
    @ManyToOne
    protected MascotaEntity mascota;

    /**
     * Cliente adquisisor del servicio
     */
    @PodamExclude
    @ManyToOne
    protected ClienteEntity cliente;

    /**
     * Factura asociada al servicio
     */
    @PodamExclude
    @OneToOne(mappedBy = "servicio", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    protected FacturaEntity factura;

    /**
     * Calificación del servicio
     */
    @PodamExclude
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    protected CalificacionEntity calificacion;

    /**
     * Empleado a cargo del servicio
     */
    @PodamExclude
    @ManyToOne
    protected EmpleadoEntity empleado;

    /**
     *
     * @return the mascota
     */
    public MascotaEntity getMascota() {
        return mascota;
    }

    /**
     *
     * @param mascota the mascota to set
     */
    public void setMascota(MascotaEntity mascota) {
        this.mascota = mascota;
    }

    /**
     *
     * @return the cliente
     */
    public ClienteEntity getCliente() {
        return cliente;
    }

    /**
     *
     * @param cliente the cliente to set
     */
    public void setCliente(ClienteEntity cliente) {
        this.cliente = cliente;
    }

    /**
     *
     * @return the factura
     */
    public FacturaEntity getFactura() {
        return factura;
    }

    /**
     *
     * @param factura the factura to set
     */
    public void setFactura(FacturaEntity factura) {
        this.factura = factura;
    }

    /**
     *
     * @return the calificacion
     */
    public CalificacionEntity getCalificacion() {
        return calificacion;
    }

    /**
     *
     * @param calificacion the calificacion to set
     */
    public void setCalificacion(CalificacionEntity calificacion) {
        this.calificacion = calificacion;
    }

    /**
     *
     * @return the empleado
     */
    public EmpleadoEntity getEmpleado() {
        return empleado;
    }

    /**
     *
     * @param empleado the empleado to set
     */
    public void setEmpleado(EmpleadoEntity empleado) {
        this.empleado = empleado;
    }

    /**
     *
     * @param fecha the fecha to set
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    /**
     *
     * @param costo the costo to set
     */

    public void setCosto(Double costo) {
        this.costo = costo;
    }

    /**
     *
     * @param estado the estado to set
     */
    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    /**
     *
     * @param rango the rango to set
     */
    public void setRango(List<String> rango) {
        this.rango = rango;
    }

    /**
     *
     * @param duracion the duracion to set
     */
    public void setDuracion(Double duracion) {
        this.duracion = duracion;
    }

    /**
     *
     * @return the fecha
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     *
     * @return the costo
     */
    public Double getCosto() {
        return costo;
    }

    /**
     *
     * @return the Estado
     */
    public Boolean isEstado() {
        return estado;
    }

    /**
     *
     * @return the rango
     */
    public List<String> getRango() {
        return rango;
    }

    /**
     *
     * @return the duracion
     */
    public Double getDuracion() {
        return duracion;
    }

    /**
     *
     * @return the hora
     */
    public Integer getHora() {
        return hora;
    }

    /**
     *
     * @param hora the hora to set
     */
    public void setHora(Integer hora) {
        this.hora = hora;
    }

    /**
     * Metodo para saber si el objeto es del mismo tipo de esta clase
     *
     * @param obj el objeto a comprar
     * @return true si es de la misma clase, false de lo contrario
     */
    public final boolean tipoClase(final Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        return getClass() == obj.getClass();
    }
}
