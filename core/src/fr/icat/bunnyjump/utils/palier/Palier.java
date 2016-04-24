package fr.icat.bunnyjump.utils.palier;

import com.badlogic.gdx.utils.Array;
import fr.icat.bunnyjump.utils.active.iActiveScoreComp;
import fr.icat.bunnyjump.utils.active.iActiveScore;

/**
 * Stocke et distribue une variation de donnée en fonction du score de la partie
 */
public final class Palier<T extends iActiveScoreComp> implements iPalier<T> {

    Array<T> actObjs;

    // --

    public Palier(){
        actObjs = new Array<T>();
    }

    public Palier(T... actObjs){
        this.actObjs = new Array<T>(actObjs);
    }

    public Palier(Array<T> actObjs){
        this.actObjs = actObjs;
    }

    // --

    public void add(T actObj){
        this.actObjs.add(actObj);
    }

    @Override
    public T get() {

        if(actObjs.size == 0){ throw new RuntimeException("Palier vide"); }

        T temp = null;

        for (T actObj :
                this.actObjs) {

            iActiveScore dataActiveScore = actObj.getActiveScore();

            if(dataActiveScore.scoreIsReady() &&
                    (temp == null ||
                            dataActiveScore.getScore() > temp.getActiveScore().getScore())
            ){
                temp = actObj;
            }
        }

        return temp;
    }
}
