/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.watchdogs.dtos;

import co.edu.uniandes.csw.watchdogs.entities.AseoEntity;
import co.edu.uniandes.csw.watchdogs.entities.ClienteEntity;
import co.edu.uniandes.csw.watchdogs.entities.EntrenamientoEntity;
import co.edu.uniandes.csw.watchdogs.entities.FacturaEntity;
import co.edu.uniandes.csw.watchdogs.entities.HotelEntity;
import co.edu.uniandes.csw.watchdogs.entities.MascotaEntity;
import co.edu.uniandes.csw.watchdogs.entities.MetodoDePagoEntity;
import co.edu.uniandes.csw.watchdogs.entities.PaseoEntity;
import co.edu.uniandes.csw.watchdogs.entities.PayPalEntity;
import co.edu.uniandes.csw.watchdogs.entities.PseEntity;
import co.edu.uniandes.csw.watchdogs.entities.ServicioEntity;
import co.edu.uniandes.csw.watchdogs.entities.TarjetaCreditoEntity;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que extiende de {link ClienteDTO} para manejar la transformacion entre
 * los objetos JSON y las Entidades de la base de datos. Para conocer el
 * contenido de la ciudad vaya a la documentacion de {@link ClienteDTO}
 *
 * Al serializarse como JSON esta clase implementa el siguiente modelo: <br>
 * <pre>
 *  {
 *      "id": number,
 *      "nombre": string,
 *      "cedula": string,
 *      "mascotas": [{@link MascotaDTO}],
 *      "metodosDePago": [{@link MetodoDePagoDTO}],
 *      "facturas": [{@link FacturaDTO}],
 *      "calificacion": {@link CalificacionDTO},
 *      "servicio": {@link ServicioDTO}
 *
 *  }
 * </pre>
 *
 * Por ejemplo un cliente se representa asi: <br>
 *
 * <pre>
 *
 *  {
 *      "id": 1,
 *      "nombre": "Camilo Beltran",
 *      "cedula": "1020123456",
 *      "mascotas": [
 *          {
 *              "id": 1,
 *              "nombre": negra,
 *              "raza": criolla,
 *              "color": negro,
 *              "sexo": femenino
 *          }
 *      ],
 *      "metodosDePago": [
 *          {
 *              "id": 1,
 *              "correo: abc@hotmail.com,
 *              "contrasenha": abc123
 *          },
 *          {
 *              "id": 1,
 *              "correo: abc@hotmail.com
 *          },
 *          {
 *              "id": 1,
 *              "numeroTarjeta: 451012345678,
 *              "fechaVencimiento": 08/2050,
 *              "codigoSeguridad": 123
 *          }
 *      ],
 *      "facturas": [
 *          {
 *              "id": 1,
 *              "valor": 100000,
 *              "pago": true
 *          }
 *      ],
 *      "calificacion": {
 *          "id": 1,
 *          "puntaje": 10
 *      },
 *      "servicio": {
 *          "id": 1,
 *          "fecha: 01/01/2020,
 *          "costo": 10000,
 *          "estado": true,
 *          "duración": 10,
 *          "rango": a'
 *          "dientes": true,
 *          "banho": true,
 *          "peluqueria": true
 *      }
 *  }
 *
 * </pre>
 *
 * @author ca.beltran10
 */
public class ClienteDetailDTO extends ClienteDTO {

    private List<MascotaDTO> mascotas;
    private List<MetodoDePagoDTO> metodosDePago;
    private List<FacturaDTO> facturas;
    private CalificacionDTO calificacion;
    private List<ServicioDTO> servicios;

    /**
     * Constructor por defecto
     */
    public ClienteDetailDTO() {
        
    }

