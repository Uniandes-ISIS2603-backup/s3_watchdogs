/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.watchdogs.dtos;

/**
 *
 * @author m.diazt
 */
public class HotelDTO extends ServicioDTO{
    
    private Long id;
    private String tiempoHospedaje;
    
    /**
     * Constructor por defecto
     */
    public HotelDTO()
    {
 
    }

    /**
     * @return id del hotel
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id Id del hotel a establecer
     */
    public void setId(Long id) {
        this.id = id;
    }
     
    /**
     * @return tiempoHospedaje
     */
    public String getTiempoHospedaje()
    {
        return tiempoHospedaje;
    }
    
    /**
     * @param pTiempoHospedaje the time to set
     */
    public void setTiempoHospedaje(String pTiempoHospedaje)
    {
        this.tiempoHospedaje = pTiempoHospedaje;
    }
}
