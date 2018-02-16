/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.watchdogs.dtos;


/**
 *
 * @author ca.beltran10
 */
public class EmpleadoDTO {
    //----- Atributos -----
    private Long id;
    private String imagen;
    private int edad;
    private String horarios;
    
    //----- Constructor -----
    
    /**
     * Constructor por defecto
     */
    public EmpleadoDTO(){
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
    
}
