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
public class PayPalDTO {
    
    private Long id;
    private String correo;
    private String contrasenha;
    
    /**
     * Constructor por defecto 
     */
    public PayPalDTO(){}
   
    
    /**
     * Método que retorna el id asociado al DTO 
     * @return id asociado 
     */
    public Long getId()
    {
        return id;
    }
    
    /**
     * Método que asigna un nuevo valor al id 
     * @param pId Nuevo id a asignar 
     */
    public void setId(Long pId)
    {
        id = pId;
    }

    /**
     * @return el correo
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * @param correo el correo a asignar
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * @return la contrasenha
     */
    public String getContrasenha() {
        return contrasenha;
    }

    /**
     * @param contrasenha la contraseña a asignar
     */
    public void setContrasenha(String contrasenha) {
        this.contrasenha = contrasenha;
    }
   
    
}
