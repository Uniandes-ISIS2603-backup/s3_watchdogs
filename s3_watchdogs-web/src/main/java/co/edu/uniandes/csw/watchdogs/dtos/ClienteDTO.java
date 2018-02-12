/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.watchdogs.dtos;

import co.edu.uniandes.csw.watchdogs.entities.ClienteEntity;

/**
 * ClienteDTO Objeto de transferencia de datos de Clientes. Los DTO contienen las
 * representaciones de los JSON que se tranfieren entre el cliente y el servidor.
 * 
 * Al serializarse como JSON esta clase implementa el siguiente modelo: <br>
 * <pre>
 *  {
 *      "nombre": string,
 *      "cedula": string
 *  }
 * </pre>
 * Por ejemplo un cliente se representa asi: <br>
 * 
 * <pre>
 * 
 *  {
 *      "nombre": "Camilo Beltran",
 *      "cedula": "1020123456"
 *  }
 * 
 * </pre>
 * 
 * @author ca.beltran10
 */
public class ClienteDTO {
    
    private String nombre;
    private String cedula;
    
    /**
     * Constructor por defecto
     */
    public ClienteDTO() {
    }
    
    public ClienteDTO( ClienteEntity cliente ) {
        this.nombre = cliente.getNombre( );
        this.cedula = cliente.getCedula( );
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the cedula
     */
    public String getCedula() {
        return cedula;
    }

    /**
     * @param cedula the cedula to set
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
        entity.setNombre( this.nombre );
        entity.setCedula( this.cedula );
        return entity;
    }
}
