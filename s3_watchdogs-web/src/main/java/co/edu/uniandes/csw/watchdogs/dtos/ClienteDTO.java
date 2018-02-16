/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.watchdogs.dtos;


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
    
    private Long id;
    private String nombre;
    private String cedula;
    
    /**
     * Constructor por defecto
     */
    public ClienteDTO() {
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
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }
}
