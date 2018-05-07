/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.watchdogs.ejb;

import co.edu.uniandes.csw.watchdogs.entities.AseoEntity;
import co.edu.uniandes.csw.watchdogs.entities.PaseoEntity;
import co.edu.uniandes.csw.watchdogs.entities.VeterinariaEntity;
import co.edu.uniandes.csw.watchdogs.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.watchdogs.persistence.VeterinariaPersistence;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author js.vacat
 */
@Stateless
public class VeterinariaLogic {

    private static final Logger LOGGER = Logger.getLogger(VeterinariaLogic.class.getName());

    @Inject
    private VeterinariaPersistence persistence;

    @Inject
    private PaseoLogic paseoLogic;

    @Inject
    private AseoLogic aseoLogic;

    /**
     * Devuelve todas las veterinarias que hay en la base de datos.
     *
     * @return Lista de entidades de tipo Veterinaria.
     */
    public List<VeterinariaEntity> getVeterinarias() {
        LOGGER.info("Inicia proceso de consultar todas las Veterinarias");
        List<VeterinariaEntity> veterinaria = persistence.findAll();
        LOGGER.info("Termina proceso de consultar todas las veterinarias");
        return veterinaria;
    }

    /**
     * Busca una Veterinaria por ID
     *
     * @param id El id de la veterinaria a buscar
     * @return La veterinaria encontrada, null si no la encuentra.
     */
    public VeterinariaEntity getVeterinaria(Long id) {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar Veterinaria con id={0}", id);
        VeterinariaEntity veterinaria = persistence.find(id);
        if (veterinaria == null) {
            LOGGER.log(Level.SEVERE, "La Veterinaria con el id {0} no existe", id);
        }
        LOGGER.log(Level.INFO, "Termina proceso de consultar Veterinaria con id={0}", id);
        return veterinaria;
    }

    /**
     * Guardar una nueva Veterinaria
     *
     * @param entity La entidad de tipo veterinaria a persistir.
     * @return La entidad luego de persistirla
     * @throws BusinessLogicException
     */
    public VeterinariaEntity createVeterinaria(VeterinariaEntity entity) throws BusinessLogicException {
        LOGGER.info("Inicia proceso de creación de Veterinaria");
        validar(entity);
        persistence.create(entity);
        LOGGER.info("Termina proceso de creación de Veterinaria");
        return entity;
    }

