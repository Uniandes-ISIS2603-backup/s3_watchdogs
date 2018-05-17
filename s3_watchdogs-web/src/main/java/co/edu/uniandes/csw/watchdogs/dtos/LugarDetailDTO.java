/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.watchdogs.dtos;

import co.edu.uniandes.csw.watchdogs.entities.LugarEntity;

/**
 *
 * @author js.vacat
 */
public abstract class LugarDetailDTO extends LugarDTO {

    /**
     * Constructor por defecto
     */
    public LugarDetailDTO() {
        super();
    }

    /**
     * Constructor para transformar un Entity a un DTO
     *
     * @param entity La entidad del Lugar de la cual se construye el objeto
     */
    public LugarDetailDTO(LugarEntity entity) {
        super(entity);
    }

    /**
     * Metodo que pasa de un DTO a un Entity
     *
     * @return la entidad creada
     */
    @Override
    public LugarEntity toEntity() {
        return super.toEntity();
    }
}
