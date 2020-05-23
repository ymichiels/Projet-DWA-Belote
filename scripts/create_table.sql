CREATE TABLE `joueur` (
  `joueur_id` int(11) NOT NULL,
  `nb_victoire` int(11) DEFAULT NULL,
  `score_moyen` float DEFAULT NULL,
  `nb_partie` int(11) DEFAULT NULL,
  `pseudo` varchar(20) NOT NULL,
  `DTYPE` varchar(15) NOT NULL,
  PRIMARY KEY (`joueur_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `humain` (
  `joueur_id` int(11) NOT NULL,
  # hashera avec md5 pour le mot de passe
  `mot_de_passe` char(32) NOT NULL,
  `age` smallint(6) DEFAULT NULL,
  `ville` varchar(20) DEFAULT NULL,
  `sexe` char(1) DEFAULT NULL,
  PRIMARY KEY (`joueur_id`),
  FOREIGN KEY (`joueur_id`) REFERENCES `joueur`(`joueur_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `robot` (
  `joueur_id` int(11) NOT NULL,
  `programme` varchar(20) NOT NULL,
  PRIMARY KEY (`joueur_id`),
  FOREIGN KEY (`joueur_id`) REFERENCES `joueur`(`joueur_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `partie` (
  `partie_id` int(11) NOT NULL,
  `eq_1a` int(11) DEFAULT NULL,
  `eq_1b` int(11) DEFAULT NULL,
  `score_eq1` smallint(6) DEFAULT NULL,
  `eq_2a` int(11) DEFAULT NULL,
  `eq_2b` int(1) DEFAULT NULL,
  `score_eq2` smallint(6) DEFAULT NULL,
  `duree` time DEFAULT NULL,
  PRIMARY KEY (`partie_id`),
  FOREIGN KEY (`eq_1a`) REFERENCES `joueur`(`joueur_id`),
  FOREIGN KEY (`eq_1b`) REFERENCES `joueur`(`joueur_id`),
  FOREIGN KEY (`eq_2a`) REFERENCES `joueur`(`joueur_id`),
  FOREIGN KEY (`eq_2b`) REFERENCES `joueur`(`joueur_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `manche` (
  `partie_id` int(11) NOT NULL,
  `manche_nb` tinyint(4) NOT NULL,
  `joueur_prenant` int(11) DEFAULT NULL,
  `atout_initial` varchar(13) DEFAULT NULL,
  `atout_final` varchar(13) DEFAULT NULL,
  `point_manche_est_ouest` smallint(6),
  `point_manche_nort_sud` smallint(6),
  PRIMARY KEY (`partie_id`, `manche_nb`),
  FOREIGN KEY (`partie_id`) REFERENCES `partie` (`partie_id`),
  FOREIGN KEY (`joueur_prenant`) REFERENCES `joueur` (`joueur_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `main` (
  `partie_id` int(11) NOT NULL,
  `manche_nb` tinyint(4) NOT NULL,
  `joueur_id` int(11) NOT NULL,
  `carte_1` varchar(13) DEFAULT NULL,
  `carte_2` varchar(13) DEFAULT NULL,
  `carte_3` varchar(13) DEFAULT NULL,
  `carte_4` varchar(13) DEFAULT NULL,
  `carte_5` varchar(13) DEFAULT NULL,
  `carte_6` varchar(13) DEFAULT NULL,
  `carte_7` varchar(13) DEFAULT NULL,
  `carte_8` varchar(13) DEFAULT NULL,
  PRIMARY KEY (`partie_id`, `manche_nb`, `joueur_id`),
  FOREIGN KEY (`partie_id`, `manche_nb`) REFERENCES `manche` (`partie_id`, `manche_nb`),
  FOREIGN KEY (`joueur_id`) REFERENCES `joueur` (`joueur_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `plis` (
  `partie_id` int(11) NOT NULL,
  `manche_nb` tinyint(4) NOT NULL,
  `plis_nb` tinyint(4) NOT NULL,
  `joueur_debut` int(11) DEFAULT NULL,
  `carte_1` varchar(13) DEFAULT NULL,
  `carte_2` varchar(13) DEFAULT NULL,
  `carte_3` varchar(13) DEFAULT NULL,
  `carte_4` varchar(13) DEFAULT NULL,
  `note` char(1) DEFAULT ' ',
  PRIMARY KEY (`partie_id`, `manche_nb`, `plis_nb`),
  FOREIGN KEY (`partie_id`, `manche_nb`) REFERENCES `manche` (`partie_id`, `manche_nb`),
  FOREIGN KEY (`joueur_debut`) REFERENCES `joueur` (`joueur_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `SEQUENCE` (
  `SEQ_NAME` varchar(15) NOT NULL,
  `SEQ_COUNT` int DEFAULT '0',
  PRIMARY KEY (`SEQ_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;