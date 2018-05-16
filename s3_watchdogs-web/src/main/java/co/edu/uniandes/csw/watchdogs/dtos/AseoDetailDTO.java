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
public class AseoDetailDTO extends ServicioDetailDTO{
   
    /**
     * Representa la veterinaria a la cual se encuentra relacionada
     */
    private VeterinariaDTO veterinaria;
    
    /**
     * Representa si el Aseo incluye servicio de dientes
     */
    private Boolean dientes;
    
    /**
     * Representa si el Aseo incluye servicio de baño
     */
    private Boolean banho;
    
    /**
     * Representa si el Aseo incluye servicio de peluquería
     */
    private Boolean peluqueria;
    
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
        this.banho = entity.getBanho();
        this.dientes = entity.getDientes();
        this.peluqueria = entity.getPeluqueria();
        
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
        AseoEntity entity = new AseoEntity();
        entity.setBanho(this.banho);
        entity.setDientes(this.dientes);
        entity.setPeluqueria(this.peluqueria);
        entity.setCosto(this.getCosto());
        entity.setDuracion(this.getDuracion());
        entity.setEstado(this.isEstado());
        entity.setFecha(this.getFecha());
        entity.setRango(this.getRango());
        entity.setId(this.id);
        if(this.cliente!=null){
            entity.setCliente(cliente.toEntity());
        }
        if(this.mascota!=null){
            entity.setMascota(mascota.toEntity());
        }
        if(this.empleado!=null){
            entity.setEmpleado(empleado.toEntity());
        }
        if(this.factura!=null){
            entity.setFactura(factura.toEntity());
        }
        if(this.calificacion!=null){
            entity.setCalificacion(calificacion.toEntity());
        }
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
    
    /**
     * @return El servico de dientes
     */
    public Boolean getDientes() {
        return dientes;
    }

    /**
     * @param dientes El nuevo Servico de dientes
     */
    public void setDientes(Boolean dientes) {
        this.dientes = dientes;
    }

    /**
     * @return El servicio de banho
     */
    public Boolean getBanho() {
        return banho;
    }

    /**
     * @param banho El nuevo Servico de banho
     */
    public void setBanho(Boolean banho) {
        this.banho = banho;
    }

    /**
     * @return El Servicio de peluqueria
     */
    public Boolean getPeluqueria() {
        return peluqueria;
    }

    /**
     * @param peluqueria El nuevo Servico de peluqueria
     */
    public void setPeluqueria(Boolean peluqueria) {
        this.peluqueria = peluqueria;
    }
}