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

delete from PseEntity;
delete from PayPalEntity;
delete from TarjetaCreditoEntity;
delete from FacturaEntity;
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

insert into ClienteEntity (id, cedula, correo, imagen, name, telefono) values (5001, '1580009000', 'rkroch0@t.co', 'http://dummyimage.com/242x212.bmp/ff4444/ffffff', 'Rana Kroch', '199-912-0740');
insert into ClienteEntity (id, cedula, correo, imagen, name, telefono) values (5002, '1090009009', 'jglyn1@php.net', 'http://dummyimage.com/112x242.png/cc0000/ffffff', 'Jerome Glyn', '884-452-6796');
insert into ClienteEntity (id, cedula, correo, imagen, name, telefono) values (5003, '1080060778', 'cimms2@aboutads.info', 'http://dummyimage.com/164x168.png/ff4444/ffffff', 'Cam Imms', '595-863-0572');
insert into ClienteEntity (id, cedula, correo, imagen, name, telefono) values (5004, '1000800990', 'wpolle3@pcworld.com', 'http://dummyimage.com/198x120.jpg/5fa2dd/ffffff', 'Worthington Polle', '398-675-3333');
insert into ClienteEntity (id, cedula, correo, imagen, name, telefono) values (5005, '1000008890', 'cquest4@fotki.com', 'http://dummyimage.com/207x125.png/5fa2dd/ffffff', 'Chantal Quest', '701-716-4912');
insert into ClienteEntity (id, cedula, correo, imagen, name, telefono) values (5006, '1009970098', 'swapple5@ihg.com', 'http://dummyimage.com/249x217.jpg/5fa2dd/ffffff', 'Sissy Wapple', '203-928-1306');
insert into ClienteEntity (id, cedula, correo, imagen, name, telefono) values (5007, '1005007080', 'cgreathead6@japanpost.jp', 'http://dummyimage.com/147x176.jpg/ff4444/ffffff', 'Cybil Greathead', '349-576-4537');
insert into ClienteEntity (id, cedula, correo, imagen, name, telefono) values (5008, '1800097096', 'ccastro7@illinois.edu', 'http://dummyimage.com/227x177.png/cc0000/ffffff', 'Claudetta Castro', '565-247-9949');
insert into ClienteEntity (id, cedula, correo, imagen, name, telefono) values (5009, '1090089009', 'afishbourn8@nyu.edu', 'http://dummyimage.com/223x130.bmp/cc0000/ffffff', 'Averil Fishbourn', '629-156-3792');
insert into ClienteEntity (id, cedula, correo, imagen, name, telefono) values (5010, '1978999080', 'hcordero9@ucla.edu', 'http://dummyimage.com/189x118.bmp/ff4444/ffffff', 'Hillie Cordero', '917-380-2711');
insert into ClienteEntity (id, cedula, correo, imagen, name, telefono) values (5011, '1000907900', 'gcantora@go.com', 'http://dummyimage.com/153x154.jpg/5fa2dd/ffffff', 'Giuditta Cantor', '964-376-7946');
insert into ClienteEntity (id, cedula, correo, imagen, name, telefono) values (5012, '1098909000', 'emichelb@opensource.org', 'http://dummyimage.com/137x182.png/cc0000/ffffff', 'Ewart Michel', '450-307-9552');
insert into ClienteEntity (id, cedula, correo, imagen, name, telefono) values (5013, '1906790896', 'zdannielc@latimes.com', 'http://dummyimage.com/219x239.jpg/dddddd/000000', 'Zola Danniel', '657-717-8303');
insert into ClienteEntity (id, cedula, correo, imagen, name, telefono) values (5014, '1990090008', 'prowlerd@sakura.ne.jp', 'http://dummyimage.com/101x168.jpg/ff4444/ffffff', 'Phil Rowler', '251-194-0110');
insert into ClienteEntity (id, cedula, correo, imagen, name, telefono) values (5015, '1990800900', 'vbeausange@mysql.com', 'http://dummyimage.com/238x236.png/ff4444/ffffff', 'Viole Beausang', '456-524-4936');
insert into ClienteEntity (id, cedula, correo, imagen, name, telefono) values (5016, '1080000099', 'dcaddickf@archive.org', 'http://dummyimage.com/222x248.bmp/5fa2dd/ffffff', 'Dorita Caddick', '614-392-2963');
insert into ClienteEntity (id, cedula, correo, imagen, name, telefono) values (5017, '1990000090', 'ndiackg@nsw.gov.au', 'http://dummyimage.com/106x205.png/dddddd/000000', 'Neilla Diack', '948-193-9091');
insert into ClienteEntity (id, cedula, correo, imagen, name, telefono) values (5018, '1760080900', 'vguisoth@cyberchimps.com', 'http://dummyimage.com/148x133.jpg/dddddd/000000', 'Vachel Guisot', '947-368-3354');
insert into ClienteEntity (id, cedula, correo, imagen, name, telefono) values (5019, '1990000809', 'lrosenstocki@opera.com', 'http://dummyimage.com/150x231.jpg/cc0000/ffffff', 'Lanna Rosenstock', '785-148-9501');
insert into ClienteEntity (id, cedula, correo, imagen, name, telefono) values (5020, '1070008099', 'rmercerj@constantcontact.com', 'http://dummyimage.com/140x189.bmp/ff4444/ffffff', 'Rahal Mercer', '954-720-1751');
insert into ClienteEntity (id, cedula, correo, imagen, name, telefono) values (5021, '1190998987', 'ojakemank@gmpg.org', 'http://dummyimage.com/222x112.jpg/dddddd/000000', 'Oswald Jakeman', '415-437-2855');
insert into ClienteEntity (id, cedula, correo, imagen, name, telefono) values (5022, '1800800900', 'nhannabyl@wikia.com', 'http://dummyimage.com/142x104.bmp/5fa2dd/ffffff', 'Nicol Hannaby', '749-759-5485');
insert into ClienteEntity (id, cedula, correo, imagen, name, telefono) values (5023, '1950080400', 'fchilversm@creativecommons.org', 'http://dummyimage.com/168x170.png/5fa2dd/ffffff', 'Francklin Chilvers', '807-937-9606');
insert into ClienteEntity (id, cedula, correo, imagen, name, telefono) values (5024, '1999990900', 'nbellardn@yolasite.com', 'http://dummyimage.com/142x155.bmp/dddddd/000000', 'Nixie Bellard', '651-746-0678');
insert into ClienteEntity (id, cedula, correo, imagen, name, telefono) values (5025, '1900099680', 'ncurnuckeo@nationalgeographic.com', 'http://dummyimage.com/137x129.png/ff4444/ffffff', 'Nadeen Curnucke', '123-311-7862');

