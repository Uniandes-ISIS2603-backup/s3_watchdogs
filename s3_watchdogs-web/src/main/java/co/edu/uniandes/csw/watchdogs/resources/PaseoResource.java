/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.watchdogs.resources;

import co.edu.uniandes.csw.watchdogs.dtos.PaseoDetailDTO;
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
@Path("paseos")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
public class PaseoResource {
    
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
     * @throws BusinessLogicException {@link BusinessLogicExceptionMapper} - Error de lógica que se genera cuando ya existe el Paseo.
     */
    @POST
    public PaseoDetailDTO createPaseo(PaseoDetailDTO paseo) throws BusinessLogicException {
        return paseo;
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
        return new ArrayList<>();
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
    public PaseoDetailDTO getPaseo(@PathParam("id") Long id) {
        return null;
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
     * @throws BusinessLogicException {@link BusinessLogicExceptionMapper} - Error de lógica que se genera al no poder actualizar el Paseo porque ya existe uno con ese nombre.
     */
    @PUT
    @Path("{id: \\d+}")
    public PaseoDetailDTO updatePaseo(@PathParam("id") Long id, PaseoDetailDTO paseo) throws BusinessLogicException {
        return paseo;
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
        // Void
    }
}
