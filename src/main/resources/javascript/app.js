const couleur = ["piques", "coeur", "carreau", "trèfle"];
const valeur = ["A", "7", "8", "9", "10", "J", "Q", "K"];


function distribute() {
    var player1 = new joueur();
    var player2 = new joueur();
    var player3 = new joueur();
    var player4 = new joueur();
}

function getDeck() {
    var deck = new Array();

    for(var i = 0; i < couleur.length; i++)
    {
        for(var j = 0; x < valeur.length; j++)
        {
            var card = {Value: valeur[x]};
            deck.push(card);
        }
    }
    return deck;
}

