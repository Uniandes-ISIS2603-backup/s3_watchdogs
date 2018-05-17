/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.watchdogs.resources;

import co.edu.uniandes.csw.watchdogs.dtos.FacturaDetailDTO;
import co.edu.uniandes.csw.watchdogs.dtos.MascotaDetailDTO;
import co.edu.uniandes.csw.watchdogs.ejb.ClienteLogic;
import co.edu.uniandes.csw.watchdogs.entities.FacturaEntity;
import co.edu.uniandes.csw.watchdogs.entities.MascotaEntity;
import co.edu.uniandes.csw.watchdogs.exceptions.BusinessLogicException;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author jc.pulido
 */
@Path("clientes/{clientesId: \\d+}/facturas")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ClienteFacturaResource {

    @Inject
    private ClienteLogic clienteLogic;

    /**
     * Convierte una lista de AuthorEntity a una lista de AuthorDetailDTO.
     *
     * @param entityList Lista de AuthorEntity a convertir.
     * @return Lista de AuthorDetailDTO convertida.
     *
     */
    private List<FacturaDetailDTO> facturasListEntity2DTO(List<FacturaEntity> entityList) {
        List<FacturaDetailDTO> list = new ArrayList<>();
        for (FacturaEntity entity : entityList) {
            list.add(new FacturaDetailDTO(entity));
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
    private List<FacturaEntity> facturasListDTO2Entity(List<FacturaDetailDTO> dtos) {
        List<FacturaEntity> list = new ArrayList<>();
        for (FacturaDetailDTO dto : dtos) {
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
    public List<FacturaDetailDTO> listFacturas(@PathParam("clientesId") Long clienteId) throws BusinessLogicException {
        return facturasListEntity2DTO(clienteLogic.listFacturas(clienteId));
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
    @Path("{facturaId: \\d+}")
    public FacturaDetailDTO getFactura(@PathParam("clientesId") Long clientesId, @PathParam("facturaId") Long facturaId) throws BusinessLogicException {
        return new FacturaDetailDTO(clienteLogic.getFactura(clientesId, facturaId));
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

}
