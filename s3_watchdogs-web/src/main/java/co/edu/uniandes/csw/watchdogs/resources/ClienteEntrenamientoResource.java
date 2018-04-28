/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.watchdogs.resources;

import co.edu.uniandes.csw.watchdogs.dtos.EntrenamientoDetailDTO;
import co.edu.uniandes.csw.watchdogs.ejb.EntrenamientoLogic;
import co.edu.uniandes.csw.watchdogs.exceptions.BusinessLogicException;
import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

/**
 *
 * @author c.martinezc1
 */
@Path("clientes/{clienteId:\\d+}/entrenamientos")
public class ClienteEntrenamientoResource {
    
    @Inject
    EntrenamientoLogic entrenamientoLogic;
    
    
    /**
     * Crea un entrenamieto.
     * @param entrenamiento
     * @return
     * @throws BusinessLogicException
     */
    @POST
    public EntrenamientoDetailDTO createEntrenamiento(EntrenamientoDetailDTO entrenamiento) throws BusinessLogicException {        
        return new EntrenamientoDetailDTO(entrenamientoLogic.createEntrenamiento(entrenamiento.toEntity()));
    }
}
