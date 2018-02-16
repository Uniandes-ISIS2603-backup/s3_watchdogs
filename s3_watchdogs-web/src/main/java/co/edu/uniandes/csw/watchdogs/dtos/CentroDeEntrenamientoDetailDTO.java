/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.watchdogs.dtos;

import java.util.ArrayList;

/**
 * Clase que extiende de {@link CentroDeEntrenamientoDTO} para manejar la transformacion entre
 * los objetos JSON y las Entidades de la base de datos. Para conocer el
 * contenido del centro de entrenamiento vaya a la documentacion de {@link CentroDeEntrenamientoDTO}
 * @author m.diazt
 */
public class CentroDeEntrenamientoDetailDTO extends CentroDeEntrenamientoDTO {
    
    private ArrayList<EntrenamientoDTO> entrenamientos;
    private ArrayList<HotelDTO> hoteles;
    
    /**
     * Constructor por defecto
     */
    public CentroDeEntrenamientoDetailDTO()
    {
        super();
    }

    /**
     * @return entrenamientos
     */
    public ArrayList<EntrenamientoDTO> getEntrenamientos() {
        return entrenamientos;
    }

    /**
     * @param entrenamientos Lista de entrenamientos a establecer
     */
    public void setEntrenamientos(ArrayList<EntrenamientoDTO> entrenamientos) {
        this.entrenamientos = entrenamientos;
    }

    /**
     * @return hoteles
     */
    public ArrayList<HotelDTO> getHoteles() {
        return hoteles;
    }

    /**
     * @param hoteles Lista de hoteles a establecer
     */
    public void setHoteles(ArrayList<HotelDTO> hoteles) {
        this.hoteles = hoteles;
    }
    
    
    
}
