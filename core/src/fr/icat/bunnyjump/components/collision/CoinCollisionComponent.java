package fr.icat.bunnyjump.components.collision;

import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.math.Rectangle;

/**
 * Created by Romain on 16/04/2016.
 */
public final class CoinCollisionComponent extends AbsCollisionComponent {

    public CoinCollisionComponent(Entity parent, Rectangle area) {
        super(parent, area);
    }
}
