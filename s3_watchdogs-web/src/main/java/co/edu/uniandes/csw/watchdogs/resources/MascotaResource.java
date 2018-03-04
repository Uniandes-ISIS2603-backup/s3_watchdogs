/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.watchdogs.resources;

import co.edu.uniandes.csw.watchdogs.dtos.MascotaDetailDTO;
import co.edu.uniandes.csw.watchdogs.ejb.MascotaLogic;
import co.edu.uniandes.csw.watchdogs.entities.MascotaEntity;
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
 * <pre>Clase que implementa el recurso "mascotas".
 * URL: /api/mascotas
 * </pre>
 * <i>Note que la aplicación (definida en {@link RestConfig}) define la ruta
 * "/api" y este recurso tiene la ruta "mascotas".</i>
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
@Path("/mascotas")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@RequestScoped
public class MascotaResource {

    @Inject
    private MascotaLogic mascotaLogic;

    /**
     * Convierte una lista de MascotaEntity a una lista de MascotaDetailDTO.
     *
     * @param entityList Lista de MascotaEntity a convertir.
     * @return La lista de MascotaDetailDTO convertida.
     */
    private List<MascotaDetailDTO> listEntity2DTO(List<MascotaEntity> entityList) {
        List<MascotaDetailDTO> list = new ArrayList<>();
        for (MascotaEntity entity : entityList) {
            list.add(new MascotaDetailDTO(entity));
        }
        return list;
    }

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
     * @param mascota {@link MascotaDetailDTO} - La mascota que se desea
     * guardar.
     * @return JSON {@link MascotaDetailDTO} - La mascota guardada con el
     * atributo id autogenerado.
     */
    @POST
    public MascotaDetailDTO createMascota(MascotaDetailDTO mascota) {
        try {
            return new MascotaDetailDTO(mascotaLogic.creatMascota(mascota.toEntity()));
        } catch (BusinessLogicException e) {
            throw new WebApplicationException(e.getMessage(), 404);
        }
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
     *
     * @return JSONArray {@link CityDetailDTO} - Los mascotas encontrados en la
     * aplicación. Si no hay ninguno retorna una lista vacía.
     */
    @GET
    public List<MascotaDetailDTO> getMascotas() {
        return listEntity2DTO(mascotaLogic.getMascotas());
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
     *
     * @param id Identificador de la mascota que se esta buscando. Este debe ser
     * una cadena de dígitos.
     * @return JSON {@link MascotaDetailDTO} - La mascota buscada
     */
    @GET
    @Path("{id: \\d+}")
    public MascotaDetailDTO getMascota(@PathParam("id") Long id) {
        MascotaEntity entity = mascotaLogic.getMascota(id);
        if (entity == null) {
            throw new WebApplicationException("La mascota no existe", 404);
        }
        return new MascotaDetailDTO(entity);
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
     *
     * @param id Identificador de la mascota que se desea actualizar. Este debe
     * ser una cadena de dígitos.
     * @param mascota {@link MascotaDetailDTO} La mascota que se desea guardar.
     * @return JSON {@link MascotaDetailDTO} - La mascota guardado.
     */
    @PUT
    @Path("{id: \\d+}")
    public MascotaDetailDTO updateMascota(@PathParam("id") Long id, MascotaDetailDTO mascota) {
        MascotaEntity entity = mascota.toEntity();
        entity.setId(id);
        MascotaEntity oldEntity = mascotaLogic.getMascota(id);
        if (oldEntity == null) {
            throw new WebApplicationException("La mascota no existe", 404);
        }
        entity.setServicio(oldEntity.getServicio());
        entity.setCliente(oldEntity.getCliente());
        return new MascotaDetailDTO(mascotaLogic.updateMascota(id, entity));
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
     *
     * @param id Identificador de la mascota que se desea borrar. Este debe ser
     * una cadena de dígitos.
     */
    @DELETE
    @Path("{id: \\d+}")
    public void deleteMascota(@PathParam("id") Long id) {
        try {
            mascotaLogic.deleteMascota(id);
        } catch (BusinessLogicException e) {
            throw new WebApplicationException(e.getMessage(), 404);
        }
    }

}
