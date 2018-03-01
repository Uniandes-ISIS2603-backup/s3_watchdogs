/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.watchdogs.dtos;

import co.edu.uniandes.csw.watchdogs.entities.DisponibilidadEntity;
import co.edu.uniandes.csw.watchdogs.entities.Estado;


/**
 * DisponibilidadDTO Objeto de transferencia de datos de Watchdogs. Los DTO contienen las
 * represnetaciones de los JSON que se transfieren entre el cliente y el
 * servidor.
 * 
 * Al serializarse como JSON esta clase implementa el siguiente modelo: <br>
 * <pre>
 *   {
 *      "id": number,
 *      "matrizHorarios": string
 *   }
 * </pre>
 * Por ejemplo una ruta se representa asi:<br>
 * 
 * <pre>
 * 
 *   {
 *      "id": 1321321,
 *      "matrizHorarios": "LAD LLL DDD AAL LLD DDL" 
 *   }
 *
 * </pre>
 *
 * @author id.salazar
 */
public class DisponibilidadDTO {
    
    private Long id;
    private Estado[][] matrizHorarios;
    
    
    /** 
     * Constructor por defecto
     */
    public DisponibilidadDTO(){
        
    }
    
     /**
     * Constructor que recibe un entity
     * @param entity 
     */
    public DisponibilidadDTO(DisponibilidadEntity entity){
        this.id = entity.getId();
        this.matrizHorarios = entity.getMatrizHorarios();
    }
    
    /**
     * 
     * @return El id de la Disponibilidad
     */
    
    public long getId(){
        return id;
    }
    
    /**
     * @param id El nuevo id de la Disponibilidad
     */
    
    public void setId(long id){
        this.id = id;
    }
    
     /**
     * 
     * @return La matriz de horarios
     */
    
    public Estado[][] getMatrizHorarios(){
        return matrizHorarios;
    }
    
     /**
     * @param matrizHorarios La nueva matriz de horarios
     */
    
    public void setMatrizHorarios(Estado[][] matrizHorarios){
        this.matrizHorarios = matrizHorarios;
    }
    
    /**
     * Metodo que pasa de un DTO a un Entity
     * @return la entidad creada
     */
    public DisponibilidadEntity toEntity(){
        DisponibilidadEntity entity = new DisponibilidadEntity();
        entity.setId(id);
        entity.setMatrizHorarios(matrizHorarios);
        return entity;
    }
    
    
}
