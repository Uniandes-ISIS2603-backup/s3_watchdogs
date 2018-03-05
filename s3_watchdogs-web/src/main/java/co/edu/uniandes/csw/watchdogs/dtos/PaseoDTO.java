/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.watchdogs.dtos;

import co.edu.uniandes.csw.watchdogs.entities.PaseoEntity;
import java.util.ArrayList;
import java.util.List;

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
    private List<String> horas;
    
    public PaseoDTO()
    {
        
    }
    
    public PaseoDTO(PaseoEntity entity){
        super(entity);
        this.setCapMax(entity.getCapMax());
        this.setHoras(entity.getHoras());
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
    public List<String> getHoras() {
        return horas;
    }

    /**
     * @param horas Lista de horas a establecer
     */
    public void setHoras(List<String> horas) {
        this.horas = horas;
    }
    
    public PaseoEntity toEntity(){
        PaseoEntity entity = new PaseoEntity();
        entity.setId(this.getId());
        entity.setCosto(this.getCosto());
        entity.setDuracion(this.getDuracion());
        entity.setEstado(this.isEstado());
        entity.setFecha(this.getFecha());
        entity.setRango(this.getRango());
        entity.setCapMax(this.getCapMax());
        entity.setHoras(this.getHoras());
        return entity;
    }
    
}
