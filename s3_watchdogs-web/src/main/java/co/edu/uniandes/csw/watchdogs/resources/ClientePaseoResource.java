/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.watchdogs.resources;

import co.edu.uniandes.csw.watchdogs.dtos.PaseoDetailDTO;
import co.edu.uniandes.csw.watchdogs.ejb.PaseoLogic;
import co.edu.uniandes.csw.watchdogs.exceptions.BusinessLogicException;
import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

/**
 *
 * @author c.martinezc1
 */
@Path("clientes/{clienteId:\\d+}/paseos")
public class ClientePaseoResource {
    
    @Inject
    PaseoLogic hotelLogic;
    
    /**
     * Crea un entrenamieto.
     * @param clienteId
     * @param hotel
     * @return
     * @throws BusinessLogicException
     */
    @POST
    public PaseoDetailDTO createPaseo(@PathParam("clienteId")Long clienteId, PaseoDetailDTO hotel) throws BusinessLogicException {        
        return new PaseoDetailDTO(hotelLogic.createClientePaseo(clienteId,hotel.toEntity()));
    }
}
