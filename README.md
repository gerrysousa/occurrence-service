# Ocorrencia Services


####Criar schema de banco de dados

CREATE SCHEMA `ocorrenciasDB` ;


####Criar table ocorrencias

CREATE TABLE `ocorrenciasDB`.`ocorrencias` (
  `idocorrencias` INT NOT NULL AUTO_INCREMENT,
  `categoria` VARCHAR(45) NOT NULL,
  `subcategoria` VARCHAR(45) NOT NULL,
  `status` VARCHAR(45) NULL,
  `dataCadastro` DATETIME NULL,
  PRIMARY KEY (`idocorrencias`));

