package fr.icat.bunnyjump.components;

import com.badlogic.ashley.core.Component;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.signals.Signal;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.ObjectMap;
import fr.icat.bunnyjump.bag.EntityDuoBag;
import fr.icat.bunnyjump.consts.Mapper;

/**
 * UpdateTransportable Component
 */
public final class TransporterComponent implements Component {

    public EntityDuoBag bag = new EntityDuoBag();

    public Signal<EntityDuoBag> entityAddedSignal = new Signal<EntityDuoBag>();

    public Signal<EntityDuoBag> entityRemovedSignal = new Signal<EntityDuoBag>();

    public final ObjectMap<Integer, TransportableComponent> transportables;

    Vector2 vTemp = new Vector2();

    // --

    public TransporterComponent(Entity parent){
        this.transportables = new ObjectMap<Integer, TransportableComponent>();
        this.bag.e1 = parent;
    }

    public TransporterComponent(Entity parent, ObjectMap<Integer, TransportableComponent> transportables) {
        this.transportables = transportables;
        this.bag.e1 = parent;
    }

    // --

    public void add(int key, TransportableComponent transportable){

        this.transportables.put(key, transportable);

        final TransformComponent transEnfant = Mapper.Transform.get(transportable.parent);
        final TransformComponent transParent = Mapper.Transform.get(this.bag.e1);
        final Vector2 temp = vTemp.set(
                transportable.x + transParent.pos.x, transportable.y + transParent.pos.y);

        transEnfant.setPos(temp);

        bag.e2 = transportable.parent;
        this.entityAddedSignal.dispatch(bag);
        transportable.entityAddedSignal.dispatch(transportable.parent);
    }

    public void remove(int key){
        if(!this.transportables.containsKey(key)){ return; }

        final TransportableComponent t = this.transportables.get(key);

        bag.e2 = t.parent;
        this.entityRemovedSignal.dispatch(bag);
        t.entityAddedSignal.dispatch(t.parent);
        this.transportables.remove(key);
    }
}
