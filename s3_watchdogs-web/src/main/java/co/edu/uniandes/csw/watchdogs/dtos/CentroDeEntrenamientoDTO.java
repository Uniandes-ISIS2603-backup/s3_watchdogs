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
public class CentroDeEntrenamientoDTO extends LugarDTO{
    
    private Long id;
    
    /**
     * Constructor por defecto
     */
    public CentroDeEntrenamientoDTO()
    {
        
    }

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id Id del C.E a establecer
     */
    public void setId(Long id) {
        this.id = id;
    }
    
    
    
}
