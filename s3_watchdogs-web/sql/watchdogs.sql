/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  c.martinezc1
 * Created: 6/03/2018
 */
--ClienteEntity OK
--DisponibilidadEntity SIN MATRIZ
--LugarEntity
--MascotaEntity OK
--RutaEntity OK
--TransporteEntity OK
--EmpleadoEntity OK
--CalificacionEntity OK
--PayPalEntity OK
--PSEEntity OK
--TarjetaCreditoEntity OK

--AseoEntity
--EntranamientoEntity
--FacturaEntity
--HotelEntity
--PaseoEntity
--ServicioEntity

delete from FacturaEntity;
delete from PseEntity;
delete from PayPalEntity;
delete from TarjetaCreditoEntity;
delete from EntrenamientoEntity;
delete from AseoEntity;
delete from HotelEntity;
delete from PaseoEntity;
delete from ServicioEntity;
delete from RutaEntity;
delete from LugarEntity;
delete from TransporteEntity;
delete from MascotaEntity;
delete from CalificacionEntity;
delete from EmpleadoEntity;
delete from DisponibilidadEntity;
delete from ClienteEntity;

insert into ClienteEntity (id, cedula, correo, imagen, name, telefono) values (5001, '1580009000', 'rkroch0@t.co', 'src/images/clientes/mujer1.png', 'Rana Kroch', '199-912-0740');
insert into ClienteEntity (id, cedula, correo, imagen, name, telefono) values (5002, '1090009009', 'jglyn1@php.net', 'src/images/clientes/hombre1.png', 'Jerome Glyn', '884-452-6796');
insert into ClienteEntity (id, cedula, correo, imagen, name, telefono) values (5003, '1080060778', 'cimms2@aboutads.info', 'src/images/clientes/hombre2.png', 'Cam Imms', '595-863-0572');
insert into ClienteEntity (id, cedula, correo, imagen, name, telefono) values (5004, '1000800990', 'wpolle3@pcworld.com', 'src/images/clientes/hombre3.png', 'Worthington Polle', '398-675-3333');
insert into ClienteEntity (id, cedula, correo, imagen, name, telefono) values (5005, '1000008890', 'cquest4@fotki.com', 'src/images/clientes/mujer2.png', 'Chantal Quest', '701-716-4912');
insert into ClienteEntity (id, cedula, correo, imagen, name, telefono) values (5006, '1009970098', 'swapple5@ihg.com', 'src/images/clientes/mujer3.png', 'Sissy Wapple', '203-928-1306');
insert into ClienteEntity (id, cedula, correo, imagen, name, telefono) values (5007, '1005007080', 'cgreathead6@japanpost.jp', 'src/images/clientes/mujer4.png', 'Cybil Greathead', '349-576-4537');
insert into ClienteEntity (id, cedula, correo, imagen, name, telefono) values (5008, '1800097096', 'ccastro7@illinois.edu', 'src/images/clientes/mujer5.png', 'Claudetta Castro', '565-247-9949');
insert into ClienteEntity (id, cedula, correo, imagen, name, telefono) values (5009, '1090089009', 'afishbourn8@nyu.edu', 'src/images/clientes/hombre4.png', 'Averil Fishbourn', '629-156-3792');
insert into ClienteEntity (id, cedula, correo, imagen, name, telefono) values (5010, '1978999080', 'hcordero9@ucla.edu', 'src/images/clientes/mujer6.png', 'Hillie Cordero', '917-380-2711');
insert into ClienteEntity (id, cedula, correo, imagen, name, telefono) values (5011, '1000907900', 'gcantora@go.com', 'src/images/clientes/mujer7.png', 'Giuditta Cantor', '964-376-7946');
insert into ClienteEntity (id, cedula, correo, imagen, name, telefono) values (5012, '1098909000', 'emichelb@opensource.org', 'src/images/clientes/hombre5.png', 'Ewart Michel', '450-307-9552');
insert into ClienteEntity (id, cedula, correo, imagen, name, telefono) values (5013, '1906790896', 'zdannielc@latimes.com', 'src/images/clientes/mujer8.png', 'Zola Danniel', '657-717-8303');
insert into ClienteEntity (id, cedula, correo, imagen, name, telefono) values (5014, '1990090008', 'prowlerd@sakura.ne.jp', 'src/images/clientes/hombre6.png', 'Phil Rowler', '251-194-0110');
insert into ClienteEntity (id, cedula, correo, imagen, name, telefono) values (5015, '1990800900', 'vbeausange@mysql.com', 'src/images/clientes/mujer9.png', 'Viole Beausang', '456-524-4936');
insert into ClienteEntity (id, cedula, correo, imagen, name, telefono) values (5016, '1080000099', 'dcaddickf@archive.org', 'src/images/clientes/mujer10.png', 'Dorita Caddick', '614-392-2963');
insert into ClienteEntity (id, cedula, correo, imagen, name, telefono) values (5017, '1990000090', 'ndiackg@nsw.gov.au', 'src/images/clientes/mujer11.png', 'Neilla Diack', '948-193-9091');
insert into ClienteEntity (id, cedula, correo, imagen, name, telefono) values (5018, '1760080900', 'vguisoth@cyberchimps.com', 'src/images/clientes/mujer12.png', 'Vachel Guisot', '947-368-3354');
insert into ClienteEntity (id, cedula, correo, imagen, name, telefono) values (5019, '1990000809', 'lrosenstocki@opera.com', 'src/images/clientes/mujer13.png', 'Lanna Rosenstock', '785-148-9501');
insert into ClienteEntity (id, cedula, correo, imagen, name, telefono) values (5020, '1070008099', 'rmercerj@constantcontact.com', 'src/images/clientes/mujer14.png', 'Rahal Mercer', '954-720-1751');
insert into ClienteEntity (id, cedula, correo, imagen, name, telefono) values (5021, '1190998987', 'ojakemank@gmpg.org', 'src/images/clientes/hombre7.png', 'Oswald Jakeman', '415-437-2855');
insert into ClienteEntity (id, cedula, correo, imagen, name, telefono) values (5022, '1800800900', 'nhannabyl@wikia.com', 'src/images/clientes/mujer15.png', 'Nicol Hannaby', '749-759-5485');
insert into ClienteEntity (id, cedula, correo, imagen, name, telefono) values (5023, '1950080400', 'fchilversm@creativecommons.org', 'src/images/clientes/hombre8.png', 'Francklin Chilvers', '807-937-9606');
insert into ClienteEntity (id, cedula, correo, imagen, name, telefono) values (5024, '1999990900', 'nbellardn@yolasite.com', 'src/images/clientes/mujer16.png', 'Nixie Bellard', '651-746-0678');
insert into ClienteEntity (id, cedula, correo, imagen, name, telefono) values (5025, '1900099680', 'ncurnuckeo@nationalgeographic.com', 'src/images/clientes/hombre9.png', 'Nadeen Curnucke', '123-311-7862');

insert into DisponibilidadEntity (id, name) values (5001, 'Disponibilidad');
insert into DisponibilidadEntity (id, name) values (5002, 'Disponibilidad');
insert into DisponibilidadEntity (id, name) values (5003, 'Disponibilidad');
insert into DisponibilidadEntity (id, name) values (5004, 'Disponibilidad');
insert into DisponibilidadEntity (id, name) values (5005, 'Disponibilidad');
insert into DisponibilidadEntity (id, name) values (5006, 'Disponibilidad');
insert into DisponibilidadEntity (id, name) values (5007, 'Disponibilidad');
insert into DisponibilidadEntity (id, name) values (5008, 'Disponibilidad');
insert into DisponibilidadEntity (id, name) values (5009, 'Disponibilidad');
insert into DisponibilidadEntity (id, name) values (5010, 'Disponibilidad');
insert into DisponibilidadEntity (id, name) values (5011, 'Disponibilidad');
insert into DisponibilidadEntity (id, name) values (5012, 'Disponibilidad');
insert into DisponibilidadEntity (id, name) values (5013, 'Disponibilidad');
insert into DisponibilidadEntity (id, name) values (5014, 'Disponibilidad');
insert into DisponibilidadEntity (id, name) values (5015, 'Disponibilidad');
insert into DisponibilidadEntity (id, name) values (5016, 'Disponibilidad');
insert into DisponibilidadEntity (id, name) values (5017, 'Disponibilidad');
insert into DisponibilidadEntity (id, name) values (5018, 'Disponibilidad');
insert into DisponibilidadEntity (id, name) values (5019, 'Disponibilidad');
insert into DisponibilidadEntity (id, name) values (5020, 'Disponibilidad');
insert into DisponibilidadEntity (id, name) values (5021, 'Disponibilidad');
insert into DisponibilidadEntity (id, name) values (5022, 'Disponibilidad');
insert into DisponibilidadEntity (id, name) values (5023, 'Disponibilidad');
insert into DisponibilidadEntity (id, name) values (5024, 'Disponibilidad');
insert into DisponibilidadEntity (id, name) values (5025, 'Disponibilidad');

