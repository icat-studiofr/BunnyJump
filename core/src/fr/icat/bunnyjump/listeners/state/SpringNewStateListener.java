package fr.icat.bunnyjump.listeners.state;

import com.badlogic.ashley.signals.Listener;
import com.badlogic.ashley.signals.Signal;
import fr.icat.bunnyjump.bag.EntityNewStateBag;
import fr.icat.bunnyjump.components.TransformComponent;
import fr.icat.bunnyjump.consts.Mapper;
import fr.icat.bunnyjump.data.SpringData;

/**
 * Created by Romain on 11/04/2016.
 */
public final class SpringNewStateListener implements Listener<EntityNewStateBag> {

    private static SpringNewStateListener stock = new SpringNewStateListener();

    public static SpringNewStateListener inst() {
        return stock;
    }

    private SpringNewStateListener() {}

    // --

    @Override
    public void receive(Signal<EntityNewStateBag> signal, EntityNewStateBag bag) {

        if(bag == null || bag.entity == null){ return; }

        // SPRING -> SPRING IN
        if(bag.actualState.equals(SpringData.STATES.SPRING) &&
                bag.newState.equals(SpringData.STATES.SPRING_IN)
        ){
            final TransformComponent transformComponent = Mapper.Transform.get(bag.entity);
            transformComponent.pos.y += transformComponent.size.y - SpringData.SIZE.SPRING_IN.y;
            transformComponent.size = SpringData.SIZE.SPRING_IN;
        }

        // SPRING IN -> SPRING OUT
        if(bag.actualState.equals(SpringData.STATES.SPRING_IN)
                && bag.newState.equals(SpringData.STATES.SPRING_OUT)
        ){
            final TransformComponent transformComponent = Mapper.Transform.get(bag.entity);
            transformComponent.pos.y += transformComponent.size.y - SpringData.SIZE.SPRING_OUT.y;
            transformComponent.size = SpringData.SIZE.SPRING_OUT;
        }
    }
}
