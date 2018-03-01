/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.watchdogs.resources;

import co.edu.uniandes.csw.watchdogs.dtos.VeterinariaDetailDTO;
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
 * <pre>Clase que implementa el recurso "veterinarias".
 * URL: /api/veterinarias
 * </pre>
 * <i>Note que la aplicación (definida en {@link RestConfig}) define la ruta "/api" y
 * este recurso tiene la ruta "veterinarias".</i>
 *
 * <h2>Anotaciones </h2>
 * <pre>
 * Path: indica la dirección después de "api" para acceder al recurso
 * Produces/Consumes: indica que los servicios definidos en este recurso reciben y devuelven objetos en formato JSON
 * RequestScoped: Inicia una transacción desde el llamado de cada método (servicio). 
 * </pre>
 * @author js.vacat
 * @version 1.0
 */
@Path("veterinarias")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
public class VeterinariaResource {
    
    
        /**
     * <h1>POST /api/veterinarias : Crear una veterinaria.</h1>
     * 
     * <pre>Cuerpo de peticion: JSON{@link VeterinariaDetailDTO}.
     * 
     * Crea una nueva veterinaria con la informacion que se recibe en el cuerpo
     * de la peticion y se regresa un objeto identico con un id auto-generado
     * por la base de datos.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Creo la nueva veterinaria.
     * </code>
     * </pre>
     * 
     * @param veterinaria {@link VeterinariaDetailDTO} - La veterinaria que se desea guardar.
     * @return JSON {@link veterinariaDetailDTO} - La veterinaria guardada con el atributo id autogenerado.
     * @throws BusinessLogicException Error de logica que se genera cuando ya existe la  veterinaria.
     */
    @POST
    public VeterinariaDetailDTO createVeterinaria(VeterinariaDetailDTO veterinaria ) throws BusinessLogicException {
        return veterinaria;
    }
    
        /**
     * <h1>GET /api/veterinarias : Obtener todos las veterinarias.</h1>
     * 
     * <pre>Busca y devuelve todas las veterinarias que existen en la aplicacion.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Devuelve todos las veterinarias de la aplicacion.</code> 
     * </pre>
     * @return JSONArray {@link VeterinariaDetailDTO} - Las veterinarias encontrados en la aplicación. Si no hay ninguna retorna una lista vacía.
     */
    @GET
    public List<VeterinariaDetailDTO> getVeterinarias() {
        return new ArrayList<>();
    }
    
     /**
     * <h1>GET /api/veterinarias/{id} : Obtener veterinaria por id.</h1>
     * 
     * <pre>Busca la veterinaria con el id asociado recibido en la URL y la devuelve.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Devuelve la veterinaria correspondiente al id.
     * </code> 
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found No existe una veterinaria con el id dado.
     * </code> 
     * </pre>
     * @param id Identificador de la veterinaria que se esta buscando. Este debe ser una cadena de dígitos.
     * @return JSON {@link VeterinariaDetailDTO} - La veterinaria buscada
     */
    @GET
    @Path("{id: \\d+}")
    public VeterinariaDetailDTO getMascota(@PathParam("id") Long id) {
        return null;
    }
    
     /**
     * <h1>PUT /api/veterinarias/{id} : Actualizar veterinaria con el id dado.</h1>
     * <pre>Cuerpo de petición: JSON {@link VeterinariaDetailDTO}.
     * 
     * Actualiza la veterinaria con el id recibido en la URL con la informacion que se recibe en el cuerpo de la petición.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Actualiza la veterinaria con el id dado con la información enviada como parámetro. Retorna un objeto identico.</code> 
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found. No existe una veterinaria con el id dado.
     * </code> 
     * </pre>
     * @param id Identificador de la veterinaria que se desea actualizar. Este debe ser una cadena de dígitos.
     * @param veterinaria {@link VeterinariaDetailDTO} La veterinaria que se desea guardar.
     * @return JSON {@link VeterinariaDetailDTO} - La veterinaria guardada.
     * @throws BusinessLogicException {@link BusinessLogicExceptionMapper} - Error de lógica que se genera al no poder actualizar la veterinaria porque ya existe una con ese nombre.
     */
    @PUT
    @Path("{id: \\d+}")
    public VeterinariaDetailDTO updateVeterinaria(@PathParam("id") Long id, VeterinariaDetailDTO veterinaria) throws BusinessLogicException {
        return veterinaria;
    }
    
    /**
     * <h1>DELETE /api/veterinarias/{id} : Borrar veterinaria por id.</h1>
     * 
     * <pre>Borra la veterinaria con el id asociado recibido en la URL.
     * 
     * Códigos de respuesta:<br>
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Elimina la veterinaria correspondiente al id dado.</code>
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found. No existe una veterinaria con el id dado.
     * </code>
     * </pre>
     * @param id Identificador de la veterinaria que se desea borrar. Este debe ser una cadena de dígitos.
     */
    @DELETE
    @Path("{id: \\d+}")
     public void deleteVeterinaria(@PathParam("id") Long id) {
        // Void
    }
     
}
