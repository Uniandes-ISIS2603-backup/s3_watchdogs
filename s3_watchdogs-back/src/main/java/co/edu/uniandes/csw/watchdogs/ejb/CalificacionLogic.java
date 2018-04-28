/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.watchdogs.ejb;

import co.edu.uniandes.csw.watchdogs.entities.CalificacionEntity;
import co.edu.uniandes.csw.watchdogs.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.watchdogs.persistence.CalificacionPersistence;
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
public class CalificacionLogic {

    private static final Logger LOGGER = Logger.getLogger(EntrenamientoLogic.class.getName());

    @Inject
    private CalificacionPersistence persistence;

    /**
     * Devuelve todos los Calificacion que hay en la base de datos.
     *
     * @return Lista de entidades de tipo Calificacion.
     */
    public List<CalificacionEntity> getCalificaciones() {
        LOGGER.info("Inicia proceso de consultar todos los Calificacion");
        List<CalificacionEntity> calificaciones = persistence.findAll();
        LOGGER.info("Termina proceso de consultar todos los Calificacion");
        return calificaciones;
    }

    /**
     * Busca un Calificacion por ID
     *
     * @param id El id del Calificacion a buscar
     * @return El Calificacion encontrado, null si no lo encuentra.
     */
    public CalificacionEntity getCalificacion(Long id) {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar Calificacion con id={0}", id);
        CalificacionEntity calificacion = persistence.find(id);
        if (calificacion == null) {
            LOGGER.log(Level.SEVERE, "El Calificacion con el id {0} no existe", id);
        }
        LOGGER.log(Level.INFO, "Termina proceso de consultar Calificacion con id={0}", id);
        return calificacion;
    }

    /**
     * Guardar un nuevo Calificacion
     *
     * @param entity La entidad de tipo Calificacion del nuevo libro a
     * persistir.
     * @return La entidad luego de persistirla
     * @throws BusinessLogicException
     */
    public CalificacionEntity createCalificacion(CalificacionEntity entity) throws BusinessLogicException {
        LOGGER.info("Inicia proceso de creación de Calificacion");

        persistence.create(entity);
        LOGGER.info("Termina proceso de creación de Calificacion");
        return entity;
    }

    /**
     * Actualizar un Calificacion por ID
     *
     * @param id El ID del Calificacion a actualizar
     * @param entity La entidad del Calificacion con los cambios deseados
     * @return La entidad del Entrenamiento luego de actualizarla
     * @throws BusinessLogicException
     */
    public CalificacionEntity updateCalificacion(Long id, CalificacionEntity entity) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "Inicia proceso de actualizar Calificacion con id={0}", id);

        CalificacionEntity newEntity = persistence.update(entity);
        LOGGER.log(Level.INFO, "Termina proceso de actualizar Calificacion con id={0}", entity.getId());
        return newEntity;
    }

    /**
     * Eliminar un Calificacion por ID
     *
     * @param id El ID del Calificacion a eliminar
     */
    public void deleteCalificacion(Long id) {
        LOGGER.log(Level.INFO, "Inicia proceso de borrar Calificacion con id={0}", id);
        persistence.delete(id);
        LOGGER.log(Level.INFO, "Termina proceso de borrar Calificacion con id={0}", id);
    }
}
