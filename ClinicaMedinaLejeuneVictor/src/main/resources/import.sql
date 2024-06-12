INSERT INTO departamento(ID_DEPARTAMENTO,ESPECIALIDAD) VALUES(1, 'Alergología');
INSERT INTO departamento(ID_DEPARTAMENTO,ESPECIALIDAD) VALUES(2, 'Dermatología');
INSERT INTO departamento(ID_DEPARTAMENTO,ESPECIALIDAD) VALUES(3, 'Neumología');
ALTER SEQUENCE departamento_seq RESTART WITH (53);


INSERT INTO seguro(ID_SEGURO, NOMBRE, PRECIO, DESCRIPCION) VALUES(1,'Sin seguro', 0, 'No tiene seguro'); 	  	  
INSERT INTO seguro(ID_SEGURO, NOMBRE, PRECIO, DESCRIPCION) VALUES(2,'Seguro plata', 25.99, 'Seguro que cubre las citas que no son especiales y hace descuento a las especiales');
INSERT INTO seguro(ID_SEGURO, NOMBRE, PRECIO, DESCRIPCION) VALUES(3, 'Seguro oro', 145.99, 'Seguro que cubre todos los servicios');
ALTER SEQUENCE seguro_seq RESTART WITH (53);


INSERT INTO usuario(ID, username, NOMBRE, APELLIDOS, GMAIL, password, DNI, ES_ADMIN, ES_DOCTOR) VALUES(1,'admin','Paco','Gomez','pacogomez@gmail.com','{bcrypt}$2y$10$HDQFRiVddHHu1SMEjIR9LuQigT/2lnz/3LKwCn1LmeElF/JN/SDMW','12345678A',true,false);
INSERT INTO usuario(ID, username, NOMBRE, APELLIDOS, GMAIL, password, DNI, ES_ADMIN, ES_DOCTOR) VALUES(2,'usuario','Victor','Medina','victormedina@gmail.com','{bcrypt}$2y$10$o.EOfX3DcTdr9ku1PpTmX.4pnJ/Tpgy.WHtB/Z00ElYaD1VfsnEJO','23456789B',false,true);
INSERT INTO usuario(ID, username, NOMBRE, APELLIDOS, GMAIL, password, DNI, ES_ADMIN, ES_DOCTOR) VALUES(3,'Doctor02','Manuel','Gomez','manuelgomez@gmail.com','{bcrypt}$2y$10$o.EOfX3DcTdr9ku1PpTmX.4pnJ/Tpgy.WHtB/Z00ElYaD1VfsnEJO','34567891C',false,true);
INSERT INTO usuario(ID, username, NOMBRE, APELLIDOS, GMAIL, password, DNI, ES_ADMIN, ES_DOCTOR) VALUES(4,'Doctor03','Moises','Dorado','moisesdorado@gmail.com','{bcrypt}$2y$10$o.EOfX3DcTdr9ku1PpTmX.4pnJ/Tpgy.WHtB/Z00ElYaD1VfsnEJO','45678912D',false,true);
INSERT INTO usuario(ID, username, NOMBRE, APELLIDOS, GMAIL, password, DNI, ES_ADMIN, ES_DOCTOR) VALUES(5, 'Doctor04', 'Bruno', 'Delgado', 'brunodelgado@gmail.com', '{bcrypt}$2y$10$o.EOfX3DcTdr9ku1PpTmX.4pnJ/Tpgy.WHtB/Z00ElYaD1VfsnEJO', '56789123E', false, true);
INSERT INTO usuario(ID, username, NOMBRE, APELLIDOS, GMAIL, password, DNI, ES_ADMIN, ES_DOCTOR) VALUES(6, 'Doctor05', 'Carlos', 'Roman', 'carlosroman@gmail.com', '{bcrypt}$2y$10$o.EOfX3DcTdr9ku1PpTmX.4pnJ/Tpgy.WHtB/Z00ElYaD1VfsnEJO', '67891234F', false, true);
INSERT INTO usuario(ID, username, NOMBRE, APELLIDOS, GMAIL, password, DNI, ES_ADMIN, ES_DOCTOR) VALUES(7, 'Doctor06', 'Joaquín', 'Carrascal', 'joaquincarrascal@gmail.com', '{bcrypt}$2y$10$o.EOfX3DcTdr9ku1PpTmX.4pnJ/Tpgy.WHtB/Z00ElYaD1VfsnEJO', '78912345G', false, true);
INSERT INTO usuario(ID, username, NOMBRE, APELLIDOS, GMAIL, password, DNI, ES_ADMIN, ES_DOCTOR) VALUES(8,'user','Pedro','Sanchez','pedrosanchez@gmail.com','{bcrypt}$2y$10$o.EOfX3DcTdr9ku1PpTmX.4pnJ/Tpgy.WHtB/Z00ElYaD1VfsnEJO','89123456H',false,false);
INSERT INTO usuario(ID, username, NOMBRE, APELLIDOS, GMAIL, password, DNI, ES_ADMIN, ES_DOCTOR) VALUES(9,'Cliente02','Pablo','Teyssere','pabloteyssere@gmail.com','{bcrypt}$2y$10$o.EOfX3DcTdr9ku1PpTmX.4pnJ/Tpgy.WHtB/Z00ElYaD1VfsnEJO','91234567I',false,false);
INSERT INTO usuario(ID, username, NOMBRE, APELLIDOS, GMAIL, password, DNI, ES_ADMIN, ES_DOCTOR) VALUES(10,'Cliente03','Pepe','Segura','pepe@gmail.com','{bcrypt}$2y$10$o.EOfX3DcTdr9ku1PpTmX.4pnJ/Tpgy.WHtB/Z00ElYaD1VfsnEJO','12345678J',false,false);
INSERT INTO usuario(ID, username, NOMBRE, APELLIDOS, GMAIL, password, DNI, ES_ADMIN, ES_DOCTOR) VALUES(11,'Cliente04','Pablo','Camara','pablocamara@gmail.com','{bcrypt}$2y$10$o.EOfX3DcTdr9ku1PpTmX.4pnJ/Tpgy.WHtB/Z00ElYaD1VfsnEJO','23456789K',false,false);
INSERT INTO usuario(ID, username, NOMBRE, APELLIDOS, GMAIL, password, DNI, ES_ADMIN, ES_DOCTOR) VALUES(12,'Cliente05','Homer','Simpson','homersimpson@gmail.com','{bcrypt}$2y$10$o.EOfX3DcTdr9ku1PpTmX.4pnJ/Tpgy.WHtB/Z00ElYaD1VfsnEJO','91234567L',false,false);
INSERT INTO usuario(ID, username, NOMBRE, APELLIDOS, GMAIL, password, DNI, ES_ADMIN, ES_DOCTOR) VALUES(13,'Cliente06','Forest','Gump','forestgump@gmail.com','{bcrypt}$2y$10$o.EOfX3DcTdr9ku1PpTmX.4pnJ/Tpgy.WHtB/Z00ElYaD1VfsnEJO','12345678M',false,false);
INSERT INTO usuario(ID, username, NOMBRE, APELLIDOS, GMAIL, password, DNI, ES_ADMIN, ES_DOCTOR) VALUES(14,'Cliente07','Obi-Wan','Kenobi','obiwankenobi@gmail.com','{bcrypt}$2y$10$o.EOfX3DcTdr9ku1PpTmX.4pnJ/Tpgy.WHtB/Z00ElYaD1VfsnEJO','23456789N',false,false);
INSERT INTO usuario(ID, username, NOMBRE, APELLIDOS, GMAIL, password, DNI, ES_ADMIN, ES_DOCTOR) VALUES(15,'Cliente08','Benjamín','Pescado','benjaminpescado@gmail.com','{bcrypt}$2y$10$o.EOfX3DcTdr9ku1PpTmX.4pnJ/Tpgy.WHtB/Z00ElYaD1VfsnEJO','34567891Ñ',false,false);
ALTER SEQUENCE usuario_seq RESTART WITH (65);


