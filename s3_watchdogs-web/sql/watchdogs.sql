/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  c.martinezc1
 * Created: 6/03/2018
 */
delete from ServicioEntity_RutaEntity;
delete from RutaEntity;
delete from LugarEntity;
delete from FacturaEntity;
delete from ServicioEntity;
delete from TransporteEntity;
delete from MascotaEntity;
delete from EmpleadoEntity;
delete from DisponibilidadEntity;
delete from ClienteEntity_MetodoDePagoEntity;
delete from MetodoDePagoEntity;
delete from ClienteEntity;
delete from CalificacionEntity;

insert into CalificacionEntity (id,puntaje) values (1,7);
insert into CalificacionEntity (id,puntaje) values (2,7);
insert into CalificacionEntity (id,puntaje) values (3,3);
insert into CalificacionEntity (id,puntaje) values (4,10);
insert into CalificacionEntity (id,puntaje) values (5,6);
insert into CalificacionEntity (id,puntaje) values (6,5);
insert into CalificacionEntity (id,puntaje) values (7,10);
insert into CalificacionEntity (id,puntaje) values (8,3);
insert into CalificacionEntity (id,puntaje) values (9,5);
insert into CalificacionEntity (id,puntaje) values (10,4);

insert into ClienteEntity (id,cedula, name, Calificacion_Id) values (1,'2228', 'Giacopo', 1);
insert into ClienteEntity (id,cedula, name, Calificacion_Id) values (2,'1766', 'Decca', 2);
insert into ClienteEntity (id,cedula, name, Calificacion_Id) values (3,'6677', 'Joey', 3);
insert into ClienteEntity (id,cedula, name, Calificacion_Id) values (4,'8753', 'Christie', 4);
insert into ClienteEntity (id,cedula, name, Calificacion_Id) values (5,'5351', 'Astra', 5);
insert into ClienteEntity (id,cedula, name, Calificacion_Id) values (6,'4162', 'Marchelle', 6);
insert into ClienteEntity (id,cedula, name, Calificacion_Id) values (7,'1257', 'Kasey', 7);
insert into ClienteEntity (id,cedula, name, Calificacion_Id) values (8,'6614', 'Loren', 8);
insert into ClienteEntity (id,cedula, name, Calificacion_Id) values (9,'6939', 'Wolfgang', 9);
insert into ClienteEntity (id,cedula, name, Calificacion_Id) values (10,'1008', 'Bartlet', 10);

insert into MetodoDePagoEntity (id,aprobado, name, nombre, correo, codigoseguridad, fechavencimiento, numerotarjeta, contrasenha) values (1,1, 'Cristian', 'Peralta', 'pbaxter0@buzzfeed.com', '192', '07/23/2018', '5602217084788197557', 'iOc87B');
insert into MetodoDePagoEntity (id,aprobado, name, nombre, correo, codigoseguridad, fechavencimiento, numerotarjeta, contrasenha) values (2,1, 'Kym', 'Kim', 'kchellingworth1@salon.com', '854', '10/30/2018', '6391166470850846', 'wTu3EkMk9y');
insert into MetodoDePagoEntity (id,aprobado, name, nombre, correo, codigoseguridad, fechavencimiento, numerotarjeta, contrasenha) values (3,1, 'Rockie', 'Frasquito', 'fchagg2@gnu.org', '107', '08/08/2018', '3530875050292265', 'oBPKHz');
insert into MetodoDePagoEntity (id,aprobado, name, nombre, correo, codigoseguridad, fechavencimiento, numerotarjeta, contrasenha) values (4,1, 'Whitney', 'Tammie', 'tarthur3@pen.io', '239', '06/08/2018', '560221362124941527', 'rssvPFc5');
insert into MetodoDePagoEntity (id,aprobado, name, nombre, correo, codigoseguridad, fechavencimiento, numerotarjeta, contrasenha) values (5,0, 'Damien', 'Ross', 'rplenderleith4@unicef.org', '467', '08/21/2018', '3584934520873983', 'ec6LxEUqcD');
insert into MetodoDePagoEntity (id,aprobado, name, nombre, correo, codigoseguridad, fechavencimiento, numerotarjeta, contrasenha) values (6,1, 'Katharyn', 'Frazer', 'ffootitt5@virginia.edu', '399', '10/19/2018', '3576989041642820', 'hhzfRMoKivs1');
insert into MetodoDePagoEntity (id,aprobado, name, nombre, correo, codigoseguridad, fechavencimiento, numerotarjeta, contrasenha) values (7,0, 'Clarette', 'Agneta', 'ashiril6@sogou.com', '203', '08/08/2018', '5610812884638015', 'GHifAeNI8');
insert into MetodoDePagoEntity (id,aprobado, name, nombre, correo, codigoseguridad, fechavencimiento, numerotarjeta, contrasenha) values (8,1, 'Blondell', 'Pennie', 'pporcher7@hexun.com', '369', '05/08/2018', '3583478174316064', 'I4jVMRTg');
insert into MetodoDePagoEntity (id,aprobado, name, nombre, correo, codigoseguridad, fechavencimiento, numerotarjeta, contrasenha) values (9,0, 'Elbertina', 'Gaile', 'gspringett8@archive.org', '164', '11/10/2018', '3529187202785532', '71xiILUVr9');
insert into MetodoDePagoEntity (id,aprobado, name, nombre, correo, codigoseguridad, fechavencimiento, numerotarjeta, contrasenha) values (10,1, 'Zebedee', 'Roshelle', 'rshutte9@scientificamerican.com', '688', '1/10/2018', '3549106064837799', 'lnyS20Wni');

