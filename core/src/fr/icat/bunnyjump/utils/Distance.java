package fr.icat.bunnyjump.utils;

import com.badlogic.ashley.core.Component;
import com.badlogic.ashley.signals.Listener;
import com.badlogic.ashley.signals.Signal;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;

/**
 * Indique que l'entité se déplace d'une certaine distance en faisant des allés retour
 */
public final class Distance {

    public float start;

    public float end;

    public Distance(float start, float end){
        this.start = start;
        this.end = end;
    }

    public boolean check(float pos){
        boolean res = true;
        if((pos > start && pos < end) || (pos < start && pos > end)){
            res = false;
        } else {
            res = true;
        }
        return res;
    }

    public void update(float velo){
        this.start += velo;
        this.end += velo;
    }
}
