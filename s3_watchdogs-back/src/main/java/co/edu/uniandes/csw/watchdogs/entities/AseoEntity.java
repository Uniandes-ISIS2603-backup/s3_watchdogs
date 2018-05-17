/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.watchdogs.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import uk.co.jemos.podam.common.PodamExclude;

/**
 *
 * @author js.vacat
 */
@Entity
public class AseoEntity extends ServicioEntity implements Serializable {

    /**
     * Representa si el Aseo incluye servicio de dientes
     */
    private Boolean dientes;

    /**
     * Representa si el Aseo incluye servicio de baño
     */
    private Boolean banho;

    /**
     * Representa si el Aseo incluye servicio de peluquería
     */
    private Boolean peluqueria;

    /**
     * Representa la relación del servicio de Aseo con la veterinaria
     */
    @PodamExclude
    @ManyToOne
    private VeterinariaEntity veterinaria;

    /**
     * Constructor vacío por defecto.
     */
    public AseoEntity() {
        super();
    }

    /**
     * @return la veterinaria relacionada con el servicio
     */
    public VeterinariaEntity getVeterinaria() {
        return veterinaria;
    }

    /**
     * @param veterinaria la nueva veterinaria relacionada con el servicio
     */
    public void setVeterinaria(VeterinariaEntity veterinaria) {
        this.veterinaria = veterinaria;
    }

    /**
     * @return El servicio de dientes
     */
    public Boolean getDientes() {
        return dientes;
    }

    /**
     * @param dientes El nuevo servicio de dientes
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
     * @param banho El nuevo servicio de banho
     */
    public void setBanho(Boolean banho) {
        this.banho = banho;
    }

    /**
     * @return El servicio de peluqueria
     */
    public Boolean getPeluqueria() {
        return peluqueria;
    }

    /**
     * @param peluqueria El nuevo servicio de peluqueria
     */
    public void setPeluqueria(Boolean peluqueria) {
        this.peluqueria = peluqueria;
    }

}
