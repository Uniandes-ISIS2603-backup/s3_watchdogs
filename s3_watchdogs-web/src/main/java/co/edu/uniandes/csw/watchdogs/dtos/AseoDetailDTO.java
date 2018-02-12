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
public class AseoDetailDTO extends AseoDTO{
   
     /**
     * Constructor por defecto
     */
    public AseoDetailDTO() {
    }
    
    /**
     * Constructor para transformar un Entity a un DTO
     *
     * @param entity La entidad de ciudad a partir de la cual se construye el objeto
     */
    public AseoDetailDTO(AseoEntity entity) {
        super(entity);
    }
    
     /**
     * Transformar un DTO a un Entity
     *
     * @return  La entidad construida a partir del DTO.
     */
    @Override
    public AseoEntity toEntity() {
        AseoEntity aseoE = super.toEntity();
        return aseoE;
    }
}
