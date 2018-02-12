/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.watchdogs.dtos;

import co.edu.uniandes.csw.watchdogs.entities.PayPalEntity;

/**
 *
 * @author jc.pulido
 */
public class PayPalDetailDTO extends PayPalDTO {
    
    /**
     * constructor por defecto
     */
    public PayPalDetailDTO(){}
    
      /**
     * Constructor que tranforma un entity en un DTO
     * @param payPalE Entidad de paypal a partir de la cual se construye el objeto.
     */
    public PayPalDetailDTO(PayPalEntity payPalE)
    {
        super(payPalE);
    }
    
     /**
     * Transformar un DTO a un Entity 
     * @return La entidad construida a partir del DTO
     */
    @Override
    public PayPalEntity toEntity()
    {
        return super.toEntity();
    }
    
}
