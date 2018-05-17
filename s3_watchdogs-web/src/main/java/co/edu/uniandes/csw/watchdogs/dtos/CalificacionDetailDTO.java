/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.watchdogs.dtos;

/**
 * Clase que extiende de {@link CalificacionDTO} para manejar la transformacion entre
 * los objetos JSON y las Entidades de la base de datos. Para conocer el
 * contenido de la ciudad vaya a la documentacion de {@link CalificacionDTO}
 * 
 * Al serializarse como JSON esta clase implementa el siguiente modelo: <br>
 * <pre>
 *  {
 *        "id": number,
 *        "puntaje": number
 *        "cliente" : {@link ClienteDTO}
 *        
 *  }
 *    
 * </pre>
 * Por ejemplo una Calificacion se representa asi: <br>
 * 
 * <pre>
 * 
 *  {
 *        "id": 5001,
 *        "puntaje": 5
 *        "cliente": {
 *               "cedula": "1070008099",
 *               "correo": "rmercerj@constantcontact.com",
 *               "id": 5020,
 *               "imagen": "src/images/clientes/mujer14.png",
 *               "name": "Rahal Mercer",
 *               "telefono": "954-720-1751"
 *           }
 *  }
 * 
 * </pre>
 * 
 * @author c.martinezc1
 */
import co.edu.uniandes.csw.watchdogs.entities.CalificacionEntity;

/**
 *
 * @author c.martinezc1
 */
public class CalificacionDetailDTO extends CalificacionDTO {

    /**
     * Representa el cliente calificado
     */
    private ClienteDTO cliente;

    /**
     * Constructor para transformar un Entity a un DTO
     *
     * @param entity La entidad de la mascota a partir de la cual se construye
     * el objeto
     */
    public CalificacionDetailDTO(CalificacionEntity entity) {
        super(entity);
        if (entity != null) {
            if (entity.getCliente() != null) {
                cliente = new ClienteDTO(entity.getCliente());
            }
        }
    }

     /**
     * Constructor por defecto
     */
    public CalificacionDetailDTO() {
        super();

    }

    /**
     * @return El cliente calificado
     */
    public ClienteDTO getCliente() {
        return cliente;
    }
    
    /**
     * @param cliente El nuevo cliente relacionado
     */
    public void setCliente(ClienteDTO cliente) {
        this.cliente = cliente;
    }

    /**
     * Metodo que pasa de un DTO a un Entity
     * @return la entidad creada
     */
    @Override
    public CalificacionEntity toEntity() {
        CalificacionEntity entity = super.toEntity();
        if(this.cliente!=null){
            entity.setCliente(cliente.toEntity());
        }
        return entity;
    }

}
