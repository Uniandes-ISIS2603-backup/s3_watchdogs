/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.watchdogs.resources;

import co.edu.uniandes.csw.watchdogs.dtos.HotelDetailDTO;
import co.edu.uniandes.csw.watchdogs.ejb.HotelLogic;
import co.edu.uniandes.csw.watchdogs.exceptions.BusinessLogicException;
import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

/**
 *
 * @author c.martinezc1
 */
@Path("clientes/{clienteId:\\d+}/hoteles")
public class ClienteHotelResource {
    
    @Inject
    HotelLogic hotelLogic;
    
    /**
     * Crea un entrenamieto.
     * @param clienteId
     * @param hotel
     * @return
     * @throws BusinessLogicException
     */
    @POST
    public HotelDetailDTO createClienteHotel(@PathParam("clienteId")Long clienteId, HotelDetailDTO hotel) throws BusinessLogicException {        
        return new HotelDetailDTO(hotelLogic.createClienteHotel(clienteId,hotel.toEntity()));
    }
}
