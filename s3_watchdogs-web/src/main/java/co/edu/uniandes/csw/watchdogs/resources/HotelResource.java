/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.watchdogs.resources;

import co.edu.uniandes.csw.watchdogs.dtos.HotelDetailDTO;
import co.edu.uniandes.csw.watchdogs.ejb.HotelLogic;
import co.edu.uniandes.csw.watchdogs.entities.HotelEntity;
import co.edu.uniandes.csw.watchdogs.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.watchdogs.persistence.HotelPersistence;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;

/**
 *
 * @author m.diazt
 */
@Path("hoteles")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
public class HotelResource {
    
    
     @Inject
    private HotelLogic hotelLogic;
    
    private static final Logger LOGGER = Logger.getLogger(HotelPersistence.class.getName());
    
    /**
     * <h1>POST /api/hoteles : Crear un hotel.</h1>
     * 
     * <pre>Cuerpo de petición: JSON {@link HotelDetailDTO}.
     * 
     * Crea un nuevO HOTEL con la informacion que se recibe en el cuerpo 
     * de la petición y se regresa un objeto identico con un id auto-generado 
     * por la base de datos.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Creó el nuevo hotel .
     * </code>
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 412 Precodition Failed: Ya existe el hotel.
     * </code>
     * </pre>
     * @param hotel {@link HotelDetailDTO} - El hotel que se desea guardar.
     * @return JSON {@link HotelDetailDTO}  - El hotel guardado con el atributo id autogenerado.
     * @throws BusinessLogicException {@link BusinessLogicException} - Error de lógica que se genera cuando ya existe el hotel.
     */
    @POST
    public HotelDetailDTO createHotel(HotelDetailDTO hotel) throws BusinessLogicException {
        HotelEntity hotelEntity = hotel.toEntity();
        HotelEntity nuevoHotel = hotelLogic.createHotel(hotelEntity);
        return new HotelDetailDTO(nuevoHotel);
    }

    /**
     * <h1>GET /api/hoteles : Obtener todos los hoteles.</h1>
     * 
     * <pre>Busca y devuelve todos los hoteles que existen en la aplicacion.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Devuelve todos los hoteles de la aplicacion.</code> 
     * </pre>
     * @return JSONArray {@link HotelDetailDTO} - Los hoteles encontrados en la aplicación. Si no hay ninguna retorna una lista vacía.
     */
    @GET
    public List<HotelDetailDTO> getHoteles() {
       return listEntity2DetailDTO(hotelLogic.getHoteles());
    }

    /**
     * <h1>GET /api/hoteles/{id} : Obtener hotel por id.</h1>
     * 
     * <pre>Busca el hotel con el id asociado recibido en la URL y la devuelve.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Devuelve el hotel correspondiente al id.
     * </code> 
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found No existe un hotel con el id dado.
     * </code> 
     * </pre>
     * @param id Identificador del hotel que se esta buscando. Este debe ser una cadena de dígitos.
     * @return JSON {@link HotelDetailDTO} - El hotel buscada
     */
    @GET
    @Path("{id: \\d+}")
    public HotelDetailDTO getHotel(@PathParam("id") Long id) throws WebApplicationException{
        HotelEntity entity = hotelLogic.getHotel(id);
        if (entity == null) {
            throw new WebApplicationException("El recurso /hoteles/" + id + " no existe.", 404);
        }
        return new HotelDetailDTO(hotelLogic.getHotel(id));
    }
    
    /**
     * <h1>PUT /api/hoteles/{id} : Actualizar hotel con el id dado.</h1>
     * <pre>Cuerpo de petición: JSON {@link HotelDetailDTO}.
     * 
     * Actualiza el hotel con el id recibido en la URL con la informacion que se recibe en el cuerpo de la petición.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Actualiza el hotel con el id dado con la información enviada como parámetro. Retorna un objeto identico.</code> 
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found. No existe un hotel con el id dado.
     * </code> 
     * </pre>
     * @param id Identificador de el hotel que se desea actualizar.Este debe ser una cadena de dígitos.
     * @param hotel {@link HotelDetailDTO} el hotel que se desea guardar.
     * @return JSON {@link HotelDetailDTO} - el hotel guardado.
     * @throws BusinessLogicException {@link BusinessLogicException} - Error de lógica que se genera al no poder actualizar el hotel porque ya existe uno con ese nombre.
     */
    @PUT
    @Path("{id: \\d+}")
    public HotelDetailDTO updateHotel(@PathParam("id") Long id, HotelDetailDTO hotel) throws WebApplicationException, BusinessLogicException {
        hotel.setId(id);
        HotelEntity entity = hotelLogic.getHotel(id);
        if (entity == null) {
            throw new WebApplicationException("El recurso /hoteles/" + id + " no existe.", 404);
        }
        return new HotelDetailDTO(hotelLogic.updateHotel(id, hotel.toEntity()));
    }
    
    /**
     * <h1>DELETE /api/hoteles/{id} : Borrar hotel por id.</h1>
     * 
     * <pre>Borra el hotel con el id asociado recibido en la URL.
     * 
     * Códigos de respuesta:<br>
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Elimina el hotel correspondiente al id dado.</code>
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found. No existe un hotel con el id dado.
     * </code>
     * </pre>
     * @param id Identificador de el hotel que se desea borrar. Este debe ser una cadena de dígitos.
     */
    @DELETE
    @Path("{id: \\d+}")
     public void deleteHotel(@PathParam("id") Long id) {
        LOGGER.log(Level.INFO, "Inicia proceso de borrar un Hotel con id {0}", id);
        HotelEntity entity = hotelLogic.getHotel(id);
        if (entity == null) {
            throw new WebApplicationException("El recurso /hoteles/" + id + " no existe.", 404);
        }
        hotelLogic.deleteHotel(id);
    }
     
      /**
     *
     * lista de entidades a DTO.
     *
     * Este método convierte una lista de objetos HotelEntity a una lista de
     * objetos HotelDetailDTO (json)
     *
     * @param entityList corresponde a la lista de hoteles de tipo Entity
     * que vamos a convertir a DTO.
     * @return la lista de hoteles en forma DTO (json)
     */
    private List<HotelDetailDTO> listEntity2DetailDTO(List<HotelEntity> entityList) {
        List<HotelDetailDTO> list = new ArrayList<>();
        for (HotelEntity entity : entityList) {
            list.add(new HotelDetailDTO(entity));
        }
        return list;
    }
}
