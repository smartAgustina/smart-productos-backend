DROP TABLE IF EXISTS usuarios;
CREATE TABLE usuarios (
    id INTEGER AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR (50) NOT NULL,
    apellido VARCHAR (50) NOT NULL,
    dni VARCHAR (50) NOT NULL,
    telefono VARCHAR (50) NOT NULL,
    mail VARCHAR (150) NOT NULL,
    rol ENUM('ADMIN', 'USER') NOT NULL,
    ultimoAcceso DATE,
    password VARCHAR (50) NOT NULL
   

);
ALTER TABLE usuarios ADD COLUMN ultimo_acceso timestamp(6);