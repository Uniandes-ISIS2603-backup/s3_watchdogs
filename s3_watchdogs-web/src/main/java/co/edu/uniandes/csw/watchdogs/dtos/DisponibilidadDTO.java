/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.watchdogs.dtos;

import co.edu.uniandes.csw.watchdogs.entities.DisponibilidadEntity;
//import co.edu.uniandes.csw.watchdogs.entities.Estado;


/**
 * DisponibilidadDTO Objeto de transferencia de datos de Watchdogs. Los DTO contienen las
 * represnetaciones de los JSON que se transfieren entre el cliente y el
 * servidor.
 * 
 * Al serializarse como JSON esta clase implementa el siguiente modelo: <br>
 * <pre>
 *   {
 *      "id": number,
 *      "matrizHorarios": String
 *   }
 * </pre>
 * Por ejemplo una ruta se representa asi:<br>
 * 
 * <pre>
 * 
 *   {
 *      "id": 1321321,
 *      "matrizHorarios": "LAD LLL DDD AAL LLD DDL" 
 *   }
 *
 * </pre>
 *
 * @author id.salazar
 */
public class DisponibilidadDTO {
    
    private Long id;
    private String matrizHorarios;
    
    
    /** 
     * Constructor por defecto
     */
    public DisponibilidadDTO(){
        
    }
    
     /**
     * Constructor que recibe un entity
     * @param entity 
     */
    public DisponibilidadDTO(DisponibilidadEntity entity){
        if(entity != null){
        this.id = entity.getId();
        //this.matrizHorarios = fromMatrizHorarios(entity.getMatrizHorarios());
        }
    }
    
    /**
     * 
     * @return El id de la Disponibilidad
     */
    
    public Long getId(){
        return id;
    }
    
    /**
     * @param id El nuevo id de la Disponibilidad
     */
    
    public void setId(Long id){
        this.id = id;
    }
    
     /**
     * 
     * @return La matriz de horarios
     */
    
    public String getMatrizHorarios(){
        return matrizHorarios;
    }
    
     /**
     * @param matrizHorarios La nueva matriz de horarios
     */
    
    public void setMatrizHorarios(String matrizHorarios){
        this.matrizHorarios = matrizHorarios;
    }
    
    /**
     * Metodo que pasa de un DTO a un Entity
     * @return la entidad creada
     */
    public DisponibilidadEntity toEntity(){
        DisponibilidadEntity entity = new DisponibilidadEntity();
        entity.setId(id);
        //entity.setMatrizHorarios(toMatrizHorarios());
        return entity;
    }
    
//    public void setMatrizHorarios(Estado[][] matrizHorarios){
//        this.matrizHorarios = fromMatrizHorarios(matrizHorarios);
//    }
    
//    public Estado[][] toMatrizHorarios(){
//        String[] temp = matrizHorarios.split(" ");
//        String[] dummy = temp[0].split("");
//        Estado[][] rta = new Estado[temp.length][dummy.length];
//        for(int i = 0; i < temp.length; i++){
//            String[] temp2 = temp[i].split("");
//            for(int j = 0; j < temp2.length; j++){
//                String value = temp2[j];
//                if(value.equalsIgnoreCase("A")){
//                    rta[i][j]= Estado.AGENDADO;
//                } else if(value.equalsIgnoreCase("L")){
//                    rta[i][j]= Estado.LIBRE;
//                } else if(value.equalsIgnoreCase("D")){
//                    rta[i][j]= Estado.DESCANSO;
//                }  
//            }
//        }
//        return rta;
//    }
//    
//    public String fromMatrizHorarios(Estado[][] entrante){
//        String rta = "";
//        for(int i = 0; i < entrante.length; i++){
//            for(int j = 0; j < entrante[0].length; j++){
//                
//                if(entrante[i][j] != null){
//                switch(entrante[i][j]){
//                case AGENDADO:
//                    rta += "A";
//                    break;
//                case LIBRE:
//                    rta += "L";
//                    break;
//                case DESCANSO:
//                    rta += "D";
//                    break;
//                
//                } 
//                }
//            }
//            rta += " ";
//        }
//        return rta;
//    }
    
    
}
