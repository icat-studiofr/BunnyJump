package fr.icat.bunnyjump.components.collision;

import com.badlogic.ashley.core.Component;
import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;

/**
 * Created by Romain on 10/04/2016.
 */
public final class MagicianCollisionComponent extends AbsCollisionComponent {

    public Array<Component> componentRemoved = new Array<Component>();

    public MagicianCollisionComponent(Entity parent, Rectangle area) {
        super(parent, area);
    }
}
