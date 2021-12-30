-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le :  mer. 19 déc. 2018 à 13:57
-- Version du serveur :  5.7.17
-- Version de PHP :  5.6.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `growsmart`
--

-- --------------------------------------------------------

--
-- Structure de la table `agriculteur`
--

CREATE TABLE `agriculteur` (
  `login` varchar(255) NOT NULL,
  `nom` varchar(50) NOT NULL,
  `prenom` varchar(50) NOT NULL,
  `sexe` varchar(8) NOT NULL,
  `email` varchar(255) NOT NULL,
  `motdepasse` varchar(255) NOT NULL,
  `imgUser` varchar(8) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `agriculteur`
--

INSERT INTO `agriculteur` (`login`, `nom`, `prenom`, `sexe`, `email`, `motdepasse`, `imgUser`) VALUES
('SmileMore', 'Jabri', 'Hamza', 'Homme', 'jabrihamza1996@gmail.com', 'ss', '0'),
('', '', '', 'homme', '', '', '1'),
('Sh07', 'Smile', 'More', 'homme', 'jabrihamza1996@gmail.com', 'sh07', '1'),
('H008', 'Hamza', 'Jabri', 'homme', 'jabrihamza1996@gmail.com', 'h008', '1'),
('login', 'nom', 'prenom', 'sexe', 'email', 'motdepasse', ''),
('SmilemoreX', 'Smile', 'More', 'homme', 'smilemore2k17@gmail.com ', 'smilemore', '1'),
('H07', 'H1', 'H2', 'Femme', 'jabrihamza1996@gmail.com', 'hh', '1'),
('User', 'Ser', 'Te', 'Homme', 'jabrihamza1996@gmail.com', 'hh', '1'),
('SSA', 'S', 'A', 'Homme', 'Test@gmail.com', 'ssa', '1'),
('H007', 'Jabri', 'Hamza', 'Homme', 'jabrihamza1996@gmail.com', 'azerty1996', '1'),
('T017', 'Khalfi', 'Amir', 'Homme', 'jabrihamza1996@gmail.com', 'd30', '1'),
('H07m', 'Jabri', 'Hamza', 'Homme', 'jabrihamza1996@gmail.com', 'ssa', '1');

-- --------------------------------------------------------

--
-- Structure de la table `article`
--

CREATE TABLE `article` (
  `codeArticle` int(8) NOT NULL,
  `titreArticle` varchar(255) NOT NULL,
  `descriptionArticle` text NOT NULL,
  `dateArticle` date NOT NULL,
  `loginuser` varchar(255) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `article`
--

INSERT INTO `article` (`codeArticle`, `titreArticle`, `descriptionArticle`, `dateArticle`, `loginuser`) VALUES
(5555, 'Titre', 'Une fois ce constat fait, il n\'est pas pour autant question de baisser les bras. Un ensemble d\'actions peut être mis en place pour éviter que le mildiou se déclare et se propage sur les rangs de tomates. Mais attention ! Une de ces actions, mise en place seule, n\'aura qu\'un effet limité.', '2018-12-05', 'SmileMore'),
(5557, 'Probleme', 'Bonjour et Merci pour ce tuto, Je voudrais savoir s’il était possible de sauvegarder plusieurs éléments les un à la suite des autres et pas au même moments ???', '2018-12-07', 'SmileMore'),
(5559, 'Lutter contre la propagation aérienne', 'Lutter contre la propagation aérienne du mildiou\r\nLe mildiou ne se développe que sur une surface humide. Aussi, les pieds de tomates doivent être suffisamment espacés et aérés, afin de garder les feuilles le plus sèches possible et les plus éloignées les unes des autres. Si vous avez la place, 1 mètre entre chaque plant est idéal ; il est vrai que, si on cultive sous serre, l\'espace est plutôt restreint et on a tendance à vouloir planter plus serré. Quoiqu\'il en soit, ne descendez pas en dessous de 50 cm.', '2018-12-12', 'Sh07'),
(5560, 'Problem', 'nouveau probleme', '2018-01-12', 'H008'),
(5561, 'Thw', 'Gdjd', '2018-12-12', 'SmileMore'),
(5562, 'Secheresse', 'Probleme', '2018-12-12', 'SmileMore'),
(5563, 'Titre ', 'Oussema ', '2018-12-13', 'SmileMore'),
(5564, 'New problem', 'Ceci mon problÃ¨me ', '2018-12-14', 'SmileMore'),
(5565, 'My problem', 'Bonjour', '2018-12-14', 'SmileMore'),
(5566, 'New', 'Test', '2018-12-14', 'SmileMore');

-- --------------------------------------------------------

--
-- Structure de la table `commentaire`
--

CREATE TABLE `commentaire` (
  `codeCommentaire` int(4) NOT NULL,
  `descriptionCommentaire` int(11) NOT NULL,
  `dateTime` datetime NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `engrais`
--

CREATE TABLE `engrais` (
  `codeEngrais` int(4) NOT NULL,
  `libelleEngrais` varchar(255) NOT NULL,
  `descriptionEngrais` text NOT NULL,
  `dateEngrais` date NOT NULL,
  `codemaladie` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `maladie`
--

CREATE TABLE `maladie` (
  `code` int(11) NOT NULL,
  `nom` varchar(255) NOT NULL,
  `description` text NOT NULL,
  `codeplante` int(8) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `maladie`
--

INSERT INTO `maladie` (`code`, `nom`, `description`, `codeplante`) VALUES
(1, 'Mildiou', 'Virus de la maladie bronzee de la tomate.', 11),
(2, 'Charbon du ble', 'La maladie entraine des pertes de rendement et une depreciation qualitative de la recolte. Les symptomes sont visibles a partir de l epiaison', 444);

-- --------------------------------------------------------

--
-- Structure de la table `plantes`
--

CREATE TABLE `plantes` (
  `code` int(8) NOT NULL,
  `libelle` varchar(255) NOT NULL,
  `famille` varchar(100) NOT NULL,
  `description` text NOT NULL,
  `quantite` int(10) NOT NULL,
  `tempjour` int(2) NOT NULL,
  `tempnuit` int(2) NOT NULL,
  `dateplantage` date NOT NULL,
  `daterecolte` date NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `plantes`
--

INSERT INTO `plantes` (`code`, `libelle`, `famille`, `description`, `quantite`, `tempjour`, `tempnuit`, `dateplantage`, `daterecolte`) VALUES
(11, 'Tomate', 'Plante', 'legume', 26600, 25, 15, '2019-04-01', '2019-06-01'),
(444, 'Graine', 'Graine', 'Graine', 135, 25, 48, '2018-12-20', '2018-12-12'),
(452, 'Pomme de terre', 'Graine', 'Graine', 200, 25, 15, '2018-12-11', '2019-05-01');

-- --------------------------------------------------------

--
-- Structure de la table `profil`
--

CREATE TABLE `profil` (
  `codeProfil` int(8) NOT NULL,
  `codeImage` int(4) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `agriculteur`
--
ALTER TABLE `agriculteur`
  ADD PRIMARY KEY (`login`);

--
-- Index pour la table `article`
--
ALTER TABLE `article`
  ADD PRIMARY KEY (`codeArticle`),
  ADD KEY `loginuser` (`loginuser`);

--
-- Index pour la table `commentaire`
--
ALTER TABLE `commentaire`
  ADD PRIMARY KEY (`codeCommentaire`);

--
-- Index pour la table `engrais`
--
ALTER TABLE `engrais`
  ADD PRIMARY KEY (`codeEngrais`),
  ADD KEY `codemaladie` (`codemaladie`);

--
-- Index pour la table `maladie`
--
ALTER TABLE `maladie`
  ADD PRIMARY KEY (`code`),
  ADD KEY `codeplante` (`codeplante`);

--
-- Index pour la table `plantes`
--
ALTER TABLE `plantes`
  ADD PRIMARY KEY (`code`);

--
-- Index pour la table `profil`
--
ALTER TABLE `profil`
  ADD PRIMARY KEY (`codeProfil`),
  ADD KEY `codeImage` (`codeImage`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `article`
--
ALTER TABLE `article`
  MODIFY `codeArticle` int(8) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5567;COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
