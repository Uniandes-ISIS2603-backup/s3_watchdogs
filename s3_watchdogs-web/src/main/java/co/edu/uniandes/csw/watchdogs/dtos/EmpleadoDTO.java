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
 *      "imagen": string,
 *      "edad": integer
 *      "horarios": string
 *  }
 * </pre>
 * Por ejemplo un empleado se representa asi:<br>
 * 
 * <pre>
 *  {
 *      "id": 95873,
 *      "nombre": "Camilo",
 *      "imagen": "abg.jpg",
 *      "edad": 24
 *      "horarios": "No se como es"
 *  }
 * </pre>
 * @author ca.beltran10
 */
public class EmpleadoDTO {
    //----- Atributos -----
    private Long id;
    private String nombre;
    private String imagen;
    private int edad;
    
    //----- Constructor -----
    
    /**
     * Constructor por defecto
     */
    public EmpleadoDTO(){
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
        this.imagen = empleado.getImagen();
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
    public int getEdad() {
        return edad;
    }

    /**
     * @param edad La nueva edad del empleado
     */
    public void setEdad(int edad) {
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
        entity.setImagen(this.imagen);
        entity.setEdad(this.edad);
        return entity;
    }
    
}
