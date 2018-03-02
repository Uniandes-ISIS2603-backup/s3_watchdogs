/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.watchdogs.ejb;

import co.edu.uniandes.csw.watchdogs.entities.RutaEntity;
import co.edu.uniandes.csw.watchdogs.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.watchdogs.persistence.RutaPersistence;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author id.salazar
 */

@Stateless
public class RutaLogic {
    
    private static final Logger LOGGER = Logger.getLogger(RutaLogic.class.getName());
    
    @Inject
    private RutaPersistence persistence;

    /**
     * Devuelve todas las rutas que hay en la base de datos.
     * @return Lista de entidades de tipo ruta.
     */
    public List<RutaEntity> getRutas() {
        LOGGER.info("Inicia proceso de consultar todas las Rutas");
        List<RutaEntity> rutas = persistence.findAll();
        LOGGER.info("Termina proceso de consultar todas las Rutas");
        return rutas;
    }
    
    /**
     * Busca una ruta por ID
     * @param id El id de la ruta a buscar
     * @return La ruta encontrada, null si no la encuentra.
     */
    public RutaEntity getRuta(Long id) {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar Ruta con id={0}", id);
        RutaEntity ruta = persistence.find(id);
        if (ruta == null) {
            LOGGER.log(Level.SEVERE, "La Ruta con el id {0} no existe", id);
        }
        LOGGER.log(Level.INFO, "Termina proceso de consultar ruta con id={0}", id);
        return ruta;
    }
    
    /**
     * Guardar una nueva Ruta
     * @param entity La nueva entidad de tipo Ruta a persistir.
     * @return La entidad luego de persistirla
     * @throws BusinessLogicException 
     */
    public RutaEntity createRuta(RutaEntity entity) throws BusinessLogicException {
        LOGGER.info("Inicia proceso de creación de Ruta");
        check(entity);
        persistence.create(entity);
        LOGGER.info("Termina proceso de creación de Ruta");
        return entity;
    }
    
    /**
     * Actualizar una Ruta por ID
     * @param id El ID de la Ruta a actualizar
     * @param entity La entidad de la Ruta con los cambios deseados
     * @return La entidad de la Ruta luego de actualizarla
     * @throws BusinessLogicException 
     */
    public RutaEntity updateRuta(Long id, RutaEntity entity) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "Inicia proceso de actualizar Ruta con id={0}", id);
        check(entity);
        RutaEntity newEntity = persistence.update(entity);
        LOGGER.log(Level.INFO, "Termina proceso de actualizar Ruta con id={0}", entity.getId());
        return newEntity;
    }
    
    /**
     * Eliminar una Ruta por ID
     * @param id El ID de la Ruta a eliminar
     */
    public void deleteRuta(Long id) {
        LOGGER.log(Level.INFO, "Inicia proceso de borrar Ruta con id={0}", id);
        persistence.delete(id);
        LOGGER.log(Level.INFO, "Termina proceso de borrar Ruta con id={0}", id);
    }
    
    
     public void check(RutaEntity entity)throws BusinessLogicException{
        checkDuracionValida(entity);
    }
    
    
    /**
     * verifica que la duracion de la ruta sea superior a 0 y no mayor a 120
     */
    public void checkDuracionValida(RutaEntity entity) throws BusinessLogicException{
        if( entity.getDuracion()< 0  || entity.getDuracion() > 120){
            throw new BusinessLogicException("La duracion de la ruta no es válida");
        }
    }
}