    /**
     * Constructor para transformar un Entity a un DTO
     *
     * @param entity La entidad de cliente a partir de la cual se contruye el
     * objeto
     */
    public ClienteDetailDTO(ClienteEntity entity) {
        super(entity);
        if (entity != null) {
            mascotas = new ArrayList<>();
            for (MascotaEntity entityMascotas : entity.getMascotas()) {
                mascotas.add(new MascotaDTO(entityMascotas));
            }
            metodosDePago = new ArrayList<>();
            if (entity.getMetodosDePago() != null) {

                for (MetodoDePagoEntity entityMetodosDePago : entity.getMetodosDePago()) {
                    if (entityMetodosDePago.getClass().equals(PseEntity.class)) {
                        PseDTO nuevo = new PseDTO();
                        nuevo.setAprobado(entityMetodosDePago.getAprobado());
                        nuevo.setCorreo(((PseEntity) entityMetodosDePago).getCorreo());
                        nuevo.setId(entityMetodosDePago.getId());
                        metodosDePago.add(nuevo);
                    } else if (entityMetodosDePago.getClass().equals(TarjetaCreditoEntity.class)) {
                        TarjetaCreditoDTO nuevo = new TarjetaCreditoDTO();
                        nuevo.setId(entityMetodosDePago.getId());
                        nuevo.setAprobado(entityMetodosDePago.getAprobado());
                        nuevo.setCodSeguridad(((TarjetaCreditoEntity) entityMetodosDePago).getCodigoSeguridad());
                        nuevo.setFechaVencimiento(((TarjetaCreditoEntity) entityMetodosDePago).getFechaVencimiento());
                        nuevo.setNumTarjeta(((TarjetaCreditoEntity) entityMetodosDePago).getNumeroTarjeta());
                        metodosDePago.add(nuevo);
                    } else if (entityMetodosDePago.getClass().equals(PayPalEntity.class)) {
                        PayPalDTO nuevo = new PayPalDTO();
                        nuevo.setAprobado(entityMetodosDePago.getAprobado());
                        nuevo.setCorreo(((PayPalEntity) entityMetodosDePago).getCorreo());
                        nuevo.setId(entityMetodosDePago.getId());
                        metodosDePago.add(nuevo);
                    }
                }
            }
            facturas = new ArrayList<>();
            for (FacturaEntity entityFacturas : entity.getFacturas()) {
                facturas.add(new FacturaDTO(entityFacturas));
            }
            calificacion = new CalificacionDTO();
            if (entity.getCalificacion() != null) {
                calificacion.setId(entity.getCalificacion().getId());
                calificacion.setPuntaje(entity.getCalificacion().getPuntaje());
            }
            servicios = new ArrayList<>();
            if (entity.getServicios() != null) {
                for (ServicioEntity entityServicio : entity.getServicios()) {
                    if (entityServicio.getClass().equals(AseoEntity.class)) {
                        AseoDTO servicio = new AseoDTO();
                        servicio.setId(entityServicio.getId());
                        servicio.setFecha(entityServicio.getFecha());
                        servicio.setCosto(entityServicio.getCosto());
                        servicio.setEstado(entityServicio.isEstado());
                        servicio.setRango(entityServicio.getRango());
                        servicio.setDuracion(entityServicio.getDuracion());
                        ((AseoDTO) servicio).setDientes(((AseoEntity) entityServicio).getDientes());
                        ((AseoDTO) servicio).setBanho(((AseoEntity) entityServicio).getBanho());
                        ((AseoDTO) servicio).setPeluqueria(((AseoEntity) entityServicio).getPeluqueria());
                        servicios.add(servicio);
                    } else if (entityServicio.getClass().equals(PaseoEntity.class)) {
                        PaseoDTO servicio = new PaseoDTO();
                        servicio.setId(entityServicio.getId());
                        servicio.setFecha(entityServicio.getFecha());
                        servicio.setCosto(entityServicio.getCosto());
                        servicio.setEstado(entityServicio.isEstado());
                        servicio.setRango(entityServicio.getRango());
                        servicio.setDuracion(entityServicio.getDuracion());
                        ((PaseoDTO) servicio).setCapMax(((PaseoEntity) entityServicio).getCapMax());
                        ((PaseoDTO) servicio).setHoras(((PaseoEntity) entityServicio).getHoras());
                        servicios.add(servicio);
                    } else if (entityServicio.getClass().equals(HotelEntity.class)) {
                        HotelDTO servicio = new HotelDTO();
                        servicio.setId(entityServicio.getId());
                        servicio.setFecha(entityServicio.getFecha());
                        servicio.setCosto(entityServicio.getCosto());
                        servicio.setEstado(entityServicio.isEstado());
                        servicio.setRango(entityServicio.getRango());
                        servicio.setDuracion(entityServicio.getDuracion());
                        ((HotelDTO) servicio).setTiempoHospedaje(((HotelEntity) entityServicio).getTiempoHospedaje());
                        servicios.add(servicio);
                    } else if (entityServicio.getClass().equals(EntrenamientoEntity.class)) {
                        EntrenamientoDTO servicio = new EntrenamientoDTO();
                        servicio.setId(entityServicio.getId());
                        servicio.setFecha(entityServicio.getFecha());
                        servicio.setCosto(entityServicio.getCosto());
                        servicio.setEstado(entityServicio.isEstado());
                        servicio.setRango(entityServicio.getRango());
                        servicio.setDuracion(entityServicio.getDuracion());
                        ((EntrenamientoDTO) servicio).setTipo(((EntrenamientoEntity) entityServicio).getTipo());
                        servicios.add(servicio);
                    }
                }
            }

        }
    }

