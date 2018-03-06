/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.watchdogs.dtos;

import co.edu.uniandes.csw.watchdogs.entities.EntrenamientoEntity;

/**
 * Al serializarse como JSON esta clase implementa el siguiente modelo: <br>
 * <pre>
 *   {
 *      "id": long,
 *      "fecha: date,
 *      "costo": double
 *      "estado": boolean
 *      "duración": double
 *      "rango": List'String'
 *      "tipo": string
 *   }
 * </pre>
 * Por ejemplo un entrenamiento se representa asi:<br>
 * 
 * <pre>
 * 
 *   {
 *      "id": 815373,
 *      "fecha: "10-10-2010",
 *      "costo": 25
 *      "estado": "1"
 *      "duración": 20.5
 *      "rango": ""
 *      "tipo": "cardio"
 *   }
 *
 * </pre>
 * @author c.martinezc1
 */
public class EntrenamientoDTO extends ServicioDTO {
    
    
    /**
     * Atributo que representa el tipo de entrenamiento
     */
    private String tipo;
    
    /**
     * Constructor por defecto
     */
    public EntrenamientoDTO(){
        
    }
    
    /**
     * Constructor donde recibe un entity
     * @param entity :objeto tipo entity
     */
    public EntrenamientoDTO(EntrenamientoEntity entity){
        super(entity);
        if(entity!=null){
            this.tipo = entity.getTipo();
        }
        
    }


    /**
     * Getter del tipo
     * @return tipo de entrenamiento
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Setter de tipo
     * @param tipo :tipo de entrenamiento
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * Metodo que cambia de DTO a Entity
     * @return entity Objeto tipo entity
     */
    @Override
    public EntrenamientoEntity toEntity(){
        EntrenamientoEntity entity = new EntrenamientoEntity();
        
        
        
        entity.setCosto(this.getCosto());
        entity.setDuracion(this.getDuracion());
        entity.setEstado(this.isEstado());
        entity.setFecha(this.getFecha());
        entity.setRango(this.getRango());
        entity.setTipo(this.tipo);
        entity.setId(this.id);
        return entity;
    }
}