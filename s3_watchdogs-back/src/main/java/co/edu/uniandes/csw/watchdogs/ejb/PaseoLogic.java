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
import co.edu.uniandes.csw.watchdogs.entities.MascotaEntity;
import co.edu.uniandes.csw.watchdogs.entities.PaseoEntity;
import co.edu.uniandes.csw.watchdogs.entities.RutaEntity;
import co.edu.uniandes.csw.watchdogs.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.watchdogs.persistence.PaseoPersistence;
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
public class PaseoLogic {

    private static final Logger LOGGER = Logger.getLogger(PaseoLogic.class.getName());

    @Inject
    private PaseoPersistence persistence;

    @Inject
    private RutaLogic rutaLogic;

    @Inject
    private ClienteLogic clienteLogic;

    @Inject
    private MascotaLogic mascotaLogic;

    @Inject
    private EmpleadoLogic empleadoLogic;

    @Inject
    private FacturaLogic facturaLogic;

    /**
     * Devuelve todos los Paseo que hay en la base de datos.
     *
     * @return Lista de entidades de tipo Paseo.
     */
    public List<PaseoEntity> getPaseos() {
        LOGGER.info("Inicia proceso de consultar todos los paseos");
        List<PaseoEntity> paseos = persistence.findAll();
        LOGGER.info("Termina proceso de consultar todos los paseos");
        return paseos;
    }

    /**
     * Busca un Paseo por ID
     *
     * @param id El id del Paseo a buscar
     * @return El Paseo encontrado, null si no lo encuentra.
     */
    public PaseoEntity getPaseo(Long id) {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar Paseo con id={0}", id);
        PaseoEntity paseo = persistence.find(id);
        if (paseo == null) {
            LOGGER.log(Level.SEVERE, "El Paseo con el id {0} no existe", id);
        }
        LOGGER.log(Level.INFO, "Termina proceso de consultar Transporte con id={0}", id);
        return paseo;
    }

    /**
     * Guardar un nuevo Paseo
     *
     * @param entity La entidad de tipo Paseo del nuevo ruta a persistir.
     * @return La entidad luego de persistirla
     * @throws BusinessLogicException
     */
    public PaseoEntity createPaseo(PaseoEntity entity) throws BusinessLogicException {
        LOGGER.info("Inicia proceso de creación de Paseo");
        validarServicios(entity);
        ClienteEntity cliente = clienteLogic.getCliente(entity.getCliente().getId());
        MascotaEntity mascota = mascotaLogic.getMascota(entity.getMascota().getId());
        entity.setCliente(cliente);
        entity.setMascota(mascota);
        persistence.create(entity);
        LOGGER.info("Termina proceso de creación de Paseo");
        return entity;
    }

    /**
     * Guardar un nuevo Aseo
     *
     * @param idC
     * @param entity La entidad de tipo Aseo del nuevo libro a persistir.
     * @return La entidad luego de persistirla
     * @throws BusinessLogicException
     */
    public PaseoEntity createClientePaseo(Long idC, PaseoEntity entity) throws BusinessLogicException {
        LOGGER.info("Inicia proceso de creación de Aseo. Logica");

        Date todayDate = Calendar.getInstance().getTime();
        if (todayDate.before(entity.getFecha())) {
            ClienteEntity cliente = clienteLogic.getCliente(idC);
            MascotaEntity mascota = mascotaLogic.getMascota(entity.getMascota().getId());
            entity.setCosto(costo(entity.getDuracion()));
            entity.setEstado(true);
            entity.setCliente(cliente);
            entity.setMascota(mascota);
            persistence.create(entity);
            LOGGER.info("Termina proceso de creación de Aseo");
            return entity;
        } else {
            throw new BusinessLogicException("La fecha del servicio debe ser posterior a hoy");
        }
    }

