/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.watchdogs.dtos;

import co.edu.uniandes.csw.watchdogs.entities.PseEntity;

/**
 * PseDTO Objeto de transferencia de datos de Pse. Los DTO contienen las
 * represnetaciones de los JSON que se transfieren entre el cliente y el
 * servidor.
 * 
 * Al serializarse como JSON esta clase implementa el siguiente modelo: <br>
 * <pre>
 *   {
 *      "id": number,
 *      "correo: string,
 *   }
 * </pre>
 * Por ejemplo un Pse se representa asi:<br>
 * 
 * <pre>
 * 
 *   {
 *      "id": 91852,
 *      "correo: "jc.pulido@uniandes.edu.co",
 *   }
 *
/**
 *
 * @author jc.pulido
 */
public class PseDTO extends MetodoDePagoDTO{
    
    
    private String correo;
    
    /**
     * Constructor por defecto 
     */
    public PseDTO(){}
    
    public PseDTO(PseEntity entity)
    {
        super(entity);

        if(entity != null)
        {
            nombre = MetodoDePagoDTO.PSE;
            correo = entity.getCorreo();
        }
    }
    
    public PseEntity toEntity()
    {
        PseEntity entity = new PseEntity();
        entity.setCorreo(this.correo);
        entity.setNombre(this.nombre);
        entity.setId(id);
        entity.setNombre(this.nombre);
        return entity;
    }
    
    /**
     * Método que retorna el id que identifica al DTO
     * @return id asociado al DTO 
     */
    public Long getId()
    {
        return id;
    }
    
    /**
     * Método que asigna un nuevo valor al id
     * @param pId id nuevo a asignar
     */
    public void setId(Long pId)
    {
        id = pId;
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
    
}