    /**
     * Transformar un DTO a un entity
     *
     * @return La entidad construida a partir del DTO
     */
    @Override
    public ClienteEntity toEntity() {
        ClienteEntity clienteE = super.toEntity();
        if (mascotas != null) {
            List<MascotaEntity> mascotasEntity = new ArrayList<>();
            for (MascotaDTO dtoMascota : mascotas) {
                mascotasEntity.add(dtoMascota.toEntity());
            }
            clienteE.setMascotas(mascotasEntity);
        }
        if (metodosDePago != null) {
            List<MetodoDePagoEntity> metodosDePagoEntity = new ArrayList<>();
            for (MetodoDePagoDTO dtoMetodoDePago : metodosDePago) {
                if (dtoMetodoDePago.getClass().equals(PseDTO.class)) {
                    PseEntity nuevo = new PseEntity();
                    nuevo.setAprobado(dtoMetodoDePago.getAprobado());
                    nuevo.setCorreo(((PseDTO) dtoMetodoDePago).getCorreo());
                    nuevo.setId(dtoMetodoDePago.getId());
                    metodosDePagoEntity.add(nuevo);
                }
                else if (dtoMetodoDePago.getClass().equals(TarjetaCreditoDTO.class)) {
                    TarjetaCreditoEntity nuevo = new TarjetaCreditoEntity();
                    nuevo.setId(dtoMetodoDePago.getId());
                    nuevo.setAprobado(dtoMetodoDePago.getAprobado());
                    nuevo.setFechaVencimiento(((TarjetaCreditoDTO) dtoMetodoDePago).getFechaVencimiento());
                    nuevo.setNumeroTarjeta(((TarjetaCreditoDTO) dtoMetodoDePago).getNumTarjeta());
                    metodosDePagoEntity.add(nuevo);
                }
                else if (dtoMetodoDePago.getClass().equals(PayPalDTO.class)) {
                    PayPalEntity nuevo = new PayPalEntity();
                    nuevo.setAprobado(dtoMetodoDePago.getAprobado());
                    nuevo.setCorreo(((PayPalDTO) dtoMetodoDePago).getCorreo());
                    nuevo.setId(dtoMetodoDePago.getId());
                    metodosDePagoEntity.add(nuevo);
                }
            }
            clienteE.setMetodosDePago(metodosDePagoEntity);
        }
        if (facturas != null) {
            List<FacturaEntity> facturasEntity = new ArrayList<>();
            for (FacturaDTO dtoFactura : facturas) {
                facturasEntity.add(dtoFactura.toEntity());
            }
            clienteE.setFacturas(facturasEntity);
        }
        if (calificacion != null) {
            clienteE.setCalificacion(calificacion.toEntity());
        }
        if (servicios != null) {
            List<ServicioEntity> serviciosEntity = new ArrayList<>();
            for (ServicioDTO dtoServicio : servicios) {
                if (dtoServicio.getClass().equals(AseoDTO.class)) {
                    AseoEntity nuevo = new AseoEntity();
                    nuevo.setId(dtoServicio.getId());
                    nuevo.setFecha(dtoServicio.getFecha());
                    nuevo.setCosto(dtoServicio.getCosto());
                    nuevo.setEstado(dtoServicio.isEstado());
                    nuevo.setRango(dtoServicio.getRango());
                    nuevo.setDuracion(dtoServicio.getDuracion());
                    ((AseoEntity) nuevo).setDientes(((AseoDTO) dtoServicio).getDientes());
                    ((AseoEntity) nuevo).setBanho(((AseoDTO) dtoServicio).getBanho());
                    ((AseoEntity) nuevo).setPeluqueria(((AseoDTO) dtoServicio).getPeluqueria());
                    serviciosEntity.add(nuevo);
                } else if (dtoServicio.getClass().equals(PaseoDTO.class)) {
                    PaseoEntity nuevo = new PaseoEntity();
                    nuevo.setId(dtoServicio.getId());
                    nuevo.setFecha(dtoServicio.getFecha());
                    nuevo.setCosto(dtoServicio.getCosto());
                    nuevo.setEstado(dtoServicio.isEstado());
                    nuevo.setRango(dtoServicio.getRango());
                    nuevo.setDuracion(dtoServicio.getDuracion());
                    ((PaseoEntity) nuevo).setCapMax(((PaseoDTO) dtoServicio).getCapMax());
                    ((PaseoEntity) nuevo).setHoras(((PaseoDTO) dtoServicio).getHoras());
                    serviciosEntity.add(nuevo);
                } else if (dtoServicio.getClass().equals(HotelDTO.class)) {
                    HotelEntity nuevo = new HotelEntity();
                    nuevo.setId(dtoServicio.getId());
                    nuevo.setFecha(dtoServicio.getFecha());
                    nuevo.setCosto(dtoServicio.getCosto());
                    nuevo.setEstado(dtoServicio.isEstado());
                    nuevo.setRango(dtoServicio.getRango());
                    nuevo.setDuracion(dtoServicio.getDuracion());
                    ((HotelEntity) nuevo).setTiempoHospedaje(((HotelDTO) dtoServicio).getTiempoHospedaje());
                    serviciosEntity.add(nuevo);
                } else if (dtoServicio.getClass().equals(EntrenamientoDTO.class)) {
                    EntrenamientoEntity nuevo = new EntrenamientoEntity();
                    nuevo.setId(dtoServicio.getId());
                    nuevo.setFecha(dtoServicio.getFecha());
                    nuevo.setCosto(dtoServicio.getCosto());
                    nuevo.setEstado(dtoServicio.isEstado());
                    nuevo.setRango(dtoServicio.getRango());
                    nuevo.setDuracion(dtoServicio.getDuracion());
                    ((EntrenamientoEntity) nuevo).setTipo(((EntrenamientoDTO) dtoServicio).getTipo());
                    serviciosEntity.add(nuevo);
                }
            }
            clienteE.setServicios(serviciosEntity);
        }
        return clienteE;
    }

