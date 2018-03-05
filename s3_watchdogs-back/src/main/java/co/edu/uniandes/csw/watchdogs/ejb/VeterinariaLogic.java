/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.watchdogs.ejb;

import co.edu.uniandes.csw.watchdogs.entities.AseoEntity;
import co.edu.uniandes.csw.watchdogs.entities.PaseoEntity;
import co.edu.uniandes.csw.watchdogs.entities.VeterinariaEntity;
import co.edu.uniandes.csw.watchdogs.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.watchdogs.persistence.VeterinariaPersistence;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author js.vacat
 */
@Stateless
public class VeterinariaLogic {
    
    private static final Logger LOGGER = Logger.getLogger(VeterinariaLogic.class.getName());
    
    @Inject
    private VeterinariaPersistence persistence;
    
    @Inject
    private PaseoLogic paseoLogic;
    
    @Inject
    private AseoLogic aseoLogic;
    
    
    /**
     * Devuelve todas las veterinarias que hay en la base de datos.
     * @return Lista de entidades de tipo Veterinaria.
     */
    public List<VeterinariaEntity> getVeterinarias() {
        LOGGER.info("Inicia proceso de consultar todas las Veterinarias");
        List<VeterinariaEntity> veterinaria = persistence.findAll();
        LOGGER.info("Termina proceso de consultar todas las veterinarias");
        return veterinaria;
    }
    
    /**
     * Busca una Veterinaria por ID
     * @param id El id de la veterinaria a buscar
     * @return La veterinaria encontrada, null si no la encuentra.
     */
    public VeterinariaEntity getVeterinaria(Long id) {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar Veterinaria con id={0}", id);
        VeterinariaEntity veterinaria = persistence.find(id);
        if (veterinaria == null) {
            LOGGER.log(Level.SEVERE, "La Veterinaria con el id {0} no existe", id);
        }
        LOGGER.log(Level.INFO, "Termina proceso de consultar Veterinaria con id={0}", id);
        return veterinaria;
    }
    
    /**
     * Guardar una nueva Veterinaria
     * @param entity La entidad de tipo veterinaria  a persistir.
     * @return La entidad luego de persistirla
     * @throws BusinessLogicException 
     */
    public VeterinariaEntity createVeterinaria(VeterinariaEntity entity) throws BusinessLogicException {
        LOGGER.info("Inicia proceso de creación de Veterinaria");
        persistence.create(entity);
        LOGGER.info("Termina proceso de creación de Veterinaria");
        return entity;
    }
    
