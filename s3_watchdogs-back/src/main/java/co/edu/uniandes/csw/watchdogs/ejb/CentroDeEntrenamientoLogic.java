/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.watchdogs.ejb;

import co.edu.uniandes.csw.watchdogs.entities.CentroDeEntrenamientoEntity;
import co.edu.uniandes.csw.watchdogs.entities.CentroDeEntrenamientoEntity;
import co.edu.uniandes.csw.watchdogs.entities.EntrenamientoEntity;
import co.edu.uniandes.csw.watchdogs.entities.CentroDeEntrenamientoEntity;
import co.edu.uniandes.csw.watchdogs.entities.HotelEntity;
import co.edu.uniandes.csw.watchdogs.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.watchdogs.persistence.CentroDeEntrenamientoPersistence;
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
public class CentroDeEntrenamientoLogic {
    
    private static final Logger LOGGER = Logger.getLogger(CentroDeEntrenamientoLogic.class.getName());
    
    @Inject
    private CentroDeEntrenamientoPersistence persistence;

    /**
     * Devuelve todos los CentroDeEntrenamiento que hay en la base de datos.
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
     * @param entity La entidad de tipo CentroDeEntrenamiento del nuevo libro a persistir.
     * @return La entidad luego de persistirla
     * @throws BusinessLogicException 
     */
    public CentroDeEntrenamientoEntity createCentroDeEntrenamiento(CentroDeEntrenamientoEntity entity) throws BusinessLogicException {
        LOGGER.info("Inicia proceso de creación de CentroDeEntrenamiento");
        
        persistence.create(entity);
        LOGGER.info("Termina proceso de creación de CentroDeEntrenamiento");
        return entity;
    }
    
    /**
     * Actualizar un CentroDeEntrenamiento por ID
     * @param id El ID del CentroDeEntrenamiento a actualizar
     * @param entity La entidad del CentroDeEntrenamiento con los cambios deseados
     * @return La entidad del CentroDeEntrenamiento luego de actualizarla
     * @throws BusinessLogicException 
     */
    public CentroDeEntrenamientoEntity updateCentroDeEntrenamiento(Long id, CentroDeEntrenamientoEntity entity) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "Inicia proceso de actualizar CentroDeEntrenamiento con id={0}", id);
        
        CentroDeEntrenamientoEntity newEntity = persistence.update(entity);
        LOGGER.log(Level.INFO, "Termina proceso de actualizar CentroDeEntrenamiento con id={0}", entity.getId());
        return newEntity;
    }
    
    /**
     * Eliminar un CentroDeEntrenamiento por ID
     * @param id El ID del CentroDeEntrenamiento a eliminar
     */
    public void deleteCentroDeEntrenamiento(Long id) {
        LOGGER.log(Level.INFO, "Inicia proceso de borrar CentroDeEntrenamiento con id={0}", id);
        persistence.delete(id);
        LOGGER.log(Level.INFO, "Termina proceso de borrar CentroDeEntrenamiento con id={0}", id);
    }
    
    public ArrayList<EntrenamientoEntity> getEntrenamientos(Long id){
        return getCentroDeEntrenamiento(id).getEntrenamientos();
    }
    
    public EntrenamientoEntity getEntrenamiento(Long idC, Long idE){
        CentroDeEntrenamientoEntity centroDeEntrenamientoEntity = getCentroDeEntrenamiento(idC);
        EntrenamientoEntity EntrenamientoEntity = null;
        for(EntrenamientoEntity eEnt : centroDeEntrenamientoEntity.getEntrenamientos()){
            if(eEnt.getId().equals(idE))
                EntrenamientoEntity = eEnt;
        }
        return EntrenamientoEntity;
    }
    
    public EntrenamientoEntity addEntrenamiento(Long idC,Long idE){
        CentroDeEntrenamientoEntity centroDeEntrenamientoEntity = getCentroDeEntrenamiento(idC);
        EntrenamientoEntity eEntity = new EntrenamientoEntity();
        eEntity.setId(idE);
        centroDeEntrenamientoEntity.getEntrenamientos().add(eEntity);
        return getEntrenamiento(idC,idE);
    }
    
    public EntrenamientoEntity replaceEntrenamiento(Long id,Long idE, EntrenamientoEntity entrenamiento){
        CentroDeEntrenamientoEntity centroDeEntrenamientoEntity = getCentroDeEntrenamiento(id);
        for(EntrenamientoEntity eEnt : centroDeEntrenamientoEntity.getEntrenamientos()){
            if(eEnt.getId().equals(idE))
                eEnt = entrenamiento; break;
        }
        return getEntrenamiento(id, entrenamiento.getId());
    }
    
    public ArrayList<HotelEntity> getHoteles(Long id){
        return getCentroDeEntrenamiento(id).getHoteles();
    }
    
    public HotelEntity getHotel(Long idC, Long idH){
        CentroDeEntrenamientoEntity centroDeEntrenamientoEntity = getCentroDeEntrenamiento(idC);
        HotelEntity HotelEntity = null;
        for(HotelEntity hEnt : centroDeEntrenamientoEntity.getHoteles()){
            if(hEnt.getId().equals(idH))
                HotelEntity = hEnt;
        }
        return HotelEntity;
    }
    
    public HotelEntity addHotel(Long idC,Long idH){
        CentroDeEntrenamientoEntity centroDeEntrenamientoEntity = getCentroDeEntrenamiento(idC);
        HotelEntity hEntity = new HotelEntity();
        hEntity.setId(idH);
        centroDeEntrenamientoEntity.getHoteles().add(hEntity);
        return getHotel(idC,idH);
    }
    
    public HotelEntity replaceHotel(Long id,Long idH, HotelEntity hotel){
        CentroDeEntrenamientoEntity centroDeEntrenamientoEntity = getCentroDeEntrenamiento(id);
        for(HotelEntity hEnt : centroDeEntrenamientoEntity.getHoteles()){
            if(hEnt.getId().equals(idH))
                hEnt = hotel; break;
        }
        return getHotel(id, hotel.getId());
    }
}