insert into DisponibilidadEntity (id, name) values (5001, 'Bytecard');
insert into DisponibilidadEntity (id, name) values (5002, 'Greenlam');
insert into DisponibilidadEntity (id, name) values (5003, 'Bytecard');
insert into DisponibilidadEntity (id, name) values (5004, 'Transcof');
insert into DisponibilidadEntity (id, name) values (5005, 'Y-Solowarm');
insert into DisponibilidadEntity (id, name) values (5006, 'Namfix');
insert into DisponibilidadEntity (id, name) values (5007, 'Vagram');
insert into DisponibilidadEntity (id, name) values (5008, 'Kanlam');
insert into DisponibilidadEntity (id, name) values (5009, 'Aerified');
insert into DisponibilidadEntity (id, name) values (5010, 'Aerified');
insert into DisponibilidadEntity (id, name) values (5011, 'Voyatouch');
insert into DisponibilidadEntity (id, name) values (5012, 'Home Ing');
insert into DisponibilidadEntity (id, name) values (5013, 'Wrapsafe');
insert into DisponibilidadEntity (id, name) values (5014, 'Tin');
insert into DisponibilidadEntity (id, name) values (5015, 'Quo Lux');
insert into DisponibilidadEntity (id, name) values (5016, 'Pannier');
insert into DisponibilidadEntity (id, name) values (5017, 'Konklux');
insert into DisponibilidadEntity (id, name) values (5018, 'Viva');
insert into DisponibilidadEntity (id, name) values (5019, 'Otcom');
insert into DisponibilidadEntity (id, name) values (5020, 'Tres-Zap');
insert into DisponibilidadEntity (id, name) values (5021, 'Alphazap');
insert into DisponibilidadEntity (id, name) values (5022, 'Home Ing');
insert into DisponibilidadEntity (id, name) values (5023, 'Stringtough');
insert into DisponibilidadEntity (id, name) values (5024, 'Namfix');
insert into DisponibilidadEntity (id, name) values (5025, 'Cardify');

insert into MascotaEntity (id, color, name, raza, sexo, cliente_id) values (5001, 'Pink', 'Zelig', 'Australian spiny anteater', 'Male', 5012);
insert into MascotaEntity (id, color, name, raza, sexo, cliente_id) values (5002, 'Teal', 'Franciska', 'Phalarope, northern', 'Female', 5001);
insert into MascotaEntity (id, color, name, raza, sexo, cliente_id) values (5003, 'Maroon', 'Aymer', 'Civet, small-toothed palm', 'Male', 5005);
insert into MascotaEntity (id, color, name, raza, sexo, cliente_id) values (5004, 'Aquamarine', 'Fulton', 'Coke''s hartebeest', 'Male', 5011);
insert into MascotaEntity (id, color, name, raza, sexo, cliente_id) values (5005, 'Goldenrod', 'Trista', 'Cougar', 'Female', 5001);
insert into MascotaEntity (id, color, name, raza, sexo, cliente_id) values (5006, 'Khaki', 'Earlie', 'Little brown dove', 'Male', 5012);
insert into MascotaEntity (id, color, name, raza, sexo, cliente_id) values (5007, 'Indigo', 'Christoper', 'Yak', 'Male', 5010);
insert into MascotaEntity (id, color, name, raza, sexo, cliente_id) values (5008, 'Teal', 'Ludvig', 'Neotropic cormorant', 'Male', 5016);
insert into MascotaEntity (id, color, name, raza, sexo, cliente_id) values (5009, 'Yellow', 'Rutledge', 'Southern hairy-nosed wombat', 'Male', 5025);
insert into MascotaEntity (id, color, name, raza, sexo, cliente_id) values (5010, 'Teal', 'Analiese', 'Ox, musk', 'Female', 5015);
insert into MascotaEntity (id, color, name, raza, sexo, cliente_id) values (5011, 'Mauv', 'Laurene', 'Black-crowned crane', 'Female', 5025);
insert into MascotaEntity (id, color, name, raza, sexo, cliente_id) values (5012, 'Purple', 'Dora', 'Rose-ringed parakeet', 'Female', 5007);
insert into MascotaEntity (id, color, name, raza, sexo, cliente_id) values (5013, 'Yellow', 'Derwin', 'Flamingo, chilean', 'Male', 5007);
insert into MascotaEntity (id, color, name, raza, sexo, cliente_id) values (5014, 'Indigo', 'Jessika', 'Coqui partridge', 'Female', 5002);
insert into MascotaEntity (id, color, name, raza, sexo, cliente_id) values (5015, 'Green', 'Filippo', 'Brazilian otter', 'Male', 5023);
insert into MascotaEntity (id, color, name, raza, sexo, cliente_id) values (5016, 'Crimson', 'Jessamine', 'Hanuman langur', 'Female', 5020);
insert into MascotaEntity (id, color, name, raza, sexo, cliente_id) values (5017, 'Green', 'Rollo', 'Godwit, hudsonian', 'Male', 5002);
insert into MascotaEntity (id, color, name, raza, sexo, cliente_id) values (5018, 'Goldenrod', 'Torry', 'Macaw, blue and yellow', 'Male', 5010);
insert into MascotaEntity (id, color, name, raza, sexo, cliente_id) values (5019, 'Orange', 'Toddy', 'Common zebra', 'Male', 5017);
insert into MascotaEntity (id, color, name, raza, sexo, cliente_id) values (5020, 'Teal', 'Demetre', 'Yellow baboon', 'Male', 5023);
insert into MascotaEntity (id, color, name, raza, sexo, cliente_id) values (5021, 'Indigo', 'Bibbye', 'Greylag goose', 'Female', 5023);
insert into MascotaEntity (id, color, name, raza, sexo, cliente_id) values (5022, 'Violet', 'Ario', 'Egyptian vulture', 'Male', 5008);
insert into MascotaEntity (id, color, name, raza, sexo, cliente_id) values (5023, 'Red', 'Angelo', 'Dabchick', 'Male', 5013);
insert into MascotaEntity (id, color, name, raza, sexo, cliente_id) values (5024, 'Puce', 'Rolf', 'Indian star tortoise', 'Male', 5012);
insert into MascotaEntity (id, color, name, raza, sexo, cliente_id) values (5025, 'Khaki', 'Broddie', 'Nuthatch, red-breasted', 'Male', 5023);

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
insert into CalificacionEntity (id, name, puntaje, cliente_id) values (5001, 'Zamit', 2, 5001);
insert into CalificacionEntity (id, name, puntaje, cliente_id) values (5002, 'Zamit', 5, 5002);
insert into CalificacionEntity (id, name, puntaje, cliente_id) values (5003, 'Trippledex', 1, 5003);
insert into CalificacionEntity (id, name, puntaje, cliente_id) values (5004, 'Subin', 5, 5004);
insert into CalificacionEntity (id, name, puntaje, cliente_id) values (5005, 'Zontrax', 1, 5005);
insert into CalificacionEntity (id, name, puntaje, cliente_id) values (5006, 'Redhold', 3, 5006);
insert into CalificacionEntity (id, name, puntaje, cliente_id) values (5007, 'Zaam-Dox', 5, 5007);
insert into CalificacionEntity (id, name, puntaje, cliente_id) values (5008, 'Stim', 3, 5008);
insert into CalificacionEntity (id, name, puntaje, cliente_id) values (5009, 'Alphazap', 5, 5009);
insert into CalificacionEntity (id, name, puntaje, cliente_id) values (5010, 'Tres-Zap', 1, 5010);
insert into CalificacionEntity (id, name, puntaje, cliente_id) values (5011, 'Trippledex', 3, 5011);
insert into CalificacionEntity (id, name, puntaje, cliente_id) values (5012, 'Regrant', 5, 5012);
insert into CalificacionEntity (id, name, puntaje, cliente_id) values (5013, 'Aerified', 4, 5013);
insert into CalificacionEntity (id, name, puntaje, cliente_id) values (5014, 'Otcom', 3, 5014);
insert into CalificacionEntity (id, name, puntaje, cliente_id) values (5015, 'Stim', 4, 5015);
insert into CalificacionEntity (id, name, puntaje, cliente_id) values (5016, 'Trippledex', 1, 5016);
insert into CalificacionEntity (id, name, puntaje, cliente_id) values (5017, 'Voltsillam', 5, 5017);
insert into CalificacionEntity (id, name, puntaje, cliente_id) values (5018, 'Lotlux', 2, 5018);
insert into CalificacionEntity (id, name, puntaje, cliente_id) values (5019, 'Fintone', 4, 5019);
insert into CalificacionEntity (id, name, puntaje, cliente_id) values (5020, 'Namfix', 4, 5020);
insert into CalificacionEntity (id, name, puntaje, cliente_id) values (5021, 'Domainer', 1, 5021);
insert into CalificacionEntity (id, name, puntaje, cliente_id) values (5022, 'Zaam-Dox', 4, 5022);
insert into CalificacionEntity (id, name, puntaje, cliente_id) values (5023, 'Tresom', 2, 5023);
insert into CalificacionEntity (id, name, puntaje, cliente_id) values (5024, 'Voyatouch', 4, 5024);
insert into CalificacionEntity (id, name, puntaje, cliente_id) values (5025, 'Temp', 1, 5025);

