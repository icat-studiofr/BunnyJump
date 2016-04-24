package fr.icat.bunnyjump.systems;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import fr.icat.bunnyjump.components.TimerComponent;
import fr.icat.bunnyjump.consts.Mapper;

/**
 * Created by Romain on 09/04/2016.
 */
public final class TimerSystem extends IteratingSystem {

    TimerComponent timerComponent;

    public TimerSystem() {
        super(Family.all(TimerComponent.class).get());
    }

    @Override
    protected void processEntity(Entity entity, float deltaTime) {

        timerComponent = Mapper.Timer.get(entity);

        if(!timerComponent.provide){ return; }

        timerComponent.temp += deltaTime;

        if(timerComponent.temp >= timerComponent.time){

            timerComponent.temp = 0;

            timerComponent.timerSignal.dispatch(timerComponent.data);

            if(timerComponent.kill) {
                getEngine().removeEntity(entity);
            }
        }
    }
}
