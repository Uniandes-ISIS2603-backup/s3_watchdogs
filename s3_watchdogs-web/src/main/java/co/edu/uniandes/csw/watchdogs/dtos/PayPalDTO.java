/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.watchdogs.dtos;

/**
 * PayPalDTO Objeto de transferencia de datos de PayPal. Los DTO contienen las
 * represnetaciones de los JSON que se transfieren entre el cliente y el
 * servidor.
 * 
 * Al serializarse como JSON esta clase implementa el siguiente modelo: <br>
 * <pre>
 *   {
 *      "id": number,
 *      "correo: string,
 *      "contrasenha": string
 *   }
 * </pre>
 * Por ejemplo un PayPal se representa asi:<br>
 * 
 * <pre>
 * 
 *   {
 *      "id": 91852,
 *      "correo: "jc.pulido@uniandes.edu.co",
 *      "contrasenha": "juanca8520"
 *   }
 *
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
