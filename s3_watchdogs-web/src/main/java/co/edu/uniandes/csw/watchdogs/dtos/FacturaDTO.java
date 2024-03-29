/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.watchdogs.dtos;

import co.edu.uniandes.csw.watchdogs.entities.FacturaEntity;

/**
 * FacturaDTO Objeto de transferencia de datos de Watchdogs. Los DTO contienen
 * las represnetaciones de los JSON que se transfieren entre el cliente y el
 * servidor.
 *
 * Al serializarse como JSON esta clase implementa el siguiente modelo: <br>
 * <pre>
 *   {
 *      "id": number,
 *      "valor": number,
 *      "pago": boolean
 *   }
 * </pre> Por ejemplo una ciudad se representa asi:<br>
 *
 * <pre>
 *
 *   {
 *      "id": 1321321,
 *      "valor": 40000,
 *      "pago": true
 *   }
 *
 * </pre>
 *
 * @author id.salazar
 */
public class FacturaDTO {

    /**
     * id de la factura
     */
    private Long id;

    /**
     * valor de la factura
     */
    private Double valor;

    /**
     * estado de pagado de la factura
     */
    private Boolean pagado;

    /**
     * Constructor por defecto
     */
    public FacturaDTO() {
        super();
    }

    /**
     * Constructor que recibe un entity
     *
     * @param entity
     */
    public FacturaDTO(FacturaEntity entity) {
        if (entity != null) {
            this.id = entity.getId();
            this.valor = entity.getValor();
            this.pagado = entity.getPagado();
        }
    }

    /**
     *
     * @return El id de la factura
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id El nuevo id de la factura
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     *
     * @return El valor de la factura
     */
    public Double getValor() {
        return valor;
    }

    /**
     * @param valor El nuevo valor de la factura
     */
    public void setValor(Double valor) {
        this.valor = valor;
    }

    /**
     *
     * @return El estatus de pago de la factura
     */
    public Boolean getPagado() {
        return pagado;
    }

    /**
     * @param pagado El nuevo estado de pago
     */
    public void setPagado(Boolean pagado) {
        this.pagado = pagado;
    }

    /**
     * Metodo que pasa de un DTO a un Entity
     *
     * @return la entidad creada
     */
    public FacturaEntity toEntity() {
        FacturaEntity entity = new FacturaEntity();
        entity.setId(id);
        entity.setPagado(pagado);
        entity.setValor(valor);
        return entity;
    }

}