insert into EmpleadoEntity (id, cargo, cedula, correo, edad, imagen, name, disponibilidad_id) values (5001, 'Aseador', '1090009879', 'hperfect0@wp.com', 29, 'http://dummyimage.com/119x131.jpg/5fa2dd/ffffff', 'Hadley Perfect', 5001);
insert into EmpleadoEntity (id, cargo, cedula, correo, edad, imagen, name, disponibilidad_id) values (5002, 'Cuidador', '1909909609', 'cedney1@nydailynews.com', 57, 'http://dummyimage.com/238x140.jpg/dddddd/000000', 'Casi Edney', 5002);
insert into EmpleadoEntity (id, cargo, cedula, correo, edad, imagen, name, disponibilidad_id) values (5003, 'Entrenador', '1000999000', 'lwillimott2@paypal.com', 46, 'http://dummyimage.com/121x107.jpg/cc0000/ffffff', 'Laney Willimott', 5003);
insert into EmpleadoEntity (id, cargo, cedula, correo, edad, imagen, name, disponibilidad_id) values (5004, 'Paseador', '1900800879', 'vhallex3@tinypic.com', 28, 'http://dummyimage.com/159x249.bmp/cc0000/ffffff', 'Vin Hallex', 5004);
insert into EmpleadoEntity (id, cargo, cedula, correo, edad, imagen, name, disponibilidad_id) values (5005, 'Paseador', '1906060000', 'happleford4@columbia.edu', 24, 'http://dummyimage.com/229x198.png/5fa2dd/ffffff', 'Hasty Appleford', 5005);
insert into EmpleadoEntity (id, cargo, cedula, correo, edad, imagen, name, disponibilidad_id) values (5006, 'Entrenador', '1009097589', 'cfagence5@psu.edu', 21, 'http://dummyimage.com/224x187.png/ff4444/ffffff', 'Courtney Fagence', 5006);
insert into EmpleadoEntity (id, cargo, cedula, correo, edad, imagen, name, disponibilidad_id) values (5007, 'Cuidador', '1009908090', 'lroma6@amazon.co.uk', 31, 'http://dummyimage.com/195x160.png/5fa2dd/ffffff', 'Lenore Roma', 5007);
insert into EmpleadoEntity (id, cargo, cedula, correo, edad, imagen, name, disponibilidad_id) values (5008, 'Aseador', '1900090906', 'kwillment7@salon.com', 56, 'http://dummyimage.com/146x156.png/ff4444/ffffff', 'Kelvin Willment', 5008);
insert into EmpleadoEntity (id, cargo, cedula, correo, edad, imagen, name, disponibilidad_id) values (5009, 'Aseador', '1000980000', 'jwakeham8@eepurl.com', 37, 'http://dummyimage.com/113x126.jpg/dddddd/000000', 'Juana Wakeham', 5009);
insert into EmpleadoEntity (id, cargo, cedula, correo, edad, imagen, name, disponibilidad_id) values (5010, 'Cuidador', '1989989000', 'fneame9@twitpic.com', 26, 'http://dummyimage.com/181x191.jpg/5fa2dd/ffffff', 'Fredericka Neame', 5010);
insert into EmpleadoEntity (id, cargo, cedula, correo, edad, imagen, name, disponibilidad_id) values (5011, 'Entrenador', '1800900900', 'cbarabischa@gizmodo.com', 21, 'http://dummyimage.com/171x190.jpg/dddddd/000000', 'Caroljean Barabisch', 5011);
insert into EmpleadoEntity (id, cargo, cedula, correo, edad, imagen, name, disponibilidad_id) values (5012, 'Paseador', '1000007000', 'hgwinnellb@rambler.ru', 26, 'http://dummyimage.com/193x130.bmp/cc0000/ffffff', 'Heidi Gwinnell', 5012);
insert into EmpleadoEntity (id, cargo, cedula, correo, edad, imagen, name, disponibilidad_id) values (5013, 'Cuidador', '1809999009', 'wcursonsc@google.fr', 33, 'http://dummyimage.com/205x157.png/5fa2dd/ffffff', 'Welch Cursons', 5013);
insert into EmpleadoEntity (id, cargo, cedula, correo, edad, imagen, name, disponibilidad_id) values (5014, 'Cuidador', '1890068087', 'sbollandsd@latimes.com', 21, 'http://dummyimage.com/158x136.bmp/ff4444/ffffff', 'Stillmann Bollands', 5014);
insert into EmpleadoEntity (id, cargo, cedula, correo, edad, imagen, name, disponibilidad_id) values (5015, 'Cuidador', '1870979090', 'cmaine@buzzfeed.com', 60, 'http://dummyimage.com/167x226.bmp/ff4444/ffffff', 'Candice Main', 5015);
insert into EmpleadoEntity (id, cargo, cedula, correo, edad, imagen, name, disponibilidad_id) values (5016, 'Aseador', '1998906409', 'bpilsworthf@sogou.com', 60, 'http://dummyimage.com/201x217.jpg/ff4444/ffffff', 'Beryle Pilsworth', 5016);
insert into EmpleadoEntity (id, cargo, cedula, correo, edad, imagen, name, disponibilidad_id) values (5017, 'Cuidador', '1906900069', 'jsouterg@theguardian.com', 19, 'http://dummyimage.com/147x161.bmp/cc0000/ffffff', 'Janice Souter', 5017);
insert into EmpleadoEntity (id, cargo, cedula, correo, edad, imagen, name, disponibilidad_id) values (5018, 'Entrenador', '1906098804', 'rwhittonh@youtu.be', 33, 'http://dummyimage.com/151x117.bmp/cc0000/ffffff', 'Rosy Whitton', 5018);
insert into EmpleadoEntity (id, cargo, cedula, correo, edad, imagen, name, disponibilidad_id) values (5019, 'Cuidador', '1600900990', 'abitchenoi@cisco.com', 47, 'http://dummyimage.com/169x180.jpg/ff4444/ffffff', 'Avrom Bitcheno', 5019);
insert into EmpleadoEntity (id, cargo, cedula, correo, edad, imagen, name, disponibilidad_id) values (5020, 'Cuidador', '1000099060', 'khogginsj@ted.com', 35, 'http://dummyimage.com/244x127.jpg/ff4444/ffffff', 'Klara Hoggins', 5020);
insert into EmpleadoEntity (id, cargo, cedula, correo, edad, imagen, name, disponibilidad_id) values (5021, 'Cuidador', '1890089088', 'wnovisk@hibu.com', 38, 'http://dummyimage.com/136x188.png/ff4444/ffffff', 'Willie Novis', 5021);
insert into EmpleadoEntity (id, cargo, cedula, correo, edad, imagen, name, disponibilidad_id) values (5022, 'Entrenador', '1099798809', 'mristel@privacy.gov.au', 33, 'http://dummyimage.com/155x111.jpg/cc0000/ffffff', 'Misha Riste', 5022);
insert into EmpleadoEntity (id, cargo, cedula, correo, edad, imagen, name, disponibilidad_id) values (5023, 'Cuidador', '1800000680', 'tclemensm@nytimes.com', 33, 'http://dummyimage.com/123x182.png/dddddd/000000', 'Terence Clemens', 5023);
insert into EmpleadoEntity (id, cargo, cedula, correo, edad, imagen, name, disponibilidad_id) values (5024, 'Entrenador', '1769897998', 'cbrennonn@360.cn', 26, 'http://dummyimage.com/231x151.png/5fa2dd/ffffff', 'Ches Brennon', 5024);
insert into EmpleadoEntity (id, cargo, cedula, correo, edad, imagen, name, disponibilidad_id) values (5025, 'Cuidador', '1709090099', 'dgrobo@sourceforge.net', 30, 'http://dummyimage.com/216x121.bmp/cc0000/ffffff', 'Daryl Grob', 5025);

