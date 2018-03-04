/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.watchdogs.dtos;

import co.edu.uniandes.csw.watchdogs.entities.LugarEntity;
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
 *      "capacidadActual":Integer,
 *      "capacidadMaxima":Integer
 *  }
 * </pre>
 * Por ejemplo un Lugar se representa asi: <br>
 * 
 * <pre>
 * 
 *  {
 *      "direccion": "cra33#47-06",
 *      "fotos": " ",
 *      "capacidadActual":20,
 *      "capacidadMaxima":30
 *  }
 * 
 * </pre>
 * 
 * @author js.vacat
 */
public abstract class LugarDTO {
    
    protected Long id;
    protected String direccion;
    protected List<String> fotos;
    protected Integer capacidadActual;
    protected Integer capacidadMaxima;
    
     /**
     * Constructor por defecto
     */
    public LugarDTO() {
    }

    public LugarDTO(LugarEntity lugar) {
        if(lugar!=null)
        {
        this.id = lugar.getId();
        this.direccion = lugar.getDireccion();
        this.fotos = lugar.getFotos();
        this.capacidadActual=lugar.getCapacidadMaxima();
        this.capacidadMaxima=lugar.getCapacidadMaxima();
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
    
    public LugarEntity toEntity(){
        
        LugarEntity lugar=null;
        return lugar;
    }

    /**
     * @return la capacidadActual
     */
    public Integer getCapacidadActual() {
        return capacidadActual;
    }

    /**
     * @param capacidadActual la capacidadActual que entra por parametro
     */
    public void setCapacidadActual(Integer capacidadActual) {
        this.capacidadActual = capacidadActual;
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