insert into MascotaEntity (id, color, imagen, name, raza, sexo, cliente_id) values (5001, 'Purple', 'src/images/mascotas/mascota1.png', 'Carleen', 'Bonnet macaque', 'Female', 5017);
insert into MascotaEntity (id, color, imagen, name, raza, sexo, cliente_id) values (5002, 'Puce', 'src/images/mascotas/mascota2.png', 'Quintana', 'Onager', 'Female', 5010);
insert into MascotaEntity (id, color, imagen, name, raza, sexo, cliente_id) values (5003, 'Goldenrod', 'src/images/mascotas/mascota3.png', 'Hube', 'Possum, ring-tailed', 'Male', 5007);
insert into MascotaEntity (id, color, imagen, name, raza, sexo, cliente_id) values (5004, 'Violet', 'src/images/mascotas/mascota4.png', 'Alethea', 'Eagle, bateleur', 'Female', 5006);
insert into MascotaEntity (id, color, imagen, name, raza, sexo, cliente_id) values (5005, 'Puce', 'src/images/mascotas/mascota5.png', 'Nichole', 'Sloth, pale-throated three-toed', 'Male', 5015);
insert into MascotaEntity (id, color, imagen, name, raza, sexo, cliente_id) values (5006, 'Violet', 'src/images/mascotas/mascota6.png', 'Kai', 'Bontebok', 'Female', 5008);
insert into MascotaEntity (id, color, imagen, name, raza, sexo, cliente_id) values (5007, 'Maroon', 'src/images/mascotas/mascota7.png', 'Fawnia', 'Booby, masked', 'Female', 5023);
insert into MascotaEntity (id, color, imagen, name, raza, sexo, cliente_id) values (5008, 'Puce', 'src/images/mascotas/mascota8.png', 'Anne-marie', 'American marten', 'Female', 5017);
insert into MascotaEntity (id, color, imagen, name, raza, sexo, cliente_id) values (5009, 'Indigo', 'src/images/mascotas/mascota9.png', 'Woodman', 'Springbuck', 'Male', 5011);
insert into MascotaEntity (id, color, imagen, name, raza, sexo, cliente_id) values (5010, 'Khaki', 'src/images/mascotas/mascota10.png', 'Kimberlyn', 'Small Indian mongoose', 'Female', 5021);
insert into MascotaEntity (id, color, imagen, name, raza, sexo, cliente_id) values (5011, 'Fuscia', 'src/images/mascotas/mascota11.png', 'Berri', 'White-faced tree rat', 'Female', 5025);
insert into MascotaEntity (id, color, imagen, name, raza, sexo, cliente_id) values (5012, 'Blue', 'src/images/mascotas/mascota12.png', 'Bradly', 'Rainbow lory', 'Male', 5017);
insert into MascotaEntity (id, color, imagen, name, raza, sexo, cliente_id) values (5013, 'Violet', 'src/images/mascotas/mascota13.png', 'Kimmi', 'Capuchin, brown', 'Female', 5010);
insert into MascotaEntity (id, color, imagen, name, raza, sexo, cliente_id) values (5014, 'Yellow', 'src/images/mascotas/mascota14.png', 'Ware', 'Vulture, king', 'Male', 5009);
insert into MascotaEntity (id, color, imagen, name, raza, sexo, cliente_id) values (5015, 'Purple', 'src/images/mascotas/mascota15.png', 'Twyla', 'Swallow (unidentified)', 'Female', 5013);
insert into MascotaEntity (id, color, imagen, name, raza, sexo, cliente_id) values (5016, 'Yellow', 'src/images/mascotas/mascota16.png', 'Alaric', 'Racer, blue', 'Male', 5011);
insert into MascotaEntity (id, color, imagen, name, raza, sexo, cliente_id) values (5017, 'Blue', 'src/images/mascotas/mascota17.png', 'Louis', 'Woodchuck', 'Male', 5023);
insert into MascotaEntity (id, color, imagen, name, raza, sexo, cliente_id) values (5018, 'Mauv', 'src/images/mascotas/mascota18.png', 'Shellie', 'Gorilla, western lowland', 'Female', 5012);
insert into MascotaEntity (id, color, imagen, name, raza, sexo, cliente_id) values (5019, 'Pink', 'src/images/mascotas/mascota19.png', 'Thaddeus', 'Canadian tiger swallowtail butterfly', 'Male', 5016);
insert into MascotaEntity (id, color, imagen, name, raza, sexo, cliente_id) values (5020, 'Maroon', 'src/images/mascotas/mascota20.png', 'Dalia', 'Dove, rock', 'Female', 5025);
insert into MascotaEntity (id, color, imagen, name, raza, sexo, cliente_id) values (5021, 'Orange', 'src/images/mascotas/mascota21.png', 'Chane', 'Sparrow, rufous-collared', 'Male', 5012);
insert into MascotaEntity (id, color, imagen, name, raza, sexo, cliente_id) values (5022, 'Turquoise', 'src/images/mascotas/mascota22.png', 'Alair', 'Zorro, common', 'Male', 5014);
insert into MascotaEntity (id, color, imagen, name, raza, sexo, cliente_id) values (5023, 'Purple', 'src/images/mascotas/mascota23.png', 'Alphard', 'Weaver, chestnut', 'Male', 5019);
insert into MascotaEntity (id, color, imagen, name, raza, sexo, cliente_id) values (5024, 'Violet', 'src/images/mascotas/mascota24.png', 'Jillane', 'Deer, barasingha', 'Female', 5010);
insert into MascotaEntity (id, color, imagen, name, raza, sexo, cliente_id) values (5025, 'Fuscia', 'src/images/mascotas/mascota25.png', 'Evelyn', 'Butterfly (unidentified)', 'Female', 5019);


insert into RutaEntity (id, duracion, name) values (5001, 71, 'Farmco');
insert into RutaEntity (id, duracion, name) values (5002, 105, 'Express');
insert into RutaEntity (id, duracion, name) values (5003, 76, 'Waubesa');
insert into RutaEntity (id, duracion, name) values (5004, 11, 'Lakewood');
insert into RutaEntity (id, duracion, name) values (5005, 8, 'Stuart');
insert into RutaEntity (id, duracion, name) values (5006, 11, 'Cambridge');
insert into RutaEntity (id, duracion, name) values (5007, 60, 'Vera');
insert into RutaEntity (id, duracion, name) values (5008, 39, 'Corry');
insert into RutaEntity (id, duracion, name) values (5009, 112, 'Homewood');
insert into RutaEntity (id, duracion, name) values (5010, 12, 'Schurz');
insert into RutaEntity (id, duracion, name) values (5011, 119, 'Del Sol');
insert into RutaEntity (id, duracion, name) values (5012, 49, 'Independence');
insert into RutaEntity (id, duracion, name) values (5013, 32, 'Grayhawk');
insert into RutaEntity (id, duracion, name) values (5014, 103, 'Pleasure');
insert into RutaEntity (id, duracion, name) values (5015, 61, 'Golden Leaf');
insert into RutaEntity (id, duracion, name) values (5016, 71, 'Jana');
insert into RutaEntity (id, duracion, name) values (5017, 69, 'Green Ridge');
insert into RutaEntity (id, duracion, name) values (5018, 1, 'Larry');
insert into RutaEntity (id, duracion, name) values (5019, 29, 'Utah');
insert into RutaEntity (id, duracion, name) values (5020, 56, 'Waubesa');
insert into RutaEntity (id, duracion, name) values (5021, 33, 'Glendale');
insert into RutaEntity (id, duracion, name) values (5022, 54, 'South');
insert into RutaEntity (id, duracion, name) values (5023, 72, 'Dayton');
insert into RutaEntity (id, duracion, name) values (5024, 63, 'Buena Vista');
insert into RutaEntity (id, duracion, name) values (5025, 18, 'Sundown');

