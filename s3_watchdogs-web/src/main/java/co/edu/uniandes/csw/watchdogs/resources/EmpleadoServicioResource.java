/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.watchdogs.resources;

import co.edu.uniandes.csw.watchdogs.dtos.ServicioDetailDTO;
import co.edu.uniandes.csw.watchdogs.ejb.EmpleadoLogic;
import co.edu.uniandes.csw.watchdogs.entities.ServicioEntity;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author c.martinezc1
 */
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("empleados/{empleadoId:\\d+}/servicios")
public class EmpleadoServicioResource {
    
    @Inject
    private EmpleadoLogic empleadoLogic;
    
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
    public List<ServicioDetailDTO> listServicios(@PathParam("empleadoId") Long empleadoId) {
        return servicioListEntity2DTO(empleadoLogic.getServicios(empleadoId));
    }
}
