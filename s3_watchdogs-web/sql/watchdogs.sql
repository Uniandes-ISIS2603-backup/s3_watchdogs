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

insert into CalificacionEntity (id,puntaje) values (100,7);
insert into CalificacionEntity (id,puntaje) values (200,7);
insert into CalificacionEntity (id,puntaje) values (300,3);
insert into CalificacionEntity (id,puntaje) values (400,10);
insert into CalificacionEntity (id,puntaje) values (500,6);
insert into CalificacionEntity (id,puntaje) values (600,5);
insert into CalificacionEntity (id,puntaje) values (700,10);
insert into CalificacionEntity (id,puntaje) values (800,3);
insert into CalificacionEntity (id,puntaje) values (900,5);
insert into CalificacionEntity (id,puntaje) values (1000,4);

insert into ClienteEntity (id,cedula, name, Calificacion_Id) values (100,'2228', 'Giacopo', 100);
insert into ClienteEntity (id,cedula, name, Calificacion_Id) values (200,'1766', 'Decca', 200);
insert into ClienteEntity (id,cedula, name, Calificacion_Id) values (300,'6677', 'Joey', 300);
insert into ClienteEntity (id,cedula, name, Calificacion_Id) values (400,'8753', 'Christie', 400);
insert into ClienteEntity (id,cedula, name, Calificacion_Id) values (500,'5351', 'Astra', 500);
insert into ClienteEntity (id,cedula, name, Calificacion_Id) values (600,'4162', 'Marchelle', 600);
insert into ClienteEntity (id,cedula, name, Calificacion_Id) values (700,'1257', 'Kasey', 700);
insert into ClienteEntity (id,cedula, name, Calificacion_Id) values (800,'6614', 'Loren', 800);
insert into ClienteEntity (id,cedula, name, Calificacion_Id) values (900,'6939', 'Wolfgang', 900);
insert into ClienteEntity (id,cedula, name, Calificacion_Id) values (1000,'1008', 'Bartlet', 1000);

insert into MetodoDePagoEntity (id,aprobado, name, nombre, correo, codigoseguridad, fechavencimiento, numerotarjeta, contrasenha) values (100,1, 'Cristian', 'Peralta', 'pbaxter0@buzzfeed.com', '192', '07/23/2018', '5602217084788197557', 'iOc87B');
insert into MetodoDePagoEntity (id,aprobado, name, nombre, correo, codigoseguridad, fechavencimiento, numerotarjeta, contrasenha) values (200,1, 'Kym', 'Kim', 'kchellingworth1@salon.com', '854', '10/30/2018', '6391166470850846', 'wTu3EkMk9y');
insert into MetodoDePagoEntity (id,aprobado, name, nombre, correo, codigoseguridad, fechavencimiento, numerotarjeta, contrasenha) values (300,1, 'Rockie', 'Frasquito', 'fchagg2@gnu.org', '107', '08/08/2018', '3530875050292265', 'oBPKHz');
insert into MetodoDePagoEntity (id,aprobado, name, nombre, correo, codigoseguridad, fechavencimiento, numerotarjeta, contrasenha) values (400,1, 'Whitney', 'Tammie', 'tarthur3@pen.io', '239', '06/08/2018', '560221362124941527', 'rssvPFc5');
insert into MetodoDePagoEntity (id,aprobado, name, nombre, correo, codigoseguridad, fechavencimiento, numerotarjeta, contrasenha) values (500,0, 'Damien', 'Ross', 'rplenderleith4@unicef.org', '467', '08/21/2018', '3584934520873983', 'ec6LxEUqcD');
insert into MetodoDePagoEntity (id,aprobado, name, nombre, correo, codigoseguridad, fechavencimiento, numerotarjeta, contrasenha) values (600,1, 'Katharyn', 'Frazer', 'ffootitt5@virginia.edu', '399', '10/19/2018', '3576989041642820', 'hhzfRMoKivs1');
insert into MetodoDePagoEntity (id,aprobado, name, nombre, correo, codigoseguridad, fechavencimiento, numerotarjeta, contrasenha) values (700,0, 'Clarette', 'Agneta', 'ashiril6@sogou.com', '203', '08/08/2018', '5610812884638015', 'GHifAeNI8');
insert into MetodoDePagoEntity (id,aprobado, name, nombre, correo, codigoseguridad, fechavencimiento, numerotarjeta, contrasenha) values (800,1, 'Blondell', 'Pennie', 'pporcher7@hexun.com', '369', '05/08/2018', '3583478174316064', 'I4jVMRTg');
insert into MetodoDePagoEntity (id,aprobado, name, nombre, correo, codigoseguridad, fechavencimiento, numerotarjeta, contrasenha) values (900,0, 'Elbertina', 'Gaile', 'gspringett8@archive.org', '164', '11/10/2018', '3529187202785532', '71xiILUVr9');
insert into MetodoDePagoEntity (id,aprobado, name, nombre, correo, codigoseguridad, fechavencimiento, numerotarjeta, contrasenha) values (1000,1, 'Zebedee', 'Roshelle', 'rshutte9@scientificamerican.com', '688', '1/10/2018', '3549106064837799', 'lnyS20Wni');