insert into TransporteEntity (id, devuelta, direccion, name, recogida) values (5001, 17, '96597 East Center', 'Old Shore', 8);
insert into TransporteEntity (id, devuelta, direccion, name, recogida) values (5002, 12, '08731 Onsgard Place', 'Shasta', 12);
insert into TransporteEntity (id, devuelta, direccion, name, recogida) values (5003, 20, '48498 Spohn Hill', 'Center', 12);
insert into TransporteEntity (id, devuelta, direccion, name, recogida) values (5004, 15, '431 5th Lane', 'Kennedy', 11);
insert into TransporteEntity (id, devuelta, direccion, name, recogida) values (5005, 18, '30 Homewood Avenue', 'Lunder', 12);
insert into TransporteEntity (id, devuelta, direccion, name, recogida) values (5006, 17, '66106 Fulton Pass', 'Charing Cross', 12);
insert into TransporteEntity (id, devuelta, direccion, name, recogida) values (5007, 12, '72 Bay Center', 'Cody', 10);
insert into TransporteEntity (id, devuelta, direccion, name, recogida) values (5008, 14, '30840 Coleman Junction', 'Helena', 12);
insert into TransporteEntity (id, devuelta, direccion, name, recogida) values (5009, 14, '3114 Sunnyside Pass', 'Carpenter', 11);
insert into TransporteEntity (id, devuelta, direccion, name, recogida) values (5010, 12, '8 Maple Wood Point', 'Waxwing', 8);
insert into TransporteEntity (id, devuelta, direccion, name, recogida) values (5011, 19, '81 Old Gate Center', 'Continental', 9);
insert into TransporteEntity (id, devuelta, direccion, name, recogida) values (5012, 13, '77 Bartillon Road', 'Londonderry', 10);
insert into TransporteEntity (id, devuelta, direccion, name, recogida) values (5013, 20, '62 Toban Circle', 'Memorial', 11);
insert into TransporteEntity (id, devuelta, direccion, name, recogida) values (5014, 13, '307 Saint Paul Avenue', 'Forster', 11);
insert into TransporteEntity (id, devuelta, direccion, name, recogida) values (5015, 18, '2 Mallard Park', 'Sundown', 9);
insert into TransporteEntity (id, devuelta, direccion, name, recogida) values (5016, 14, '8750 Lighthouse Bay Lane', 'Myrtle', 9);
insert into TransporteEntity (id, devuelta, direccion, name, recogida) values (5017, 20, '0382 High Crossing Junction', 'Hoffman', 9);
insert into TransporteEntity (id, devuelta, direccion, name, recogida) values (5018, 17, '9584 Knutson Circle', 'Toban', 9);
insert into TransporteEntity (id, devuelta, direccion, name, recogida) values (5019, 19, '9 Clarendon Center', 'Linden', 9);
insert into TransporteEntity (id, devuelta, direccion, name, recogida) values (5020, 15, '236 Reinke Place', 'Eastwood', 10);
insert into TransporteEntity (id, devuelta, direccion, name, recogida) values (5021, 14, '32537 Graedel Park', 'Garrison', 8);
insert into TransporteEntity (id, devuelta, direccion, name, recogida) values (5022, 12, '9 Mariners Cove Pass', 'Meadow Vale', 10);
insert into TransporteEntity (id, devuelta, direccion, name, recogida) values (5023, 14, '90 Spenser Place', 'Eagle Crest', 11);
insert into TransporteEntity (id, devuelta, direccion, name, recogida) values (5024, 17, '3490 Lillian Plaza', 'Fieldstone', 12);
insert into TransporteEntity (id, devuelta, direccion, name, recogida) values (5025, 13, '561 Hoepker Terrace', 'Larry', 9);

--Calificacion Cliente
insert into CalificacionEntity (id, name, puntaje, cliente_id) values (5001, 'CalificacionCliente', 5, 5001);
insert into CalificacionEntity (id, name, puntaje, cliente_id) values (5002, 'CalificacionCliente', 1, 5002);
insert into CalificacionEntity (id, name, puntaje, cliente_id) values (5003, 'CalificacionCliente', 3, 5003);
insert into CalificacionEntity (id, name, puntaje, cliente_id) values (5004, 'CalificacionCliente', 3, 5004);
insert into CalificacionEntity (id, name, puntaje, cliente_id) values (5005, 'CalificacionCliente', 3, 5005);
insert into CalificacionEntity (id, name, puntaje, cliente_id) values (5006, 'CalificacionCliente', 2, 5006);
insert into CalificacionEntity (id, name, puntaje, cliente_id) values (5007, 'CalificacionCliente', 3, 5007);
insert into CalificacionEntity (id, name, puntaje, cliente_id) values (5008, 'CalificacionCliente', 1, 5008);
insert into CalificacionEntity (id, name, puntaje, cliente_id) values (5009, 'CalificacionCliente', 1, 5009);
insert into CalificacionEntity (id, name, puntaje, cliente_id) values (5010, 'CalificacionCliente', 4, 5010);
insert into CalificacionEntity (id, name, puntaje, cliente_id) values (5011, 'CalificacionCliente', 3, 5011);
insert into CalificacionEntity (id, name, puntaje, cliente_id) values (5012, 'CalificacionCliente', 1, 5012);
insert into CalificacionEntity (id, name, puntaje, cliente_id) values (5013, 'CalificacionCliente', 3, 5013);
insert into CalificacionEntity (id, name, puntaje, cliente_id) values (5014, 'CalificacionCliente', 4, 5014);
insert into CalificacionEntity (id, name, puntaje, cliente_id) values (5015, 'CalificacionCliente', 2, 5015);
insert into CalificacionEntity (id, name, puntaje, cliente_id) values (5016, 'CalificacionCliente', 3, 5016);
insert into CalificacionEntity (id, name, puntaje, cliente_id) values (5017, 'CalificacionCliente', 5, 5017);
insert into CalificacionEntity (id, name, puntaje, cliente_id) values (5018, 'CalificacionCliente', 5, 5018);
insert into CalificacionEntity (id, name, puntaje, cliente_id) values (5019, 'CalificacionCliente', 1, 5019);
insert into CalificacionEntity (id, name, puntaje, cliente_id) values (5020, 'CalificacionCliente', 5, 5020);
insert into CalificacionEntity (id, name, puntaje, cliente_id) values (5021, 'CalificacionCliente', 3, 5021);
insert into CalificacionEntity (id, name, puntaje, cliente_id) values (5022, 'CalificacionCliente', 3, 5022);
insert into CalificacionEntity (id, name, puntaje, cliente_id) values (5023, 'CalificacionCliente', 5, 5023);
insert into CalificacionEntity (id, name, puntaje, cliente_id) values (5024, 'CalificacionCliente', 3, 5024);
insert into CalificacionEntity (id, name, puntaje, cliente_id) values (5025, 'CalificacionCliente', 1, 5025);


