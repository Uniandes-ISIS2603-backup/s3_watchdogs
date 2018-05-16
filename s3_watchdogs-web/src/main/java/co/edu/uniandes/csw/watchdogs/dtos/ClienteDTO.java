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

    //==========================================================================================
    // Atributos
    //==========================================================================================
    
    /**
     * id del cliente
     */
    private Long id;
    
    /**
     * nombre del cliente
     */
    private String name;
    
    /**
     * cedula del cliente
     */
    private String cedula;
    
    /**
     * correo del cliente
     */
    private String correo;
    
    /**
     * telefono del cliente
     */
    private String telefono;
    
    /**
     * ruta de la imagen del cliente
     */
    private String imagen;

    //==========================================================================================
    // Metodos
    //==========================================================================================
    /**
     * Constructor por defecto.
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
        this.correo = cliente.getCorreo();
        this.telefono = cliente.getTelefono();
        this.imagen = cliente.getImagen();
    }

    /**
     * Convertir DTO a Entity
     *
     * @return Un Entity con los valores del DTO
     */
    public ClienteEntity toEntity() {
        ClienteEntity entity = new ClienteEntity();
        entity.setId(this.getId());
        entity.setName(this.getName());
        entity.setCedula(this.getCedula());
        entity.setCorreo(this.getCorreo());
        entity.setImagen(this.getImagen());
        entity.setTelefono(this.getTelefono());
        return entity;
    }

    //==========================================================================================
    // Getters y Setters
    //==========================================================================================
    /**
     * Metodo que retorna el id del cliente.
     *
     * @return El ID del cliente
     */
    public Long getId() {
        return id;
    }

    /**
     * Metodo que modifica el valor del id del cliente.
     *
     * @param id El nuevo Id del cliente
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Metodo que retorna la cedula del cliente.
     *
     * @return La cedula del cliente
     */
    public String getCedula() {
        return cedula;
    }

    /**
     * Metodo que modifica el valor de la cedula del cliente.
     *
     * @param cedula La nueva cedula del cliente
     */
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    /**
     * Metodo que retorna el nombre del cliente.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Metodo que modifica el valor del nombre del cliente.
     *
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Metodo que retorna el correo del cliente.
     *
     * @return the correo
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * Metodo que modifica el valor del correo del cliente.
     *
     * @param correo the correo to set
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * Metodo que retorna el telefono del cliente.
     *
     * @return the telefono
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Metodo que modifica el valor del telefono del cliente.
     *
     * @param telefono the telefono to set
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * Metodo que retorna la imagen del cliente.
     *
     * @return the imagen
     */
    public String getImagen() {
        return imagen;
    }

    /**
     * Metodo que modifica el valor de la imagen del cliente.
     *
     * @param imagen the imagen to set
     */
    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

}
