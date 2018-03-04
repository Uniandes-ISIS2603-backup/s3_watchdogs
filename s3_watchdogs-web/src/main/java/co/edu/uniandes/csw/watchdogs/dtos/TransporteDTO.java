/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.watchdogs.dtos;

import co.edu.uniandes.csw.watchdogs.entities.TransporteEntity;

/**
 *Al serializarse como JSON esta clase implementa el siguiente modelo: <br>
 * <pre>
 *   {
 *      "id": long,
 *      "direccion: string,
 *      "recogida": int
 *      "devuelta": int
 *   }
 * </pre>
 * Por ejemplo un entrenamiento se representa asi:<br>
 * 
 * <pre>
 * 
 *   {
 *      "id": 815373,
 *      "direccion: "Cra 11 # 11",
 *      "recogida": 10:00
 *      "devuelta": 1:00
 *   }
 *
 * </pre>
 * @author c.martinezc1
 */
public class TransporteDTO {
    /**
     * identificador
     */
    private Long id;
    /**
     * Dirección de recogida y devuelta
     */
    private String direccion;
    /**
     * Hora de recogida
     */
    private Integer recogida;
    /**
     * Hora de devuelta
     */
    private Integer devuelta;
    
    /**
     * Constructor por defecto
     */
    public TransporteDTO(){
        
    }
    
    /**
     * Constructor que recibe un entity
     * @param entity 
     */
    public TransporteDTO(TransporteEntity entity){
        if(entity!=null){
            this.id = entity.getId();
            this.devuelta = entity.getDevuelta();
            this.direccion = entity.getDireccion();
            this.recogida = entity.getRecogida();
        }
        
    }

    /**
     * Setter id
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Setter direccion
     * @param direccion
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * Setter recogida
     * @param recogida 
     */
    public void setRecogida(Integer recogida) {
        this.recogida = recogida;
    }

    /**
     * Setter devuelta
     * @param devuelta 
     */
    public void setDevuelta(Integer devuelta) {
        this.devuelta = devuelta;
    }

    /**
     * Getter id
     * @return 
     */
    public Long getId() {
        return id;
    }

    /**
     * Getter direccion
     * @return 
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * Getter recogida
     * @return 
     */
    public Integer getRecogida() {
        return recogida;
    }

    /**
     * Getter devuelta
     * @return 
     */
    public Integer getDevuelta() {
        return devuelta;
    }
    
    /**
     * Metodo que pasa de un DTO a un Entity
     * @return 
     */
    public TransporteEntity toEntity(){
        TransporteEntity entity = new TransporteEntity();
        entity.setDevuelta(devuelta);
        entity.setDireccion(direccion);
        entity.setRecogida(recogida);
        return entity;
    }
}
