package fr.icat.bunnyjump.components;

import com.badlogic.ashley.core.Component;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.signals.Signal;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by Romain on 26/03/2016.
 */
public final class TransportableComponent implements Component {

    public float x;

    public float y;

    public Entity parent;

    public Signal<Entity> entityAddedSignal = new Signal<Entity>();

    public Signal<Entity> entityRemove = new Signal<Entity>();

    public TransportableComponent(Entity entity, float x, float y){
        this.x = x;
        this.y = y;
        this.parent = entity;
    }

    public TransportableComponent(Entity entity, Vector2 pos){
        this.x = pos.x;
        this.y = pos.y;
        this.parent = entity;
    }
}
