/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.watchdogs.dtos;

import co.edu.uniandes.csw.watchdogs.entities.AseoEntity;


/**
 * AseoDTO Objeto de transferencia de datos de Aseo. Los DTO contienen las
 * representaciones de los JSON que se tranfieren entre el servicio de aseo y el servidor.
 * 
 * Al serializarse como JSON esta clase implementa el siguiente modelo: <br>
 * <pre>
 *  {
 *      "id": Long,
 *      "fecha: Date,
 *      "costo": Double,
 *      "estado": Boolean,
 *      "duración": Double,
 *      "rango": List'String'
 *      "dientes": Boolean,
 *      "banho": Boolean,
 *      "peluqueria": Boolean
 *  }
 * </pre>
 * Por ejemplo un servicio de aseo se representa asi: <br>
 * 
 * <pre>
 * 
 *  {
 *      "id": 1889
 *      "fecha: "10-10-2010",
 *      "costo": 25,
 *      "estado": "1",
 *      "duración": 20.5,
 *      "rango": "",
 *      "dientes": true,
 *      "banho": true,
 *      "peluqueria": true
 *  }
 * 
 * </pre>
 * 
 * @author js.vacat
 */
public class AseoDTO extends ServicioDTO{
    
//    private Long id;
    private Boolean dientes;
    private Boolean banho;
    private Boolean peluqueria;
    
    /**
     * Constructor por defecto
     */
    public AseoDTO(){
    }
    
    /**
     * Convertir Entity a DTO (Crea un nuevo DTO con los valores que recibe en
     * la entidad que viene de argumento
     * 
     * @param entity: Es la entidad que se va a convertir a DTO
     */
    public AseoDTO(AseoEntity entity) {
        super(entity);
        this.dientes = entity.getDientes();
        this.banho = entity.getBanho();
        this.peluqueria = entity.getPeluqueria();
    }

    /**
     * @return El servico de dientes
     */
    public Boolean getDientes() {
        return dientes;
    }

    /**
     * @param dientes El nuevo Servico de dientes
     */
    public void setDientes(Boolean dientes) {
        this.dientes = dientes;
    }

    /**
     * @return El servicio de banho
     */
    public Boolean getBanho() {
        return banho;
    }

    /**
     * @param banho El nuevo Servico de banho
     */
    public void setBanho(Boolean banho) {
        this.banho = banho;
    }

    /**
     * @return El Servicio de peluqueria
     */
    public Boolean getPeluqueria() {
        return peluqueria;
    }

    /**
     * @param peluqueria El nuevo Servico de peluqueria
     */
    public void setPeluqueria(Boolean peluqueria) {
        this.peluqueria = peluqueria;
    }
    
     /**
     * Convertir un DTO a un Entity
     * 
     * @return Un entity con los valores del DTO
     */
    public AseoEntity toEntity() {
        AseoEntity entity = new AseoEntity();
        entity.setId(this.id);
        entity.setCosto(this.costo);
        entity.setDuracion(this.duracion);
        entity.setEstado(this.estado);
        entity.setFecha(this.fecha);
        entity.setRango(this.rango);
        entity.setPeluqueria(this.peluqueria);
        entity.setDientes(this.dientes);
        entity.setBanho(this.banho);
        return entity;
    }
}
