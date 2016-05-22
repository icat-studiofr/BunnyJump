package fr.icat.bunnyjump.utils.active;

import fr.icat.bunnyjump.entities.BunnyEntity;

/**
 * Définit une classe ayant un score d'activation
 */
public class ActiveScore implements iActiveScore{

    public static final iActiveScore ActiveScoreZero = new ActiveScore();

    int score = 0;

    public ActiveScore(){}

    public ActiveScore(int score){
        this.score = score;
    }

    @Override
    public int getScore() {
        return score;
    }

    @Override
    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public boolean scoreIsReady() {
        return BunnyEntity.score >= score;
    }
}
