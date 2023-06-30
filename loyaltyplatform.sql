-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Creato il: Giu 30, 2023 alle 11:37
-- Versione del server: 10.4.28-MariaDB
-- Versione PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `loyaltyplatform`
--

-- --------------------------------------------------------

--
-- Struttura della tabella `acquisti`
--

CREATE TABLE `acquisti` (
  `N_Fattura` smallint(6) NOT NULL,
  `Id_cliente` mediumint(9) NOT NULL,
  `Totale` mediumint(9) NOT NULL,
  `Convalidato` bit(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Struttura della tabella `clienti`
--

CREATE TABLE `clienti` (
  `Id_cliente` mediumint(10) NOT NULL,
  `Nome` varchar(20) NOT NULL,
  `Cognome` varchar(20) NOT NULL,
  `email` varchar(30) NOT NULL,
  `nTelefono` varchar(14) NOT NULL,
  `Tessera` bit(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Struttura della tabella `clienti_premi`
--

CREATE TABLE `clienti_premi` (
  `Id_cliente` mediumint(9) NOT NULL,
  `Id_premio` mediumint(9) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Struttura della tabella `coupon`
--

CREATE TABLE `coupon` (
  `Id_coupon` mediumint(9) NOT NULL,
  `Valore` mediumint(9) NOT NULL,
  `data_inizio` date NOT NULL,
  `data_fine` date NOT NULL,
  `minimo_spesa` mediumint(9) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Struttura della tabella `formulario`
--

CREATE TABLE `formulario` (
  `Id_cliente` mediumint(9) NOT NULL,
  `CF` varchar(20) NOT NULL,
  `DataDiNascita` date NOT NULL,
  `LuogoDiNascita` varchar(50) NOT NULL,
  `Residenza` varchar(100) NOT NULL,
  `Documento` varchar(20) NOT NULL,
  `CodiceDocumento` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Struttura della tabella `lifvelloutente`
--

CREATE TABLE `lifvelloutente` (
  `Id_livello` tinyint(4) NOT NULL,
  `Amministrazione` bit(1) NOT NULL,
  `PannelloCassiere` bit(1) NOT NULL,
  `Configurazione` bit(1) NOT NULL,
  `PannelloMarketing` bit(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Struttura della tabella `livelliprogramma`
--

CREATE TABLE `livelliprogramma` (
  `Id_livello` int(11) NOT NULL,
  `Nome` varchar(20) NOT NULL,
  `n_Visite` mediumint(9) NOT NULL,
  `Esperienza` int(11) NOT NULL,
  `Premio` mediumint(9) NOT NULL,
  `Coupon_mensile` mediumint(9) NOT NULL,
  `Percentuale_clienti` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Struttura della tabella `premi`
--

CREATE TABLE `premi` (
  `Id_premi` mediumint(9) NOT NULL,
  `Nome` varchar(30) NOT NULL,
  `Descrizione` varchar(100) NOT NULL,
  `Punti` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Struttura della tabella `programmalivelli`
--

CREATE TABLE `programmalivelli` (
  `Id_cliente` int(11) NOT NULL,
  `Livello` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Struttura della tabella `programmapunti`
--

CREATE TABLE `programmapunti` (
  `Id_cliente` int(11) NOT NULL,
  `Punti` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Struttura della tabella `utenti`
--

CREATE TABLE `utenti` (
  `NomeUtente` varchar(12) NOT NULL,
  `Nome` varchar(20) NOT NULL,
  `Cognome` varchar(20) NOT NULL,
  `email` varchar(30) NOT NULL,
  `Password` varchar(24) NOT NULL,
  `Livello` tinyint(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Indici per le tabelle scaricate
--

--
-- Indici per le tabelle `acquisti`
--
ALTER TABLE `acquisti`
  ADD PRIMARY KEY (`N_Fattura`);

--
-- Indici per le tabelle `clienti`
--
ALTER TABLE `clienti`
  ADD PRIMARY KEY (`Id_cliente`);

--
-- Indici per le tabelle `coupon`
--
ALTER TABLE `coupon`
  ADD PRIMARY KEY (`Id_coupon`);

--
-- Indici per le tabelle `formulario`
--
ALTER TABLE `formulario`
  ADD PRIMARY KEY (`Id_cliente`);

--
-- Indici per le tabelle `livelliprogramma`
--
ALTER TABLE `livelliprogramma`
  ADD PRIMARY KEY (`Id_livello`);

--
-- Indici per le tabelle `programmalivelli`
--
ALTER TABLE `programmalivelli`
  ADD PRIMARY KEY (`Id_cliente`);

--
-- Indici per le tabelle `programmapunti`
--
ALTER TABLE `programmapunti`
  ADD PRIMARY KEY (`Id_cliente`);

--
-- Indici per le tabelle `utenti`
--
ALTER TABLE `utenti`
  ADD PRIMARY KEY (`NomeUtente`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