insert into EmpleadoEntity (id, cargo, cedula, correo, edad, imagen, name) values (5001, 'Aseador', '1090009879', 'hperfect0@wp.com', 29, 'src/images/empleados/aseador-f1.png', 'Hadley Perfect');
insert into EmpleadoEntity (id, cargo, cedula, correo, edad, imagen, name) values (5002, 'Cuidador', '1909909609', 'cedney1@nydailynews.com', 57, 'src/images/empleados/cuidador-f1.png', 'Casi Edney');
insert into EmpleadoEntity (id, cargo, cedula, correo, edad, imagen, name) values (5003, 'Entrenador', '1000999000', 'lwillimott2@paypal.com', 46, 'src/images/empleados/entrenador-f1.png', 'Laney Willimott');
insert into EmpleadoEntity (id, cargo, cedula, correo, edad, imagen, name) values (5004, 'Paseador', '1900800879', 'vhallex3@tinypic.com', 28, 'src/images/empleados/paseo-m1.png', 'Vin Hallex');
insert into EmpleadoEntity (id, cargo, cedula, correo, edad, imagen, name) values (5005, 'Paseador', '1906060000', 'happleford4@columbia.edu', 24, 'src/images/empleados/paseo-f1.png', 'Hasty Appleford');
insert into EmpleadoEntity (id, cargo, cedula, correo, edad, imagen, name) values (5006, 'Entrenador', '1009097589', 'cfagence5@psu.edu', 21, 'src/images/empleados/entrenador-f2.png', 'Courtney Fagence');
insert into EmpleadoEntity (id, cargo, cedula, correo, edad, imagen, name) values (5007, 'Cuidador', '1009908090', 'lroma6@amazon.co.uk', 31, 'src/images/empleados/cuidador-f2.png', 'Lenore Roma');
insert into EmpleadoEntity (id, cargo, cedula, correo, edad, imagen, name) values (5008, 'Aseador', '1900090906', 'kwillment7@salon.com', 56, 'src/images/empleados/aseador-m1.png', 'Kelvin Willment');
insert into EmpleadoEntity (id, cargo, cedula, correo, edad, imagen, name) values (5009, 'Aseador', '1000980000', 'jwakeham8@eepurl.com', 37, 'src/images/empleados/aseador-f2.png', 'Juana Wakeham');
insert into EmpleadoEntity (id, cargo, cedula, correo, edad, imagen, name) values (5010, 'Cuidador', '1989989000', 'fneame9@twitpic.com', 26, 'src/images/empleados/cuidador-f3.png', 'Fredericka Neame');
insert into EmpleadoEntity (id, cargo, cedula, correo, edad, imagen, name) values (5011, 'Entrenador', '1800900900', 'cbarabischa@gizmodo.com', 21, 'src/images/empleados/entrenador-f3.png', 'Caroljean Barabisch');
insert into EmpleadoEntity (id, cargo, cedula, correo, edad, imagen, name) values (5012, 'Paseador', '1000007000', 'hgwinnellb@rambler.ru', 26, 'src/images/empleados/paseo-f2.png', 'Heidi Gwinnell');
insert into EmpleadoEntity (id, cargo, cedula, correo, edad, imagen, name) values (5013, 'Cuidador', '1809999009', 'wcursonsc@google.fr', 33, 'src/images/empleados/cuidador-f4.png', 'Welch Cursons');
insert into EmpleadoEntity (id, cargo, cedula, correo, edad, imagen, name) values (5014, 'Cuidador', '1890068087', 'sbollandsd@latimes.com', 21, 'src/images/empleados/cuidador-m1.png', 'Stillmann Bollands');
insert into EmpleadoEntity (id, cargo, cedula, correo, edad, imagen, name) values (5015, 'Cuidador', '1870979090', 'cmaine@buzzfeed.com', 60, 'src/images/empleados/cuidador-f5.png', 'Candice Main');
insert into EmpleadoEntity (id, cargo, cedula, correo, edad, imagen, name) values (5016, 'Aseador', '1998906409', 'bpilsworthf@sogou.com', 60, 'src/images/empleados/aseador-m2.png', 'Beryle Pilsworth');
insert into EmpleadoEntity (id, cargo, cedula, correo, edad, imagen, name) values (5017, 'Cuidador', '1906900069', 'jsouterg@theguardian.com', 19, 'src/images/empleados/cuidador-f6.png', 'Janice Souter');
insert into EmpleadoEntity (id, cargo, cedula, correo, edad, imagen, name) values (5018, 'Entrenador', '1906098804', 'rwhittonh@youtu.be', 33, 'src/images/empleados/entrenador-f4.png', 'Rosy Whitton');
insert into EmpleadoEntity (id, cargo, cedula, correo, edad, imagen, name) values (5019, 'Cuidador', '1600900990', 'abitchenoi@cisco.com', 47, 'src/images/empleados/cuidador-m2.png', 'Avrom Bitcheno');
insert into EmpleadoEntity (id, cargo, cedula, correo, edad, imagen, name) values (5020, 'Cuidador', '1000099060', 'khogginsj@ted.com', 35, 'src/images/empleados/cuidador-f7.png', 'Klara Hoggins');
insert into EmpleadoEntity (id, cargo, cedula, correo, edad, imagen, name) values (5021, 'Cuidador', '1890089088', 'wnovisk@hibu.com', 38, 'src/images/empleados/cuidador-m3.png', 'Willie Novis');
insert into EmpleadoEntity (id, cargo, cedula, correo, edad, imagen, name) values (5022, 'Entrenador', '1099798809', 'mristel@privacy.gov.au', 33, 'src/images/empleados/entrenador-f5.png', 'Misha Riste');
insert into EmpleadoEntity (id, cargo, cedula, correo, edad, imagen, name) values (5023, 'Cuidador', '1800000680', 'tclemensm@nytimes.com', 33, 'src/images/empleados/cuidador-m4.png', 'Terence Clemens');
insert into EmpleadoEntity (id, cargo, cedula, correo, edad, imagen, name) values (5024, 'Entrenador', '1769897998', 'cbrennonn@360.cn', 26, 'src/images/empleados/cesar-millan.png', 'Cesar Millan');
insert into EmpleadoEntity (id, cargo, cedula, correo, edad, imagen, name) values (5025, 'Cuidador', '1709090099', 'dgrobo@sourceforge.net', 30, 'src/images/empleados/cuidador-m5.png', 'Daryl Grob');

--Calificacion Empleado
insert into CalificacionEntity (id, name, puntaje, empleado_id) values (5101, 'CalificacionEmpleado', 4, 5001);
insert into CalificacionEntity (id, name, puntaje, empleado_id) values (5102, 'CalificacionEmpleado', 3, 5002);
insert into CalificacionEntity (id, name, puntaje, empleado_id) values (5103, 'CalificacionEmpleado', 5, 5003);
insert into CalificacionEntity (id, name, puntaje, empleado_id) values (5104, 'CalificacionEmpleado', 5, 5004);
insert into CalificacionEntity (id, name, puntaje, empleado_id) values (5105, 'CalificacionEmpleado', 1, 5005);
insert into CalificacionEntity (id, name, puntaje, empleado_id) values (5106, 'CalificacionEmpleado', 5, 5006);
insert into CalificacionEntity (id, name, puntaje, empleado_id) values (5107, 'CalificacionEmpleado', 2, 5007);
insert into CalificacionEntity (id, name, puntaje, empleado_id) values (5108, 'CalificacionEmpleado', 3, 5008);
insert into CalificacionEntity (id, name, puntaje, empleado_id) values (5109, 'CalificacionEmpleado', 1, 5009);
insert into CalificacionEntity (id, name, puntaje, empleado_id) values (5110, 'CalificacionEmpleado', 1, 5010);
insert into CalificacionEntity (id, name, puntaje, empleado_id) values (5111, 'CalificacionEmpleado', 1, 5011);
insert into CalificacionEntity (id, name, puntaje, empleado_id) values (5112, 'CalificacionEmpleado', 5, 5012);
insert into CalificacionEntity (id, name, puntaje, empleado_id) values (5113, 'CalificacionEmpleado', 4, 5013);
insert into CalificacionEntity (id, name, puntaje, empleado_id) values (5114, 'CalificacionEmpleado', 2, 5014);
insert into CalificacionEntity (id, name, puntaje, empleado_id) values (5115, 'CalificacionEmpleado', 3, 5015);
insert into CalificacionEntity (id, name, puntaje, empleado_id) values (5116, 'CalificacionEmpleado', 1, 5016);
insert into CalificacionEntity (id, name, puntaje, empleado_id) values (5117, 'CalificacionEmpleado', 5, 5017);
insert into CalificacionEntity (id, name, puntaje, empleado_id) values (5118, 'CalificacionEmpleado', 4, 5018);
insert into CalificacionEntity (id, name, puntaje, empleado_id) values (5119, 'CalificacionEmpleado', 2, 5019);
insert into CalificacionEntity (id, name, puntaje, empleado_id) values (5120, 'CalificacionEmpleado', 1, 5020);
insert into CalificacionEntity (id, name, puntaje, empleado_id) values (5121, 'CalificacionEmpleado', 1, 5021);
insert into CalificacionEntity (id, name, puntaje, empleado_id) values (5122, 'CalificacionEmpleado', 2, 5022);
insert into CalificacionEntity (id, name, puntaje, empleado_id) values (5123, 'CalificacionEmpleado', 4, 5023);
insert into CalificacionEntity (id, name, puntaje, empleado_id) values (5124, 'CalificacionEmpleado', 1, 5024);
insert into CalificacionEntity (id, name, puntaje, empleado_id) values (5125, 'CalificacionEmpleado', 3, 5025);

