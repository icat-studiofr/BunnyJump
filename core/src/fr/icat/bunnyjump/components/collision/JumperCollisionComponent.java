package fr.icat.bunnyjump.components.collision;

import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.math.Rectangle;

/**
 * Jumper Component */
public final class JumperCollisionComponent extends AbsCollisionComponent{

    public final float VELO_Y;

    public JumperCollisionComponent(Entity parent, Rectangle area, float velo_y) {
        super(parent, area);
        this.VELO_Y = velo_y;
    }
}
