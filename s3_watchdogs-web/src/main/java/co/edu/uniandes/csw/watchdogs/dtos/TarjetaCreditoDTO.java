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
public class TarjetaCreditoDTO {
    
    private Long id;
    private String nombre;
    private String numeroTarjeta;
    private String fechaVencimiento;
    private String CodigoSeguridad;
    
    /**
     * Constructor por defecto
     */
    public TarjetaCreditoDTO(){}
    
    /**
     * Método que transforma una entidad en un DTO
     * @param tarjetaE 
     */
    public TarjetaCreditoDTO(TarjetaCreditoEntity tarjetaE)
    {
        this.nombre = tarjetaE.getNombre();
        this.numeroTarjeta = tarjetaE.getNumTarjeta();
        this.fechaVencimiento = tarjetaE.getFechaVencimiento();
        this.CodigoSeguridad = tarjetaE.getCodigoSeguridad();
    }
    
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
     * @return nombre asociado a la tarjeta 
     */
    public String getNombre()
    {
        return nombre;
    }
    
    /**
     * 
     * @param nombre Nombre nuevo a asignar a la tarjeta
     */
    public void setNombre(String nombre)
    {
        this.nombre = nombre;
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
    
      /**
     * Convertir DTO a Entity
     *
     * @return Un Entity con los valores del DTO
     */
    public TarjetaCreditoEntity toEntity()
    {
        TarjetaCreditoEntity tarjetaE = new TarjetaCreditoEntity();
        tarjetaE.setNombre(nombre);
        tarjetaE.setNumTarjeta(numeroTarjeta);
        tarjetaE.setFechaVencimiento(fechaVencimiento);
        tarjetaE.setCodigoSeguridad(CodigoSeguridad);
        return tarjetaE;
    }
}