insert into ClienteEntity_MetodoDePagoEntity (ClienteEntity_id, MetodosDePago_Id) values (100, 100);
insert into ClienteEntity_MetodoDePagoEntity (ClienteEntity_id, MetodosDePago_Id) values (200, 200);
insert into ClienteEntity_MetodoDePagoEntity (ClienteEntity_id, MetodosDePago_Id) values (300, 300);
insert into ClienteEntity_MetodoDePagoEntity (ClienteEntity_id, MetodosDePago_Id) values (400, 400);
insert into ClienteEntity_MetodoDePagoEntity (ClienteEntity_id, MetodosDePago_Id) values (500, 500);
insert into ClienteEntity_MetodoDePagoEntity (ClienteEntity_id, MetodosDePago_Id) values (600, 600);
insert into ClienteEntity_MetodoDePagoEntity (ClienteEntity_id, MetodosDePago_Id) values (700, 700);
insert into ClienteEntity_MetodoDePagoEntity (ClienteEntity_id, MetodosDePago_Id) values (800, 800);
insert into ClienteEntity_MetodoDePagoEntity (ClienteEntity_id, MetodosDePago_Id) values (900, 900);
insert into ClienteEntity_MetodoDePagoEntity (ClienteEntity_id, MetodosDePago_Id) values (1000, 1000);

insert into DisponibilidadEntity (id, name) values (100, 'F');
insert into DisponibilidadEntity (id, name) values (200, 'F');
insert into DisponibilidadEntity (id, name) values (300, 'M');
insert into DisponibilidadEntity (id, name) values (400, 'M');
insert into DisponibilidadEntity (id, name) values (500, 'F');
insert into DisponibilidadEntity (id, name) values (600, 'M');
insert into DisponibilidadEntity (id, name) values (700, 'M');
insert into DisponibilidadEntity (id, name) values (800, 'F');
insert into DisponibilidadEntity (id, name) values (900, 'F');
insert into DisponibilidadEntity (id, name) values (1000, 'F');

insert into EmpleadoEntity (id,cedula, edad, imagen, name, Disponibilidad_id) values (100,'2727', 24, 'proin.tiff', 'Annetta Vallens', 100);
insert into EmpleadoEntity (id,cedula, edad, imagen, name, Disponibilidad_id) values (200,'21111', 31, 'mauris_sit_amet.tiff', 'Marcos Partridge', 200);
insert into EmpleadoEntity (id,cedula, edad, imagen, name, Disponibilidad_id) values (300,'1856', 74, 'fusce_congue_diam.png', 'Christiane Traviss', 300);
insert into EmpleadoEntity (id,cedula, edad, imagen, name, Disponibilidad_id) values (400,'9427', 68, 'vestibulum.jpeg', 'Lia Midner', 400);
insert into EmpleadoEntity (id,cedula, edad, imagen, name, Disponibilidad_id) values (500,'2719', 72, 'mauris.png', 'Elwyn Sympson', 500);
insert into EmpleadoEntity (id,cedula, edad, imagen, name, Disponibilidad_id) values (600,'3145', 58, 'velit_vivamus.gif', 'Randa Ropp', 600);
insert into EmpleadoEntity (id,cedula, edad, imagen, name, Disponibilidad_id) values (700,'9144', 55, 'auctor_sed.tiff', 'Josefa Bowart', 700);
insert into EmpleadoEntity (id,cedula, edad, imagen, name, Disponibilidad_id) values (800,'6289', 21, 'condimentum_curabitur_in.tiff', 'Chad Gress',800);
insert into EmpleadoEntity (id,cedula, edad, imagen, name, Disponibilidad_id) values (900,'8922', 30, 'consequat.gif', 'Clarance Grindle',900);
insert into EmpleadoEntity (id,cedula, edad, imagen, name, Disponibilidad_id) values (1000,'1421', 74, 'ante_ipsum_primis.jpeg', 'Lynnea Thomelin',1000);

