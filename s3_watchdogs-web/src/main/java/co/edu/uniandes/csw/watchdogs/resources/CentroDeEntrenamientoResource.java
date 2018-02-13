/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.watchdogs.resources;

import co.edu.uniandes.csw.watchdogs.dtos.CentroDeEntrenamientoDetailDTO;
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
 *
 * @author m.diazt
 */
@Path("centrosDeEntrenamiento")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
public class CentroDeEntrenamientoResource {
    
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
     * @throws BusinessLogicException {@link BusinessLogicExceptionMapper} - Error de lógica que se genera cuando ya existe el CentroDeEntrenamiento.
     */
    @POST
    public CentroDeEntrenamientoDetailDTO createCentroDeEntrenamiento(CentroDeEntrenamientoDetailDTO centroDeEntrenamiento) throws BusinessLogicException {
        return centroDeEntrenamiento;
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
        return new ArrayList<>();
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
    public CentroDeEntrenamientoDetailDTO getCentroDeEntrenamiento(@PathParam("id") Long id) {
        return null;
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
     * @throws BusinessLogicException {@link BusinessLogicExceptionMapper} - Error de lógica que se genera al no poder actualizar el CentroDeEntrenamiento porque ya existe uno con ese nombre.
     */
    @PUT
    @Path("{id: \\d+}")
    public CentroDeEntrenamientoDetailDTO updateCentroDeEntrenamiento(@PathParam("id") Long id, CentroDeEntrenamientoDetailDTO centroDeEntrenamiento) throws BusinessLogicException {
        return centroDeEntrenamiento;
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
        // Void
    }
    
}
