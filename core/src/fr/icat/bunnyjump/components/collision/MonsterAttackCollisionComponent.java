package fr.icat.bunnyjump.components.collision;

import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.math.Rectangle;

/**
 * Created by Romain on 24/03/2016.
 */
public final class MonsterAttackCollisionComponent extends AbsAttackCollisionComponent {

    public MonsterAttackCollisionComponent(Entity parent, int degat, Rectangle area) {
        super(parent, degat, area);
    }
}