--Calificacion Empleado
insert into CalificacionEntity (id, name, puntaje, empleado_id) values (6001, 'Subin', 2, 5001);
insert into CalificacionEntity (id, name, puntaje, empleado_id) values (6002, 'Lotstring', 2, 5002);
insert into CalificacionEntity (id, name, puntaje, empleado_id) values (6003, 'Opela', 4, 5003);
insert into CalificacionEntity (id, name, puntaje, empleado_id) values (6004, 'Quo Lux', 5, 5004);
insert into CalificacionEntity (id, name, puntaje, empleado_id) values (6005, 'Bamity', 5, 5005);
insert into CalificacionEntity (id, name, puntaje, empleado_id) values (6006, 'Cardify', 1, 5006);
insert into CalificacionEntity (id, name, puntaje, empleado_id) values (6007, 'Transcof', 1, 5007);
insert into CalificacionEntity (id, name, puntaje, empleado_id) values (6008, 'Duobam', 1, 5008);
insert into CalificacionEntity (id, name, puntaje, empleado_id) values (6009, 'Zoolab', 3, 5009);
insert into CalificacionEntity (id, name, puntaje, empleado_id) values (6010, 'Hatity', 2, 5010);
insert into CalificacionEntity (id, name, puntaje, empleado_id) values (6011, 'Lotstring', 1, 5011);
insert into CalificacionEntity (id, name, puntaje, empleado_id) values (6012, 'Bitchip', 5, 5012);
insert into CalificacionEntity (id, name, puntaje, empleado_id) values (6013, 'Y-find', 4, 5013);
insert into CalificacionEntity (id, name, puntaje, empleado_id) values (6014, 'Mat Lam Tam', 1, 5014);
insert into CalificacionEntity (id, name, puntaje, empleado_id) values (6015, 'Domainer', 1, 5015);
insert into CalificacionEntity (id, name, puntaje, empleado_id) values (6016, 'Cookley', 1, 5016);
insert into CalificacionEntity (id, name, puntaje, empleado_id) values (6017, 'Ronstring', 5, 5017);
insert into CalificacionEntity (id, name, puntaje, empleado_id) values (6018, 'Greenlam', 4, 5018);
insert into CalificacionEntity (id, name, puntaje, empleado_id) values (6019, 'Greenlam', 3, 5019);
insert into CalificacionEntity (id, name, puntaje, empleado_id) values (6020, 'Toughjoyfax', 2, 5020);
insert into CalificacionEntity (id, name, puntaje, empleado_id) values (6021, 'Cookley', 5, 5021);
insert into CalificacionEntity (id, name, puntaje, empleado_id) values (6022, 'Andalax', 4, 5022);
insert into CalificacionEntity (id, name, puntaje, empleado_id) values (6023, 'Kanlam', 3, 5023);
insert into CalificacionEntity (id, name, puntaje, empleado_id) values (6024, 'Sub-Ex', 3, 5024);
insert into CalificacionEntity (id, name, puntaje, empleado_id) values (6025, 'Stim', 2, 5025);

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

