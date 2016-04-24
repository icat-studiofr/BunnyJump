package fr.icat.bunnyjump.components.collision;

import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.math.Rectangle;

/**
 * Created by Romain on 17/04/2016.
 */
public final class CarrotAttackCollisionComponent extends AbsAttackCollisionComponent {

    public CarrotAttackCollisionComponent(Entity parent, int degat, Rectangle area) {
        super(parent, degat, area);
    }
}
