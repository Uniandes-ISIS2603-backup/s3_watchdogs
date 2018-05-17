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
 *
 * @author m.diazt
 */
public class HotelDetailDTO extends ServicioDetailDTO {

    /**
     * Transporte asociado al Hotel
     */
    private TransporteDTO transporte;

    /**
     * CentroDeEntrenamiento Asociado al Hotel
     */
    private CentroDeEntrenamientoDTO centroDeEntrenamiento;

    /**
     * Tiempo de hospedaje en el hotel
     */
    private Integer tiempoHospedaje;

    /**
     * Constructor por defecto
     */
    public HotelDetailDTO() {
        super();
    }

    public HotelDetailDTO(HotelEntity entity) {
        super(entity);
        tiempoHospedaje = entity.getTiempoHospedaje();
        if (entity.getTransporte() != null) {
            this.transporte = new TransporteDTO(entity.getTransporte());
        } else {
            entity.setTransporte(null);
        }
        if (entity.getCentroDeEntrenamiento() != null) {
            this.centroDeEntrenamiento = new CentroDeEntrenamientoDTO(entity.getCentroDeEntrenamiento());
        } else {
            entity.setCentroDeEntrenamiento(null);
        }
    }

    /**
     * @return tiempoHospedaje
     */
    public Integer getTiempoHospedaje() {
        return tiempoHospedaje;
    }

    /**
     * @param tiempoHospedaje El nuevo tiempo de hospedaje
     */
    public void setTiempoHospedaje(Integer tiempoHospedaje) {
        this.tiempoHospedaje = tiempoHospedaje;
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
     *
     * @return HotelEntity
     */
    @Override
    public HotelEntity toEntity() {
        HotelEntity entity = new HotelEntity();
        entity.setTiempoHospedaje(tiempoHospedaje);
        entity.setCosto(this.costo);
        entity.setDuracion(this.duracion);
        entity.setEstado(this.estado);
        entity.setFecha(this.fecha);
        entity.setRango(this.rango);
        if (this.cliente != null) {
            entity.setCliente(cliente.toEntity());
        }
        if (this.mascota != null) {
            entity.setMascota(mascota.toEntity());
        }
        if (this.empleado != null) {
            entity.setEmpleado(empleado.toEntity());
        }
        if (this.factura != null) {
            entity.setFactura(factura.toEntity());
        }
        if (this.calificacion != null) {
            entity.setCalificacion(calificacion.toEntity());
        }
        if (this.centroDeEntrenamiento != null) {
            entity.setCentroDeEntrenamiento(this.centroDeEntrenamiento.toEntity());
        }
        if (this.transporte != null) {
            entity.setTransporte(this.transporte.toEntity());
        }
        return entity;
    }
}