insert into TarjetaCreditoEntity (id, codigoseguridad, fechavencimiento, name, numerotarjeta, cliente_id) values (5001, '097', '10/1/2020', 'diners-club-enroute', '201791214728140', 5003);
insert into TarjetaCreditoEntity (id, codigoseguridad, fechavencimiento, name, numerotarjeta, cliente_id) values (5002, '900', '8/3/2023', 'switch', '6331106903655199769', 5004);
insert into TarjetaCreditoEntity (id, codigoseguridad, fechavencimiento, name, numerotarjeta, cliente_id) values (5003, '009', '1/14/2021', 'jcb', '3538746604854383', 5006);
insert into TarjetaCreditoEntity (id, codigoseguridad, fechavencimiento, name, numerotarjeta, cliente_id) values (5004, '089', '9/9/2023', 'jcb', '3560447965763161', 5014);
insert into TarjetaCreditoEntity (id, codigoseguridad, fechavencimiento, name, numerotarjeta, cliente_id) values (5005, '960', '3/22/2022', 'visa-electron', '4917715043129086', 5015);
insert into TarjetaCreditoEntity (id, codigoseguridad, fechavencimiento, name, numerotarjeta, cliente_id) values (5006, '308', '10/17/2021', 'jcb', '3536620945654681', 5019);
insert into TarjetaCreditoEntity (id, codigoseguridad, fechavencimiento, name, numerotarjeta, cliente_id) values (5007, '999', '11/5/2020', 'jcb', '3589829825005411', 5020);
insert into TarjetaCreditoEntity (id, codigoseguridad, fechavencimiento, name, numerotarjeta, cliente_id) values (5008, '985', '11/11/2023', 'jcb', '3559444423075158', 5008);
insert into TarjetaCreditoEntity (id, codigoseguridad, fechavencimiento, name, numerotarjeta, cliente_id) values (5009, '990', '6/16/2019', 'laser', '67092136493429047', 5024);
insert into TarjetaCreditoEntity (id, codigoseguridad, fechavencimiento, name, numerotarjeta, cliente_id) values (5010, '000', '8/1/2021', 'mastercard', '5181041262504842', 5009);




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

insert into RutaEntity (id,duracion, name) values (100,39,'Calle 116');
insert into RutaEntity (id,duracion, name) values (200,36,'Usaquen');
insert into RutaEntity (id,duracion, name) values (300,23,'Retiro');
insert into RutaEntity (id,duracion, name) values (400,43,'Calle 127');
insert into RutaEntity (id,duracion, name) values (500,28,'Chapinero');
insert into RutaEntity (id,duracion, name) values (600,44,'Candelaria');
insert into RutaEntity (id,duracion, name) values (700,50,'Monserrate');
insert into RutaEntity (id,duracion, name) values (800,37,'Rosales');
insert into RutaEntity (id,duracion, name) values (900,39,'Calle 200');
insert into RutaEntity (id,duracion, name) values (1000,58,'Bosque Medina');

--aseo
insert into ServicioEntity (id,DTYPE,costo, duracion, estado, fecha, hora, cliente_id, mascota_id, empleado_id, calificacion_id) values (100,'AseoEntity',78, 58.9, 1, '12/17/2017', 6, 100, 100, 100, 100);
insert into AseoEntity (id, banho, dientes, peluqueria) values (100,0, 0, 0);
insert into ServicioEntity (id,DTYPE,costo, duracion, estado, fecha, hora, cliente_id, mascota_id, empleado_id, calificacion_id) values (200,'AseoEntity',81, 19.5, 1, '9/14/2017', 11, 200, 200, 200, 200);
insert into AseoEntity (id, banho, dientes, peluqueria) values (200, 0, 0, 0);
insert into ServicioEntity (id,DTYPE,costo, duracion, estado, fecha, hora, cliente_id, mascota_id, empleado_id, calificacion_id) values (300,'AseoEntity',11, 19.9, 1, '6/2/2017', 10, 300, 300, 300, 300);
insert into AseoEntity (id, banho, dientes, peluqueria) values (300, 1, 1, 1);
insert into ServicioEntity (id,DTYPE,costo, duracion, estado, fecha, hora, cliente_id, mascota_id, empleado_id, calificacion_id) values (400,'AseoEntity',19, 58.1, 1, '12/16/2017', 6, 400, 400, 400, 400);
insert into AseoEntity (id, banho, dientes, peluqueria) values (400, 0, 1, 0);
insert into ServicioEntity (id,DTYPE,costo, duracion, estado, fecha, hora, cliente_id, mascota_id, empleado_id, calificacion_id) values (500,'AseoEntity',86, 50.0, 0, '7/14/2017', 1, 500, 500, 500, 500);
insert into AseoEntity (id, banho, dientes, peluqueria) values (500, 1, 1, 0);
insert into ServicioEntity (id,DTYPE,costo, duracion, estado, fecha, hora, cliente_id, mascota_id, empleado_id, calificacion_id) values (600,'AseoEntity',25, 23.5, 1, '4/21/2017', 12, 600, 600, 600, 600);
insert into AseoEntity (id, banho, dientes, peluqueria) values (600, 1, 1, 0);
insert into ServicioEntity (id,DTYPE,costo, duracion, estado, fecha, hora, cliente_id, mascota_id, empleado_id, calificacion_id) values (700,'AseoEntity',23, 34.2, 0, '12/14/2017', 5, 700, 700, 700, 700);
insert into AseoEntity (id, banho, dientes, peluqueria) values (700,0, 0, 0);
insert into ServicioEntity (id,DTYPE,costo, duracion, estado, fecha, hora, cliente_id, mascota_id, empleado_id, calificacion_id) values (800,'AseoEntity',37, 16.9, 0, '7/28/2017', 8, 800, 800, 800, 800);
insert into AseoEntity (id, banho, dientes, peluqueria) values (800, 1, 1, 1);
insert into ServicioEntity (id,DTYPE,costo, duracion, estado, fecha, hora, cliente_id, mascota_id, empleado_id, calificacion_id) values (900,'AseoEntity',73, 31.1, 0, '4/27/2017', 2, 900, 900, 900, 900);
insert into AseoEntity (id, banho, dientes, peluqueria) values (900, 1, 0, 0);
insert into ServicioEntity (id,DTYPE,costo, duracion, estado, fecha, hora, cliente_id, mascota_id, empleado_id, calificacion_id) values (1000,'AseoEntity',61, 7.6, 1, '4/29/2017', 2, 1000, 1000, 1000, 1000);
insert into AseoEntity (id, banho, dientes, peluqueria) values (1000, 0, 0, 1);

