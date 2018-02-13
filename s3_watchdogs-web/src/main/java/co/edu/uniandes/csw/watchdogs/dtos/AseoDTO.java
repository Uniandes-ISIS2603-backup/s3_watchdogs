/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.watchdogs.dtos;


/**
 *
 * @author js.vacat
 */
public class AseoDTO {
    
    private Boolean dientes;
    private Boolean banho;
    private Boolean peluqueria;
    
    /**
     * Constructor por defecto
     */
    public AseoDTO(){
    }
    

    /**
     * @return El servico de dientes
     */
    public Boolean getDientes() {
        return dientes;
    }

    /**
     * @param dientes El nuevo Servico de dientes
     */
    public void setDientes(Boolean dientes) {
        this.dientes = dientes;
    }

    /**
     * @return El servicio de banho
     */
    public Boolean getBanho() {
        return banho;
    }

    /**
     * @param banho El nuevo Servico de banho
     */
    public void setBanho(Boolean banho) {
        this.banho = banho;
    }

    /**
     * @return El Servicio de peluqueria
     */
    public Boolean getPeluqueria() {
        return peluqueria;
    }

    /**
     * @param peluqueria El nuevo Servico de peluqueria
     */
    public void setPeluqueria(Boolean peluqueria) {
        this.peluqueria = peluqueria;
    }
}
