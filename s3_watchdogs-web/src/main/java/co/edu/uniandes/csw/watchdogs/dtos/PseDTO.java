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
public class PseDTO {
    
    private String correo;
    
    /**
     * Constructor por defecto 
     */
    public PseDTO(){}
    
    /**
     * Convertir Entity a DTO, crea un nuevo DTO con los valores que vienen con
     * la entidad entrada por parámetro.
     * @param pse Entidad que se convertirá a DTO
     */
    public PseDTO(PseEntity pse)
    {
        this.correo = pse.getCorreo();
    }
    
    /**
     * Método que retorna el correo de la cuenta PSE
     * @return correo asosciado a la cuenta PSE
     */
    public String getCorreo()
    {
        return correo;
    }
    
    /**
     * Método que asigna un nuevo valor al correo
     * @param correo El nuevo correo a asignar.
     */
    public void setCorreo(String correo)
    {
        this.correo = correo;
    }
    
    public PseEntity toEntity()
    {
        PseEntity pseEntity = new PseEntity();
        pseEntity.setCorreo(correo);
        return pseEntity;
    }
}
