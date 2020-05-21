# Web Avancée

Ce projet a pour but d'implémenter un jeu de carte : la belote.

Cebollado Johann & Michiels Yan

Table :


# => clef etrangère
! => clef primaire

joueur(pseudo!, mot_de_passe, age, sexe, ville, nb_victoire, nb_partie, score_moyen),

partie(partie_id!, #eq_1a, #eq_1b, point1, #eq_2a, #eq_2b, point2, durée),

manche(
  #partie_id!,
  manche_nb!,
  #couleur_atout, // <- la "couleur" de la carte
  #id_joueur_prenant,
  #atout_init,    // <- la carte posé au début comme atout 
  #atout_final?,  // <- la carte qui remplace l'atout initial; uniquement set si on remplace l'atout
  point,          // <- nombre de point rapporté (+ pour 1er équipe; - pour 2nd équipe)
)

main(#partie_id!, #manche_nb!, #pseudo!, #carte1, #carte2, #carte3, #carte4, #carte5, #carte6, #carte7, #carte8),

plis(#partie_id!, #manche_nb!, plis_nb!, #joueur_debut, #carte1, #carte2, #carte3, #carte4, note) // note => belotte ou rebelotte

carte(#valeur!, #couleur!) // 1 par carte

// Peut être supprimer et remplacer par des chaines de caractère...
couleur(couleur!)
valeur(valeur!)

Visuel :

[   Joueur   ]
[------------]
[   pseudo   ]
[ nb_victoire]
[  nb_partie  ]
[ score_moyen]
      ^
      +---------------------+
      |                     |
[   Robot  ]           [   Humain   ]
[----------]           [------------]
[programme ]           [mot_de_passe]
                       [    age     ]
                       [    sexe    ]
                       [    ville   ]



Différence entre char et varchar :

|                  CHAR                  |                     VARCHAR                                 |
| -------------------------------------- |: --------------------------------------: |
| Signifier CHARACTER					 |	Signifier VARIABLE CHARACTER
| CHAR stocke les valeurs dans           |  VARCHAR stocke les valeurs de 
| des longueurs fixes et                 |  longueur variable avec le 
| est complété avec des espaces          |  préfixe de longueur 1 octet 
| pour correspondre à la                 |  ou 2 octets et ne contient aucun 
| longueur spécifiée.	                 |  autre caractère.
| Il peut contenir un maximum 			 |	Il peut contenir un maximum
| de 255 caractères.	 			     |	de 65 535 caractères.
| Il utilise l’allocation statique		 |	Il utilise l’allocation dynamique  
| de mémoire.							 |	de mémoire.


en deux couleurs : 	noir,
					rouge 


quatre enseignes françaises : 	trèfle, 
								carreau, 
								cœur, 
								pique