insert into ClienteEntity_MetodoDePagoEntity (ClienteEntity_id, MetodosDePago_Id) values (1, 1);
insert into ClienteEntity_MetodoDePagoEntity (ClienteEntity_id, MetodosDePago_Id) values (2, 2);
insert into ClienteEntity_MetodoDePagoEntity (ClienteEntity_id, MetodosDePago_Id) values (3, 3);
insert into ClienteEntity_MetodoDePagoEntity (ClienteEntity_id, MetodosDePago_Id) values (4, 4);
insert into ClienteEntity_MetodoDePagoEntity (ClienteEntity_id, MetodosDePago_Id) values (5, 5);
insert into ClienteEntity_MetodoDePagoEntity (ClienteEntity_id, MetodosDePago_Id) values (6, 6);
insert into ClienteEntity_MetodoDePagoEntity (ClienteEntity_id, MetodosDePago_Id) values (7, 7);
insert into ClienteEntity_MetodoDePagoEntity (ClienteEntity_id, MetodosDePago_Id) values (8, 8);
insert into ClienteEntity_MetodoDePagoEntity (ClienteEntity_id, MetodosDePago_Id) values (9, 9);
insert into ClienteEntity_MetodoDePagoEntity (ClienteEntity_id, MetodosDePago_Id) values (10, 10);

insert into DisponibilidadEntity (id, name) values (1, 'F');
insert into DisponibilidadEntity (id, name) values (2, 'F');
insert into DisponibilidadEntity (id, name) values (3, 'M');
insert into DisponibilidadEntity (id, name) values (4, 'M');
insert into DisponibilidadEntity (id, name) values (5, 'F');
insert into DisponibilidadEntity (id, name) values (6, 'M');
insert into DisponibilidadEntity (id, name) values (7, 'M');
insert into DisponibilidadEntity (id, name) values (8, 'F');
insert into DisponibilidadEntity (id, name) values (9, 'F');
insert into DisponibilidadEntity (id, name) values (10, 'F');

