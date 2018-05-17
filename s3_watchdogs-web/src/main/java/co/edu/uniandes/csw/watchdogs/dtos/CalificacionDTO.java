/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.watchdogs.dtos;

import co.edu.uniandes.csw.watchdogs.entities.CalificacionEntity;


/**
 * LugarDTO Objeto de transferencia de datos de Calificacion. Los DTO contienen las
 * representaciones de los JSON que se tranfieren entre el lugar y el servidor.
 * 
 * Al serializarse como JSON esta clase implementa el siguiente modelo: <br>
 * <pre>
 *  {
 *        "id": number,
 *        "puntaje": number
 *
 *  }
 *    
 * </pre>
 * Por ejemplo una Calificacion se representa asi: <br>
 * 
 * <pre>
 * 
 *  {
 *        "id": 5001,
 *        "puntaje": 5
 *
 *  }
 * 
 * </pre>
 * 
 * @author c.martinezc1
 */
public class CalificacionDTO {
    
    /**
     * Representa el id de la calificacion
     */
    private Long id;
   
    /**
     * representa el puntaje de la calificacion
     */
    private Integer puntaje;

    /**
     * Constructor por defecto
     */
    public CalificacionDTO() {
       
    }
    
    /**
     * Constructor que recibe un entity
     * @param entity 
     */
    public CalificacionDTO(CalificacionEntity entity){
        if(entity!=null){
            this.id = entity.getId();
            this.puntaje = entity.getPuntaje();
        }
        
    }
    
    /**
     * @return El id de la calificacion
     */
    
    public Long getId() {
        return id;
    }
    
    /**
     * @return El puntaje de la calificacion
     */
    public Integer getPuntaje() {
        return puntaje;
    }
    
    
    /**
     * @param id el nuevo id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @param puntaje el nuevo puntaje
     */
    public void setPuntaje(Integer puntaje) {
        this.puntaje = puntaje;
    }
    
    /**
     * Metodo que pasa de un DTO a un Entity
     * @return la entidad creada
     */
    public CalificacionEntity toEntity(){
        CalificacionEntity entity = new CalificacionEntity();
        entity.setId(id);
        entity.setPuntaje(puntaje);
        return entity;
    }
}
