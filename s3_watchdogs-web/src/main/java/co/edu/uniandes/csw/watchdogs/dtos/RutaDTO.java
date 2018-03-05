/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.watchdogs.dtos;

import co.edu.uniandes.csw.watchdogs.entities.RutaEntity;

/**
 * RutaDTO Objeto de transferencia de datos de Watchdogs. Los DTO contienen las
 * represnetaciones de los JSON que se transfieren entre el cliente y el
 * servidor.
 * 
 * Al serializarse como JSON esta clase implementa el siguiente modelo: <br>
 * <pre>
 *   {
 *      "id": number,
 *      "duracion": number,
 *   }
 * </pre>
 * Por ejemplo una ruta se representa asi:<br>
 * 
 * <pre>
 * 
 *   {
 *      "id": 1321321,
 *      "duracion": 43,
 *   }
 *
 * </pre>
 *
 * @author id.salazar
 */
public class RutaDTO {
    
    private Long id;
    private Integer duracion;
    
     /** 
     * Constructor por defecto
     */
    public RutaDTO(){
        
    }
    
     /**
     * Constructor que recibe un entity
     * @param entity 
     */
    public RutaDTO(RutaEntity entity){
        if(entity != null){
        this.id = entity.getId();
        this.duracion = entity.getDuracion();
        }
    }
    
    /**
     * 
     * @return El id de la ruta
     */
    
    public Long getId(){
        return id;
    }
    
    /**
     * @param id El nuevo id de la ruta
     */
    
    public void setId(Long id){
        this.id = id;
    }
    
    /**
     * 
     * @return La duración de la ruta
     */
    
    public Integer getDuracion(){
        return duracion;
    }
    
    /**
     * @param duracion La nueva duración de la ruta
     */
    
    public void setDuracion(Integer duracion){
        this.duracion = duracion;
    }
    
    /**
     * Metodo que pasa de un DTO a un Entity
     * @return la entidad creada
     */
    public RutaEntity toEntity(){
        RutaEntity entity = new RutaEntity();
        entity.setId(id);
        entity.setDuracion(duracion);
        return entity;
    }

}
