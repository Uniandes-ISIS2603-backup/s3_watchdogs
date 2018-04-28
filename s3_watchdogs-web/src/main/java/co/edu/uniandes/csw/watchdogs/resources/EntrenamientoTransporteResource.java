/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.watchdogs.resources;


import co.edu.uniandes.csw.watchdogs.dtos.TransporteDTO;
import co.edu.uniandes.csw.watchdogs.dtos.TransporteDetailDTO;
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
@Path("entrenamientos/{entrenamientoId: \\d+}/transportes")
public class EntrenamientoTransporteResource {
    
    @Inject
    private EntrenamientoLogic entrenamientoLogic;
    
    /**
     * Obtiene una instancia de transporte asociada a una instancia de
     * Entrenamiento
     *
     * @param entrenamientoId Identificador de la instancia de Entrenamiento
     * @return
     *
     */
    @GET
    public TransporteDetailDTO getTransporte(@PathParam("entrenamientoId") Long entrenamientoId ) {
        return new TransporteDetailDTO(entrenamientoLogic.getTransporte(entrenamientoId));
    }

    /**
     * Asocia un transporte existente a un Entrenamiento
     *
     * @param entrenamientoId
     * @param transporte
     * @return Instancia de transporteDetailDTO que fue asociada a
     * Entrenamiento
     *
     */
    @POST
    public TransporteDetailDTO addTransporte(@PathParam("entrenamientoId") Long entrenamientoId, TransporteDTO transporte) {
        try {
            return new TransporteDetailDTO(entrenamientoLogic.addTransporte(entrenamientoId, transporte.toEntity()));
        } catch (BusinessLogicException ex) {
            Logger.getLogger(EntrenamientoTransporteResource.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
