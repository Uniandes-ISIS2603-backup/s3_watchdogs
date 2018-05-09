/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.watchdogs.ejb;

import co.edu.uniandes.csw.watchdogs.entities.EntrenamientoEntity;
import co.edu.uniandes.csw.watchdogs.entities.CentroDeEntrenamientoEntity;
import co.edu.uniandes.csw.watchdogs.entities.HotelEntity;
import co.edu.uniandes.csw.watchdogs.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.watchdogs.persistence.CentroDeEntrenamientoPersistence;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author m.diazt
 */
@Stateless
public class CentroDeEntrenamientoLogic {

    private static final Logger LOGGER = Logger.getLogger(CentroDeEntrenamientoLogic.class.getName());

    @Inject
    private CentroDeEntrenamientoPersistence persistence;

    @Inject
    private EntrenamientoLogic entrenamientoLogic;

    @Inject
    private HotelLogic hotelLogic;

    /**
     * Devuelve todos los CentroDeEntrenamiento que hay en la base de datos.
     *
     * @return Lista de entidades de tipo CentroDeEntrenamiento.
     */
    public List<CentroDeEntrenamientoEntity> getCentrosDeEntrenamientos() {
        LOGGER.info("Inicia proceso de consultar todos los CentroDeEntrenamientos");
        List<CentroDeEntrenamientoEntity> centroDeEntrenamientos = persistence.findAll();
        LOGGER.info("Termina proceso de consultar todos los CentroDeEntrenamientos");
        return centroDeEntrenamientos;
    }

    /**
     * Busca un CentroDeEntrenamiento por ID
     *
     * @param id El id del CentroDeEntrenamiento a buscar
     * @return El CentroDeEntrenamiento encontrado, null si no lo encuentra.
     */
    public CentroDeEntrenamientoEntity getCentroDeEntrenamiento(Long id) {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar CentroDeEntrenamiento con id={0}", id);
        CentroDeEntrenamientoEntity centroDeEntrenamiento = persistence.find(id);
        if (centroDeEntrenamiento == null) {
            LOGGER.log(Level.SEVERE, "El CentroDeEntrenamiento con el id {0} no existe", id);
        }
        LOGGER.log(Level.INFO, "Termina proceso de consultar Transporte con id={0}", id);
        return centroDeEntrenamiento;
    }

    /**
     * Guardar un nuevo CentroDeEntrenamiento
     *
     * @param entity La entidad de tipo CentroDeEntrenamiento del nuevo hotel a
     * persistir.
     * @return La entidad luego de persistirla
     * @throws BusinessLogicException
     */
    public CentroDeEntrenamientoEntity createCentroDeEntrenamiento(CentroDeEntrenamientoEntity entity) throws BusinessLogicException {
        LOGGER.info("Inicia proceso de creación de CentroDeEntrenamiento");
        validar(entity);
        persistence.create(entity);
        LOGGER.info("Termina proceso de creación de CentroDeEntrenamiento");
        return entity;
    }

