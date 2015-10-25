SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `Java2_test` DEFAULT CHARACTER SET utf8 ;
USE `Java2_test` ;

-- -----------------------------------------------------
-- Table `Java2_test`.`users`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `java2_test`.`users` ;

CREATE TABLE IF NOT EXISTS `java2_test`.`users` (
  `userId` BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  `username` CHAR(32) NOT NULL,
  `password` CHAR(32) NOT NULL,
  `email` CHAR(50) NOT NULL
)
ENGINE = InnoDB
AUTO_INCREMENT = 1002;

-- -----------------------------------------------------
-- Table `Java2_test`.`persons`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `java2_test`.`persons` ;

CREATE TABLE IF NOT EXISTS `java2_test`.`persons` (
  `PersonID` INT(11) NOT NULL AUTO_INCREMENT,
  `FirstName` CHAR(32) NOT NULL,
  `LastName` CHAR(32) NOT NULL,
  PRIMARY KEY (`PersonID`)
)
ENGINE = InnoDB
DEFAULT CHARSET=utf8;

-- -----------------------------------------------------
-- Table `Java2_test`.`groups`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `java2_test`.`groups` ;

CREATE TABLE IF NOT EXISTS `java2_test`.`groups` (
  `GroupID` INT(11) NOT NULL AUTO_INCREMENT,
  `Name` CHAR(32) NOT NULL,
  `Description` CHAR(32) NOT NULL,
  PRIMARY KEY (`GroupID`)
)
ENGINE = InnoDB
DEFAULT CHARSET=utf8;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;