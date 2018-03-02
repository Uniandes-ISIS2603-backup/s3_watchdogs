/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.watchdogs.ejb;

import co.edu.uniandes.csw.watchdogs.entities.CentroDeEntrenamientoEntity;
import co.edu.uniandes.csw.watchdogs.entities.EntrenamientoEntity;
import co.edu.uniandes.csw.watchdogs.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.watchdogs.persistence.EntrenamientoPersistence;
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

    /**
     * Devuelve todos los Entrenamiento que hay en la base de datos.
     * @return Lista de entidades de tipo Entrenamiento.
     */
    public List<EntrenamientoEntity> getEntrenamientos() {
        LOGGER.info("Inicia proceso de consultar todos los Entrenamiento");
        List<EntrenamientoEntity> entrenamientos = persistence.findAll();
        LOGGER.info("Termina proceso de consultar todos los Entrenamiento");
        return entrenamientos;
    }
    
    /**
     * Busca un Entrenamiento por ID
     * @param id El id del Entrenamiento a buscar
     * @return El Entrenamiento encontrado, null si no lo encuentra.
     */
    public EntrenamientoEntity getEntrenamiento(Long id) {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar Entrenamiento con id={0}", id);
        EntrenamientoEntity entrenamiento = persistence.find(id);
        if (entrenamiento == null) {
            LOGGER.log(Level.SEVERE, "El Entrenamiento con el id {0} no existe", id);
        }
        LOGGER.log(Level.INFO, "Termina proceso de consultar Transporte con id={0}", id);
        return entrenamiento;
    }
    
    /**
     * Guardar un nuevo Entrenamiento
     * @param entity La entidad de tipo Entrenamiento del nuevo libro a persistir.
     * @return La entidad luego de persistirla
     * @throws BusinessLogicException 
     */
    public EntrenamientoEntity createEntrenamiento(EntrenamientoEntity entity) throws BusinessLogicException {
        LOGGER.info("Inicia proceso de creación de Entrenamiento");
        
        persistence.create(entity);
        LOGGER.info("Termina proceso de creación de Entrenamiento");
        return entity;
    }
    
    /**
     * Actualizar un Entrenamiento por ID
     * @param id El ID del Entrenamiento a actualizar
     * @param entity La entidad del Entrenamiento con los cambios deseados
     * @return La entidad del Entrenamiento luego de actualizarla
     * @throws BusinessLogicException 
     */
    public EntrenamientoEntity updateEntrenamiento(Long id, EntrenamientoEntity entity) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "Inicia proceso de actualizar Entrenamiento con id={0}", id);
        
        EntrenamientoEntity newEntity = persistence.update(entity);
        LOGGER.log(Level.INFO, "Termina proceso de actualizar Entrenamiento con id={0}", entity.getId());
        return newEntity;
    }
    
    /**
     * Eliminar un Transporte por ID
     * @param id El ID del Transporte a eliminar
     */
    public void deleteEntrenamiento(Long id) {
        LOGGER.log(Level.INFO, "Inicia proceso de borrar Entrenamiento con id={0}", id);
        persistence.delete(id);
        LOGGER.log(Level.INFO, "Termina proceso de borrar Entrenamiento con id={0}", id);
    }
    
    public CentroDeEntrenamientoEntity getCentroDeEntrenamiento(Long id){
        return getEntrenamiento(id).getCentroDeEntrenamiento();
    }
    
    public CentroDeEntrenamientoEntity addCentroDeEntrenamiento(Long idC, Long idE){
        EntrenamientoEntity entrenamientoEntity = getEntrenamiento(idE);
        CentroDeEntrenamientoEntity centroEntity = new CentroDeEntrenamientoEntity();
        centroEntity.setId(idC);
        entrenamientoEntity.setCentroDeEntrenamiento(centroEntity);
        return getCentroDeEntrenamiento(idC);
    }
    
    public CentroDeEntrenamientoEntity replaceCentroDeEntrenamiento(Long id, CentroDeEntrenamientoEntity centro){
        EntrenamientoEntity entrenamientoEntity = getEntrenamiento(id);
        entrenamientoEntity.setCentroDeEntrenamiento(centro);
        return entrenamientoEntity.getCentroDeEntrenamiento();
    }
    
}
