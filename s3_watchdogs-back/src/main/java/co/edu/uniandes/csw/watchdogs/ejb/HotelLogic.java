/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.watchdogs.ejb;

import co.edu.uniandes.csw.watchdogs.entities.ClienteEntity;
import co.edu.uniandes.csw.watchdogs.entities.EmpleadoEntity;
import co.edu.uniandes.csw.watchdogs.entities.HotelEntity;
import co.edu.uniandes.csw.watchdogs.entities.MascotaEntity;
import co.edu.uniandes.csw.watchdogs.entities.TransporteEntity;
import co.edu.uniandes.csw.watchdogs.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.watchdogs.persistence.HotelPersistence;
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
public class HotelLogic {

    private static final Logger LOGGER = Logger.getLogger(HotelLogic.class.getName());

    @Inject
    private HotelPersistence persistence;

    @Inject
    private TransporteLogic transporteLogic;

    @Inject
    private ClienteLogic clienteLogic;

    @Inject
    private MascotaLogic mascotaLogic;

    @Inject
    private EmpleadoLogic empleadoLogic;

    /**
     * Devuelve todos los Hotel que hay en la base de datos.
     *
     * @return Lista de entidades de tipo Hotel.
     */
    public List<HotelEntity> getHoteles() {
        LOGGER.info("Inicia proceso de consultar todos los Hotel");
        List<HotelEntity> hotels = persistence.findAll();
        LOGGER.info("Termina proceso de consultar todos los Hotel");
        return hotels;
    }

    /**
     * Busca un Hotel por ID
     *
     * @param id El id del Hotel a buscar
     * @return El Hotel encontrado, null si no lo encuentra.
     */
    public HotelEntity getHotel(Long id) {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar Hotel con id={0}", id);
        HotelEntity hotel = persistence.find(id);
        if (hotel == null) {
            LOGGER.log(Level.SEVERE, "El Hotel con el id {0} no existe", id);
        }
        LOGGER.log(Level.INFO, "Termina proceso de consultar Transporte con id={0}", id);
        return hotel;
    }

    /**
     * Guardar un nuevo Hotel
     *
     * @param entity La entidad de tipo Hotel del nuevo transporte a persistir.
     * @return La entidad luego de persistirla
     * @throws BusinessLogicException
     */
    public HotelEntity createHotel(HotelEntity entity) throws BusinessLogicException {
        LOGGER.info("Inicia proceso de creación de Hotel. Logica");
        Date todayDate = Calendar.getInstance().getTime();
        if (todayDate.before(entity.getFecha())) {
            ClienteEntity cliente = clienteLogic.getCliente(entity.getCliente().getId());
            MascotaEntity mascota = mascotaLogic.getMascota(entity.getMascota().getId());
            entity.setCosto(entity.getDuracion()*10000.0);
            entity.setEstado(true);
            entity.setCliente(cliente);
            entity.setMascota(mascota);
            persistence.create(entity);
            LOGGER.info("Termina proceso de creación de Hotel");
            return entity;
        } else {
            throw new BusinessLogicException("La fecha del servicio debe ser posterior a la de hoy");
        }
    }
    
    /**
     * 
     * @param idC
     * @param entity
     * @return
     * @throws BusinessLogicException 
     */
    public HotelEntity crear( HotelEntity entity) throws BusinessLogicException {
        LOGGER.info("Inicia proceso de creación de Hotel. Logica");

        Date todayDate = Calendar.getInstance().getTime();
        if (todayDate.before(entity.getFecha())) {
            ClienteEntity cliente = clienteLogic.getCliente(entity.getCliente().getId());
            MascotaEntity mascota = mascotaLogic.getMascota(entity.getMascota().getId());
            entity.setCosto(entity.getDuracion()*10000.0);
            entity.setEstado(true);
            entity.setCliente(cliente);
            entity.setMascota(mascota);
            persistence.create(entity);
            LOGGER.info("Termina proceso de creación de Hotel");
            return entity;
        } else {
            throw new BusinessLogicException("La fecha del servicio debe ser posterior a la de hoy");
        }
    }

