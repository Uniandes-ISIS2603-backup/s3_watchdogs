/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.watchdogs.resources;

import co.edu.uniandes.csw.watchdogs.dtos.CalificacionDTO;
import co.edu.uniandes.csw.watchdogs.dtos.CalificacionDetailDTO;
import co.edu.uniandes.csw.watchdogs.ejb.EntrenamientoLogic;
import co.edu.uniandes.csw.watchdogs.exceptions.BusinessLogicException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
 * @author c.martinezc1
 */
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("entrenamientos/{entrenamientoId: \\d+}/calificaciones")
public class EntrenamientoCalificacionResource {

    @Inject
    private EntrenamientoLogic entrenamientoLogic;

    /**
     * Obtiene una instancia de Calificacion asociada a una instancia de
     * Entrenamiento
     *
     * @param entrenamientoId Identificador de la instancia de Entrenamiento
     * @return
     *
     */
    @GET
    public CalificacionDetailDTO getCalificacion(@PathParam("entrenamientoId") Long entrenamientoId ) {
        return new CalificacionDetailDTO(entrenamientoLogic.getCalificacion(entrenamientoId));
    }

    /**
     * Asocia un Calificacion existente a un Entrenamiento
     *
     * @param entrenamientoId
     * @param calificacion
     * @return Instancia de CalificacionDetailDTO que fue asociada a
     * Entrenamiento
     *
     */
    @POST
    public CalificacionDetailDTO addCalificacion(@PathParam("entrenamientoId") Long entrenamientoId, CalificacionDTO calificacion) {
        try {
            return new CalificacionDetailDTO(entrenamientoLogic.addCalificacion(entrenamientoId, calificacion.toEntity()));
        } catch (BusinessLogicException ex) {
            Logger.getLogger(EntrenamientoCalificacionResource.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }


    
}
