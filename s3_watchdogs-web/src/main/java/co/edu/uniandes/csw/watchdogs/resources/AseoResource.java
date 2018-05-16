package co.edu.uniandes.csw.watchdogs.resources;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import co.edu.uniandes.csw.watchdogs.dtos.AseoDetailDTO;
import co.edu.uniandes.csw.watchdogs.ejb.AseoLogic;
import co.edu.uniandes.csw.watchdogs.entities.AseoEntity;
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
 * <pre>Clase que implementa el recurso "Aseos".
 * URL: /api/mascotas
 * </pre>
 * <i>Note que la aplicación (definida en {@link RestConfig}) define la ruta "/api" y
 * este recurso tiene la ruta "aseos".</i>
 *
 * <h2>Anotaciones </h2>
 * <pre>
 * Path: indica la dirección después de "api" para acceder al recurso
 * Produces/Consumes: indica que los servicios definidos en este recurso reciben y devuelven objetos en formato JSON
 * RequestScoped: Inicia una transacción desde el llamado de cada método (servicio). 
 * </pre>
 * @author js.vacat 
 * @version 1.0
 */
@Path("aseos")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
public class AseoResource {
    
    @Inject
    AseoLogic aseoLogic;

    /**
     * <h1>POST /api/aseos : Crear una aseo.</h1>
     * 
     * <pre>Cuerpo de petición: JSON {@link AseoDetailDTO}.
     * 
     * Crea un nuevo servicio de aseo con la informacion que se recibe en el cuerpo 
     * de la petición y se regresa un objeto identico con un id auto-generado 
     * por la base de datos.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Creó el nuevo servicio de aseo .
     * </code>
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 412 Precodition Failed: Ya existe el servicio de aseo.
     * </code>
     * </pre>
     * @param aseo {@link AseoDetailDTO} -Servicio de aseo que se desea guardar.
     * @return JSON {@link AseoDetailDTO}  - Servicio de aseo guardado con el atributo id autogenerado.
     * @throws BusinessLogicException {@link BusinessLogicExceptionMapper} - Error de lógica que se genera cuando ya existeel servicio de aseo.
     */
    @POST
    public AseoDetailDTO createAseo(AseoDetailDTO aseo) throws BusinessLogicException {
        return new AseoDetailDTO(aseoLogic.createAseo(aseo.toEntity()));
    }

    /**
     * <h1>GET /api/aseos : Obtener todos los Servicios de aseo.</h1>
     * 
     * <pre>Busca y devuelve todos los servicios de aseo que existen en la aplicacion.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Devuelve todos los servicios de aseo de la aplicacion.</code> 
     * </pre>
     * @return JSONArray {@link AseoDetailDTO} - Los servicios de aseo encontrados en la aplicación. Si no hay ninguna retorna una lista vacía.
     * @throws co.edu.uniandes.csw.watchdogs.exceptions.BusinessLogicException
     */
    @GET
    public List<AseoDetailDTO> getAseos() throws BusinessLogicException {
        return listAseoEntity2DetailDTO(aseoLogic.getAseos());
    }

    /**
     * <h1>GET /api/aseos/{id} : Obtener el servicio de aseo por id.</h1>
     * 
     * <pre>Busca el servicio de aseo con el id asociado recibido en la URL y la devuelve.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Devuelve el servicio de aseo correspondiente al id.
     * </code> 
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found No existe un servicio de aseo con el id dado.
     * </code> 
     * </pre>
     * @param id Identificador del servicio de aseo que se esta buscando. Este debe ser una cadena de dígitos.
     * @return JSON {@link AseoDetailDTO} -El servicio de aseo buscado
     * @throws co.edu.uniandes.csw.watchdogs.exceptions.BusinessLogicException
     */
    @GET
    @Path("{id: \\d+}")
    public AseoDetailDTO getAseo(@PathParam("id") Long id)throws BusinessLogicException {
        AseoEntity entity = aseoLogic.getAseo(id);
        if (entity==null)
        {
           throw new WebApplicationException("El recurso  /aseos/" + id + " no existe.", 404);
        }
        return new AseoDetailDTO(entity);  
        
    }
    
    /**
     * <h1>PUT /api/aseos/{id} : Actualizar el servicio de aseo con el id dado.</h1>
     * <pre>Cuerpo de petición: JSON {@link AseoDetailDTO}.
     * 
     * Actualiza el servicio de aseo con el id recibido en la URL con la informacion que se recibe en el cuerpo de la petición.
     * 
     * Codigos de respuesta:
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Actualiza el servicio de aseo con el id dado con la información enviada como parámetro. Retorna un objeto identico.</code> 
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found. No existe un servico de aseo con el id dado.
     * </code> 
     * </pre>
     * @param id Identificador del servico de aseo que se desea actualizar.Este debe ser una cadena de dígitos.
     * @param aseo {@link AseoDetailDTO} El servicio de aseo que se desea guardar.
     * @return JSON {@link AseoDetailDTO} - El servicio de aseo guardado.
     * @throws BusinessLogicException {@link BusinessLogicExceptionMapper} - Error de lógica que se genera al no poder actualizar el servicio de aseo porque ya existe uno con ese nombre.
     */
    @PUT
    @Path("{id: \\d+}")
    public AseoDetailDTO updateAseo(@PathParam("id") Long id,AseoDetailDTO aseo) throws BusinessLogicException {
        aseo.setId(id);
        AseoEntity entity = aseoLogic.getAseo(id);
        if (entity == null) {
            throw new WebApplicationException("El recurso /aseos/" + id + " no  existe.", 404);
        }
        return new AseoDetailDTO(aseoLogic.updateAseo(id,aseo.toEntity() ));
    }
    
    /**
     * <h1>DELETE /api/aseos/{id} : Borrar servicio de aseo por id.</h1>
     * 
     * <pre>Borra el servicio de aseo con el id asociado recibido en la URL.
     * 
     * Códigos de respuesta:<br>
     * <code style="color: mediumseagreen; background-color: #eaffe0;">
     * 200 OK Elimina el servicio de aseo correspondiente al id dado.</code>
     * <code style="color: #c7254e; background-color: #f9f2f4;">
     * 404 Not Found. No existe un servicio de aseo con el id dado.
     * </code>
     * </pre>
     * @param id Identificador del servicio de aseo que se desea borrar. Este debe ser una cadena de dígitos.
     * @throws co.edu.uniandes.csw.watchdogs.exceptions.BusinessLogicException
     */
    @DELETE
    @Path("{id: \\d+}")
     public void deleteAseo(@PathParam("id") Long id) throws BusinessLogicException {
        AseoEntity entity = aseoLogic.getAseo(id);
        if (entity == null) {
            throw new WebApplicationException("El recurso /aseos/" + id + " no existe.", 404);
        }
       aseoLogic.deleteAseo(id);
    }
     
      private List<AseoDetailDTO> listAseoEntity2DetailDTO(List<AseoEntity> entityList) {
        List<AseoDetailDTO> list = new ArrayList<>();
        for(AseoEntity entity : entityList) {
            list.add(new AseoDetailDTO(entity));
        }
        return list;
    }
      
      private Double costo(double duracion){
        return duracion * 1.5;
    }
}