/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.watchdogs.dtos;


/**
 *
 * @author c.martinezc1
 */
public class CalificacionDTO {
    
    private Long id;
    
    private int puntaje;

    public CalificacionDTO() {
       
    }  
    
    public CalificacionDTO(){
        
    }
    
    public Long getId() {
        return id;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }
}
