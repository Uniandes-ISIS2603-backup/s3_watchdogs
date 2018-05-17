/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.watchdogs.dtos;

import co.edu.uniandes.csw.watchdogs.entities.PaseoEntity;
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
 * </pre> Por ejemplo un paseo se representa asi:<br>
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
public class PaseoDTO extends ServicioDTO {

    /**
    * Capacidad maxima de perros en el paseo
    */
    private Integer capMax;

    /**
     * 
     */
    private List<String> horas;

    /**
     * Constructor por defecto 
     */
      
    public PaseoDTO() {

    }
    
    /**
     * Constructor que recibe un entity
     * @param entity 
     */ 
    public PaseoDTO(PaseoEntity entity) {
        super(entity);
        if (entity != null) {
            this.capMax = entity.getCapMax();
            this.horas = entity.getHoras();
        }

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

    /**
     * Metodo que pasa de un DTO a un Entity
     * @return la entidad creada
     */
    @Override
    public PaseoEntity toEntity() {
        PaseoEntity entity = new PaseoEntity();
        entity.setId(this.id);
        entity.setCosto(this.costo);
        entity.setDuracion(this.duracion);
        entity.setEstado(this.estado);
        entity.setFecha(this.fecha);
        entity.setRango(this.rango);
        entity.setCapMax(this.capMax);
        entity.setHoras(this.horas);
        return entity;
    }

}