--entrenamiento
insert into ServicioEntity (id,DTYPE,costo, duracion, estado, fecha, hora, cliente_id, mascota_id, empleado_id, calificacion_id) values (101,'EntrenamientoEntity',78, 58.9, 1, '12/17/2017', 6, 100, 100, 100, 100);
insert into EntrenamientoEntity (id, tipo, Transporte_id, CentrodeEntrenamiento_id) values (101, 'Often', 100, 100);
insert into ServicioEntity (id,DTYPE,costo, duracion, estado, fecha, hora, cliente_id, mascota_id, empleado_id, calificacion_id) values (201,'EntrenamientoEntity',81, 19.5, 1, '9/14/2017', 11, 200, 200, 200, 200);
insert into EntrenamientoEntity (id, tipo, Transporte_id, CentrodeEntrenamiento_id) values (201, 'Never', 200, 200);
insert into ServicioEntity (id,DTYPE,costo, duracion, estado, fecha, hora, cliente_id, mascota_id, empleado_id, calificacion_id) values (301,'EntrenamientoEntity',11, 19.9, 1, '6/2/2017', 10, 300, 300, 300, 300);
insert into EntrenamientoEntity (id, tipo, Transporte_id, CentrodeEntrenamiento_id) values (301, 'Never', 300, 300);
insert into ServicioEntity (id,DTYPE,costo, duracion, estado, fecha, hora, cliente_id, mascota_id, empleado_id, calificacion_id) values (401,'EntrenamientoEntity',19, 58.1, 1, '12/16/2017', 6, 400, 400, 400, 400);
insert into EntrenamientoEntity (id, tipo, Transporte_id, CentrodeEntrenamiento_id) values (401, 'Yearly', 400, 400);
insert into ServicioEntity (id,DTYPE,costo, duracion, estado, fecha, hora, cliente_id, mascota_id, empleado_id, calificacion_id) values (501,'EntrenamientoEntity',86, 50.0, 0, '7/14/2017', 1, 500, 500, 500, 500);
insert into EntrenamientoEntity (id, tipo, Transporte_id, CentrodeEntrenamiento_id) values (501, 'Often', 500, 500);
insert into ServicioEntity (id,DTYPE,costo, duracion, estado, fecha, hora, cliente_id, mascota_id, empleado_id, calificacion_id) values (601,'EntrenamientoEntity',25, 23.5, 1, '4/21/2017', 12, 600, 600, 600, 600);
insert into EntrenamientoEntity (id, tipo, Transporte_id, CentrodeEntrenamiento_id) values (601,'Weekly', 600, 600);
insert into ServicioEntity (id,DTYPE,costo, duracion, estado, fecha, hora, cliente_id, mascota_id, empleado_id, calificacion_id) values (701,'EntrenamientoEntity',23, 34.2, 0, '12/14/2017', 5, 700, 700, 700, 700);
insert into EntrenamientoEntity (id, tipo, Transporte_id, CentrodeEntrenamiento_id) values (701, 'Daily', 700, 700);
insert into ServicioEntity (id,DTYPE,costo, duracion, estado, fecha, hora, cliente_id, mascota_id, empleado_id, calificacion_id) values (801,'EntrenamientoEntity',37, 16.9, 0, '7/28/2017', 8, 800, 800, 800, 800);
insert into EntrenamientoEntity (id, tipo, Transporte_id, CentrodeEntrenamiento_id) values (801, 'Often', 800, 800);
insert into ServicioEntity (id,DTYPE,costo, duracion, estado, fecha, hora, cliente_id, mascota_id, empleado_id, calificacion_id) values (901,'EntrenamientoEntity',73, 31.1, 0, '4/27/2017', 2, 900, 900, 900, 900);
insert into EntrenamientoEntity (id, tipo, Transporte_id, CentrodeEntrenamiento_id) values (901, 'Yearly', 900, 900);
insert into ServicioEntity (id,DTYPE,costo, duracion, estado, fecha, hora, cliente_id, mascota_id, empleado_id, calificacion_id) values (1001,'EntrenamientoEntity',61, 7.6, 1, '4/29/2017', 2, 1000, 1000, 1000, 1000);
insert into EntrenamientoEntity (id, tipo, Transporte_id, CentrodeEntrenamiento_id) values (1001, 'Seldom', 1000, 1000);

