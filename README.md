# Développement Web Avancée - Projet Belote

---
Tables des matières
---------------------------------------------------------------------
1. [Introduction](#Introduction)
2. [Structure du projet](#Structure-du-projet)
3. [Partie Données](#Partie-Données)
4. [Partie Web](#Partie-Web)
5. [Contributeurs](#Contributeurs)
- - -

# Introduction

Projet de deuxième semestre de Master 1 Informatique, celui-ci consiste en l'implémentation du célèbre jeu de carte : `**la belote**.  Nous avons développé l'application suivant les precepts de **l'architecture 3 tiers** du Web qui permet de modulariser  notre partie données et web, permettant : 
    - une meilleure évolutivité de l'application, 
        - un meilleur passage à l'échelle, 
        - et une maintenance plus aisée. 

Dans notre solution, nous nous basons sur différentes technologies.  
1. avec pour la partie données : 
    - `MySQL` pour la base de données, 
    - `eclypseLink` pour la persistance des données. 

2. Concernant la partie Web : 
    - nous utilisons le serveur `Tomcat9`. 

3. Pour pouvoir utiliser aux mieux ces technologies en gérant les librairies, les dépendances le versionning,  mais également la compilation et déploiement des applications Java, nous avons utilisé l'outil `Maven` qui permet d'automatiser la gestion de projets Java.  Le développement de l'application a été réalisé sur l'IDE `IntellJ`. 

Je détaille en premier la structure du projet. Puis, dans la partie donnée, figure les informations concernant nos données avec la justification des types choisie pour notre base.  Enfin, nous parlons de l'architecture de notre application Web, du fonctionnement de notre jeu de belote avec la partie logique métier et de son interface.

# Structure du projet

```
Belote --> project name
├── lib --> Directory wich contains the JPA library file
├── livrables --> Directory wich contains the first deliverable request by our teacher
├── scripts --> Directory wich contains the SQL script files for the database
├── src --> Main directory witch contains all the files
|   └── main
|       ├── java --> Directory witch contains the server and database files part
|       |   ├── dao
|       |   ├── filter
|       |   ├── logic
|       |   ├── message
|       |   ├── servlet
|       |   ├── upkeep
|       |   └── ws
|       └── ressources -->  Directory witch contains the ressources files part used by the WEB client
|           ├── css
|           ├── js
|           ├── medias
|               └── images
|           └── META-INF
└── web --> Directory witch contains all WEB client content part
    ├── common
    ├── viewq
    └── WEB-INF
```

# Partie Données

## Schéma BDD

Nous utilisons pour notre projet le système de gestion de base de données `MySQL` en version 8.0.20.  Mais pour le déploiement sur Azure, nous utilisons `MariaDB` qui est un fork de MySQL et compatible avec ses drivers.

# Partie Web

## Fonctionnement général du jeu

Pour la réalisation de notre jeux nous avons mis en place un système où :

- Un joueur possède quatre états :
  - déconnecté : le joueur est déconnecté
  - libre : le joueur est connecté et ne fait rien
  - en attente : le joueur est en attente de démarrage d'une partie
  - en jeux : le joueur est en train de jouer une partie
- le serveur détermine les cartes à jouer pour le client, lui envoi toutes les possibilités et le client n'a juste après qu'à sélectionner les cartes disponibles. 
  Cette implémentation a été choisie pour :
  - minimiser le travail du code coté client 
  - et limité la confiance attribuer au  client et ainsi limiter la possibilité de triche.

- Nous aurons donc pour réaliser cela une mise a jour dynamique au travers de WebSocket pour : 
  - gérer le déroulement d'une partie
  - mise a jour de la liste de joueur connecté

Nous proposons dans un premier temps, plusieurs pages. Dans le cas le plus extrême, on pourra faire le "changement" de page via le `JavaScript` (et donc avoir un vrai MVC).

## Interface Web

- Pour une interface épurée et moderne, nous avons utilisés les outils comme :
  -  le framework de Twitter pour la création du design (graphisme, animation et interactions avec la page dans le navigateur, etc.)
  -  jQuery qui est une bibliothèque JavaScript créée pour faciliter l'écriture de scripts côté client dans le code HTML des pages web.
  - chart.js pour la réalisation de graphique en html5.
  - DataTables pour la réalision de tableau dynamique.
- L'interface de notre jeu est composée de :
  - page de connexion (première page lancée par le serveur).
  - page d'inscription.
  -  page d'accueil du dashboard.
     - page d'édition du profil du joueur du dashboard.
  - page de création de partie du dashboard.
  - page de statistiques du joueur du dashboard.
  - page du jeu.

## Serveur

Pour notre projet, nous utilisons la version 9 de Tomcat.

## JSP

Pour la génération de code HTML, nous avons séparés les parties HTML de chaque pages pour rendre le code le plus modulaire possible.

## WebSocket

La communication entre les utilisateurs et les serveurs se fait au travers des `WebSockets`. Ces cervelets transmettent les classes des sous-package de **message** sérialisés en `Json`. Ces WebSockets sont définis dans les classes :
    - **ws.WebSocketPlayer** : un Websocket sur le port `/ws/partie` chargé d'informer les utilisateurs de la liste des autres utilisateurs connecté ainsi que d'informé les utilisateurs.
            - **ws.WebSocketUsers** : un Websocket sur le port `/ws/users` utilisé uniquement durant les parties pour transmettre l'état du tapis et la les des cartes. Les messages transmis par le servlet sont déclaré dans les packages:
    - **message.partie.serveur** contenant la liste des messages émit par le serveur en destination du client.
        - **message.partie.client** contenant la liste des messages émit par le client en destination du serveur.


Les messages dans le package **message.setup** étaient destinés à la mise en place d'un protocole d'invitation  qui a du être coupé par manque de temps et de moyens.


## Gestion de la partie

La partie est gérée par des composants logiques représentant les joueurs au travers de la classe abstraite **logic.joueur.Joueur** qui définie des méthodes utilisable pour envoyer les mises à jour de l'état de la partie au client et de  récupérer les actions du joueur. Comme les interactions des joueurs sont des actions asynchrone, la classe **Future<T>** est utilisée pour conserver un semblant de flow séquentiel.

Plus généralement, les classes applicatifs **logic.party** appelle dès après chaque modification du tapis. Chaque méthode possède 2 versions, une version retournant des **Future** dans le cas où le joueur est supposé jouer une carte et des méthodes retournant rien pour les joueurs ne pouvant pas agir de sorte de les garder informé. Cette organisation permet de gérer efficacement simplement les clients asynchrones tout en concevant un flux d'exécution en apparence synchrone.

# Contributeurs

Yan Michiels & Johann Cebollado