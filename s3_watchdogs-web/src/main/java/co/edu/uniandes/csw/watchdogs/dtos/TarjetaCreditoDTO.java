/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.watchdogs.dtos;

import co.edu.uniandes.csw.watchdogs.entities.TarjetaCreditoEntity;
import java.util.Date;

/**
 * TarjetaCreditoDTO Objeto de transferencia de datos de las tarjetas de
 * crédito. Los DTO contienen las represnetaciones de los JSON que se
 * transfieren entre el cliente y el servidor.
 *
 * Al serializarse como JSON esta clase implementa el siguiente modelo: <br>
 * <pre>
 *   {
 *      "numeroTarjeta": string,
 *      "fechaVencimiento": string,
 *      "codigoSeguridad": String
 *   }
 * </pre> Por ejemplo una tarjeta se representa asi:<br>
 *
 * <pre>
 *
 *   {
 *      "numeroTarjeta": "1212124648794562",
 *      "fechaVencimiento": "12/2020"
 *      "codigoSeguridad": "456"
 *   }
 *
 * /**
 *
 * @author jc.pulido
 */
public class TarjetaCreditoDTO {

    /**
     * Id de la tarjeta
     */
    private Long id;

    /**
     * Nombre del tipo de método de pago
     */
    private String nombre;

    /**
     * Numero de la tarjeta
     */
    private String numeroTarjeta;

    /**
     * Fecha de vencimiento de la tarjeta
     */
    private Date fechaVencimiento;

    /**
     * Código de seguridad de la tarjeta
     */
    private String codigoSeguridad;

    /**
     * Constructor por defecto
     */
    public TarjetaCreditoDTO() {
        super();
    }

    /**
     * Constructor que recibe un entity
     *
     * @param entity
     */
    public TarjetaCreditoDTO(TarjetaCreditoEntity entity) {
        if (entity != null) {
            id = entity.getId();
            nombre = "Tarjeta de Credito";
            numeroTarjeta = entity.getNumeroTarjeta();
            fechaVencimiento = entity.getFechaVencimiento();
            codigoSeguridad = entity.getCodigoSeguridad();
        }
    }

    /**
     * Metodo que pasa de un DTO a un Entity
     *
     * @return la entidad creada
     */
    public TarjetaCreditoEntity toEntity() {
        TarjetaCreditoEntity entity = new TarjetaCreditoEntity();
        entity.setCodigoSeguridad(this.codigoSeguridad);
        entity.setFechaVencimiento(this.fechaVencimiento);
        entity.setNumeroTarjeta(this.numeroTarjeta);
        entity.setName(this.nombre);
        entity.setId(this.id);
        return entity;
    }

    /**
     *
     * @param nombre el nuevo nombre de este metodo de pago
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     *
     * @return el nombre del metodo de pago
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Método que retorna el id asociado al DTO
     *
     * @return El id asociado al DTO
     */
    public Long getId() {
        return id;
    }

    /**
     * Método que asigna un nuevo id
     *
     * @param pId el id a asignar
     */
    public void setId(Long pId) {
        id = pId;
    }

    /**
     *
     * @return Número de la tarjeta
     */
    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    /**
     *
     * @param numeroTarjeta Número de tarjeta nuevo a asignar
     */
    public void setNumeroTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    /**
     *
     * @return Fecha de vencimiento de la tarjeta
     */
    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    /**
     *
     * @param fecha Nueva fecha a asignar
     */
    public void setFechaVencimiento(Date fecha) {
        this.fechaVencimiento = fecha;
    }

    /**
     *
     * @return Código de seguridad de la tarjeta de crédito
     */
    public String getCodSeguridad() {
        return codigoSeguridad;
    }

    /**
     *
     * @param cod Código de seguridad nuevo a asignar
     */
    public void setCodSeguridad(String cod) {
        this.codigoSeguridad = cod;
    }

}
