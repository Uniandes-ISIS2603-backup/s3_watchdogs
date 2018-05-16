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

    /**
     * Lista de mascotas del cliente
     */
    private List<MascotaDTO> mascotas;
    
    /**
     * Lista de facturas del cliente
     */
    private List<FacturaDTO> facturas;
    
    /**
     * Lista de calificaciones del cliente
     */
    private CalificacionDTO calificacion;
    
    /**
     * Lista de servicios del cliente
     */
    private List<ServicioDTO> servicios;
    
    /**
     * Lista de Paypals del cliente
     */
    private List<PayPalDTO> payPals;
    
    /**
     * Lista de PSEs del cliente
     */
    private List<PseDTO> pses;
    
    /**
     * Lista de Tarjetas de crédito del cliente
     */
    private List<TarjetaCreditoDTO> tarjetas;

    /**
     * Constructor por defecto
     */
    public ClienteDetailDTO() {
        super();
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

            payPals = new ArrayList<>();
            if (entity.getPayPals() != null) {
                for (int i = 0; i < entity.getPayPals().size(); i++) {
                    payPals.add(new PayPalDTO(entity.getPayPals().get(i)));
                }
            }

            pses = new ArrayList<>();
            if (entity.getPses() != null) {
                for (int i = 0; i < entity.getPses().size(); i++) {
                    pses.add(new PseDTO(entity.getPses().get(i)));
                }
            }

            tarjetas = new ArrayList<>();
            if (entity.getTarjetas() != null) {
                for (int i = 0; i < entity.getTarjetas().size(); i++) {
                    tarjetas.add(new TarjetaCreditoDTO(entity.getTarjetas().get(i)));
                }
            }

            facturas = new ArrayList<>();
            for (FacturaEntity entityFacturas : entity.getFacturas()) {
                facturas.add(new FacturaDTO(entityFacturas));
            }
            calificacion = new CalificacionDTO(entity.getCalificacion());
            servicios = new ArrayList<>();
            if (entity.getServicios() != null) {
                llenarServicios(entity.getServicios());
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

        if (pses != null) {
            List<PseEntity> pseEntity = new ArrayList<>();
            for (PseDTO dtoPse : pses) {
                pseEntity.add(dtoPse.toEntity());
            }
            clienteE.setPses(pseEntity);
        }
        if (payPals != null) {
            List<PayPalEntity> payPalEntity = new ArrayList<>();
            for (PayPalDTO dtoPaypal : payPals) {
                payPalEntity.add(dtoPaypal.toEntity());
            }
            clienteE.setPayPals(payPalEntity);
        }
        if (tarjetas != null) {
            List<TarjetaCreditoEntity> tarjetasEntity = new ArrayList<>();
            for (TarjetaCreditoDTO dtoTarjeta : tarjetas) {
                tarjetasEntity.add(dtoTarjeta.toEntity());
            }
            clienteE.setTarjetas(tarjetasEntity);
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
    
        
    /**
     * @return Lista de Paypals del cliente
     */
    public List<PayPalDTO> getPayPals() {
        return payPals;
    }
    
    /**
     * @param payPals Nueva lista de Paypals del cliente
     */
    public void setPayPals(List<PayPalDTO> payPals) {
        this.payPals = payPals;
    }

    /**
     * @return Lista de PSEs del cliente
     */
    public List<PseDTO> getPses() {
        return pses;
    }
    
    /**
     * @param pses Nueva lista de PSEs del cliente
     */
    public void setPses(List<PseDTO> pses) {
        this.pses = pses;
    }

    /**
     * @return Lista de Tarjetas del cliente
     */
    public List<TarjetaCreditoDTO> getTarjetas() {
        return tarjetas;
    }

    /**
     * @param tarjetas Nueva lista de Tarjetas del cliente
     */
    
    public void setTarjetas(List<TarjetaCreditoDTO> tarjetas) {
        this.tarjetas = tarjetas;
    }

    private void llenarServicios(List<ServicioEntity> servicios) {
        for (ServicioEntity entityServicio : servicios) {
            if (entityServicio.getClass().equals(AseoEntity.class)) {
                AseoDTO servicio = new AseoDTO((AseoEntity) entityServicio);
                this.servicios.add(servicio);
            } else if (entityServicio.getClass().equals(PaseoEntity.class)) {
                PaseoDTO servicio = new PaseoDTO((PaseoEntity) entityServicio);
                this.servicios.add(servicio);
            } else if (entityServicio.getClass().equals(HotelEntity.class)) {
                HotelDTO servicio = new HotelDTO((HotelEntity) entityServicio);
                this.servicios.add(servicio);
            } else if (entityServicio.getClass().equals(EntrenamientoEntity.class)) {
                EntrenamientoDTO servicio = new EntrenamientoDTO((EntrenamientoEntity) entityServicio);
                this.servicios.add(servicio);
            }
        }
    }
    
}
