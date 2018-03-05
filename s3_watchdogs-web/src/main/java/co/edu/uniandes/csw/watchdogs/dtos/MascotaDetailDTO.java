/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.watchdogs.dtos;

import co.edu.uniandes.csw.watchdogs.entities.AseoEntity;
import co.edu.uniandes.csw.watchdogs.entities.EntrenamientoEntity;
import co.edu.uniandes.csw.watchdogs.entities.HotelEntity;
import co.edu.uniandes.csw.watchdogs.entities.MascotaEntity;
import co.edu.uniandes.csw.watchdogs.entities.PaseoEntity;

/**
 * Clase que extiende de {@link MascotaDTO} para manejar la transformacion entre
 * los objetos JSON y las Entidades de la base de datos. Para conocer el
 * contenido de la mascota vaya a la documentacion de {@link MascotaDTO}
 *
 * Al serializarse como JSON esta clase implementa el siguiente modelo: <br>
 * <pre>
 *  {
 *      "id": number,
 *      "nombre": string,
 *      "raza": string,
 *      "color": string,
 *      "sexo": string,
 *      "servicio": {@link ServicioDTO}
 *      "cliente": {@link ClienteDTO}
 *  }
 * </pre> Por ejemplo una mascota se representa asi:<br>
 *
 * <pre>
 *
 *  {
 *      "id": 1,
 *      "nombre": "Negra",
 *      "raza": "Criolla",
 *      "color": "Negro",
 *      "sexo": Hembra,
 *      "servicio": {
 *          "id": 1,
 *          "fecha: 01/01/2020,
 *          "costo": 10000,
 *          "estado": true,
 *          "duración": 10,
 *          "rango": a'
 *          "dientes": true,
 *          "banho": true,
 *          "peluqueria": true
 *      }
 *      "cliente": {
 *          "id": 1,
 *          "nombre": "Camilo Beltran",
 *          "cedula": "1020123456"
 *      }
 *  }
 *
 * </pre>
 *
 * @author ca.beltran10
 */
public class MascotaDetailDTO extends MascotaDTO {

    private ServicioDTO servicio;
    private ClienteDTO cliente;

    //----- Constructor -----
    /**
     * Constructor por defecto
     */
    public MascotaDetailDTO() {
    }

    /**
     * Constructor para transformar un Entity a un DTO
     *
     * @param entity La entidad de la mascota a partir de la cual se construye
     * el objeto
     */
    public MascotaDetailDTO(MascotaEntity entity) {
        super(entity);
        if (entity != null) {
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
                } else if (entity.getServicio().getClass().equals(PaseoDTO.class)) {
                    servicio = new PaseoDTO();
                    servicio.setFecha(entity.getServicio().getFecha());
                    servicio.setCosto(entity.getServicio().getCosto());
                    servicio.setEstado(entity.getServicio().isEstado());
                    servicio.setRango(entity.getServicio().getRango());
                    servicio.setDuracion(entity.getServicio().getDuracion());
                    ((PaseoDTO) servicio).setCapMax(((PaseoEntity) entity.getServicio()).getCapMax());
                    ((PaseoDTO) servicio).setHoras(((PaseoEntity) entity.getServicio()).getHoras());
                } else if (entity.getServicio().getClass().equals(HotelDTO.class)) {
                    servicio = new HotelDTO();
                    servicio.setFecha(entity.getServicio().getFecha());
                    servicio.setCosto(entity.getServicio().getCosto());
                    servicio.setEstado(entity.getServicio().isEstado());
                    servicio.setRango(entity.getServicio().getRango());
                    servicio.setDuracion(entity.getServicio().getDuracion());
                    ((HotelDTO) servicio).setTiempoHospedaje(((HotelEntity) entity.getServicio()).getTiempoHospedaje());
                } else if (entity.getServicio().getClass().equals(EntrenamientoDTO.class)) {
                    servicio = new EntrenamientoDTO();
                    servicio.setFecha(entity.getServicio().getFecha());
                    servicio.setCosto(entity.getServicio().getCosto());
                    servicio.setEstado(entity.getServicio().isEstado());
                    servicio.setRango(entity.getServicio().getRango());
                    servicio.setDuracion(entity.getServicio().getDuracion());
                    ((EntrenamientoDTO) servicio).setTipo(((EntrenamientoEntity) entity.getServicio()).getTipo());
                }
            }
            cliente = new ClienteDTO();
            if (cliente != null) {
                cliente.setId(entity.getCliente().getId());
                cliente.setNombre(entity.getCliente().getName());
                cliente.setCedula(entity.getCliente().getCedula());
            }
        }
    }

    /**
     * Transformar un DTO a un Entity
     *
     * @return La entidad construida a partir del DTO
     */
    @Override
    public MascotaEntity toEntity() {
        MascotaEntity mascotaE = super.toEntity();
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
                mascotaE.setServicio(nuevo);
            } else if (servicio.getClass().equals(PaseoDTO.class)) {
                PaseoEntity nuevo = new PaseoEntity();
                nuevo.setFecha(servicio.getFecha());
                nuevo.setCosto(servicio.getCosto());
                nuevo.setEstado(servicio.isEstado());
                nuevo.setRango(servicio.getRango());
                nuevo.setDuracion(servicio.getDuracion());
                ((PaseoEntity) nuevo).setCapMax(((PaseoDTO) servicio).getCapMax());
                ((PaseoEntity) nuevo).setHoras(((PaseoDTO) servicio).getHoras());
                mascotaE.setServicio(nuevo);
            } else if (servicio.getClass().equals(HotelDTO.class)) {
                HotelEntity nuevo = new HotelEntity();
                nuevo.setFecha(servicio.getFecha());
                nuevo.setCosto(servicio.getCosto());
                nuevo.setEstado(servicio.isEstado());
                nuevo.setRango(servicio.getRango());
                nuevo.setDuracion(servicio.getDuracion());
                ((HotelEntity) nuevo).setTiempoHospedaje(((HotelDTO) servicio).getTiempoHospedaje());
                mascotaE.setServicio(nuevo);
            } else if (servicio.getClass().equals(EntrenamientoDTO.class)) {
                EntrenamientoEntity nuevo = new EntrenamientoEntity();
                nuevo.setFecha(servicio.getFecha());
                nuevo.setCosto(servicio.getCosto());
                nuevo.setEstado(servicio.isEstado());
                nuevo.setRango(servicio.getRango());
                nuevo.setDuracion(servicio.getDuracion());
                ((EntrenamientoEntity) nuevo).setTipo(((EntrenamientoDTO) servicio).getTipo());
                mascotaE.setServicio(nuevo);
            }
        }
        if (cliente != null) {
            mascotaE.setCliente(cliente.toEntity());
        }
        return mascotaE;
    }
}
