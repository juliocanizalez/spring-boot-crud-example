CREATE DATABASE EncuestaLab2JEC

USE EncuestaLab2JEC;

CREATE TABLE EncuestaJEC(
id_encuesta INT NOT NULL PRIMARY KEY auto_increment,
nombre VARCHAR(150) NOT NULL,
sexo VARCHAR(9) NOT NULL,
deporte_favorito VARCHAR(10) NOT NULL,
nivel_estudio VARCHAR(10) NOT NULL,
temas VARCHAR(10) NOT NULL
);

