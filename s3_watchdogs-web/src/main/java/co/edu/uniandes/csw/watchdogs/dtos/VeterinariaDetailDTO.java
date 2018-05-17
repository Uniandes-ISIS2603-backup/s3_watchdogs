/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.watchdogs.dtos;

import co.edu.uniandes.csw.watchdogs.entities.AseoEntity;
import co.edu.uniandes.csw.watchdogs.entities.PaseoEntity;
import co.edu.uniandes.csw.watchdogs.entities.VeterinariaEntity;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que extiende de {@link VeterinariaDTO} para manejar la transformacion
 * entre los objetos JSON y las Entidades de la base de datos. Para conocer el
 * contenido de la veterinaria vaya a la documentacion de {@link VeterinariaDTO}
 *
 * * VeterinariaDTO Objeto de transferencia de datos de Lugar. Los DTO
 * contienen las representaciones de los JSON que se tranfieren entre la
 * veterinaria y el servidor.
 *
 * Al serializarse como JSON esta clase implementa el siguiente modelo: <br>
 * <pre>
 *  {
 *      "id": Long,
 *      "direccion": String,
 *      "fotos": List'String',
 *      "usuariosEnServicio": Integer,
 *      "capacidadMaxima":Integer
 *
 *  }
 * </pre> Por ejemplo veterinaria se representa asi: <br>
 *
 * <pre>
 *
 *  {
 *      "id": 1234,
 *      "direccion": Carrera 50#120,
 *      "fotos": "",
 *      "usuariosEnServicio": Integer,
 *      "capacidadMaxima":Integer
 *  }
 *
 * </pre>
 *
 * @author js.vacat
 */
public class VeterinariaDetailDTO extends VeterinariaDTO {

    private transient List<PaseoDTO> paseos;
    private transient List<AseoDTO> aseos;

    /**
     * Constructor por defecto
     */
    public VeterinariaDetailDTO() {
        super();
    }

    /**
     * Constructor para transformar un Entity a un DTO
     *
     * @param entity La entidad de veterinaria a partir de la cual se contruye
     * el objeto
     */
    public VeterinariaDetailDTO(VeterinariaEntity entity) {
        super(entity);

        if (entity != null) {
            if (entity.getAseos() != null) {
                aseos = new ArrayList();
                for (AseoEntity eEnt : entity.getAseos()) {
                    aseos.add(new AseoDTO(eEnt));
                }
            }
            if (entity.getPaseos() != null) {
                paseos = new ArrayList();
                for (PaseoEntity hEnt : entity.getPaseos()) {
                    paseos.add(new PaseoDTO(hEnt));
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
    public VeterinariaEntity toEntity() {
        VeterinariaEntity entity = super.toEntity();
        if (this.getAseos() != null) {
            List<AseoEntity> aseoEnt = new ArrayList<>();
            for (AseoDTO e : aseos) {
                aseoEnt.add(e.toEntity());
            }
            entity.setAseos(aseoEnt);
        }
        if (this.getPaseos() != null) {
            List<PaseoEntity> paseoEnt = new ArrayList<>();
            for (PaseoDTO h : paseos) {
                paseoEnt.add(h.toEntity());
            }
            entity.setPaseos(paseoEnt);
        }
        return entity;
    }

    /**
     * @return the paseo
     */
    public List<PaseoDTO> getPaseos() {
        return paseos;
    }

    /**
     * @param paseos the paseo to set
     */
    public void setPaseos(List<PaseoDTO> paseos) {
        this.paseos = paseos;
    }

    /**
     * @return the aseo
     */
    public List<AseoDTO> getAseos() {
        return aseos;
    }

    /**
     * @param aseos the aseo to set
     */
    public void setAseos(List<AseoDTO> aseos) {
        this.aseos = aseos;
    }

}
