/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.watchdogs.entities;

import java.io.Serializable;

/**
 *
 * @author js.vacat
 */
public class AseoEntity extends ServicioEntity implements Serializable {
    private Boolean dientes;
    private Boolean banho;
    private Boolean peluqueria;

    /**
     * @return the dientes
     */
    public Boolean getDientes() {
        return dientes;
    }

    /**
     * @param dientes the dientes to set
     */
    public void setDientes(Boolean dientes) {
        this.dientes = dientes;
    }

    /**
     * @return the banho
     */
    public Boolean getBanho() {
        return banho;
    }

    /**
     * @param banho the banho to set
     */
    public void setBanho(Boolean banho) {
        this.banho = banho;
    }

    /**
     * @return the peluqueria
     */
    public Boolean getPeluqueria() {
        return peluqueria;
    }

    /**
     * @param peluqueria the peluqueria to set
     */
    public void setPeluqueria(Boolean peluqueria) {
        this.peluqueria = peluqueria;
    }

   
}