    /**
     * Actualizar un CentroDeEntrenamiento por ID
     *
     * @param id El ID del CentroDeEntrenamiento a actualizar
     * @param entity La entidad del CentroDeEntrenamiento con los cambios
     * deseados
     * @return La entidad del CentroDeEntrenamiento luego de actualizarla
     * @throws BusinessLogicException
     */
    public CentroDeEntrenamientoEntity updateCentroDeEntrenamiento(Long id, CentroDeEntrenamientoEntity entity) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "Inicia proceso de actualizar CentroDeEntrenamiento con id={0}", id);
        validar(entity);
        CentroDeEntrenamientoEntity newEntity = persistence.update(entity);
        LOGGER.log(Level.INFO, "Termina proceso de actualizar CentroDeEntrenamiento con id={0}", entity.getId());
        return newEntity;
    }

    public void validar(CentroDeEntrenamientoEntity entity) throws BusinessLogicException {
        if (entity.getUsuariosEnServicio() > entity.getCapacidadMaxima()) {
            throw new BusinessLogicException("Los usuarios en servicio no pueden ser mayores que la capacidad máxima");
        }
        if (entity.getDireccion().length() > 50) {
            throw new BusinessLogicException("La direccion es muy grande");
        }
    }

    /**
     * Eliminar un CentroDeEntrenamiento por ID
     *
     * @param id El ID del CentroDeEntrenamiento a eliminar
     */
    public void deleteCentroDeEntrenamiento(Long id) {
        LOGGER.log(Level.INFO, "Inicia proceso de borrar CentroDeEntrenamiento con id={0}", id);
        persistence.delete(id);
        LOGGER.log(Level.INFO, "Termina proceso de borrar CentroDeEntrenamiento con id={0}", id);
    }

    public List<EntrenamientoEntity> getEntrenamientos(Long id) {
        return getCentroDeEntrenamiento(id).getEntrenamientos();
    }

    public EntrenamientoEntity getEntrenamiento(Long idC, Long idE) throws BusinessLogicException {
        List<EntrenamientoEntity> entrenamientos = getCentroDeEntrenamiento(idC).getEntrenamientos();
        EntrenamientoEntity entrenamiento = entrenamientoLogic.getEntrenamiento(idE);
        int index = entrenamientos.indexOf(entrenamiento);
        if (index >= 0) {
            return entrenamientos.get(index);
        }
        throw new BusinessLogicException("El entrenamiento no está asociado al centro de entrenamiento");
    }

    public EntrenamientoEntity addEntrenamiento(Long idC, Long idE) throws BusinessLogicException {
        CentroDeEntrenamientoEntity centroDeEntrenamientoEntity = getCentroDeEntrenamiento(idC);
        EntrenamientoEntity entrenamientoEntity = entrenamientoLogic.getEntrenamiento(idE);
        validarServicios(entrenamientoEntity.getFecha(), entrenamientoEntity.getCosto(), entrenamientoEntity.getDuracion());
        entrenamientoEntity.setCentroDeEntrenamiento(centroDeEntrenamientoEntity);
        return entrenamientoEntity;
    }

    public List<EntrenamientoEntity> replaceEntrenamientos(Long id, List<EntrenamientoEntity> entrenamientos) {
        CentroDeEntrenamientoEntity centroDeEntrenamiento = getCentroDeEntrenamiento(id);
        List<EntrenamientoEntity> entrenamientoList = entrenamientoLogic.getEntrenamientos();
        for (EntrenamientoEntity entrenamiento : entrenamientoList) {
            if (entrenamientos.contains(entrenamiento)) {
                entrenamiento.setCentroDeEntrenamiento(centroDeEntrenamiento);
            } else if (entrenamiento.getCentroDeEntrenamiento() != null && entrenamiento.getCentroDeEntrenamiento().equals(centroDeEntrenamiento)) {
                entrenamiento.setCentroDeEntrenamiento(null);
            }
        }
        return entrenamientos;
    }

    public void removeEntrenamiento(Long entrenamientoId, Long centroDeEntrenamientoId) {
        CentroDeEntrenamientoEntity centroDeEntrenamientoEntity = getCentroDeEntrenamiento(centroDeEntrenamientoId);
        EntrenamientoEntity entrenamiento = entrenamientoLogic.getEntrenamiento(entrenamientoId);
        entrenamiento.setCentroDeEntrenamiento(null);
        centroDeEntrenamientoEntity.getEntrenamientos().remove(entrenamiento);
    }

    /**
     * Agregar un Hotel al CentroDeEntrenamiento
     *
     * @param hotelId El id hotel a guardar
     * @param centroDeEntrenamientoId El id del CentroDeEntrenamiento en la cual
     * se va a guardar el hotel.
     * @return El hotel que fue agregado al CentroDeEntrenamiento.
     */
    public HotelEntity addHotel(Long hotelId, Long centroDeEntrenamientoId) throws BusinessLogicException {
        CentroDeEntrenamientoEntity CentroDeEntrenamientoEntity = getCentroDeEntrenamiento(centroDeEntrenamientoId);
        HotelEntity hotelEntity = hotelLogic.getHotel(hotelId);
        validarServicios(hotelEntity.getFecha(), hotelEntity.getCosto(), hotelEntity.getDuracion());
        validarHotel(hotelEntity.getTiempoHospedaje());
        hotelEntity.setCentroDeEntrenamiento(CentroDeEntrenamientoEntity);
        return hotelEntity;
    }

    /**
     * Borrar un Hotel de un CentroDeEntrenamiento
     *
     * @param hotelId El hotel que se desea borrar del CentroDeEntrenamiento.
     * @param centroDeEntrenamientoId La CentroDeEntrenamiento del cual se desea
     * eliminar.
     */
    public void removeHotel(Long hotelId, Long centroDeEntrenamientoId) {
        CentroDeEntrenamientoEntity centroDeEntrenamientoEntity = getCentroDeEntrenamiento(centroDeEntrenamientoId);
        HotelEntity hotel = hotelLogic.getHotel(hotelId);
        hotel.setCentroDeEntrenamiento(null);
        centroDeEntrenamientoEntity.getHoteles().remove(hotel);
    }

    /**
     * Remplazar Hotels de una CentroDeEntrenamiento
     *
     * @param hoteles Lista de hotels que serán los del CentroDeEntrenamiento.
     * @param centroDeEntrenamientoId El id del CentroDeEntrenamiento que se
     * quiere actualizar.
     * @return La lista de hotels actualizada.
     */
    public List<HotelEntity> replaceHoteles(Long centroDeEntrenamientoId, List<HotelEntity> hoteles) {
        CentroDeEntrenamientoEntity centroDeEntrenamiento = getCentroDeEntrenamiento(centroDeEntrenamientoId);
        List<HotelEntity> hotelList = hotelLogic.getHoteles();
        for (HotelEntity hotel : hotelList) {
            if (hoteles.contains(hotel)) {
                hotel.setCentroDeEntrenamiento(centroDeEntrenamiento);
            } else if (hotel.getCentroDeEntrenamiento() != null && hotel.getCentroDeEntrenamiento().equals(centroDeEntrenamiento)) {
                hotel.setCentroDeEntrenamiento(null);
            }
        }
        return hoteles;
    }

    /**
     * Retorna todos los Hotels asociados a una CentroDeEntrenamiento
     *
     * @param centroDeEntrenamientoId El ID del CentroDeEntrenamiento buscada
     * @return La lista de hotels del CentroDeEntrenamiento
     */
    public List<HotelEntity> getHoteles(Long centroDeEntrenamientoId) {
        return getCentroDeEntrenamiento(centroDeEntrenamientoId).getHoteles();
    }

    /**
     * Retorna un Hotel asociado a una CentroDeEntrenamiento
     *
     * @param centroDeEntrenamientoId El id del CentroDeEntrenamiento a buscar.
     * @param hotelId El id del hotel a buscar
     * @return El hotel encontrado dentro del CentroDeEntrenamiento.
     * @throws BusinessLogicException Si el hotel no se encuentra en la
     * CentroDeEntrenamiento
     */
    public HotelEntity getHotel(Long centroDeEntrenamientoId, Long hotelId) throws BusinessLogicException {
        List<HotelEntity> hoteles = getCentroDeEntrenamiento(centroDeEntrenamientoId).getHoteles();
        HotelEntity hotel = hotelLogic.getHotel(hotelId);
        int index = hoteles.indexOf(hotel);
        if (index >= 0) {
            return hoteles.get(index);
        }
        throw new BusinessLogicException("El hotel no está asociado al CentroDeEntrenamiento");

    }

    public void validarServicios(Date fecha, Double costo, Double duracion) throws BusinessLogicException {
        Date todayDate = Calendar.getInstance().getTime();
        if (fecha.before(todayDate)) {
            throw new BusinessLogicException("La fecha ingresada no es valida");
        }
        if (costo < 0) {
            throw new BusinessLogicException("El costo es invalido");
        }
        if (duracion < 0) {
            throw new BusinessLogicException("La duracion es invalida");
        }

    }

    public void validarHotel(Integer tHospedaje) throws BusinessLogicException {
        if (tHospedaje < 12) {
            throw new BusinessLogicException("El tiempo de hospedaje no puede ser menor a 24 horas");
        }
    }
}
