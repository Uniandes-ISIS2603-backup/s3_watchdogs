/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.watchdogs.resources;

import co.edu.uniandes.csw.watchdogs.dtos.TarjetaCreditoDTO;
import co.edu.uniandes.csw.watchdogs.ejb.TarjetaCreditoLogic;
import co.edu.uniandes.csw.watchdogs.entities.TarjetaCreditoEntity;
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
@Path("clientes/{idCliente: \\d+}/tarjetasCredito")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
public class TarjetaCreditoResource {

    @Inject
    TarjetaCreditoLogic tarjetaLogic;

    /**
     * <h1>POST /api/tarjetaCredito : Crear una tarjeta.</h1>
     *
     * <pre>Cuerpo de petición: JSON.
     *
     * Crea una nueva tarjeta con la informacion que se recibe en el cuerpo
     * de la petición y se regresa un objeto identico con un id auto-generado
     * por la base de datos.
     *
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Creó la nueva tarjeta de crédito.
     * </code>
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 412 Precodition Failed: Ya existe la tarjeta de crédito.
     * </code>
     * </pre>
     *
     * @param tarjeta {@link TarjetaCreditoDTO} - La tarjeta que se desea
     * guardar.
     * @return JSON {@link PseDTO} - La tarjeta guardada con el atributo
     * id autogenerado.
     * @throws BusinessLogicException {@link BusinessLogicException} - Error de
     * lógica que se genera cuando ya existe la tarjeta.
     */
    @POST
    public TarjetaCreditoDTO createTarjeta(@PathParam("idCliente") Long idCliente, TarjetaCreditoDTO tarjeta) throws BusinessLogicException {
      
        return new TarjetaCreditoDTO(tarjetaLogic.createTarjeta(idCliente, tarjeta.toEntity()));
    }

    /**
     * <h1>GET /api/tarjetas : Obtener todas las tarjetas.</h1>
     *
     * <pre>Busca y devuelve todas las tarjetas que existen en la aplicacion.
     *
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Devuelve todas las tarjetas de la aplicacion.</code>
     * </pre>
     *
     * @return JSONArray {@link TarjetaCreditoDetailDTO} - Las tarjetas
     * encontradas en la aplicación. Si no hay ninguna retorna una lista vacía.
     */
    @GET
    public List<TarjetaCreditoDTO> getTarjetas(@PathParam("idCliente") Long idCliente) throws BusinessLogicException {
        return listTarjetaEntity2DetailDTO(tarjetaLogic.getTarjetas(idCliente));
    }

    /**
     * <h1>GET /api/tarjetaCredito/{id} : Obtener tarjeta por id.</h1>
     *
     * <pre>Busca la tarjeta con el id asociado recibido en la URL y la devuelve.
     *
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Devuelve la tarjeta correspondiente al id.
     * </code>
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found No existe una tarjeta con el id dado.
     * </code>
     * </pre>
     *
     * @param id Identificador de la tarjeta que se esta buscando. Este debe ser
     * una cadena de dígitos.
     * @return JSON {@link PseDetailDTO} - La tarjeta buscada
     */
    @GET
    @Path("{id: \\d+}")
    public TarjetaCreditoDTO getTarjeta(@PathParam("idCliente") Long idCliente, @PathParam("id") Long id) {
        TarjetaCreditoEntity entity = tarjetaLogic.getTarjeta(idCliente, id);
        if (entity == null) {
            throw new WebApplicationException("La tarjeta no existe", 404);
        }
        return new TarjetaCreditoDTO(entity);
    }

    /**
     * <h1>PUT /api/tarjetas/{id} : Actualizar tarjeta con el id dado.</h1>
     * <pre>Cuerpo de petición: JSON {@link TarjetaCreditoDetailDTO}.
     *
     * Actualiza la tarjeta con el id recibido en la URL con la informacion que se recibe en el cuerpo de la petición.
     *
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Actualiza la tarjeta con el id dado con la información enviada como parámetro. Retorna un objeto identico.</code>
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found. No existe una tarjeta con el id dado.
     * </code>
     * </pre>
     *
     * @param id Identificador de la tarjeta que se desea actualizar.Este debe
     * ser una cadena de dígitos.
     * @param tarjeta {@link TarjetaCreditoDetailDTO} La tarjeta que se desea
     * guardar.
     * @return JSON {@link TarjetaCreditoDetailDTO} - La tarjeta guardada.
     * @throws BusinessLogicException {@link BusinessLogicExceptionMapper} -
     * Error de lógica que se genera al no poder actualizar la tarjeta porque ya
     * existe una con ese nombre.
     */
    @PUT
    @Path("{id: \\d+}")
    public TarjetaCreditoDTO updateTarjeta(@PathParam("idCliente") Long idCliente, @PathParam("id") Long id, TarjetaCreditoDTO tarjeta) throws BusinessLogicException {
        tarjeta.setId(id);
        TarjetaCreditoEntity oldEntity = tarjetaLogic.getTarjeta(idCliente, id);
        if (oldEntity == null) {
            throw new WebApplicationException("La tarjeta  no existe", 404);
        }
        return new TarjetaCreditoDTO(tarjetaLogic.updateTarjeta(idCliente, tarjeta.toEntity()));
    }

    /**
     * <h1>DELETE /api/tarjetas/{id} : Borrar tarjeta por id.</h1>
     *
     * <pre>Borra la tarjeta con el id asociado recibido en la URL.
     *
     * Códigos de respuesta:<br>
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Elimina la tarjeta correspondiente al id dado.</code>
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found. No existe una tarjeta con el id dado.
     * </code>
     * </pre>
     *
     * @param id Identificador de la tarjeta que se desea borrar. Este debe ser
     * una cadena de dígitos.
     */
    @DELETE
    @Path("{id: \\d+}")
    public void deleteTarjeta(@PathParam("idCliente") Long idCliente, @PathParam("id") Long id) {
        TarjetaCreditoEntity entity = tarjetaLogic.getTarjeta(idCliente, id);
        if (entity == null) {
            throw new WebApplicationException("La tarjeta no existe", 404);
        }
        tarjetaLogic.deleteTarjeta(idCliente, id);
    }

    private List<TarjetaCreditoDTO> listTarjetaEntity2DetailDTO(List<TarjetaCreditoEntity> entityList) {
        List<TarjetaCreditoDTO> list = new ArrayList<>();
        for (TarjetaCreditoEntity entity : entityList) {
            list.add(new TarjetaCreditoDTO(entity));
        }
        return list;
    }

}
