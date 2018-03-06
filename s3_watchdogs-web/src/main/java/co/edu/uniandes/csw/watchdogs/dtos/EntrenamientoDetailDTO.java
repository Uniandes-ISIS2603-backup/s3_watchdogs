/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.watchdogs.dtos;

import co.edu.uniandes.csw.watchdogs.entities.EntrenamientoEntity;

/**
 *
 * @author c.martinezc1
 */
public class EntrenamientoDetailDTO extends ServicioDetailDTO{
    
    private CentroDeEntrenamientoDTO centroDeEntrenamiento;
    
    private String tipo;
    /**
     * Constructor por defecto
     */
    public EntrenamientoDetailDTO() {
        super();
    }
    
    /**
     * Constructor que recibe un entity
     * @param entity
     */
    public EntrenamientoDetailDTO(EntrenamientoEntity entity){
        super(entity);
        this.tipo = entity.getTipo();
        if(entity.getCentroDeEntrenamiento() != null){
            this.centroDeEntrenamiento = new CentroDeEntrenamientoDTO(entity.getCentroDeEntrenamiento());
        }
        else centroDeEntrenamiento = null;
        
    }
    
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    public CentroDeEntrenamientoDTO getCentroDeEntrenamiento() {
        return centroDeEntrenamiento;
    }

    public void setCentroDeEntrenamiento(CentroDeEntrenamientoDTO centroDeEntrenamiento) {
        this.centroDeEntrenamiento = centroDeEntrenamiento;
    }
    
    

    /**
     * Metodo que convierte un DTO a ENtity
     * @return EntrenamientoEntity
     */
    @Override
    public EntrenamientoEntity toEntity(){
        EntrenamientoEntity entity = new EntrenamientoEntity();
        entity.setCosto(this.getCosto());
        entity.setDuracion(this.getDuracion());
        entity.setEstado(this.isEstado());
        entity.setFecha(this.getFecha());
        entity.setRango(this.getRango());
        entity.setTipo(this.tipo);
        entity.setId(this.id);
        if(this.cliente!=null){
            entity.setCliente(cliente.toEntity());
        }
        if(this.mascota!=null){
            entity.setMascota(mascota.toEntity());
        }
        if(this.empleado!=null){
            entity.setEmpleado(empleado.toEntity());
        }
        if(this.factura!=null){
            entity.setFactura(factura.toEntity());
        }
        if(this.calificacion!=null){
            entity.setCalificacion(calificacion.toEntity());
        }
        if(centroDeEntrenamiento!=null){
            entity.setCentroDeEntrenamiento(centroDeEntrenamiento.toEntity());
        }
        return entity;
    }
}