/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.watchdogs.entities;

import co.edu.uniandes.csw.watchdogs.podam.DiaDisponibilidadStrategy;
import java.io.Serializable;
import javax.persistence.Entity;
import uk.co.jemos.podam.common.PodamStrategyValue;

/**
 *
 * @author id.salazar
 */
@Entity
public class DisponibilidadEntity extends BaseEntity implements Serializable {

    /**
     * String que representa el horario
     */
    @PodamStrategyValue(DiaDisponibilidadStrategy.class)
    private String matrizHorarios;

    public DisponibilidadEntity() {
        super();
    }

    /**
     * @param matrizHorarios la nueva matriz de Horario
     */
    public void setMatrizHorarios(String matrizHorarios) {
        this.matrizHorarios = matrizHorarios;
    }

    /**
     * @return la matriz de horario
     */
    public String getMatrizHorarios() {
        return matrizHorarios;
    }
}
