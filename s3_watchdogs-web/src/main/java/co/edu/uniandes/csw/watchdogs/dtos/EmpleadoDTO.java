/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.watchdogs.dtos;

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
    private String horarios;
    
    //----- Constructor -----
    
    /**
     * Constructor por defecto
     */
    public EmpleadoDTO(){
    }
    
    public EmpleadoDTO(EmpleadoEntity empleado) {
        this.id = empleado.getId();
        this.nombre = empleado.getName();
        this.imagen = empleado.getImagen();
    }
   
    //----- Metodos -----

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

    /**
     * @return the edad
     */
    public int getEdad() {
        return edad;
    }

    /**
     * @param edad the edad to set
     */
    public void setEdad(int edad) {
        this.edad = edad;
    }

    /**
     * @return the horarios
     */
    public String getHorarios() {
        return horarios;
    }

    /**
     * @param horarios the horarios to set
     */
    public void setHorarios(String horarios) {
        this.horarios = horarios;
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
    
}
