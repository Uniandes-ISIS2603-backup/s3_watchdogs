/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.watchdogs.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import uk.co.jemos.podam.common.PodamExclude;

/**
 * Clase que representa una entidad de un empleado para ser creado en la base de
 * datos.
 *
 * @author ca.beltran10
 */
@Entity
public class EmpleadoEntity extends BaseEntity implements Serializable {

    /**
     * Relacion con la disponibilidad del empleado.
     */
    @PodamExclude
    @OneToOne
    private DisponibilidadEntity disponibilidad;

    /**
     * Relacion con la calificacion del empleado.
     */
    @PodamExclude
    @OneToOne(mappedBy = "empleado", cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
    private CalificacionEntity calificacion;

    /**
     * Relacion con el servicio del empleado.
     */
    @PodamExclude
    @OneToMany(mappedBy = "empleado")
    private List<ServicioEntity> servicios = new ArrayList<>();

    /**
     * Ruta de la imagen del empleado.
     */
    private String imagen;

    /**
     * Cedula del empleado.
     */
    private String cedula;

    /**
     * Edad del empleado.
     */
    private Integer edad;

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
    public List<ServicioEntity> getServicios() {
        return servicios;
    }

    /**
     * Etablece el valor del atributo servicio.
     *
     * @param servicio nuevo valor del atributo.
     */
    public void setServicios(List<ServicioEntity> servicios) {
        this.servicios = servicios;
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
    public Integer getEdad() {
        return edad;
    }

    /**
     * Establede el valor del atributo edad.
     *
     * @param edad nuevo valor del atributo edad.
     */
    public void setEdad(Integer edad) {
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
