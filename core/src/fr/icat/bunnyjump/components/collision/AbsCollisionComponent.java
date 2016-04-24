package fr.icat.bunnyjump.components.collision;

import com.badlogic.ashley.core.Component;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.signals.Signal;
import com.badlogic.gdx.math.Rectangle;
import fr.icat.bunnyjump.bag.EntityDuoBag;

/**
 * AbsCollision */
public abstract class AbsCollisionComponent implements Component{

    public final Rectangle area;

    public EntityDuoBag bag = new EntityDuoBag();

    public Signal<EntityDuoBag> collisionSignal = new Signal<EntityDuoBag>();

    // --

    public AbsCollisionComponent(Entity parent, Rectangle area){
        this.area = area;
        this.bag.e1 = parent;
    }
}
