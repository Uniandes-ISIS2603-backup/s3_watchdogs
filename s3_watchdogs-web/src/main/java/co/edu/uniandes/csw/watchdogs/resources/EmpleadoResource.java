/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.watchdogs.resources;

import co.edu.uniandes.csw.watchdogs.dtos.EmpleadoDetailDTO;
import co.edu.uniandes.csw.watchdogs.exceptions.BusinessLogicException;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

/**
 *
 * @author ca.beltran10
 */
public class EmpleadoResource {
    
        /**
     * <h1>POST /api/empleados : Crear un empleado.</h1>
     * 
     * <pre>Cuerpo de peticion: JSON{@link EmpleadoDetailDTO}.
     * 
     * Crea un nuevo empleado con la informacion que se recibe en el cuerpo
     * de la peticion y se regresa un objeto identico con un id auto-generado
     * por la base de datos.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Creo el nuevo empleado.
     * </code>
     * </pre>
     * 
     * @param empleado {@link EmpleadoDetailDTO} - El empleado que se desea guardar.
     * @return JSON {@link EmpleadoDetailDTO} - El empleado guardado con el atributo id autogenerado.
     * @throws BusinessLogicException {@link BusinessLogicExceptionMapper} - Error de logica que se genera cuando ya existe la ciudad.
     */
    @POST
    public EmpleadoDetailDTO createEmpleado( EmpleadoDetailDTO empleado ) throws BusinessLogicException {
        return empleado;
    }
    
        /**
     * <h1>GET /api/empleados : Obtener todos los empleados.</h1>
     * 
     * <pre>Busca y devuelve todos los empleados que existen en la aplicacion.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Devuelve todos los empleados de la aplicacion.</code> 
     * </pre>
     * @return JSONArray {@link CityDetailDTO} - Los empleados encontrados en la aplicación. Si no hay ninguno retorna una lista vacía.
     */
    @GET
    public List<EmpleadoDetailDTO> getempleados() {
        return new ArrayList<>();
    }
    
     /**
     * <h1>GET /api/empleados/{id} : Obtener empleado por id.</h1>
     * 
     * <pre>Busca el empleado con el id asociado recibido en la URL y la devuelve.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Devuelve el empleado correspondiente al id.
     * </code> 
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found No existe un empleado con el id dado.
     * </code> 
     * </pre>
     * @param id Identificador del empleado que se esta buscando. Este debe ser una cadena de dígitos.
     * @return JSON {@link EmpleadoDetailDTO} - El empleado buscado
     */
    @GET
    @Path("{id: \\d+}")
    public EmpleadoDetailDTO getEmpleado(@PathParam("id") Long id) {
        return null;
    }
    
     /**
     * <h1>PUT /api/empleados/{id} : Actualizar empleado con el id dado.</h1>
     * <pre>Cuerpo de petición: JSON {@link EmpleadoDetailDTO}.
     * 
     * Actualiza el empleado con el id recibido en la URL con la informacion que se recibe en el cuerpo de la petición.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Actualiza el empleado con el id dado con la información enviada como parámetro. Retorna un objeto identico.</code> 
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found. No existe un empleado con el id dado.
     * </code> 
     * </pre>
     * @param id Identificador del empleado que se desea actualizar. Este debe ser una cadena de dígitos.
     * @param empleado {@link EmpleadoDetailDTO} El empleado que se desea guardar.
     * @return JSON {@link EmpleadoDetailDTO} - El empleado guardado.
     * @throws BusinessLogicException {@link BusinessLogicExceptionMapper} - Error de lógica que se genera al no poder actualizar el empleado porque ya existe una con ese nombre.
     */
    @PUT
    
    @Path("{id: \\d+}")
    public EmpleadoDetailDTO updateEmpleado(@PathParam("id") Long id, EmpleadoDetailDTO empleado) throws BusinessLogicException {
        return empleado;
    }
    
    /**
     * <h1>DELETE /api/cities/{id} : Borrar empleado por id.</h1>
     * 
     * <pre>Borra el empleado con el id asociado recibido en la URL.
     * 
     * Códigos de respuesta:<br>
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Elimina el empleado correspondiente al id dado.</code>
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found. No existe un empleado con el id dado.
     * </code>
     * </pre>
     * @param id Identificador del empleado que se desea borrar. Este debe ser una cadena de dígitos.
     */
    @DELETE
    @Path("{id: \\d+}")
     public void deleteEmpleado(@PathParam("id") Long id) {
        // Void
    }
     
}
