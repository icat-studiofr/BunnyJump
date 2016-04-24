package fr.icat.bunnyjump.utils.tsco;

/**
 * Created by Romain on 10/04/2016.
 */
public final class TSCOTimerInfo {

    public float time;

    public int nextState;

    public TSCOTimerInfo(float time, int nextState) {
        this.time = time;
        this.nextState = nextState;
    }
}
