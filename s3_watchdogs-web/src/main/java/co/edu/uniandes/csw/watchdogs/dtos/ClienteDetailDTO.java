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
    private List<FacturaDTO> facturas;
    private CalificacionDTO calificacion;
    private List<ServicioDTO> servicios;
    private List<PayPalDTO> payPals;
    private List<PseDTO> pses;
    private List<TarjetaCreditoDTO> tarjetas;

    public List<PayPalDTO> getPayPals() {
        return payPals;
    }

    public void setPayPals(List<PayPalDTO> payPals) {
        this.payPals = payPals;
    }

    public List<PseDTO> getPses() {
        return pses;
    }

    public void setPses(List<PseDTO> pses) {
        this.pses = pses;
    }

    public List<TarjetaCreditoDTO> getTarjetas() {
        return tarjetas;
    }

    public void setTarjetas(List<TarjetaCreditoDTO> tarjetas) {
        this.tarjetas = tarjetas;
    }

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

            if (entity.getPayPals() != null) {
                for (int i = 0; i < entity.getPayPals().size(); i++) {
                    PayPalDTO old = new PayPalDTO(entity.getPayPals().get(i));
                    PayPalDTO nuevo = new PayPalDTO();
                    nuevo.setCorreo(old.getCorreo());
                    nuevo.setId(old.getId());
                    payPals.add(nuevo);
                }
            } else if (entity.getPses() != null) {
                for (int i = 0; i < entity.getPses().size(); i++) {
                    PseDTO old = new PseDTO(entity.getPses().get(i));
                    PseDTO nuevo = new PseDTO();
                    nuevo.setCorreo(old.getCorreo());
                    nuevo.setId(old.getId());
                    pses.add(nuevo);
                }
            } else if (entity.getTarjetas() != null) {
                for (int i = 0; i < entity.getTarjetas().size(); i++) {
                    TarjetaCreditoDTO old = new TarjetaCreditoDTO(entity.getTarjetas().get(i));
                    TarjetaCreditoDTO nuevo = new TarjetaCreditoDTO();
                    nuevo.setId(old.getId());
                    nuevo.setNumeroTarjeta(old.getNumeroTarjeta());
                    nuevo.setFechaVencimiento(old.getFechaVencimiento());
                    nuevo.setCodSeguridad(old.getCodSeguridad());
                    tarjetas.add(nuevo);
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
        List<PseEntity> agregarPse = new ArrayList<>();
        List<PayPalEntity> agregarPayPal = new ArrayList<>();
        List<TarjetaCreditoEntity> agregarTarjetas = new ArrayList<>();

        if (pses != null) {
            for (int i = 0; i < pses.size(); i++) {
                PseEntity nuevo = new PseEntity();
                PseDTO old = pses.get(i);
                nuevo.setCorreo(old.getCorreo());
                nuevo.setId(old.getId());
                nuevo.setName(old.getNombre());
                nuevo.setCliente(clienteE);
                agregarPse.add(nuevo);
            }
        }
        if (payPals != null) {
            for (int i = 0; i < payPals.size(); i++) {
                PayPalEntity nuevo = new PayPalEntity();
                PayPalDTO old = payPals.get(i);
                nuevo.setCorreo(old.getCorreo());
                nuevo.setId(old.getId());
                nuevo.setName(old.getNombre());
                nuevo.setCliente(clienteE);
                agregarPayPal.add(nuevo);
            }
        }
        if (tarjetas != null) {
            for (int i = 0; i < tarjetas.size(); i++) {
                TarjetaCreditoEntity nuevo = new TarjetaCreditoEntity();
                TarjetaCreditoDTO old = tarjetas.get(i);
                nuevo.setId(old.getId());
                nuevo.setNumeroTarjeta(old.getNumeroTarjeta());
                nuevo.setFechaVencimiento(old.getFechaVencimiento());
                nuevo.setCodigoSeguridad(old.getCodSeguridad());
                nuevo.setName(old.getNombre());
                nuevo.setCliente(clienteE);
                agregarTarjetas.add(nuevo);
            }
        }

        clienteE.setPses(agregarPse);
        clienteE.setPayPals(agregarPayPal);
        clienteE.setTarjetas(agregarTarjetas);

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
