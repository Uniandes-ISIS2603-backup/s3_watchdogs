/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.watchdogs.ejb;

import co.edu.uniandes.csw.watchdogs.entities.CalificacionEntity;
import co.edu.uniandes.csw.watchdogs.entities.CentroDeEntrenamientoEntity;
import co.edu.uniandes.csw.watchdogs.entities.ClienteEntity;
import co.edu.uniandes.csw.watchdogs.entities.EmpleadoEntity;
import co.edu.uniandes.csw.watchdogs.entities.EntrenamientoEntity;
import co.edu.uniandes.csw.watchdogs.entities.MascotaEntity;
import co.edu.uniandes.csw.watchdogs.entities.TransporteEntity;
import co.edu.uniandes.csw.watchdogs.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.watchdogs.persistence.EntrenamientoPersistence;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author c.martinezc1
 */
@Stateless
public class EntrenamientoLogic {

    private static final Logger LOGGER = Logger.getLogger(EntrenamientoLogic.class.getName());

    @Inject
    private EntrenamientoPersistence persistence;

    @Inject
    private ClienteLogic clienteLogic;

    @Inject
    private MascotaLogic mascotaLogic;

    @Inject
    private EmpleadoLogic empleadoLogic;


    /**
     * Devuelve todos los Entrenamiento que hay en la base de datos.
     *
     * @return Lista de entidades de tipo Entrenamiento.
     */
    public List<EntrenamientoEntity> getEntrenamientos() {
        LOGGER.info("Inicia proceso de consultar todos los Entrenamientos");
        List<EntrenamientoEntity> entrenamientos = persistence.findAll();
        LOGGER.info("Termina proceso de consultar todos los Entrenamientos");
        return entrenamientos;
    }

    /**
     * Busca un Entrenamiento por ID
     *
     * @param id El id del Entrenamiento a buscar
     * @return El Entrenamiento encontrado, null si no lo encuentra.
     */
    public EntrenamientoEntity getEntrenamiento(Long id) {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar Entrenamiento con id={0}", id);
        EntrenamientoEntity entrenamiento = persistence.find(id);
        if (entrenamiento == null) {
            LOGGER.log(Level.SEVERE, "El Entrenamiento con el id {0} no existe", id);
        }
        LOGGER.log(Level.INFO, "Termina proceso de consultar Entrenamiento con id={0}", id);
        return entrenamiento;
    }

    /**
     * Guardar un nuevo Entrenamiento
     *
     * @param entity La entidad de tipo Entrenamiento del nuevo libro a
     * persistir.
     * @return La entidad luego de persistirla
     * @throws BusinessLogicException
     */
    public EntrenamientoEntity createEntrenamiento(EntrenamientoEntity entity) throws BusinessLogicException {
        LOGGER.info("Inicia proceso de creación de Entrenamiento. Logica");
        Date todayDate = Calendar.getInstance().getTime();
        if (todayDate.before(entity.getFecha())) {
            ClienteEntity cliente = clienteLogic.getCliente(entity.getCliente().getId());
            MascotaEntity mascota = mascotaLogic.getMascota(entity.getMascota().getId());
            entity.setCosto(costo(entity.getDuracion()));
            entity.setEstado(true);
            entity.setCliente(cliente);
            entity.setMascota(mascota);
            persistence.create(entity);
            LOGGER.info("Termina proceso de creación de Entrenamiento");
            return entity;
        } else {
            throw new BusinessLogicException("La fecha del servicio debe ser posterior a hoy");
        }
    }
    
    

    /**
     * Guardar un nuevo Entrenamiento
     *
     * @param idC
     * @param entity La entidad de tipo Entrenamiento del nuevo libro a
     * persistir.
     * @return La entidad luego de persistirla
     * @throws BusinessLogicException
     */
    public EntrenamientoEntity createEntrenamiento(Long idC, EntrenamientoEntity entity) throws BusinessLogicException {
        LOGGER.info("Inicia proceso de creación de Entrenamiento. Logica");
        LOGGER.log(Level.INFO, "El id del cliente es: {0}", idC);
        LOGGER.log(Level.INFO, "El id del cliente es: {0}", entity.getFecha());

        Date todayDate = Calendar.getInstance().getTime();
        if (todayDate.before(entity.getFecha())) {
            ClienteEntity cliente = clienteLogic.getCliente(idC);
            MascotaEntity mascota = mascotaLogic.getMascota(entity.getMascota().getId());
            entity.setCosto(costo(entity.getDuracion()));
            entity.setEstado(true);
            entity.setCliente(cliente);
            entity.setMascota(mascota);
            persistence.create(entity);
            LOGGER.info("Termina proceso de creación de Entrenamiento");
            return entity;
        } else {
            throw new BusinessLogicException("La fecha del servicio debe ser posterior a hoy");
        }
    }