    /**
     * Actualizar una Veterinaria por ID
     *
     * @param id El ID de la Veterinaria a actualizar
     * @param entity La entidad de la Veterinaria con los cambios deseados
     * @return La entidad de la Veterinaria luego de actualizarla
     * @throws BusinessLogicException
     */
    public VeterinariaEntity updateVeterinaria(Long id, VeterinariaEntity entity) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "Inicia proceso de actualizar Veterinaria con id={0}", id);
        validar(entity);
        VeterinariaEntity newEntity = persistence.update(entity);
        LOGGER.log(Level.INFO, "Termina proceso de actualizar Veterinaria con id={0}", entity.getId());
        return newEntity;
    }

    public void validar(VeterinariaEntity entity) throws BusinessLogicException {
        if (entity.getUsuariosEnServicio() > entity.getCapacidadMaxima()) {
            throw new BusinessLogicException("Los usuarios en servicio no pueden ser mayores que la capacidad máxima");
        }
        if (entity.getDireccion().length() > 50) {
            throw new BusinessLogicException("La direccion es muy grande");
        }
    }

    /**
     * Eliminar una Veterinaria por ID
     *
     * @param id El ID de la Veterinaria a eliminar
     */
    public void deleteVeterinaria(Long id) {
        LOGGER.log(Level.INFO, "Inicia proceso de borrar Veterinaria con id={0}", id);
        persistence.delete(id);
        LOGGER.log(Level.INFO, "Termina proceso de borrar Veterinaria con id={0}", id);
    }

    public List<AseoEntity> getAseos(Long id) {
        return getVeterinaria(id).getAseos();
    }

    public AseoEntity getAseo(Long idC, Long idE) throws BusinessLogicException {
        List<AseoEntity> aseos = getVeterinaria(idC).getAseos();
        AseoEntity aseo = aseoLogic.getAseo(idE);
        int index = aseos.indexOf(aseo);
        if (index >= 0) {
            return aseos.get(index);
        }
        throw new BusinessLogicException("El Aseo no está asociado a la Veterinaria");
    }

    public AseoEntity addAseo(Long idC, Long idE) throws BusinessLogicException {
        VeterinariaEntity veterinariaEntity = getVeterinaria(idC);
        AseoEntity aseoEntity = aseoLogic.getAseo(idE);
        validarServicios(aseoEntity.getId(), aseoEntity.getName(), aseoEntity.getFecha(), aseoEntity.getCosto(), aseoEntity.getDuracion());
        aseoEntity.setVeterinaria(veterinariaEntity);
        return aseoEntity;
    }

    public List<AseoEntity> replaceAseos(Long id, List<AseoEntity> aseos) {
        VeterinariaEntity veterinaria = getVeterinaria(id);
        List<AseoEntity> aseoList = aseoLogic.getAseos();
        for (AseoEntity aseo : aseoList) {
            if (aseos.contains(aseo)) {
                aseo.setVeterinaria(veterinaria);
            } else if (aseo.getVeterinaria() != null && aseo.getVeterinaria().equals(veterinaria)) {
                aseo.setVeterinaria(null);
            }
        }
        return aseos;
    }

    public void removeAseo(Long aseoId, Long veterinariaId) {
        VeterinariaEntity veterinariaEntity = getVeterinaria(veterinariaId);
        AseoEntity aseo = aseoLogic.getAseo(aseoId);
        aseo.setVeterinaria(null);
        veterinariaEntity.getAseos().remove(aseo);
    }

    /**
     * Agregar un Paseo a la Veterinaria
     *
     * @param paseoId El id paseo a guardar
     * @param veterinariaId El id de la Veterinaria en la cual se va a guardar
     * el paseo.
     * @return El paseo que fue agregado a la Veterinaria.
     */
    public PaseoEntity addPaseo(Long paseoId, Long veterinariaId) throws BusinessLogicException {
        VeterinariaEntity veterinariaEntity = getVeterinaria(veterinariaId);
        PaseoEntity paseoEntity = paseoLogic.getPaseo(paseoId);
        validarServicios(paseoEntity.getId(), paseoEntity.getName(), paseoEntity.getFecha(), paseoEntity.getCosto(), paseoEntity.getDuracion());
        paseoEntity.setVeterinaria(veterinariaEntity);
        return paseoEntity;
    }

    /**
     * Borrar un Paseo de una Veterinaria
     *
     * @param paseoId El paseo que se desea borrar de la veterinaria.
     * @param veterinariaId la vetererinaria de la cual se desea eliminar.
     */
    public void removeHotel(Long paseoId, Long veterinariaId) {
        VeterinariaEntity veterinariaEntity = getVeterinaria(veterinariaId);
        PaseoEntity paseo = paseoLogic.getPaseo(paseoId);
        paseo.setVeterinaria(null);
        veterinariaEntity.getPaseos().remove(paseo);
    }

    /**
     * Remplazar Paseos de una Veterinaria
     *
     * @param paseos Lista de paseos que serán los de la veterinaria.
     * @param veterinariaId El id de la veterinaria que se quiere actualizar.
     * @return La lista de paseos actualizada.
     */
    public List<PaseoEntity> replacePaseos(Long veterinariaId, List<PaseoEntity> paseos) {
        VeterinariaEntity veterinaria = getVeterinaria(veterinariaId);
        List<PaseoEntity> paseoList = paseoLogic.getPaseos();
        for (PaseoEntity paseo : paseoList) {
            if (paseos.contains(paseo)) {
                paseo.setVeterinaria(veterinaria);
            } else if (paseo.getVeterinaria() != null && paseo.getVeterinaria().equals(veterinaria)) {
                paseo.setVeterinaria(null);
            }
        }
        return paseos;
    }

    /**
     * Retorna todos los paseos asociados a una Veterinaria
     *
     * @param veterinariaId El ID de la Veterinaria buscada
     * @return La lista de paseos de la Veterinaria
     */
    public List<PaseoEntity> getPaseos(Long veterinariaId) {
        return getVeterinaria(veterinariaId).getPaseos();
    }

    /**
     * Retorna un Paseo asociado a una Veterinaria
     *
     * @param veterinariaId El id de la veterinaria a buscar.
     * @param paseoId El id del hotel a buscar
     * @return El paseo encontrado dentro de la veterinaria.
     * @throws BusinessLogicException Si el hotel no se encuentra en la
     * CentroDeEntrenamiento
     */
    public PaseoEntity getPaseo(Long veterinariaId, Long paseoId) throws BusinessLogicException {
        List<PaseoEntity> paseos = getVeterinaria(veterinariaId).getPaseos();
        PaseoEntity paseo = paseoLogic.getPaseo(paseoId);
        int index = paseos.indexOf(paseo);
        if (index >= 0) {
            return paseos.get(index);
        }
        throw new BusinessLogicException("El paseo no está asociado a la veterinaria");

    }

    public void validarServicios(Long id, String nombre, Date fecha, Double costo, Double duracion) throws BusinessLogicException {
        Date todayDate = Calendar.getInstance().getTime();
        if (fecha.before(todayDate)) {
            throw new BusinessLogicException("La fecha ingresada no es valida");
        } else if (id < 0) {
            throw new BusinessLogicException("El id es invalido");
        } else if (nombre.length() > 50) {
            throw new BusinessLogicException("El nombre es muy grande");
        } else if (costo < 0) {
            throw new BusinessLogicException("El costo es invalido");
        } else if (duracion < 0) {
            throw new BusinessLogicException("La duracion es invalida");
        }
    }

}
