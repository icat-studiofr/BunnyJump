package fr.icat.bunnyjump.utils.grouper;

import com.badlogic.ashley.utils.ImmutableArray;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.Array;
import fr.icat.bunnyjump.utils.active.iActiveRandomScoreComp;

/**
 * Groupe un ensemble d'entité dont une seul peut être selectionnée à la fois.
 */
public final class Grouper<T extends iActiveRandomScoreComp> implements iGrouper<T>{

    Array<T> readyList = new Array<T>();

    Array<T> waitingList = new Array<T>();

    T defaultObj;

    // --

    public Grouper(T obj, boolean isDefault){
        if(obj == null) return;
        if(isDefault) {
            defaultObj = obj;
        }
        sortedAllObj(obj);
    }
    
    public Grouper(T defaultObj, T... objs){
        this.defaultObj = defaultObj;
        sortedAllObj(objs);
    }

    public Grouper(Array<T> readyList, Array<T> waitingList){
        this.readyList = readyList;
        this.waitingList = waitingList;
    }

    public Grouper(T defaultObj, Array<T> readyList, Array<T> waitingList){
        this.defaultObj = defaultObj;
        this.readyList = readyList;
        this.waitingList = waitingList;
    }

    // --

    @Override
    public T getDefault() {
        return defaultObj;
    }

    @Override
    public ImmutableArray<T> getReadyList() {
        return new ImmutableArray<T>(this.readyList);
    }

    @Override
    public ImmutableArray<T> getWaitingList() {
        return new ImmutableArray<T>(this.waitingList);
    }

    @Override
    public void add(T obj) {
        sortedObj(obj);
    }

    @Override
    public void addAll(T... objs) {
        sortedAllObj(objs);
    }

    public T exec(){
        refresh();

        if(readyList.size == 0){ return defaultObj; }

        T select = readyList.get(MathUtils.random(0, readyList.size - 1));
        if(select.getActiveRandom().isSuccess()){
            return select;
        } else {
            return defaultObj;
        }
    }

    private void refresh(){
        T actual;
        for (int i = waitingList.size - 1; i >= 0 ; i--) {
            actual = waitingList.get(i);
            if(actual.getActiveScore().scoreIsReady()){
                readyList.add(actual);
                waitingList.removeIndex(i);
            }
        }
    }

    private void sortedAllObj(T... objs){
        for (T obj :
                objs) {
            sortedObj(obj);
        }
    }

    private void sortedObj(T obj){
        if(!obj.getActiveScore().scoreIsReady()){
            waitingList.add(obj);
        } else {
            readyList.add(obj);
        }
    }
}
