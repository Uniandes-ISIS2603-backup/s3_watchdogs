/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.watchdogs.dtos;

import co.edu.uniandes.csw.watchdogs.entities.ClienteEntity;

/**
 * ClienteDTO Objeto de transferencia de datos de Clientes. Los DTO contienen
 * las representaciones de los JSON que se tranfieren entre el cliente y el
 * servidor.
 *
 * Al serializarse como JSON esta clase implementa el siguiente modelo: <br>
 * <pre>
 *  {
 *      "id": number,
 *      "name": string,
 *      "cedula": string
 *  }
 * </pre> Por ejemplo un cliente se representa asi: <br>
 *
 * <pre>
 *
 *  {
 *      "id": 1,
 *      "name": "Camilo Beltran",
 *      "cedula": "1020123456"
 *  }
 *
 * </pre>
 *
 * @author ca.beltran10
 */
public class ClienteDTO {

    private Long id;
    private String name;
    private String cedula;

    /**
     * Constructor por defecto
     */
    public ClienteDTO() {
    }

    /**
     * Convertir Entity a DTO (Crea un nuevo DTO con los valores que recibe en
     * la entidad que viene de argumento
     *
     * @param cliente: Es la entidad que se va a convertir a DTO
     */
    public ClienteDTO(ClienteEntity cliente) {
        this.id = cliente.getId();
        this.name = cliente.getName();
        this.cedula = cliente.getCedula();
    }

    /**
     * @return El ID del cliente
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id El nuevo Id del cliente
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return El nombre del cliente
     */
    public String getNombre() {
        return name;
    }

    /**
     * @param nombre El nuevo nombre del cliente
     */
    public void setNombre(String nombre) {
        this.name = nombre;
    }

    /**
     * @return La cedula del cliente
     */
    public String getCedula() {
        return cedula;
    }

    /**
     * @param cedula La nueva cedula del cliente
     */
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    /**
     * Convertir DTO a Entity
     *
     * @return Un Entity con los valores del DTO
     */
    public ClienteEntity toEntity() {
        ClienteEntity entity = new ClienteEntity();
        entity.setId(this.id);
        entity.setName(this.name);
        entity.setCedula(this.cedula);
        return entity;
    }

}
