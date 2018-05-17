/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.watchdogs.ejb;

import co.edu.uniandes.csw.watchdogs.entities.CalificacionEntity;
import co.edu.uniandes.csw.watchdogs.entities.ClienteEntity;
import co.edu.uniandes.csw.watchdogs.entities.EmpleadoEntity;
import co.edu.uniandes.csw.watchdogs.entities.FacturaEntity;
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
    private ClienteLogic clienteLogic;

    @Inject
    private MascotaLogic mascotaLogic;

    @Inject
    private EmpleadoLogic empleadoLogic;

    @Inject
    private FacturaLogic facturaLogic;

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
        LOGGER.info("Inicia proceso de creación de Hotel");
        validarServicios(entity);
        ClienteEntity cliente = clienteLogic.getCliente(entity.getCliente().getId());
        MascotaEntity mascota = mascotaLogic.getMascota(entity.getMascota().getId());
        entity.setCliente(cliente);
        entity.setMascota(mascota);
        persistence.create(entity);
        LOGGER.info("Termina proceso de creación de Hotel");
        return entity;
    }

    /**
     * Guardar un nuevo hotel
     *
     * @param idC
     * @param entity La entidad de tipo hotel del nuevo libro a persistir.
     * @return La entidad luego de persistirla
     * @throws BusinessLogicException
     */
    public HotelEntity createClienteHotel(Long idC, HotelEntity entity) throws BusinessLogicException {
        LOGGER.info("Inicia proceso de creación de hotel. Logica");

        Date todayDate = Calendar.getInstance().getTime();
        if (todayDate.before(entity.getFecha())) {
            ClienteEntity cliente = clienteLogic.getCliente(idC);
            MascotaEntity mascota = mascotaLogic.getMascota(entity.getMascota().getId());
            entity.setCosto(costo(entity.getDuracion()));
            entity.setEstado(true);
            entity.setCliente(cliente);
            entity.setMascota(mascota);
            persistence.create(entity);
            LOGGER.info("Termina proceso de creación de hotel");
            return entity;
        } else {
            throw new BusinessLogicException("La fecha del servicio debe ser posterior a hoy");
        }
    }

    /**
     * Guardar un nuevo hotel
     *
     * @param idC
     * @param entity La entidad de tipo hotel del nuevo libro a persistir.
     * @return La entidad luego de persistirla
     * @throws BusinessLogicException
     */
    public HotelEntity createFullHotel(Long idC, HotelEntity entity) throws BusinessLogicException {
        LOGGER.info("Inicia proceso de creación de hotel. Logica");

        Date todayDate = Calendar.getInstance().getTime();
        if (todayDate.before(entity.getFecha())) {
            ClienteEntity cliente = clienteLogic.getCliente(idC);
            MascotaEntity mascota = mascotaLogic.getMascota(entity.getMascota().getId());
            FacturaEntity factura = new FacturaEntity();
            factura.setCliente(cliente);
            factura.setValor(costo(entity.getDuracion()));
            facturaLogic.createFactura(factura);
            entity.setCosto(costo(entity.getDuracion()));
            entity.setEstado(true);
            entity.setCliente(cliente);
            entity.setMascota(mascota);
            persistence.create(entity);
            LOGGER.info("Termina proceso de creación de hotel");
            return entity;
        } else {
            throw new BusinessLogicException("La fecha del servicio debe ser posterior a hoy");
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
        LOGGER.log(Level.INFO, "Inicia proceso de actualizar Hotel con id={0}", id);
        validarServicios(entity);
        ClienteEntity cliente = clienteLogic.getCliente(entity.getCliente().getId());
        MascotaEntity mascota = mascotaLogic.getMascota(entity.getMascota().getId());
        EmpleadoEntity empleado = empleadoLogic.getEmpleado(entity.getEmpleado().getId());
        entity.setCliente(cliente);
        entity.setMascota(mascota);
        entity.setEmpleado(empleado);
        HotelEntity newEntity = persistence.update(entity);
        LOGGER.log(Level.INFO, "Termina proceso de actualizar Hotel con id={0}", entity.getId());
        return newEntity;
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
     * @param idH
     * @param transporte
     * @return El transporte que fue agregado al Hotel.
     * @throws co.edu.uniandes.csw.watchdogs.exceptions.BusinessLogicException
     */
    public TransporteEntity addTransporte(Long idH, TransporteEntity transporte) throws BusinessLogicException {
        HotelEntity hotelEntity = getHotel(idH);
        if (hotelEntity.isEstado()) {
            hotelEntity.setTransporte(transporte);
            return getTransporte(idH);
        } else {
            throw new BusinessLogicException("El hotel no ha acabado.");
        }
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

    /**
     * Metodo que devuelve la calificacion del hotel con id dado por parametro.
     *
     * @param id del hotel
     * @return CalificacionEntity
     */
    public CalificacionEntity getCalificacion(Long id) {
        return getHotel(id).getCalificacion();
    }

    /**
     *
     * @param idE Long id del hotel
     * @param calificacion CalificacionEntity
     * @return CalificacionEntity
     * @throws BusinessLogicException
     */
    public CalificacionEntity addCalificacion(Long idE, CalificacionEntity calificacion) throws BusinessLogicException {
        HotelEntity hotelEntity = getHotel(idE);
        if (!hotelEntity.isEstado()) {
            hotelEntity.setCalificacion(calificacion);
            return getCalificacion(idE);
        } else {
            throw new BusinessLogicException("El hotel no ha acabado.");
        }
    }

    /**
     *
     * @param entity
     * @throws BusinessLogicException
     */
    private void validarServicios(HotelEntity entity) throws BusinessLogicException {
        Date todayDate = Calendar.getInstance().getTime();
        if (entity.getFecha().before(todayDate)) {
            throw new BusinessLogicException("La fecha ingresada no es valida");
        }
        if (entity.getCosto() < 0) {
            throw new BusinessLogicException("El costo es invalido");
        }
        if (entity.getDuracion() < 0) {
            throw new BusinessLogicException("La duracion es invalida");
        }
        if (entity.getTiempoHospedaje() < 12) {
            throw new BusinessLogicException("El tiempo de hospedaje no puede ser menor a 24 horas");
        }

    }

    private Double costo(double duracion) {
        return duracion * 1.5;
    }
}
