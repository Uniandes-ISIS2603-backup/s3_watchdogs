/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.watchdogs.ejb;

import co.edu.uniandes.csw.watchdogs.entities.HotelEntity;
import co.edu.uniandes.csw.watchdogs.entities.TransporteEntity;
import co.edu.uniandes.csw.watchdogs.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.watchdogs.persistence.HotelPersistence;
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
    private TransporteLogic transporteLogic;

    /**
     * Devuelve todos los Hotel que hay en la base de datos.
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
     * @param entity La entidad de tipo Hotel del nuevo transporte a persistir.
     * @return La entidad luego de persistirla
     * @throws BusinessLogicException 
     */
    public HotelEntity createHotel(HotelEntity entity) throws BusinessLogicException {
        LOGGER.info("Inicia proceso de creación de Hotel");
        
        persistence.create(entity);
        LOGGER.info("Termina proceso de creación de Hotel");
        return entity;
    }
    
    /**
     * Actualizar un Hotel por ID
     * @param id El ID del Hotel a actualizar
     * @param entity La entidad del Hotel con los cambios deseados
     * @return La entidad del Hotel luego de actualizarla
     * @throws BusinessLogicException 
     */
    public HotelEntity updateHotel(Long id, HotelEntity entity) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "Inicia proceso de actualizar Hotel con id={0}", id);
        
        HotelEntity newEntity = persistence.update(entity);
        LOGGER.log(Level.INFO, "Termina proceso de actualizar Hotel con id={0}", entity.getId());
        return newEntity;
    }
    
    /**
     * Eliminar un paseo por ID
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
     * @param transporteId El id transporte a guardar
     * @param hotelId El id del Hotel en la cual se va a guardar el
     * transporte.
     * @return El transporte que fue agregado al Hotel.
     */
    public TransporteEntity addTransporte(Long transporteId, Long hotelId) {
        HotelEntity hotelEntity = getHotel(hotelId);
        TransporteEntity transporteEntity = transporteLogic.getTransporte(transporteId);
        hotelEntity.setTransporte(transporteEntity);
        return transporteEntity;
    }

    /**
     * Borrar un Transporte de un Hotel
     *
     * @param hotelId La Hotel del cual se desea eliminar.
     */
    public void removeTransporte( Long hotelId) {
        HotelEntity hotelEntity = getHotel(hotelId);
        hotelEntity.setTransporte(null);
    }

    /**
     * Remplazar Transportes de un Hotel
     *
     * @param transporte Lista de transportes que serán los del Hotel.
     * @param hotelId El id del Hotel que se quiere actualizar.
     * @return La lista de transportes actualizada.
     */
    public TransporteEntity replaceTransportes(Long hotelId, TransporteEntity transporte) {
        HotelEntity hotel = getHotel(hotelId);
        hotel.setTransporte(transporte);
        return transporte;
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
}
