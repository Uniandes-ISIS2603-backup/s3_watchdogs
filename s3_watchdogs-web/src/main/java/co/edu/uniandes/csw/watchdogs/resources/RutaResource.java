/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.watchdogs.resources;

import co.edu.uniandes.csw.watchdogs.dtos.RutaDetailDTO;
import co.edu.uniandes.csw.watchdogs.exceptions.BusinessLogicException;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 * <pre>Clase que implementa el recurso "rutas".
 * URL: /api/rutas
 * </pre>
 * <i>Note que la aplicación (definida en {@link RestConfig}) define la ruta "/api" y
 * este recurso tiene la ruta "rutas".</i>
 *
 * <h2>Anotaciones </h2>
 * <pre>
 * Path: indica la dirección después de "api" para acceder al recurso
 * Produces/Consumes: indica que los servicios definidos en este recurso reciben y devuelven objetos en formato JSON
 * RequestScoped: Inicia una transacción desde el llamado de cada método (servicio). 
 * </pre>
 * @author id.salazar  
 * @version 1.0
 */
@Path("rutas")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
public class RutaResource {
    /**
     * <h1>POST /api/rutas : Crear una ruta.</h1>
     * 
     * <pre>Cuerpo de petición: JSON {@link RutaDetailDTO}.
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
     * @param ruta {@link RutaDetailDTO} - La ruta que se desea guardar.
     * @return JSON {@link RutaDetailDTO}  - La ruta guardada con el atributo id autogenerado.
     * @throws BusinessLogicException {@link BusinessLogicExceptionMapper} - Error de lógica que se genera cuando ya existe la ruta.
     */
    @POST
    public RutaDetailDTO createRuta(RutaDetailDTO ruta) throws BusinessLogicException {
        return ruta;
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
     * @return JSONArray {@link RutaDetailDTO} - Las rutas encontradas en la aplicación. Si no hay ninguna retorna una lista vacía.
     */
    @GET
    public List<RutaDetailDTO> getRutas() {
        return new ArrayList<>();
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
     * @param id Identificador de la ruta que se esta buscando. Este debe ser una cadena de dígitos.
     * @return JSON {@link RutaDetailDTO} - La ruta buscada
     */
    @GET
    @Path("{id: \\d+}")
    public RutaDetailDTO getRuta(@PathParam("id") Long id) {
        return null;
    }
    
    /**
     * <h1>PUT /api/rutas/{id} : Actualizar ruta con el id dado.</h1>
     * <pre>Cuerpo de petición: JSON {@link RutaDetailDTO}.
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
     * @param id Identificador de la ruta que se desea actualizar.Este debe ser una cadena de dígitos.
     * @param ruta {@link RutaDetailDTO} La ruta que se desea guardar.
     * @return JSON {@link RutaDetailDTO} - La ruta guardada.
     */
    @PUT
    @Path("{id: \\d+}")
    public RutaDetailDTO updateRuta(@PathParam("id") Long id, RutaDetailDTO ruta){
        return ruta;
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
     * @param id Identificador de la ruta que se desea borrar. Este debe ser una cadena de dígitos.
     */
    @DELETE
    @Path("{id: \\d+}")
     public void deleteRuta(@PathParam("id") Long id) {
        // Void
    }
}