    /**
     * @return the mascotas
     */
    public List<MascotaDTO> getMascotas() {
        return mascotas;
    }

    /**
     * @param mascotas the mascotas to set
     */
    public void setMascotas(List<MascotaDTO> mascotas) {
        this.mascotas = mascotas;
    }

    /**
     * @return the metodosDePago
     */
    public List<MetodoDePagoDTO> getMetodosDePago() {
        return metodosDePago;
    }

    /**
     * @param metodosDePago the metodosDePago to set
     */
    public void setMetodosDePago(List<MetodoDePagoDTO> metodosDePago) {
        this.metodosDePago = metodosDePago;
    }

    /**
     * @return the factura
     */
    public List<FacturaDTO> getFacturas() {
        return facturas;
    }

    /**
     * @param factura the factura to set
     */
    public void setFacturas(List<FacturaDTO> factura) {
        this.facturas = factura;
    }

    /**
     * @return the calificacion
     */
    public CalificacionDTO getCalificacion() {
        return calificacion;
    }

    /**
     * @param calificacion the calificacion to set
     */
    public void setCalificacion(CalificacionDTO calificacion) {
        this.calificacion = calificacion;
    }

    /**
     * @return the servicios
     */
    public List<ServicioDTO> getServicios() {
        return servicios;
    }

    /**
     * @param servicios the servicios to set
     */
    public void setServicios(List<ServicioDTO> servicios) {
        this.servicios = servicios;
    }

}
