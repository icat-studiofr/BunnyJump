package fr.icat.bunnyjump.utils.range;

import com.badlogic.gdx.math.Vector2;
import fr.icat.bunnyjump.utils.active.ActiveScore;
import fr.icat.bunnyjump.utils.active.iActiveScore;

/**
 * Range utilisé par un builder pack afin de définir la hauteur de la zone de spawnage
 * au dessus de la derniere cible.
 */
public final class Range implements iRange {

    private int max = 1;

    private int min = 0;

    private ActiveScore activeScore;

    // --

    public Range(){
        this.activeScore = new ActiveScore();
    }

    public Range(int score){

        this.activeScore = new ActiveScore(score);
    }

    public Range(int max, int min){
        this.max = max + min;
        this.min = min;
        this.activeScore = new ActiveScore();
    }

    public Range(int max, int min, int score){
        this.max = max + min;
        this.min = min;
        this.activeScore = new ActiveScore(score);
    }

    // --

    @Override
    public iActiveScore getActiveScore() {
        return this.activeScore;
    }

    @Override
    public int getMin() {
        return min;
    }

    @Override
    public int getMax() {
        return max;
    }

    @Override
    public void setMin(int min) {
        this.min = min;
    }

    @Override
    public void setMax(int max) {
        this.max = max;
    }

    @Override
    public void set(int min, int max) {
        setMin(min);
        setMax(max);
    }

    @Override
    public void set(Vector2 range) {
        setMin((int)range.x);
        setMax((int)range.y);
    }
}
