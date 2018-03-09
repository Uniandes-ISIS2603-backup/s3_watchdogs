/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.watchdogs.dtos;

import co.edu.uniandes.csw.watchdogs.entities.AseoEntity;
import co.edu.uniandes.csw.watchdogs.entities.EntrenamientoEntity;
import co.edu.uniandes.csw.watchdogs.entities.FacturaEntity;
import co.edu.uniandes.csw.watchdogs.entities.HotelEntity;
import co.edu.uniandes.csw.watchdogs.entities.PaseoEntity;
import co.edu.uniandes.csw.watchdogs.entities.PayPalEntity;
import co.edu.uniandes.csw.watchdogs.entities.PseEntity;
import co.edu.uniandes.csw.watchdogs.entities.TarjetaCreditoEntity;

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
 *      "pago": boolean,
 *      "cliente": {@link clienteDTO}
 *      "servicio": {@link servicioDTO}
 *      "metodoDepago": {@link metodoDepagoDTO}
 *   }
 * </pre
 * </pre>
 * Por ejemplo una factura con una Tarjeta de Crédito como Método de Pago y un aseo como servicio se representa asi:<br>
 * 
 * <pre>
 * 
 *   {
 *      "id": 1321321,
 *      "valor": 40000,
 *      "pago": true,
 *      "cliente": { "id": 123, "nombre": "Homero Thompson", "cedula": "1234567912" },
 *      "servicio": {"id": "1889", "fecha" : "10-10-2010","costo": 25 "estado": "1","duración": 20.5, "rango": "","dientes": true, "banho": true, "peluqueria": true}
 *      "metodoDepago": {"id": 91852,"numeroTarjeta": "1212124648794562","fechaVencimiento": "12/2020","codigoSeguridad": "456" }
 *   }
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
            if(entity.getServicio() != null){
                if(entity.getServicio().tipoClase(AseoEntity.class)){
                   servicio = new AseoDTO((AseoEntity)entity.getServicio());  
                }
                else if(entity.getServicio().tipoClase(EntrenamientoEntity.class)){
                   servicio = new EntrenamientoDTO((EntrenamientoEntity)entity.getServicio());  
                }
                else if(entity.getServicio().tipoClase(PaseoEntity.class)){
                   servicio = new PaseoDTO((PaseoEntity)entity.getServicio());  
                }
                else if(entity.getServicio().tipoClase(HotelEntity.class)){
                   servicio = new HotelDTO((HotelEntity)entity.getServicio());  
                }
            }else entity.setServicio(null);
            if(entity.getMetodoDePago() != null){
                if(entity.getMetodoDePago().getClass() == PseEntity.class){
                        metodoDePago = new PseDTO((PseEntity)entity.getMetodoDePago());
                }else if(entity.getMetodoDePago().getClass() == PayPalEntity.class){
                        metodoDePago = new PayPalDTO((PayPalEntity)entity.getMetodoDePago());
                }else if(entity.getMetodoDePago().getClass() == TarjetaCreditoEntity.class){
                        metodoDePago = new TarjetaCreditoDTO((TarjetaCreditoEntity)entity.getMetodoDePago());
                }
            }else entity.setMetodoDePago(null);
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
        if(servicio.getClass() == AseoDTO.class){
            rta.setServicio((AseoEntity)servicio.toEntity());
        } else if(servicio.getClass() == HotelDTO.class){
            rta.setServicio((HotelEntity)servicio.toEntity());
        } else if(servicio.getClass() == EntrenamientoDTO.class){
            rta.setServicio((EntrenamientoEntity)servicio.toEntity());
        } else if(servicio.getClass() == PaseoDTO.class){
            rta.setServicio((PaseoEntity)servicio.toEntity());
        }
        if(metodoDePago.getClass() == PayPalDTO.class){
            rta.setMetodoDePago((PayPalEntity) metodoDePago.toEntity());
        }else if(metodoDePago.getClass() == PseDTO.class){
            rta.setMetodoDePago((PseEntity) metodoDePago.toEntity());
        }else if(metodoDePago.getClass() == TarjetaCreditoDTO.class){
            rta.setMetodoDePago((TarjetaCreditoEntity) metodoDePago.toEntity());
        }
        return rta;
    }
   
    
    
    
}
