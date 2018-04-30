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

insert into ClienteEntity (id,cedula, name) values (100,'2228', 'Giacopo');
insert into ClienteEntity (id,cedula, name) values (200,'1766', 'Decca');
insert into ClienteEntity (id,cedula, name) values (300,'6677', 'Joey');
insert into ClienteEntity (id,cedula, name) values (400,'8753', 'Christie');
insert into ClienteEntity (id,cedula, name) values (500,'5351', 'Astra');
insert into ClienteEntity (id,cedula, name) values (600,'4162', 'Marchelle');
insert into ClienteEntity (id,cedula, name) values (700,'1257', 'Kasey');
insert into ClienteEntity (id,cedula, name) values (800,'6614', 'Loren');
insert into ClienteEntity (id,cedula, name) values (900,'6939', 'Wolfgang');
insert into ClienteEntity (id,cedula, name) values (1000,'1008', 'Bartlet');

--PSE
insert into MetodoDePagoEntity (id,DTYPE,aprobado, nombre, cliente_id, correo) values (100,'PseEntity',1, 'Peralta', 100, 'pbaxter0@buzzfeed.com');
insert into MetodoDePagoEntity (id,DTYPE,aprobado, nombre, cliente_id, correo) values (200,'PseEntity',1, 'Kim',200, 'kchellingworth1@salon.com');
insert into MetodoDePagoEntity (id,DTYPE,aprobado, nombre, cliente_id, correo) values (300,'PseEntity',1, 'Frasquito',300, 'fchagg2@gnu.org');
insert into MetodoDePagoEntity (id,DTYPE,aprobado, nombre, cliente_id, correo) values (400,'PseEntity',1, 'Tammie',400, 'tarthur3@pen.io');
insert into MetodoDePagoEntity (id,DTYPE,aprobado, nombre, cliente_id, correo) values (500,'PseEntity',0, 'Ross',500, 'rplenderleith4@unicef.org');
insert into MetodoDePagoEntity (id,DTYPE,aprobado, nombre, cliente_id, correo) values (600,'PseEntity',1, 'Frazer',600, 'ffootitt5@virginia.edu');
insert into MetodoDePagoEntity (id,DTYPE,aprobado, nombre, cliente_id, correo) values (700,'PseEntity',0, 'Agneta',700, 'ashiril6@sogou.com');
insert into MetodoDePagoEntity (id,DTYPE,aprobado, nombre, cliente_id, correo) values (800,'PseEntity',1, 'Pennie',800, 'pporcher7@hexun.com');
insert into MetodoDePagoEntity (id,DTYPE,aprobado, nombre, cliente_id, correo) values (900,'PseEntity',0, 'Gaile',900, 'gspringett8@archive.org');
insert into MetodoDePagoEntity (id,DTYPE,aprobado, nombre, cliente_id, correo) values (1000,'PseEntity',1, 'Roshelle',1000, 'rshutte9@scientificamerican.com');

--PayPal
insert into MetodoDePagoEntity (id,DTYPE,aprobado, nombre, cliente_id, correo) values (101,'PaypalEntity',1, 'Cristian', 100, 'pbaxter0@buzzfeed.com');
insert into MetodoDePagoEntity (id,DTYPE,aprobado, nombre, cliente_id, correo) values (201,'PaypalEntity',1, 'Kym',200, 'kchellingworth1@salon.com');
insert into MetodoDePagoEntity (id,DTYPE,aprobado, nombre, cliente_id, correo) values (301,'PaypalEntity',1, 'Rockie',300, 'fchagg2@gnu.org');
insert into MetodoDePagoEntity (id,DTYPE,aprobado, nombre, cliente_id, correo) values (401,'PaypalEntity',1, 'Whitney', 400, 'tarthur3@pen.io');
insert into MetodoDePagoEntity (id,DTYPE,aprobado, nombre, cliente_id, correo) values (501,'PaypalEntity',0, 'Damien', 500, 'rplenderleith4@unicef.org');
insert into MetodoDePagoEntity (id,DTYPE,aprobado, nombre, cliente_id, correo) values (601,'PaypalEntity',1, 'Katharyn', 600, 'ffootitt5@virginia.edu');
insert into MetodoDePagoEntity (id,DTYPE,aprobado, nombre, cliente_id, correo) values (701,'PaypalEntity',0, 'Clarette', 700, 'ashiril6@sogou.com');
insert into MetodoDePagoEntity (id,DTYPE,aprobado, nombre, cliente_id, correo) values (801,'PaypalEntity',1, 'Blondell', 800, 'pporcher7@hexun.com');
insert into MetodoDePagoEntity (id,DTYPE,aprobado, nombre, cliente_id, correo) values (901,'PaypalEntity',0, 'Elbertina', 900, 'gspringett8@archive.org');
insert into MetodoDePagoEntity (id,DTYPE,aprobado, nombre, cliente_id, correo) values (1001,'PaypalEntity',1, 'Zebedee', 1000, 'rshutte9@scientificamerican.com');

