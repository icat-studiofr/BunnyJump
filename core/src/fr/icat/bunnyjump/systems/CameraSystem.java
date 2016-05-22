package fr.icat.bunnyjump.systems;

import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.EntitySystem;
import com.badlogic.ashley.core.Family;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;

import fr.icat.bunnyjump.components.BackgroundComponent;
import fr.icat.bunnyjump.components.BunnyComponent;
import fr.icat.bunnyjump.components.TransformComponent;
import fr.icat.bunnyjump.consts.Mapper;
import fr.icat.bunnyjump.data.WorldData;
import fr.icat.bunnyjump.entities.asset.BackgroundEntity;

/**
 *
 */
public final class CameraSystem extends EntitySystem {

    Camera camera;

    TransformComponent transformBackground;
    TransformComponent transformBunny;

    public CameraSystem(OrthographicCamera c) {
        this.camera = c;
    }

    @Override
    public void addedToEngine(Engine engine) {

        transformBackground = Mapper.Transform.get(
                engine.getEntitiesFor(Family.all(BackgroundComponent.class).get()).first());

        transformBunny = Mapper.Transform.get(
                engine.getEntitiesFor(Family.all(BunnyComponent.class).get()).first());
    }

    @Override
    public void update(float deltaTime) {

        camera.position.y = Math.min(
                camera.position.y, transformBunny.pos.y);

        camera.update();

        transformBackground.setPos(camera.position.x - WorldData.SIZE.W / 2,
                camera.position.y - WorldData.SIZE.H / 2);

    }
}
