/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.watchdogs.resources;

import co.edu.uniandes.csw.watchdogs.dtos.CentroDeEntrenamientoDetailDTO;
import co.edu.uniandes.csw.watchdogs.ejb.CentroDeEntrenamientoLogic;
import co.edu.uniandes.csw.watchdogs.entities.CentroDeEntrenamientoEntity;
import co.edu.uniandes.csw.watchdogs.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.watchdogs.persistence.CentroDeEntrenamientoPersistence;
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
@Path("centrosDeEntrenamiento")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
public class CentroDeEntrenamientoResource {
    
    @Inject
    private CentroDeEntrenamientoLogic centroDeEntrenamientoLogic;
    
    private static final Logger LOGGER = Logger.getLogger(CentroDeEntrenamientoPersistence.class.getName());

    
    /**
     * <h1>POST /api/centrosDeEntrenamiento : Crear un CentroDeEntrenamiento.</h1>
     * 
     * <pre>Cuerpo de petición: JSON {@link CentroDeEntrenamientoDetailDTO}.
     * 
     * Crea un nuevO CentroDeEntrenamiento con la informacion que se recibe en el cuerpo 
     * de la petición y se regresa un objeto identico con un id auto-generado 
     * por la base de datos.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Creó el nuevo CentroDeEntrenamiento .
     * </code>
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 412 Precodition Failed: Ya existe el CentroDeEntrenamiento.
     * </code>
     * </pre>
     * @param centroDeEntrenamiento {@link CentroDeEntrenamientoDetailDTO} - El CentroDeEntrenamiento que se desea guardar.
     * @return JSON {@link CentroDeEntrenamientoDetailDTO}  - El CentroDeEntrenamiento guardado con el atributo id autogenerado.
     * @throws BusinessLogicException {@link BusinessLogicException} - Error de lógica que se genera cuando ya existe el CentroDeEntrenamiento.
     */
    @POST
    public CentroDeEntrenamientoDetailDTO createCentroDeEntrenamiento(CentroDeEntrenamientoDetailDTO centroDeEntrenamiento) throws BusinessLogicException {
        CentroDeEntrenamientoEntity centroDeEntrenamientoEntity = centroDeEntrenamiento.toEntity();
        CentroDeEntrenamientoEntity nuevoCentroDeEntrenamiento = centroDeEntrenamientoLogic.createCentroDeEntrenamiento(centroDeEntrenamientoEntity);
        return new CentroDeEntrenamientoDetailDTO(nuevoCentroDeEntrenamiento);    
    }

    /**
     * <h1>GET /api/centrosDeEntrenamiento : Obtener todos los centrosDeEntrenamiento.</h1>
     * 
     * <pre>Busca y devuelve todos los centrosDeEntrenamiento que existen en la aplicacion.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Devuelve todos los centrosDeEntrenamiento de la aplicacion.</code> 
     * </pre>
     * @return JSONArray {@link CentroDeEntrenamientoDetailDTO} - Los centrosDeEntrenamiento encontrados en la aplicación. Si no hay ninguna retorna una lista vacía.
     */
    @GET
    public List<CentroDeEntrenamientoDetailDTO> getCentrosDeEntrenamiento() {
        return listEntity2DetailDTO(centroDeEntrenamientoLogic.getCentrosDeEntrenamientos());
    }

    /**
     * <h1>GET /api/centrosDeEntrenamiento/{id} : Obtener CentroDeEntrenamiento por id.</h1>
     * 
     * <pre>Busca el CentroDeEntrenamiento con el id asociado recibido en la URL y la devuelve.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Devuelve el CentroDeEntrenamiento correspondiente al id.
     * </code> 
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found No existe un CentroDeEntrenamiento con el id dado.
     * </code> 
     * </pre>
     * @param id Identificador del CentroDeEntrenamiento que se esta buscando. Este debe ser una cadena de dígitos.
     * @return JSON {@link CentroDeEntrenamientoDetailDTO} - El CentroDeEntrenamiento buscada
     */
    @GET
    @Path("{id: \\d+}")
    public CentroDeEntrenamientoDetailDTO getCentroDeEntrenamiento(@PathParam("id") Long id)throws WebApplicationException {
        CentroDeEntrenamientoEntity entity = centroDeEntrenamientoLogic.getCentroDeEntrenamiento(id);
        if (entity == null) {
            throw new WebApplicationException("El recurso /centrosDeEntrenamiento/" + id + " no existe.", 404);
        }
        return new CentroDeEntrenamientoDetailDTO(centroDeEntrenamientoLogic.getCentroDeEntrenamiento(id));
    }
    
    /**
     * <h1>PUT /api/centrosDeEntrenamiento/{id} : Actualizar CentroDeEntrenamiento con el id dado.</h1>
     * <pre>Cuerpo de petición: JSON {@link CentroDeEntrenamientoDetailDTO}.
     * 
     * Actualiza el CentroDeEntrenamiento con el id recibido en la URL con la informacion que se recibe en el cuerpo de la petición.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Actualiza el CentroDeEntrenamiento con el id dado con la información enviada como parámetro. Retorna un objeto identico.</code> 
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found. No existe un CentroDeEntrenamiento con el id dado.
     * </code> 
     * </pre>
     * @param id Identificador de el CentroDeEntrenamiento que se desea actualizar.Este debe ser una cadena de dígitos.
     * @param centroDeEntrenamiento {@link CentroDeEntrenamientoDetailDTO} el CentroDeEntrenamiento que se desea guardar.
     * @return JSON {@link CentroDeEntrenamientoDetailDTO} - el CentroDeEntrenamiento guardado.
     * @throws BusinessLogicException {@link BusinessLogicException} - Error de lógica que se genera al no poder actualizar el CentroDeEntrenamiento porque ya existe uno con ese nombre.
     */
    @PUT
    @Path("{id: \\d+}")
    public CentroDeEntrenamientoDetailDTO updateCentroDeEntrenamiento(@PathParam("id") Long id, CentroDeEntrenamientoDetailDTO centroDeEntrenamiento) throws WebApplicationException, BusinessLogicException {
        centroDeEntrenamiento.setId(id);
        CentroDeEntrenamientoEntity entity = centroDeEntrenamientoLogic.getCentroDeEntrenamiento(id);
        if (entity == null) {
            throw new WebApplicationException("El recurso /centrosDeEntrenamiento/" + id + " no existe.", 404);
        }
        return new CentroDeEntrenamientoDetailDTO(centroDeEntrenamientoLogic.updateCentroDeEntrenamiento(id, centroDeEntrenamiento.toEntity()));
    }
    
