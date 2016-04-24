package fr.icat.bunnyjump.listeners.collision;

import com.badlogic.ashley.signals.Listener;
import com.badlogic.ashley.signals.Signal;
import fr.icat.bunnyjump.components.TSC;
import fr.icat.bunnyjump.consts.Mapper;
import fr.icat.bunnyjump.data.BunnyData;
import fr.icat.bunnyjump.bag.EntityDuoBag;

/**
 * Created by Romain on 26/03/2016.
 */
public final class BunnyJumpCollisionListener implements Listener <EntityDuoBag>{

    public static BunnyJumpCollisionListener inst(){ return stock; }

    private static BunnyJumpCollisionListener stock = new BunnyJumpCollisionListener();

    private BunnyJumpCollisionListener(){}

    // --

    @Override
    public void receive(Signal<EntityDuoBag> signal, EntityDuoBag bag) {

        final TSC TSC = Mapper.TSC.get(bag.e1);

        if(TSC == null) { return; }

        TSC.setState(BunnyData.STATES.STAND);
    }
}
