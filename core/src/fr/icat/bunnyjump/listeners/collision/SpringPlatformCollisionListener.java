package fr.icat.bunnyjump.listeners.collision;

import com.badlogic.ashley.signals.Listener;
import com.badlogic.ashley.signals.Signal;
import fr.icat.bunnyjump.components.TSC;
import fr.icat.bunnyjump.consts.Mapper;
import fr.icat.bunnyjump.data.SpringData;
import fr.icat.bunnyjump.bag.EntityDuoBag;

/**
 * Created by Romain on 26/03/2016.
 */
public final class SpringPlatformCollisionListener implements Listener<EntityDuoBag> {

    private static SpringPlatformCollisionListener ourInstance = new SpringPlatformCollisionListener();

    public static SpringPlatformCollisionListener inst() {
        return ourInstance;
    }

    private SpringPlatformCollisionListener() {}

    // --

    @Override
    public void receive(Signal<EntityDuoBag> signal, EntityDuoBag bag) {

        final TSC tsc = Mapper.TSC.get(bag.e1);

        if(tsc == null) return;

        tsc.setState(SpringData.STATES.SPRING_IN);
    }
}
