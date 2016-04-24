package fr.icat.bunnyjump.listeners.state;

import com.badlogic.ashley.signals.Listener;
import com.badlogic.ashley.signals.Signal;
import fr.icat.bunnyjump.bag.EntityNewStateBag;
import fr.icat.bunnyjump.components.TransformComponent;
import fr.icat.bunnyjump.consts.Mapper;
import fr.icat.bunnyjump.data.BunnyData;

/**
 * Created by Romain on 10/04/2016.
 */
public final class BunnyNewStateListener implements Listener<EntityNewStateBag> {

    private static BunnyNewStateListener stock = new BunnyNewStateListener();

    public static BunnyNewStateListener inst() {
        return stock;
    }

    private BunnyNewStateListener() {}

    // --

    @Override
    public void receive(Signal<EntityNewStateBag> signal, EntityNewStateBag bag) {

        // -> SKY
        if(bag.newState.equals(BunnyData.STATES.SKY)){
            final TransformComponent transformComponent = Mapper.Transform.get(bag.entity);
            transformComponent.addSize(2, 0);
        }

        // <- SKY
        if(bag.actualState.equals(BunnyData.STATES.SKY)){
            final TransformComponent transformComponent = Mapper.Transform.get(bag.entity);
            transformComponent.addSize(-2, 0);
        }

        // -> DEAD
        if(bag.newState.equals(BunnyData.STATES.DEAD)){
            final TransformComponent transformComponent = Mapper.Transform.get(bag.entity);
            transformComponent.addSize(1,0);
        }
    }

}
