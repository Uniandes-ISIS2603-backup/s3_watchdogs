/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.watchdogs.dtos;

import co.edu.uniandes.csw.watchdogs.entities.AseoEntity;
import co.edu.uniandes.csw.watchdogs.entities.EmpleadoEntity;
import co.edu.uniandes.csw.watchdogs.entities.EntrenamientoEntity;
import co.edu.uniandes.csw.watchdogs.entities.HotelEntity;
import co.edu.uniandes.csw.watchdogs.entities.PaseoEntity;

/**
 * Clase que extiende de {@link EmpleadoDTO} para manejar la transformacion
 * entre los objetos JSON y las Entidades de la base de datos. Para conocer el
 * contenido de la ciudad vaya a la documentacion de {@link EmpleadoDTO}
 *
 * Al serializarse como JSON esta clase implementa el siguiente modelo: <br>
 * <pre>
 *  {
 *      "id": number,
 *      "nombre": sttring,
 *      "cedula": string,
 *      "imagen": string,
 *      "edad": integer
 *      "clasificacion": number,
 *      "servicios" : {@link ServicioDTO},
 *      "disponibilidad" : {@link DisponibilidadDTO}
 *  }
 * </pre> Por ejemplo un empleado se representa asi:<br>
 *
 * <pre>
 *  {
 *      "id": 95873,
 *      "nombre": "Camilo",
 *      "cedula": "1020123456",
 *      "imagen": "abg.jpg",
 *      "edad": 24
 *      "horarios": "No se como es"
 *      "clasificacion": 10,
 *      "servicios" : {
 *          "id": 1,
 *          "fecha: 01/01/2020,
 *          "costo": 10000,
 *          "estado": true,
 *          "duración": 10,
 *          "rango": a'
 *          "dientes": true,
 *          "banho": true,
 *          "peluqueria": true
 *      },
 *      "disponibilidad" : {
 *          "id": 1321321,
 *          "matrizHorarios": "LAD LLL DDD AAL LLD DDL"
 *      }
 *  }
 * </pre>
 *
 * @author ca.beltran10
 */
public class EmpleadoDetailDTO extends EmpleadoDTO {

    private CalificacionDTO calificacion;
    private ServicioDTO servicio;
    private DisponibilidadDTO disponibilidad;

    //----- Constructor -----
    /**
     * Constructor por defecto
     */
    public EmpleadoDetailDTO() {
    }

    /**
     * Constructor para transformar un Entity a un DTO
     *
     * @param entity La entidad del empleado de la cual se construye el objeto
     */
    public EmpleadoDetailDTO(EmpleadoEntity entity) {
        super(entity);
        if (entity != null) {
            calificacion = new CalificacionDTO();
            if (entity.getCalificacion() != null) {
                calificacion.setId(entity.getCalificacion().getId());
                calificacion.setPuntaje(entity.getCalificacion().getPuntaje());
            }
            if (entity.getServicio() != null) {
                if (entity.getServicio().getClass().equals(AseoDTO.class)) {
                    servicio = new AseoDTO();
                    servicio.setFecha(entity.getServicio().getFecha());
                    servicio.setCosto(entity.getServicio().getCosto());
                    servicio.setEstado(entity.getServicio().isEstado());
                    servicio.setRango(entity.getServicio().getRango());
                    servicio.setDuracion(entity.getServicio().getDuracion());
                    ((AseoDTO) servicio).setDientes(((AseoEntity) entity.getServicio()).getDientes());
                    ((AseoDTO) servicio).setBanho(((AseoEntity) entity.getServicio()).getBanho());
                    ((AseoDTO) servicio).setPeluqueria(((AseoEntity) entity.getServicio()).getPeluqueria());
                }
                if (entity.getServicio().getClass().equals(ServicioDTO.class)) {
                    servicio = new AseoDTO();
                    servicio.setFecha(entity.getServicio().getFecha());
                    servicio.setCosto(entity.getServicio().getCosto());
                    servicio.setEstado(entity.getServicio().isEstado());
                    servicio.setRango(entity.getServicio().getRango());
                    servicio.setDuracion(entity.getServicio().getDuracion());
                    ((PaseoDTO) servicio).setCapMax(((PaseoEntity) entity.getServicio()).getCapMax());
                    ((PaseoDTO) servicio).setHoras(((PaseoEntity) entity.getServicio()).getHoras());
                }
                if (entity.getServicio().getClass().equals(ServicioDTO.class)) {
                    servicio = new AseoDTO();
                    servicio.setFecha(entity.getServicio().getFecha());
                    servicio.setCosto(entity.getServicio().getCosto());
                    servicio.setEstado(entity.getServicio().isEstado());
                    servicio.setRango(entity.getServicio().getRango());
                    servicio.setDuracion(entity.getServicio().getDuracion());
                    ((HotelDTO) servicio).setTiempoHospedaje(((HotelEntity) entity.getServicio()).getTiempoHospedaje());
                }
                if (entity.getServicio().getClass().equals(ServicioDTO.class)) {
                    servicio = new AseoDTO();
                    servicio.setFecha(entity.getServicio().getFecha());
                    servicio.setCosto(entity.getServicio().getCosto());
                    servicio.setEstado(entity.getServicio().isEstado());
                    servicio.setRango(entity.getServicio().getRango());
                    servicio.setDuracion(entity.getServicio().getDuracion());
                    ((EntrenamientoDTO) servicio).setTipo(((EntrenamientoEntity) entity.getServicio()).getTipo());
                }
            }
            disponibilidad = new DisponibilidadDTO();
            if (entity.getDisponibilidad() != null) {
                disponibilidad.setId(entity.getDisponibilidad().getId());
                disponibilidad.setMatrizHorarios(entity.getDisponibilidad().getMatrizHorarios());
            }
        }
    }

