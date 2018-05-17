/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.watchdogs.podam;

import java.util.Random;
import uk.co.jemos.podam.common.AttributeStrategy;
import uk.co.jemos.podam.exceptions.PodamMockeryException;

/**
 *
 * @author id.salazar
 */
public class DiaDisponibilidadStrategy implements AttributeStrategy<String> {

    /**
     *
     * Retorna un Arreglo que representa un día (12 horas) de Estado
     *
     * {@inheritDoc}
     */
    @Override
    public String getValue() throws PodamMockeryException {

        String rta = "";
        String[] options = new String[3];
        options[1] = "L";
        options[2] = "D";
        options[0] = "A";
        Random newMachetazo = new Random();

        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 12; j++) {
                rta += options[newMachetazo.nextInt(3)];
            }
            rta += " ";
        }

        return rta;
    }

}
