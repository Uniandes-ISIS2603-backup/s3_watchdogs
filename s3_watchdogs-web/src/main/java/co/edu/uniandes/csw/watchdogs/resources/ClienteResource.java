/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.watchdogs.resources;

import co.edu.uniandes.csw.watchdogs.dtos.ClienteDetailDTO;
import co.edu.uniandes.csw.watchdogs.ejb.ClienteLogic;
import co.edu.uniandes.csw.watchdogs.entities.ClienteEntity;
import co.edu.uniandes.csw.watchdogs.exceptions.BusinessLogicException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import javax.ws.rs.core.MediaType;

/**
 * <pre>Clase que implementa el recurso "clientes".
 * URL: /api/clientes
 * </pre>
 * <i>Note que la aplicación (definida en {@link RestConfig}) define la ruta
 * "/api" y este recurso tiene la ruta "clientes".</i>
 *
 * <h2>Anotaciones </h2>
 * <pre>
 * Path: indica la dirección después de "api" para acceder al recurso
 * Produces/Consumes: indica que los servicios definidos en este recurso reciben y devuelven objetos en formato JSON
 * RequestScoped: Inicia una transacción desde el llamado de cada método (servicio).
 * </pre>
 *
 * @author ca.beltran10
 * @version 1.0
 */
