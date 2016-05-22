package fr.icat.bunnyjump.systems;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import fr.icat.bunnyjump.components.AccelComponent;
import fr.icat.bunnyjump.components.TransformComponent;
import fr.icat.bunnyjump.components.VelocityComponent;
import fr.icat.bunnyjump.consts.Mapper;

/**
 * Created by Romain on 17/04/2016.
 */
public class AccelSystem extends IteratingSystem {

    VelocityComponent velocityComponent;
    AccelComponent accelComponent;
    TransformComponent transformComponent;

    public AccelSystem() {
        super(Family.all(AccelComponent.class, VelocityComponent.class).get());
    }

    @Override
    protected void processEntity(Entity entity, float deltaTime) {

        velocityComponent = Mapper.Velocity.get(entity);
        accelComponent = Mapper.Accel.get(entity);
        transformComponent = Mapper.Transform.get(entity);

        velocityComponent.setVelo(
                -Gdx.input.getAccelerometerX() * accelComponent.speed,
                velocityComponent.getVelo().y);

    }
}
