/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.watchdogs.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import uk.co.jemos.podam.common.PodamExclude;

/**
 *
 * @author ca.beltran10
 */
@Entity
public class EmpleadoEntity extends BaseEntity implements Serializable {

    @PodamExclude
    @OneToOne
    private DisponibilidadEntity disponibilidad;

    @PodamExclude
    @OneToOne
    private CalificacionEntity calificacion;

    @PodamExclude
    @OneToOne
    private ServicioEntity servicio;

    private String imagen;
    private String cedula;
    private int edad;

    /**
     * Obtiene el atributo disponibilidad.
     *
     * @return el atributo disponibilidad.
     */
    public DisponibilidadEntity getDisponibilidad() {
        return disponibilidad;
    }

    /**
     * Establece el valor del atributo disponibilidad.
     *
     * @param disponibilidad nuevo valor del atributo
     */
    public void setDisponibilidad(DisponibilidadEntity disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    /**
     * Obtiene el atributo calificacion.
     *
     * @return atributo calificacion.
     */
    public CalificacionEntity getCalificacion() {
        return calificacion;
    }

    /**
     * Establece el valor del atributo calificacion.
     *
     * @param calificacion nuevo valor del atributo.
     */
    public void setCalificacion(CalificacionEntity calificacion) {
        this.calificacion = calificacion;
    }

    /**
     * Obtiene el atributo servicio.
     *
     * @return atributo servicio.
     */
    public ServicioEntity getServicio() {
        return servicio;
    }

    /**
     * Etablece el valor del atributo servicio.
     *
     * @param servicio nuevo valor del atributo.
     */
    public void setServicio(ServicioEntity servicio) {
        this.servicio = servicio;
    }

    /**
     * Obtiene el valor imagen.
     *
     * @return atributo imagen.
     */
    public String getImagen() {
        return imagen;
    }

    /**
     * Establece el valor del atributo imagen.
     *
     * @param imagen nuevo valor del atributo.
     */
    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    /**
     * Obtiene el atributo edad.
     *
     * @return atributo edad.
     */
    public int getEdad() {
        return edad;
    }

    /**
     * Establede el valor del atributo edad.
     *
     * @param edad nuevo valor del atributo edad.
     */
    public void setEdad(int edad) {
        this.edad = edad;
    }

    /**
     * Obtiene el atributo cedula.
     *
     * @return atributo cedula.
     */
    public String getCedula() {
        return cedula;
    }

    /**
     * Establece el valor del atributo cedula.
     *
     * @param cedula nuevo valor del atributo.
     */
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

}
