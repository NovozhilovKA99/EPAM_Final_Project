-- MySQL Script generated by MySQL Workbench
-- Tue Sep 17 13:59:23 2019
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `mydb` ;

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`User`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`User` ;

CREATE TABLE IF NOT EXISTS `mydb`.`User` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `fullName` VARCHAR(45) NOT NULL,
  `birthday` DATE NULL,
  `position` VARCHAR(45) NOT NULL,
  `contractId` INT NOT NULL,
  `password` VARCHAR(255) NOT NULL,
  `login` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `idUser_UNIQUE` (`id` ASC) VISIBLE,
  UNIQUE INDEX `contractId_UNIQUE` (`contractId` ASC) VISIBLE,
  UNIQUE INDEX `login_UNIQUE` (`login` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Route`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Route` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Route` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `number` INT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `idRoute_UNIQUE` (`id` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Stop`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Stop` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Stop` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `Route_id` INT NOT NULL,
  `end` TINYINT NOT NULL,
  `IndexRoute` INT NOT NULL,
  PRIMARY KEY (`id`, `Route_id`),
  INDEX `fk_Stops_Route1_idx` (`Route_id` ASC) VISIBLE,
  UNIQUE INDEX `idStops_UNIQUE` (`id` ASC) VISIBLE,
  CONSTRAINT `fk_Stops_Route1`
    FOREIGN KEY (`Route_id`)
    REFERENCES `mydb`.`Route` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Type`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Type` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Type` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `description` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `idType_UNIQUE` (`id` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Model`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Model` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Model` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `description` VARCHAR(45) NULL,
  `Type_id` INT NOT NULL,
  PRIMARY KEY (`id`, `Type_id`),
  UNIQUE INDEX `idModel_UNIQUE` (`id` ASC) VISIBLE,
  INDEX `fk_Model_Type1_idx` (`Type_id` ASC) VISIBLE,
  CONSTRAINT `fk_Model_Type1`
    FOREIGN KEY (`Type_id`)
    REFERENCES `mydb`.`Type` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Transport`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Transport` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Transport` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `Model_id` INT NOT NULL,
  `regPlate` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`, `Model_id`),
  INDEX `fk_Transport_Model1_idx` (`Model_id` ASC) VISIBLE,
  UNIQUE INDEX `regPlate_UNIQUE` (`regPlate` ASC) VISIBLE,
  CONSTRAINT `fk_Transport_Model1`
    FOREIGN KEY (`Model_id`)
    REFERENCES `mydb`.`Model` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Сast`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Cast` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Cast` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `Transport_id` INT NOT NULL,
  `Route_id` INT NOT NULL,
  `User_idDriver` INT NOT NULL,
  `User_idConductor` INT NOT NULL,
  `startTime` DATETIME NOT NULL,
  `endTime` DATETIME NOT NULL,
  INDEX `fk_cast_Transport1_idx` (`Transport_id` ASC) VISIBLE,
  INDEX `fk_cast_Route1_idx` (`Route_id` ASC) VISIBLE,
  INDEX `fk_cast_User1_idx` (`User_idDriver` ASC) VISIBLE,
  INDEX `fk_cast_User2_idx` (`User_idConductor` ASC) VISIBLE,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_cast_Transport1`
    FOREIGN KEY (`Transport_id`)
    REFERENCES `mydb`.`Transport` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_cast_Route1`
    FOREIGN KEY (`Route_id`)
    REFERENCES `mydb`.`Route` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_cast_User1`
    FOREIGN KEY (`User_idDriver`)
    REFERENCES `mydb`.`User` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_cast_User2`
    FOREIGN KEY (`User_idConductor`)
    REFERENCES `mydb`.`User` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Driver`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Driver` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Driver` (
  `User_idUser` INT NOT NULL,
  INDEX `fk_Driver_User1_idx` (`User_idUser` ASC) VISIBLE,
  UNIQUE INDEX `User_idUser_UNIQUE` (`User_idUser` ASC) VISIBLE,
  PRIMARY KEY (`User_idUser`),
  CONSTRAINT `fk_Driver_User1`
    FOREIGN KEY (`User_idUser`)
    REFERENCES `mydb`.`User` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Driver_has_Type`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Driver_has_Type` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Driver_has_Type` (
  `User_id` INT NOT NULL,
  `Type_id` INT NOT NULL,
  INDEX `fk_Driver_has_Type_Type1_idx` (`Type_id` ASC) VISIBLE,
  INDEX `fk_Driver_has_Type_User1_idx` (`User_id` ASC) VISIBLE,
  CONSTRAINT `fk_Driver_has_Type_Type1`
    FOREIGN KEY (`Type_id`)
    REFERENCES `mydb`.`Type` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Driver_has_Type_User1`
    FOREIGN KEY (`User_id`)
    REFERENCES `mydb`.`User` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
