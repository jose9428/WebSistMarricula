drop database if exists bdmatricula;

create database bdmatricula;

use bdmatricula;

CREATE TABLE Usuario
(
	Idusuario            INTEGER AUTO_INCREMENT,
    perfil               VARCHAR(30),
	usuario              VARCHAR(50) NULL,
	contrasena           VARCHAR(200) NULL,
	fechacreacion        DATE NULL DEFAULT now(),
	PRIMARY KEY (Idusuario)
);


CREATE TABLE Profesor
(
	IdProfesor           INTEGER AUTO_INCREMENT,
	Nombre               VARCHAR(60) NULL,
	Apellido_Paterno     VARCHAR(60) NULL,
	Apellido_Materno     VARCHAR(60) NULL,
	Documento            VARCHAR(15) NULL,
	Idusuario            INTEGER NULL,
	PRIMARY KEY (IdProfesor),
	FOREIGN KEY (Idusuario) REFERENCES Usuario (Idusuario)
);



CREATE TABLE Alumnos
(
	IdAlumno             INTEGER AUTO_INCREMENT,
    Idusuario            INTEGER NULL,
	Nombre               VARCHAR(60) NULL,
	Apellido_Paterno     VARCHAR(60) NULL,
	Apellido_Materno     VARCHAR(60) NULL,
	FecNac               DATE NULL,
	Direccion            VARCHAR(70) NULL,
	Telefono             VARCHAR(15) NULL,
	Email                VARCHAR(30) NULL,
	Documento            VARCHAR(15) NULL,
	Estado               BOOLEAN NULL,
	Apoderado            VARCHAR(40) NULL,
	PRIMARY KEY (IdAlumno),
    FOREIGN KEY(Idusuario) REFERENCES Usuario (Idusuario)
);

CREATE TABLE Curso
(
	IdCurso              INTEGER AUTO_INCREMENT,
	Nombre_curso         VARCHAR(60) NULL,
    Creditos             INTEGER,
	PRIMARY KEY (IdCurso)
);

Create table Seccion(
	idSeccion INTEGER AUTO_INCREMENT,
    IdProfesor  INTEGER,
    IdCurso INTEGER,
    Vacantes  INTEGER,
    dia VARCHAR(50),
    HoraInicio time,
    HoraFin time,
    PRIMARY KEY (idSeccion),
	FOREIGN KEY(IdProfesor) REFERENCES Profesor (IdProfesor),
    FOREIGN KEY(IdCurso) REFERENCES Curso (IdCurso)
)AUTO_INCREMENT = 10000;

Create table Matricula(
	IdMatricula  INTEGER AUTO_INCREMENT,
    IdAlumno     INTEGER,
    Fecha        date,
    estado       BOOLEAN,
    PRIMARY KEY (IdMatricula),
    FOREIGN KEY(IdAlumno) REFERENCES Alumnos (IdAlumno)
);

Create table DetalleMatricula(
	 IdDetalleMatricula INTEGER AUTO_INCREMENT,
	 IdMatricula   INTEGER,
	 idSeccion  INTEGER,
	 PRIMARY KEY (IdDetalleMatricula),
	 FOREIGN KEY(IdMatricula) REFERENCES Matricula (IdMatricula) ON DELETE CASCADE,
	 FOREIGN KEY(idSeccion) REFERENCES Seccion (idSeccion)
);


INSERT INTO USUARIO (idusuario , perfil  , usuario , contrasena)VALUES(1 ,'ALUMNO' , '1624512' , '123456');
INSERT INTO USUARIO (idusuario , perfil  , usuario , contrasena)VALUES(2 , 'ALUMNO' , '1624513' , '123456');
INSERT INTO USUARIO (idusuario , perfil  , usuario , contrasena)VALUES(3 , 'ALUMNO' , '1624514' , '123456');
INSERT INTO USUARIO (idusuario , perfil  , usuario , contrasena)VALUES(4 , 'ALUMNO' , '1624515' , '123456');
INSERT INTO USUARIO (idusuario , perfil  , usuario , contrasena)VALUES(5 , 'ALUMNO' , '1624516' , '123456');
INSERT INTO USUARIO (idusuario , perfil  , usuario , contrasena)VALUES(6 , 'ALUMNO' , '1624517' , '123456');