insert into EmpleadoEntity (id,cedula, edad, imagen, name, Disponibilidad_id) values (1,'2727', 24, 'proin.tiff', 'Annetta Vallens', 1);
insert into EmpleadoEntity (id,cedula, edad, imagen, name, Disponibilidad_id) values (2,'21111', 31, 'mauris_sit_amet.tiff', 'Marcos Partridge', 2);
insert into EmpleadoEntity (id,cedula, edad, imagen, name, Disponibilidad_id) values (3,'1856', 74, 'fusce_congue_diam.png', 'Christiane Traviss', 3);
insert into EmpleadoEntity (id,cedula, edad, imagen, name, Disponibilidad_id) values (4,'9427', 68, 'vestibulum.jpeg', 'Lia Midner', 4);
insert into EmpleadoEntity (id,cedula, edad, imagen, name, Disponibilidad_id) values (5,'2719', 72, 'mauris.png', 'Elwyn Sympson', 5);
insert into EmpleadoEntity (id,cedula, edad, imagen, name, Disponibilidad_id) values (6,'3145', 58, 'velit_vivamus.gif', 'Randa Ropp', 6);
insert into EmpleadoEntity (id,cedula, edad, imagen, name, Disponibilidad_id) values (7,'9144', 55, 'auctor_sed.tiff', 'Josefa Bowart', 7);
insert into EmpleadoEntity (id,cedula, edad, imagen, name, Disponibilidad_id) values (8,'6289', 21, 'condimentum_curabitur_in.tiff', 'Chad Gress',8);
insert into EmpleadoEntity (id,cedula, edad, imagen, name, Disponibilidad_id) values (9,'8922', 30, 'consequat.gif', 'Clarance Grindle',9);
insert into EmpleadoEntity (id,cedula, edad, imagen, name, Disponibilidad_id) values (10,'1421', 74, 'ante_ipsum_primis.jpeg', 'Lynnea Thomelin',10);

insert into MascotaEntity (id,color, name, raza, sexo, Cliente_id) values (1,'Goldenrod', 'Talya', 'Lamprotornis nitens', 'F', 1);
insert into MascotaEntity (id,color, name, raza, sexo, Cliente_id) values (2,'Violet', 'Davy', 'Corvus albus', 'M', 2);
insert into MascotaEntity (id,color, name, raza, sexo, Cliente_id) values (3,'Blue', 'Lynsey', 'Oncorhynchus nerka', 'F', 3);
insert into MascotaEntity (id,color, name, raza, sexo, Cliente_id) values (4,'Indigo', 'Darwin', 'Sarkidornis melanotos', 'M', 4);
insert into MascotaEntity (id,color, name, raza, sexo, Cliente_id) values (5,'Crimson', 'Immanuel', 'Geococcyx californianus', 'M', 5);
insert into MascotaEntity (id,color, name, raza, sexo, Cliente_id) values (6,'Goldenrod', 'Danny', 'Oryx gazella callotis', 'M', 6);
insert into MascotaEntity (id,color, name, raza, sexo, Cliente_id) values (7,'Crimson', 'Hillier', 'Lophoaetus occipitalis', 'M', 7);
insert into MascotaEntity (id,color, name, raza, sexo, Cliente_id) values (8,'Blue', 'Tim', 'Cynictis penicillata', 'F', 8);
insert into MascotaEntity (id,color, name, raza, sexo, Cliente_id) values (9,'Orange', 'Neall', 'Canis lupus baileyi', 'M', 9);
insert into MascotaEntity (id,color, name, raza, sexo, Cliente_id) values (10,'Orange', 'Neal', 'Ateles paniscus', 'M', 10);

insert into TransporteEntity (id,devuelta, direccion, recogida) values (1,10, '3 Pierstorff Avenue', 4);
insert into TransporteEntity (id,devuelta, direccion, recogida) values (2,10, '2996 Maywood Avenue', 5);
insert into TransporteEntity (id,devuelta, direccion, recogida) values (3,7, '82163 7th Drive', 4);
insert into TransporteEntity (id,devuelta, direccion, recogida) values (4,6, '9933 Maple Parkway', 4);
insert into TransporteEntity (id,devuelta, direccion, recogida) values (5,8, '16 Gulseth Crossing', 4);
insert into TransporteEntity (id,devuelta, direccion, recogida) values (6,7, '5 Corscot Drive', 3);
insert into TransporteEntity (id,devuelta, direccion, recogida) values (7,10, '8595 Claremont Parkway', 4);
insert into TransporteEntity (id,devuelta, direccion, recogida) values (8,9, '3 Arapahoe Plaza', 1);
insert into TransporteEntity (id,devuelta, direccion, recogida) values (9,6, '729 Barnett Road', 3);
insert into TransporteEntity (id,devuelta, direccion, recogida) values (10,10, '2 Everett Parkway', 4);

