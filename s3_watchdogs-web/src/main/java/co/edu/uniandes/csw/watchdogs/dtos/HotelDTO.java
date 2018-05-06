/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.watchdogs.dtos;

import co.edu.uniandes.csw.watchdogs.entities.HotelEntity;

/**
 * HotelDTO Objeto de transferencia de datos de Hoteles. Los DTO contienen las
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
 *      "tiempoHospedaje": Integer
 *   }
 * </pre> Por ejemplo un hotel se representa asi:<br>
 *
 * <pre>
 *
 *   {
 *      "id": 1889
 *      "fecha: "10-10-2010",
 *      "costo": 25,
 *      "estado": "1",
 *      "duración": 20.5,
 *      "rango": "",
 *      "tiempoHospedaje": 48
 *   }
 *
 * </pre>
 *
 * @author m.diazt
 */
public class HotelDTO extends ServicioDTO {

    private Integer tiempoHospedaje; //En horas

    /**
     * Constructor por defecto
     */
    public HotelDTO() {

    }

    public HotelDTO(HotelEntity entity) {
        super(entity);
        this.setTiempoHospedaje(entity.getTiempoHospedaje());
    }

    /**
     * @return tiempoHospedaje
     */
    public Integer getTiempoHospedaje() {
        return tiempoHospedaje;
    }

    /**
     * @param pTiempoHospedaje the time to set
     */
    public void setTiempoHospedaje(Integer pTiempoHospedaje) {
        this.tiempoHospedaje = pTiempoHospedaje;
    }

    public HotelEntity toEntity() {
        HotelEntity entity = new HotelEntity();
        entity.setId(this.getId());
        entity.setCosto(this.getCosto());
        entity.setDuracion(this.getDuracion());
        entity.setEstado(this.isEstado());
        entity.setFecha(this.getFecha());
        entity.setRango(this.getRango());
        entity.setTiempoHospedaje(this.getTiempoHospedaje());
        return entity;
    }
}
