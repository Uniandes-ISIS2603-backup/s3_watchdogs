/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.watchdogs.resources;

import co.edu.uniandes.csw.watchdogs.dtos.ServicioDTO;
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

/**
 *
 * @author c.martinezc1
 */
@Produces("application/json")
@Consumes("application/json")
public abstract class ServicioResource {
    
    /**
     *
     * @param dto
     * @return
     */
    @POST
    public ServicioDTO createServicio(ServicioDTO dto){
        return dto;
    }
    
    /**
     *
     * @return
     */
    @GET
    public List<ServicioDTO> getServicios(){
        return new ArrayList<>();
    }
    
    /**
     *
     * @param id
     * @return
     */
    @GET
    @Path("{id: \\d+}")
    public ServicioDTO getServicio(@PathParam("id") Long id){
        return null;
    }
    
    /**
     *
     * @param id
     * @param servicio
     * @return
     */
    @PUT
    @Path("{id: \\d+}")
    public ServicioDTO updateServicio(@PathParam("id") Long id, ServicioDTO servicio){
        return servicio;
    }
    
    @DELETE
    @Path("{id: \\d+}")
    public void DeteleServicio(){
        
    }
}