INSERT INTO doctor(ID,DEPARTAMENTO_ID_DEPARTAMENTO,SALARIO,IND_JEFE) VALUES(2,1,200,false);
INSERT INTO doctor(ID,DEPARTAMENTO_ID_DEPARTAMENTO,SALARIO,IND_JEFE) VALUES(3,2,250,true);
INSERT INTO doctor(ID,DEPARTAMENTO_ID_DEPARTAMENTO,SALARIO,IND_JEFE) VALUES(4,3,170,false);
INSERT INTO doctor(ID,DEPARTAMENTO_ID_DEPARTAMENTO,SALARIO,IND_JEFE) VALUES(5,1,170,true);
INSERT INTO doctor(ID,DEPARTAMENTO_ID_DEPARTAMENTO,SALARIO,IND_JEFE) VALUES(6,2,170,false);
INSERT INTO doctor(ID,DEPARTAMENTO_ID_DEPARTAMENTO,SALARIO,IND_JEFE) VALUES(7,3,170,true);


INSERT INTO cliente(ID,SEGURO_ID_SEGURO) VALUES(8,1);
INSERT INTO cliente(ID,SEGURO_ID_SEGURO) VALUES(9,3);
INSERT INTO cliente(ID,SEGURO_ID_SEGURO) VALUES(10,2);
INSERT INTO cliente(ID,SEGURO_ID_SEGURO) VALUES(11,3);  
INSERT INTO cliente(ID,SEGURO_ID_SEGURO) VALUES(12,1);
INSERT INTO cliente(ID,SEGURO_ID_SEGURO) VALUES(13,3);
INSERT INTO cliente(ID,SEGURO_ID_SEGURO) VALUES(14,1);
INSERT INTO cliente(ID,SEGURO_ID_SEGURO) VALUES(15,2);


                                                                                               

