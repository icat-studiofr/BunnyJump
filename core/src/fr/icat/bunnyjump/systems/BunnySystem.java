package fr.icat.bunnyjump.systems;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.badlogic.gdx.graphics.Camera;

import fr.icat.bunnyjump.components.BunnyComponent;
import fr.icat.bunnyjump.components.TransformComponent;
import fr.icat.bunnyjump.consts.Mapper;
import fr.icat.bunnyjump.data.WorldData;
import fr.icat.bunnyjump.entities.BunnyEntity;

/**
 *
 */
public final class BunnySystem extends IteratingSystem{

    Camera camera;
    TransformComponent transformComponent;

    public BunnySystem(Camera camera) {
        super(Family.all(BunnyComponent.class).get());

        this.camera = camera;
    }

    @Override
    protected void processEntity(Entity entity, float deltaTime) {

        transformComponent = Mapper.Transform.get(entity);

        // Empéche le bunny de sortir de l'écran
        if(transformComponent.pos.x + transformComponent.size.x / 2 < 0){
            transformComponent.setPos(WorldData.SIZE.W - transformComponent.size.x / 2, transformComponent.pos.y);
        } else if(transformComponent.pos.x + transformComponent.size.x / 2 > WorldData.SIZE.W){
            transformComponent.setPos(-transformComponent.size.x / 2,transformComponent.pos.y);
        }

        if(transformComponent.pos.y > camera.position.y){ return; }

        BunnyEntity.score++;

    }
}
