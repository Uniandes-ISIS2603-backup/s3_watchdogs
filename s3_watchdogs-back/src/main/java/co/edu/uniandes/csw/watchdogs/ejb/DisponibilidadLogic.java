/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.watchdogs.ejb;

import co.edu.uniandes.csw.watchdogs.entities.DisponibilidadEntity;
import co.edu.uniandes.csw.watchdogs.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.watchdogs.persistence.DisponibilidadPersistence;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author id.salazar
 */

@Stateless
public class DisponibilidadLogic {
    
    private static final Logger LOGGER = Logger.getLogger(DisponibilidadLogic.class.getName());
    
    @Inject
    private DisponibilidadPersistence persistence;

    /**
     * Devuelve todas las disponibilidades que hay en la base de datos.
     * @return Lista de entidades de tipo disponibilidad.
     */
    public List<DisponibilidadEntity> getDisponibilidades() {
        LOGGER.info("Inicia proceso de consultar todas las Disponibilidades");
        List<DisponibilidadEntity> disponibilidades = persistence.findAll();
        LOGGER.info("Termina proceso de consultar todas las Disponibilidades");
        return disponibilidades;
    }
    
    /**
     * Busca una disponibilidad por ID
     * @param id El id de la disponibilidad a buscar
     * @return La disponibilidad encontrada, null si no la encuentra.
     */
    public DisponibilidadEntity getDisponibilidad(Long id) {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar Disponibilidad con id={0}", id);
        DisponibilidadEntity disponibilidad = persistence.find(id);
        if (disponibilidad == null) {
            LOGGER.log(Level.SEVERE, "La Disponibilidad con el id {0} no existe", id);
        }
        LOGGER.log(Level.INFO, "Termina proceso de consultar disponibilidad con id={0}", id);
        return disponibilidad;
    }
    
    /**
     * Guardar una nueva Disponibilidad
     * @param entity La nueva entidad de tipo Disponibilidad a persistir.
     * @return La entidad luego de persistirla
     * @throws BusinessLogicException 
     */
    public DisponibilidadEntity createDisponibilidad(DisponibilidadEntity entity) throws BusinessLogicException {
        LOGGER.info("Inicia proceso de creación de Disponibilidad");
        check(entity);
        persistence.create(entity);
        LOGGER.info("Termina proceso de creación de Disponibilidad");
        return entity;
    }
    
    /**
     * Actualizar una Disponibilidad por ID
     * @param id El ID de la Disponibilidad a actualizar
     * @param entity La entidad de la Disponibilidad con los cambios deseados
     * @return La entidad de la Disponibilidad luego de actualizarla
     * @throws BusinessLogicException 
     */
    public DisponibilidadEntity updateDisponibilidad(Long id, DisponibilidadEntity entity) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "Inicia proceso de actualizar Disponibilidad con id={0}", id);
        check(entity);
        DisponibilidadEntity newEntity = persistence.update(entity);
        LOGGER.log(Level.INFO, "Termina proceso de actualizar Disponibilidad con id={0}", entity.getId());
        return newEntity;
    }
    
    /**
     * Eliminar una Disponibilidad por ID
     * @param id El ID de la Disponibilidad a eliminar
     */
    public void deleteDisponibilidad(Long id) {
        LOGGER.log(Level.INFO, "Inicia proceso de borrar Disponibilidad con id={0}", id);
        persistence.delete(id);
        LOGGER.log(Level.INFO, "Termina proceso de borrar Disponibilidad con id={0}", id);
    }
    
    public void check(DisponibilidadEntity entity)throws BusinessLogicException{
        checkMatrizValida(entity);
    }
    
    
    /**
     * verifica que el horario cumpla con los parámetros (7 días y 12 horas)
     * @param entity La disponibilidad a revisar
     * @throws BusinessLogicException Si el horario no tiene el formato adecuado.
     */
    public void checkMatrizValida(DisponibilidadEntity entity) throws BusinessLogicException{
        String checker = entity.getMatrizHorarios();
        if(!(checker.length() == 90 || checker.length() == 91)){
            throw new BusinessLogicException("Formato inválido, el String no tiene la duración adecuada");
        }
        String[] checker1 = checker.split(" ");
        for(int i = 0; i < 7; i++){
            if(checker1[i].length() != 12){
                throw new BusinessLogicException("Hora del día inválidas");
            }
            String temp = checker1[i];
            temp = temp.replaceAll("L","");
            temp = temp.replaceAll("D","");
            temp = temp.replaceAll("A","");
            if(!temp.equals("")){
                throw new BusinessLogicException("Caracteres no válidos");
            }
            
        }
    }
    
}
