/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.watchdogs.dtos;

import co.edu.uniandes.csw.watchdogs.entities.MascotaEntity;


/**
 * Clase que extiende de {@link MascotaDTO} para manejar la transformacion entre
 * los objetos JSON y las Entidades de la base de datos. Para conocer el
 * contenido de la mascota vaya a la documentacion de {@link MascotaDTO}
 * 
 * @author ca.beltran10
 */
public class MascotaDetailDTO extends MascotaDTO {
    
    //----- Constructor -----
    
    /**
     * Constructor por defecto
     */
    public MascotaDetailDTO() {
    }
    
    /**
     * Constructor para transformar un Entity a un DTO
     * 
     * @param entity La entidad de la mascota a partir de la cual se construye el objeto
     */
    public MascotaDetailDTO(MascotaEntity entity) {
        super(entity);
    }
    
    /**
     * Transformar un DTO a un Entity
     * 
     * @return La entidad construida a partir del DTO
     */
    @Override
    public MascotaEntity toEntity() {
        MascotaEntity mascotaE = super.toEntity();
        return mascotaE;
    }
}
