/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.watchdogs.resources;

import co.edu.uniandes.csw.watchdogs.dtos.PaseoDetailDTO;
import co.edu.uniandes.csw.watchdogs.dtos.PaseoDetailDTO;
import co.edu.uniandes.csw.watchdogs.ejb.PaseoLogic;
import co.edu.uniandes.csw.watchdogs.ejb.RutaLogic;
import co.edu.uniandes.csw.watchdogs.entities.PaseoEntity;
import co.edu.uniandes.csw.watchdogs.entities.RutaEntity;
import co.edu.uniandes.csw.watchdogs.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.watchdogs.persistence.PaseoPersistence;
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
@Path("paseos")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
public class PaseoResource {
    
     @Inject
    private PaseoLogic paseoLogic;
     
     @Inject
     private RutaLogic rutaLogic;
     
    
    private static final Logger LOGGER = Logger.getLogger(PaseoPersistence.class.getName());
    
    /**
     * <h1>POST /api/paseos : Crear un Paseo.</h1>
     * 
     * <pre>Cuerpo de petición: JSON {@link PaseoDetailDTO}.
     * 
     * Crea un nuevO Paseo con la informacion que se recibe en el cuerpo 
     * de la petición y se regresa un objeto identico con un id auto-generado 
     * por la base de datos.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Creó el nuevo Paseo .
     * </code>
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 412 Precodition Failed: Ya existe el Paseo.
     * </code>
     * </pre>
     * @param paseo {@link PaseoDetailDTO} - El Paseo que se desea guardar.
     * @return JSON {@link PaseoDetailDTO}  - El Paseo guardado con el atributo id autogenerado.
     * @throws BusinessLogicException {@link BusinessLogicException} - Error de lógica que se genera cuando ya existe el Paseo.
     */
    @POST
    public PaseoDetailDTO createPaseo(PaseoDetailDTO paseo) throws BusinessLogicException {
        PaseoEntity paseoEntity = paseo.toEntity();
        PaseoEntity nuevoPaseo = paseoLogic.createPaseo(paseoEntity);
        return new PaseoDetailDTO(nuevoPaseo);
    }

    /**
     * <h1>GET /api/paseos : Obtener todos los paseos.</h1>
     * 
     * <pre>Busca y devuelve todos los paseos que existen en la aplicacion.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Devuelve todos los paseos de la aplicacion.</code> 
     * </pre>
     * @return JSONArray {@link PaseoDetailDTO} - Los paseos encontrados en la aplicación. Si no hay ninguna retorna una lista vacía.
     */
    @GET
    public List<PaseoDetailDTO> getPaseos() {
        return listEntity2DetailDTO(paseoLogic.getPaseos());
    }

    /**
     * <h1>GET /api/paseos/{id} : Obtener Paseo por id.</h1>
     * 
     * <pre>Busca el Paseo con el id asociado recibido en la URL y la devuelve.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Devuelve el Paseo correspondiente al id.
     * </code> 
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found No existe un Paseo con el id dado.
     * </code> 
     * </pre>
     * @param id Identificador del Paseo que se esta buscando. Este debe ser una cadena de dígitos.
     * @return JSON {@link PaseoDetailDTO} - El Paseo buscada
     */
    @GET
    @Path("{id: \\d+}")
    public PaseoDetailDTO getPaseo(@PathParam("id") Long id)throws WebApplicationException {
        PaseoEntity entity = paseoLogic.getPaseo(id);
        if (entity == null) {
            throw new WebApplicationException("El recurso /paseos/" + id + " no existe.", 404);
        }
        return new PaseoDetailDTO(paseoLogic.getPaseo(id));
    }
    
    /**
     * <h1>PUT /api/paseos/{id} : Actualizar Paseo con el id dado.</h1>
     * <pre>Cuerpo de petición: JSON {@link PaseoDetailDTO}.
     * 
     * Actualiza el Paseo con el id recibido en la URL con la informacion que se recibe en el cuerpo de la petición.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Actualiza el Paseo con el id dado con la información enviada como parámetro. Retorna un objeto identico.</code> 
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found. No existe un Paseo con el id dado.
     * </code> 
     * </pre>
     * @param id Identificador de el Paseo que se desea actualizar.Este debe ser una cadena de dígitos.
     * @param paseo {@link PaseoDetailDTO} el Paseo que se desea guardar.
     * @return JSON {@link PaseoDetailDTO} - el Paseo guardado.
     * @throws BusinessLogicException {@link BusinessLogicException} - Error de lógica que se genera al no poder actualizar el Paseo porque ya existe uno con ese nombre.
     */
    @PUT
    @Path("{id: \\d+}")
    public PaseoDetailDTO updatePaseo(@PathParam("id") Long id, PaseoDetailDTO paseo) throws WebApplicationException, BusinessLogicException {
        PaseoEntity entity = paseo.toEntity();
        paseo.setId(id);
        PaseoEntity oldEntity = paseoLogic.getPaseo(id);
        if (entity == null) {
            throw new WebApplicationException("El recurso /paseos/" + id + " no existe.", 404);
        }
        entity.setDuracion(paseo.getDuracion());
        entity.setCosto((paseo.getDuracion()*20000.0));
        entity.setCliente(oldEntity.getCliente());
        RutaEntity ruta = rutaLogic.getRuta(paseo.getRutas().getId());
        entity.setRuta(ruta);
        entity.setCliente(oldEntity.getCliente());
        return new PaseoDetailDTO(paseoLogic.updatePaseo(id, paseo.toEntity()));
    }
    
    /**
     * <h1>DELETE /api/paseos/{id} : Borrar Paseo por id.</h1>
     * 
     * <pre>Borra el Paseo con el id asociado recibido en la URL.
     * 
     * Códigos de respuesta:<br>
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Elimina el Paseo correspondiente al id dado.</code>
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found. No existe un Paseo con el id dado.
     * </code>
     * </pre>
     * @param id Identificador de el Paseo que se desea borrar. Este debe ser una cadena de dígitos.
     */
    @DELETE
    @Path("{id: \\d+}")
     public void deletePaseo(@PathParam("id") Long id) {
        LOGGER.log(Level.INFO, "Inicia proceso de borrar un Paseo con id {0}", id);
        PaseoEntity entity = paseoLogic.getPaseo(id);
        if (entity == null) {
            throw new WebApplicationException("El recurso /paseos/" + id + " no existe.", 404);
        }
        paseoLogic.deletePaseo(id);
    }
     
     
     /**
     *
     * lista de entidades a DTO.
     *
     * Este método convierte una lista de objetos PaseoEntity a una lista de
     * objetos PaseoDetailDTO (json)
     *
     * @param entityList corresponde a la lista de Paseoes de tipo Entity
     * que vamos a convertir a DTO.
     * @return la lista de Paseoes en forma DTO (json)
     */
    private List<PaseoDetailDTO> listEntity2DetailDTO(List<PaseoEntity> entityList) {
        List<PaseoDetailDTO> list = new ArrayList<>();
        for (PaseoEntity entity : entityList) {
            list.add(new PaseoDetailDTO(entity));
        }
        return list;
    }
}