    /**
     * Transformar un DTO a un Entity
     *
     * @return La entidad construida a partir del DTO
     */
    @Override
    public EmpleadoEntity toEntity() {
        EmpleadoEntity empleadoE = super.toEntity();
        if (calificacion != null) {
            empleadoE.setCalificacion(calificacion.toEntity());
        }
        if (servicio != null) {
            if (servicio.getClass().equals(AseoDTO.class)) {
                AseoEntity nuevo = new AseoEntity();
                nuevo.setFecha(servicio.getFecha());
                nuevo.setCosto(servicio.getCosto());
                nuevo.setEstado(servicio.isEstado());
                nuevo.setRango(servicio.getRango());
                nuevo.setDuracion(servicio.getDuracion());
                ((AseoEntity) nuevo).setDientes(((AseoDTO) servicio).getDientes());
                ((AseoEntity) nuevo).setBanho(((AseoDTO) servicio).getBanho());
                ((AseoEntity) nuevo).setPeluqueria(((AseoDTO) servicio).getPeluqueria());
                empleadoE.setServicio(nuevo);
            } else if (servicio.getClass().equals(PaseoDTO.class)) {
                PaseoEntity nuevo = new PaseoEntity();
                nuevo.setFecha(servicio.getFecha());
                nuevo.setCosto(servicio.getCosto());
                nuevo.setEstado(servicio.isEstado());
                nuevo.setRango(servicio.getRango());
                nuevo.setDuracion(servicio.getDuracion());
                ((PaseoEntity) nuevo).setCapMax(((PaseoDTO) servicio).getCapMax());
                ((PaseoEntity) nuevo).setHoras(((PaseoDTO) servicio).getHoras());
                empleadoE.setServicio(nuevo);
            } else if (servicio.getClass().equals(HotelDTO.class)) {
                HotelEntity nuevo = new HotelEntity();
                nuevo.setFecha(servicio.getFecha());
                nuevo.setCosto(servicio.getCosto());
                nuevo.setEstado(servicio.isEstado());
                nuevo.setRango(servicio.getRango());
                nuevo.setDuracion(servicio.getDuracion());
                ((HotelEntity) nuevo).setTiempoHospedaje(((HotelDTO) servicio).getTiempoHospedaje());
                empleadoE.setServicio(nuevo);
            } else if (servicio.getClass().equals(EntrenamientoDTO.class)) {
                EntrenamientoEntity nuevo = new EntrenamientoEntity();
                nuevo.setFecha(servicio.getFecha());
                nuevo.setCosto(servicio.getCosto());
                nuevo.setEstado(servicio.isEstado());
                nuevo.setRango(servicio.getRango());
                nuevo.setDuracion(servicio.getDuracion());
                ((EntrenamientoEntity) nuevo).setTipo(((EntrenamientoDTO) servicio).getTipo());
                empleadoE.setServicio(nuevo);
            }
        }
        if (disponibilidad != null) {
            empleadoE.setDisponibilidad(disponibilidad.toEntity());
        }
        return empleadoE;
    }

    /**
     * @param calificacion the calificacion to set
     */
    public void setCalificacion(CalificacionDTO calificacion) {
        this.calificacion = calificacion;
    }

    /**
     * @return the servicio
     */
    public ServicioDTO getServicio() {
        return servicio;
    }

    /**
     * @param servicio the servicio to set
     */
    public void setServicio(ServicioDTO servicio) {
        this.servicio = servicio;
    }

    /**
     * @return the calificacion
     */
    public CalificacionDTO getCalificacion() {
        return calificacion;
    }

    /**
     * @param disponibilidad the disponibilidad to set
     */
    public void setDisponibilidad(DisponibilidadDTO disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    /**
     * @return the disponibilidad
     */
    public DisponibilidadDTO getDisponibilidad() {
        return disponibilidad;
    }
}
