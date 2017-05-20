-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema instagram
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema instagram
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `instagram` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `instagram` ;

-- -----------------------------------------------------
-- Table `instagram`.`Korisnik`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `instagram`.`Korisnik` (
  `idKorisnik` INT NOT NULL AUTO_INCREMENT,
  `korisnickoIme` VARCHAR(20) NOT NULL,
  `korisnickaSifraHash` VARCHAR(30) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `kratakOpis` VARCHAR(100) NOT NULL,
  UNIQUE INDEX `idkorisnik_UNIQUE` (`idKorisnik` ASC),
  PRIMARY KEY (`idKorisnik`),
  UNIQUE INDEX `korisnickoIme_UNIQUE` (`korisnickoIme` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `instagram`.`Panel`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `instagram`.`Panel` (
  `idPanel` INT NOT NULL AUTO_INCREMENT,
  `kreatorPanela` INT NOT NULL,
  `privatnost` TINYINT(1) NOT NULL,
  PRIMARY KEY (`idPanel`),
  UNIQUE INDEX `idPanel_UNIQUE` (`idPanel` ASC),
  INDEX `fk_Panel_Korisnik_idx` (`kreatorPanela` ASC),
  CONSTRAINT `fk_Panel_Korisnik`
    FOREIGN KEY (`kreatorPanela`)
    REFERENCES `instagram`.`Korisnik` (`idKorisnik`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `instagram`.`ucesniciPanela`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `instagram`.`ucesniciPanela` (
  `idKorisnik` INT NOT NULL,
  `idPanel` INT NOT NULL,
  INDEX `fk_Korisnik_has_Panel_Panel1_idx` (`idPanel` ASC),
  INDEX `fk_Korisnik_has_Panel_Korisnik1_idx` (`idKorisnik` ASC),
  PRIMARY KEY (`idKorisnik`, `idPanel`),
  CONSTRAINT `fk_Korisnik_has_Panel_Korisnik1`
    FOREIGN KEY (`idKorisnik`)
    REFERENCES `instagram`.`Korisnik` (`idKorisnik`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Korisnik_has_Panel_Panel1`
    FOREIGN KEY (`idPanel`)
    REFERENCES `instagram`.`Panel` (`idPanel`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `instagram`.`PozivniceZaPanel`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `instagram`.`PozivniceZaPanel` (
  `idPozivnice` INT NOT NULL AUTO_INCREMENT,
  `korisnikPoslao` INT NOT NULL,
  `korisnikPrima` INT NOT NULL,
  `idPanela` INT NOT NULL,
  INDEX `fk_Korisnik_has_Panel_Panel2_idx` (`idPanela` ASC),
  INDEX `fk_Korisnik_has_Panel_Korisnik2_idx` (`korisnikPoslao` ASC),
  UNIQUE INDEX `idPozivnice_UNIQUE` (`idPozivnice` ASC),
  PRIMARY KEY (`idPozivnice`),
  INDEX `fk_korisnik_prima_idx` (`korisnikPrima` ASC),
  CONSTRAINT `fk_Korisnik_poslao_pozivnica`
    FOREIGN KEY (`korisnikPoslao`)
    REFERENCES `instagram`.`Korisnik` (`idKorisnik`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_panel_pozivnica`
    FOREIGN KEY (`idPanela`)
    REFERENCES `instagram`.`Panel` (`idPanel`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_korisnik_prima_pozivnica`
    FOREIGN KEY (`korisnikPrima`)
    REFERENCES `instagram`.`Korisnik` (`idKorisnik`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `instagram`.`Lokacija`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `instagram`.`Lokacija` (
  `idLokacija` INT NOT NULL AUTO_INCREMENT,
  `nazivLokacije` VARCHAR(45) NOT NULL,
  UNIQUE INDEX `idLokacija_UNIQUE` (`idLokacija` ASC),
  PRIMARY KEY (`idLokacija`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `instagram`.`Fotografija`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `instagram`.`Fotografija` (
  `idFotografija` INT NOT NULL AUTO_INCREMENT,
  `idKorisnik` INT NOT NULL,
  `idLokacija` INT NOT NULL,
  `brojSvidjanja` INT NOT NULL,
  PRIMARY KEY (`idFotografija`),
  UNIQUE INDEX `idFotografija_UNIQUE` (`idFotografija` ASC),
  INDEX `kreatorFotografije_idx` (`idKorisnik` ASC),
  INDEX `lokacijaFotografije_idx` (`idLokacija` ASC),
  CONSTRAINT `kreatorFotografije_fotografija`
    FOREIGN KEY (`idKorisnik`)
    REFERENCES `instagram`.`Korisnik` (`idKorisnik`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `lokacijaFotografije_fotografija`
    FOREIGN KEY (`idLokacija`)
    REFERENCES `instagram`.`Lokacija` (`idLokacija`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `instagram`.`FotografijaSvidjanja`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `instagram`.`FotografijaSvidjanja` (
  `idFotografije` INT NOT NULL,
  `idKorisnika` INT NOT NULL,
  PRIMARY KEY (`idFotografije`, `idKorisnika`),
  INDEX `fk_korisnik_idx` (`idKorisnika` ASC),
  CONSTRAINT `fk_fotografija`
    FOREIGN KEY (`idFotografije`)
    REFERENCES `instagram`.`Fotografija` (`idFotografija`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_korisnik`
    FOREIGN KEY (`idKorisnika`)
    REFERENCES `instagram`.`Korisnik` (`idKorisnik`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `instagram`.`Komentari`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `instagram`.`Komentari` (
  `idKomentara` INT NOT NULL AUTO_INCREMENT,
  `idFotografije` INT NOT NULL,
  `idKorisnika` INT NOT NULL,
  `tekstKomentara` VARCHAR(100) NOT NULL,
  UNIQUE INDEX `idKomentara_UNIQUE` (`idKomentara` ASC),
  PRIMARY KEY (`idKomentara`),
  INDEX `fk_fotografija_idx` (`idFotografije` ASC),
  INDEX `fk_korisnik_idx` (`idKorisnika` ASC),
  CONSTRAINT `fk_fotografija_komentar`
    FOREIGN KEY (`idFotografije`)
    REFERENCES `instagram`.`Fotografija` (`idFotografija`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_korisnik_komentar`
    FOREIGN KEY (`idKorisnika`)
    REFERENCES `instagram`.`Korisnik` (`idKorisnik`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `instagram`.`ZahtjevZaPridruživanjePanelu`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `instagram`.`ZahtjevZaPridruživanjePanelu` (
  `idZahtjeva` INT NOT NULL AUTO_INCREMENT,
  `idKorisnika` INT NOT NULL,
  `idPanela` INT NOT NULL,
  PRIMARY KEY (`idZahtjeva`),
  INDEX `fk_panel_idx` (`idPanela` ASC),
  INDEX `fk_korisnik_idx` (`idKorisnika` ASC),
  CONSTRAINT `fk_panel_zahtjevPridruzivanja`
    FOREIGN KEY (`idPanela`)
    REFERENCES `instagram`.`Panel` (`idPanel`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_korisnik_zahtjevPridruzivanja`
    FOREIGN KEY (`idKorisnika`)
    REFERENCES `instagram`.`Korisnik` (`idKorisnik`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `instagram`.`ZahtjevZaPrijateljstvo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `instagram`.`ZahtjevZaPrijateljstvo` (
  `idZahtjeva` INT NOT NULL AUTO_INCREMENT,
  `idKorisnikaPoslao` INT NOT NULL,
  `idKorisnikaPrima` INT NOT NULL,
  `procitana` TINYINT(1) NOT NULL,
  `kratakOpisNotifikacije` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`idZahtjeva`),
  UNIQUE INDEX `idZahtjeva_UNIQUE` (`idZahtjeva` ASC),
  INDEX `fk_korisnik_poslao_idx` (`idKorisnikaPoslao` ASC),
  INDEX `fk_korisnik_prima_idx` (`idKorisnikaPrima` ASC),
  CONSTRAINT `fk_korisnik_poslao_zahtjev`
    FOREIGN KEY (`idKorisnikaPoslao`)
    REFERENCES `instagram`.`Korisnik` (`idKorisnik`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_korisnik_prima_zahtjev`
    FOREIGN KEY (`idKorisnikaPrima`)
    REFERENCES `instagram`.`Korisnik` (`idKorisnik`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `instagram`.`Prijateljstva`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `instagram`.`Prijateljstva` (
  `idKorisnika1` INT NOT NULL,
  `idKorisnika2` INT NOT NULL,
  PRIMARY KEY (`idKorisnika1`, `idKorisnika2`),
  INDEX `fk_korisnik_2_idx` (`idKorisnika2` ASC),
  CONSTRAINT `fk_korisnik_1_prijatelj`
    FOREIGN KEY (`idKorisnika1`)
    REFERENCES `instagram`.`Korisnik` (`idKorisnik`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_korisnik_2_prijatelj`
    FOREIGN KEY (`idKorisnika2`)
    REFERENCES `instagram`.`Korisnik` (`idKorisnik`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `instagram`.`Notifikacije`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `instagram`.`Notifikacije` (
  `idNotifikacije` INT NOT NULL AUTO_INCREMENT,
  `idKorisnika` INT NOT NULL,
  `tipNotifikacije` INT NOT NULL,
  `idNotifikacije_tip` INT NOT NULL,
  PRIMARY KEY (`idNotifikacije`),
  UNIQUE INDEX `idNotifikacije_UNIQUE` (`idNotifikacije` ASC),
  INDEX `fk_korisnik_idx` (`idKorisnika` ASC),
  CONSTRAINT `fk_korisnik_norifikacije`
    FOREIGN KEY (`idKorisnika`)
    REFERENCES `instagram`.`Korisnik` (`idKorisnik`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
