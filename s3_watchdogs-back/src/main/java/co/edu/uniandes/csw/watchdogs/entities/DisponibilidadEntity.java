/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.watchdogs.entities;

import co.edu.uniandes.csw.watchdogs.podam.DiaDisponibilidadStrategy;
import java.io.Serializable;
import javax.persistence.Entity;
import uk.co.jemos.podam.common.PodamCollection;

/**
 *
 * @author id.salazar
 */

@Entity
public class DisponibilidadEntity extends BaseEntity implements Serializable{
    
  
    @PodamCollection(nbrElements = 7,collectionElementStrategy = DiaDisponibilidadStrategy.class)
    private Estado[][] matrizHorarios ; 
    
    public DisponibilidadEntity(){
    
    }
    
     /**
     * @param matrizHorarios la nueva matriz de Horario
     */

    public void setMatrizHorarios(Estado[][] matrizHorarios){
        this.matrizHorarios = matrizHorarios;
    }
    
     /**
     * @return la matriz de horario
     */
    
    public Estado[][] getMatrizHorarios(){
    return matrizHorarios;
    }
}