insert into PayPalEntity (id, correo, name, cliente_id) values (5001, 'leingerfield0@aboutads.info', 'PayPalService', 5001);
insert into PayPalEntity (id, correo, name, cliente_id) values (5002, 'fbellin1@cmu.edu', 'PayPalService', 5009);
insert into PayPalEntity (id, correo, name, cliente_id) values (5003, 'emorfett2@ask.com', 'PayPalService', 5010);
insert into PayPalEntity (id, correo, name, cliente_id) values (5004, 'smapston3@godaddy.com', 'PayPalService', 5011);
insert into PayPalEntity (id, correo, name, cliente_id) values (5005, 'sburchatt4@paginegialle.it', 'PayPalService', 5017);
insert into PayPalEntity (id, correo, name, cliente_id) values (5006, 'ppuden5@ovh.net', 'PayPalService', 5022);
insert into PayPalEntity (id, correo, name, cliente_id) values (5007, 'fshilito6@cargocollective.com', 'PayPalService', 5012);
insert into PayPalEntity (id, correo, name, cliente_id) values (5008, 'bhimpson7@parallels.com', 'PayPalService', 5021);
insert into PayPalEntity (id, correo, name, cliente_id) values (5009, 'mgarthshore8@google.com.au', 'PayPalService', 5018);
insert into PayPalEntity (id, correo, name, cliente_id) values (5010, 'ftogwell9@dion.ne.jp', 'PayPalService', 5013);

insert into PseEntity (id, correo, name, cliente_id) values (5001, 'soak0@tumblr.com', 'PSE Service', 5025);
insert into PseEntity (id, correo, name, cliente_id) values (5002, 'dgyppes1@upenn.edu', 'PSE Service', 5020);
insert into PseEntity (id, correo, name, cliente_id) values (5003, 'dcasillis2@mashable.com', 'PSE Service', 5015);
insert into PseEntity (id, correo, name, cliente_id) values (5004, 'cpanichelli3@google.de', 'PSE Service', 5016);
insert into PseEntity (id, correo, name, cliente_id) values (5005, 'rflag4@godaddy.com', 'PSE Service', 5023);
insert into PseEntity (id, correo, name, cliente_id) values (5006, 'ewhiting5@cargocollective.com', 'PSE Service', 5007);
insert into PseEntity (id, correo, name, cliente_id) values (5007, 'wshurey6@house.gov', 'PSE Service', 5024);
insert into PseEntity (id, correo, name, cliente_id) values (5008, 'mmurthwaite7@npr.org', 'PSE Service', 5008);
insert into PseEntity (id, correo, name, cliente_id) values (5009, 'cmichal8@vkontakte.ru', 'PSE Service', 5005);
insert into PseEntity (id, correo, name, cliente_id) values (5010, 'lboeter9@salon.com', 'PSE Service', 5002);

insert into TarjetaCreditoEntity (id, codigoseguridad, fechavencimiento, name, numerotarjeta, cliente_id) values (5001, '080', '4/1/2021', 'AmericanExpress', '3585497271082237', 5003);
insert into TarjetaCreditoEntity (id, codigoseguridad, fechavencimiento, name, numerotarjeta, cliente_id) values (5002, '000', '10/12/2019', 'AmericanExpress', '58939295550546246', 5004);
insert into TarjetaCreditoEntity (id, codigoseguridad, fechavencimiento, name, numerotarjeta, cliente_id) values (5003, '008', '10/29/2022', 'MasterCard', '3537589413201839', 5006);
insert into TarjetaCreditoEntity (id, codigoseguridad, fechavencimiento, name, numerotarjeta, cliente_id) values (5004, '080', '10/21/2023', 'Visa', '3560508118729456', 5014);
insert into TarjetaCreditoEntity (id, codigoseguridad, fechavencimiento, name, numerotarjeta, cliente_id) values (5005, '099', '7/8/2021', 'AmericanExpress', '3553614343168624', 5015);
insert into TarjetaCreditoEntity (id, codigoseguridad, fechavencimiento, name, numerotarjeta, cliente_id) values (5006, '900', '4/19/2023', 'AmericanExpress', '4041373363351911', 5019);
insert into TarjetaCreditoEntity (id, codigoseguridad, fechavencimiento, name, numerotarjeta, cliente_id) values (5007, '099', '7/23/2022', 'AmericanExpress', '3540136385240489', 5020);
insert into TarjetaCreditoEntity (id, codigoseguridad, fechavencimiento, name, numerotarjeta, cliente_id) values (5008, '900', '5/10/2023', 'MasterCard', '6762653942487142', 5008);
insert into TarjetaCreditoEntity (id, codigoseguridad, fechavencimiento, name, numerotarjeta, cliente_id) values (5009, '007', '8/1/2022', 'AmericanExpress', '3586083934853179', 5024);
insert into TarjetaCreditoEntity (id, codigoseguridad, fechavencimiento, name, numerotarjeta, cliente_id) values (5010, '090', '11/25/2023', 'AmericanExpress', '3553950193413433', 5009);

--Servicio Aseo

insert into ServicioEntity (id, dtype, costo, duracion, estado, fecha, hora, name, cliente_id, empleado_id, mascota_id) values (5001, 'AseoEntity', 606261.43, 25, 0, '2/17/2018', 18, 'ServicioAseo', 5003, 5012, 5024);
insert into ServicioEntity (id, dtype, costo, duracion, estado, fecha, hora, name, cliente_id, empleado_id, mascota_id) values (5002, 'AseoEntity', 277398.39, 22, 1, '1/16/2018', 17, 'ServicioAseo', 5014, 5001, 5021);
insert into ServicioEntity (id, dtype, costo, duracion, estado, fecha, hora, name, cliente_id, empleado_id, mascota_id) values (5003, 'AseoEntity', 681171.65, 9, 1, '10/26/2017', 23, 'ServicioAseo', 5001, 5011, 5008);
insert into ServicioEntity (id, dtype, costo, duracion, estado, fecha, hora, name, cliente_id, empleado_id, mascota_id) values (5004, 'AseoEntity', 154460.95, 21, 0, '2/27/2018', 11, 'ServicioAseo', 5025, 5007, 5023);
insert into ServicioEntity (id, dtype, costo, duracion, estado, fecha, hora, name, cliente_id, empleado_id, mascota_id) values (5005, 'AseoEntity', 533576.97, 15, 1, '5/25/2017', 9, 'ServicioAseo', 5021, 5012, 5017);
insert into ServicioEntity (id, dtype, costo, duracion, estado, fecha, hora, name, cliente_id, empleado_id, mascota_id) values (5006, 'AseoEntity', 750062.58, 11, 1, '8/8/2017', 1, 'ServicioAseo', 5009, 5013, 5002);
insert into ServicioEntity (id, dtype, costo, duracion, estado, fecha, hora, name, cliente_id, empleado_id, mascota_id) values (5007, 'AseoEntity', 577664.27, 24, 0, '9/5/2017', 10, 'ServicioAseo', 5018, 5023, 5023);
insert into ServicioEntity (id, dtype, costo, duracion, estado, fecha, hora, name, cliente_id, empleado_id, mascota_id) values (5008, 'AseoEntity', 749961.00, 25, 0, '9/18/2017', 22, 'ServicioAseo', 5014, 5011, 5005);
insert into ServicioEntity (id, dtype, costo, duracion, estado, fecha, hora, name, cliente_id, empleado_id, mascota_id) values (5009, 'AseoEntity', 696524.20, 2, 0, '5/15/2018', 14, 'ServicioAseo', 5009, 5013, 5018);
insert into ServicioEntity (id, dtype, costo, duracion, estado, fecha, hora, name, cliente_id, empleado_id, mascota_id) values (5010, 'AseoEntity', 686103.53, 10, 1, '12/7/2017', 21, 'ServicioAseo', 5025, 5016, 5019);

