/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.watchdogs.dtos;

import co.edu.uniandes.csw.watchdogs.entities.TarjetaCreditoEntity;


/**
 *
 * @author jc.pulido
 */
public class TarjetaCreditoDetailDTO extends TarjetaCreditoDTO {
    
    /**
     * Constructor por defecto
     */
    public TarjetaCreditoDetailDTO(){
        super();
    }
    
    public TarjetaCreditoDetailDTO(TarjetaCreditoEntity entity)
    {
        super(entity);
    }
    
    @Override
    public TarjetaCreditoEntity toEntity()
    {
        TarjetaCreditoEntity entity = super.toEntity();
        return entity;
    }
  
    
   
}
