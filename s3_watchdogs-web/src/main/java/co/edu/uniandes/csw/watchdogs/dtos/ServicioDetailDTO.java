/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.watchdogs.dtos;

import co.edu.uniandes.csw.watchdogs.entities.ServicioEntity;

/**
 *
 * @author c.martinezc1
 */
public class ServicioDetailDTO extends ServicioDTO {

    protected MascotaDTO mascota;

    protected ClienteDTO cliente;

    protected FacturaDTO factura;

    protected CalificacionDTO calificacion;

    protected EmpleadoDTO empleado;

    /**
     * Constructor por defecto
     */
    public ServicioDetailDTO() {
        super();
    }

    /**
     *
     * @param entity
     */
    public ServicioDetailDTO(ServicioEntity entity) {
        super(entity);
        if (entity.getCalificacion() != null) {
            this.calificacion = new CalificacionDTO(entity.getCalificacion());
        } else {
            calificacion = null;
        }

        if (entity.getMascota() != null) {
            this.mascota = new MascotaDTO(entity.getMascota());
        } else {
            mascota = null;
        }

        if (entity.getCliente() != null) {
            this.cliente = new ClienteDTO(entity.getCliente());
        } else {
            cliente = null;
        }

        if (entity.getFactura() != null) {
            this.factura = new FacturaDTO(entity.getFactura());
        } else {
            factura = null;
        }

        if (entity.getEmpleado() != null) {
            this.empleado = new EmpleadoDTO(entity.getEmpleado());
        } else {
            empleado = null;
        }

    }

    public MascotaDTO getMascota() {
        return mascota;
    }

    public void setMascota(MascotaDTO mascota) {
        this.mascota = mascota;
    }

    public ClienteDTO getCliente() {
        return cliente;
    }

    public void setCliente(ClienteDTO cliente) {
        this.cliente = cliente;
    }

    public FacturaDTO getFactura() {
        return factura;
    }

    public void setFactura(FacturaDTO factura) {
        this.factura = factura;
    }

    public CalificacionDTO getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(CalificacionDTO calificacion) {
        this.calificacion = calificacion;
    }

    public EmpleadoDTO getEmpleado() {
        return empleado;
    }

    public void setEmpleado(EmpleadoDTO empleado) {
        this.empleado = empleado;
    }

    @Override
    public ServicioEntity toEntity() {
        ServicioEntity servicio = super.toEntity();
        if (this.calificacion != null) {
            servicio.setCalificacion(calificacion.toEntity());
        }
        if (this.cliente != null) {
            servicio.setCliente(cliente.toEntity());
        }
        if (this.empleado != null) {
            servicio.setEmpleado(empleado.toEntity());
        }
        if (this.factura != null) {
            servicio.setFactura(factura.toEntity());
        }
        if (this.mascota != null) {
            servicio.setMascota(mascota.toEntity());
        }
        return servicio;
    }
}
