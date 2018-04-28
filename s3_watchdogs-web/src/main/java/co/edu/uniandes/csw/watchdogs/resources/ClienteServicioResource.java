/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.watchdogs.resources;

import co.edu.uniandes.csw.watchdogs.dtos.ServicioDetailDTO;
import co.edu.uniandes.csw.watchdogs.ejb.ClienteLogic;
import co.edu.uniandes.csw.watchdogs.entities.ServicioEntity;
import co.edu.uniandes.csw.watchdogs.exceptions.BusinessLogicException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
 * URI: clientes/{clientesId: \\d+}/servicios
 *
 * @cliente c.martinezc1
 */
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("clientes/{clienteId:\\d+}/servicios")
public class ClienteServicioResource {

    @Inject
    private ClienteLogic clienteLogic;

    private List<ServicioDetailDTO> servicioListEntity2DTO(List<ServicioEntity> entityList) {
        List<ServicioDetailDTO> list = new ArrayList<>();
        entityList.forEach((entity) -> {
            list.add(new ServicioDetailDTO(entity) {
            });
        });
        return list;
    }

    /**
     * Obtiene una colección de instancias de servicioDetailDTO asociadas a una
     * instancia de cliente
     *
     * @param clienteId
     * @return Colección de instancias de servicioDetailDTO asociadas a la
     * instancia de cliente
     *
     */
    @GET
    public List<ServicioDetailDTO> listServicios(@PathParam("clienteId") Long clienteId) {
        try {
            return servicioListEntity2DTO(clienteLogic.getServicios(clienteId));
        } catch (BusinessLogicException ex) {
            Logger.getLogger(ClienteServicioResource.class.getName()).log(Level.SEVERE, null, ex);
            throw new WebApplicationException("El recurso incumple una regla de negocio.", 415);
        }
    }

}
