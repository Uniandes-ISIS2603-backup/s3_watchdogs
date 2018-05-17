/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.watchdogs.dtos;

/**
 * Al serializarse como JSON esta clase implementa el siguiente modelo: <br>
 * <pre>
 *   {
 *      "id": long,
 *      "fecha: date,
 *      "costo": double
 *      "estado": boolean
 *      "duración": double
 *      "rango": List'String'
 *      "tipo": string
 *      "centroDeEntrenamiento" : {@link CentroDeEntrenamientoDTO}
 *      "transporte" : {@link TransporteDTO}
 *   }
 * </pre> Por ejemplo un entrenamiento se representa asi:<br>
 *
 * <pre>
 *
 *   {
 *      "id": 815373,
 *      "fecha: "10-10-2010",
 *      "costo": 25
 *      "estado": "1"
 *      "duración": 20.5
 *      "rango": ""
 *      "tipo": "cardio"
 *      "centroDeEntrenamiento" : {
 *              "id": Long,
 *              "direccion": String,
 *              "fotos": List'String',
 *              "usuariosEnServicio": Integer,
 *              "capacidadMaxima": Integer
 *          },
 *      "transporte" : {
 *              "id": long,
 *              "direccion: string,
 *              "recogida": int
 *              "devuelta": int
 *              }
 *   }
 *
 * </pre>
 *
 * @author c.martinezc1
 */
import co.edu.uniandes.csw.watchdogs.entities.EntrenamientoEntity;

/**
 *
 * @author c.martinezc1
 */
public class EntrenamientoDetailDTO extends ServicioDetailDTO {

    /**
     * Centro de Entrenamiento asociado
     */
    private CentroDeEntrenamientoDTO centroDeEntrenamiento;

    /**
     * Transporte asociado
     */
    private TransporteDTO transporte;

    /**
     * Tipo del entrenamiento
     */
    private String tipo;

    /**
     * Constructor por defecto
     */
    public EntrenamientoDetailDTO() {
        super();
    }

    /**
     * Constructor que recibe un entity
     *
     * @param entity
     */
    public EntrenamientoDetailDTO(EntrenamientoEntity entity) {
        super(entity);
        this.tipo = entity.getTipo();
        if (entity.getCentroDeEntrenamiento() != null) {
            this.centroDeEntrenamiento = new CentroDeEntrenamientoDTO(entity.getCentroDeEntrenamiento());
        } else {
            centroDeEntrenamiento = null;
        }
        if (entity.getTransporte() != null) {
            this.transporte = new TransporteDTO(entity.getTransporte());
        } else {
            transporte = null;
        }
    }

    /**
     *
     * @return el tipo del entrenamiento
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo el nuevo tipo
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * @return el centro de entrenamiento
     */
    public CentroDeEntrenamientoDTO getCentroDeEntrenamiento() {
        return centroDeEntrenamiento;
    }

    /**
     *
     * @param centroDeEntrenamiento el nuevo centro de entrenamiento
     */
    public void setCentroDeEntrenamiento(CentroDeEntrenamientoDTO centroDeEntrenamiento) {
        this.centroDeEntrenamiento = centroDeEntrenamiento;
    }

    /**
     *
     * @return el transporte
     */
    public TransporteDTO getTransporte() {
        return transporte;
    }

    /**
     *
     * @param transporte El nuevo transporte
     */
    public void setTransporte(TransporteDTO transporte) {
        this.transporte = transporte;
    }

    /**
     * Metodo que convierte un DTO a ENtity
     *
     * @return EntrenamientoEntity
     */
    @Override
    public EntrenamientoEntity toEntity() {
        EntrenamientoEntity entity = new EntrenamientoEntity();
        entity.setCosto(this.getCosto());
        entity.setDuracion(this.getDuracion());
        entity.setEstado(this.isEstado());
        entity.setFecha(this.getFecha());
        entity.setRango(this.getRango());
        entity.setTipo(this.tipo);
        entity.setId(this.id);
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
        if (this.transporte != null) {
            entity.setTransporte(transporte.toEntity());
        }
        if (centroDeEntrenamiento != null) {
            if (centroDeEntrenamiento.getClass().equals(CentroDeEntrenamientoDTO.class)) {
                entity.setCentroDeEntrenamiento(centroDeEntrenamiento.toEntity());
            } else {
                entity.setCentroDeEntrenamiento(null);
            }

        }
        return entity;
    }
}
