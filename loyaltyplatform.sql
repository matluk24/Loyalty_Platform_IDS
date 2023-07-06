-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
<<<<<<< Upstream, based on branch 'main' of https://github.com/matluk24/Loyalty_Platform_IDS.git
-- Creato il: Lug 06, 2023 alle 17:21
=======
-- Creato il: Lug 06, 2023 alle 15:00
>>>>>>> 1da0bb0 agguirnamento DBMS
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

--
-- Dump dei dati per la tabella `clienti`
--

INSERT INTO `clienti` (`Id_cliente`, `Nome`, `Cognome`, `email`, `nTelefono`, `Tessera`) VALUES
(1, 'mario', 'rossi', 'mario.rossi@g.com', '2975689008', b'1');

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

--
-- Dump dei dati per la tabella `formulario`
--

INSERT INTO `formulario` (`Id_cliente`, `CF`, `DataDiNascita`, `LuogoDiNascita`, `Residenza`, `Documento`, `CodiceDocumento`) VALUES
(1, 'dgsdgdsgsdg', '1999-01-01', 'vsvdsvsd', 'gsdgsd', 'sdgdsg', '03458');

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
  `Livello` int(11) NOT NULL,
<<<<<<< Upstream, based on branch 'main' of https://github.com/matluk24/Loyalty_Platform_IDS.git
  `Esperienza` int(11) NOT NULL,
  `N_visite` int(11) NOT NULL
=======
  `esperienza` int(11) NOT NULL
>>>>>>> 1da0bb0 agguirnamento DBMS
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Struttura della tabella `programmapunti`
--

CREATE TABLE `programmapunti` (
  `Id_cliente` int(11) NOT NULL,
  `Punti` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dump dei dati per la tabella `programmapunti`
--

INSERT INTO `programmapunti` (`Id_cliente`, `Punti`) VALUES
(1, 0);

-- --------------------------------------------------------

--
-- Struttura della tabella `programmi`
--

CREATE TABLE `programmi` (
  `Id_programma` int(11) NOT NULL,
  `Descrizione` int(100) NOT NULL,
  `Status` bit(1) NOT NULL DEFAULT b'0',
  `Nome` varchar(30) NOT NULL,
  `Tools` varchar(128) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Struttura della tabella `programmi`
--

CREATE TABLE `programmi` (
  `Id_programma` int(11) NOT NULL,
  `Descrizione` int(100) NOT NULL,
  `Status` bit(1) NOT NULL DEFAULT b'0',
  `Nome` varchar(30) NOT NULL,
  `Tools` varchar(128) NOT NULL
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
-- Dump dei dati per la tabella `utenti`
--

INSERT INTO `utenti` (`NomeUtente`, `Nome`, `Cognome`, `email`, `Password`, `Livello`) VALUES
('fb', 'francesco', 'barontini', 'f.b@g.com', '123456', 1),
('mariorossi', 'mario', 'rossi', 'mariorossi@g.com', 'mariorossi1', 0),
('ml', 'mattia', 'luciani', 'm.l@g.com', '123456', 1);

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
-- Indici per le tabelle `premi`
--
ALTER TABLE `premi`
  ADD PRIMARY KEY (`Id_premi`);

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
-- Indici per le tabelle `programmi`
--
ALTER TABLE `programmi`
  ADD PRIMARY KEY (`Id_programma`);

--
-- Indici per le tabelle `utenti`
--
ALTER TABLE `utenti`
  ADD PRIMARY KEY (`NomeUtente`);

--
-- AUTO_INCREMENT per le tabelle scaricate
--

--
<<<<<<< Upstream, based on branch 'main' of https://github.com/matluk24/Loyalty_Platform_IDS.git
-- AUTO_INCREMENT per la tabella `acquisti`
--
ALTER TABLE `acquisti`
  MODIFY `N_Fattura` smallint(6) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT per la tabella `clienti`
--
ALTER TABLE `clienti`
  MODIFY `Id_cliente` mediumint(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT per la tabella `coupon`
--
ALTER TABLE `coupon`
  MODIFY `Id_coupon` mediumint(9) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT per la tabella `livelliprogramma`
--
ALTER TABLE `livelliprogramma`
  MODIFY `Id_livello` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT per la tabella `premi`
--
ALTER TABLE `premi`
  MODIFY `Id_premi` mediumint(9) NOT NULL AUTO_INCREMENT;
=======
-- AUTO_INCREMENT per la tabella `clienti`
--
ALTER TABLE `clienti`
  MODIFY `Id_cliente` mediumint(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
>>>>>>> 1da0bb0 agguirnamento DBMS

--
-- AUTO_INCREMENT per la tabella `programmi`
--
ALTER TABLE `programmi`
  MODIFY `Id_programma` int(11) NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