insert into MascotaEntity (id,color, name, raza, sexo, Cliente_id) values (100,'Goldenrod', 'Talya', 'Lamprotornis nitens', 'F', 100);
insert into MascotaEntity (id,color, name, raza, sexo, Cliente_id) values (200,'Violet', 'Davy', 'Corvus albus', 'M', 200);
insert into MascotaEntity (id,color, name, raza, sexo, Cliente_id) values (300,'Blue', 'Lynsey', 'Oncorhynchus nerka', 'F', 300);
insert into MascotaEntity (id,color, name, raza, sexo, Cliente_id) values (400,'Indigo', 'Darwin', 'Sarkidornis melanotos', 'M', 400);
insert into MascotaEntity (id,color, name, raza, sexo, Cliente_id) values (500,'Crimson', 'Immanuel', 'Geococcyx californianus', 'M', 500);
insert into MascotaEntity (id,color, name, raza, sexo, Cliente_id) values (600,'Goldenrod', 'Danny', 'Oryx gazella callotis', 'M', 600);
insert into MascotaEntity (id,color, name, raza, sexo, Cliente_id) values (700,'Crimson', 'Hillier', 'Lophoaetus occipitalis', 'M', 700);
insert into MascotaEntity (id,color, name, raza, sexo, Cliente_id) values (800,'Blue', 'Tim', 'Cynictis penicillata', 'F', 800);
insert into MascotaEntity (id,color, name, raza, sexo, Cliente_id) values (900,'Orange', 'Neall', 'Canis lupus baileyi', 'M', 900);
insert into MascotaEntity (id,color, name, raza, sexo, Cliente_id) values (1000,'Orange', 'Neal', 'Ateles paniscus', 'M', 1000);

insert into TransporteEntity (id,devuelta, direccion, recogida) values (100,10, '3 Pierstorff Avenue', 4);
insert into TransporteEntity (id,devuelta, direccion, recogida) values (200,10, '2996 Maywood Avenue', 5);
insert into TransporteEntity (id,devuelta, direccion, recogida) values (300,7, '82163 7th Drive', 4);
insert into TransporteEntity (id,devuelta, direccion, recogida) values (400,6, '9933 Maple Parkway', 4);
insert into TransporteEntity (id,devuelta, direccion, recogida) values (500,8, '16 Gulseth Crossing', 4);
insert into TransporteEntity (id,devuelta, direccion, recogida) values (600,7, '5 Corscot Drive', 3);
insert into TransporteEntity (id,devuelta, direccion, recogida) values (700,10, '8595 Claremont Parkway', 4);
insert into TransporteEntity (id,devuelta, direccion, recogida) values (800,9, '3 Arapahoe Plaza', 1);
insert into TransporteEntity (id,devuelta, direccion, recogida) values (900,6, '729 Barnett Road', 3);
insert into TransporteEntity (id,devuelta, direccion, recogida) values (1000,10, '2 Everett Parkway', 4);

insert into ServicioEntity (id,costo, duracion, estado, fecha, hora, cliente_id, mascota_id, empleado_id, calificacion_id, tipo, Transporte_id, capmax, banho, dientes, peluqueria, tiempohospedaje) values (100,78, 58.9, 1, '12/17/2017', 6, 100, 100, 100, 100, 'Often', 100, 8, 0, 0, 0, 58);
insert into ServicioEntity (id,costo, duracion, estado, fecha, hora, cliente_id, mascota_id, empleado_id, calificacion_id, tipo, Transporte_id, capmax, banho, dientes, peluqueria, tiempohospedaje) values (200,81, 19.5, 1, '9/14/2017', 11, 200, 200, 200, 200, 'Never', 200, 4, 0, 0, 0, 25);
insert into ServicioEntity (id,costo, duracion, estado, fecha, hora, cliente_id, mascota_id, empleado_id, calificacion_id, tipo, Transporte_id, capmax, banho, dientes, peluqueria, tiempohospedaje) values (300,11, 19.9, 1, '6/2/2017', 10, 300, 300, 300, 300, 'Never', 300, 11, 1, 1, 1, 46);
insert into ServicioEntity (id,costo, duracion, estado, fecha, hora, cliente_id, mascota_id, empleado_id, calificacion_id, tipo, Transporte_id, capmax, banho, dientes, peluqueria, tiempohospedaje) values (400,19, 58.1, 1, '12/16/2017', 6, 400, 400, 400, 400, 'Yearly', 400, 19, 0, 1, 0, 28);
insert into ServicioEntity (id,costo, duracion, estado, fecha, hora, cliente_id, mascota_id, empleado_id, calificacion_id, tipo, Transporte_id, capmax, banho, dientes, peluqueria, tiempohospedaje) values (500,86, 50.0, 0, '7/14/2017', 1, 500, 500, 500, 500, 'Often', 500, 8, 1, 1, 0, 43);
insert into ServicioEntity (id,costo, duracion, estado, fecha, hora, cliente_id, mascota_id, empleado_id, calificacion_id, tipo, Transporte_id, capmax, banho, dientes, peluqueria, tiempohospedaje) values (600,25, 23.5, 1, '4/21/2017', 12, 600, 600, 600, 600, 'Weekly', 600, 20, 1, 1, 0, 58);
insert into ServicioEntity (id,costo, duracion, estado, fecha, hora, cliente_id, mascota_id, empleado_id, calificacion_id, tipo, Transporte_id, capmax, banho, dientes, peluqueria, tiempohospedaje) values (700,23, 34.2, 0, '12/14/2017', 5, 700, 700, 700, 700, 'Daily', 700, 3, 0, 0, 0, 55);
insert into ServicioEntity (id,costo, duracion, estado, fecha, hora, cliente_id, mascota_id, empleado_id, calificacion_id, tipo, Transporte_id, capmax, banho, dientes, peluqueria, tiempohospedaje) values (800,37, 16.9, 0, '7/28/2017', 8, 800, 800, 800, 800, 'Often', 800, 11, 1, 1, 1, 56);
insert into ServicioEntity (id,costo, duracion, estado, fecha, hora, cliente_id, mascota_id, empleado_id, calificacion_id, tipo, Transporte_id, capmax, banho, dientes, peluqueria, tiempohospedaje) values (900,73, 31.1, 0, '4/27/2017', 2, 900, 900, 900, 900, 'Yearly', 900, 2, 1, 0, 0, 36);
insert into ServicioEntity (id,costo, duracion, estado, fecha, hora, cliente_id, mascota_id, empleado_id, calificacion_id, tipo, Transporte_id, capmax, banho, dientes, peluqueria, tiempohospedaje) values (1000,61, 7.6, 1, '4/29/2017', 2, 1000, 1000, 1000, 1000, 'Seldom', 1000, 10, 0, 0, 1, 67);

