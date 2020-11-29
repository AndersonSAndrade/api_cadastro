/*
 * Copyright (c) 2020. Olá todos os direitos reservados para Anderson S. Andrade.
 * Local do Arquivo: (/Users/andersons.andrade/Desktop/JAVA/SPRING/DEVELOPER/CADASTRO/api/src/main/resources/db/migration/V1_0__cria_usuario_schema.sql)
 * Projeto: api -> api -> V1_0__cria_usuario_schema.sql
 * Criador: andersons.andrade
 * Última Modificação: 28/11/2020 10:39
 */

CREATE TABLE IF NOT EXISTS usuario (
   codigo int NOT NULL AUTO_INCREMENT PRIMARY KEY,
   nome varchar(100) NOT NULL ,
   foto text,
   data_nascimento TIMESTAMP
)ENGINE=InnoDB DEFAULT CHARSET=UTF8;