    /**
     * Actualizar una Veterinaria por ID
     * @param id El ID de la Veterinaria a actualizar
     * @param entity La entidad de la Veterinaria con los cambios deseados
     * @return La entidad de la Veterinaria luego de actualizarla
     * @throws BusinessLogicException 
     */
    public VeterinariaEntity updateVeterinaria(Long id, VeterinariaEntity entity) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "Inicia proceso de actualizar Veterinaria con id={0}", id); 
        VeterinariaEntity newEntity = persistence.update(entity);
        LOGGER.log(Level.INFO, "Termina proceso de actualizar Veterinaria con id={0}", entity.getId());
        return newEntity;
    }
    
    /**
     * Eliminar una Veterinaria por ID
     * @param id El ID de la Veterinaria a eliminar
     */
    public void deleteVeterinaria(Long id) {
        LOGGER.log(Level.INFO, "Inicia proceso de borrar Veterinaria con id={0}", id);
        persistence.delete(id);
        LOGGER.log(Level.INFO, "Termina proceso de borrar Veterinaria con id={0}", id);
    }
    
    public List<AseoEntity> getAseos(Long id){
        return getVeterinaria(id).getAseos();
    }
    
    public AseoEntity getAseo(Long idC, Long idE) throws BusinessLogicException{
        List<AseoEntity> aseos = getVeterinaria(idC).getAseos();
        AseoEntity aseo = aseoLogic.getAseo(idE);
        int index = aseos.indexOf(aseo);
        if (index >= 0) {
            return aseos.get(index);
        }
        throw new BusinessLogicException("El Aseo no está asociado a la Veterinaria");
    }
    
    public AseoEntity addAseo(Long idC,Long idE)throws BusinessLogicException{
        VeterinariaEntity veterinariaEntity = getVeterinaria(idC);
        AseoEntity aseoEntity = aseoLogic.getAseo(idE);
        validarServicios(aseoEntity.getId(), aseoEntity.getName(), aseoEntity.getFecha(),aseoEntity.getCosto(),aseoEntity.getDuracion());
        aseoEntity.setVeterinaria(veterinariaEntity);
        return aseoEntity;
    }
    
    public List<AseoEntity> replaceAseos(Long id, List<AseoEntity> aseos){
        VeterinariaEntity veterinaria = getVeterinaria(id);
        List<AseoEntity> aseoList = aseoLogic.getAseos();
        for (AseoEntity aseo : aseoList) {
            if (aseos.contains(aseo)) {
                aseo.setVeterinaria(veterinaria);
            } else if (aseo.getVeterinaria() != null && aseo.getVeterinaria().equals(veterinaria)) {
                aseo.setVeterinaria(null);
            }
        }
        return aseos;
    }
    
    public void removeAseo(Long aseoId, Long veterinariaId) {
        VeterinariaEntity veterinariaEntity = getVeterinaria(veterinariaId);
        AseoEntity aseo = aseoLogic.getAseo(aseoId);
        aseo.setVeterinaria(null);
        veterinariaEntity.getAseos().remove(aseo);
    }
    
    
     /**
     * Agregar un Paseo a la Veterinaria
     *
     * @param paseoId El id paseo a guardar
     * @param veterinariaId El id del CentroDeEntrenamiento en la cual se va a guardar el
     * hotel.
     * @return El hotel que fue agregado al CentroDeEntrenamiento.
     */
    public  PaseoEntity addPaseo(Long paseoId, Long veterinariaId) throws BusinessLogicException {
        VeterinariaEntity veterinariaEntity = getVeterinaria(veterinariaId);
        PaseoEntity paseoEntity = paseoLogic.getPaseo(paseoId);
        validarServicios(paseoEntity.getId(), paseoEntity.getName(), paseoEntity.getFecha(),paseoEntity.getCosto(),paseoEntity.getDuracion());
       // validarHotel(hotelEntity.getTiempoHospedaje());
        paseoEntity.setVeterinaria(veterinariaEntity);
        return paseoEntity;
    }

    /**
     * Borrar un Hotel de un CentroDeEntrenamiento
     *
     * @param paseoId El hotel que se desea borrar del CentroDeEntrenamiento.
     * @param veterinariaId La CentroDeEntrenamiento del cual se desea eliminar.
     */
    public void removeHotel(Long paseoId, Long veterinariaId) {
        VeterinariaEntity veterinariaEntity = getVeterinaria(veterinariaId);
        PaseoEntity paseo = paseoLogic.getPaseo(paseoId);
        paseo.setVeterinaria(null);
        veterinariaEntity.getPaseos().remove(paseo);
    }

    /**
     * Remplazar Hotels de una CentroDeEntrenamiento
     *
     * @param paseos Lista de hotels que serán los del CentroDeEntrenamiento.
     * @param veterinariaId El id del CentroDeEntrenamiento que se quiere actualizar.
     * @return La lista de hotels actualizada.
     */
    public List<PaseoEntity> replacePaseos(Long veterinariaId, List<PaseoEntity> paseos) {
       VeterinariaEntity veterinaria = getCentroDeEntrenamiento(centroDeEntrenamientoId);
        List<HotelEntity> hotelList = hotelLogic.getHoteles();
        for (HotelEntity hotel : hotelList) {
            if (hoteles.contains(hotel)) {
                hotel.setCentroDeEntrenamiento(centroDeEntrenamiento);
            } else if (hotel.getCentroDeEntrenamiento() != null && hotel.getCentroDeEntrenamiento().equals(centroDeEntrenamiento)) {
                hotel.setCentroDeEntrenamiento(null);
            }
        }
        return hoteles;
    }

    /**
     * Retorna todos los Hotels asociados a una CentroDeEntrenamiento
     *
     * @param centroDeEntrenamientoId El ID del CentroDeEntrenamiento buscada
     * @return La lista de hotels del CentroDeEntrenamiento
     */
    public List<HotelEntity> getHoteles(Long centroDeEntrenamientoId) {
        return getCentroDeEntrenamiento(centroDeEntrenamientoId).getHoteles();
    }

    /**
     * Retorna un Hotel asociado a una CentroDeEntrenamiento
     *
     * @param centroDeEntrenamientoId El id del CentroDeEntrenamiento a buscar.
     * @param hotelId El id del hotel a buscar
     * @return El hotel encontrado dentro del CentroDeEntrenamiento.
     * @throws BusinessLogicException Si el hotel no se encuentra en la CentroDeEntrenamiento
     */
    public HotelEntity getHotel(Long centroDeEntrenamientoId, Long hotelId) throws BusinessLogicException {
        List<HotelEntity> hoteles = getCentroDeEntrenamiento(centroDeEntrenamientoId).getHoteles();
        HotelEntity hotel = hotelLogic.getHotel(hotelId);
        int index = hoteles.indexOf(hotel);
        if (index >= 0) {
            return hoteles.get(index);
        }
        throw new BusinessLogicException("El hotel no está asociado al CentroDeEntrenamiento");

    
    
    
    public void validarServicios(Long id, String nombre, Date fecha , Double costo, Double duracion)throws BusinessLogicException{
        Date todayDate = Calendar.getInstance().getTime();
        if(todayDate.before(fecha)) throw new BusinessLogicException ("La fecha ingresada no es valida");
        else if(id<0) throw new BusinessLogicException ("El id es invalido");
        else if(nombre.length()>50) throw new BusinessLogicException ("El nombre es muy grande");
        else if(costo<0) throw new BusinessLogicException ("El costo es invalido");
        else if(duracion <0) throw new BusinessLogicException ("La duracion es invalida");   
    }
    
    
}