insert into AseoEntity (id, banho, dientes, peluqueria) values (5001, 1, 0, 1);
insert into AseoEntity (id, banho, dientes, peluqueria) values (5002, 1, 0, 0);
insert into AseoEntity (id, banho, dientes, peluqueria) values (5003, 1, 1, 1);
insert into AseoEntity (id, banho, dientes, peluqueria) values (5004, 1, 1, 1);
insert into AseoEntity (id, banho, dientes, peluqueria) values (5005, 1, 1, 0);
insert into AseoEntity (id, banho, dientes, peluqueria) values (5006, 1, 1, 1);
insert into AseoEntity (id, banho, dientes, peluqueria) values (5007, 1, 1, 0);
insert into AseoEntity (id, banho, dientes, peluqueria) values (5008, 0, 0, 0);
insert into AseoEntity (id, banho, dientes, peluqueria) values (5009, 0, 0, 1);
insert into AseoEntity (id, banho, dientes, peluqueria) values (5010, 1, 0, 1);

insert into FacturaEntity (id, name, pagado, valor, cliente_id, servicio_id, tarjeta_id) values (5001, 'FacturaAseo', 1, 606261.43, 5003, 5001, 5001);
insert into FacturaEntity (id, name, pagado, valor, cliente_id, servicio_id, tarjeta_id) values (5002, 'FacturaAseo', 0, 277398.39, 5014, 5002, 5004);
insert into FacturaEntity (id, name, pagado, valor, cliente_id, servicio_id, paypal_id) values (5003, 'FacturaAseo', 0, 681171.65, 5001, 5003, 5001);
insert into FacturaEntity (id, name, pagado, valor, cliente_id, servicio_id, pse_id) values (5004, 'FacturaAseo', 0, 154460.95, 5025, 5004, 5001);
insert into FacturaEntity (id, name, pagado, valor, cliente_id, servicio_id, paypal_id) values (5005, 'FacturaAseo', 0, 533576.97, 5021, 5005, 5008);
insert into FacturaEntity (id, name, pagado, valor, cliente_id, servicio_id, paypal_id) values (5006, 'FacturaAseo', 1, 750062.58, 5009, 5006, 5002);
insert into FacturaEntity (id, name, pagado, valor, cliente_id, servicio_id, paypal_id) values (5007, 'FacturaAseo', 1, 577664.27, 5018, 5007, 5009);
insert into FacturaEntity (id, name, pagado, valor, cliente_id, servicio_id, tarjeta_id) values (5008, 'FacturaAseo', 1, 749961.00, 5014, 5008, 5004);
insert into FacturaEntity (id, name, pagado, valor, cliente_id, servicio_id, tarjeta_id) values (5009, 'FacturaAseo', 1, 696524.20, 5009, 5009, 5010);
insert into FacturaEntity (id, name, pagado, valor, cliente_id, servicio_id, paypal_id) values (5010, 'FacturaAseo', 1, 686103.53, 5025, 5010, 5003);

--Servicio Entrenamiento

insert into ServicioEntity (id, dtype, costo, duracion, estado, fecha, hora, name, cliente_id, empleado_id, mascota_id) values (5101, 'EntrenamientoEntity', 639507.81, 9, 0, '11/23/2017', 21, 'ServicioEntrenamiento', 5017, 5006, 5003);
insert into ServicioEntity (id, dtype, costo, duracion, estado, fecha, hora, name, cliente_id, empleado_id, mascota_id) values (5102, 'EntrenamientoEntity', 696055.85, 1, 1, '10/11/2017', 10, 'ServicioEntrenamiento', 5009, 5025, 5010);
insert into ServicioEntity (id, dtype, costo, duracion, estado, fecha, hora, name, cliente_id, empleado_id, mascota_id) values (5103, 'EntrenamientoEntity', 770101.67, 2, 0, '7/26/2018', 22, 'ServicioEntrenamiento', 5008, 5015, 5011);
insert into ServicioEntity (id, dtype, costo, duracion, estado, fecha, hora, name, cliente_id, empleado_id, mascota_id) values (5104, 'EntrenamientoEntity', 754548.83, 12, 0, '1/23/2018', 11, 'ServicioEntrenamiento', 5020, 5005, 5019);
insert into ServicioEntity (id, dtype, costo, duracion, estado, fecha, hora, name, cliente_id, empleado_id, mascota_id) values (5105, 'EntrenamientoEntity', 603313.32, 7, 0, '12/16/2017', 22, 'ServicioEntrenamiento', 5003, 5020, 5003);
insert into ServicioEntity (id, dtype, costo, duracion, estado, fecha, hora, name, cliente_id, empleado_id, mascota_id) values (5106, 'EntrenamientoEntity', 349218.61, 16, 0, '1/24/2018', 12, 'ServicioEntrenamiento', 5016, 5017, 5006);
insert into ServicioEntity (id, dtype, costo, duracion, estado, fecha, hora, name, cliente_id, empleado_id, mascota_id) values (5107, 'EntrenamientoEntity', 240538.22, 2, 1, '4/5/2017', 9, 'ServicioEntrenamiento', 5016, 5019, 5022);
insert into ServicioEntity (id, dtype, costo, duracion, estado, fecha, hora, name, cliente_id, empleado_id, mascota_id) values (5108, 'EntrenamientoEntity', 908249.41, 15, 1, '1/2/2018', 17, 'ServicioEntrenamiento', 5021, 5015, 5002);
insert into ServicioEntity (id, dtype, costo, duracion, estado, fecha, hora, name, cliente_id, empleado_id, mascota_id) values (5109, 'EntrenamientoEntity', 447616.20, 16, 0, '3/16/2018', 22, 'ServicioEntrenamiento', 5023, 5006, 5014);
insert into ServicioEntity (id, dtype, costo, duracion, estado, fecha, hora, name, cliente_id, empleado_id, mascota_id) values (5110, 'EntrenamientoEntity', 590947.48, 19, 1, '4/21/2018', 2, 'ServicioEntrenamiento', 5020, 5012, 5006);

insert into EntrenamientoEntity (id, tipo, transporte_id) values (5001, 'Diario', 5012);
insert into EntrenamientoEntity (id, tipo, transporte_id) values (5002, 'Diario', 5002);
insert into EntrenamientoEntity (id, tipo, transporte_id) values (5003, 'Nunca', 5010);
insert into EntrenamientoEntity (id, tipo, transporte_id) values (5004, 'Anual', 5001);
insert into EntrenamientoEntity (id, tipo, transporte_id) values (5005, 'Nunca', 5023);
insert into EntrenamientoEntity (id, tipo, transporte_id) values (5006, 'Semanal', 5014);
insert into EntrenamientoEntity (id, tipo, transporte_id) values (5007, 'Nunca', 5005);
insert into EntrenamientoEntity (id, tipo, transporte_id) values (5008, 'Semanal', 5020);
insert into EntrenamientoEntity (id, tipo, transporte_id) values (5009, 'Anual', 5017);
insert into EntrenamientoEntity (id, tipo, transporte_id) values (5010, 'Anual', 5010);

