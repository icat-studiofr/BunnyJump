package fr.icat.bunnyjump.utils;

import fr.icat.bunnyjump.utils.active.ActiveScore;
import fr.icat.bunnyjump.utils.active.iActiveScore;
import fr.icat.bunnyjump.utils.active.iActiveScoreComp;

/**
 *
 */
public final class Speed implements iActiveScoreComp{

    /**
     * Distance par sec
     */
    public float speed;

    private ActiveScore activeScore;

    public Speed(float speed, int score){
        this.speed = speed;
        this.activeScore = new ActiveScore(score);
    }

    @Override
    public iActiveScore getActiveScore() {
        return activeScore;
    }
}
