/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.watchdogs.dtos;

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
 *      "matrizHorarios": hashcode
 *   }
 * </pre>
 * Por ejemplo una ruta se representa asi:<br>
 * 
 * <pre>
 * 
 *   {
 *      "id": 1321321,
 *      "matrizHorarios": 12379817
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
    
    
}
