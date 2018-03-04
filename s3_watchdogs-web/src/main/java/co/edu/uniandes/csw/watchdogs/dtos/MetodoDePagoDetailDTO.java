/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.watchdogs.dtos;

import co.edu.uniandes.csw.watchdogs.entities.MetodoDePagoEntity;

/**
 *
 * @author jc.pulido
 */
public abstract class MetodoDePagoDetailDTO extends MetodoDePagoDTO {
    
    public MetodoDePagoDetailDTO()
    {
        super();
    }
    
    public MetodoDePagoDetailDTO(MetodoDePagoEntity entity)
    {
        super(entity);
    }
    
    public MetodoDePagoEntity toEntity()
    {
        return null;
    }
    
}
