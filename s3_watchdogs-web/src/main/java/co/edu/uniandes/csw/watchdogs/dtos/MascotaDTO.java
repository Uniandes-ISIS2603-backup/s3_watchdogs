/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.watchdogs.dtos;

import co.edu.uniandes.csw.watchdogs.entities.MascotaEntity;


/**
 * MascotaDTO Objeto de transferencia de datos de Mascotas. Los DTO contienen las
 * representaciones de los JSON que se transfieren entre el cliente y el
 * servidor.
 * 
 * Al serializarse como JSON esta clase implementa el siguiente modelo: <br>
 * <pre>
 *  {
 *      "id": numbre,
 *      "nombre": string,
 *      "raza": string,
 *      "color": string,
 *      "sexo": string
 *  }
 * </pre>
 * Por ejemplo una mascota se representa asi:<br>
 * 
 * <pre>
 * 
 *  {
 *      "id": 5263,
 *      "nombre": "Negra",
 *      "raza": "Criolla",
 *      "color": "Negro",
 *      "sexo": Hembra
 *  }
 * 
 * </pre>
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
    
    /**
     * Convertir Entity a DTO (Crea un nuevo DTO con los valores que recibe en
     * la entidad que viene de argumento.)
     * 
     * @param mascotaE: El la entidad que se va a convertir en DTO
     */
    public MascotaDTO(MascotaEntity mascotaE) {
        this.id = mascotaE.getId();
        this.nombre = mascotaE.getNombre();
        this.raza = mascotaE.getRaza();
        this.sexo = mascotaE.getSexo();
    }
   

    /**
     * @return El id de la mascota
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id El nuevo id de la mascota
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return El nombre de la mascota
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre El nuevo nombre de la mascota
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return La raza de la mascota
     */
    public String getRaza() {
        return raza;
    }

    /**
     * @param raza La nueva raza de la mascota
     */
    public void setRaza(String raza) {
        this.raza = raza;
    }

    /**
     * @return El color de la mascota
     */
    public String getColor() {
        return color;
    }

    /**
     * @param color El nuevo color de la mascota
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * @return El sexo de la mascota
     */
    public String getSexo() {
        return sexo;
    }

    /**
     * @param sexo El nuevo sexo de la mascota
     */
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    
    /**
     * Convertir un DTO a Entity
     * 
     * @return Un Entity con los valores del DTO
     */
    public MascotaEntity toEntity() {
        MascotaEntity entity = new MascotaEntity();
        entity.setId(this.id);
        entity.setNombre(this.nombre);
        entity.setColor(this.color);
        entity.setRaza(this.raza);
        entity.setSexo(this.sexo);
        return entity;
    }
   
}