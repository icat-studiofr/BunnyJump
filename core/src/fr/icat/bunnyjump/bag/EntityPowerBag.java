package fr.icat.bunnyjump.bag;

import com.badlogic.ashley.core.Component;
import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.utils.Array;

/**
 * Created by Romain on 10/04/2016.
 */
public final class EntityPowerBag {

    public Entity entity;

    public Array<Component> componentRemoved;

    public EntityPowerBag(Entity entity, Array<Component> componentRemoved){
        this.entity = entity;
        this.componentRemoved = componentRemoved;
    }

}
