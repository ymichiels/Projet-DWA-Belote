<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 23/05/2020
  Time: 03:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- Info Modal -->
<div class="modal fade" id="infoModal" tabindex="-1" role="dialog" aria-labelledby="infoModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="infoModalLabel">Informations sur le jeu de la belote</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                La belote est un jeu de cartes qui se joue à 4 (2 équipes de 2 joueurs) en utilisant un jeu de 32 cartes, soient les cartes 7, 8, 9, 10, Valet, Dame, Roi, As pour les 4 couleurs Coeur, Carreau, Trèfle et Pique.

                Valeurs des cartes et victoire
                Parmi les 4 couleurs, une des couleurs sera l'atout. En fonction de cela, la valeur des cartes sera dans l'ordre croissant avec le nombre de points associé à chaque carte :

                Hors atout : 7 (0 point), 8 (0 point), 9 (0 point), Valet (2 points), Dame (3 points), Roi (4 points), 10 (10 points) et As (11 points)
                Couleur d'atout : 7 (0 point), 8 (0 point), Dame (3 points), Roi (4 points), 10 (10 points), As (11 points), 9 (14 points) et Valet (20 points)
                Le total des points d'une manche est de 162 points (aux points des 32 cartes se rajoutent le « dix de der » soit 10 points de plus pour celui qui gagne le dernier pli). Le cas échéant, un bonus de 20 points est donné au joueur qui possède la Dame et le Roi d'atout (« belote » et « rebelote »).

                Une partie est gagnée quand une équipe atteint ou dépasse les 501 points. On jouera autant de manches que nécessaire pour atteindre cet objectif.

                Ordre des joueurs
                Les joueurs gardent la même position pendant toute la partie avec les équipes entrelacées. Si par exemple Saturnin et Gérard forment une équipe et Simone et Tatiana l'autre équipe, l'ordre pourra être Saturnin puis Simone puis Gérard puis Tatiana, dans l'ordre des aiguilles d'une montre. On reviendra ensuite à Saturnin et ainsi de suite.

                Distribution des cartes et choix de l'atout
                Le premier joueur est choisi aléatoirement. Il distribue les cartes en commençant par le joueur à sa gauche, dans l'ordre établi. Il donne d'abord 3 cartes à chaque joueur puis 2 cartes. Il retourne ensuite la première carte restante.

                Cette carte retournée est la proposition de couleur d'atout. Le premier joueur à parler est celui à gauche du distributeur. Il peut décider de prendre à la couleur d'atout de la carte ou passer. Dans le second cas, on demande la même chose à son voisin et ainsi de suite. Si au bout d'un tour, personne n'a pris à la couleur d'atout proposée, un deuxième tour commence dans le même ordre. Un joueur peut alors prendre en proposant une autre couleur d'atout. Si personne n'a choisi de couleur d'atout au bout des deux tours, la manche est terminée.

                Une fois qu'un joueur a choisi la couleur d'atout, il récupère la carte retournée. Le distributeur continue de distribuer les cartes dans le même ordre, en commençant par son voisin de gauche. Un joueur qui n'a pas pris reçoit 3 cartes et le joueur qui a pris en reçoit 2.

                Une fois une manche terminée, le prochain joueur à distribuer est celui à gauche de celui qui vient de distribuer.

                Déroulement d'une manche et points marqués
                Chaque joueur dispose d'une main de 8 cartes après distribution des 32 cartes du jeu. Une manche se déroule en 8 plis, chaque joueur jouant une carte à chaque pli en suivant l'ordre établi des joueurs. Pour le premier pli d'une manche, c'est le joueur à gauche de celui qui a distribué qui commence. Pour les autres plis, c'est le vainqueur du pli précédent qui commence.

                Si la première carte posée du pli n'est pas un atout, les joueurs suivants doivent jouer chacun leur tour une carte de la même couleur (dite la couleur demandée). Si un joueur n'a pas de carte de la couleur demandée, il doit couper en mettant une carte d'atout. S'il n'a pas d'atout ni la couleur demandée, il joue n'importe quelle autre carte. Un atout est forcément meilleur qu'une carte de n'importe quelle autre couleur. Il y a néanmoins une exception à l'obligation de couper si l'on n'a pas la couleur demandée : si c'est son partenaire qui a la meilleure des cartes déjà posées du pli, on peut alors se défausser en jouant n'importe quelle carte d'une autre couleur.

                Si la première carte posée du pli est un atout, tous les autres joueurs doivent jouer un atout sauf s'ils n'en ont pas (ils se défaussent alors d'une carte d'une autre couleur).

                Quand des atouts doivent être joués (un pli d'atouts ou quand on doit couper), on doit obligatoirement mettre un atout plus fort que tous les atouts du pli déjà joués. Si on a pas un tel atout, on met un atout d'une valeur quelconque si l'on en possède un, sinon on joue n'importe quelle autre carte si on n'a plus d'atout. Il n'y a pas d'obligation de poser une carte de valeur plus élevée que celles déjà sur la table pour les cartes hors atout.

                L'équipe qui gagne le pli est celle dont un des joueurs a posé l'atout le plus grand ou, si aucun atout n'a été joué, la carte de la couleur demandée de la plus grande valeur. L'équipe marque alors les points des 4 cartes de ce pli.

                Une fois les 8 plis joués, l'équipe dont le joueur au départ a choisi l'atout gagne la manche si la somme des plis qu'elle a gagnés dépasse les 81 points (en incluant éventuellement les points de la belote et de la rebelote). Elle marque alors tous les points qu'elle a gagnés. Si elle n'atteint pas le score de 81 points, c'est l'équipe adverse qui marque 162 points. Pour une manche, une seule des deux équipes marque des points (exception faite des 20 points de la belote et rebelote systématiquement gagnés par l'équipe du joueur qui les avait). Une équipe qui gagne tous les plis d'une manche marque 252 points.

                Si un joueur possède la Dame et le Roi d'atout, pour pouvoir marquer les 20 points de la belote, il faut que quand il pose la première des deux cartes, il dise « belote » et quand il pose la seconde, il dise « rebelote ».

                Fonctionnalités et interfaces
                Gestion des comptes joueur
                Chaque joueur peut se créer un compte en précisant ses informations personnelles : pseudo, mot de passe, age, sexe et ville. A l'exception du pseudo, les autres champs peuvent être modifiés.

                Déroulement d'une partie
                Chaque joueur se connecte avec son pseudo et mot de passe. La page affiche la liste des joueurs actuellement connectés avec un rafraichissement régulier.

                Un joueur lance une partie en sélectionnant les 3 autres joueurs et en formant les 2 équipes et l'ordre des joueurs. On pourra décider, pour éviter d'avoir toujours 4 joueurs humains, de sélectionner un joueur robot dont vous aurez à implémenter l'algorithme de jeu.

                Chaque joueur sélectionné reçoit une invitation et l'accepte ou la refuse (un robot ne refuse pas par principe). Une fois que 4 joueurs ont accepté de jouer, le jeu démarre.

                La partie se déroule ensuite comme précisé ci-dessus. Quand ce n'est pas le tour d'un joueur, celui-ci voit sur sa page ce qu'il se passe chez celui qui joue et quelles sont les cartes posées sur la table ou qui a gagné le pli ou la partie.

                Les combinaisons avec interaction que sont la Belote et la Rebelote sont gérées par des boutons permettant d'envoyer le bon message.

                A chaque tour, tout le monde est informé de qui a marqué combien de points et les scores de chaque équipe sont visibles.

                Statistiques
                Un ensemble d'informations devront être disponibles et affichables :

                La liste des joueurs enregistrés.
                Des informations sur sur chaque joueur : en plus des informations personnelles, on précisera le nombre de parties jouées, le nombre de victoires, le nombre moyen de victoires, le score moyen.
                Pour chaque partie, on enregistra tous les plis qui ont été joués et on pourra revoir en accéléré le déroulement d'une partie.
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Fermer</button>
            </div>
        </div>
    </div>
</div>
<!-- End of Info Modal -->
