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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import uk.co.jemos.podam.common.PodamExclude;

/**
 * Clase que representa un cliente en la persistencia y permite su serializacion
 *
 * @author ca.beltran10
 */
@Entity
public class ClienteEntity extends BaseEntity implements Serializable {

    @PodamExclude
    @OneToMany(mappedBy = "cliente")
    private List<MascotaEntity> mascotas = new ArrayList<>();

    @PodamExclude
    @OneToMany(mappedBy = "cliente")
    private List<ServicioEntity> servicios = new ArrayList<>();

    @PodamExclude
    @OneToMany
    private List<MetodoDePagoEntity> metodosDePago = new ArrayList<>();

    @PodamExclude
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.PERSIST)
    private List<FacturaEntity> facturas = new ArrayList<>();

    @PodamExclude
    @OneToOne
    private CalificacionEntity calificacion = new CalificacionEntity();

    private String cedula;
    private String correo;
    private String telefono;
    private String imagen;

    /**
     * Obtiene el atributo cedula.
     *
     * @return atributo cedula
     */
    public String getCedula() {
        return cedula;
    }

    /**
     * Establece el valor del atributo cedula
     *
     * @param cedula nuevo valor de cedula
     */
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    /**
     * Obtiene la coleccion de mascotas.
     *
     * @return coleccion de mascotas.
     */
    public List<MascotaEntity> getMascotas() {
        return mascotas;
    }

    /**
     * Establece el valor de la coleccion de mascotas.
     *
     * @param mascotas nuevo valor de la coleccion.
     */
    public void setMascotas(List<MascotaEntity> mascotas) {
        this.mascotas = mascotas;
    }

    /**
     * Obtiene la coleccion de servicios.
     *
     * @return coleccion de servicios.
     */
    public List<ServicioEntity> getServicios() {
        return servicios;
    }

    /**
     * Establece el valor de la coleccion de servicios.
     *
     * @param servicios nuevo valor de la coleccion.
     */
    public void setServicios(List<ServicioEntity> servicios) {
        this.servicios = servicios;
    }

    /**
     * Obtiene la coleccion de metodos de pago.
     *
     * @return coleecion de metodos de pago.
     */
    public List<MetodoDePagoEntity> getMetodosDePago() {
        return metodosDePago;
    }

    /**
     * Establece el valor de la coleccion de metodos de pago.
     *
     * @param metodosDePago nuevo valor de la coleccion.
     */
    public void setMetodosDePago(List<MetodoDePagoEntity> metodosDePago) {
        this.metodosDePago = metodosDePago;
    }

    /**
     * Obtiene la coleccion de faturas.
     *
     * @return coleecion de facturas.
     */
    public List<FacturaEntity> getFacturas() {
        return facturas;
    }

    /**
     * Establece el valor de la coleccion de facturas.
     *
     * @param facturas nuevo valor de la coleccion.
     */
    public void setFacturas(List<FacturaEntity> facturas) {
        this.facturas = facturas;
    }

    /**
     * Devuelve la calificacion del cliente.
     *
     * @return la calificacion del cliente.
     */
    public CalificacionEntity getCalificacion() {
        return calificacion;
    }

    /**
     * Establece el valor de la calificacion del cliente.
     *
     * @param calificacion nuevo valor de la calificacion.
     */
    public void setCalificacion(CalificacionEntity calificacion) {
        this.calificacion = calificacion;
    }

    /**
     * @return the correo
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * @param correo the correo to set
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * @return the telefono
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * @return the imagen
     */
    public String getImagen() {
        return imagen;
    }

    /**
     * @param imagen the imagen to set
     */
    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

}
