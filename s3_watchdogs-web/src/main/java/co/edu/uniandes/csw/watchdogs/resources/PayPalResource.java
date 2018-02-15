/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.watchdogs.resources;

import co.edu.uniandes.csw.watchdogs.dtos.ClienteDetailDTO;
import co.edu.uniandes.csw.watchdogs.dtos.PayPalDetailDTO;
import co.edu.uniandes.csw.watchdogs.dtos.PseDetailDTO;
import co.edu.uniandes.csw.watchdogs.exceptions.BusinessLogicException;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 *
 * @author jc.pulido
 */
@Path("paypal")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
public class PayPalResource {
    
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
     * @param paypal {@link PseDetailDTO} -El método de pago Pse que se desea guardar.
     * @return JSON {@link PseDetailDTO}  - El método de pago Pse con el atributo id autogenerado.
     * @throws BusinessLogicException {@link BusinessLogicException} - Error de lógica que se genera cuando ya existe el método de pago pse.
     */
    @POST
    public PayPalDetailDTO createPayPal(PayPalDetailDTO paypal) throws BusinessLogicException
    {
        return paypal;
    }
    
    /**
     * <h1>GET /api/paypal : Obtener todos los clientes.</h1>
     * 
     * <pre>Busca y devuelve todos los PayPal que existen en la aplicacion.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Devuelve todos los clientes de la aplicacion.</code> 
     * </pre>
     * @return JSONArray {@link CityDetailDTO} - Los PayPal encontrados en la aplicación. Si no hay ninguno retorna una lista vacía.
     */
    @GET
    public List<PayPalDetailDTO> getPayPals() {
        return new ArrayList<>();
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
    public PayPalDetailDTO getPayPal(@PathParam("id") Long id)
    {
        return null;
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
     * @param payPal {@link PseDetailDTO} La ciudad que se desea guardar.
     * @return JSON {@link PseDetailDTO} - La ciudad guardada.
     * @throws BusinessLogicException {@link BusinessLogicExceptionMapper} - Error de lógica que se genera al no poder actualizar la ciudad porque ya existe una con ese nombre.
     */
    @PUT
    @Path("{id: \\d+}")
    public PayPalDetailDTO updatePayPal(@PathParam("id") Long id, PayPalDetailDTO payPal) throws BusinessLogicException {
        return payPal;
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
     public void deletePayPal(@PathParam("id") Long id) {
        // Void
    }
}
