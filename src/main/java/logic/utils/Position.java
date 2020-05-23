package logic.utils;

import java.util.Random;

/**
 * Represent la position d'un joueur autour de la table
 */
public enum Position {
    Nord,
    Est,
    Sud,
    Ouest;

    /**
     * Retourne la positon suivante dans le sens des aiguille d'une montre
     * @return la position suivante.
     */
    public Position next() {
        return Position.values()[(this.ordinal() + 1) % Position.values().length];
    }
    public Position opposite() {
        return Position.values()[(this.ordinal() + 2) % Position.values().length];
    }
    public static Position random(Random rand) {
        return Position.values()[rand.nextInt(Position.values().length)];
    }
}
