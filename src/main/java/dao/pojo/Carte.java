package dao.pojo;

/**
 * @author jcebollado
 */
public enum Carte {
    PIQUE_7(Couleur.PIQUE, Valeur.N7),
    PIQUE_8(Couleur.PIQUE, Valeur.N8),
    PIQUE_9(Couleur.PIQUE, Valeur.N9),
    PIQUE_10(Couleur.PIQUE, Valeur.N10),
    PIQUE_VALET(Couleur.PIQUE, Valeur.VALET),
    PIQUE_DAME(Couleur.PIQUE, Valeur.DAME),
    PIQUE_ROI(Couleur.PIQUE, Valeur.ROI),
    PIQUE_AS(Couleur.PIQUE, Valeur.AS),
    TREFLE_7(Couleur.TREFLE, Valeur.N7),
    TREFLE_8(Couleur.TREFLE, Valeur.N8),
    TREFLE_9(Couleur.TREFLE, Valeur.N9),
    TREFLE_10(Couleur.TREFLE, Valeur.N10),
    TREFLE_VALET(Couleur.TREFLE, Valeur.VALET),
    TREFLE_DAME(Couleur.TREFLE, Valeur.DAME),
    TREFLE_ROI(Couleur.TREFLE, Valeur.ROI),
    TREFLE_AS(Couleur.TREFLE, Valeur.AS),
    COEUR_7(Couleur.COEUR, Valeur.N7),
    COEUR_8(Couleur.COEUR, Valeur.N8),
    COEUR_9(Couleur.COEUR, Valeur.N9),
    COEUR_10(Couleur.COEUR, Valeur.N10),
    COEUR_VALET(Couleur.COEUR, Valeur.VALET),
    COEUR_DAME(Couleur.COEUR, Valeur.DAME),
    COEUR_ROI(Couleur.COEUR, Valeur.ROI),
    COEUR_AS(Couleur.COEUR, Valeur.AS),
    CARREAU_7(Couleur.CARREAU, Valeur.N7),
    CARREAU_8(Couleur.CARREAU, Valeur.N8),
    CARREAU_9(Couleur.CARREAU, Valeur.N9),
    CARREAU_10(Couleur.CARREAU, Valeur.N10),
    CARREAU_VALET(Couleur.CARREAU, Valeur.VALET),
    CARREAU_DAME(Couleur.CARREAU, Valeur.DAME),
    CARREAU_ROI(Couleur.CARREAU, Valeur.ROI),
    CARREAU_AS(Couleur.CARREAU, Valeur.AS);

    private final Couleur couleur;
    private final Valeur valeur;

    Carte(Couleur couleur, Valeur valeur) {
        this.couleur = couleur;
        this.valeur = valeur;
    }

    public Couleur getCouleur() {
        return this.couleur;
    }

    public Valeur getValeur() {
        return this.valeur;
    }

    public int getPoint(Couleur atout) {
        return this.valeur.getValeur(this.couleur.equals(atout));
    }

    public Category obtenirCategory(Couleur atout, Couleur demander) {
        if(couleur == atout) {
            return Category.ATOUT;
        } else if(couleur == demander) {
            return Category.DEMANDER;
        } else {
            return Category.AUTRE;
        }
    }

    public static Carte getCarte(Couleur couleur, Valeur valeur) {
        for(Carte carte : values()) {
            if(carte.valeur == valeur && carte.couleur == couleur) {
                return carte;
            }
        }
        return null;
    }

    public enum Couleur {
        PIQUE,
        TREFLE,
        CARREAU,
        COEUR;
    }

    public enum Valeur {
        N7(0, 0),
        N8(0, 0),
        N9(14, 0),
        N10(10, 10),
        VALET(20, 2),
        DAME(3, 3),
        ROI(4, 4),
        AS(11, 11);

        private int valeurAtout;
        private int valeurNormale;
        Valeur(int valeurAtout, int valeurNormale) {
            this.valeurAtout = valeurAtout;
            this.valeurNormale = valeurNormale;
        }

        public int getValeur(boolean estAtout){
            return estAtout ? this.valeurAtout : this.valeurNormale;
        }
    }

    public enum Category {
        ATOUT(2),
        DEMANDER(1),
        AUTRE(0);

        private int category;
        Category(int category) {
            this.category = category;
        }

        public boolean estMeilleur(Category autre) {
            return this.category > autre.category;
        }
    }
}