--Tarjeta
insert into MetodoDePagoEntity (id,DTYPE,aprobado, nombre, cliente_id, codigoseguridad, fechavencimiento, numerotarjeta) values (102,'TarjetadeCreditoEntity',1, 'Cristian', 100, '192', '07/23/2018', '5602217084788197557');
insert into MetodoDePagoEntity (id,DTYPE,aprobado, nombre, cliente_id, codigoseguridad, fechavencimiento, numerotarjeta) values (202,'TarjetadeCreditoEntity',1, 'Kym',200, '854', '10/30/2018', '6391166470850846');
insert into MetodoDePagoEntity (id,DTYPE,aprobado, nombre, cliente_id, codigoseguridad, fechavencimiento, numerotarjeta) values (302,'TarjetadeCreditoEntity',1, 'Rockie',300, '107', '08/08/2018', '3530875050292265');
insert into MetodoDePagoEntity (id,DTYPE,aprobado, nombre, cliente_id, codigoseguridad, fechavencimiento, numerotarjeta) values (402,'TarjetadeCreditoEntity',1, 'Whitney',400, '239', '06/08/2018', '560221362124941527');
insert into MetodoDePagoEntity (id,DTYPE,aprobado, nombre, cliente_id, codigoseguridad, fechavencimiento, numerotarjeta) values (502,'TarjetadeCreditoEntity',0, 'Damien',500, '467', '08/21/2018', '3584934520873983');
insert into MetodoDePagoEntity (id,DTYPE,aprobado, nombre, cliente_id, codigoseguridad, fechavencimiento, numerotarjeta) values (602,'TarjetadeCreditoEntity',1, 'Katharyn',600, '399', '10/19/2018', '3576989041642820');
insert into MetodoDePagoEntity (id,DTYPE,aprobado, nombre, cliente_id, codigoseguridad, fechavencimiento, numerotarjeta) values (702,'TarjetadeCreditoEntity',0, 'Clarette',700, '203', '08/08/2018', '5610812884638015');
insert into MetodoDePagoEntity (id,DTYPE,aprobado, nombre, cliente_id, codigoseguridad, fechavencimiento, numerotarjeta) values (802,'TarjetadeCreditoEntity',1, 'Blondell',800, '369', '05/08/2018', '3583478174316064');
insert into MetodoDePagoEntity (id,DTYPE,aprobado, nombre, cliente_id, codigoseguridad, fechavencimiento, numerotarjeta) values (902,'TarjetadeCreditoEntity',0, 'Elbertina',900, '164', '11/10/2018', '3529187202785532');
insert into MetodoDePagoEntity (id,DTYPE,aprobado, nombre, cliente_id, codigoseguridad, fechavencimiento, numerotarjeta) values (1002,'TarjetadeCreditoEntity',1, 'Zebedee',1000, '688', '1/10/2018', '3549106064837799');


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

insert into LugarEntity (id, capacidadmaxima, direccion, name, usuariosenservicio) values (100, 1, '6053 Melby Circle', 'Wordtune', 7);
insert into LugarEntity (id, capacidadmaxima, direccion, name, usuariosenservicio) values (200, 5, '5 American Ash Way', 'Wikizz', 5);
insert into LugarEntity (id, capacidadmaxima, direccion, name, usuariosenservicio) values (300, 10, '2 Rusk Trail', 'Linklinks', 4);
insert into LugarEntity (id, capacidadmaxima, direccion, name, usuariosenservicio) values (400, 10, '93056 Arkansas Junction', 'Rooxo', 4);
insert into LugarEntity (id, capacidadmaxima, direccion, name, usuariosenservicio) values (500, 60, '59 Roxbury Street', 'Blogpad', 10);
insert into LugarEntity (id, capacidadmaxima, direccion, name, usuariosenservicio) values (600, 30, '2 Bluestem Point', 'Skajo', 4);
insert into LugarEntity (id, capacidadmaxima, direccion, name, usuariosenservicio) values (700, 50, '76 Anthes Hill', 'Nlounge', 6);
insert into LugarEntity (id, capacidadmaxima, direccion, name, usuariosenservicio) values (800, 40, '449 Hagan Point', 'Tambee', 6);
insert into LugarEntity (id, capacidadmaxima, direccion, name, usuariosenservicio) values (900, 90, '4251 Continental Drive', 'Topicblab', 7);
insert into LugarEntity (id, capacidadmaxima, direccion, name, usuariosenservicio) values (1000, 80, '67 Thierer Terrace', 'Zooveo', 6);

