package DAO.pojo;

/**
 *
 * @author jcebollado
 */
public enum Carte {
    PIQUE_7      (Couleur.PIQUE,   Valeur.N7),
    PIQUE_8      (Couleur.PIQUE,   Valeur.N8),
    PIQUE_9      (Couleur.PIQUE,   Valeur.N9),
    PIQUE_10     (Couleur.PIQUE,   Valeur.N10),
    PIQUE_VALET  (Couleur.PIQUE,   Valeur.VALET),
    PIQUE_DAME   (Couleur.PIQUE,   Valeur.DAME),
    PIQUE_ROI    (Couleur.PIQUE,   Valeur.ROI),
    PIQUE_AS     (Couleur.PIQUE,   Valeur.AS),
    TREFLE_7     (Couleur.TREFLE,  Valeur.N7),
    TREFLE_8     (Couleur.TREFLE,  Valeur.N8),
    TREFLE_9     (Couleur.TREFLE,  Valeur.N9),
    TREFLE_10    (Couleur.TREFLE,  Valeur.N10),
    TREFLE_VALET (Couleur.TREFLE,  Valeur.VALET),
    TREFLE_DAME  (Couleur.TREFLE,  Valeur.DAME),
    TREFLE_ROI   (Couleur.TREFLE,  Valeur.ROI),
    TREFLE_AS    (Couleur.TREFLE,  Valeur.AS),
    COEUR_7      (Couleur.COEUR,   Valeur.N7),
    COEUR_8      (Couleur.COEUR,   Valeur.N8),
    COEUR_9      (Couleur.COEUR,   Valeur.N9),
    COEUR_10     (Couleur.COEUR,   Valeur.N10),
    COEUR_VALET  (Couleur.COEUR,   Valeur.VALET),
    COEUR_DAME   (Couleur.COEUR,   Valeur.DAME),
    COEUR_ROI    (Couleur.COEUR,   Valeur.ROI),
    COEUR_AS     (Couleur.COEUR,   Valeur.AS),
    CARREAU_7    (Couleur.CARREAU, Valeur.N7),
    CARREAU_8    (Couleur.CARREAU, Valeur.N8),
    CARREAU_9    (Couleur.CARREAU, Valeur.N9),
    CARREAU_10   (Couleur.CARREAU, Valeur.N10),
    CARREAU_VALET(Couleur.CARREAU, Valeur.VALET),
    CARREAU_DAME (Couleur.CARREAU, Valeur.DAME),
    CARREAU_ROI  (Couleur.CARREAU, Valeur.ROI),
    CARREAU_AS   (Couleur.CARREAU, Valeur.AS);
    
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
    
    public enum Couleur {
        PIQUE,
        TREFLE,
        CARREAU,
        COEUR;
    }
    
    public enum Valeur {
        N7,
        N8,
        N9,
        N10,
        VALET,
        DAME,
        ROI,
        AS;
    }
}