insert into FacturaEntity (id, name, pagado, valor, cliente_id, servicio_id, paypal_id) values (5101, 'FacturaEntrenamiento', 1, 639507.81, 5017, 5101, 5005);
insert into FacturaEntity (id, name, pagado, valor, cliente_id, servicio_id, paypal_id) values (5102, 'FacturaEntrenamiento', 0, 696055.85, 5009, 5102, 5009);
insert into FacturaEntity (id, name, pagado, valor, cliente_id, servicio_id, pse_id) values (5103, 'FacturaEntrenamiento', 1, 770101.67, 5008, 5103, 5008);
insert into FacturaEntity (id, name, pagado, valor, cliente_id, servicio_id, tarjeta_id) values (5104, 'FacturaEntrenamiento', 1, 754548.83, 5020, 5104, 5007);
insert into FacturaEntity (id, name, pagado, valor, cliente_id, servicio_id, tarjeta_id) values (5105, 'FacturaEntrenamiento', 1, 603313.32, 5003, 5105, 5001);
insert into FacturaEntity (id, name, pagado, valor, cliente_id, servicio_id, pse_id) values (5106, 'FacturaEntrenamiento', 0, 349218.61, 5016, 5106, 5004);
insert into FacturaEntity (id, name, pagado, valor, cliente_id, servicio_id, pse_id) values (5107, 'FacturaEntrenamiento', 0, 240538.22, 5016, 5107, 5004);
insert into FacturaEntity (id, name, pagado, valor, cliente_id, servicio_id, paypal_id) values (5108, 'FacturaEntrenamiento', 1, 908249.41, 5021, 5108, 5008);
insert into FacturaEntity (id, name, pagado, valor, cliente_id, servicio_id, pse_id) values (5109, 'FacturaEntrenamiento', 0, 447616.20, 5023, 5109, 5005);
insert into FacturaEntity (id, name, pagado, valor, cliente_id, servicio_id, tarjeta_id) values (5110, 'FacturaEntrenamiento', 1, 590947.48, 5020, 5110, 5007);

--Servicio Hotel

insert into ServicioEntity (id, dtype, costo, duracion, estado, fecha, hora, name, cliente_id, empleado_id, mascota_id) values (5201, 'HotelEntity', 780631.42, 16, 1, '2/16/2018', 23, 'ServicioHotel', 5019, 5010, 5008);
insert into ServicioEntity (id, dtype, costo, duracion, estado, fecha, hora, name, cliente_id, empleado_id, mascota_id) values (5202, 'HotelEntity', 550797.19, 3, 0, '5/2/2018', 14, 'ServicioHotel', 5016, 5013, 5009);
insert into ServicioEntity (id, dtype, costo, duracion, estado, fecha, hora, name, cliente_id, empleado_id, mascota_id) values (5203, 'HotelEntity', 294694.40, 26, 0, '5/3/2017', 21, 'ServicioHotel', 5001, 5021, 5016);
insert into ServicioEntity (id, dtype, costo, duracion, estado, fecha, hora, name, cliente_id, empleado_id, mascota_id) values (5204, 'HotelEntity', 195893.61, 13, 0, '3/5/2018', 18, 'ServicioHotel', 5018, 5008, 5024);
insert into ServicioEntity (id, dtype, costo, duracion, estado, fecha, hora, name, cliente_id, empleado_id, mascota_id) values (5205, 'HotelEntity', 117733.77, 19, 1, '12/13/2017', 19, 'ServicioHotel', 5022, 5014, 5005);
insert into ServicioEntity (id, dtype, costo, duracion, estado, fecha, hora, name, cliente_id, empleado_id, mascota_id) values (5206, 'HotelEntity', 163122.36, 2, 1, '10/18/2017', 13, 'ServicioHotel', 5017, 5011, 5016);
insert into ServicioEntity (id, dtype, costo, duracion, estado, fecha, hora, name, cliente_id, empleado_id, mascota_id) values (5207, 'HotelEntity', 497681.79, 10, 1, '2/10/2018', 15, 'ServicioHotel', 5007, 5023, 5014);
insert into ServicioEntity (id, dtype, costo, duracion, estado, fecha, hora, name, cliente_id, empleado_id, mascota_id) values (5208, 'HotelEntity', 881885.41, 23, 0, '1/9/2018', 15, 'ServicioHotel', 5020, 5001, 5022);
insert into ServicioEntity (id, dtype, costo, duracion, estado, fecha, hora, name, cliente_id, empleado_id, mascota_id) values (5209, 'HotelEntity', 329790.19, 4, 0, '7/1/2018', 21, 'ServicioHotel', 5017, 5015, 5010);
insert into ServicioEntity (id, dtype, costo, duracion, estado, fecha, hora, name, cliente_id, empleado_id, mascota_id) values (5210, 'HotelEntity', 715109.30, 25, 0, '10/1/2017', 12, 'ServicioHotel', 5008, 5019, 5016);

insert into HotelEntity (id, tiempohospedaje, transporte_id) values (5001, 8, 5002);
insert into HotelEntity (id, tiempohospedaje, transporte_id) values (5002, 25, 5004);
insert into HotelEntity (id, tiempohospedaje, transporte_id) values (5003, 29, 5011);
insert into HotelEntity (id, tiempohospedaje, transporte_id) values (5004, 30, 5008);
insert into HotelEntity (id, tiempohospedaje, transporte_id) values (5005, 3, 5020);
insert into HotelEntity (id, tiempohospedaje, transporte_id) values (5006, 25, 5004);
insert into HotelEntity (id, tiempohospedaje, transporte_id) values (5007, 2, 5008);
insert into HotelEntity (id, tiempohospedaje, transporte_id) values (5008, 28, 5008);
insert into HotelEntity (id, tiempohospedaje, transporte_id) values (5009, 19, 5021);
insert into HotelEntity (id, tiempohospedaje, transporte_id) values (5010, 29, 5003);

insert into FacturaEntity (id, name, pagado, valor, cliente_id, servicio_id, tarjeta_id) values (5201, 'FacturaHotel', 0, 780631.42, 5019, 5201, 5006);
insert into FacturaEntity (id, name, pagado, valor, cliente_id, servicio_id, pse_id) values (5202, 'FacturaHotel', 0, 550797.19, 5016, 5202, 5004);
insert into FacturaEntity (id, name, pagado, valor, cliente_id, servicio_id, paypal_id) values (5203, 'FacturaHotel', 1, 294694.40, 5001, 5203, 5001);
insert into FacturaEntity (id, name, pagado, valor, cliente_id, servicio_id, paypal_id) values (5204, 'FacturaHotel', 1, 195893.61, 5018, 5204, 5009);
insert into FacturaEntity (id, name, pagado, valor, cliente_id, servicio_id, paypal_id) values (5205, 'FacturaHotel', 1, 117733.77, 5022, 5205, 5006);
insert into FacturaEntity (id, name, pagado, valor, cliente_id, servicio_id, paypal_id) values (5206, 'FacturaHotel', 0, 163122.36, 5017, 5206, 5005);
insert into FacturaEntity (id, name, pagado, valor, cliente_id, servicio_id, pse_id) values (5207, 'FacturaHotel', 0, 497681.79, 5007, 5207, 5006);
insert into FacturaEntity (id, name, pagado, valor, cliente_id, servicio_id, tarjeta_id) values (5208, 'FacturaHotel', 1, 881885.41, 5020, 5208, 5007);
insert into FacturaEntity (id, name, pagado, valor, cliente_id, servicio_id, tarjeta_id) values (5209, 'FacturaHotel', 1, 329790.19, 5017, 5209, 5005);
insert into FacturaEntity (id, name, pagado, valor, cliente_id, servicio_id, pse_id) values (5210, 'FacturaHotel', 0, 715109.30, 5008, 5210, 5008);

--Servicio Paseo