INSERT INTO ALUMNOS VALUES(NULL , 1 , 'Luis' ,  'Rosales' , 'Juares' ,'1992-12-15' , 'Av. Garcilzo de la Vega 185 - El Agustino' , '1235485' , '1624512@utp.edu.pe' , '17854268' , 1 , 'Marco Rosales Coleman');
INSERT INTO ALUMNOS VALUES(NULL , 2 , 'Andres' ,  'Vasquez' , 'Infantes' ,'1994-08-15' , 'Av. Guzman Blanco 231- Lima' , '4581235' , '1624513@utp.edu.pe' , '84569251' , 1 , 'Maria Santana Infantes');
INSERT INTO ALUMNOS VALUES(NULL , 3 , 'Maria' ,  'Guevara' , 'Suarez' ,'1993-05-17' , 'Calle los faroles 453 - La Victoria' , '6547851' , '1624514@utp.edu.pe' , '74581685' , 1 , 'Jhon Guevara Mora');
INSERT INTO ALUMNOS VALUES(NULL , 4 , 'Jhon' ,  'Anchante' , 'Hurtado' ,'1991-04-19' , 'Av. Circunvalacion 214 - Ate' , '1548358' , '1624515@utp.edu.pe' , '47852158' , 1 , 'Pedro Anchante Hurtado');
INSERT INTO ALUMNOS VALUES(NULL , 5 , 'Christy' ,  'Treneman' , 'Lopez' ,'1992-11-11' , 'Av, Constructores 123 - La Molina' , '8456248' , '1624516@utp.edu.pe' , '78541325' , 1 , 'Antonio Treneman Guevara');
INSERT INTO ALUMNOS VALUES(NULL , 6 , 'Gerardo' ,  'Garcia' , 'Mori' ,'1991-10-12' , 'Av. Los gorriones 154 - Miraflores' , '4756215' , '1624517@utp.edu.pe' , '47581235' , 1 , 'Hugo Garcia Leyva');

INSERT INTO USUARIO (idusuario , perfil  , usuario , contrasena)VALUES(7 ,'PROFESOR' , '9045111' , '123456');
INSERT INTO USUARIO (idusuario , perfil  , usuario , contrasena)VALUES(8 , 'PROFESOR' , '9045112' , '123456');
INSERT INTO USUARIO (idusuario , perfil  , usuario , contrasena)VALUES(9 , 'PROFESOR' , '9045113' , '123456');
INSERT INTO USUARIO (idusuario , perfil  , usuario , contrasena)VALUES(10 , 'PROFESOR' , '9045114' , '123456');
INSERT INTO USUARIO (idusuario , perfil  , usuario , contrasena)VALUES(11 , 'PROFESOR' , '9045115' , '123456');
INSERT INTO USUARIO (idusuario , perfil  , usuario , contrasena)VALUES(12 , 'PROFESOR' , '9045116' , '123456');

INSERT INTO PROFESOR VALUES(NULL , 'Andres' , 'Rojas' , 'Cruz' , '89641258' , 7);
INSERT INTO PROFESOR VALUES(NULL , 'Edgard' , 'Moreno' , 'Cueva' , '74512368' , 8);
INSERT INTO PROFESOR VALUES(NULL , 'Maria' , 'Garcia' , 'Angulo' , '84512658' , 9);
INSERT INTO PROFESOR VALUES(NULL , 'Marco' , 'Vizcarra' , 'Gomez' , '78451265' , 10);
INSERT INTO PROFESOR VALUES(NULL , 'Nicanor' , 'Paucar' , 'Guevara' , '25698452' , 11);
INSERT INTO PROFESOR VALUES(NULL , 'Yovana' , 'Chavez' , 'Huertas' , '47851356' , 12);

