package fr.icat.bunnyjump.bag;

import com.badlogic.ashley.core.Entity;

/**
 * Created by Romain on 10/04/2016.
 */
public final class EntityNextStateBag {

    public Entity entity;

    public int nextState;

    public EntityNextStateBag(){}

    public EntityNextStateBag(Entity entity, int nextState){
        this.entity = entity;
        this.nextState = nextState;
    }

}
