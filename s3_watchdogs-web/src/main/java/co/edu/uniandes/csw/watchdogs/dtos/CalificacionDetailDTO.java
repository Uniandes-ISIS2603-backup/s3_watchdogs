/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.watchdogs.dtos;

import co.edu.uniandes.csw.watchdogs.entities.CalificacionEntity;

/**
 *
 * @author c.martinezc1
 */
public class CalificacionDetailDTO extends CalificacionDTO {

    private ClienteDTO cliente;

    public CalificacionDetailDTO(CalificacionEntity entity) {
        super(entity);
        if (entity != null) {
            if (entity.getCliente() != null) {
                cliente = new ClienteDTO(entity.getCliente());
            }
        }
    }

    public CalificacionDetailDTO() {
        super();

    }

    public ClienteDTO getCliente() {
        return cliente;
    }

    public void setCliente(ClienteDTO cliente) {
        this.cliente = cliente;
    }

    @Override
    public CalificacionEntity toEntity() {
        CalificacionEntity entity = super.toEntity();
        if(this.cliente!=null){
            entity.setCliente(cliente.toEntity());
        }
        return entity;
    }

}
