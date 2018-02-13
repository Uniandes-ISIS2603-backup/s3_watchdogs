/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.watchdogs.dtos;

import java.util.ArrayList;

/**
 *
 * @author m.diazt
 */
public class PaseoDTO extends ServicioDTO{
    
    private Long id;
    private Integer capMax;
    private ArrayList<String> horas;
    
    public PaseoDTO()
    {
        
    }

    /**
     * @return id 
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id Id del paseo a establecer
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return capMax
     */
    public Integer getCapMax() {
        return capMax;
    }

    /**
     * @param capMax Capacidad maxima a establecer
     */
    public void setCapMax(Integer capMax) {
        this.capMax = capMax;
    }

    /**
     * @return Lista de horas
     */
    public ArrayList<String> getHoras() {
        return horas;
    }

    /**
     * @param horas Lista de horas a establecer
     */
    public void setHoras(ArrayList<String> horas) {
        this.horas = horas;
    }
    
    
    
}
