/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.watchdogs.dtos;


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
     * Getter del tipo
     * @return tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Setter de tipo
     * @param tipo
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}