/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.watchdogs.resources;

import co.edu.uniandes.csw.watchdogs.dtos.PayPalDetailDTO;
import co.edu.uniandes.csw.watchdogs.dtos.PseDetailDTO;
import co.edu.uniandes.csw.watchdogs.ejb.PseLogic;
import co.edu.uniandes.csw.watchdogs.entities.PseEntity;
import co.edu.uniandes.csw.watchdogs.exceptions.BusinessLogicException;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.RequestScoped;
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
 * @author jc.pulido
 */

@Path("pses")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
public class PseResource {
    @Inject
    private PseLogic pseLogic;
    
    /**
     * <h1>POST /api/pse : Crear un método de pago Pse.</h1>
     * 
     * <pre>Cuerpo de petición: JSON.
     * 
     * Crea un nuevo método de pago con la informacion que se recibe en el cuerpo 
     * de la petición y se regresa un objeto identico con un id auto-generado 
     * por la base de datos.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Creó el nuevo método de pago PSE.
     * </code>
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 412 Precodition Failed: Ya existe el método de pago.
     * </code>
     * </pre>
     * @param pse {@link PseDetailDTO} -El método de pago Pse que se desea guardar.
     * @return JSON {@link PseDetailDTO}  - El método de pago Pse con el atributo id autogenerado.
     * @throws BusinessLogicException {@link BusinessLogicException} - Error de lógica que se genera cuando ya existe el método de pago pse.
     */
    @POST
    public PseDetailDTO createPse(PseDetailDTO pse) throws BusinessLogicException
    {
        return new PseDetailDTO(pseLogic.createPse(pse.toEntity()));
    }
    
     /**
     * <h1>GET /api/clientes : Obtener todos los clientes.</h1>
     * 
     * <pre>Busca y devuelve todos los clientes que existen en la aplicacion.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Devuelve todos los clientes de la aplicacion.</code> 
     * </pre>
     * @return JSONArray {@link CityDetailDTO} - Los clientes encontrados en la aplicación. Si no hay ninguno retorna una lista vacía.
     */
    @GET
    public List<PseDetailDTO> getPses() {
        return listEntity2DTO(pseLogic.getPses());
    }
    
    /**
     * <h1>GET /api/pse/{id} : Obtener ciudad por id.</h1>
     * 
     * <pre>Busca el método de pago pse con el id asociado recibido en la URL y la devuelve.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Devuelve el pago pse correspondiente al id.
     * </code> 
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found No existe un pago pse con el id dado.
     * </code> 
     * </pre>
     * @param id Identificador del pago pse que se esta buscando. Este debe ser una cadena de dígitos.
     * @return JSON {@link PseDetailDTO} - El pago buscado
     */
    @GET
    @Path("(id: \\d+)")
    public PseDetailDTO getPse(@PathParam("id") Long id)
    {
        PseEntity entity = pseLogic.getPse(id);
        if(entity == null)
        {
            throw new WebApplicationException("El pse no existe");
        }
        return new PseDetailDTO(entity);
    }
    
      /**
     * <h1>PUT /api/pse/{id} : Actualizar pago pse con el id dado.</h1>
     * <pre>Cuerpo de petición: JSON {@link PseDetailDTO}.
     * 
     * Actualiza el pago pse con el id recibido en la URL con la informacion que se recibe en el cuerpo de la petición.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Actualiza el pago pse con el id dado con la información enviada como parámetro. Retorna un objeto identico.</code> 
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found. No existe un pago pse con el id dado.
     * </code> 
     * </pre>
     * @param id Identificador del pago pse que se desea actualizar.Este debe ser una cadena de dígitos.
     * @param pse {@link PseDetailDTO} La ciudad que se desea guardar.
     * @return JSON {@link PseDetailDTO} - La ciudad guardada.
     * @throws BusinessLogicException {@link BusinessLogicExceptionMapper} - Error de lógica que se genera al no poder actualizar la ciudad porque ya existe una con ese nombre.
     */
    @PUT
    @Path("{id: \\d+}")
    public PseDetailDTO updatePse(@PathParam("id") Long id, PseDetailDTO pse) throws BusinessLogicException {
    PseEntity entity = pse.toEntity();
    entity.setId(id);
    PseEntity oldEntity = pseLogic.getPse(id);
    if(oldEntity == null)
    {
        throw new WebApplicationException("El pse no existe");
    }
    return new PseDetailDTO(pseLogic.updateEntity(id, entity));
    }
    
     /**
     * <h1>DELETE /api/pse/{id} : Borrar pago pse por id.</h1>
     * 
     * <pre>Borra el pago pse con el id asociado recibido en la URL.
     * 
     * Códigos de respuesta:<br>
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Elimina el pago pse correspondiente al id dado.</code>
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found. No existe un pago pse con el id dado.
     * </code>
     * </pre>
     * @param id Identificador del pago pse que se desea borrar. Este debe ser una cadena de dígitos.
     */
    @DELETE
    @Path("{id: \\d+}")
     public void deletePse(@PathParam("id") Long id) {
         PseEntity entity = pseLogic.getPse(id);
         if(entity == null)
         {
             throw new WebApplicationException("El Pse no existe");
         }
         pseLogic.deletePse(id);
    }
     
      /**
     * Convierte una lista de AuthorEntity a una lista de AuthorDetailDTO.
     *
     * @param entityList Lista de AuthorEntity a convertir.
     * @return Lista de AuthorDetailDTO convertida.
     * 
     */
    private List<PseDetailDTO> listEntity2DTO(List<PseEntity> entityList) {
        List<PseDetailDTO> list = new ArrayList<>();
        for (PseEntity entity : entityList) {
            list.add(new PseDetailDTO(entity));
        }
        return list;
    }
}
