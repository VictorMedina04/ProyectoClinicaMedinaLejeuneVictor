INSERT INTO departamento(ID_DEPARTAMENTO,ESPECIALIDAD) VALUES(1, 'Alergologia');

INSERT INTO departamento(ID_DEPARTAMENTO,ESPECIALIDAD) VALUES(2, 'Dermatologia');

INSERT INTO departamento(ID_DEPARTAMENTO,ESPECIALIDAD) VALUES(3, 'Neumologia');


INSERT INTO seguro(ID_SEGURO, NOMBRE, PRECIO, DESCRIPCION) VALUES(1,'Sin seguro', 0, 'No tiene seguro');
  	 	  	  
INSERT INTO seguro(ID_SEGURO, NOMBRE, PRECIO, DESCRIPCION) VALUES(2,'Seguro plata', 25.99, 'Seguro que cubre las citas que no son especiales y hace descuento a las especiales');


INSERT INTO seguro(ID_SEGURO, NOMBRE, PRECIO, DESCRIPCION) VALUES(3, 'Seguro oro', 145.99, 'Seguro que cubre todos los servicios');



INSERT INTO usuario(ID, USERNAME, NOMBRE, APELLIDOS, GMAIL, PASSWORD, DNI, ES_ADMIN, ES_DOCTOR) VALUES(1,'admin','Paco','Gomez','pacogomez@gmail.com','{bcrypt}$2y$10$gk.yHcB4aPtgs6zNYV6ve.4cgKMozKboCnIVj7a01ckM7sae9nXkW','12345678A',true,false);

INSERT INTO usuario(ID, USERNAME, NOMBRE, APELLIDOS, GMAIL, PASSWORD, DNI, ES_ADMIN, ES_DOCTOR) VALUES(2,'Doctor01','Jose','Garcia','josegarcia@gmail.com','{bcrypt}$2y$10$gk.yHcB4aPtgs6zNYV6ve.4cgKMozKboCnIVj7a01ckM7sae9nXkW','23456789B',false,true);

INSERT INTO usuario(ID, USERNAME, NOMBRE, APELLIDOS, GMAIL, PASSWORD, DNI, ES_ADMIN, ES_DOCTOR) VALUES(5,'Doctor02','Marta','Lopez','martalopez@gmail.com','{bcrypt}$2y$10$gk.yHcB4aPtgs6zNYV6ve.4cgKMozKboCnIVj7a01ckM7sae9nXkW','56789123E',false,true);

INSERT INTO usuario(ID, USERNAME, NOMBRE, APELLIDOS, GMAIL, PASSWORD, DNI, ES_ADMIN, ES_DOCTOR) VALUES(6,'Doctor03','Angela','Martín','angelamartin@gmail.com','{bcrypt}$2y$10$gk.yHcB4aPtgs6zNYV6ve.4cgKMozKboCnIVj7a01ckM7sae9nXkW','67891234F',false,true);

INSERT INTO usuario(ID, USERNAME, NOMBRE, APELLIDOS, GMAIL, PASSWORD, DNI, ES_ADMIN, ES_DOCTOR) VALUES(3,'Cliente01','Maria','Medina','mariamedina@gmail.com','{bcrypt}$2y$10$gk.yHcB4aPtgs6zNYV6ve.4cgKMozKboCnIVj7a01ckM7sae9nXkW','34567891C',false,false);

INSERT INTO usuario(ID, USERNAME, NOMBRE, APELLIDOS, GMAIL, PASSWORD, DNI, ES_ADMIN, ES_DOCTOR) VALUES(4,'Cliente02','Juan','Herrera','juanherrera@gmail.com','{bcrypt}$2y$10$gk.yHcB4aPtgs6zNYV6ve.4cgKMozKboCnIVj7a01ckM7sae9nXkW','45678912D',false,false);


INSERT INTO doctor(ID,DEPARTAMENTO_ID_DEPARTAMENTO,SALARIO,IND_JEFE) VALUES(2,1,200,false);

INSERT INTO doctor(ID,DEPARTAMENTO_ID_DEPARTAMENTO,SALARIO,IND_JEFE) VALUES(5,2,250,true);

INSERT INTO doctor(ID,DEPARTAMENTO_ID_DEPARTAMENTO,SALARIO,IND_JEFE) VALUES(6,3,170,false);
  	  	  	  


INSERT INTO cliente(ID,SEGURO_ID_SEGURO) VALUES(3,1);
	  
INSERT INTO cliente(ID,SEGURO_ID_SEGURO) VALUES(4,3);