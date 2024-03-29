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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import uk.co.jemos.podam.common.PodamExclude;

/**
 * Clase que representa una entidad de mascota para ser generada en la base de
 * datos.
 *
 * @author ca.beltran10
 */
@Entity
public class MascotaEntity extends BaseEntity implements Serializable {

    /**
     * Relacion con los servicios de la mascota.
     */
    @PodamExclude
    @OneToMany(mappedBy = "mascota", fetch = FetchType.LAZY)
    private List<ServicioEntity> servicios = new ArrayList<>();

    /**
     * Relacion con el cliente de la mascota.
     */
    @PodamExclude
    @ManyToOne(cascade = CascadeType.PERSIST)
    private ClienteEntity cliente;

    /**
     * Raza de la mascota.
     */
    private String raza;

    /**
     * Color de la mascota.
     */
    private String color;

    /**
     * Sexo de la mascota.
     */
    private String sexo;

    /**
     * Imagen de la mascota.
     */
    private String imagen;

    /**
     * Obtiene el atributo servicio.
     *
     * @return atributo servicio
     */
    public List<ServicioEntity> getServicios() {
        return servicios;
    }

    /**
     * Establece el valor del atributo servicio.
     *
     * @param servicios nuevo valor del atributo
     */
    public void setServicios(List<ServicioEntity> servicios) {
        this.servicios = servicios;
    }

    /**
     * Obtiene el atributo cliente.
     *
     * @return atributo cliente.
     */
    public ClienteEntity getCliente() {
        return cliente;
    }

    /**
     * Establece el valor del atributo cliente.
     *
     * @param cliente nuevo valor del atributo
     */
    public void setCliente(ClienteEntity cliente) {
        this.cliente = cliente;
    }

    /**
     * Obtiene el atributo raza.
     *
     * @return atributo raza.
     */
    public String getRaza() {
        return raza;
    }

    /**
     * Establece el valor del atributo raza.
     *
     * @param raza nuevo valor del atributo
     */
    public void setRaza(String raza) {
        this.raza = raza;
    }

    /**
     * Obtiene el valor del atributo color.
     *
     * @return nuevo valor del atributo
     */
    public String getColor() {
        return color;
    }

    /**
     * Establece el valor del atributo color.
     *
     * @param color nuevo valor del atributo.
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * Obtiene el atributo sexo.
     *
     * @return atributo sexo.
     */
    public String getSexo() {
        return sexo;
    }

    /**
     * Establece el valor del atributo sexo.
     *
     * @param sexo nuevo valor del atributo.
     */
    public void setSexo(String sexo) {
        this.sexo = sexo;
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
