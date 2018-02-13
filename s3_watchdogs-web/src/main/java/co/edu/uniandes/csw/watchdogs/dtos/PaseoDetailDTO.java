/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.watchdogs.dtos;

import java.util.ArrayList;

/**
 *
 * @author m.diazt
 */
public class PaseoDetailDTO extends PaseoDTO{
    
    //private ArrayList<RutaDTO> rutas;
    private VeterinariaDTO veterinaria;
    
    public PaseoDetailDTO()
    {
        super();
    }

    /**
     * @return Lista de rutas
     */
    /**public ArrayList<RutaDTO> getRutas() {
        return rutas;
    }

    /**
     * @param rutas Lista de rutas a establecer
     */
    /**public void setRutas(ArrayList<RutaDTO> rutas) {
        this.rutas = rutas;
    }**/

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
