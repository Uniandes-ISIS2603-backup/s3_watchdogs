/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.watchdogs.dtos;

import co.edu.uniandes.csw.watchdogs.entities.HotelEntity;

/**
 * Clase que extiende de {@link HotelDTO} para manejar la transformacion entre
 * los objetos JSON y las Entidades de la base de datos. Para conocer el
 * contenido del hotel vaya a la documentacion de {@link HotelDTO}
 * @author m.diazt
 */
public class HotelDetailDTO extends HotelDTO {
    
    private TransporteDTO transporte;
    private CentroDeEntrenamientoDTO centroDeEntrenamiento;
    
    /**
     * Constructor por defecto
     */
    public HotelDetailDTO()
    {
        super();
    }
    
    public HotelDetailDTO(HotelEntity entity){
        super(entity);
    }

    /**
     * @return transporte
     */
    public TransporteDTO getTransporte() {
        return transporte;
    }

    /**
     * @param transporte El transporte a establecer
     */
    public void setTransporte(TransporteDTO transporte) {
        this.transporte = transporte;
    }

    /**
     * @return centroDeEntrenamiento
     */
    public CentroDeEntrenamientoDTO getCentroDeEntrenamiento() {
        return centroDeEntrenamiento;
    }

    /**
     * @param centroDeEntrenamiento El centro de entrenamiento a establecer
     */
    public void setCentroDeEntrenamiento(CentroDeEntrenamientoDTO centroDeEntrenamiento) {
        this.centroDeEntrenamiento = centroDeEntrenamiento;
    }
    
    /**
     * Metodo que convierte un DTO a ENtity
     * @return HotelEntity
     */
    @Override
    public HotelEntity toEntity(){
        HotelEntity entity = super.toEntity();
        return entity;
    }
}
