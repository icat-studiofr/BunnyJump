package fr.icat.bunnyjump.utils;

import fr.icat.bunnyjump.assets.MathAsset;
import fr.icat.bunnyjump.utils.active.ActiveScore;
import fr.icat.bunnyjump.utils.active.iActiveScore;
import fr.icat.bunnyjump.utils.active.iActiveScoreComp;

/**
 * Created by Romain on 21/03/2016.
 */
public class Random implements iActiveScoreComp {

    int random = 50;

    iActiveScore activeScore;

    public Random(int score){
        this.activeScore = new ActiveScore(score);
    }

    public Random(int random, int score){
        this.random = random;
        this.activeScore = new ActiveScore(score);
    }

    public boolean check(){
        return MathAsset.percentRandom(random);
    }

    @Override
    public iActiveScore getActiveScore() {
        return activeScore;
    }
}
