package fr.icat.bunnyjump.systems;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import fr.icat.bunnyjump.components.CarrotAttackComponent;
import fr.icat.bunnyjump.components.TransformComponent;
import fr.icat.bunnyjump.consts.Mapper;
import fr.icat.bunnyjump.entities.CarrotEntity;

/**
 * Created by Romain on 17/04/2016.
 */
public final class CarrotAttackSystem extends IteratingSystem {

    InputSystem inputSystem;

    TransformComponent transformComponent;

    Vector3 v3;
    Vector2 v2;

    float velo_x;

    public CarrotAttackSystem(InputSystem inputSystem) {
        super(Family.all(CarrotAttackComponent.class, TransformComponent.class).get());
        this.inputSystem = inputSystem;
        this.v2 = new Vector2();
    }

    @Override
    protected void processEntity(Entity entity, float deltaTime) {

        v3 = inputSystem.getContinuePressedPos();

        if(v3 == null) return;

        transformComponent = Mapper.Transform.get(entity);

        velo_x = v3.x - transformComponent.pos.x;
        v2.set(transformComponent.pos.x, transformComponent.pos.y);
        v2.x += transformComponent.size.x / 2;

        getEngine().addEntity(new CarrotEntity(v2, velo_x));
    }
}
