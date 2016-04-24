package fr.icat.bunnyjump.components.collision;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;
import fr.icat.bunnyjump.listeners.power.added.iPowerAddedListener;
import fr.icat.bunnyjump.listeners.power.removed.iPowerRemovedListener;

/**
 * Created by Romain on 09/04/2016.
 */
public final class PowerCollisionComponent extends AbsCollisionComponent {

    public Array<ComponentMapper> componentToRemove;

    public iPowerAddedListener powerAdded;

    public iPowerRemovedListener powerRemoved;

    public float time; // durée du pouvoir

    public PowerCollisionComponent(Entity parent, Rectangle area, float time,
                        Array<ComponentMapper> componentToRemove, iPowerAddedListener powerAdded,
                        iPowerRemovedListener powerRemoved
    ){
        super(parent, area);
        this.componentToRemove = componentToRemove;
        this.powerAdded = powerAdded;
        this.powerRemoved = powerRemoved;
        this.time = time;
    }
}
