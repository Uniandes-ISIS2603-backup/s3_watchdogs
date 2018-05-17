/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.watchdogs.resources;

import co.edu.uniandes.csw.watchdogs.dtos.MascotaDetailDTO;
import co.edu.uniandes.csw.watchdogs.ejb.ClienteLogic;
import co.edu.uniandes.csw.watchdogs.entities.MascotaEntity;
import co.edu.uniandes.csw.watchdogs.exceptions.BusinessLogicException;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author jc.pulido
 */
@Path("clientes/{clientesId: \\d+}/mascotas")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MascotasClientesResource {

    @Inject
    private ClienteLogic clienteLogic;

    /**
     * Convierte una lista de AuthorEntity a una lista de AuthorDetailDTO.
     *
     * @param entityList Lista de AuthorEntity a convertir.
     * @return Lista de AuthorDetailDTO convertida.
     *
     */
    private List<MascotaDetailDTO> mascotasListEntity2DTO(List<MascotaEntity> entityList) {
        List<MascotaDetailDTO> list = new ArrayList<>();
        for (MascotaEntity entity : entityList) {
            list.add(new MascotaDetailDTO(entity));
        }
        return list;
    }

    /**
     * Convierte una lista de AuthorDetailDTO a una lista de AuthorEntity.
     *
     * @param dtos Lista de AuthorDetailDTO a convertir.
     * @return Lista de AuthorEntity convertida.
     *
     */
    private List<MascotaEntity> mascotasListDTO2Entity(List<MascotaDetailDTO> dtos) {
        List<MascotaEntity> list = new ArrayList<>();
        for (MascotaDetailDTO dto : dtos) {
            list.add(dto.toEntity());
        }
        return list;
    }

    /**
     * <h1>GET /api/books/{booksId}/authors : Obtener todos los autores de un
     * libro.</h1>
     *
     * <pre>Busca y devuelve todos los autores que existen en un libro.
     *
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Devuelve todos los autores del libro.</code>
     * </pre>
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found. No existe un libro con el id dado.
     * </code>
     *
     * @param booksId El ID del libro del cual se buscan los autores
     * @return JSONArray {@link AuthorDetailDTO} - Los autores encontrados en el
     * libro. Si no hay ninguno retorna una lista vacía.
     */
    @GET
    public List<MascotaDetailDTO> listMascotas(@PathParam("clientesId") Long clienteId) throws BusinessLogicException {
        return mascotasListEntity2DTO(clienteLogic.listMascotas(clienteId));
    }

    /**
     * <h1>GET /api/books/{booksId}/authors/{authorsId} : Obtener un autor de un
     * libro.</h1>
     *
     * <pre>Busca y devuelve el autor con el ID recibido en la URL, relativo a un
     * libro.
     *
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Devuelve el autor del libro.</code>
     * </pre>
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found. No existe un libro con el id dado.
     * </code>
     *
     * @param authorsId El ID del autor que se busca
     * @param booksId El ID del libro del cual se busca el autor
     * @return {@link AuthorDetailDTO} - El autor encontrado en el libro.
     */
    @GET
    @Path("{mascotasId: \\d+}")
    public MascotaDetailDTO getMascotas(@PathParam("clientesId") Long clientesId, @PathParam("mascotasId") Long mascotasId) throws BusinessLogicException {
        return new MascotaDetailDTO(clienteLogic.getMascota(clientesId, mascotasId));
    }

    /**
     * <h1>POST /api/books/{booksId}/authors/{authorsId} : Aociar un autor a un
     * libro.</h1>
     *
     * <pre> Asocia un autor existente con un libro existente
     *
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Asoció el autor .
     * </code>
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found: No existe el libro o el autor
     * </code>
     * </pre>
     *
     * @param authorsId El ID del autor que se va a asociar
     * @param booksId El ID del libro al cual se le va a asociar el autor
     * @return JSON {@link AuthorDetailDTO} - El autor asociado.
     */
    @POST
    public MascotaDetailDTO addMascotas(@PathParam("clientesId") Long clientesId, @PathParam("mascotasId") Long mascotasId) throws BusinessLogicException {
        return new MascotaDetailDTO(clienteLogic.addMascota(clientesId, mascotasId));
    }

//    @POST
//    public MascotaDetailDTO addMascotas(@PathParam("clientesId") Long clientesId, MascotaDTO mascota) throws BusinessLogicException {
//        return new MascotaDetailDTO(mascotaLogic.createMascota(clientesId, mascota.toEntity()));
//    }
    /**
     * <h1>DELETE /api/books/{booksId}/authors/{authorsId} : Desasociar autor
     * por id.</h1>
     *
     * <pre>Elimina la conexión entre el autor y el libro recibidos en la URL.
     *
     * Códigos de respuesta:<br>
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Elimina la referencia al autor.</code>
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found. No existe un autor con el id dado en el libro.
     * </code>
     * </pre>
     *
     * @param booksId El ID del libro al cual se le va a desasociar el autor
     * @param authorsId El ID del autor que se desasocia
     */
    @DELETE
    @Path("{mascotasId: \\d+}")
    public void removeMascota(@PathParam("clientesId") Long clientesId, @PathParam("mascotasId") Long mascotasId) throws BusinessLogicException {
        clienteLogic.removeMascota(clientesId, mascotasId);
    }

}