INSERT INTO cita(ESPECIAL, DURACION, FECHA_INICIO, ID_CLIENTE, ID_DOCTOR, PRECIO_CITA) VALUES(false, 60, '2024-06-05T09:00:00', 8, 2, 20);
INSERT INTO cita(ESPECIAL, DURACION, FECHA_INICIO, ID_CLIENTE, ID_DOCTOR, PRECIO_CITA) VALUES(false, 60, '2024-06-05T10:00:00', 9, 2, 20);
INSERT INTO cita(ESPECIAL, DURACION, FECHA_INICIO, ID_CLIENTE, ID_DOCTOR, PRECIO_CITA) VALUES(true, 60, '2024-06-05T11:00:00', 10, 2, 40);
INSERT INTO cita(ESPECIAL, DURACION, FECHA_INICIO, ID_CLIENTE, ID_DOCTOR, PRECIO_CITA) VALUES(false, 60, '2024-06-05T12:00:00', 11, 2, 20);
INSERT INTO cita(ESPECIAL, DURACION, FECHA_INICIO, ID_CLIENTE, ID_DOCTOR, PRECIO_CITA) VALUES(false, 60, '2024-06-05T09:00:00', 9, 5, 20);
INSERT INTO cita(ESPECIAL, DURACION, FECHA_INICIO, ID_CLIENTE, ID_DOCTOR, PRECIO_CITA) VALUES(false, 60, '2024-06-05T10:00:00', 10, 5, 20);
INSERT INTO cita(ESPECIAL, DURACION, FECHA_INICIO, ID_CLIENTE, ID_DOCTOR, PRECIO_CITA) VALUES(true, 60, '2024-06-05T11:00:00', 11, 5, 40);
INSERT INTO cita(ESPECIAL, DURACION, FECHA_INICIO, ID_CLIENTE, ID_DOCTOR, PRECIO_CITA) VALUES(false, 60, '2024-06-05T12:00:00', 8, 5, 20);