INSERT INTO CURSO VALUES(1 , 'Matematica I' , 4);
INSERT INTO CURSO VALUES(2 , 'Matematica II' , 3);
INSERT INTO CURSO VALUES(3 , 'Fisica' , 4);
INSERT INTO CURSO VALUES(4 , 'Ingles I' , 4);
INSERT INTO CURSO VALUES(5 , 'Ingles II' , 5);
INSERT INTO CURSO VALUES(6 , 'Lenguaje' , 2);
INSERT INTO CURSO VALUES(7 , 'Literatura' , 4);
INSERT INTO CURSO VALUES(8 , 'Quimica' , 4);
INSERT INTO CURSO VALUES(9 , 'Biologia' , 3);
INSERT INTO CURSO VALUES(10 , 'Tutoria' , 4);


INSERT INTO SECCION VALUES(NULL , 1 , 1 , 40 , 'LUNES' , '08:00' , '09:30' );
INSERT INTO SECCION VALUES(NULL , 2 , 2 , 35 , 'MARTES' , '17:00' , '19:00' );
INSERT INTO SECCION VALUES(NULL , 1 , 7 , 40 , 'LUNES' , '09:45' , '11:15' );
INSERT INTO SECCION VALUES(NULL , 3 , 5 , 40 , 'VIERNES' , '08:00' , '09:30' );
INSERT INTO SECCION VALUES(NULL , 1 , 4 , 25 , 'LUNES' , '18:00' , '20:15' );
INSERT INTO SECCION VALUES(NULL , 4 , 3 , 40 , 'SABADO' , '08:00' , '09:30' );
INSERT INTO SECCION VALUES(NULL , 5 , 1 , 20 , 'LUNES' , '08:00' , '09:30' );
INSERT INTO SECCION VALUES(NULL , 6 , 2 , 40 , 'JUEVES' , '08:00' , '09:30' );
INSERT INTO SECCION VALUES(NULL , 3 , 6 , 40 , 'LUNES' , '08:00' , '09:30' );
INSERT INTO SECCION VALUES(NULL , 4 , 8 , 40 , 'LUNES' , '08:00' , '09:30' );

INSERT INTO SECCION VALUES(NULL , 2 , 1 , 20 , 'JUEVES' , '11:30' , '13:00' );
INSERT INTO SECCION VALUES(NULL , 6 , 1 , 30 , 'MARTES' , '16:45' , '18:15' );

INSERT INTO SECCION VALUES(NULL , 2 , 2 , 35 , 'JUEVES' , '11:30' , '13:00' );
INSERT INTO SECCION VALUES(NULL , 5 , 2 , 25 , 'MIERCOLES' , '18:30' , '20:00' );


INSERT INTO SECCION VALUES(NULL , 3 , 9 , 30 , 'MARTES' , '11:30' , '13:00' );
INSERT INTO SECCION VALUES(NULL , 4 , 9 , 18 , 'MIERCOLES' , '20:15' , '21:45' );

select * from seccion;
select * from profesor;
select * from curso;

DELIMITER @@
DROP PROCEDURE IF EXISTS sp_agregar_alumno @@
CREATE PROCEDURE sp_agregar_alumno
(
_NOMBRE VARCHAR(40),
_APEP VARCHAR(40),
_APEM VARCHAR(40),
_FECHA_NAC DATE,
_DIRECCION VARCHAR(50),
_TELEFONO CHAR(9),
_EMAIL VARCHAR(50),
_DNI CHAR(8),
_ESTADO CHAR(1),
_APODERADO VARCHAR(60)
)
BEGIN
  DECLARE _USER VARCHAR(15);
  DECLARE _ID_USER INTEGER;
  DECLARE _ID_ALU INTEGER;
  
  SELECT IFNULL(MAX(IDALUMNO),0) + 1 INTO _ID_ALU FROM ALUMNOS; -- OBTENER EL MAXIMO ALUMNO
  
  SET _USER = CONCAT('U',SUBSTRING(YEAR(NOW()),3,2) , MONTH(NOW()) , LPAD(_ID_ALU , 4, '0')); -- OBTENER EL USUARIO GENERADO
  
  INSERT INTO USUARIO VALUES(NULL , 'ALUMNO' , _USER , _DNI , NOW());	
  
  select last_insert_id() INTO _ID_USER;
  
  INSERT INTO ALUMNOS VALUES(NULL , _ID_USER , _NOMBRE , _APEP , _APEM , _FECHA_NAC , _DIRECCION , _TELEFONO , _EMAIL , _DNI ,_ESTADO,_APODERADO );
