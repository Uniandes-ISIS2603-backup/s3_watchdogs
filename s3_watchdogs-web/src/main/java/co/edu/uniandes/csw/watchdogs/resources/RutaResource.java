/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.watchdogs.resources;

import co.edu.uniandes.csw.watchdogs.dtos.RutaDTO;
import co.edu.uniandes.csw.watchdogs.ejb.RutaLogic;
import co.edu.uniandes.csw.watchdogs.entities.RutaEntity;
import co.edu.uniandes.csw.watchdogs.exceptions.BusinessLogicException;
import java.util.ArrayList;
import java.util.List;
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
 * <pre>Clase que implementa el recurso "rutas".
 * URL: /api/rutas
 * </pre>
 * <i>Note que la aplicación (definida en {@link RestConfig}) define la ruta
 * "/api" y este recurso tiene la ruta "rutas".</i>
 *
 * <h2>Anotaciones </h2>
 * <pre>
 * Path: indica la dirección después de "api" para acceder al recurso
 * Produces/Consumes: indica que los servicios definidos en este recurso reciben y devuelven objetos en formato JSON
 * RequestScoped: Inicia una transacción desde el llamado de cada método (servicio).
 * </pre>
 *
 * @author id.salazar
 * @version 1.0
 */
@Path("rutas")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
public class RutaResource {

    @Inject
    private RutaLogic rutaLogic;

    /**
     * <h1>POST /api/rutas : Crear una ruta.</h1>
     *
     * <pre>Cuerpo de petición: JSON {@link RutaDTO}.
     *
     * Crea una nueva Ruta con la informacion que se recibe en el cuerpo
     * de la petición y se regresa un objeto identico con un id auto-generado
     * por la base de datos.
     *
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Creó la nueva ruta .
     * </code>
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 412 Precodition Failed: Ya existe la ruta.
     * </code>
     * </pre>
     *
     * @param ruta {@link RutaDTO} - La ruta que se desea guardar.
     * @return JSON {@link RutaDTO} - La ruta guardada con el atributo id
     * autogenerado.
     * @throws BusinessLogicException {@link BusinessLogicExceptionMapper} -
     * Error de lógica que se genera cuando ya existe la ruta.
     */
    @POST
    public RutaDTO createRuta(RutaDTO ruta) throws BusinessLogicException {
        return new RutaDTO(rutaLogic.createRuta(ruta.toEntity()));
    }

    /**
     * <h1>GET /api/rutas : Obtener todas las rutas.</h1>
     *
     * <pre>Busca y devuelve todas las rutas que existen en la aplicacion.
     *
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Devuelve todas las rutas de la aplicacion.</code>
     * </pre>
     *
     * @return JSONArray {@link RutaDTO} - Las rutas encontradas en la
     * aplicación. Si no hay ninguna retorna una lista vacía.
     */
    @GET
    public List<RutaDTO> getRutas() {

        List<RutaEntity> list = rutaLogic.getRutas();
        List<RutaDTO> dtoList = new ArrayList<>();
        for (RutaEntity entity : list) {
            dtoList.add(new RutaDTO(entity));
        }
        return dtoList;
    }

    /**
     * <h1>GET /api/rutas/{id} : Obtener ruta por id.</h1>
     *
     * <pre>Busca la ruta con el id asociado recibido en la URL y la devuelve.
     *
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Devuelve la ruta correspondiente al id.
     * </code>
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found No existe una ruta con el id dado.
     * </code>
     * </pre>
     *
     * @param id Identificador de la ruta que se esta buscando. Este debe ser
     * una cadena de dígitos.
     * @return JSON {@link RutaDTO} - La ruta buscada
     */
    @GET
    @Path("{id: \\d+}")
    public RutaDTO getRuta(@PathParam("id") Long id) {
        RutaEntity entity = rutaLogic.getRuta(id);
        if (entity == null) {
            throw new WebApplicationException("El recurso  /rutas/" + id + " no existe.", 404);
        }
        return new RutaDTO(entity);
    }

    /**
     * <h1>PUT /api/rutas/{id} : Actualizar ruta con el id dado.</h1>
     * <pre>Cuerpo de petición: JSON {@link RutaDTO}.
     *
     * Actualiza la ruta con el id recibido en la URL con la informacion que se recibe en el cuerpo de la petición.
     *
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Actualiza la ruta con el id dado con la información enviada como parámetro. Retorna un objeto identico.</code>
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found. No existe una ruta con el id dado.
     * </code>
     * </pre>
     *
     * @param id Identificador de la ruta que se desea actualizar.Este debe ser
     * una cadena de dígitos.
     * @param ruta {@link RutaDTO} La ruta que se desea guardar.
     * @return JSON {@link RutaDTO} - La ruta guardada.
     * @throws BusinessLogicException {@link BusinessLogicExceptionMapper} -
     * Error de lógica que se genera cuando la ruta no cumple las
     * especificaciones.
     */
    @PUT
    @Path("{id: \\d+}")
    public RutaDTO updateRuta(@PathParam("id") Long id, RutaDTO ruta) throws BusinessLogicException {
        ruta.setId(id);
        RutaEntity entity = rutaLogic.getRuta(id);
        if (entity == null) {
            throw new WebApplicationException("El recurso /rutas/" + id + " no  existe.", 404);
        }
        return new RutaDTO(rutaLogic.updateRuta(id, ruta.toEntity()));
    }

    /**
     * <h1>DELETE /api/rutas/{id} : Borrar ruta por id.</h1>
     *
     * <pre>Borra la ruta con el id asociado recibido en la URL.
     *
     * Códigos de respuesta:<br>
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Elimina la ruta correspondiente al id dado.</code>
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found. No existe una ruta con el id dado.
     * </code>
     * </pre>
     *
     * @param id Identificador de la ruta que se desea borrar. Este debe ser una
     * cadena de dígitos.
     */
    @DELETE
    @Path("{id: \\d+}")
    public void deleteRuta(@PathParam("id") Long id) {
        RutaEntity entity = rutaLogic.getRuta(id);
        if (entity == null) {
            throw new WebApplicationException("El recurso /rutas/" + id + " no existe.", 404);
        }
        rutaLogic.deleteRuta(id);
    }
}
