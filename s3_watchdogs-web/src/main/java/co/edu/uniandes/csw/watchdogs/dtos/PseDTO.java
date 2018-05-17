/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.watchdogs.dtos;

import co.edu.uniandes.csw.watchdogs.entities.PseEntity;

/**
 * PseDTO Objeto de transferencia de datos de Pse. Los DTO contienen las
 * represnetaciones de los JSON que se transfieren entre el cliente y el
 * servidor.
 *
 * Al serializarse como JSON esta clase implementa el siguiente modelo: <br>
 * <pre>
 *   {
 *      "id": number,
 *      "correo: string,
 *   }
 * </pre> Por ejemplo un Pse se representa asi:<br>
 *
 * <pre>
 *
 *   {
 *      "id": 91852,
 *      "correo: "jc.pulido@uniandes.edu.co",
 *   }
 *
 * /**
 *
 * @author jc.pulido
 */
public class PseDTO {

    /**
     * Id del PSE
     */
    private Long id;

    /**
     * Correo del PSE
     */
    private String correo;

    /**
     * Nombre del método de pago
     */
    private String nombre;

    /**
     * Constructor por defecto
     */
    public PseDTO() {
        super();
    }

    public PseDTO(PseEntity entity) {
        if (entity != null) {
            id = entity.getId();
            nombre = "PSE";
            correo = entity.getCorreo();
        }
    }

    /**
     * Metodo que pasa de un DTO a un Entity
     *
     * @return la entidad creada
     */
    public PseEntity toEntity() {
        PseEntity entity = new PseEntity();
        entity.setCorreo(this.correo);
        entity.setName(this.nombre);
        entity.setId(id);
        return entity;
    }

    /**
     * @return el nombre del metodo de pago
     */
    public String getNombre() {
        return nombre;
    }

    /**
     *
     * @param nombre el nuevo nombre del metodo de pago
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Método que retorna el id que identifica al DTO
     *
     * @return id asociado al DTO
     */
    public Long getId() {
        return id;
    }

    /**
     * Método que asigna un nuevo valor al id
     *
     * @param pId id nuevo a asignar
     */
    public void setId(Long pId) {
        id = pId;
    }

    /**
     * Método que retorna el correo de la cuenta PSE
     *
     * @return correo asosciado a la cuenta PSE
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * Método que asigna un nuevo valor al correo
     *
     * @param correo El nuevo correo a asignar.
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

}
