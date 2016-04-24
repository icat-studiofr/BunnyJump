package fr.icat.bunnyjump.components.collision;

import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.math.Rectangle;

/**
 * Created by Romain on 21/03/2016.
 */
public abstract class AbsAttackCollisionComponent extends AbsCollisionComponent {

    public int degat;

    public AbsAttackCollisionComponent(Entity parent, int degat, Rectangle area) {
        super(parent, area);
        this.degat = degat;
    }
}
