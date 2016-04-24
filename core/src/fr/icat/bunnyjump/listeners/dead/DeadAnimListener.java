package fr.icat.bunnyjump.listeners.dead;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.signals.Listener;
import com.badlogic.ashley.signals.Signal;
import fr.icat.bunnyjump.components.VelocityComponent;
import fr.icat.bunnyjump.consts.Mapper;

/**
 * Created by Romain on 26/03/2016.
 */
public final class DeadAnimListener implements Listener<Entity> {

    public static DeadAnimListener inst(){ return stock; }

    private static DeadAnimListener stock = new DeadAnimListener();

    private DeadAnimListener(){}

    // --

    @Override
    public void receive(Signal<Entity> signal, Entity e) {

        VelocityComponent velocityComponent = Mapper.Velocity.get(e);

        if(velocityComponent == null){
            velocityComponent = new VelocityComponent(e);
            e.add(velocityComponent);
        } else {
            velocityComponent.setDistanceY(null);
            velocityComponent.setDistanceX(null);
        }

        velocityComponent.setVelo(0, 35);
    }
}
