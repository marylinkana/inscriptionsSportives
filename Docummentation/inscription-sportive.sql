-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  ven. 08 fév. 2019 à 11:14
-- Version du serveur :  5.7.19
-- Version de PHP :  5.6.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `inscription-sportive`
--

-- --------------------------------------------------------

--
-- Structure de la table `candidat`
--

DROP TABLE IF EXISTS `candidat`;
CREATE TABLE IF NOT EXISTS `candidat` (
  `numcandidat` int(32) NOT NULL,
  `numcompetition` int(32) DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`numcandidat`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `competition`
--

DROP TABLE IF EXISTS `competition`;
CREATE TABLE IF NOT EXISTS `competition` (
  `numcompetition` int(32) NOT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `dateCloture` date DEFAULT NULL,
  `enEquipe` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`numcompetition`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `equipe`
--

DROP TABLE IF EXISTS `equipe`;
CREATE TABLE IF NOT EXISTS `equipe` (
  `numequipe` int(32) NOT NULL,
  `nom` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`numequipe`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `integre`
--

DROP TABLE IF EXISTS `integre`;
CREATE TABLE IF NOT EXISTS `integre` (
  `numequipe` int(32) NOT NULL DEFAULT '0',
  `numpersonne` int(32) NOT NULL DEFAULT '0',
  PRIMARY KEY (`numequipe`,`numpersonne`),
  KEY `numpersonne` (`numpersonne`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `participe`
--

DROP TABLE IF EXISTS `participe`;
CREATE TABLE IF NOT EXISTS `participe` (
  `numcandidat` int(32) NOT NULL DEFAULT '0',
  `numcompetition` int(32) NOT NULL DEFAULT '0',
  PRIMARY KEY (`numcandidat`,`numcompetition`),
  KEY `numcompetition` (`numcompetition`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `personne`
--

DROP TABLE IF EXISTS `personne`;
CREATE TABLE IF NOT EXISTS `personne` (
  `numpersonne` int(32) NOT NULL,
  `prenom` varchar(255) DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `mail` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`numpersonne`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `equipe`
--
ALTER TABLE `equipe`
  ADD CONSTRAINT `equipe_ibfk_1` FOREIGN KEY (`numequipe`) REFERENCES `candidat` (`numcandidat`);

--
-- Contraintes pour la table `integre`
--
ALTER TABLE `integre`
  ADD CONSTRAINT `integre_ibfk_1` FOREIGN KEY (`numequipe`) REFERENCES `equipe` (`numequipe`),
  ADD CONSTRAINT `integre_ibfk_2` FOREIGN KEY (`numpersonne`) REFERENCES `personne` (`numpersonne`);

--
-- Contraintes pour la table `participe`
--
ALTER TABLE `participe`
  ADD CONSTRAINT `participe_ibfk_1` FOREIGN KEY (`numcandidat`) REFERENCES `candidat` (`numcandidat`),
  ADD CONSTRAINT `participe_ibfk_2` FOREIGN KEY (`numcompetition`) REFERENCES `competition` (`numcompetition`);

--
-- Contraintes pour la table `personne`
--
ALTER TABLE `personne`
  ADD CONSTRAINT `personne_ibfk_1` FOREIGN KEY (`numpersonne`) REFERENCES `candidat` (`numcandidat`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
