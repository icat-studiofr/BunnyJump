package fr.icat.bunnyjump.components;

import com.badlogic.ashley.core.Component;

/**
 * Created by Romain on 17/04/2016.
 */
public final class AccelComponent implements Component {

    public final float speed;

    public AccelComponent(float speed){
        this.speed = speed;
    }
}
