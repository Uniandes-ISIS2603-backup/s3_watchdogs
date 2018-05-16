/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.watchdogs.resources;

import co.edu.uniandes.csw.watchdogs.dtos.AseoDetailDTO;
import co.edu.uniandes.csw.watchdogs.ejb.AseoLogic;
import co.edu.uniandes.csw.watchdogs.exceptions.BusinessLogicException;
import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

/**
 *
 * @author c.martinezc1
 */
@Path("clientes/{clienteId:\\d+}/aseos")
public class ClienteAseoResource {
    
    @Inject
    AseoLogic aseoLogic;
    
    /**
     * Crea un entrenamieto.
     * @param clienteId
     * @param aseo
     * @return
     * @throws BusinessLogicException
     */
    @POST
    public AseoDetailDTO createAseo(@PathParam("clienteId")Long clienteId, AseoDetailDTO aseo) throws BusinessLogicException {        
        return new AseoDetailDTO(aseoLogic.createClienteAseo(clienteId,aseo.toEntity()));
    }
}
