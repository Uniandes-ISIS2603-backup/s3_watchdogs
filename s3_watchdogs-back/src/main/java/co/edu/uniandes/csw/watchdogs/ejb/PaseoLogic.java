/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.watchdogs.ejb;

import co.edu.uniandes.csw.watchdogs.entities.PaseoEntity;
import co.edu.uniandes.csw.watchdogs.entities.RutaEntity;
import co.edu.uniandes.csw.watchdogs.entities.VeterinariaEntity;
import co.edu.uniandes.csw.watchdogs.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.watchdogs.persistence.PaseoPersistence;
import java.util.ArrayList;
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

    /**
     * Devuelve todos los Paseo que hay en la base de datos.
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
     * @param id El id del Paseo a buscar
     * @return El Paseo encontrado, null si no lo encuentra.
     */
    public PaseoEntity getPaseo(Long id) {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar Paseo con id={0}", id);
        PaseoEntity Paseo = persistence.find(id);
        if (Paseo == null) {
            LOGGER.log(Level.SEVERE, "El Paseo con el id {0} no existe", id);
        }
        LOGGER.log(Level.INFO, "Termina proceso de consultar Transporte con id={0}", id);
        return Paseo;
    }
    
    /**
     * Guardar un nuevo Paseo
     * @param entity La entidad de tipo Paseo del nuevo ruta a persistir.
     * @return La entidad luego de persistirla
     * @throws BusinessLogicException 
     */
    public PaseoEntity createPaseo(PaseoEntity entity) throws BusinessLogicException {
        LOGGER.info("Inicia proceso de creación de Paseo");
        
        persistence.create(entity);
        LOGGER.info("Termina proceso de creación de Paseo");
        return entity;
    }
    
    /**
     * Actualizar un Paseo por ID
     * @param id El ID del Paseo a actualizar
     * @param entity La entidad del Paseo con los cambios deseados
     * @return La entidad del Paseo luego de actualizarla
     * @throws BusinessLogicException 
     */
    public PaseoEntity updatePaseo(Long id, PaseoEntity entity) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "Inicia proceso de actualizar Paseo con id={0}", id);
        
        PaseoEntity newEntity = persistence.update(entity);
        LOGGER.log(Level.INFO, "Termina proceso de actualizar Paseo con id={0}", entity.getId());
        return newEntity;
    }
    
    /**
     * Eliminar un paseo por ID
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
     */
    public RutaEntity addRuta(Long rutaId, Long paseoId) {
        PaseoEntity paseoEntity = getPaseo(paseoId);
        RutaEntity rutaEntity = rutaLogic.getRuta(rutaId);
        paseoEntity.getRutas().add(rutaEntity);
        return rutaEntity;
    }

    /**
     * Borrar una Ruta de un Paseo
     *
     * @param rutaId La ruta que se desea borrar del Paseo.
     * @param paseoId El Paseo del cual se desea eliminar.
     */
    public void removeRuta(Long rutaId, Long paseoId) {
        PaseoEntity paseoEntity = getPaseo(paseoId);
        RutaEntity ruta = rutaLogic.getRuta(rutaId);
        paseoEntity.getRutas().remove(ruta);
    }

    /**
     * Remplazar Rutas de un Paseo
     *
     * @param rutas Lista de rutas que serán los de la Paseo.
     * @param paseoId El id de la Paseo que se quiere actualizar.
     * @return La lista de rutas actualizada.
     */
    public List<RutaEntity> replaceRutas(Long paseoId, List<RutaEntity> rutas) {
        PaseoEntity paseo = getPaseo(paseoId);
        paseo.setRutas(rutas);
        return rutas;
    }

    /**
     * Retorna todas las Rutas asociados a un Paseo
     *
     * @param paseoId El ID del Paseo buscado
     * @return La lista de rutas del Paseo
     */
    public List<RutaEntity> getRutas(Long paseoId) {
        return getPaseo(paseoId).getRutas();
    }

    /**
     * Retorna una Ruta asociada a un Paseo
     *
     * @param paseoId El id del Paseo a buscar.
     * @param rutaId El id de la ruta a buscar
     * @return La ruta encontrada dentro del Paseo.
     * @throws BusinessLogicException Si la ruta no se encuentra en el Paseo
     */
    public RutaEntity getRuta(Long paseoId, Long rutaId) throws BusinessLogicException {
        List<RutaEntity> rutas = getPaseo(paseoId).getRutas();
        RutaEntity ruta = rutaLogic.getRuta(rutaId);
        int index = rutas.indexOf(ruta);
        if (index >= 0) {
            return rutas.get(index);
        }
        throw new BusinessLogicException("El ruta no está asociado a la Paseo");

    }
   
}