@Path("/clientes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@RequestScoped
public class ClienteResource {

    @Inject
    private ClienteLogic clienteLogic;

    /**
     * Convierte una lista de ClienteEntity a una lista de ClienteDetailDTO
     *
     * @param entityList Lista de ClienteEntity a convertir
     * @return Lista de ClienteDetailDTO convertida.
     */
    private List<ClienteDetailDTO> listEntity2DTO(List<ClienteEntity> entityList) {
        List<ClienteDetailDTO> list = new ArrayList<>();
        for (ClienteEntity entity : entityList) {
            list.add(new ClienteDetailDTO(entity));
        }
        return list;
    }

    /**
     * <h1>POST /api/clientes : Crear un cliente.</h1>
     *
     * <pre>Cuerpo de peticion: JSON{@link ClienteDetailDTO}.
     *
     * Crea un nuevo cliente con la informacion que se recibe en el cuerpo
     * de la peticion y se regresa un objeto identico con un id auto-generado
     * por la base de datos.
     *
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Creo el nuevo cliente.
     * </code>
     * </pre>
     *
     * @param cliente {@link ClienteDetailDTO} - El cliente que se desea
     * guardar.
     * @return JSON {@link ClienteDetailDTO} - El cliente guardado con el
     * atributo id autogenerado.
     */
    @POST
    public ClienteDetailDTO createCliente(ClienteDetailDTO cliente) throws BusinessLogicException {

        return new ClienteDetailDTO(clienteLogic.createCliente(cliente.toEntity()));

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
     *
     * @return JSONArray {@link CityDetailDTO} - Los clientes encontrados en la
     * aplicación. Si no hay ninguno retorna una lista vacía.
     */
    @GET
    public List<ClienteDetailDTO> getClientes() {
        return listEntity2DTO(clienteLogic.getClientes());
    }

    /**
     * <h1>GET /api/clientes/{id} : Obtener cliente por id.</h1>
     *
     * <pre>Busca el cliente con el id asociado recibido en la URL y la devuelve.
     *
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Devuelve el cliente correspondiente al id.
     * </code>
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found No existe un cliente con el id dado.
     * </code>
     * </pre>
     *
     * @param id Identificador del cliente que se esta buscando. Este debe ser
     * una cadena de dígitos.
     * @return JSON {@link ClienteDetailDTO} - El cliente buscado
     */
    @GET
    @Path("{id: \\d+}")
    public ClienteDetailDTO getCliente(@PathParam("id") Long id) throws BusinessLogicException {
        ClienteEntity entity = clienteLogic.getCliente(id);
        return new ClienteDetailDTO(entity);
    }

    /**
     * <h1>PUT /api/clientes/{id} : Actualizar cliente con el id dado.</h1>
     * <pre>Cuerpo de petición: JSON {@link ClienteDetailDTO}.
     *
     * Actualiza el cliente con el id recibido en la URL con la informacion que se recibe en el cuerpo de la petición.
     *
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Actualiza el cliente con el id dado con la información enviada como parámetro. Retorna un objeto identico.</code>
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found. No existe un cliente con el id dado.
     * </code>
     * </pre>
     *
     * @param id Identificador del cliente que se desea actualizar. Este debe
     * ser una cadena de dígitos.
     * @param cliente {@link ClienteDetailDTO} El cliente que se desea guardar.
     * @return JSON {@link ClienteDetailDTO} - El cliente guardado.
     */
    @PUT
    @Path("{id: \\d+}")
    public ClienteDetailDTO updateCliente(@PathParam("id") Long id, ClienteDetailDTO cliente) throws BusinessLogicException {
        ClienteEntity entity = cliente.toEntity();
        entity.setId(id);
        ClienteEntity oldEntity = clienteLogic.getCliente(id);
        if (oldEntity == null) {
            throw new WebApplicationException("El cliente no existe", 404);
        }
        entity.setFacturas(oldEntity.getFacturas());
        entity.setMascotas(oldEntity.getMascotas());
        entity.setCalificacion(oldEntity.getCalificacion());
        entity.setServicios(oldEntity.getServicios());
        entity.setPayPals(oldEntity.getPayPals());
        return new ClienteDetailDTO(clienteLogic.updateCliente(id, entity));
    }

    /**
     * <h1>DELETE /api/cities/{id} : Borrar cliente por id.</h1>
     *
     * <pre>Borra el cliente con el id asociado recibido en la URL.
     *
     * Códigos de respuesta:<br>
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Elimina el cliente correspondiente al id dado.</code>
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found. No existe un cliente con el id dado.
     * </code>
     * </pre>
     *
     * @param id Identificador del cliente que se desea borrar. Este debe ser
     * una cadena de dígitos.
     */
    @DELETE
    @Path("{id: \\d+}")
    public void deleteCliente(@PathParam("id") Long id) throws BusinessLogicException {
        clienteLogic.deleteCliente(id);
    }

    /**
     * Conexión con el servicio de metodos de pago para un cliente.
     * {@link ClienteMetodosDePAgoResource}
     *
     * Este método conecta la ruta de /clientes con las rutas de /metodosDePago
     * que dependen del cliente, es una redirección al servicio que maneja el
     * segmento de la URL que se encarga de los metodos de pago.
     *
     * @param booksId El ID del libro con respecto al cual se accede al
     * servicio.
     * @return El servicio de Autores para ese libro en paricular.
     */
    @Path("{clienteId: \\d+}/payPals")
    public Class<PayPalResource> getClientePayPalResource(@PathParam("clienteId") Long clienteId) {

        ClienteEntity entity = null;
        try {
            entity = clienteLogic.getCliente(clienteId);
        } catch (BusinessLogicException ex) {
            Logger.getLogger(ClienteResource.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (entity == null) {
            throw new WebApplicationException("El recurso /clientes/" + clienteId + "/payPal no existe.", 404);
        }
        return PayPalResource.class;
    }
    
     /**
     * Conexión con el servicio de metodos de pago para un cliente.
     * {@link ClienteMetodosDePAgoResource}
     *
     * Este método conecta la ruta de /clientes con las rutas de /metodosDePago
     * que dependen del cliente, es una redirección al servicio que maneja el
     * segmento de la URL que se encarga de los metodos de pago.
     *
     * @param booksId El ID del libro con respecto al cual se accede al
     * servicio.
     * @return El servicio de Autores para ese libro en paricular.
     */
    @Path("{clienteId: \\d+}/PSES")
    public Class<PseResource> getClientePseResource(@PathParam("clienteId") Long clienteId) {

        ClienteEntity entity = null;
        try {
            entity = clienteLogic.getCliente(clienteId);
        } catch (BusinessLogicException ex) {
            Logger.getLogger(ClienteResource.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (entity == null) {
            throw new WebApplicationException("El recurso /clientes/" + clienteId + "/PSE no existe.", 404);
        }
        return PseResource.class;
    }

}
