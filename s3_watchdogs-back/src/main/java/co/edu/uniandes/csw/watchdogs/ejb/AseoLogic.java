/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.watchdogs.ejb;

import co.edu.uniandes.csw.watchdogs.entities.AseoEntity;
import co.edu.uniandes.csw.watchdogs.entities.ClienteEntity;
import co.edu.uniandes.csw.watchdogs.entities.EmpleadoEntity;
import co.edu.uniandes.csw.watchdogs.entities.MascotaEntity;
import co.edu.uniandes.csw.watchdogs.entities.VeterinariaEntity;
import co.edu.uniandes.csw.watchdogs.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.watchdogs.persistence.AseoPersistence;
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
public class AseoLogic {

    private static final Logger LOGGER = Logger.getLogger(AseoLogic.class.getName());

    @Inject
    private AseoPersistence persistence;

    @Inject
    private ClienteLogic clienteLogic;

    @Inject
    private MascotaLogic mascotaLogic;

    @Inject
    private EmpleadoLogic empleadoLogic;

    /**
     * Guardar un nuevo Entrenamiento
     *
     * @param entity La entidad de tipo Aseo del nuevo libro a persistir.
     * @return La entidad luego de persistirla
     * @throws BusinessLogicException
     */
    public AseoEntity createAseo(AseoEntity entity) throws BusinessLogicException {
        LOGGER.info("Inicia proceso de creación de Aseo. Logica");
        LOGGER.log(Level.INFO,"Fecha = {0}",entity.getCliente().getId());

        Date todayDate = Calendar.getInstance().getTime();
        if (todayDate.before(entity.getFecha())) {
            ClienteEntity cliente = clienteLogic.getCliente(entity.getCliente().getId());
            MascotaEntity mascota = mascotaLogic.getMascota(entity.getMascota().getId());
            entity.setCosto(costo(entity.getDuracion()));
            entity.setEstado(true);
            entity.setCliente(cliente);
            entity.setMascota(mascota);
            persistence.create(entity);
            LOGGER.info("Termina proceso de creación de Aseo");
            return entity;
        } else {
            throw new BusinessLogicException("La fecha del servicio debe ser posterior a hoy");
        }
    }

    /**
     * Devuelve todos los Servicios de Aseo que hay en la base de datos.
     *
     * @return Lista de entidades de tipo Aseo.
     */
    public List<AseoEntity> getAseos() {
        LOGGER.info("Inicia proceso de consultar todos los Servicios de Aseos");
        List<AseoEntity> aseos = persistence.findAll();
        LOGGER.info("Termina proceso de consultar todos los aseos");
        return aseos;
    }

    /**
     * Busca un Servicio de Aseo por ID
     *
     * @param id El id del Servicio de Aseo a buscar
     * @return El Servicio de Aseo encontrado, null si no lo encuentra.
     */
    public AseoEntity getAseo(Long id) {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar Aseo con id={0}", id);
        AseoEntity aseo = persistence.find(id);
        if (aseo == null) {
            LOGGER.log(Level.SEVERE, "El Servicio de aseo con el id {0} no existe", id);
        }
        LOGGER.log(Level.INFO, "Termina proceso de consultar Servicio de aseo con id={0}", id);
        return aseo;
    }

    /**
     * Actualizar un Aseo por ID
     *
     * @param id El ID del Entrenamiento a actualizar
     * @param entity La entidad del Entrenamiento con los cambios deseados
     * @param idCliente
     * @param idMascota
     * @param idEmpleado
     * @return La entidad del Entrenamiento luego de actualizarla
     * @throws BusinessLogicException
     */
    public AseoEntity updateAseo(Long id, AseoEntity entity) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "Inicia proceso de actualizar Aseo con id={0}", id);
        Date todayDate = Calendar.getInstance().getTime();
        if (todayDate.before(entity.getFecha())) {
            ClienteEntity cliente = clienteLogic.getCliente(entity.getCliente().getId());
            MascotaEntity mascota = mascotaLogic.getMascota(entity.getMascota().getId());
            EmpleadoEntity empleado = empleadoLogic.getEmpleado(entity.getEmpleado().getId());
            entity.setCliente(cliente);
            entity.setMascota(mascota);
            entity.setEmpleado(empleado);
            AseoEntity newEntity = persistence.update(entity);
            LOGGER.log(Level.INFO, "Termina proceso de actualizar Aseo con id={0}", entity.getId());
            return newEntity;
        } else {
            throw new BusinessLogicException("La fecha debe ser posterior a hoy.");
        }
    }

    /**
     * Eliminar un Servicio de Aseo por ID
     *
     * @param id El ID del Servicio de Aseo a eliminar
     */
    public void deleteAseo(Long id) {
        LOGGER.log(Level.INFO, "Inicia proceso de borrar Servicio de Aseo con id={0}", id);
        persistence.delete(id);
        LOGGER.log(Level.INFO, "Termina proceso de borrar Servicio de Aseo con id={0}", id);
    }

    public VeterinariaEntity getVeterinaria(Long id) {
        return getAseo(id).getVeterinaria();
    }

    public VeterinariaEntity addVeterinaria(Long idC, Long idE) {
        AseoEntity veterinariaEntity = getAseo(idE);
        VeterinariaEntity vetEntity = new VeterinariaEntity();
        vetEntity.setId(idC);
        veterinariaEntity.setVeterinaria(vetEntity);
        return getVeterinaria(idC);
    }

    public VeterinariaEntity replaceVeterinaria(Long id, VeterinariaEntity vet) {
        AseoEntity aseoEntity = getAseo(id);
        aseoEntity.setVeterinaria(vet);
        return aseoEntity.getVeterinaria();
    }

    private Double costo(double duracion) {
        return duracion * 1.5;
    }
}