--aseo
insert into ServicioEntity (id,DTYPE,costo, duracion, estado, fecha, hora, cliente_id, mascota_id, empleado_id, calificacion_id, banho, dientes, peluqueria) values (100,'AseoEntity',78, 58.9, 1, '12/17/2017', 6, 100, 100, 100, 100, 0, 0, 0);
insert into ServicioEntity (id,DTYPE,costo, duracion, estado, fecha, hora, cliente_id, mascota_id, empleado_id, calificacion_id, banho, dientes, peluqueria) values (200,'AseoEntity',81, 19.5, 1, '9/14/2017', 11, 200, 200, 200, 200, 0, 0, 0);
insert into ServicioEntity (id,DTYPE,costo, duracion, estado, fecha, hora, cliente_id, mascota_id, empleado_id, calificacion_id, banho, dientes, peluqueria) values (300,'AseoEntity',11, 19.9, 1, '6/2/2017', 10, 300, 300, 300, 300, 1, 1, 1);
insert into ServicioEntity (id,DTYPE,costo, duracion, estado, fecha, hora, cliente_id, mascota_id, empleado_id, calificacion_id, banho, dientes, peluqueria) values (400,'AseoEntity',19, 58.1, 1, '12/16/2017', 6, 400, 400, 400, 400, 0, 1, 0);
insert into ServicioEntity (id,DTYPE,costo, duracion, estado, fecha, hora, cliente_id, mascota_id, empleado_id, calificacion_id, banho, dientes, peluqueria) values (500,'AseoEntity',86, 50.0, 0, '7/14/2017', 1, 500, 500, 500, 500, 1, 1, 0);
insert into ServicioEntity (id,DTYPE,costo, duracion, estado, fecha, hora, cliente_id, mascota_id, empleado_id, calificacion_id, banho, dientes, peluqueria) values (600,'AseoEntity',25, 23.5, 1, '4/21/2017', 12, 600, 600, 600, 600, 1, 1, 0);
insert into ServicioEntity (id,DTYPE,costo, duracion, estado, fecha, hora, cliente_id, mascota_id, empleado_id, calificacion_id, banho, dientes, peluqueria) values (700,'AseoEntity',23, 34.2, 0, '12/14/2017', 5, 700, 700, 700, 700, 0, 0, 0);
insert into ServicioEntity (id,DTYPE,costo, duracion, estado, fecha, hora, cliente_id, mascota_id, empleado_id, calificacion_id, banho, dientes, peluqueria) values (800,'AseoEntity',37, 16.9, 0, '7/28/2017', 8, 800, 800, 800, 800, 1, 1, 1);
insert into ServicioEntity (id,DTYPE,costo, duracion, estado, fecha, hora, cliente_id, mascota_id, empleado_id, calificacion_id, banho, dientes, peluqueria) values (900,'AseoEntity',73, 31.1, 0, '4/27/2017', 2, 900, 900, 900, 900, 1, 0, 0);
insert into ServicioEntity (id,DTYPE,costo, duracion, estado, fecha, hora, cliente_id, mascota_id, empleado_id, calificacion_id, banho, dientes, peluqueria) values (1000,'AseoEntity',61, 7.6, 1, '4/29/2017', 2, 1000, 1000, 1000, 1000, 0, 0, 1);

