CREATE DATABASE contatodb;

USE contatodb;

CREATE TABLE contato (
  id int NOT NULL AUTO_INCREMENT,
  nome varchar(100) DEFAULT NULL,
  telefone varchar(50) DEFAULT NULL,
  email varchar(100) DEFAULT NULL,
  nascimento date,
  PRIMARY KEY (id)
);
