/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.watchdogs.dtos;

import co.edu.uniandes.csw.watchdogs.entities.AseoEntity;

/**
 *
 * @author js.vacat
 */
public class AseoDTO {
    
    private Boolean dientes;
    private Boolean banho;
    private Boolean peluqueria;
    
    /**
     * Constructor por defecto
     */
    public AseoDTO(){
    }
    
     /**
     * Conviertir Entity a DTO (Crea un nuevo DTO con los valores que recibe en
     * la entidad que viene de argumento.
     *
     * @param aseo: Es la entidad que se va a convertir a DTO
     */
    public AseoDTO(AseoEntity aseo) {
        this.dientes =aseo.getDientes();
        this.banho = aseo.getBanho();
        this.peluqueria = aseo.getPeluqueria();
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
     * Convertir DTO a Entity
     *
     * @return Un Entity con los valores del DTO
     */
     public AseoEntity toEntity() {
        AseoEntity entity = new AseoEntity();
        entity.setDientes(this.dientes);
        entity.setBanho(this.banho);
        entity.setPeluqueria(this.peluqueria);
        return entity;
    }
}
