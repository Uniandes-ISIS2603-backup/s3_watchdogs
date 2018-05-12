/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.watchdogs.podam;

import co.edu.uniandes.csw.watchdogs.entities.EmpleadoEntity;
import java.util.Random;
import uk.co.jemos.podam.common.AttributeStrategy;

/**
 *
 * @author id.salazar
 */
public class CargoStrategy implements AttributeStrategy<String>{
    
    @Override
    public String getValue() {
        return cargoValido();
    }
    
    private String cargoValido() {
        
        String rta = "";
        Random rnd = new Random();
        int choice = rnd.nextInt(4);
        if(choice == 0){
            rta = EmpleadoEntity.PASEADOR;
        }else if(choice == 1){
            rta = EmpleadoEntity.ASEADOR;
        }else if(choice ==2){
            rta = EmpleadoEntity.ENTRENADOR;
        }else{
            rta = EmpleadoEntity.CUIDADOR;
        }
        return rta;
    }
    
}
