/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.watchdogs.dtos;


/**
 *
 * @author jc.pulido
 */
public class PayPalDetailDTO extends PayPalDTO {
    
    private PayPalDTO paypal;
    
    /**
    //private ArrayList<PayPalDTO> paypal;
    private PayPalDTO paypal;
    
    public PaseoDetailDTO()
    {
        super();
    }

    /**
     * @return Lista de rutas
     */
    /**public ArrayList<RutaDTO> getRutas() {
        return rutas;
    }

    /**
     * @param rutas Lista de rutas a establecer
     */
    /**public void setRutas(ArrayList<RutaDTO> rutas) {
        this.rutas = rutas;
    }**/

    /**
     * @return veterinaria
     */
    public PayPalDTO getPayPal() {
        return paypal;
    }

    /**
     * @param paypal PayPal a establecer
     */
    public void setPayPal(PayPalDTO paypal) {
        this.paypal = paypal;
    }
    
  
    
}