    /**
     * Guardar un nuevo Aseo
     *
     * @param idC
     * @param entity La entidad de tipo Aseo del nuevo libro a persistir.
     * @return La entidad luego de persistirla
     * @throws BusinessLogicException
     */
    public PaseoEntity createFullPaseo(Long idC, PaseoEntity entity) throws BusinessLogicException {
        LOGGER.info("Inicia proceso de creación de Aseo. Logica");

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
            LOGGER.info("Termina proceso de creación de Aseo");
            return entity;
        } else {
            throw new BusinessLogicException("La fecha del servicio debe ser posterior a hoy");
        }
    }

    /**
     * Actualizar un Paseo por ID
     *
     * @param id El ID del Paseo a actualizar
     * @param entity La entidad del Paseo con los cambios deseados
     * @return La entidad del Paseo luego de actualizarla
     * @throws BusinessLogicException
     */
    public PaseoEntity updatePaseo(Long id, PaseoEntity entity) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "Inicia proceso de actualizar Paseo con id={0}", id);
        validarServicios(entity);
        ClienteEntity cliente = clienteLogic.getCliente(entity.getCliente().getId());
        MascotaEntity mascota = mascotaLogic.getMascota(entity.getMascota().getId());
        EmpleadoEntity empleado = empleadoLogic.getEmpleado(entity.getEmpleado().getId());
        entity.setCliente(cliente);
        entity.setMascota(mascota);
        entity.setEmpleado(empleado);
        PaseoEntity newEntity = persistence.update(entity);
        LOGGER.log(Level.INFO, "Termina proceso de actualizar Paseo con id={0}", entity.getId());
        return newEntity;
    }

    /**
     * Eliminar un paseo por ID
     *
     * @param id El ID del paseo a eliminar
     */
    public void deletePaseo(Long id) {
        LOGGER.log(Level.INFO, "Inicia proceso de borrar Paseo con id={0}", id);
        persistence.delete(id);
        LOGGER.log(Level.INFO, "Termina proceso de borrar Paseo con id={0}", id);
    }

    /**
     * Agregar una Ruta al Paseo
     *
     * @param rutaId El id ruta a guardar
     * @param paseoId El id del Paseo en la cual se va a guardar la ruta.
     * @return La ruta que fue agregado a la Paseo.
     * @throws co.edu.uniandes.csw.watchdogs.exceptions.BusinessLogicException
     */
    public RutaEntity addRuta(Long rutaId, Long paseoId) throws BusinessLogicException {
        PaseoEntity paseoEntity = getPaseo(paseoId);
        RutaEntity rutaEntity = rutaLogic.getRuta(rutaId);
        if (rutaEntity.getDuracion() < 0) {
            throw new BusinessLogicException("La duracion no puede ser negativa");
        }
        paseoEntity.setRuta(rutaEntity);
        return rutaEntity;
    }

    /**
     * Remplazar Rutas de un Paseo
     *
     * @param ruta Lista de rutas que serán los de la Paseo.
     * @param paseoId El id de la Paseo que se quiere actualizar.
     * @return La lista de rutas actualizada.
     */
    public RutaEntity replaceRuta(Long paseoId, RutaEntity ruta) {
        PaseoEntity paseo = getPaseo(paseoId);
        paseo.setRuta(ruta);
        return ruta;
    }

    /**
     * Retorna todas las Rutas asociados a un Paseo
     *
     * @param paseoId El ID del Paseo buscado
     * @return La lista de rutas del Paseo
     */
    public RutaEntity getRuta(Long paseoId) {
        return getPaseo(paseoId).getRuta();
    }

    /**
     * Metodo que devuelve la calificacion del paseo con id dado por parametro.
     *
     * @param id del paseo
     * @return CalificacionEntity
     */
    public CalificacionEntity getCalificacion(Long id) {
        return getPaseo(id).getCalificacion();
    }

    /**
     *
     * @param idE Long id del paseo
     * @param calificacion CalificacionEntity
     * @return CalificacionEntity
     * @throws BusinessLogicException
     */
    public CalificacionEntity addCalificacion(Long idE, CalificacionEntity calificacion) throws BusinessLogicException {
        PaseoEntity paseoEntity = getPaseo(idE);
        if (!paseoEntity.isEstado()) {
            paseoEntity.setCalificacion(calificacion);
            return getCalificacion(idE);
        } else {
            throw new BusinessLogicException("El paseo no ha acabado.");
        }
    }

    public void validarServicios(PaseoEntity entity) throws BusinessLogicException {
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
        if (entity.getCapMax() < 0) {
            throw new BusinessLogicException("La capacidad maxima no puede ser negativa");
        }
    }

    private Double costo(double duracion) {
        return duracion * 1.5;
    }
}
