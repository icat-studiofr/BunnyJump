package fr.icat.bunnyjump.utils.generator;

import com.badlogic.ashley.utils.ImmutableArray;
import com.badlogic.gdx.utils.Array;
import fr.icat.bunnyjump.utils.active.ActiveRandom;
import fr.icat.bunnyjump.utils.active.ActiveScore;
import fr.icat.bunnyjump.utils.active.iActiveRandom;
import fr.icat.bunnyjump.utils.active.iActiveRandomScoreComp;
import fr.icat.bunnyjump.utils.active.iActiveScore;
import fr.icat.bunnyjump.utils.grouper.iGrouper;

/**
 *
 */
public final class Generator<T extends iActiveRandomScoreComp> implements iGenerator<T> {

    Array<iGrouper<T>> groupers;

    iActiveScore activeScore;

    iActiveRandom activeRandom;

    int loop = 1;

    // --

    public Generator(){
        groupers = new Array<iGrouper<T>>();
        activeRandom = new ActiveRandom();
        activeScore = new ActiveScore();
    }

    public Generator(iGrouper<T>... groupers){
        this(1, groupers);
    }

    public Generator(int loop, iGrouper<T>... groupers){
        this(loop, new ActiveScore(), new ActiveRandom(), groupers);
    }

    public Generator(iActiveScore activeScore, iGrouper<T>... groupers){
        this(activeScore, new ActiveRandom(), groupers);
    }

    public Generator(iActiveRandom activeRandom , iGrouper<T>... groupers){
        this(new ActiveScore(), activeRandom, groupers);
    }

    public Generator(iActiveScore activeScore, iActiveRandom activeRandom , iGrouper<T>... groupers){
        this(1, activeScore, activeRandom, groupers);
    }

    public Generator(int loop, iActiveScore activeScore, iActiveRandom activeRandom,
                iGrouper<T>... groupers
    ){
        this.loop = loop;
        this.activeScore = activeScore;
        this.activeRandom = activeRandom;
        this.groupers = new Array<iGrouper<T>>(groupers);
    }

    // --

    @Override
    public ImmutableArray<iGrouper<T>> getGroupers() {
        return new ImmutableArray<iGrouper<T>>(groupers);
    }

    @Override
    public iGrouper<T> get(int index) {
        return groupers.get(index);
    }

    @Override
    public int getLoop() {
        return loop;
    }

    @Override
    public int getSize() {
        return groupers.size;
    }

    @Override
    public void setLoop(int loop) {
        this.loop = loop;
    }

    @Override
    public void add(iGrouper<T> grouper) {
        groupers.add(grouper);
    }

    @Override
    public void remove(iGrouper<T> grouper) {
        groupers.removeValue(grouper, true);
    }

    @Override
    public iActiveRandom getActiveRandom() {
        return activeRandom;
    }

    @Override
    public iActiveScore getActiveScore() {
        return activeScore;
    }
}
