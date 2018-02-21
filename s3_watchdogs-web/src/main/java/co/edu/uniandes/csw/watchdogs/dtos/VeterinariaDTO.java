/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.watchdogs.dtos;

/**
 *  VeterinariaDTO Objeto de transferencia de datos de Lugar. Los DTO contienen las
 * representaciones de los JSON que se tranfieren entre la veterinaria y el servidor.
 * 
 * Al serializarse como JSON esta clase implementa el siguiente modelo: <br>
 * <pre>
 *  {
 *      "id": Long
 *      
 *  }
 * </pre>
 * Por ejemplo veterinaria se representa asi: <br>
 * 
 * <pre>
 * 
 *  {
 *      "id": 1234
 *  }
 * 
 * </pre>
 *
 * @author js.vacat
 */
public class VeterinariaDTO extends LugarDTO{
    
    private Long id;
    
    /**
     * Constructor por defecto
     */
    public VeterinariaDTO()
    {
        
    }

    /**
     * @return id de la veterinaria
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id Id del C.E a establecer
     */
    public void setId(Long id) {
        this.id = id;
    }
}
