/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.watchdogs.dtos;

import co.edu.uniandes.csw.watchdogs.entities.MascotaEntity;

/**
 *
 * @author ca.beltran10
 */
public class MascotaDTO {
    
    //----- Atributos -----
    
    private Long id;
    private String nombre;
    private String raza;
    private String color;
    private String sexo;
    
    //----- Constructores -----
    
    /**
     * Constructor por defecto
     */
    public MascotaDTO() {
    }
    
    public MascotaDTO( MascotaEntity mascota ) {
        this.id = mascota.getId();
        this.nombre = mascota.getNombre();
        this.raza = mascota.getRaza();
        this.color = mascota.getColor();
        this.sexo = mascota.getSexo();
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
     * @return the raza
     */
    public String getRaza() {
        return raza;
    }

    /**
     * @param raza the raza to set
     */
    public void setRaza(String raza) {
        this.raza = raza;
    }

    /**
     * @return the color
     */
    public String getColor() {
        return color;
    }

    /**
     * @param color the color to set
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * @return the sexo
     */
    public String getSexo() {
        return sexo;
    }

    /**
     * @param sexo the sexo to set
     */
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
   
}
