/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.watchdogs.dtos;

import co.edu.uniandes.csw.watchdogs.entities.EmpleadoEntity;

/**
 *
 * @author ca.beltran10
 */
public class EmpleadoDTO {
    //----- Atributos -----
    private Long id;
    private String imagen;
    private ServicioDTO servicio;
    private int edad;
    private String horarios;
    
    //----- Constructor -----
    
    /**
     * Constructor por defecto
     */
    public EmpleadoDTO(){
    }
    
    public EmpleadoDTO( EmpleadoEntity empleado ) {
        this.id = empleado.getId();
        this.imagen = empleado.getImagen();
        // this.servicio = empleado.getServicio();
        this.edad = empleado.getEdad();
        this.horarios = empleado.getHorarios();
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
     * @return the servicio
     */
    public ServicioDTO getServicio() {
        return servicio;
    }

    /**
     * @param servicio the servicio to set
     */
    public void setServicio(ServicioDTO servicio) {
        this.servicio = servicio;
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
    
    public EmpleadoEntity toEntity() {
        EmpleadoEntity entity = new EmpleadoEntity();
        entity.setId(this.id);
        entity.setImagen(this.imagen);
        // entity.setServicio(this.servicio);
        entity.setHorarios(this.horarios);
        return entity;
    }
    
}
