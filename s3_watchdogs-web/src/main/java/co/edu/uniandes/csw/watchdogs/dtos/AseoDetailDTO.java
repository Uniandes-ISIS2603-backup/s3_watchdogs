/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.watchdogs.dtos;

import co.edu.uniandes.csw.watchdogs.entities.AseoEntity;


/**
 * /**
 * 
 * Al serializarse como JSON esta clase implementa el siguiente modelo: <br>
 * <pre>
 *  {
 *      "id": Long,
 *      "fecha": Date,
 *      "costo": Double,
 *      "estado": Boolean,
 *      "duración": Double,
 *      "rango": List'String'
 *      "dientes": Boolean,
 *      "banho": Boolean,
 *      "peluqueria": Boolean
 *  }
 * </pre>
 * Por ejemplo un servicio de aseo se representa asi: <br>
 * 
 * <pre>
 * 
 *  {
 *      "id": 1889
 *      "fecha: "10-10-2010",
 *      "costo": 25,
 *      "estado": "1",
 *      "duración": 20.5,
 *      "rango": "",
 *      "dientes": true,
 *      "banho": true,
 *      "peluqueria": true
 *  }
 * 
 * </pre>
 * 
 *
 * @author js.vacat
 */
public class AseoDetailDTO extends AseoDTO{
   
    private VeterinariaDTO veterinaria;
    
     /**
     * Constructor por defecto
     */
    public AseoDetailDTO() 
    {
        super();
    }
    
    /**
     * Constructor para transformar un Entity a un DTO
     * 
     * @param entity La entidad de aseo a partir de la cual se contruye el objeto
     */
    public AseoDetailDTO(AseoEntity entity) {
        super(entity);
        if(entity.getVeterinaria() != null){
            this.veterinaria = new VeterinariaDTO(entity.getVeterinaria());
        }
        else{
            entity.setVeterinaria(null);
        }
    }
    
    /**
     * Transformar un DTO a un entity
     * 
     * @return La entidad construida a partir del DTO
     */
    @Override
    public AseoEntity toEntity() {
        AseoEntity entity = super.toEntity();
        if(this.getVeterinaria() != null){
            entity.setVeterinaria(this.getVeterinaria().toEntity());
        }
        return entity;
    }

    /**
     * @return la veterinaria
     */
    public VeterinariaDTO getVeterinaria() {
        return veterinaria;
    }

    /**
     * @param veterinaria que entra por parametro
     */
    public void setVeterinaria(VeterinariaDTO veterinaria) {
        this.veterinaria = veterinaria;
    }
    
}