insert into ServicioEntity (id,costo, duracion, estado, fecha, hora, cliente_id, mascota_id, empleado_id, calificacion_id, tipo, Transporte_id, capmax, banho, dientes, peluqueria, tiempohospedaje) values (1,78, 58.9, 1, '12/17/2017', 6, 1, 1, 1, 1, 'Often', 1, 8, 0, 0, 0, 58);
insert into ServicioEntity (id,costo, duracion, estado, fecha, hora, cliente_id, mascota_id, empleado_id, calificacion_id, tipo, Transporte_id, capmax, banho, dientes, peluqueria, tiempohospedaje) values (2,81, 19.5, 1, '9/14/2017', 11, 2, 2, 2, 2, 'Never', 2, 4, 0, 0, 0, 25);
insert into ServicioEntity (id,costo, duracion, estado, fecha, hora, cliente_id, mascota_id, empleado_id, calificacion_id, tipo, Transporte_id, capmax, banho, dientes, peluqueria, tiempohospedaje) values (3,11, 19.9, 1, '6/2/2017', 10, 3, 3, 3, 3, 'Never', 3, 11, 1, 1, 1, 46);
insert into ServicioEntity (id,costo, duracion, estado, fecha, hora, cliente_id, mascota_id, empleado_id, calificacion_id, tipo, Transporte_id, capmax, banho, dientes, peluqueria, tiempohospedaje) values (4,19, 58.1, 1, '12/16/2017', 6, 4, 4, 4, 4, 'Yearly', 4, 19, 0, 1, 0, 28);
insert into ServicioEntity (id,costo, duracion, estado, fecha, hora, cliente_id, mascota_id, empleado_id, calificacion_id, tipo, Transporte_id, capmax, banho, dientes, peluqueria, tiempohospedaje) values (5,86, 50.0, 0, '7/14/2017', 1, 5, 5, 5, 5, 'Often', 5, 8, 1, 1, 0, 43);
insert into ServicioEntity (id,costo, duracion, estado, fecha, hora, cliente_id, mascota_id, empleado_id, calificacion_id, tipo, Transporte_id, capmax, banho, dientes, peluqueria, tiempohospedaje) values (6,25, 23.5, 1, '4/21/2017', 12, 6, 6, 6, 6, 'Weekly', 6, 20, 1, 1, 0, 58);
insert into ServicioEntity (id,costo, duracion, estado, fecha, hora, cliente_id, mascota_id, empleado_id, calificacion_id, tipo, Transporte_id, capmax, banho, dientes, peluqueria, tiempohospedaje) values (7,23, 34.2, 0, '12/14/2017', 5, 7, 7, 7, 7, 'Daily', 7, 3, 0, 0, 0, 55);
insert into ServicioEntity (id,costo, duracion, estado, fecha, hora, cliente_id, mascota_id, empleado_id, calificacion_id, tipo, Transporte_id, capmax, banho, dientes, peluqueria, tiempohospedaje) values (8,37, 16.9, 0, '7/28/2017', 8, 8, 8, 8, 8, 'Often', 8, 11, 1, 1, 1, 56);
insert into ServicioEntity (id,costo, duracion, estado, fecha, hora, cliente_id, mascota_id, empleado_id, calificacion_id, tipo, Transporte_id, capmax, banho, dientes, peluqueria, tiempohospedaje) values (9,73, 31.1, 0, '4/27/2017', 2, 9, 9, 9, 9, 'Yearly', 9, 2, 1, 0, 0, 36);
insert into ServicioEntity (id,costo, duracion, estado, fecha, hora, cliente_id, mascota_id, empleado_id, calificacion_id, tipo, Transporte_id, capmax, banho, dientes, peluqueria, tiempohospedaje) values (10,61, 7.6, 1, '4/29/2017', 2, 10, 10, 10, 10, 'Seldom', 10, 10, 0, 0, 1, 67);

