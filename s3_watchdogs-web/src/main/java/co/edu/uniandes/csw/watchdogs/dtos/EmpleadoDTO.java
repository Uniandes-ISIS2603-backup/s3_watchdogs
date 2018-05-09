/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.watchdogs.dtos;

import co.edu.uniandes.csw.watchdogs.entities.EmpleadoEntity;

/**
 * EmpleadoDTO Objeto de transferencia de datos de Empleados. Los DTO contienen
 * las representaciones de los JSON que se transfieren entre los empleados y el
 * servidor.
 *
 * Al serializarse como JSON esta clase implementa el siguiente modelo: <br>
 * <pre>
 *  {
 *      "id": number,
 *      "nombre": sttring,
 *      "cedula": string,
 *      "imagen": string,
 *      "edad": integer
 *      "correo": string,
 *      "telefono": string,
 *      "cargo": string,
 *      "horarios": string
 *  }
 * </pre> Por ejemplo un empleado se representa asi:<br>
 *
 * <pre>
 *  {
 *      "id": 95873,
 *      "nombre": "Camilo",
 *      "cedula": "1010123456",
 *      "imagen": "abg.jpg",
 *      "edad": 24
 *      "correo": "ca.beltran10@watchdogs.com",
 *      "telefono": "3106969451",
 *      "cargo": "Paseador",
 *      "horarios": "No se como es"
 *  }
 * </pre>
 *
 * @author ca.beltran10
 */
public class EmpleadoDTO {

    //----- Atributos -----
    private Long id;
    private String nombre;
    private String cedula;
    private String imagen;
    private Integer edad;
    private String correo;
    private String telefono;
    private String cargo;

    //----- Constructor -----
    /**
     * Constructor por defecto
     */
    public EmpleadoDTO() {
    }

    /**
     * Convertir Entity a DTO (Crea un nuevo DTO con los valores que recibe en
     * la entidad que viene de argumento
     *
     * @param empleado: Es la entidad que se va a convertir a DTO
     */
    public EmpleadoDTO(EmpleadoEntity empleado) {
        this.id = empleado.getId();
        this.nombre = empleado.getName();
        this.cedula = empleado.getCedula();
        this.imagen = empleado.getImagen();
        this.edad = empleado.getEdad();
        this.correo = empleado.getCorreo();
        this.cargo = empleado.getCargo();
        this.telefono = empleado.getTelefono();
    }

    //----- Metodos -----
    /**
     * @return El id del empleado
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id El nuevo id del empleado
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return La ruta de la imagen del empleado
     */
    public String getImagen() {
        return imagen;
    }

    /**
     * @param imagen La nueva ruta de la imagen del empleado
     */
    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    /**
     * @return La edad del empleado
     */
    public Integer getEdad() {
        return edad;
    }

    /**
     * @param edad La nueva edad del empleado
     */
    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    /**
     * @return El nombre del empleado
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre El nuevo nombre del empleado
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Convertir un DTO a un Entity
     *
     * @return Un entity con los valores del DTO
     */
    public EmpleadoEntity toEntity() {
        EmpleadoEntity entity = new EmpleadoEntity();
        entity.setId(this.id);
        entity.setName(this.nombre);
        entity.setCedula(this.cedula);
        entity.setImagen(this.imagen);
        entity.setEdad(this.edad);
        entity.setCorreo(this.correo);
        entity.setCargo(this.cargo);
        entity.setTelefono(this.telefono);
        return entity;
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
     * @return the telefono
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * @param telefono the cedula to set
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    
    
    /**
     * @return the cargo
     */
    public String getCargo() {
        return cargo;
    }

    /**
     * @param cargo the cargo to set
     */
    public void setCargo(String cargo) {
        this.cargo = cargo;
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


}
