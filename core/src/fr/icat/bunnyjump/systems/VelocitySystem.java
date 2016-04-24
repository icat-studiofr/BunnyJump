package fr.icat.bunnyjump.systems;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.badlogic.gdx.math.Vector2;
import fr.icat.bunnyjump.components.TransformComponent;
import fr.icat.bunnyjump.components.VelocityComponent;
import fr.icat.bunnyjump.consts.Mapper;

/**
 *
 */
public final class VelocitySystem extends IteratingSystem {

    VelocityComponent velocityComponent;
    TransformComponent transformComponent;
    Vector2 temp = new Vector2();

    public VelocitySystem() {
        super(Family.all(VelocityComponent.class).get());
    }

    @Override
    protected void processEntity(Entity entity, float deltaTime) {

        velocityComponent = Mapper.Velocity.get(entity);
        transformComponent = Mapper.Transform.get(entity);

        temp.set(velocityComponent.getVelo());
        temp.scl(deltaTime);

        transformComponent.addVelo(temp);
        velocityComponent.checkDistances(transformComponent.pos);
    }
}
