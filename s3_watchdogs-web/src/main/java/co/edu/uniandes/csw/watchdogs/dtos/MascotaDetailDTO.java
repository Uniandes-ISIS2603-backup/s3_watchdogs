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
import co.edu.uniandes.csw.watchdogs.entities.ServicioEntity;
import java.util.ArrayList;
import java.util.List;

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

    private List<ServicioDTO> servicios;
    private ClienteDTO cliente;

    //----- Constructor -----
    /**
     * Constructor por defecto
     */
    public MascotaDetailDTO() {
        super();
    }

    /**
     * Constructor para transformar un Entity a un DTO
     *
     * @param entity La entidad de la mascota a partir de la cual se construye
     * el objeto
     */
    public MascotaDetailDTO(MascotaEntity entity) {
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
                    servicio.setDientes(((AseoEntity) entityServicio).getDientes());
                    servicio.setBanho(((AseoEntity) entityServicio).getBanho());
                    servicio.setPeluqueria(((AseoEntity) entityServicio).getPeluqueria());
                    servicios.add(servicio);
                } else if (entityServicio.getClass().equals(PaseoEntity.class)) {
                    PaseoDTO servicio = new PaseoDTO();
                    servicio.setId(entityServicio.getId());
                    servicio.setFecha(entityServicio.getFecha());
                    servicio.setCosto(entityServicio.getCosto());
                    servicio.setEstado(entityServicio.isEstado());
                    servicio.setRango(entityServicio.getRango());
                    servicio.setDuracion(entityServicio.getDuracion());
                    servicio.setCapMax(((PaseoEntity) entityServicio).getCapMax());
                    servicio.setHoras(((PaseoEntity) entityServicio).getHoras());
                    servicios.add(servicio);
                } else if (entityServicio.getClass().equals(HotelEntity.class)) {
                    HotelDTO servicio = new HotelDTO();
                    servicio.setId(entityServicio.getId());
                    servicio.setFecha(entityServicio.getFecha());
                    servicio.setCosto(entityServicio.getCosto());
                    servicio.setEstado(entityServicio.isEstado());
                    servicio.setRango(entityServicio.getRango());
                    servicio.setDuracion(entityServicio.getDuracion());
                    servicio.setTiempoHospedaje(((HotelEntity) entityServicio).getTiempoHospedaje());
                    servicios.add(servicio);
                } else if (entityServicio.getClass().equals(EntrenamientoEntity.class)) {
                    EntrenamientoDTO servicio = new EntrenamientoDTO();
                    servicio.setId(entityServicio.getId());
                    servicio.setFecha(entityServicio.getFecha());
                    servicio.setCosto(entityServicio.getCosto());
                    servicio.setEstado(entityServicio.isEstado());
                    servicio.setRango(entityServicio.getRango());
                    servicio.setDuracion(entityServicio.getDuracion());
                    servicio.setTipo(((EntrenamientoEntity) entityServicio).getTipo());
                    servicios.add(servicio);
                }
            }
        }
        if (entity.getCliente() != null) {
            this.cliente = new ClienteDTO(entity.getCliente());
        }
    }

    //----- Metodos -----
    @Override
    public MascotaEntity toEntity() {
        MascotaEntity mascotaE = super.toEntity();
        if (getServicios() != null) {
            List<ServicioEntity> serviciosEntity = new ArrayList<>();

            for (ServicioDTO dtoServicio : getServicios()) {
                if (dtoServicio.getClass().equals(AseoDTO.class
                )) {
                    AseoEntity nuevo = new AseoEntity();
                    nuevo.setId(dtoServicio.getId());
                    nuevo.setFecha(dtoServicio.getFecha());
                    nuevo.setCosto(dtoServicio.getCosto());
                    nuevo.setEstado(dtoServicio.isEstado());
                    nuevo.setRango(dtoServicio.getRango());
                    nuevo.setDuracion(dtoServicio.getDuracion());
                    nuevo.setDientes(((AseoDTO) dtoServicio).getDientes());
                    nuevo.setBanho(((AseoDTO) dtoServicio).getBanho());
                    nuevo.setPeluqueria(((AseoDTO) dtoServicio).getPeluqueria());
                    serviciosEntity.add(nuevo);

                } else if (dtoServicio.getClass().equals(PaseoDTO.class
                )) {
                    PaseoEntity nuevo = new PaseoEntity();
                    nuevo.setId(dtoServicio.getId());
                    nuevo.setFecha(dtoServicio.getFecha());
                    nuevo.setCosto(dtoServicio.getCosto());
                    nuevo.setEstado(dtoServicio.isEstado());
                    nuevo.setRango(dtoServicio.getRango());
                    nuevo.setDuracion(dtoServicio.getDuracion());
                    nuevo.setCapMax(((PaseoDTO) dtoServicio).getCapMax());
                    nuevo.setHoras(((PaseoDTO) dtoServicio).getHoras());
                    serviciosEntity.add(nuevo);

                } else if (dtoServicio.getClass().equals(HotelDTO.class
                )) {
                    HotelEntity nuevo = new HotelEntity();
                    nuevo.setId(dtoServicio.getId());
                    nuevo.setFecha(dtoServicio.getFecha());
                    nuevo.setCosto(dtoServicio.getCosto());
                    nuevo.setEstado(dtoServicio.isEstado());
                    nuevo.setRango(dtoServicio.getRango());
                    nuevo.setDuracion(dtoServicio.getDuracion());
                    nuevo.setTiempoHospedaje(((HotelDTO) dtoServicio).getTiempoHospedaje());
                    serviciosEntity.add(nuevo);

                } else if (dtoServicio.getClass().equals(EntrenamientoDTO.class
                )) {
                    EntrenamientoEntity nuevo = new EntrenamientoEntity();
                    nuevo.setId(dtoServicio.getId());
                    nuevo.setFecha(dtoServicio.getFecha());
                    nuevo.setCosto(dtoServicio.getCosto());
                    nuevo.setEstado(dtoServicio.isEstado());
                    nuevo.setRango(dtoServicio.getRango());
                    nuevo.setDuracion(dtoServicio.getDuracion());
                    nuevo.setTipo(((EntrenamientoDTO) dtoServicio).getTipo());
                    serviciosEntity.add(nuevo);
                }
            }
            mascotaE.setServicios(serviciosEntity);
        }
        if (getCliente() != null) {
            mascotaE.setCliente(getCliente().toEntity());
        }
        return mascotaE;
    }

    //----- Getters y Setters -----
    /**
     * Metodo que obtiene los servicios de la mascota.
     *
     * @return los servicios de la mascota
     */
    public List<ServicioDTO> getServicios() {
        return servicios;
    }

    /**
     * Metodo que modifica los servicios de la mascota.
     *
     * @param servicios los nuevos servicios de la mascota
     */
    public void setServicios(List<ServicioDTO> servicios) {
        this.servicios = servicios;
    }

    /**
     * Metodo que obtiene el cliente asociado a la mascota.
     *
     * @return el cliente asociado a la mascota.
     */
    public ClienteDTO getCliente() {
        return cliente;
    }

    /**
     * Metodo que modifica el cliente asociado de la mascota.
     *
     * @param cliente nuevo asociado a la mascota.
     */
    public void setCliente(ClienteDTO cliente) {
        this.cliente = cliente;
    }

}
