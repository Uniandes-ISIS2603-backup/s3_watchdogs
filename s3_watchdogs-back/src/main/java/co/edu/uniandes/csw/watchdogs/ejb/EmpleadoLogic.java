/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.watchdogs.ejb;

import co.edu.uniandes.csw.watchdogs.entities.EmpleadoEntity;
import co.edu.uniandes.csw.watchdogs.entities.ServicioEntity;
import co.edu.uniandes.csw.watchdogs.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.watchdogs.persistence.EmpleadoPersistence;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * Clase que implementa la conexion con la persistencia para la entidad
 * Empleado.
 *
 * @author ca.beltran10
 */
@Stateless
public class EmpleadoLogic {

    /**
     * Constante que relaciona el Logger de la logica.
     */
    private static final Logger LOGGER = Logger.getLogger(EmpleadoLogic.class.getName());

    /**
     * Conexion con la persistencia del empleado.
     */
    @Inject
    private EmpleadoPersistence persistence;

    /**
     * Crea un empleado en la persistencia.
     *
     * @param entity La entidad que representa el empleado a persistir.
     * @return La entidad del empleado luego de persistirla.
     * @throws BusinessLogicException Si el empleado a persistir ya existe.
     */
    public EmpleadoEntity createEmpleado(EmpleadoEntity entity) throws BusinessLogicException {
        LOGGER.info("Inicia proceso de creacion de empleado");
        if (persistence.findByCedula(entity.getCedula()) != null) {
            throw new BusinessLogicException("Ya existe un Empleado con la cedula \"" + entity.getCedula() + "\"");
        }
        check(entity);
        LOGGER.info("Termina proceso de creacion de empleado");
        return persistence.create(entity);
    }

    /**
     * Obtener todos los empleados existentes en la base de datos.
     *
     * @return una lista de empleados.
     */
    public List<EmpleadoEntity> getEmpleados() {
        LOGGER.info("Inicia proceso de consultar todos los empleados");
        List<EmpleadoEntity> empleados = persistence.findAll();
        LOGGER.info("Termina proceso de consultar todos los empleados");
        return empleados;
    }
    
    public List<EmpleadoEntity> findbyCargo(String cargo){
        LOGGER.info("Inicia proceso de consultar los empleados por cargo");
        List<EmpleadoEntity> empleados = persistence.findByCargo(cargo);
        LOGGER.info("Termina proceso de consultar los empleados por cargo");
        return empleados;
    }

    /**
     * Obtener un empleado por medio de su id.
     *
     * @param id: id del empleado para ser buscado.
     * @return El empleado solicitado por medio de su id.
     */
    public EmpleadoEntity getEmpleado(Long id) {
        LOGGER.log(Level.INFO, "Iicia proceso de consultar empleado con id={0}", id);
        EmpleadoEntity empleado = persistence.find(id);
        if (empleado == null) {
            LOGGER.log(Level.SEVERE, "El empleado con el id {0} no existe", id);
        }
        LOGGER.log(Level.INFO, "Termina proceso de consultar empleado con id={0}", id);
        return empleado;
    }

    /**
     * Actualizar un empleado.
     *
     * @param id: id del empleado para buscarlo en la base de datos.
     * @param entity: empleado con los cambios para ser actualizado, por ejemplo
     * el nombre.
     * @return el empleado con los cambios actualizados en la base de datos.
     * @throws co.edu.uniandes.csw.watchdogs.exceptions.BusinessLogicException
     */
    public EmpleadoEntity updateEmpleado(Long id, EmpleadoEntity entity) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "Inicia proceso de actualizar empleado con id={0}", id);
        check(entity);
        EmpleadoEntity newEntity = persistence.update(entity);
        LOGGER.log(Level.INFO, "Termina proceso de actualizar empleado con id={0}", entity.getId());
        return newEntity;
    }

    /**
     * Borrar un empleado.
     *
     * @param id: id del empleado a borrar
     * @throws BusinessLogicException Si el empleado a borrar tiene servicios.
     */
    public void deleteEmpleado(Long id) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "Inicia proceso de borrar empleado con id={0}", id);
        List<ServicioEntity> servicios = getServicios(id);
        if (servicios.isEmpty()) {
            persistence.delete(id);
        } else {
            throw new BusinessLogicException("No se puede borrar el empleado con id " + id + " porque tiene servicios asociados");
        }
        LOGGER.log(Level.INFO, "Termina proceso de borrar empleado con id={0}", id);
    }

    /**
     * Retorna el servicio asociado a un empleado.
     *
     * @param empleadoId El id del empleado buscado.
     * @return El serivicio del empleado.
     */
    public List<ServicioEntity> getServicios(Long empleadoId) {
        return getEmpleado(empleadoId).getServicios();
    }
    
    public void check(EmpleadoEntity empleado) throws BusinessLogicException{
        checkCargoValido(empleado);
    }
    
    public void checkCargoValido(EmpleadoEntity empleado) throws BusinessLogicException{
        if (!(empleado.getCargo().equals(EmpleadoEntity.ASEADOR)
                ||empleado.getCargo().equals(EmpleadoEntity.CUIDADOR)
                ||empleado.getCargo().equals(EmpleadoEntity.PASEADOR)
                ||empleado.getCargo().equals(EmpleadoEntity.ENTRENADOR))){
            throw new BusinessLogicException("Este cargo no es válido");
        }
    }

}
