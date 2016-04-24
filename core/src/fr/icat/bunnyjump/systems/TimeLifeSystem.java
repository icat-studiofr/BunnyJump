package fr.icat.bunnyjump.systems;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import fr.icat.bunnyjump.components.TimeLifeComponent;
import fr.icat.bunnyjump.consts.Mapper;

/**
 * Created by Romain on 24/03/2016.
 */
public class TimeLifeSystem extends IteratingSystem {

    TimeLifeComponent timeLifeComponent;

    public TimeLifeSystem() {
        super(Family.all(TimeLifeComponent.class).get());
    }

    @Override
    protected void processEntity(Entity entity, float deltaTime) {

        timeLifeComponent = Mapper.TimeLife.get(entity);

        if(timeLifeComponent.addTime(deltaTime)){
            getEngine().removeEntity(entity);
        }
    }
}