END @@
DELIMITER ;


DELIMITER @@
DROP PROCEDURE IF EXISTS sp_agregar_profesor @@
CREATE PROCEDURE sp_agregar_profesor
(
_NOMBRE VARCHAR(40),
_APEP VARCHAR(40),
_APEM VARCHAR(40),
_DNI CHAR(8)
)
BEGIN
  DECLARE _USER VARCHAR(15);
  DECLARE _ID_USER INTEGER;
  DECLARE _ID_PROF INTEGER;
  
  SELECT IFNULL(MAX(IDPROFESOR),0) + 1 INTO _ID_PROF FROM PROFESOR; -- OBTENER EL MAXIMO ALUMNO
  
  SET _USER = CONCAT('C',SUBSTRING(YEAR(NOW()),3,2) , MONTH(NOW()) , LPAD(_ID_PROF , 4, '0')); -- OBTENER EL USUARIO GENERADO
  
  INSERT INTO USUARIO VALUES(NULL , 'PROFESOR' , _USER , _DNI , NOW());	
  
  select last_insert_id() INTO _ID_USER;
  
  INSERT INTO PROFESOR VALUES(NULL  , _NOMBRE , _APEP , _APEM , _DNI ,_ID_USER);
END @@
DELIMITER ;


DELIMITER @@
DROP PROCEDURE IF EXISTS sp_agregar_matricula @@
CREATE PROCEDURE sp_agregar_matricula
(
_ID_ALUMNO INT,
_ESTADO INT
)
BEGIN
   INSERT INTO MATRICULA (IDALUMNO , FECHA , ESTADO) VALUES( _ID_ALUMNO , NOW() , _ESTADO);
   select last_insert_id();
END @@
DELIMITER ;

DELIMITER @@
DROP PROCEDURE IF EXISTS sp_agregar_detalleMatricula @@
CREATE PROCEDURE sp_agregar_detalleMatricula
(
_ID_MATRICULA INT,
_ID_SECCION INT
)
BEGIN
   INSERT INTO DETALLEMATRICULA (IDMATRICULA , IDSECCION) VALUES( _ID_MATRICULA , _ID_SECCION);
   UPDATE SECCION SET VACANTES = VACANTES - 1 WHERE IDSECCION = _ID_SECCION;
END @@
DELIMITER ;


DELIMITER @@
DROP PROCEDURE IF EXISTS sp_eliminar_matricula @@
CREATE PROCEDURE sp_eliminar_matricula
(
_ID_MAT INT
)
BEGIN
   DELETE FROM MATRICULA WHERE IDMATRICULA = _ID_MAT; 
END @@
DELIMITER ;

DELIMITER @@
DROP PROCEDURE IF EXISTS sp_eliminar_matricula2 @@
CREATE PROCEDURE sp_eliminar_matricula2
(
_ID_MAT INT
)
BEGIN
  DECLARE done INT DEFAULT FALSE;
  DECLARE nroSeccion INT;
  DECLARE cur1 CURSOR FOR select idSeccion from detallematricula where idMatricula = _ID_MAT;
  DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = TRUE;
  
    OPEN cur1;
    read_loop: LOOP
    FETCH cur1 INTO nroSeccion;
    IF done THEN
      LEAVE read_loop;
    END IF;
    
    update seccion set vacantes = vacantes + 1
    where idSeccion =  nroSeccion;
  END LOOP;
  CLOSE cur1;

   DELETE FROM MATRICULA WHERE IDMATRICULA = _ID_MAT; 
END @@
DELIMITER ;


select * from usuario;
