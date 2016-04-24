package fr.icat.bunnyjump.systems;

import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import fr.icat.bunnyjump.components.TransformComponent;
import fr.icat.bunnyjump.components.VelocityComponent;
import fr.icat.bunnyjump.components.collision.JumperCollisionComponent;
import fr.icat.bunnyjump.components.collision.PlatformCollisionComponent;
import fr.icat.bunnyjump.consts.Mapper;

/**
 *  */
public final class PlatformCollisionSystem extends AbsCollisionSystem {

    VelocityComponent velocityComponent;
    JumperCollisionComponent jumperCollisionComponent;
    PlatformCollisionComponent platformCollisionComponent;

    public PlatformCollisionSystem() {
        super(
            Family.all(JumperCollisionComponent.class, TransformComponent.class).get(),
            Mapper.Jumper,
            Mapper.PlatformCollision);
    }

    @Override
    public void addedToEngine(Engine engine) {
        super.addedToEngine(engine);
        passiveEntities = this.getEngine().getEntitiesFor(Family.all(PlatformCollisionComponent.class).get());
    }

    @Override
    public void init() {
        jumperCollisionComponent = (JumperCollisionComponent) activeCollisionComponent;
        platformCollisionComponent = (PlatformCollisionComponent) passiveCollisionComponent;
    }

    @Override
    public boolean collision(Entity aEntity, Entity pEntity) {

        velocityComponent = Mapper.Velocity.get(aEntity);

        if(activeArea.y > passiveArea.y || velocityComponent.getVelo().y < 0){ return false; }

        velocityComponent.setVelo(0,
                -jumperCollisionComponent.VELO_Y + -platformCollisionComponent.BONUS_VELO_Y);
        return true;
    }
}
