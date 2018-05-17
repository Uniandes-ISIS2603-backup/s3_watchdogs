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
import co.edu.uniandes.csw.watchdogs.entities.ServicioEntity;
import java.util.ArrayList;
import java.util.List;

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
    private List<ServicioDTO> servicios;
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
        servicios = new ArrayList<>();
        if (entity.getServicios() != null) {
            for (ServicioEntity entityServicio : entity.getServicios()) {
                if (entityServicio.getClass().equals(AseoEntity.class)) {
                    AseoDTO servicio = new AseoDTO();
                    servicio.setId(entityServicio.getId());
                    servicio.setFecha(entityServicio.getFecha());
                    servicio.setCosto(entityServicio.getCosto());
                    servicio.setEstado(entityServicio.isEstado());
                    servicio.setRango(entityServicio.getRango());
                    servicio.setDuracion(entityServicio.getDuracion());
                    ((AseoDTO) servicio).setDientes(((AseoEntity) entityServicio).getDientes());
                    ((AseoDTO) servicio).setBanho(((AseoEntity) entityServicio).getBanho());
                    ((AseoDTO) servicio).setPeluqueria(((AseoEntity) entityServicio).getPeluqueria());
                    servicios.add(servicio);
                } else if (entityServicio.getClass().equals(PaseoEntity.class)) {
                    PaseoDTO servicio = new PaseoDTO();
                    servicio.setId(entityServicio.getId());
                    servicio.setFecha(entityServicio.getFecha());
                    servicio.setCosto(entityServicio.getCosto());
                    servicio.setEstado(entityServicio.isEstado());
                    servicio.setRango(entityServicio.getRango());
                    servicio.setDuracion(entityServicio.getDuracion());
                    ((PaseoDTO) servicio).setCapMax(((PaseoEntity) entityServicio).getCapMax());
                    ((PaseoDTO) servicio).setHoras(((PaseoEntity) entityServicio).getHoras());
                    servicios.add(servicio);
                } else if (entityServicio.getClass().equals(HotelEntity.class)) {
                    HotelDTO servicio = new HotelDTO();
                    servicio.setId(entityServicio.getId());
                    servicio.setFecha(entityServicio.getFecha());
                    servicio.setCosto(entityServicio.getCosto());
                    servicio.setEstado(entityServicio.isEstado());
                    servicio.setRango(entityServicio.getRango());
                    servicio.setDuracion(entityServicio.getDuracion());
                    ((HotelDTO) servicio).setTiempoHospedaje(((HotelEntity) entityServicio).getTiempoHospedaje());
                    servicios.add(servicio);
                } else if (entityServicio.getClass().equals(EntrenamientoEntity.class)) {
                    EntrenamientoDTO servicio = new EntrenamientoDTO();
                    servicio.setId(entityServicio.getId());
                    servicio.setFecha(entityServicio.getFecha());
                    servicio.setCosto(entityServicio.getCosto());
                    servicio.setEstado(entityServicio.isEstado());
                    servicio.setRango(entityServicio.getRango());
                    servicio.setDuracion(entityServicio.getDuracion());
                    ((EntrenamientoDTO) servicio).setTipo(((EntrenamientoEntity) entityServicio).getTipo());
                    servicios.add(servicio);
                }
            }
            disponibilidad = new DisponibilidadDTO();
            if (entity.getDisponibilidad() != null) {
                disponibilidad.setId(entity.getDisponibilidad().getId());
                //disponibilidad.setMatrizHorarios(entity.getDisponibilidad().getMatrizHorarios());
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
        if (servicios != null) {
            List<ServicioEntity> serviciosEntity = new ArrayList<>();
            for (ServicioDTO dtoServicio : servicios) {
                if (dtoServicio.getClass().equals(AseoDTO.class)) {
                    AseoEntity nuevo = new AseoEntity();
                    nuevo.setId(dtoServicio.getId());
                    nuevo.setFecha(dtoServicio.getFecha());
                    nuevo.setCosto(dtoServicio.getCosto());
                    nuevo.setEstado(dtoServicio.isEstado());
                    nuevo.setRango(dtoServicio.getRango());
                    nuevo.setDuracion(dtoServicio.getDuracion());
                    ((AseoEntity) nuevo).setDientes(((AseoDTO) dtoServicio).getDientes());
                    ((AseoEntity) nuevo).setBanho(((AseoDTO) dtoServicio).getBanho());
                    ((AseoEntity) nuevo).setPeluqueria(((AseoDTO) dtoServicio).getPeluqueria());
                    serviciosEntity.add(nuevo);
                } else if (dtoServicio.getClass().equals(PaseoDTO.class)) {
                    PaseoEntity nuevo = new PaseoEntity();
                    nuevo.setId(dtoServicio.getId());
                    nuevo.setFecha(dtoServicio.getFecha());
                    nuevo.setCosto(dtoServicio.getCosto());
                    nuevo.setEstado(dtoServicio.isEstado());
                    nuevo.setRango(dtoServicio.getRango());
                    nuevo.setDuracion(dtoServicio.getDuracion());
                    ((PaseoEntity) nuevo).setCapMax(((PaseoDTO) dtoServicio).getCapMax());
                    ((PaseoEntity) nuevo).setHoras(((PaseoDTO) dtoServicio).getHoras());
                    serviciosEntity.add(nuevo);
                } else if (dtoServicio.getClass().equals(HotelDTO.class)) {
                    HotelEntity nuevo = new HotelEntity();
                    nuevo.setId(dtoServicio.getId());
                    nuevo.setFecha(dtoServicio.getFecha());
                    nuevo.setCosto(dtoServicio.getCosto());
                    nuevo.setEstado(dtoServicio.isEstado());
                    nuevo.setRango(dtoServicio.getRango());
                    nuevo.setDuracion(dtoServicio.getDuracion());
                    ((HotelEntity) nuevo).setTiempoHospedaje(((HotelDTO) dtoServicio).getTiempoHospedaje());
                    serviciosEntity.add(nuevo);
                } else if (dtoServicio.getClass().equals(EntrenamientoDTO.class)) {
                    EntrenamientoEntity nuevo = new EntrenamientoEntity();
                    nuevo.setId(dtoServicio.getId());
                    nuevo.setFecha(dtoServicio.getFecha());
                    nuevo.setCosto(dtoServicio.getCosto());
                    nuevo.setEstado(dtoServicio.isEstado());
                    nuevo.setRango(dtoServicio.getRango());
                    nuevo.setDuracion(dtoServicio.getDuracion());
                    ((EntrenamientoEntity) nuevo).setTipo(((EntrenamientoDTO) dtoServicio).getTipo());
                    serviciosEntity.add(nuevo);
                }
            }
            empleadoE.setServicios(serviciosEntity);
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
    public List<ServicioDTO> getServicio() {
        return servicios;
    }

    /**
     * @param servicio the servicio to set
     */
    public void setServicio(List<ServicioDTO> servicio) {
        this.servicios = servicio;
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
