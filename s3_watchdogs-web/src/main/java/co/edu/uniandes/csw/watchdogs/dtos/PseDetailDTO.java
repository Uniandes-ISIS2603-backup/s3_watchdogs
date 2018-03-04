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
    public PseDetailDTO()
    {
        super();
    }
    
    public PseDetailDTO(PseEntity entity)
    {
        super(entity);
    }
    
    @Override
    public PseEntity toEntity()
    {
       return super.toEntity();
    }
    
    
}
