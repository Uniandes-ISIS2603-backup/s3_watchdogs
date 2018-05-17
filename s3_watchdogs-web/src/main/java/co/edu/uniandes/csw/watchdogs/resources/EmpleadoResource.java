/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.watchdogs.resources;

import co.edu.uniandes.csw.watchdogs.dtos.EmpleadoDetailDTO;
import co.edu.uniandes.csw.watchdogs.dtos.ServicioDetailDTO;
import co.edu.uniandes.csw.watchdogs.ejb.EmpleadoLogic;
import co.edu.uniandes.csw.watchdogs.entities.EmpleadoEntity;
import co.edu.uniandes.csw.watchdogs.entities.ServicioEntity;
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
import javax.ws.rs.core.MediaType;

/**
 * <pre>Clase que implementa el recurso "empleados".
 * URL: /api/empleados
 * </pre>
 * <i>Note que la aplicación (definida en {@link RestConfig}) define la ruta
 * "/api" y este recurso tiene la ruta "empleados".</i>
 *
 * <h2>Anotaciones </h2>
 * <pre>
 * Path: indica la dirección después de "api" para acceder al recurso
 * Produces/Consumes: indica que los servicios definidos en este recurso reciben y devuelven objetos en formato JSON
 * RequestScoped: Inicia una transacción desde el llamado de cada método (servicio).
 * </pre>
 *
 * @author ca.beltran10
 * @version 1.0
 */
@Path("/empleados")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@RequestScoped
public class EmpleadoResource {

    @Inject
    private EmpleadoLogic empleadoLogic;

    /**
     * Convierte una lista de EmpleadoEntity a una lista de EmpleadoDetailDTO
     *
     * @param entityList Lista de EmpleadoEntity a convertir.
     * @return Lista de EmpleadoDetailDTO convertida.
     */
    private List<EmpleadoDetailDTO> listEntity2DTO(List<EmpleadoEntity> entityList) {
        List<EmpleadoDetailDTO> list = new ArrayList<>();
        for (EmpleadoEntity entity : entityList) {
            list.add(new EmpleadoDetailDTO(entity));
        }
        return list;
    }

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
     * @param empleado {@link EmpleadoDetailDTO} - El empleado que se desea
     * guardar.
     * @return JSON {@link EmpleadoDetailDTO} - El empleado guardado con el
     * atributo id autogenerado.
     */
    @POST
    public EmpleadoDetailDTO createEmpleado(EmpleadoDetailDTO empleado) {
        try {
            return new EmpleadoDetailDTO(empleadoLogic.createEmpleado(empleado.toEntity()));
        } catch (BusinessLogicException e) {
            throw new WebApplicationException(e.getMessage(), 404);
        }
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
     *
     * @return JSONArray {@link CityDetailDTO} - Los empleados encontrados en la
     * aplicación. Si no hay ninguno retorna una lista vacía.
     */
    @GET
    public List<EmpleadoDetailDTO> getEmpleados() {
        return listEntity2DTO(empleadoLogic.getEmpleados());
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
     *
     * @param id Identificador del empleado que se esta buscando. Este debe ser
     * una cadena de dígitos.
     * @return JSON {@link EmpleadoDetailDTO} - El empleado buscado
     */
    @GET
    @Path("{id: \\d+}")
    public EmpleadoDetailDTO getEmpleado(@PathParam("id") Long id) {
        EmpleadoEntity entity = empleadoLogic.getEmpleado(id);
        if (entity == null) {
            throw new WebApplicationException("El empleado no existe", 404);
        }
        return new EmpleadoDetailDTO(entity);
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
     *
     * @param id Identificador del empleado que se desea actualizar. Este debe
     * ser una cadena de dígitos.
     * @param empleado {@link EmpleadoDetailDTO} El empleado que se desea
     * guardar.
     * @return JSON {@link EmpleadoDetailDTO} - El empleado guardado.
     */
    @PUT
    @Path("{id: \\d+}")
    public EmpleadoDetailDTO updateEmpleado(@PathParam("id") Long id, EmpleadoDetailDTO empleado) throws BusinessLogicException {
        EmpleadoEntity entity = empleado.toEntity();
        entity.setId(id);
        EmpleadoEntity oldEntity = empleadoLogic.getEmpleado(id);
        if (oldEntity == null) {
            throw new WebApplicationException("El empleado no existe", 404);
        }
        entity.setDisponibilidad(oldEntity.getDisponibilidad());
        entity.setCalificacion(oldEntity.getCalificacion());
        entity.setServicios(oldEntity.getServicios());
        return new EmpleadoDetailDTO(empleadoLogic.updateEmpleado(id, entity));
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
     *
     * @param id Identificador del empleado que se desea borrar. Este debe ser
     * una cadena de dígitos.
     */
    @DELETE
    @Path("{id: \\d+}")
    public void deleteEmpleado(@PathParam("id") Long id) {
        try {
            empleadoLogic.deleteEmpleado(id);
        } catch (BusinessLogicException e) {
            throw new WebApplicationException(e.getMessage(), 404);
        }
    }
    
    private List<ServicioDetailDTO> servicioListEntity2DTO(List<ServicioEntity> entityList) {
        List<ServicioDetailDTO> list = new ArrayList<>();
        for(ServicioEntity entity : entityList){
            list.add(new ServicioDetailDTO(entity){});
        }
        return list;
    }

    /**
     * Obtiene una colección de instancias de servicioDetailDTO asociadas a una
     * instancia de cliente
     *
     * @param empleadoId
     * @return Colección de instancias de servicioDetailDTO asociadas a la
     * instancia de cliente
     *
     */
    @GET
    @Path("{empleadoId:\\d+}/servicios")
    public List<ServicioDetailDTO> listServicios(@PathParam("empleadoId") Long empleadoId) {
        return servicioListEntity2DTO(empleadoLogic.getServicios(empleadoId));
    }
    
    @GET
    @Path("{cargoId:\\d+}/cargo")
    public List<EmpleadoDetailDTO> empleadosCargo(@PathParam("cargoId") Long  cargo){
        String string;
        if(cargo == 1){
            string = "Entrenador";
        }
        else if(cargo == 2){
            string = "Cuidador";
        }
        else if(cargo == 3){
            string = "Aseador";
        }
        else if(cargo == 4){
            string = "Paseador";
        }
        else string = "";
        return listEntity2DTO(empleadoLogic.findbyCargo(string));
    }
    

}
