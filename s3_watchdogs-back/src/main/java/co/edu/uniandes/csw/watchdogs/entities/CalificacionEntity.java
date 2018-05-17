/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.watchdogs.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import uk.co.jemos.podam.common.PodamExclude;

/**
 *
 * @author c.martinezc1
 */
@Entity
public class CalificacionEntity extends BaseEntity implements Serializable {

    /**
     * cliente calificado
     */
    @PodamExclude
    @OneToOne
    private ClienteEntity cliente;
    
    /**
     * Empleado calificador
     */
    @PodamExclude
    @OneToOne
    private EmpleadoEntity empleado;
     
    /**
    * puntaje de la calificacion
    */
    private Integer puntaje;

    /**
     * @return the puntaje
     */
    public Integer getPuntaje() {
        return puntaje;
    }

    /**
     * @param puntaje the puntaje to set
     */
    public void setPuntaje(Integer puntaje) {
        this.puntaje = puntaje;
    }

    /**
     * @return the cliente
     */
    public ClienteEntity getCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(ClienteEntity cliente) {
        this.cliente = cliente;
    }

     /**
     * @return the empleado
     */
    public EmpleadoEntity getEmpleado() {
        return empleado;
    }
    
     /**
     * @param empleado the empleado to set
     */

    public void setEmpleado(EmpleadoEntity empleado) {
        this.empleado = empleado;
    }

}