insert into FacturaEntity (pagado, valor, Cliente_id, MetodoDePago_id, Servicio_id) values (1, 90.2, 100, 100, 100);
insert into FacturaEntity (pagado, valor, Cliente_id, MetodoDePago_id, Servicio_id) values (0, 28.4, 200, 200, 200);
insert into FacturaEntity (pagado, valor, Cliente_id, MetodoDePago_id, Servicio_id) values (0, 90.25, 300, 300, 300);
insert into FacturaEntity (pagado, valor, Cliente_id, MetodoDePago_id, Servicio_id) values (0, 91.55, 400, 400, 400);
insert into FacturaEntity (pagado, valor, Cliente_id, MetodoDePago_id, Servicio_id) values (1, 76.76, 500, 500, 500);
insert into FacturaEntity (pagado, valor, Cliente_id, MetodoDePago_id, Servicio_id) values (1, 91.14, 600, 600, 600);
insert into FacturaEntity (pagado, valor, Cliente_id, MetodoDePago_id, Servicio_id) values (1, 35.14, 700, 700, 700);
insert into FacturaEntity (pagado, valor, Cliente_id, MetodoDePago_id, Servicio_id) values (0, 20.05, 800, 800, 800);
insert into FacturaEntity (pagado, valor, Cliente_id, MetodoDePago_id, Servicio_id) values (0, 33.37, 900, 900, 900);
insert into FacturaEntity (pagado, valor, Cliente_id, MetodoDePago_id, Servicio_id) values (1, 70.89, 1000, 1000, 1000);

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


insert into RutaEntity (id,duracion) values (100,39);
insert into RutaEntity (id,duracion) values (200,36);
insert into RutaEntity (id,duracion) values (300,23);
insert into RutaEntity (id,duracion) values (400,43);
insert into RutaEntity (id,duracion) values (500,28);
insert into RutaEntity (id,duracion) values (600,44);
insert into RutaEntity (id,duracion) values (700,50);
insert into RutaEntity (id,duracion) values (800,37);
insert into RutaEntity (id,duracion) values (900,39);
insert into RutaEntity (id,duracion) values (1000,58);

insert into ServicioEntity_RutaEntity (PaseoEntity_id, Rutas_id) values (100, 100);
insert into ServicioEntity_RutaEntity (PaseoEntity_id, Rutas_id) values (200, 200);
insert into ServicioEntity_RutaEntity (PaseoEntity_id, Rutas_id) values (300, 300);
insert into ServicioEntity_RutaEntity (PaseoEntity_id, Rutas_id) values (400, 400);
insert into ServicioEntity_RutaEntity (PaseoEntity_id, Rutas_id) values (500, 500);
insert into ServicioEntity_RutaEntity (PaseoEntity_id, Rutas_id) values (600, 600);
insert into ServicioEntity_RutaEntity (PaseoEntity_id, Rutas_id) values (700, 700);
insert into ServicioEntity_RutaEntity (PaseoEntity_id, Rutas_id) values (800, 800);
insert into ServicioEntity_RutaEntity (PaseoEntity_id, Rutas_id) values (900, 900);
insert into ServicioEntity_RutaEntity (PaseoEntity_id, Rutas_id) values (1000, 1000);
