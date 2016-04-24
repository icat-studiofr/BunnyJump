package fr.icat.bunnyjump.systems;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import fr.icat.bunnyjump.components.CameraComponent;
import fr.icat.bunnyjump.components.TransformComponent;
import fr.icat.bunnyjump.consts.Mapper;

/**
 *
 */
public final class CameraSystem extends IteratingSystem {

    CameraComponent cameraComponent;
    TransformComponent transformTarget;

    public CameraSystem() {
        super(Family.all(CameraComponent.class).get());
    }

    @Override
    protected void processEntity(Entity entity, float deltaTime) {


        cameraComponent = Mapper.Camera.get(entity);
        transformTarget = Mapper.Transform.get(cameraComponent.target);

        cameraComponent.camera.position.y = Math.min(
                cameraComponent.camera.position.y, transformTarget.pos.y);
    }
}
