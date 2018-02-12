/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.watchdogs.dtos;

import co.edu.uniandes.csw.watchdogs.entities.ClienteEntity;

/**
 *
 * @author ca.beltran10
 */
public class ClienteDetailDTO extends ClienteDTO {
    
    /**
     * Constructor por defecto
     */
    public ClienteDetailDTO( ) {
    }
    
    /**
     * Constructor para transformar un Entity a un DTO
     * 
     * @param entity La entidad de cliente a partir de la cual se construye el objeto
     */
    public ClienteDetailDTO( ClienteEntity entity ) {
        super( entity );
    }
    
    /**
     * Transformar un DTO a un Entity
     * 
     * @return La entidad construida a partir del DTO
     */
    @Override
    public ClienteEntity toEntity( ) {
        ClienteEntity clienteE = super.toEntity();
        return clienteE;
    }
    
}
