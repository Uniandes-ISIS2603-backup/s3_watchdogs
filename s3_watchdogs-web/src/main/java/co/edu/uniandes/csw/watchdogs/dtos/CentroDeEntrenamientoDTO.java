/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.watchdogs.dtos;

import co.edu.uniandes.csw.watchdogs.entities.CentroDeEntrenamientoEntity;

/**
 * CentroDeEntrenamientoDTO Objeto de transferencia de datos de CentrosDeEntrenamiento. Los DTO contienen las
 * represnetaciones de los JSON que se transfieren entre el cliente y el
 * servidor.
 * 
 * Al serializarse como JSON esta clase implementa el siguiente modelo: <br>
 * <pre>
 *   {
 *      "id": Long,
 *      "direccion": String,
 *      "fotos": List'String'
 *   }
 * </pre>
 * Por ejemplo un centro de entrenamiento se representa asi:<br>
 * 
 * <pre>
 * 
 *   {
 *      "id": 1321321,
 *      "direccion": Carrera 50#120,
 *      "fotos": ""
 *   }
 *
 * </pre>
 *
 * @author m.diazt
 */
public class CentroDeEntrenamientoDTO extends LugarDTO{
    
    /**
     * Constructor por defecto
     */
    public CentroDeEntrenamientoDTO()
    {
        
    }
    
    public CentroDeEntrenamientoDTO(CentroDeEntrenamientoEntity entity){
        
        super(entity);
    }

    
    public CentroDeEntrenamientoEntity toEntity(){
        CentroDeEntrenamientoEntity entity = new CentroDeEntrenamientoEntity();
        entity.setId(this.id);
        entity.setDireccion(this.direccion);
        entity.setFotos(this.fotos);
        entity.setUsuariosEnServicio(this.usuariosEnServicio);
        entity.setCapacidadMaxima(this.capacidadMaxima);
        return entity;
    }
    
    
    
}
