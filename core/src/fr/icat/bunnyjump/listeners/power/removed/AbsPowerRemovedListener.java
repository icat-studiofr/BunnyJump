package fr.icat.bunnyjump.listeners.power.removed;

import com.badlogic.ashley.core.Component;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.signals.Signal;
import fr.icat.bunnyjump.bag.EntityPowerBag;

/**
 * Created by Romain on 10/04/2016.
 */
public abstract class AbsPowerRemovedListener implements iPowerRemovedListener {

    public abstract void exec(Entity entity);

    @Override
    public void receive(Signal<EntityPowerBag> signal, EntityPowerBag bag) {

        for (Component component :
                bag.componentRemoved) {
            bag.entity.add(component);
        }

        exec(bag.entity);
    }

}
