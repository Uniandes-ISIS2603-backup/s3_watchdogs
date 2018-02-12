/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.watchdogs.resources;

import co.edu.uniandes.csw.watchdogs.dtos.MascotaDetailDTO;
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
public class MascotaResource {
    
    
        /**
     * <h1>POST /api/mascotas : Crear una mascota.</h1>
     * 
     * <pre>Cuerpo de peticion: JSON{@link MasctoaDetailDTO}.
     * 
     * Crea una nueva mascota con la informacion que se recibe en el cuerpo
     * de la peticion y se regresa un objeto identico con un id auto-generado
     * por la base de datos.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Creo la nueva mascota.
     * </code>
     * </pre>
     * 
     * @param mascota {@link MascotaDetailDTO} - La mascota que se desea guardar.
     * @return JSON {@link MascotaDetailDTO} - La mascota guardada con el atributo id autogenerado.
     * @throws BusinessLogicException {@link BusinessLogicExceptionMapper} - Error de logica que se genera cuando ya existe la ciudad.
     */
    @POST
    public MascotaDetailDTO createMascota( MascotaDetailDTO mascota ) throws BusinessLogicException {
        return mascota;
    }
    
        /**
     * <h1>GET /api/mascotas : Obtener todos las mascotas.</h1>
     * 
     * <pre>Busca y devuelve todas las mascotas que existen en la aplicacion.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Devuelve todos las mascotas de la aplicacion.</code> 
     * </pre>
     * @return JSONArray {@link CityDetailDTO} - Los mascotas encontrados en la aplicación. Si no hay ninguno retorna una lista vacía.
     */
    @GET
    public List<MascotaDetailDTO> getMascotas() {
        return new ArrayList<>();
    }
    
     /**
     * <h1>GET /api/mascotas/{id} : Obtener mascota por id.</h1>
     * 
     * <pre>Busca la mascota con el id asociado recibido en la URL y la devuelve.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Devuelve la mascota correspondiente al id.
     * </code> 
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found No existe una mascota con el id dado.
     * </code> 
     * </pre>
     * @param id Identificador de la mascota que se esta buscando. Este debe ser una cadena de dígitos.
     * @return JSON {@link MascotaDetailDTO} - La mascota buscada
     */
    @GET
    @Path("{id: \\d+}")
    public MascotaDetailDTO getMascota(@PathParam("id") Long id) {
        return null;
    }
    
     /**
     * <h1>PUT /api/mascotas/{id} : Actualizar mascota con el id dado.</h1>
     * <pre>Cuerpo de petición: JSON {@link MascotaDetailDTO}.
     * 
     * Actualiza la mascota con el id recibido en la URL con la informacion que se recibe en el cuerpo de la petición.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Actualiza la mascota con el id dado con la información enviada como parámetro. Retorna un objeto identico.</code> 
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found. No existe una mascota con el id dado.
     * </code> 
     * </pre>
     * @param id Identificador de la mascota que se desea actualizar. Este debe ser una cadena de dígitos.
     * @param mascota {@link MascotaDetailDTO} La mascota que se desea guardar.
     * @return JSON {@link MascotaDetailDTO} - La mascota guardado.
     * @throws BusinessLogicException {@link BusinessLogicExceptionMapper} - Error de lógica que se genera al no poder actualizar la mascota porque ya existe una con ese nombre.
     */
    @PUT
    @Path("{id: \\d+}")
    public MascotaDetailDTO updateMascota(@PathParam("id") Long id, MascotaDetailDTO mascota) throws BusinessLogicException {
        return mascota;
    }
    
    /**
     * <h1>DELETE /api/cities/{id} : Borrar mascota por id.</h1>
     * 
     * <pre>Borra la mascota con el id asociado recibido en la URL.
     * 
     * Códigos de respuesta:<br>
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Elimina la mascota correspondiente al id dado.</code>
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found. No existe una mascota con el id dado.
     * </code>
     * </pre>
     * @param id Identificador de la mascota que se desea borrar. Este debe ser una cadena de dígitos.
     */
    @DELETE
    @Path("{id: \\d+}")
     public void deleteMascota(@PathParam("id") Long id) {
        // Void
    }
     
}
