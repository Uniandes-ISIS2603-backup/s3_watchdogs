/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.watchdogs.dtos;
/**
 * RutaDTO Objeto de transferencia de datos de Watchdogs. Los DTO contienen las
 * represnetaciones de los JSON que se transfieren entre el cliente y el
 * servidor.
 * 
 * Al serializarse como JSON esta clase implementa el siguiente modelo: <br>
 * <pre>
 *   {
 *      "id": number,
 *      "duracion": number
 *   }
 * </pre>
 * Por ejemplo una ruta se representa asi:<br>
 * 
 * <pre>
 * 
 *   {
 *      "id": 1321321,
 *      "duracion": 1
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
     * 
     * @return El id de la ruta
     */
    
    public long getId(){
        return id;
    }
    
    /**
     * @param id El nuevo id de la ruta
     */
    
    public void setId(long id){
        this.id = id;
    }
    
    /**
     * 
     * @return La duración de la ruta
     */
    
    public int getDuracion(){
        return duracion;
    }
    
    /**
     * @param duracion La nueva duración de la ruta
     */
    
    public void setDuracion(int duracion){
        this.duracion = duracion;
    }

}