--hotel
insert into ServicioEntity (id, DTYPE,costo, duracion, estado, fecha, hora, cliente_id, mascota_id, empleado_id, calificacion_id) values (102,'HotelEntity',78, 58.9, 1, '12/17/2017', 6, 100, 100, 100, 100);
insert into HotelEntity (id, Transporte_id, tiempohospedaje, CentrodeEntrenamiento_id) values (102, 100, 58, 100);
insert into ServicioEntity (id, DTYPE,costo, duracion, estado, fecha, hora, cliente_id, mascota_id, empleado_id, calificacion_id) values (202,'HotelEntity',81, 19.5, 1, '9/14/2017', 11, 200, 200, 200, 200);
insert into HotelEntity (id, Transporte_id, tiempohospedaje, CentrodeEntrenamiento_id) values (202, 200, 25, 200);
insert into ServicioEntity (id, DTYPE,costo, duracion, estado, fecha, hora, cliente_id, mascota_id, empleado_id, calificacion_id) values (302,'HotelEntity',11, 19.9, 1, '6/2/2017', 10, 300, 300, 300, 300);
insert into HotelEntity (id, Transporte_id, tiempohospedaje, CentrodeEntrenamiento_id) values (302, 300, 46, 300);
insert into ServicioEntity (id, DTYPE,costo, duracion, estado, fecha, hora, cliente_id, mascota_id, empleado_id, calificacion_id) values (402,'HotelEntity',19, 58.1, 1, '12/16/2017', 6, 400, 400, 400, 400);
insert into HotelEntity (id, Transporte_id, tiempohospedaje, CentrodeEntrenamiento_id) values (402, 400, 28, 400);
insert into ServicioEntity (id, DTYPE,costo, duracion, estado, fecha, hora, cliente_id, mascota_id, empleado_id, calificacion_id) values (502,'HotelEntity',86, 50.0, 0, '7/14/2017', 1, 500, 500, 500, 500);
insert into HotelEntity (id, Transporte_id, tiempohospedaje, CentrodeEntrenamiento_id) values (502, 500, 43, 500);
insert into ServicioEntity (id, DTYPE,costo, duracion, estado, fecha, hora, cliente_id, mascota_id, empleado_id, calificacion_id) values (602,'HotelEntity',25, 23.5, 1, '4/21/2017', 12, 600, 600, 600, 600);
insert into HotelEntity (id, Transporte_id, tiempohospedaje, CentrodeEntrenamiento_id) values (602, 600, 58, 600);
insert into ServicioEntity (id,DTYPE,costo, duracion, estado, fecha, hora, cliente_id, mascota_id, empleado_id, calificacion_id) values (702,'HotelEntity',23, 34.2, 0, '12/14/2017', 5, 700, 700, 700, 700);
insert into HotelEntity (id, Transporte_id, tiempohospedaje, CentrodeEntrenamiento_id) values (702, 700, 55, 700);
insert into ServicioEntity (id,DTYPE,costo, duracion, estado, fecha, hora, cliente_id, mascota_id, empleado_id, calificacion_id) values (802,'HotelEntity',37, 16.9, 0, '7/28/2017', 8, 800, 800, 800, 800);
insert into HotelEntity (id, Transporte_id, tiempohospedaje, CentrodeEntrenamiento_id) values (802, 800, 56, 800);
insert into ServicioEntity (id,DTYPE,costo, duracion, estado, fecha, hora, cliente_id, mascota_id, empleado_id, calificacion_id) values (902,'HotelEntity',73, 31.1, 0, '4/27/2017', 2, 900, 900, 900, 900);
insert into HotelEntity (id, Transporte_id, tiempohospedaje, CentrodeEntrenamiento_id) values (902, 900, 36, 900);
insert into ServicioEntity (id,DTYPE,costo, duracion, estado, fecha, hora, cliente_id, mascota_id, empleado_id, calificacion_id) values (1002,'HotelEntity',61, 7.6, 1, '4/29/2017', 2, 1000, 1000, 1000, 1000);
insert into HotelEntity (id, Transporte_id, tiempohospedaje, CentrodeEntrenamiento_id) values (1002, 1000, 67, 1000);

--paseo
insert into ServicioEntity (id,DTYPE,costo, duracion, estado, fecha, hora, cliente_id, mascota_id, empleado_id, calificacion_id) values (103,'PaseoEntity',78, 58.9, 1, '12/17/2017', 6, 100, 100, 100, 100);
insert into PaseoEntity (id, capmax, Ruta_id) values (103,8, 100);
insert into ServicioEntity (id,DTYPE,costo, duracion, estado, fecha, hora, cliente_id, mascota_id, empleado_id, calificacion_id) values (203,'PaseoEntity',81, 19.5, 1, '9/14/2017', 11, 200, 200, 200, 200);
insert into PaseoEntity (id, capmax, Ruta_id) values (203, 4, 200);
insert into ServicioEntity (id,DTYPE,costo, duracion, estado, fecha, hora, cliente_id, mascota_id, empleado_id, calificacion_id) values (303,'PaseoEntity',11, 19.9, 1, '6/2/2017', 10, 300, 300, 300, 300);
insert into PaseoEntity (id, capmax, Ruta_id) values (303, 11, 300);
insert into ServicioEntity (id,DTYPE,costo, duracion, estado, fecha, hora, cliente_id, mascota_id, empleado_id, calificacion_id) values (403,'PaseoEntity',19, 58.1, 1, '12/16/2017', 6, 400, 400, 400, 400);
insert into PaseoEntity (id, capmax, Ruta_id) values (403, 19, 400);
insert into ServicioEntity (id,DTYPE,costo, duracion, estado, fecha, hora, cliente_id, mascota_id, empleado_id, calificacion_id) values (503,'PaseoEntity',86, 50.0, 0, '7/14/2017', 1, 500, 500, 500, 500);
insert into PaseoEntity (id, capmax, Ruta_id) values (503, 8, 500);
insert into ServicioEntity (id,DTYPE,costo, duracion, estado, fecha, hora, cliente_id, mascota_id, empleado_id, calificacion_id) values (603,'PaseoEntity',25, 23.5, 1, '4/21/2017', 12, 600, 600, 600, 600);
insert into PaseoEntity (id, capmax, Ruta_id) values (603, 20, 600);
insert into ServicioEntity (id,DTYPE,costo, duracion, estado, fecha, hora, cliente_id, mascota_id, empleado_id, calificacion_id) values (703,'PaseoEntity',23, 34.2, 0, '12/14/2017', 5, 700, 700, 700, 700);
insert into PaseoEntity (id, capmax, Ruta_id) values (703, 3, 700);
insert into ServicioEntity (id,DTYPE,costo, duracion, estado, fecha, hora, cliente_id, mascota_id, empleado_id, calificacion_id) values (803,'PaseoEntity',37, 16.9, 0, '7/28/2017', 8, 800, 800, 800, 800);
insert into PaseoEntity (id, capmax, Ruta_id) values (803, 11, 800);
insert into ServicioEntity (id,DTYPE,costo, duracion, estado, fecha, hora, cliente_id, mascota_id, empleado_id, calificacion_id) values (903,'PaseoEntity',73, 31.1, 0, '4/27/2017', 2, 900, 900, 900, 900);
insert into PaseoEntity (id, capmax, Ruta_id) values (903, 2, 900);
insert into ServicioEntity (id,DTYPE,costo, duracion, estado, fecha, hora, cliente_id, mascota_id, empleado_id, calificacion_id) values (1003,'PaseoEntity',61, 7.6, 1, '4/29/2017', 2, 1000, 1000, 1000, 1000);
insert into PaseoEntity (id, capmax, Ruta_id) values (1003, 10, 1000);

