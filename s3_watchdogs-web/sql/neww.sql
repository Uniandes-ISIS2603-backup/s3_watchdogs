/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  c.martinezc1
 * Created: 27/04/2018
 */
delete from ServicioEntity_RutaEntity;
delete from RutaEntity;
delete from FacturaEntity;
delete from ServicioEntity;
delete from LugarEntity;
delete from TransporteEntity;
delete from MascotaEntity;
delete from EmpleadoEntity;
delete from DisponibilidadEntity;
--delete from ClienteEntity_MetodoDePagoEntity;
delete from MetodoDePagoEntity;
delete from ClienteEntity;
delete from CalificacionEntity;

insert into ClienteEntity (id,cedula, name) values (100,'2228', 'Giacopo');
insert into EmpleadoEntity (id,cedula, edad, imagen, name) values (100,'2727', 24, 'proin.tiff', 'Annetta Vallens');
insert into MascotaEntity (id,color, name, raza, sexo, Cliente_id) values (100,'Goldenrod', 'Talya', 'Lamprotornis nitens', 'F', 100);