    /**
     * <h1>DELETE /api/centrosDeEntrenamiento/{id} : Borrar CentroDeEntrenamiento por id.</h1>
     * 
     * <pre>Borra el CentroDeEntrenamiento con el id asociado recibido en la URL.
     * 
     * Códigos de respuesta:<br>
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Elimina el CentroDeEntrenamiento correspondiente al id dado.</code>
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found. No existe un CentroDeEntrenamiento con el id dado.
     * </code>
     * </pre>
     * @param id Identificador de el CentroDeEntrenamiento que se desea borrar. Este debe ser una cadena de dígitos.
     */
    @DELETE
    @Path("{id: \\d+}")
     public void deleteCentroDeEntrenamiento(@PathParam("id") Long id) {
        LOGGER.log(Level.INFO, "Inicia proceso de borrar un CentroDeEntrenamiento con id {0}", id);
        CentroDeEntrenamientoEntity entity = centroDeEntrenamientoLogic.getCentroDeEntrenamiento(id);
        if (entity == null) {
            throw new WebApplicationException("El recurso /centrosDeEntrenamiento/" + id + " no existe.", 404);
        }
        centroDeEntrenamientoLogic.deleteCentroDeEntrenamiento(id);
    }
     
     /**
     * Conexión con el servicio de entrenamientos para un CentroDeEntrenamiento. {@link ReviewResource}
     * 
     * Este método conecta la ruta de /centrosDeEntrenamiento con las rutas de /entrenamientos que dependen
     * del CentroDeEntrenamiento, es una redirección al servicio que maneja el segmento de la 
     * URL que se encarga de los libros.
     * 
     * @param centrosDeEntrenamientoId El ID del CentroDeEntrenamiento con respecto al cual se accede al servicio.
     * @return El servicio de entrenamientos para esa CentroDeEntrenamiento en paricular.
     */
    @Path("{centrosDeEntrenamientoId: \\d+}/entrenamientos")
    public Class<CentroDeEntrenamientoEntrenamientosResource> getCentroDeEntrenamientoEntrenamientosResource(@PathParam("centrosDeEntrenamientoId") Long centrosDeEntrenamientoId) {
        CentroDeEntrenamientoEntity entity = centroDeEntrenamientoLogic.getCentroDeEntrenamiento(centrosDeEntrenamientoId);
        if (entity == null) {
            throw new WebApplicationException("El recurso /centrosDeEntrenamiento/" + centrosDeEntrenamientoId + " no existe.", 404);
        }
        return CentroDeEntrenamientoEntrenamientosResource.class;
    }
    
    /**
     * Conexión con el servicio de hoteles para un CentroDeEntrenamiento. {@link ReviewResource}
     * 
     * Este método conecta la ruta de /centrosDeEntrenamiento con las rutas de /hoteles que dependen
     * del CentroDeEntrenamiento, es una redirección al servicio que maneja el segmento de la 
     * URL que se encarga de los libros.
     * 
     * @param centrosDeEntrenamientoId El ID del CentroDeEntrenamiento con respecto al cual se accede al servicio.
     * @return El servicio de entrenamientos para esa CentroDeEntrenamiento en paricular.
     */
    @Path("{centrosDeEntrenamientoId: \\d+}/hoteles")
    public Class<CentroDeEntrenamientoHotelesResource> getCentroDeEntrenamientoHotelesResource(@PathParam("centrosDeEntrenamientoId") Long centrosDeEntrenamientoId) {
        CentroDeEntrenamientoEntity entity = centroDeEntrenamientoLogic.getCentroDeEntrenamiento(centrosDeEntrenamientoId);
        if (entity == null) {
            throw new WebApplicationException("El recurso /centrosDeEntrenamiento/" + centrosDeEntrenamientoId + " no existe.", 404);
        }
        return CentroDeEntrenamientoHotelesResource.class;
    }
     
     /**
     *
     * lista de entidades a DTO.
     *
     * Este método convierte una lista de objetos CentroDeEntrenamientoEntity a una lista de
     * objetos CentroDeEntrenamientoDetailDTO (json)
     *
     * @param entityList corresponde a la lista de CentroDeEntrenamientoes de tipo Entity
     * que vamos a convertir a DTO.
     * @return la lista de CentroDeEntrenamientoes en forma DTO (json)
     */
    private List<CentroDeEntrenamientoDetailDTO> listEntity2DetailDTO(List<CentroDeEntrenamientoEntity> entityList) {
        List<CentroDeEntrenamientoDetailDTO> list = new ArrayList<>();
        for (CentroDeEntrenamientoEntity entity : entityList) {
            list.add(new CentroDeEntrenamientoDetailDTO(entity));
        }
        return list;
    }
    
}
