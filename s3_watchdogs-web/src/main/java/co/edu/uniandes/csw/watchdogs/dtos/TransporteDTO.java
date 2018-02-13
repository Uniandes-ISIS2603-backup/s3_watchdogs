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
public class TransporteDTO {
    /**
     * identificador
     */
    private Long id;
    /**
     * Dirección de recogida y devuelta
     */
    private String direccion;
    /**
     * Hora de recogida
     */
    private int recogida;
    /**
     * Hora de devuelta
     */
    private int devuelta;
    
    /**
     * Constructor por defecto
     */
    public TransporteDTO(){
        
    }
   

    /**
     * Setter id
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Setter direccion
     * @param direccion
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * Setter recogida
     * @param recogida 
     */
    public void setRecogida(int recogida) {
        this.recogida = recogida;
    }

    /**
     * Setter devuelta
     * @param devuelta 
     */
    public void setDevuelta(int devuelta) {
        this.devuelta = devuelta;
    }

    /**
     * Getter id
     * @return 
     */
    public Long getId() {
        return id;
    }

    /**
     * Getter direccion
     * @return 
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * Getter recogida
     * @return 
     */
    public int getRecogida() {
        return recogida;
    }

    /**
     * Getter devuelta
     * @return 
     */
    public int getDevuelta() {
        return devuelta;
    }
}
