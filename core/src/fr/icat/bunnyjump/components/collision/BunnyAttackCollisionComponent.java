package fr.icat.bunnyjump.components.collision;

import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.math.Rectangle;

/**
 * Created by Romain on 21/03/2016.
 */
public final class BunnyAttackCollisionComponent extends AbsAttackCollisionComponent {

    public BunnyAttackCollisionComponent(Entity parent, int degat, Rectangle area) {
        super(parent, degat, area);
    }
}
