package fr.icat.bunnyjump.systems;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import fr.icat.bunnyjump.components.GravityComponent;
import fr.icat.bunnyjump.components.VelocityComponent;
import fr.icat.bunnyjump.consts.Mapper;

/**
 *
 */
public final class GravitySystem extends IteratingSystem {

    static VelocityComponent veloComp;

    public GravitySystem() {
        super(Family.all(GravityComponent.class, VelocityComponent.class).get());
    }

    @Override
    protected void processEntity(Entity entity, float deltaTime) {

        veloComp = Mapper.Velocity.get(entity);
        veloComp.addVelo(0, GravityComponent.GRAVITY * deltaTime);
    }
}
