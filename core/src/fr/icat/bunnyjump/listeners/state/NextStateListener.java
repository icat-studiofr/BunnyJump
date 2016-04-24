package fr.icat.bunnyjump.listeners.state;

import com.badlogic.ashley.signals.Listener;
import com.badlogic.ashley.signals.Signal;
import fr.icat.bunnyjump.bag.EntityNextStateBag;
import fr.icat.bunnyjump.components.TSC;
import fr.icat.bunnyjump.consts.Mapper;

/**
 * Listener qui change l'état d'une entity a la fin d'un timer
 */
public final class NextStateListener implements Listener<Object> {

    private static NextStateListener stock = new NextStateListener();

    public static NextStateListener inst() {
        return stock;
    }

    private NextStateListener() {}

    // --

    @Override
    public void receive(Signal<Object> signal, Object e) {

        EntityNextStateBag bag = (EntityNextStateBag)e;

        if(bag == null || bag.entity == null || bag.nextState == -1) return;

        final TSC tsc = Mapper.TSC.get(bag.entity);
        tsc.setState(bag.nextState);
    }
}
