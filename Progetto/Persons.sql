-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Creato il: Dic 11, 2018 alle 09:19
-- Versione del server: 10.1.36-MariaDB
-- Versione PHP: 7.2.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `test`
--

-- --------------------------------------------------------

--
-- Struttura della tabella `Persons`
--

CREATE TABLE `Persons` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `setNotified` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `Persons`
--

INSERT INTO `Persons` (`id`, `name`, `setNotified`) VALUES
(1, 'HMK', 1),
(2, 'Another Name', 1),
(3, 'HMK', 1),
(4, 'Another Name', 1),
(213, 'sadasd', 1),
(222, 'dsds', 1),
(2213, 'sadasd', 1),
(123123, 'dasdsadas', 1),
(2222222, '23asd', 1),
(232323232, '12', 1);

--
-- Indici per le tabelle scaricate
--

--
-- Indici per le tabelle `Persons`
--
ALTER TABLE `Persons`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT per le tabelle scaricate
--

--
-- AUTO_INCREMENT per la tabella `Persons`
--
ALTER TABLE `Persons`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=232323233;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
