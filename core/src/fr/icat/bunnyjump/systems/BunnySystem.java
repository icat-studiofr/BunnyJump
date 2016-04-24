package fr.icat.bunnyjump.systems;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import fr.icat.bunnyjump.components.BunnyComponent;
import fr.icat.bunnyjump.components.TransformComponent;
import fr.icat.bunnyjump.consts.Mapper;
import fr.icat.bunnyjump.data.WorldData;

/**
 *
 */
public final class BunnySystem extends IteratingSystem{

    TransformComponent transformComponent;

    public BunnySystem() {
        super(Family.all(BunnyComponent.class).get());
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
    }
}
