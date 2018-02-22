/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.watchdogs.resources;

import co.edu.uniandes.csw.watchdogs.dtos.EntrenamientoDetailDTO;
import co.edu.uniandes.csw.watchdogs.ejb.EntrenamientoLogic;
import co.edu.uniandes.csw.watchdogs.entities.EntrenamientoEntity;
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
import javax.ws.rs.WebApplicationException;

/**
 *
 * @author c.martinezc1
 */
@Path("entrenamientos")
@Produces("application/json")
@Consumes("application/json")
public class EntrenamientoResource{
    
    
    @Inject
    EntrenamientoLogic entrenamientoLogic;
    
    
    /**
     *
     * @return
     * @throws BusinessLogicException
     */
    @GET
    public List<EntrenamientoDetailDTO> getEntrenamientos() throws BusinessLogicException {
        return listEntrenamientoEntity2DetailDTO(entrenamientoLogic.getEntrenamientos());
    }

    /**
     *
     * @param id
     * @return
     * @throws BusinessLogicException
     */
    @GET
    @Path("{id: \\d+}")
    public EntrenamientoDetailDTO getEntrenamiento(@PathParam("id") Long id) throws BusinessLogicException {
        EntrenamientoEntity entity = entrenamientoLogic.getEntrenamiento(id);
        if (entity == null) {
            throw new WebApplicationException("El recurso /entrenamientos/" + id + " no existe.", 404);
        }
        return new EntrenamientoDetailDTO(entity);
    }

    /**
     *
     * @param entrenamiento
     * @return
     * @throws BusinessLogicException
     */
    @POST
    public EntrenamientoDetailDTO createEntrenamiento(EntrenamientoDetailDTO entrenamiento) throws BusinessLogicException {        
         return new EntrenamientoDetailDTO(entrenamientoLogic.createEntrenamiento(entrenamiento.toEntity()));
    }

    /**
     * @param id
     * @param entrenamiento
     * @return
     * @throws BusinessLogicException
     */
    @PUT
    @Path("{id: \\d+}")
    public EntrenamientoDetailDTO updateEntenamiento(@PathParam("id") Long id, EntrenamientoDetailDTO entrenamiento) throws BusinessLogicException {
        entrenamiento.setId(id);
        EntrenamientoEntity entity = entrenamientoLogic.getEntrenamiento(id);
        if (entity == null) {
            throw new WebApplicationException("El recurso /entrenamientos/" + id + " no existe.", 404);
        }
        return new EntrenamientoDetailDTO(entrenamientoLogic.updateEntrenamiento(id, entrenamiento.toEntity()));
    }

    @DELETE
    @Path("{id: \\d+}")
    public void deleteEntrenamiento(@PathParam("id") Long id) throws BusinessLogicException {
        EntrenamientoEntity entity = entrenamientoLogic.getEntrenamiento(id);
        if (entity == null) {
            throw new WebApplicationException("El recurso /entrenamientos/" + id + " no existe.", 404);
        }
        entrenamientoLogic.deleteEntrenamiento(id);
    }


    private List<EntrenamientoDetailDTO> listEntrenamientoEntity2DetailDTO(List<EntrenamientoEntity> entityList) {
        List<EntrenamientoDetailDTO> list = new ArrayList<>();
        for(EntrenamientoEntity entity : entityList) {
            list.add(new EntrenamientoDetailDTO(entity));
        }
        return list;
    }
    
}
