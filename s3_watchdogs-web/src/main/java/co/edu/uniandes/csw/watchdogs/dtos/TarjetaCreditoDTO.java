/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.watchdogs.dtos;

/**
 * TarjetaCreditoDTO Objeto de transferencia de datos de las tarjetas de crédito. Los DTO contienen las
 * represnetaciones de los JSON que se transfieren entre el cliente y el
 * servidor.
 * 
 * Al serializarse como JSON esta clase implementa el siguiente modelo: <br>
 * <pre>
 *   {
 *      "id": number,
 *      "numeroTarjeta: string,
 *      "fechaVencimiento": string,
 *      "codigoSeguridad": String
 *   }
 * </pre>
 * Por ejemplo una tarjeta se representa asi:<br>
 * 
 * <pre>
 * 
 *   {
 *      "id": 91852,
 *      "numeroTarjeta: "1212124648794562",
 *      "fechaVencimiento": "12/2020"
 *      "codigoSeguridad": "456"
 *   }
 *
/**
 *
 * @author jc.pulido
 */
public class TarjetaCreditoDTO {
    
    private Long id;
    private String numeroTarjeta;
    private String fechaVencimiento;
    private String CodigoSeguridad;
    
    /**
     * Constructor por defecto
     */
    public TarjetaCreditoDTO(){}
  
    
    /**
     * Método que retorna el id asociado al DTO
     * @return El id asociado al DTO 
     */
    public Long getId()
    {
        return id;
    }
    
    /**
     * Método que asigna un nuevo id
     * @param pId el id a asignar
     */
    public void setId(Long pId)
    {
        id = pId;
    }
 
    
    /**
     * 
     * @return Número de la tarjeta  
     */
    public String getNumTarjeta()
    {
        return numeroTarjeta;
    }
    
    /**
     * 
     * @param numTarjeta Número de tarjeta nuevo a asignar
     */
    public void setNumTarjeta(String numTarjeta)
    {
        this.numeroTarjeta = numTarjeta;
    }
    
    /**
     * 
     * @return Fecha de vencimiento de la tarjeta 
     */
    public String getFechaVencimiento()
    {
        return fechaVencimiento;
    }
    
    /**
     * 
     * @param fecha Nueva fecha a asignar 
     */
    public void setFechaVencimiento(String fecha)
    {
        this.fechaVencimiento = fecha;
    }
    
    /**
     * 
     * @return Código de seguridad de la tarjeta de crédito
     */
    public String getCodSeguridad()
    {
        return CodigoSeguridad;
    }
    
    /**
     * 
     * @param cod Código de seguridad nuevo a asignar
     */
    public void setCodSeguridad(String cod)
    {
        this.CodigoSeguridad = cod;
    }
    
    
}
