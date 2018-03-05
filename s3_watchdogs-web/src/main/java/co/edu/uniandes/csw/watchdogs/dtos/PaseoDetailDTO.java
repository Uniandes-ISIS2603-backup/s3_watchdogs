/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.watchdogs.dtos;

import co.edu.uniandes.csw.watchdogs.entities.PaseoEntity;
import co.edu.uniandes.csw.watchdogs.entities.RutaEntity;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que extiende de {@link PaseoDTO} para manejar la transformacion entre
 * los objetos JSON y las Entidades de la base de datos. Para conocer el
 * contenido del paseo vaya a la documentacion de {@link PaseoDTO}
 * @author m.diazt
 */
public class PaseoDetailDTO extends PaseoDTO{
    
    private List<RutaDTO> rutas;
    private VeterinariaDTO veterinaria;
    
    public PaseoDetailDTO()
    {
        super();
    }
    
    public PaseoDetailDTO(PaseoEntity entity){
        super(entity);
        if(entity.getVeterinaria() != null){
            this.veterinaria = new VeterinariaDTO(entity.getVeterinaria());
        }
        else{
            entity.setVeterinaria(null);
        }
        if(entity.getRutas() != null){
            rutas = new ArrayList();
            for(RutaEntity rEntity: entity.getRutas()){
                rutas.add(new RutaDTO(rEntity));
            }
        }
        
        
    }
    
    @Override
    /**
     * Metodo que convierte un DTO a ENtity
     * @return PaseoEntity
     */
    public PaseoEntity toEntity(){
        
        PaseoEntity entity = super.toEntity();
        if(this.getVeterinaria() != null){
            entity.setVeterinaria(this.getVeterinaria().toEntity());
        }
        if(this.getRutas() != null){
            List<RutaEntity> rEnt = new ArrayList();
            for(RutaDTO ruta : rutas){
                rEnt.add(ruta.toEntity());
            }
            entity.setRutas(rEnt);
        }
        return entity;
    }

    /**
     * @return Lista de rutas
     */
    public List<RutaDTO> getRutas() {
        return rutas;
    }

    /**
     * @param rutas Lista de rutas a establecer
     */
    public void setRutas(List<RutaDTO> rutas) {
        this.rutas = rutas;
    }

    /**
     * @return veterinaria
     */
    public VeterinariaDTO getVeterinaria() {
        return veterinaria;
    }

    /**
     * @param veterinaria Veterinaria a establecer
     */
    public void setVeterinaria(VeterinariaDTO veterinaria) {
        this.veterinaria = veterinaria;
    }
    
}
