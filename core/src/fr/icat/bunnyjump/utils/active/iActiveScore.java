package fr.icat.bunnyjump.utils.active;

/**
 * Définit un score à atteindre
 */
public interface iActiveScore {

    int getScore();

    void setScore(int score);

    boolean scoreIsReady();
}
