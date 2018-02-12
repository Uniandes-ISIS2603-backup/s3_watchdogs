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
    public TarjetaCreditoDetailDTO(){}
    
    /**
     * Constructor que tranforma un entity en un DTO
     * @param TarjetaE Entidad de tarjeta de crédito a partir de la cual se construye el objeto.
     */
    public TarjetaCreditoDetailDTO(TarjetaCreditoEntity TarjetaE)
    {
        super(TarjetaE);
    }
    
    /**
     * Transformar un DTO a un Entity 
     * @return La entidad construida a partir del DTO
     */
    @Override
    public TarjetaCreditoEntity toEntity()
    {
        TarjetaCreditoEntity tarjetaE = super.toEntity();
        return tarjetaE;
    }
}