insert into FacturaEntity (id, pagado, valor, Cliente_id, Servicio_id) values (100, 1, 90.2, 100, 100);
insert into FacturaEntity (id, pagado, valor, Cliente_id, Servicio_id) values (200, 0, 28.4, 200, 200);
insert into FacturaEntity (id, pagado, valor, Cliente_id, Servicio_id) values (300, 0, 90.25, 300, 300);
insert into FacturaEntity (id, pagado, valor, Cliente_id, Servicio_id) values (400, 0, 91.55, 400, 400);
insert into FacturaEntity (id, pagado, valor, Cliente_id, Servicio_id) values (500, 1, 76.76, 500, 500);
insert into FacturaEntity (id, pagado, valor, Cliente_id, Servicio_id) values (600, 1, 91.14, 600, 600);
insert into FacturaEntity (id, pagado, valor, Cliente_id, Servicio_id) values (700, 1, 35.14, 700, 700);
insert into FacturaEntity (id, pagado, valor, Cliente_id, Servicio_id) values (800, 0, 20.05, 800, 800);
insert into FacturaEntity (id, pagado, valor, Cliente_id, Servicio_id) values (900, 0, 33.37, 900, 900);
insert into FacturaEntity (id, pagado, valor, Cliente_id, Servicio_id) values (1000, 1, 70.89, 1000, 1000);

--PSE
insert into PseEntity (id, name, cliente_id, correo) values (100, 'Peralta', 100, 'pbaxter0@buzzfeed.com');
insert into PseEntity (id, name, cliente_id, correo) values (200, 'Kim',200,'kchellingworth1@salon.com');
insert into PseEntity (id, name, cliente_id, correo) values (300, 'Frasquito',300, 'fchagg2@gnu.org');
insert into PseEntity (id, name, cliente_id, correo) values (400, 'Tammie',400, 'tarthur3@pen.io');
insert into PseEntity (id, name, cliente_id, correo) values (500, 'Ross',500, 'rplenderleith4@unicef.org');
insert into PseEntity (id, name, cliente_id, correo) values (600, 'Frazer',600,  'ffootitt5@virginia.edu');
insert into PseEntity (id, name, cliente_id, correo) values (700, 'Agneta',700, 'ashiril6@sogou.com');
insert into PseEntity (id, name, cliente_id, correo) values (800, 'Pennie',800, 'pporcher7@hexun.com');
insert into PseEntity (id, name, cliente_id, correo) values (900, 'Gaile',900, 'gspringett8@archive.org');
insert into PseEntity (id, name, cliente_id, correo) values (1000, 'Roshelle',1000, 'rshutte9@scientificamerican.com');

--PayPal
insert into PayPalEntity (id, name, cliente_id, correo) values (101, 'Cristian', 100, 'pbaxter0@buzzfeed.com');
insert into PayPalEntity (id, name, cliente_id, correo) values (201, 'Kym',200, 'kchellingworth1@salon.com');
insert into PayPalEntity (id, name, cliente_id, correo) values (301, 'Rockie',300, 'fchagg2@gnu.org');
insert into PayPalEntity (id, name, cliente_id, correo) values (401, 'Whitney', 400,'tarthur3@pen.io');
insert into PayPalEntity (id, name, cliente_id, correo) values (501, 'Damien', 500, 'rplenderleith4@unicef.org');
insert into PayPalEntity (id, name, cliente_id, correo) values (601, 'Katharyn', 600, 'ffootitt5@virginia.edu');
insert into PayPalEntity (id, name, cliente_id, correo) values (701, 'Clarette', 700, 'ashiril6@sogou.com');
insert into PayPalEntity (id, name, cliente_id, correo) values (801, 'Blondell', 800,'pporcher7@hexun.com');
insert into PayPalEntity (id, name, cliente_id, correo) values (901, 'Elbertina', 900, 'gspringett8@archive.org');
insert into PayPalEntity (id, name, cliente_id, correo) values (1001, 'Zebedee', 1000, 'rshutte9@scientificamerican.com');

--Tarjeta
insert into TarjetaCreditoEntity (id, name, cliente_id, codigoseguridad, fechavencimiento, numerotarjeta) values (102, 'Cristian', 100, '192', '07/23/2018', '5602217084788197557');
insert into TarjetaCreditoEntity (id, name, cliente_id, codigoseguridad, fechavencimiento, numerotarjeta) values (202, 'Kym',200, '854', '10/30/2018', '6391166470850846');
insert into TarjetaCreditoEntity (id, name, cliente_id, codigoseguridad, fechavencimiento, numerotarjeta) values (302, 'Rockie',300, '107', '08/08/2018', '3530875050292265');
insert into TarjetaCreditoEntity (id, name, cliente_id, codigoseguridad, fechavencimiento, numerotarjeta) values (402, 'Whitney',400, '239', '06/08/2018', '560221362124941527');
insert into TarjetaCreditoEntity (id, name, cliente_id, codigoseguridad, fechavencimiento, numerotarjeta) values (502, 'Damien',500, '467', '08/21/2018', '3584934520873983');
insert into TarjetaCreditoEntity (id, name, cliente_id, codigoseguridad, fechavencimiento, numerotarjeta) values (602, 'Katharyn',600, '399', '10/19/2018', '3576989041642820');
insert into TarjetaCreditoEntity (id, name, cliente_id, codigoseguridad, fechavencimiento, numerotarjeta) values (702, 'Clarette',700, '203', '08/08/2018', '5610812884638015');
insert into TarjetaCreditoEntity (id, name, cliente_id, codigoseguridad, fechavencimiento, numerotarjeta) values (802, 'Blondell',800, '369', '05/08/2018', '3583478174316064');
insert into TarjetaCreditoEntity (id, name, cliente_id, codigoseguridad, fechavencimiento, numerotarjeta) values (902, 'Elbertina',900, '164', '11/10/2018', '3529187202785532');
insert into TarjetaCreditoEntity (id, name, cliente_id, codigoseguridad, fechavencimiento, numerotarjeta) values (1002, 'Zebedee',1000, '688', '1/10/2018', '3549106064837799');