insert into ServicioEntity (id, dtype, costo, duracion, estado, fecha, hora, name, cliente_id, empleado_id, mascota_id) values (5301, 'PaseoEntity', 968841.01, 18, 0, '12/27/2017', 16, 'ServicioPaseo', 5017, 5018, 5002);
insert into ServicioEntity (id, dtype, costo, duracion, estado, fecha, hora, name, cliente_id, empleado_id, mascota_id) values (5302, 'PaseoEntity', 809814.16, 28, 0, '8/16/2017', 17, 'ServicioPaseo', 5016, 5004, 5005);
insert into ServicioEntity (id, dtype, costo, duracion, estado, fecha, hora, name, cliente_id, empleado_id, mascota_id) values (5303, 'PaseoEntity', 176519.19, 25, 1, '12/16/2017', 22, 'ServicioPaseo', 5022, 5007, 5021);
insert into ServicioEntity (id, dtype, costo, duracion, estado, fecha, hora, name, cliente_id, empleado_id, mascota_id) values (5304, 'PaseoEntity', 151371.55, 17, 0, '6/15/2017', 3, 'ServicioPaseo', 5001, 5009, 5004);
insert into ServicioEntity (id, dtype, costo, duracion, estado, fecha, hora, name, cliente_id, empleado_id, mascota_id) values (5305, 'PaseoEntity', 381432.03, 16, 0, '6/7/2017', 19, 'ServicioPaseo', 5004, 5001, 5017);
insert into ServicioEntity (id, dtype, costo, duracion, estado, fecha, hora, name, cliente_id, empleado_id, mascota_id) values (5306, 'PaseoEntity', 709412.23, 22, 0, '8/2/2017', 13, 'ServicioPaseo', 5019, 5007, 5014);
insert into ServicioEntity (id, dtype, costo, duracion, estado, fecha, hora, name, cliente_id, empleado_id, mascota_id) values (5307, 'PaseoEntity', 868219.07, 6, 1, '4/22/2017', 20, 'ServicioPaseo', 5023, 5005, 5021);
insert into ServicioEntity (id, dtype, costo, duracion, estado, fecha, hora, name, cliente_id, empleado_id, mascota_id) values (5308, 'PaseoEntity', 176196.75, 20, 1, '10/7/2017', 5, 'ServicioPaseo', 5012, 5014, 5007);
insert into ServicioEntity (id, dtype, costo, duracion, estado, fecha, hora, name, cliente_id, empleado_id, mascota_id) values (5309, 'PaseoEntity', 110569.23, 12, 0, '4/15/2017', 21, 'ServicioPaseo', 5014, 5013, 5011);
insert into ServicioEntity (id, dtype, costo, duracion, estado, fecha, hora, name, cliente_id, empleado_id, mascota_id) values (5310, 'PaseoEntity', 909426.65, 17, 0, '2/22/2018', 9, 'ServicioPaseo', 5010, 5012, 5017);
insert into ServicioEntity (id, dtype, costo, duracion, estado, fecha, hora, name, cliente_id, empleado_id, mascota_id) values (5311, 'PaseoEntity', 52257.31, 24, 0, '8/3/2017', 22, 'ServicioPaseo', 5004, 5018, 5004);
insert into ServicioEntity (id, dtype, costo, duracion, estado, fecha, hora, name, cliente_id, empleado_id, mascota_id) values (5312, 'PaseoEntity', 983855.14, 10, 0, '2/14/2018', 8, 'ServicioPaseo', 5025, 5025, 5001);
insert into ServicioEntity (id, dtype, costo, duracion, estado, fecha, hora, name, cliente_id, empleado_id, mascota_id) values (5313, 'PaseoEntity', 82414.58, 24, 1, '4/5/2018', 5, 'ServicioPaseo', 5001, 5013, 5007);
insert into ServicioEntity (id, dtype, costo, duracion, estado, fecha, hora, name, cliente_id, empleado_id, mascota_id) values (5314, 'PaseoEntity', 214407.69, 13, 0, '7/10/2017', 22, 'ServicioPaseo', 5015, 5023, 5022);
insert into ServicioEntity (id, dtype, costo, duracion, estado, fecha, hora, name, cliente_id, empleado_id, mascota_id) values (5315, 'PaseoEntity', 48797.50, 4, 1, '4/27/2018', 24, 'ServicioPaseo', 5009, 5015, 5024);

insert into PaseoEntity (id, capmax, ruta_id) values (5001, 9, 5007);
insert into PaseoEntity (id, capmax, ruta_id) values (5002, 7, 5007);
insert into PaseoEntity (id, capmax, ruta_id) values (5003, 5, 5020);
insert into PaseoEntity (id, capmax, ruta_id) values (5004, 9, 5001);
insert into PaseoEntity (id, capmax, ruta_id) values (5005, 9, 5020);
insert into PaseoEntity (id, capmax, ruta_id) values (5006, 6, 5020);
insert into PaseoEntity (id, capmax, ruta_id) values (5007, 8, 5009);
insert into PaseoEntity (id, capmax, ruta_id) values (5008, 10, 5024);
insert into PaseoEntity (id, capmax, ruta_id) values (5009, 8, 5014);
insert into PaseoEntity (id, capmax, ruta_id) values (5010, 9, 5002);

insert into FacturaEntity (id, name, pagado, valor, cliente_id, servicio_id, paypal_id) values (5301, 'FacturaPaseo', 0, 968841.01, 5017, 5301, 5005);
insert into FacturaEntity (id, name, pagado, valor, cliente_id, servicio_id, pse_id) values (5302, 'FacturaPaseo', 1, 809814.16, 5016, 5302, 5004);
insert into FacturaEntity (id, name, pagado, valor, cliente_id, servicio_id, paypal_id) values (5303, 'FacturaPaseo', 0, 176519.19, 5022, 5303, 5006);
insert into FacturaEntity (id, name, pagado, valor, cliente_id, servicio_id, paypal_id) values (5304, 'FacturaPaseo', 1, 151371.55, 5001, 5304, 5001);
insert into FacturaEntity (id, name, pagado, valor, cliente_id, servicio_id, tarjeta_id) values (5305, 'FacturaPaseo', 1, 381432.03, 5004, 5305, 5002);
insert into FacturaEntity (id, name, pagado, valor, cliente_id, servicio_id, tarjeta_id) values (5306, 'FacturaPaseo', 0, 709412.23, 5019, 5306, 5006);
insert into FacturaEntity (id, name, pagado, valor, cliente_id, servicio_id, pse_id) values (5307, 'FacturaPaseo', 0, 868219.07, 5023, 5307, 5005);
insert into FacturaEntity (id, name, pagado, valor, cliente_id, servicio_id, paypal_id) values (5308, 'FacturaPaseo', 0, 176196.75, 5012, 5308, 5007);
insert into FacturaEntity (id, name, pagado, valor, cliente_id, servicio_id, tarjeta_id) values (5309, 'FacturaPaseo', 0, 110569.23, 5014, 5309, 5004);
insert into FacturaEntity (id, name, pagado, valor, cliente_id, servicio_id, paypal_id) values (5310, 'FacturaPaseo', 0, 909426.65, 5010, 5310, 5003);
insert into FacturaEntity (id, name, pagado, valor, cliente_id, servicio_id, tarjeta_id) values (5311, 'FacturaPaseo', 0, 52257.31, 5004, 5311, 5002);
insert into FacturaEntity (id, name, pagado, valor, cliente_id, servicio_id, pse_id) values (5312, 'FacturaPaseo', 1, 983855.14, 5025, 5312, 5001);
insert into FacturaEntity (id, name, pagado, valor, cliente_id, servicio_id, paypal_id) values (5313, 'FacturaPaseo', 0, 82414.58, 5001, 5313, 5001);
insert into FacturaEntity (id, name, pagado, valor, cliente_id, servicio_id, tarjeta_id) values (5314, 'FacturaPaseo', 1, 214407.69, 5015, 5314, 5005);
insert into FacturaEntity (id, name, pagado, valor, cliente_id, servicio_id, tarjeta_id) values (5315, 'FacturaPaseo', 0, 48797.50, 5009, 5315, 5010);