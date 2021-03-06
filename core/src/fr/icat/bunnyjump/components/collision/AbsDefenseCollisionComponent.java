package fr.icat.bunnyjump.components.collision;

import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.math.Rectangle;

import fr.icat.bunnyjump.components.LifeComponent;

/**
 * Created by Romain on 21/03/2016.
 */
public abstract class AbsDefenseCollisionComponent extends AbsCollisionComponent {

    public LifeComponent lifeComponent;

    public AbsDefenseCollisionComponent(Entity parent, LifeComponent lifeComponent, Rectangle area) {
        super(parent, area);
        this.lifeComponent = lifeComponent;
    }
}
