DROP TABLE IF EXISTS usuarios;
CREATE TABLE usuarios (
    id INTEGER AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR (50) NOT NULL,
    fechaDeNacimiento DATE,
    apellido VARCHAR (50) NOT NULL,
    password VARCHAR (50) NOT NULL,
    DNI VARCHAR (50) NOT NULL,
    perfil VARCHAR (50) NOT NULL,
    telefono VARCHAR (50) NOT NULL,
    mail VARCHAR (50) NOT NULL,
    ultimoAcceso DATE

);