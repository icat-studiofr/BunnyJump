package fr.icat.bunnyjump.components.collision;

import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.math.Rectangle;

/**
 * PlatformCollision Component */
public final class PlatformCollisionComponent extends AbsCollisionComponent{

    public final float BONUS_VELO_Y;

    public PlatformCollisionComponent(Entity parent, Rectangle area) {
        this(parent, area, 0);
    }

    public PlatformCollisionComponent(Entity parent, Rectangle area, float bonus_velo_y) {

        super(parent, area);
        this.BONUS_VELO_Y = bonus_velo_y;
    }
}