--entrenamiento
insert into ServicioEntity (id,DTYPE,costo, duracion, estado, fecha, hora, cliente_id, mascota_id, empleado_id, calificacion_id, tipo, Transporte_id, CentrodeEntrenamiento_id) values (101,'EntrenamientoEntity',78, 58.9, 1, '12/17/2017', 6, 100, 100, 100, 100, 'Often', 100, 100);
insert into ServicioEntity (id,DTYPE,costo, duracion, estado, fecha, hora, cliente_id, mascota_id, empleado_id, calificacion_id, tipo, Transporte_id, CentrodeEntrenamiento_id) values (201,'EntrenamientoEntity',81, 19.5, 1, '9/14/2017', 11, 200, 200, 200, 200, 'Never', 200, 200);
insert into ServicioEntity (id,DTYPE,costo, duracion, estado, fecha, hora, cliente_id, mascota_id, empleado_id, calificacion_id, tipo, Transporte_id, CentrodeEntrenamiento_id) values (301,'EntrenamientoEntity',11, 19.9, 1, '6/2/2017', 10, 300, 300, 300, 300, 'Never', 300, 300);
insert into ServicioEntity (id,DTYPE,costo, duracion, estado, fecha, hora, cliente_id, mascota_id, empleado_id, calificacion_id, tipo, Transporte_id, CentrodeEntrenamiento_id) values (401,'EntrenamientoEntity',19, 58.1, 1, '12/16/2017', 6, 400, 400, 400, 400, 'Yearly', 400, 400);
insert into ServicioEntity (id,DTYPE,costo, duracion, estado, fecha, hora, cliente_id, mascota_id, empleado_id, calificacion_id, tipo, Transporte_id, CentrodeEntrenamiento_id) values (501,'EntrenamientoEntity',86, 50.0, 0, '7/14/2017', 1, 500, 500, 500, 500, 'Often', 500, 500);
insert into ServicioEntity (id,DTYPE,costo, duracion, estado, fecha, hora, cliente_id, mascota_id, empleado_id, calificacion_id, tipo, Transporte_id, CentrodeEntrenamiento_id) values (601,'EntrenamientoEntity',25, 23.5, 1, '4/21/2017', 12, 600, 600, 600, 600, 'Weekly', 600, 600);
insert into ServicioEntity (id,DTYPE,costo, duracion, estado, fecha, hora, cliente_id, mascota_id, empleado_id, calificacion_id, tipo, Transporte_id, CentrodeEntrenamiento_id) values (701,'EntrenamientoEntity',23, 34.2, 0, '12/14/2017', 5, 700, 700, 700, 700, 'Daily', 700, 700);
insert into ServicioEntity (id,DTYPE,costo, duracion, estado, fecha, hora, cliente_id, mascota_id, empleado_id, calificacion_id, tipo, Transporte_id, CentrodeEntrenamiento_id) values (801,'EntrenamientoEntity',37, 16.9, 0, '7/28/2017', 8, 800, 800, 800, 800, 'Often', 800, 800);
insert into ServicioEntity (id,DTYPE,costo, duracion, estado, fecha, hora, cliente_id, mascota_id, empleado_id, calificacion_id, tipo, Transporte_id, CentrodeEntrenamiento_id) values (901,'EntrenamientoEntity',73, 31.1, 0, '4/27/2017', 2, 900, 900, 900, 900, 'Yearly', 900, 900);
insert into ServicioEntity (id,DTYPE,costo, duracion, estado, fecha, hora, cliente_id, mascota_id, empleado_id, calificacion_id, tipo, Transporte_id, CentrodeEntrenamiento_id) values (1001,'EntrenamientoEntity',61, 7.6, 1, '4/29/2017', 2, 1000, 1000, 1000, 1000, 'Seldom', 1000, 1000);

--hotel
insert into ServicioEntity (id,DTYPE,costo, duracion, estado, fecha, hora, cliente_id, mascota_id, empleado_id, calificacion_id, Transporte_id, tiempohospedaje, CentrodeEntrenamiento_id) values (102,'HotelEnity',78, 58.9, 1, '12/17/2017', 6, 100, 100, 100, 100, 100, 58, 100);
insert into ServicioEntity (id,DTYPE,costo, duracion, estado, fecha, hora, cliente_id, mascota_id, empleado_id, calificacion_id, Transporte_id, tiempohospedaje, CentrodeEntrenamiento_id) values (202,'HotelEnity',81, 19.5, 1, '9/14/2017', 11, 200, 200, 200, 200, 200, 25, 200);
insert into ServicioEntity (id,DTYPE,costo, duracion, estado, fecha, hora, cliente_id, mascota_id, empleado_id, calificacion_id, Transporte_id, tiempohospedaje, CentrodeEntrenamiento_id) values (302,'HotelEnity',11, 19.9, 1, '6/2/2017', 10, 300, 300, 300, 300, 300, 46, 300);
insert into ServicioEntity (id,DTYPE,costo, duracion, estado, fecha, hora, cliente_id, mascota_id, empleado_id, calificacion_id, Transporte_id, tiempohospedaje, CentrodeEntrenamiento_id) values (402,'HotelEnity',19, 58.1, 1, '12/16/2017', 6, 400, 400, 400, 400, 400, 28, 400);
insert into ServicioEntity (id,DTYPE,costo, duracion, estado, fecha, hora, cliente_id, mascota_id, empleado_id, calificacion_id, Transporte_id, tiempohospedaje, CentrodeEntrenamiento_id) values (502,'HotelEnity',86, 50.0, 0, '7/14/2017', 1, 500, 500, 500, 500, 500, 43, 500);
insert into ServicioEntity (id,DTYPE,costo, duracion, estado, fecha, hora, cliente_id, mascota_id, empleado_id, calificacion_id, Transporte_id, tiempohospedaje, CentrodeEntrenamiento_id) values (602,'HotelEnity',25, 23.5, 1, '4/21/2017', 12, 600, 600, 600, 600, 600, 58, 600);
insert into ServicioEntity (id,DTYPE,costo, duracion, estado, fecha, hora, cliente_id, mascota_id, empleado_id, calificacion_id, Transporte_id, tiempohospedaje, CentrodeEntrenamiento_id) values (702,'HotelEnity',23, 34.2, 0, '12/14/2017', 5, 700, 700, 700, 700, 700, 55, 700);
insert into ServicioEntity (id,DTYPE,costo, duracion, estado, fecha, hora, cliente_id, mascota_id, empleado_id, calificacion_id, Transporte_id, tiempohospedaje, CentrodeEntrenamiento_id) values (802,'HotelEnity',37, 16.9, 0, '7/28/2017', 8, 800, 800, 800, 800, 800, 56, 800);
insert into ServicioEntity (id,DTYPE,costo, duracion, estado, fecha, hora, cliente_id, mascota_id, empleado_id, calificacion_id, Transporte_id, tiempohospedaje, CentrodeEntrenamiento_id) values (902,'HotelEnity',73, 31.1, 0, '4/27/2017', 2, 900, 900, 900, 900, 900, 36, 900);
insert into ServicioEntity (id,DTYPE,costo, duracion, estado, fecha, hora, cliente_id, mascota_id, empleado_id, calificacion_id, Transporte_id, tiempohospedaje, CentrodeEntrenamiento_id) values (1002,'HotelEnity',61, 7.6, 1, '4/29/2017', 2, 1000, 1000, 1000, 1000, 1000, 67, 1000);

