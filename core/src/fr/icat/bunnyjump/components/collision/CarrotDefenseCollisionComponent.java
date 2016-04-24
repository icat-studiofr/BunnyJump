package fr.icat.bunnyjump.components.collision;

import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.math.Rectangle;
import fr.icat.bunnyjump.components.LifeComponent;

/**
 * Created by Romain on 17/04/2016.
 */
public final class CarrotDefenseCollisionComponent extends AbsDefenseCollisionComponent {

    public CarrotDefenseCollisionComponent(Entity parent, LifeComponent lifeComponent, Rectangle area) {
        super(parent, lifeComponent, area);
    }
}
