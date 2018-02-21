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
 *      "fotos": List'String'
 *  }
 * </pre>
 * Por ejemplo un Lugar se representa asi: <br>
 * 
 * <pre>
 * 
 *  {
 *      "direccion": "cra33#47-06",
 *      "fotos": " "
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
    
     /**
     * Constructor por defecto
     */
    public LugarDTO() {
    }

    public LugarDTO(LugarEntity lugar) {
        this.id = lugar.getId();
        this.direccion = lugar.getDireccion();
        this.fotos = lugar.getFotos();
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
    
     /**
     * Convertir un DTO a un Entity
     * 
     * @return Un entity con los valores del DTO
     */
    public LugarEntity toEntity() {
        LugarEntity entity = new LugarEntity() {};
        entity.setId(this.id);
        entity.setFotos(this.fotos);
        entity.setDireccion(this.direccion);
        return entity;
    }
    
}