    /**
     * Actualizar un Hotel por ID
     *
     * @param id El ID del Hotel a actualizar
     * @param entity La entidad del Hotel con los cambios deseados
     * @return La entidad del Hotel luego de actualizarla
     * @throws BusinessLogicException
     */
    public HotelEntity updateHotel(Long id, HotelEntity entity) throws BusinessLogicException {
        LOGGER.info("Inicia proceso de actualizar Hotel ");
        HotelEntity hotelEntity = getHotel(id);
        if(hotelEntity == null){
            throw new BusinessLogicException("El hotel no existe");
        }
        //entity.setDuracion(entity.getTiempoHospedaje().doubleValue());
        //entity.setCosto(costo(entity.getTiempoHospedaje().doubleValue()));
        HotelEntity newEntity = persistence.update(entity);
        LOGGER.info("Termina proceso de actualizar Hotel");
        return newEntity;
        
        /**Date todayDate = Calendar.getInstance().getTime();
        if (todayDate.before(entity.getFecha())) {
            ClienteEntity cliente = clienteLogic.getCliente(entity.getCliente().getId());
            MascotaEntity mascota = mascotaLogic.getMascota(entity.getMascota().getId());
            EmpleadoEntity empleado = empleadoLogic.getEmpleado(entity.getEmpleado().getId());
            entity.setDuracion(entity.getTiempoHospedaje().doubleValue());
            entity.setCosto(costo(entity.getTiempoHospedaje().doubleValue()));
            entity.setCliente(cliente);
            entity.setMascota(mascota);
            entity.setEmpleado(empleado);
            HotelEntity newEntity = persistence.update(entity);
            LOGGER.info("Termina proceso de actualizar Hotel");
            return newEntity;
        } else {
            throw new BusinessLogicException("La fecha debe ser posterior a hoy.");
        }**/
    }

    /**
     * Eliminar un paseo por ID
     *
     * @param id El ID del paseo a eliminar
     */
    public void deleteHotel(Long id) {
        LOGGER.log(Level.INFO, "Inicia proceso de borrar Hotel con id={0}", id);
        persistence.delete(id);
        LOGGER.log(Level.INFO, "Termina proceso de borrar Hotel con id={0}", id);
    }

    /**
     * Agregar un Transporte al Hotel
     *
     * @param transporteId El id transporte a guardar
     * @param hotelId El id del Hotel en la cual se va a guardar el transporte.
     * @return El transporte que fue agregado al Hotel.
     */
    public TransporteEntity addTransporte(Long transporteId, Long hotelId) throws BusinessLogicException {
        HotelEntity hotelEntity = getHotel(hotelId);
        TransporteEntity transporteEntity = transporteLogic.getTransporte(transporteId);
        validarTransporte(transporteEntity.getId(), transporteEntity.getName(), transporteEntity.getDevuelta(), transporteEntity.getRecogida(), transporteEntity.getDireccion());
        hotelEntity.setTransporte(transporteEntity);
        return transporteEntity;
    }

    /**
     * Borrar un Transporte de un Hotel
     *
     * @param hotelId La Hotel del cual se desea eliminar.
     */
    public void removeTransporte(Long hotelId) {
        HotelEntity hotelEntity = getHotel(hotelId);
        hotelEntity.setTransporte(null);
    }

    /**
     * Remplazar Transportes de un Hotel
     *
     * @param transporteEntity Lista de transportes que serán los del Hotel.
     * @param hotelId El id del Hotel que se quiere actualizar.
     * @return La lista de transportes actualizada.
     */
    public TransporteEntity replaceTransportes(Long hotelId, TransporteEntity transporteEntity) throws BusinessLogicException {
        validarTransporte(transporteEntity.getId(), transporteEntity.getName(), transporteEntity.getDevuelta(), transporteEntity.getRecogida(), transporteEntity.getDireccion());
        HotelEntity hotel = getHotel(hotelId);
        hotel.setTransporte(transporteEntity);
        return transporteEntity;
    }

    /**
     * Retorna un Transporte asociado a un Hotel
     *
     * @param hotelId El id del Hotel a buscar.
     * @return El transporte encontrado dentro del Hotel.
     */
    public TransporteEntity getTransporte(Long hotelId) {
        return getHotel(hotelId).getTransporte();
    }

    public void validarTransporte(Long id, String nombre, Integer devuelta, Integer recogida, String direccion) throws BusinessLogicException {
        if (id < 0) {
            throw new BusinessLogicException("El id es invalido");
        } else if (nombre.length() > 50) {
            throw new BusinessLogicException("El nombre es muy grande");
        } else if (recogida > devuelta) {
            throw new BusinessLogicException("La hora de recogida no puede ser mas tarde que la de devuelta");
        } else if (direccion.length() > 50) {
            throw new BusinessLogicException("La direccion es muy grande");
        }
    }

    private Double costo(double duracion) {
        return duracion * 10000;
    }

}
