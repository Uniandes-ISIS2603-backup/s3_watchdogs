/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.watchdogs.dtos;

import co.edu.uniandes.csw.watchdogs.entities.VeterinariaEntity;

/**
 *  VeterinariaDTO Objeto de transferencia de datos de Lugar. Los DTO contienen las
 * representaciones de los JSON que se tranfieren entre la veterinaria y el servidor.
 * 
 * Al serializarse como JSON esta clase implementa el siguiente modelo: <br>
 * <pre>
 *  {
 *      "id": Long,
 *      "direccion": String,
 *      "fotos": List'String',
 *      "usuariosEnServicio": Integer,
 *      "capacidadMaxima":Integer
 *      
 *  }
 * </pre>
 * Por ejemplo veterinaria se representa asi: <br>
 * 
 * <pre>
 * 
 *  {
 *      "id": 1234,
 *      "direccion": Carrera 50#120,
 *      "fotos": "",
 *      "usuariosEnServicio": Integer,
 *      "capacidadMaxima":Integer
 *  }
 * 
 * </pre>
 *
 * @author js.vacat
 */
public class VeterinariaDTO extends LugarDTO{
    
    /**
     * Constructor por defecto
     */
    public VeterinariaDTO()
    {
        
    }

     /**
     * Convertir Entity a DTO (Crea un nuevo DTO con los valores que recibe en
     * la entidad que viene de argumento
     * 
     * @param entity: Es la entidad que se va a convertir a DTO
     */
    public VeterinariaDTO(VeterinariaEntity entity) {
        super(entity);
       
    }
    
    @Override
    public VeterinariaEntity toEntity() {
        VeterinariaEntity entity = new VeterinariaEntity();
        entity.setId(this.id);
        entity.setDireccion(this.direccion);
        entity.setFotos(this.fotos);
        entity.setUsuariosEnServicio(this.usuariosEnServicio);
        entity.setCapacidadMaxima(this.capacidadMaxima);
        return entity;
    }
}
