/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.watchdogs.resources;

import co.edu.uniandes.csw.watchdogs.dtos.CalificacionDetailDTO;
import co.edu.uniandes.csw.watchdogs.ejb.CalificacionLogic;
import co.edu.uniandes.csw.watchdogs.entities.CalificacionEntity;
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

/**
 *
 * @author c.martinezc1
 */
@Path("calificaciones")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
public class CalificacionResource {
    
    @Inject
    CalificacionLogic calificacionLogic;
    
    
    /**
     *
     * @return lista entities
     * @throws BusinessLogicException
     */
    @GET
    public List<CalificacionDetailDTO> getCalificaciones() throws BusinessLogicException {
        return listCalificacionEntity2DetailDTO(calificacionLogic.getCalificaciones());
    }

    /**
     *
     * @param id
     * @return
     * @throws BusinessLogicException
     */
    @GET
    @Path("{id: \\d+}")
    public CalificacionDetailDTO getCalificacion(@PathParam("id") Long id) throws BusinessLogicException {
        CalificacionEntity entity = calificacionLogic.getCalificacion(id);
        if (entity == null) {
            throw new WebApplicationException("El recurso /calificacion/" + id + " no existe.", 404);
        }
        return new CalificacionDetailDTO(entity);
    }

    /**
     *
     * @param calificacion
     * @return
     * @throws BusinessLogicException
     */
    @POST
    public CalificacionDetailDTO createCalificacion(CalificacionDetailDTO calificacion) throws BusinessLogicException {        
         return new CalificacionDetailDTO( calificacionLogic.createCalificacion(calificacion.toEntity()));
    }

    /**
     * @param id
     * @param calificacion
     * @return
     * @throws BusinessLogicException
     */
    @PUT
    @Path("{id: \\d+}")
    public CalificacionDetailDTO updateCalificacion(@PathParam("id") Long id, CalificacionDetailDTO calificacion) throws BusinessLogicException {
        calificacion.setId(id);
        CalificacionEntity entity = calificacionLogic.getCalificacion(id);
        if (entity == null) {
            throw new WebApplicationException("El recurso /calificacion/" + id + " no existe.", 404);
        }
        return new CalificacionDetailDTO(calificacionLogic.updateCalificacion(id, calificacion.toEntity()));
    }

    @DELETE
    @Path("{id: \\d+}")
    public void deleteCalificacion(@PathParam("id") Long id) throws BusinessLogicException {
        CalificacionEntity entity = calificacionLogic.getCalificacion(id);
        if (entity == null) {
            throw new WebApplicationException("El recurso /Calificacion/" + id + " no existe.", 404);
        }
        calificacionLogic.deleteCalificacion(id);
    }


    private List<CalificacionDetailDTO> listCalificacionEntity2DetailDTO(List<CalificacionEntity> entityList) {
        List<CalificacionDetailDTO> list = new ArrayList<>();
        for(CalificacionEntity entity : entityList) {
            list.add(new CalificacionDetailDTO(entity));
        }
        return list;
    }
}
