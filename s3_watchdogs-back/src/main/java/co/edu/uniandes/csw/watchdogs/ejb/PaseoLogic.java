/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.watchdogs.ejb;

import co.edu.uniandes.csw.watchdogs.entities.VeterinariaEntity;
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
     * @param entity La entidad de tipo Paseo del nuevo libro a persistir.
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
    
    public VeterinariaEntity getVeterinaria(Long id){
        return getPaseo(id).getVeterinaria();
    }
    
    public VeterinariaEntity addVeterinaria(Long idV, Long idP){
        PaseoEntity paseoEntity = getPaseo(idP);
        VeterinariaEntity vetEntity = new VeterinariaEntity();
        vetEntity.setId(idV);
        paseoEntity.setVeterinaria(vetEntity);
        return getVeterinaria(idV);
    }
    
    public VeterinariaEntity replaceVeterinaria(Long id, VeterinariaEntity vet){
        PaseoEntity paseoEntity = getPaseo(id);
        paseoEntity.setVeterinaria(vet);
        return paseoEntity.getVeterinaria();
    }
    public ArrayList<RutaEntity> getRutas(Long id){
        return getPaseo(id).getRutas();
    }
    
    public RutaEntity getRuta(Long idP, Long idR){
        PaseoEntity paseoEntity = getPaseo(idP);
        RutaEntity rutaEntity = null;
        for(RutaEntity rEnt : paseoEntity.getRutas()){
            if(rEnt.getId().equals(idR))
                rutaEntity = rEnt;
        }
        return rutaEntity;
    }
    
    public RutaEntity addRuta(Long idP,Long idR){
        PaseoEntity paseoEntity = getPaseo(idP);
        RutaEntity rEntity = new RutaEntity();
        rEntity.setId(idR);
        paseoEntity.getRutas().add(rEntity);
        return getRuta(idP,idR);
    }
    
    public RutaEntity replaceRuta(Long id,Long idR, RutaEntity ruta){
        PaseoEntity paseoEntity = getPaseo(id);
        for(RutaEntity rEnt : paseoEntity.getRutas()){
            if(rEnt.getId().equals(idR))
                rEnt = ruta; break;
        }
        return getRuta(id, ruta.getId());
    }
   
}
