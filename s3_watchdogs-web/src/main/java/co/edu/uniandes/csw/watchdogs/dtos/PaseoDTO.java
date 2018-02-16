/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.watchdogs.dtos;

import java.util.ArrayList;

/**
 * PaseoDTO Objeto de transferencia de datos de Paseos. Los DTO contienen las
 * represnetaciones de los JSON que se transfieren entre el cliente y el
 * servidor.
 * 
 * Al serializarse como JSON esta clase implementa el siguiente modelo: <br>
 * <pre>
 *   {
 *      "id": Long,
 *      "fecha: Date,
 *      "costo": Double,
 *      "estado": Boolean,
 *      "duración": Double,
 *      "rango": List'String',
 *      "capMax": Integer,
 *      "horas": List'String'
 *   }
 * </pre>
 * Por ejemplo un paseo se representa asi:<br>
 * 
 * <pre>
 * 
 *   {
 *      "id": 18859,
 *      "fecha:" 10-10-2010",
 *      "costo": 25,
 *      "estado": "1",
 *      "duración": 20.5,
 *      "rango": "",
 *      "capMax": 10,
 *      "horas": ""
 *   }
 *
 * </pre>
 *
 * @author m.diazt
 */
public class PaseoDTO extends ServicioDTO{
    
    private Integer capMax;
    private ArrayList<String> horas;
    
    public PaseoDTO()
    {
        
    }

    /**
     * @return capMax
     */
    public Integer getCapMax() {
        return capMax;
    }

    /**
     * @param capMax Capacidad maxima a establecer
     */
    public void setCapMax(Integer capMax) {
        this.capMax = capMax;
    }

    /**
     * @return Lista de horas
     */
    public ArrayList<String> getHoras() {
        return horas;
    }

    /**
     * @param horas Lista de horas a establecer
     */
    public void setHoras(ArrayList<String> horas) {
        this.horas = horas;
    }
    
    
    
}
