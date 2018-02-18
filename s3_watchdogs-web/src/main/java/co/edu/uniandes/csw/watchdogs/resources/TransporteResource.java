/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.watchdogs.resources;

import co.edu.uniandes.csw.watchdogs.dtos.TransporteDetailDTO;
import co.edu.uniandes.csw.watchdogs.entities.TransporteEntity;
import co.edu.uniandes.csw.watchdogs.exceptions.BusinessLogicException;
import java.util.ArrayList;
import java.util.List;
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
@Path("transportes")
@Produces("application/json")
@Consumes("application/json")
public class TransporteResource {
    
    /*
    @Inject
    EntrenamientoLogic entrenamientoLogic;
    */
    
    /**
     *
     * @return lista entities
     * @throws BusinessLogicException
     */
    @GET
    public List<TransporteDetailDTO> getTransportes() throws BusinessLogicException {
        return null;        //return listTransporteEntity2DetailDTO(transporteLogic.getTransportes());
    }

    /**
     *
     * @param id
     * @return
     * @throws BusinessLogicException
     */
    @GET
    @Path("{id: \\d+}")
    public TransporteDetailDTO getEntrenamiento(@PathParam("id") Long id) throws BusinessLogicException {
        TransporteEntity entity = null;//transporteLogic.getTransporte(id);
        if (entity == null) {
            throw new WebApplicationException("El recurso /transportes/" + id + " no existe.", 404);
        }
        return new TransporteDetailDTO(entity);
    }

    /**
     *
     * @param transporte
     * @return
     * @throws BusinessLogicException
     */
    @POST
    public TransporteDetailDTO createEntrenamiento(TransporteDetailDTO transporte) throws BusinessLogicException {        
         return new TransporteDetailDTO( );//transporteLogic.createTransporte(transporte.toEntity()));
    }

    /**
     * @param id
     * @param transporte
     * @return
     * @throws BusinessLogicException
     */
    @PUT
    @Path("{id: \\d+}")
    public TransporteDetailDTO updateEntenamiento(@PathParam("id") Long id, TransporteDetailDTO transporte) throws BusinessLogicException {
        transporte.setId(id);
        TransporteEntity entity = null;//transporteLogic.getTransporte(id);
        if (entity == null) {
            throw new WebApplicationException("El recurso /transportes/" + id + " no existe.", 404);
        }
        return new TransporteDetailDTO();//transporteLogic.updateTransporte(id, transporte.toEntity()));
    }

    @DELETE
    @Path("{id: \\d+}")
    public void deleteTransporte(@PathParam("id") Long id) throws BusinessLogicException {
        TransporteEntity entity = null;//transporteLogic.getTransporte(id);
        if (entity == null) {
            throw new WebApplicationException("El recurso /transportes/" + id + " no existe.", 404);
        }
        //transporteLogic.deleteTransporte(id);
    }


    private List<TransporteDetailDTO> listTransporteEntity2DetailDTO(List<TransporteEntity> entityList) {
        List<TransporteDetailDTO> list = new ArrayList<>();
        for(TransporteEntity entity : entityList) {
            list.add(new TransporteDetailDTO(entity));
        }
        return list;
    }
}