--paseo
insert into ServicioEntity (id,DTYPE,costo, duracion, estado, fecha, hora, cliente_id, mascota_id, empleado_id, calificacion_id, capmax) values (103,'Paseo',78, 58.9, 1, '12/17/2017', 6, 100, 100, 100, 100, 8);
insert into ServicioEntity (id,DTYPE,costo, duracion, estado, fecha, hora, cliente_id, mascota_id, empleado_id, calificacion_id, capmax) values (203,'Paseo',81, 19.5, 1, '9/14/2017', 11, 200, 200, 200, 200, 4);
insert into ServicioEntity (id,DTYPE,costo, duracion, estado, fecha, hora, cliente_id, mascota_id, empleado_id, calificacion_id, capmax) values (303,'Paseo',11, 19.9, 1, '6/2/2017', 10, 300, 300, 300, 300, 11);
insert into ServicioEntity (id,DTYPE,costo, duracion, estado, fecha, hora, cliente_id, mascota_id, empleado_id, calificacion_id, capmax) values (403,'Paseo',19, 58.1, 1, '12/16/2017', 6, 400, 400, 400, 400, 19);
insert into ServicioEntity (id,DTYPE,costo, duracion, estado, fecha, hora, cliente_id, mascota_id, empleado_id, calificacion_id, capmax) values (503,'Paseo',86, 50.0, 0, '7/14/2017', 1, 500, 500, 500, 500, 8);
insert into ServicioEntity (id,DTYPE,costo, duracion, estado, fecha, hora, cliente_id, mascota_id, empleado_id, calificacion_id, capmax) values (603,'Paseo',25, 23.5, 1, '4/21/2017', 12, 600, 600, 600, 600, 20);
insert into ServicioEntity (id,DTYPE,costo, duracion, estado, fecha, hora, cliente_id, mascota_id, empleado_id, calificacion_id, capmax) values (703,'Paseo',23, 34.2, 0, '12/14/2017', 5, 700, 700, 700, 700, 3);
insert into ServicioEntity (id,DTYPE,costo, duracion, estado, fecha, hora, cliente_id, mascota_id, empleado_id, calificacion_id, capmax) values (803,'Paseo',37, 16.9, 0, '7/28/2017', 8, 800, 800, 800, 800, 11);
insert into ServicioEntity (id,DTYPE,costo, duracion, estado, fecha, hora, cliente_id, mascota_id, empleado_id, calificacion_id, capmax) values (903,'Paseo',73, 31.1, 0, '4/27/2017', 2, 900, 900, 900, 900, 2);
insert into ServicioEntity (id,DTYPE,costo, duracion, estado, fecha, hora, cliente_id, mascota_id, empleado_id, calificacion_id, capmax) values (1003,'Paseo',61, 7.6, 1, '4/29/2017', 2, 1000, 1000, 1000, 1000, 10);

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