insert into FacturaEntity (pagado, valor, Cliente_id, MetodoDePago_id, Servicio_id) values (1, 90.2, 1, 1, 1);
insert into FacturaEntity (pagado, valor, Cliente_id, MetodoDePago_id, Servicio_id) values (0, 28.4, 2, 2, 2);
insert into FacturaEntity (pagado, valor, Cliente_id, MetodoDePago_id, Servicio_id) values (0, 90.25, 3, 3, 3);
insert into FacturaEntity (pagado, valor, Cliente_id, MetodoDePago_id, Servicio_id) values (0, 91.55, 4, 4, 4);
insert into FacturaEntity (pagado, valor, Cliente_id, MetodoDePago_id, Servicio_id) values (1, 76.76, 5, 5, 5);
insert into FacturaEntity (pagado, valor, Cliente_id, MetodoDePago_id, Servicio_id) values (1, 91.14, 6, 6, 6);
insert into FacturaEntity (pagado, valor, Cliente_id, MetodoDePago_id, Servicio_id) values (1, 35.14, 7, 7, 7);
insert into FacturaEntity (pagado, valor, Cliente_id, MetodoDePago_id, Servicio_id) values (0, 20.05, 8, 8, 8);
insert into FacturaEntity (pagado, valor, Cliente_id, MetodoDePago_id, Servicio_id) values (0, 33.37, 9, 9, 9);
insert into FacturaEntity (pagado, valor, Cliente_id, MetodoDePago_id, Servicio_id) values (1, 70.89, 10, 10, 10);

insert into LugarEntity (capacidadmaxima, direccion, name, usuariosenservicio) values (1, '6053 Melby Circle', 'Wordtune', 7);
insert into LugarEntity (capacidadmaxima, direccion, name, usuariosenservicio) values (5, '5 American Ash Way', 'Wikizz', 5);
insert into LugarEntity (capacidadmaxima, direccion, name, usuariosenservicio) values (10, '2 Rusk Trail', 'Linklinks', 4);
insert into LugarEntity (capacidadmaxima, direccion, name, usuariosenservicio) values (10, '93056 Arkansas Junction', 'Rooxo', 4);
insert into LugarEntity (capacidadmaxima, direccion, name, usuariosenservicio) values (60, '59 Roxbury Street', 'Blogpad', 10);
insert into LugarEntity (capacidadmaxima, direccion, name, usuariosenservicio) values (30, '2 Bluestem Point', 'Skajo', 4);
insert into LugarEntity (capacidadmaxima, direccion, name, usuariosenservicio) values (50, '76 Anthes Hill', 'Nlounge', 6);
insert into LugarEntity (capacidadmaxima, direccion, name, usuariosenservicio) values (40, '449 Hagan Point', 'Tambee', 6);
insert into LugarEntity (capacidadmaxima, direccion, name, usuariosenservicio) values (90, '4251 Continental Drive', 'Topicblab', 7);
insert into LugarEntity (capacidadmaxima, direccion, name, usuariosenservicio) values (80, '67 Thierer Terrace', 'Zooveo', 6);


insert into RutaEntity (id,duracion) values (1,39);
insert into RutaEntity (id,duracion) values (2,36);
insert into RutaEntity (id,duracion) values (3,23);
insert into RutaEntity (id,duracion) values (4,43);
insert into RutaEntity (id,duracion) values (5,28);
insert into RutaEntity (id,duracion) values (6,44);
insert into RutaEntity (id,duracion) values (7,50);
insert into RutaEntity (id,duracion) values (8,37);
insert into RutaEntity (id,duracion) values (9,39);
insert into RutaEntity (id,duracion) values (10,58);

insert into ServicioEntity_RutaEntity (PaseoEntity_id, Rutas_id) values (1, 1);
insert into ServicioEntity_RutaEntity (PaseoEntity_id, Rutas_id) values (2, 2);
insert into ServicioEntity_RutaEntity (PaseoEntity_id, Rutas_id) values (3, 3);
insert into ServicioEntity_RutaEntity (PaseoEntity_id, Rutas_id) values (4, 4);
insert into ServicioEntity_RutaEntity (PaseoEntity_id, Rutas_id) values (5, 5);
insert into ServicioEntity_RutaEntity (PaseoEntity_id, Rutas_id) values (6, 6);
insert into ServicioEntity_RutaEntity (PaseoEntity_id, Rutas_id) values (7, 7);
insert into ServicioEntity_RutaEntity (PaseoEntity_id, Rutas_id) values (8, 8);
insert into ServicioEntity_RutaEntity (PaseoEntity_id, Rutas_id) values (9, 9);
insert into ServicioEntity_RutaEntity (PaseoEntity_id, Rutas_id) values (10, 10);