    /**
     * Actualizar un Entrenamiento por ID
     *
     * @param id El ID del Entrenamiento a actualizar
     * @param entity La entidad del Entrenamiento con los cambios deseados
     * @return La entidad del Entrenamiento luego de actualizarla
     * @throws BusinessLogicException
     */
    public EntrenamientoEntity updateEntrenamiento(Long id, EntrenamientoEntity entity) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "Inicia proceso de actualizar Entrenamiento con id={0}", id);
        Date todayDate = Calendar.getInstance().getTime();
        if (todayDate.before(entity.getFecha())) {
            ClienteEntity cliente = clienteLogic.getCliente(entity.getCliente().getId());
            MascotaEntity mascota = mascotaLogic.getMascota(entity.getMascota().getId());
            EmpleadoEntity empleado = empleadoLogic.getEmpleado(entity.getEmpleado().getId());
            entity.setCliente(cliente);
            entity.setMascota(mascota);
            entity.setEmpleado(empleado);
            EntrenamientoEntity newEntity = persistence.update(entity);
            LOGGER.log(Level.INFO, "Termina proceso de actualizar Entrenamiento con id={0}", entity.getId());
            return newEntity;
        } else {
            throw new BusinessLogicException("La fecha debe ser posterior a hoy.");
        }
    }

    /**
     * Eliminar un Transporte por ID
     *
     * @param id El ID del Transporte a eliminar
     */
    public void deleteEntrenamiento(Long id) {
        LOGGER.log(Level.INFO, "Inicia proceso de borrar Entrenamiento con id={0}", id);
        persistence.delete(id);
        LOGGER.log(Level.INFO, "Termina proceso de borrar Entrenamiento con id={0}", id);
    }

    public CentroDeEntrenamientoEntity getCentroDeEntrenamiento(Long id) {
        return getEntrenamiento(id).getCentroDeEntrenamiento();
    }

    public CentroDeEntrenamientoEntity addCentroDeEntrenamiento(Long idC, Long idE) {
        LOGGER.log(Level.INFO, "Inicia proceso de agregar centro de entrenamiento con  id={0}", idC);
        EntrenamientoEntity entrenamientoEntity = getEntrenamiento(idE);
        CentroDeEntrenamientoEntity centroEntity = new CentroDeEntrenamientoEntity();
        
        centroEntity.setId(idC);
        entrenamientoEntity.setCentroDeEntrenamiento(centroEntity);
        return getCentroDeEntrenamiento(idE);
    }

    public CentroDeEntrenamientoEntity replaceCentroDeEntrenamiento(Long id, CentroDeEntrenamientoEntity centro) {
        EntrenamientoEntity entrenamientoEntity = getEntrenamiento(id);
        entrenamientoEntity.setCentroDeEntrenamiento(centro);
        return entrenamientoEntity.getCentroDeEntrenamiento();
    }

    /**
     * Metodo que devuelve la calificacion del entrenamiento con id dado por
     * parametro.
     *
     * @param id del entrenamiento
     * @return CalificacionEntity
     */
    public CalificacionEntity getCalificacion(Long id) {
        return getEntrenamiento(id).getCalificacion();
    }

    /**
     *
     * @param idE Long id del entrenamiento
     * @param calificacion CalificacionEntity
     * @return CalificacionEntity
     * @throws BusinessLogicException
     */
    public CalificacionEntity addCalificacion(Long idE, CalificacionEntity calificacion) throws BusinessLogicException {
        EntrenamientoEntity entrenamientoEntity = getEntrenamiento(idE);
        if (!entrenamientoEntity.isEstado()) {
            entrenamientoEntity.setCalificacion(calificacion);
            return getCalificacion(idE);
        } else {
            throw new BusinessLogicException("El entrenamiento no ha acabado.");
        }
    }

    public TransporteEntity getTransporte(Long entrenamientoId) {
        return getEntrenamiento(entrenamientoId).getTransporte();
    }

    public TransporteEntity addTransporte(Long idE, TransporteEntity transporte) throws BusinessLogicException {
        EntrenamientoEntity entrenamientoEntity = getEntrenamiento(idE);
        if (entrenamientoEntity.isEstado()) {
            entrenamientoEntity.setTransporte(transporte);
            return getTransporte(idE);
        } else {
            throw new BusinessLogicException("El entrenamiento no ha acabado.");
        }
    }
    
    private Double costo(double duracion){
        return duracion * 1.5;
    }
}
