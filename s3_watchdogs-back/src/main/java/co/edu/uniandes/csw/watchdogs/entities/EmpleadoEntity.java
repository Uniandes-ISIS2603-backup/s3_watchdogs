/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.watchdogs.entities;

import co.edu.uniandes.csw.watchdogs.podam.CargoStrategy;
import co.edu.uniandes.csw.watchdogs.podam.CorreoStrategy;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import uk.co.jemos.podam.common.PodamExclude;
import uk.co.jemos.podam.common.PodamStrategyValue;

/**
 * Clase que representa una entidad de un empleado para ser creado en la base de
 * datos.
 *
 * @author ca.beltran10
 */
@Entity
public class EmpleadoEntity extends BaseEntity implements Serializable {

    /**
     * Constantes posibles para el Cargo del empleado 
     **/
    
    /**
     * Constante para el paseador
     **/
    public static final String PASEADOR = "Paseador";
    
    /**
     * Constante para el aseador     
     **/
    public static final String ASEADOR = "Aseador";
    
    /**
     * Constante para el entrenador 
     **/
    public static final String ENTRENADOR = "Entrenador";
    
    /**
     * Constante para el cuidador 
     **/
    public static final String CUIDADOR = "Cuidador";
    
    
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
    @OneToOne(mappedBy = "empleado", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private CalificacionEntity calificacion;

    /**
     * Relacion con el servicio del empleado.
     */
    @PodamExclude
    @OneToMany(mappedBy = "empleado", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
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
     * Cargo del empleado.
     */
     @PodamStrategyValue(CargoStrategy.class)
    private String cargo;
    
    /**
     * Correo del empleado.
     */
    
    @PodamStrategyValue(CorreoStrategy.class)
    private String correo;
    
    /**
     * Telefono del empleado.
     */
    private String telefono;
    
    
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
    
    /**
     * Obtiene el atributo cargo.
     *
     * @return atributo cargo.
     */
    public String getCargo() {
        return cargo;
    }

    /**
     * Establece el valor del atributo cargo.
     *
     * @param cargo nuevo valor del atributo.
     */
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    
    /**
     * Obtiene el atributo correo.
     *
     * @return atributo correo.
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * Establece el valor del atributo correo.
     *
     * @param correo nuevo valor del atributo.
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
    /**
     * Obtiene el atributo telefono.
     *
     * @return atributo telefono.
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Establece el valor del atributo telefono.
     *
     * @param telefono nuevo valor del atributo.
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

}
