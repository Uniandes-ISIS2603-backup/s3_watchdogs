/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.watchdogs.dtos;

import co.edu.uniandes.csw.watchdogs.entities.PseEntity;

/**
 *
 * @author jc.pulido
 */
public class PseDetailDTO extends PseDTO {
    
    /**
     * Constructor por defecto
     */
    public PseDetailDTO(){}
    
    /**
     * Constructor que tranforma un entity en un DTO
     * @param pse Entidad de pse a partir de la cual se construye el objeto.
     */
    public PseDetailDTO(PseEntity pse)
    {
        super(pse);
    }
    
    /**
     * Transformar un DTO a un Entity 
     * @return La entidad construida a partir del DTO
     */
    @Override
    public PseEntity toEntity()
    {
        PseEntity pseE = super.toEntity();
        return pseE;
    }
    
}
