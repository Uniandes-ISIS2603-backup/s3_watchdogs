/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.watchdogs.dtos;

import co.edu.uniandes.csw.watchdogs.entities.CentroDeEntrenamientoEntity;
import co.edu.uniandes.csw.watchdogs.entities.EntrenamientoEntity;
import co.edu.uniandes.csw.watchdogs.entities.HotelEntity;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que extiende de {@link CentroDeEntrenamientoDTO} para manejar la transformacion entre
 * los objetos JSON y las Entidades de la base de datos. Para conocer el
 * contenido del centro de entrenamiento vaya a la documentacion de {@link CentroDeEntrenamientoDTO}
 * @author m.diazt
 */
public class CentroDeEntrenamientoDetailDTO extends CentroDeEntrenamientoDTO {
    
    private List<EntrenamientoDTO> entrenamientos;
    private List<HotelDTO> hoteles;
    
    /**
     * Constructor por defecto
     */
    public CentroDeEntrenamientoDetailDTO()
    {
        super();
    }
    
    public CentroDeEntrenamientoDetailDTO(CentroDeEntrenamientoEntity entity){
        super(entity);
        if(entity.getEntrenamientos() != null){
            entrenamientos = new ArrayList();
            for(EntrenamientoEntity eEnt : entity.getEntrenamientos()){
                entrenamientos.add(new EntrenamientoDTO(eEnt));
            }
        }
        if(entity.getHoteles() !=null){
            hoteles = new ArrayList();
            for(HotelEntity hEnt : entity.getHoteles()){
                hoteles.add(new HotelDTO(hEnt));
            }
        } 
    }

    /**
     * @return entrenamientos
     */
    public List<EntrenamientoDTO> getEntrenamientos() {
        return entrenamientos;
    }

    /**
     * @param entrenamientos Lista de entrenamientos a establecer
     */
    public void setEntrenamientos(List<EntrenamientoDTO> entrenamientos) {
        this.entrenamientos = entrenamientos;
    }

    /**
     * @return hoteles
     */
    public List<HotelDTO> getHoteles() {
        return hoteles;
    }

    /**
     * @param hoteles Lista de hoteles a establecer
     */
    public void setHoteles(List<HotelDTO> hoteles) {
        this.hoteles = hoteles;
    }
    
    /**
     * Metodo que convierte un DTO a ENtity
     * @return CentroDeEntrenamientoEntity
     */
    @Override
    public CentroDeEntrenamientoEntity toEntity(){
        CentroDeEntrenamientoEntity entity = super.toEntity();
        if(this.getEntrenamientos() != null){
            List<EntrenamientoEntity> entrenEnt = new ArrayList<>();
            for(EntrenamientoDTO e:entrenamientos){
                entrenEnt.add(e.toEntity());
            }
            entity.setEntrenamientos(entrenEnt);
        }
        if(this.getHoteles() != null){
            List<HotelEntity> hotelEnt = new ArrayList<>();
            for(HotelDTO h : hoteles){
                hotelEnt.add(h.toEntity());
            }
            entity.setHoteles(hotelEnt);
        }
        return entity;
    }
    
    
    
}
