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
import java.util.List;

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
 * </pre> Por ejemplo una factura con una Tarjeta de Crédito como Método de Pago
 * y un aseo como servicio se representa asi:<br>
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
 *
 * @author id.salazar
 */
public class FacturaDetailDTO extends FacturaDTO {

    /**
     *Cliente asociado a la factura 
     */
     
    private ClienteDTO cliente;

    /**
     * Servicio asociado a la factura
     */
    private ServicioDTO servicio;

    /**
     * Posible Paypal asociado a la factura
     */
    private PayPalDTO payPal;
    
    /**
     * Posible PSE asociado a la factura
     */
    private PseDTO pse;
    
    /**
     * Posible Tyarjeta asociada a la factura
     */
    private TarjetaCreditoDTO tarjeta;

    /**
     * Constructor por defecto
     */
    public FacturaDetailDTO() {
        super();
    }
    
     /**
     * Constructor para transformar un Entity a un DTO
     *
     * @param entity La entidad de la mascota a partir de la cual se construye
     * el objeto
     */
    public FacturaDetailDTO(FacturaEntity entity) {
        super(entity);
        if (entity != null) {
            if (entity.getCliente() != null) {
                cliente = new ClienteDTO(entity.getCliente());
            } else {
                entity.setCliente(null);
            }
            if (entity.getServicio() != null) {
                if (entity.getServicio().tipoClase(AseoEntity.class)) {
                    servicio = new AseoDTO((AseoEntity) entity.getServicio());
                } else if (entity.getServicio().tipoClase(EntrenamientoEntity.class)) {
                    servicio = new EntrenamientoDTO((EntrenamientoEntity) entity.getServicio());
                } else if (entity.getServicio().tipoClase(PaseoEntity.class)) {
                    servicio = new PaseoDTO((PaseoEntity) entity.getServicio());
                } else if (entity.getServicio().tipoClase(HotelEntity.class)) {
                    servicio = new HotelDTO((HotelEntity) entity.getServicio());
                }

                if (entity.getPayPal() != null) {
                    payPal = new PayPalDTO(entity.getPayPal());
                } else if (entity.getPse() != null) {
                    pse = new PseDTO(entity.getPse());
                } else if (entity.getTarjeta() != null) {
                    tarjeta = new TarjetaCreditoDTO(entity.getTarjeta());
                }
            }
        }
    }

    /**
     * @return the Paypal
     */
    public PayPalDTO getPayPal() {
        return payPal;
    }

    /**
     * @param payPal the paypal to set
     */
    public void setPayPal(PayPalDTO payPal) {
        this.payPal = payPal;
    }

    
    /**
     * @return the pse
     */
    public PseDTO getPse() {
        return pse;
    }

    /**
     * @param pse the pse to set
     */
    public void setPse(PseDTO pse) {
        this.pse = pse;
    }

    /**
     * @return the tarjeta de credito
     */
    public TarjetaCreditoDTO getTarjeta() {
        return tarjeta;
    }
    
    /**
     * @param tarjeta the tarjeta to set
     */
    public void setTarjeta(TarjetaCreditoDTO tarjeta) {
        this.tarjeta = tarjeta;
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
     * Metodo que pasa de un DTO a un Entity
     * @return la entidad creada
     */

    @Override
    public FacturaEntity toEntity() {
        FacturaEntity rta = super.toEntity();
        rta.setCliente(cliente.toEntity());
        if (servicio != null) {
            if (servicio.getClass().equals(AseoDTO.class)) {
                rta.setServicio((AseoEntity) servicio.toEntity());
            } else if (servicio.getClass().equals(HotelDTO.class)) {
                rta.setServicio((HotelEntity) servicio.toEntity());
            } else if (servicio.getClass().equals(EntrenamientoDTO.class)) {
                rta.setServicio((EntrenamientoEntity) servicio.toEntity());
            } else if (servicio.getClass().equals(PaseoDTO.class)) {
                rta.setServicio((PaseoEntity) servicio.toEntity());
            }
        }

        if (payPal != null) {
            rta.setPayPal(payPal.toEntity());
        } else if (pse != null) {
            rta.setPse(pse.toEntity());
        } else if (tarjeta != null) {
            rta.setTarjeta(tarjeta.toEntity());
        }
        return rta;
    }

}
