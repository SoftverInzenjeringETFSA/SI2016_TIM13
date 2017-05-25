-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 25, 2017 at 12:28 AM
-- Server version: 5.7.14
-- PHP Version: 5.6.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `tim13`
--

-- --------------------------------------------------------

--
-- Table structure for table `fotografije`
--

CREATE TABLE `fotografije` (
  `fotografija_id` int(11) NOT NULL,
  `korisnik_id` int(11) NOT NULL,
  `lokacija_id` int(11) NOT NULL,
  `broj_svidjanja` int(11) NOT NULL,
  `fotografija` mediumblob NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `fotografije_svidjanja`
--

CREATE TABLE `fotografije_svidjanja` (
  `fotografija_id` int(11) NOT NULL,
  `korisnik_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `komentari`
--

CREATE TABLE `komentari` (
  `komentar_id` int(11) NOT NULL,
  `fotografija_id` int(11) NOT NULL,
  `korisnik_id` int(11) NOT NULL,
  `sadrzaj` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `korisnici`
--

CREATE TABLE `korisnici` (
  `korisnik_id` int(11) NOT NULL,
  `korisnicko_ime` varchar(20) NOT NULL,
  `email` varchar(45) NOT NULL,
  `korisnicka_sifra_hash` varchar(255) NOT NULL,
  `kratak_opis` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `korisnici`
--

INSERT INTO `korisnici` (`korisnik_id`, `korisnicko_ime`, `email`, `korisnicka_sifra_hash`, `kratak_opis`) VALUES
(3, 'test', 'testni@mail.com', '0cbc6611f5540bd0809a388dc95a615b', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `lokacije`
--

CREATE TABLE `lokacije` (
  `lokacija_id` int(11) NOT NULL,
  `naziv` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `notifikacije`
--

CREATE TABLE `notifikacije` (
  `notifikacija_id` int(11) NOT NULL,
  `korisnik_id` int(11) NOT NULL,
  `tip_notifikacije` int(11) NOT NULL,
  `tip_notifikacije_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `paneli`
--

CREATE TABLE `paneli` (
  `panel_id` int(11) NOT NULL,
  `kreator_panela` int(11) NOT NULL,
  `privatnost` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `pozivnice_za_panel`
--

CREATE TABLE `pozivnice_za_panel` (
  `pozivnica_id` int(11) NOT NULL,
  `korisnik_poslao_id` int(11) NOT NULL,
  `korisnik_prima_id` int(11) NOT NULL,
  `panel_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `prijateljstva`
--

CREATE TABLE `prijateljstva` (
  `prijateljstvo_id` int(11) NOT NULL,
  `korisnik1_id` int(11) NOT NULL,
  `korisnik2_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `ucesnici_panela`
--

CREATE TABLE `ucesnici_panela` (
  `korisnik_id` int(11) NOT NULL,
  `panel_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `zahtjevi_za_pridruzivanje`
--

CREATE TABLE `zahtjevi_za_pridruzivanje` (
  `zahtjev_id` int(11) NOT NULL,
  `korisnik_id` int(11) NOT NULL,
  `panel_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `zahtjevi_za_prijateljstvo`
--

CREATE TABLE `zahtjevi_za_prijateljstvo` (
  `zahtjev_id` int(11) NOT NULL,
  `korisnik_poslao_id` int(11) NOT NULL,
  `korisnik_prima_id` int(11) NOT NULL,
  `status` tinyint(1) NOT NULL,
  `opis` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `fotografije`
--
ALTER TABLE `fotografije`
  ADD PRIMARY KEY (`fotografija_id`),
  ADD KEY `lokacija_id` (`lokacija_id`),
  ADD KEY `korisnik_id` (`korisnik_id`);

--
-- Indexes for table `fotografije_svidjanja`
--
ALTER TABLE `fotografije_svidjanja`
  ADD KEY `fotografija_id` (`fotografija_id`),
  ADD KEY `korisnik_id` (`korisnik_id`);

--
-- Indexes for table `komentari`
--
ALTER TABLE `komentari`
  ADD PRIMARY KEY (`komentar_id`),
  ADD KEY `fotografija_id` (`fotografija_id`),
  ADD KEY `korisnik_id` (`korisnik_id`);

--
-- Indexes for table `korisnici`
--
ALTER TABLE `korisnici`
  ADD PRIMARY KEY (`korisnik_id`);

--
-- Indexes for table `lokacije`
--
ALTER TABLE `lokacije`
  ADD PRIMARY KEY (`lokacija_id`);

--
-- Indexes for table `notifikacije`
--
ALTER TABLE `notifikacije`
  ADD PRIMARY KEY (`notifikacija_id`),
  ADD KEY `korisnik_id` (`korisnik_id`);

--
-- Indexes for table `paneli`
--
ALTER TABLE `paneli`
  ADD PRIMARY KEY (`panel_id`),
  ADD KEY `kreator_panela` (`kreator_panela`);

--
-- Indexes for table `pozivnice_za_panel`
--
ALTER TABLE `pozivnice_za_panel`
  ADD PRIMARY KEY (`pozivnica_id`),
  ADD KEY `korisnik_poslao_id` (`korisnik_poslao_id`),
  ADD KEY `korisnik_prima_id` (`korisnik_prima_id`),
  ADD KEY `panel_id` (`panel_id`);

--
-- Indexes for table `prijateljstva`
--
ALTER TABLE `prijateljstva`
  ADD PRIMARY KEY (`prijateljstvo_id`),
  ADD KEY `korisnik1_id` (`korisnik1_id`),
  ADD KEY `korisnik2_id` (`korisnik2_id`);

--
-- Indexes for table `ucesnici_panela`
--
ALTER TABLE `ucesnici_panela`
  ADD KEY `korisnik_id` (`korisnik_id`),
  ADD KEY `panel_id` (`panel_id`);

--
-- Indexes for table `zahtjevi_za_pridruzivanje`
--
ALTER TABLE `zahtjevi_za_pridruzivanje`
  ADD PRIMARY KEY (`zahtjev_id`),
  ADD KEY `korisnik_id` (`korisnik_id`),
  ADD KEY `panel_id` (`panel_id`);

--
-- Indexes for table `zahtjevi_za_prijateljstvo`
--
ALTER TABLE `zahtjevi_za_prijateljstvo`
  ADD PRIMARY KEY (`zahtjev_id`),
  ADD KEY `korisnik_poslao_id` (`korisnik_poslao_id`),
  ADD KEY `korisnik_prima_id` (`korisnik_prima_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `fotografije`
--
ALTER TABLE `fotografije`
  MODIFY `fotografija_id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `komentari`
--
ALTER TABLE `komentari`
  MODIFY `komentar_id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `korisnici`
--
ALTER TABLE `korisnici`
  MODIFY `korisnik_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `lokacije`
--
ALTER TABLE `lokacije`
  MODIFY `lokacija_id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `notifikacije`
--
ALTER TABLE `notifikacije`
  MODIFY `notifikacija_id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `paneli`
--
ALTER TABLE `paneli`
  MODIFY `panel_id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `pozivnice_za_panel`
--
ALTER TABLE `pozivnice_za_panel`
  MODIFY `pozivnica_id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `prijateljstva`
--
ALTER TABLE `prijateljstva`
  MODIFY `prijateljstvo_id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `zahtjevi_za_pridruzivanje`
--
ALTER TABLE `zahtjevi_za_pridruzivanje`
  MODIFY `zahtjev_id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `zahtjevi_za_prijateljstvo`
--
ALTER TABLE `zahtjevi_za_prijateljstvo`
  MODIFY `zahtjev_id` int(11) NOT NULL AUTO_INCREMENT;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `fotografije`
--
ALTER TABLE `fotografije`
  ADD CONSTRAINT `fotografije_ibfk_1` FOREIGN KEY (`lokacija_id`) REFERENCES `lokacije` (`lokacija_id`),
  ADD CONSTRAINT `fotografije_ibfk_2` FOREIGN KEY (`korisnik_id`) REFERENCES `korisnici` (`korisnik_id`);

--
-- Constraints for table `fotografije_svidjanja`
--
ALTER TABLE `fotografije_svidjanja`
  ADD CONSTRAINT `fotografije_svidjanja_ibfk_1` FOREIGN KEY (`fotografija_id`) REFERENCES `fotografije` (`fotografija_id`),
  ADD CONSTRAINT `fotografije_svidjanja_ibfk_2` FOREIGN KEY (`korisnik_id`) REFERENCES `korisnici` (`korisnik_id`);

--
-- Constraints for table `komentari`
--
ALTER TABLE `komentari`
  ADD CONSTRAINT `komentari_ibfk_1` FOREIGN KEY (`fotografija_id`) REFERENCES `fotografije` (`fotografija_id`),
  ADD CONSTRAINT `komentari_ibfk_2` FOREIGN KEY (`korisnik_id`) REFERENCES `korisnici` (`korisnik_id`);

--
-- Constraints for table `notifikacije`
--
ALTER TABLE `notifikacije`
  ADD CONSTRAINT `notifikacije_ibfk_1` FOREIGN KEY (`korisnik_id`) REFERENCES `korisnici` (`korisnik_id`);

--
-- Constraints for table `paneli`
--
ALTER TABLE `paneli`
  ADD CONSTRAINT `paneli_ibfk_1` FOREIGN KEY (`kreator_panela`) REFERENCES `korisnici` (`korisnik_id`);

--
-- Constraints for table `pozivnice_za_panel`
--
ALTER TABLE `pozivnice_za_panel`
  ADD CONSTRAINT `pozivnice_za_panel_ibfk_1` FOREIGN KEY (`korisnik_poslao_id`) REFERENCES `korisnici` (`korisnik_id`),
  ADD CONSTRAINT `pozivnice_za_panel_ibfk_2` FOREIGN KEY (`korisnik_prima_id`) REFERENCES `korisnici` (`korisnik_id`),
  ADD CONSTRAINT `pozivnice_za_panel_ibfk_3` FOREIGN KEY (`panel_id`) REFERENCES `paneli` (`panel_id`);

--
-- Constraints for table `prijateljstva`
--
ALTER TABLE `prijateljstva`
  ADD CONSTRAINT `prijateljstva_ibfk_1` FOREIGN KEY (`korisnik1_id`) REFERENCES `korisnici` (`korisnik_id`),
  ADD CONSTRAINT `prijateljstva_ibfk_2` FOREIGN KEY (`korisnik2_id`) REFERENCES `korisnici` (`korisnik_id`);

--
-- Constraints for table `ucesnici_panela`
--
ALTER TABLE `ucesnici_panela`
  ADD CONSTRAINT `ucesnici_panela_ibfk_1` FOREIGN KEY (`korisnik_id`) REFERENCES `korisnici` (`korisnik_id`),
  ADD CONSTRAINT `ucesnici_panela_ibfk_2` FOREIGN KEY (`panel_id`) REFERENCES `paneli` (`panel_id`);

--
-- Constraints for table `zahtjevi_za_pridruzivanje`
--
ALTER TABLE `zahtjevi_za_pridruzivanje`
  ADD CONSTRAINT `zahtjevi_za_pridruzivanje_ibfk_1` FOREIGN KEY (`korisnik_id`) REFERENCES `korisnici` (`korisnik_id`),
  ADD CONSTRAINT `zahtjevi_za_pridruzivanje_ibfk_2` FOREIGN KEY (`panel_id`) REFERENCES `paneli` (`panel_id`);

--
-- Constraints for table `zahtjevi_za_prijateljstvo`
--
ALTER TABLE `zahtjevi_za_prijateljstvo`
  ADD CONSTRAINT `zahtjevi_za_prijateljstvo_ibfk_1` FOREIGN KEY (`korisnik_poslao_id`) REFERENCES `korisnici` (`korisnik_id`),
  ADD CONSTRAINT `zahtjevi_za_prijateljstvo_ibfk_2` FOREIGN KEY (`korisnik_prima_id`) REFERENCES `korisnici` (`korisnik_id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
