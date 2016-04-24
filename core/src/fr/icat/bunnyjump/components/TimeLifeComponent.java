package fr.icat.bunnyjump.components;

import com.badlogic.ashley.core.Component;

/**
 * Created by Romain on 24/03/2016.
 */
public final class TimeLifeComponent implements Component{

    public float time = 1;
    public float temp;

    public TimeLifeComponent(float time){
        this.time = time;
    }

    public boolean addTime(float time){
        temp += time;
        return temp >= this.time;
    }
}
