/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.watchdogs.dtos;

import co.edu.uniandes.csw.watchdogs.entities.FacturaEntity;

/**
 * Clase que extiende de {@link FacturaDTO} para manejar la transformacion entre
 * los objetos JSON y las Entidades de la base de datos. Para conocer el
 * contenido de la ciudad vaya a la documentacion de {@link FacturaDTO}
 * 
 * Al serializarse como JSON esta clase implementa el siguiente modelo: <br>
 * <pre>
 *   {
 *      "id": number,
 *      "valor": number,
 *      "pago": boolean
 *      "cliente": {@link cliente DTO} 
 *   }
 * </pre
 * </pre>
 * Por ejemplo un libro se representa asi:<br>
 * 
 * <pre>
 * 
 *   {
 *      ""id": 1321321,
 *      "valor": 40000,
 *      "pago": true
 *      "cliente": { "nombre": "Homero Thompson", "cedula": "1234567912" },
 *      "servicio": 
 *
 *   }
 *
 * </pre>
 * @author id.salazar
 */
public class FacturaDetailDTO extends FacturaDTO{
    
    private ClienteDTO cliente;
    
    private ServicioDTO servicio;
    
    private MetodoDePagoDTO metodoDePago;
     
    
     /**
     * Constructor por defecto
     */
    
    public FacturaDetailDTO(){
        super();
    }
    
    public FacturaDetailDTO(FacturaEntity entity){
        super(entity);
        if(entity != null){
            if(entity.getCliente() != null){
                cliente = new ClienteDTO(entity.getCliente());
            }else entity.setCliente(null);
            /*if(entity.Servicio() != null){
               servicio = new ServicioDTO(entity.getServicio()); 
            }else entity.setServicio(null);
            if(entity.getMetodoDePago() != null){
                metodoDePago = new MetodoDePagoDTO(entity.getMetodoDePago);
            }else entity.setMetodoDePago(null);*/
        }
    }

    /**
     * @return the cliente
     */
    public ClienteDTO getCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(ClienteDTO cliente) {
        this.cliente = cliente;
    }

    /**
     * @return the servicio
     */
    public ServicioDTO getServicio() {
        return servicio;
    }

    /**
     * @param servicio the servicio to set
     */
    public void setServicio(ServicioDTO servicio) {
        this.servicio = servicio;
    }

    /**
     * @return the metodoDePago
     */
    public MetodoDePagoDTO getMetodoDePago() {
        return metodoDePago;
    }

    /**
     * @param metodoDePago the metodoDePago to set
     */
    public void setMetodoDePago(MetodoDePagoDTO metodoDePago) {
        this.metodoDePago = metodoDePago;
    }
    
    @Override
    public FacturaEntity toEntity(){
        FacturaEntity rta = super.toEntity();
        rta.setCliente(cliente.toEntity());
        //rta.setServicio(servicio.toEntity());
        //rta.setMetodoDePago(MetodoDePago.toEntity());
        //TODO VAlidacion clases abstractas
        return rta;
    }
   
    
    
    
}
