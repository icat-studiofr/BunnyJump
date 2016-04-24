package fr.icat.bunnyjump.systems;

import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import fr.icat.bunnyjump.components.TransformComponent;
import fr.icat.bunnyjump.components.VelocityComponent;
import fr.icat.bunnyjump.components.collision.BunnyAttackCollisionComponent;
import fr.icat.bunnyjump.components.collision.BunnyDefenseCollisionComponent;
import fr.icat.bunnyjump.consts.Mapper;

/**
 * Created by Romain on 21/03/2016.
 */
public final class BunnyAttackSystem extends AbsAttackCollisionSystem{

    VelocityComponent velocityComponent;

    public BunnyAttackSystem() {
        super(Family.all(BunnyAttackCollisionComponent.class, TransformComponent.class).get(),
                Mapper.BunnyAttack, Mapper.BunnyDefense);
    }

    @Override
    public void addedToEngine(Engine engine) {
        super.addedToEngine(engine);
        passiveEntities = engine.getEntitiesFor(Family.all(BunnyDefenseCollisionComponent.class).get());
    }

    @Override
    public boolean collision(Entity aEntity, Entity pEntity) {

        velocityComponent = Mapper.Velocity.get(aEntity);

        if(activeArea.y <= passiveArea.y && velocityComponent != null
                && velocityComponent.getVelo().y >= 0
        ){
            return super.collision(aEntity, pEntity);
        }
        return false;
    }
}
