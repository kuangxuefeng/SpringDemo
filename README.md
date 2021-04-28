# SpringDemo
SpringDemo
mybatis generator

CREATE SCHEMA `mysql_test` DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci ;

CREATE TABLE `mysql_test`.`user_table` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `pw` VARCHAR(45) NOT NULL,
  `info` VARCHAR(45) NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `name_UNIQUE` (`name` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci;