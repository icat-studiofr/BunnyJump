package fr.icat.bunnyjump.components.collision;

import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.math.Rectangle;

/**
 * Created by Romain on 16/04/2016.
 */
public final class BankerCollisionComponent extends AbsCollisionComponent {

    public int gold;
    public int silver;
    public int bronze;

    public BankerCollisionComponent(Entity parent, Rectangle area) {
        super(parent, area);
    }
}
