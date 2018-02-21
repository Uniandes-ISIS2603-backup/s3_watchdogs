/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.watchdogs.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author js.vacat
 */
@Entity
public class AseoEntity extends ServicioEntity implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Boolean dientes;
    private Boolean banho;
    private Boolean peluqueria;

    /**
     * @return el id que entra por parametro
     */
  //  public Long getId() {
   //     return id;
  //  }

    /**
     * @param id que entra por parametro
     */
 //   public void setId(Long id) {
  //      this.id = id;
  //  }

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
    
    //@Override
   // public boolean equals(Object obj) {
          //      if (this.getId() != null && ((AseoEntity) obj).getId() != null) {
         //   return this.getId().equals(((AseoEntity) obj).getId());
    //    }
     //   return super.equals(obj);
   // }
    
  //  @Override
  //  public int hashCode() {
   //     if (this.getId() != null) {
     //       return this.getId().hashCode();
     //   }
     //   return super.hashCode();
    //}
}
