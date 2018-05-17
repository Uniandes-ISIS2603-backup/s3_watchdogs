/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.watchdogs.dtos;

import co.edu.uniandes.csw.watchdogs.entities.LugarEntity;
import java.io.Serializable;
import java.util.List;

/**
 * LugarDTO Objeto de transferencia de datos de Lugar. Los DTO contienen las
 * representaciones de los JSON que se tranfieren entre el lugar y el servidor.
 *
 * Al serializarse como JSON esta clase implementa el siguiente modelo: <br>
 * <pre>
 *  {
 *      "direccion": string,
 *      "fotos": List'String',
 *      "usuariosEnServicio":Integer,
 *      "capacidadMaxima":Integer
 *  }
 * </pre> Por ejemplo un Lugar se representa asi: <br>
 *
 * <pre>
 *
 *  {
 *      "direccion": "cra33#47-06",
 *      "fotos": " ",
 *      "usuariosEnServicio":20,
 *      "capacidadMaxima":30
 *  }
 *
 * </pre>
 *
 * @author js.vacat
 */
public abstract class LugarDTO implements Serializable {

    /**
     * Id del lugar
     */
    protected Long id;

    /**
     * direccion del lugar
     */
    protected String direccion;

    /**
     * lista de fotos del lugar
     */
    protected transient List<String> fotos;

    /**
     * Ususarios en servicio
     */
    protected Integer usuariosEnServicio;

    /**
     * capacidad maxima del lugar
     */
    protected Integer capacidadMaxima;

    /**
     * Constructor por defecto
     */
    public LugarDTO() {
        super();
    }

    /**
     * Constructor que recibe un entity
     *
     * @param lugar
     */
    public LugarDTO(LugarEntity lugar) {
        if (lugar != null) {
            this.id = lugar.getId();
            this.direccion = lugar.getDireccion();
            this.fotos = lugar.getFotos();
            this.usuariosEnServicio = lugar.getUsuariosEnServicio();
            this.capacidadMaxima = lugar.getCapacidadMaxima();
        }
    }

    /**
     * @return La direccion del lugar
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * @param direccion la direccion del lugar
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * @return las fotos del lugar
     */
    public List<String> getFotos() {
        return fotos;
    }

    /**
     * @param fotos las fotos del lugar
     */
    public void setFotos(List<String> fotos) {
        this.fotos = fotos;
    }

    /**
     * @return el id del lugar
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id el ide del lugar que entra por parametro
     */
    public void setId(Long id) {
        this.id = id;
    }

    public LugarEntity toEntity() {

        LugarEntity lugar = null;
        return lugar;
    }

    /**
     * @return la usuarios En Servicio
     */
    public Integer getUsuariosEnServicio() {
        return usuariosEnServicio;
    }

    /**
     * @param usuariosEnServicio los ususarios en servicio que entra por
     * parametro
     */
    public void setUsuariosEnServicio(Integer usuariosEnServicio) {
        this.usuariosEnServicio = usuariosEnServicio;
    }

    /**
     * @return la capacidadMaxima
     */
    public Integer getCapacidadMaxima() {
        return capacidadMaxima;
    }

    /**
     * @param capacidadMaxima la capacidadMaxima que entra por parametro
     */
    public void setCapacidadMaxima(Integer capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
    }

}
