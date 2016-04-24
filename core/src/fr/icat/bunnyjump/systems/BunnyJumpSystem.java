package fr.icat.bunnyjump.systems;

import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.badlogic.ashley.utils.ImmutableArray;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;
import fr.icat.bunnyjump.components.BunnyComponent;
import fr.icat.bunnyjump.components.CameraComponent;
import fr.icat.bunnyjump.components.TransformComponent;
import fr.icat.bunnyjump.components.TransportableComponent;
import fr.icat.bunnyjump.components.VelocityComponent;
import fr.icat.bunnyjump.consts.Mapper;

/**
 * Created by Romain on 11/04/2016.
 */
public final class BunnyJumpSystem extends IteratingSystem {

    SpawnerSystem spawnerSystem;

    ImmutableArray<Entity> gameObjects;

    BunnyComponent bunnyComponent;
    TransformComponent bunnyTransform;
    TransformComponent gameObjTransform;
    VelocityComponent bunnyVelo;
    VelocityComponent gameObjVelo;

    OrthographicCamera camera;

    Vector2 temp = new Vector2();

    boolean enter = false;

    public BunnyJumpSystem(OrthographicCamera camera, SpawnerSystem spawnerSystem) {
        super(Family.all(BunnyComponent.class, VelocityComponent.class).get());
        this.spawnerSystem = spawnerSystem;
        this.camera = camera;
    }

    @Override
    public void addedToEngine(Engine engine) {
        super.addedToEngine(engine);
        gameObjects = getEngine().getEntitiesFor(
                Family.all(TransformComponent.class)
                        .exclude(BunnyComponent.class, CameraComponent.class, TransportableComponent.class)
                        .get());
    }

    @Override
    protected void processEntity(Entity entity, float deltaTime) {

        bunnyTransform = Mapper.Transform.get(entity);

        if(bunnyTransform.pos.y > camera.position.y){ return; }

        bunnyComponent = Mapper.Bunny.get(entity);
        bunnyVelo = Mapper.Velocity.get(entity);

        bunnyComponent.score++;

        bunnyTransform.addVelo(temp.set(0, camera.position.y - bunnyTransform.pos.y));

        temp.set(0, -bunnyVelo.getVelo().y).scl(deltaTime);

        for (Entity e :
                gameObjects) {
            gameObjTransform = Mapper.Transform.get(e);
            gameObjVelo = Mapper.Velocity.get(e);

            gameObjTransform.addVelo(temp);

            if(gameObjVelo != null && gameObjVelo.getDistanceY() != null){
                gameObjVelo.getDistanceY().update(temp.y);
            }
        }

        spawnerSystem.updateVeloY(temp.y);
    }
}
