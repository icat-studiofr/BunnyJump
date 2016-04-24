package fr.icat.bunnyjump.listeners.power.removed;

import com.badlogic.ashley.core.Entity;
import fr.icat.bunnyjump.components.GravityComponent;
import fr.icat.bunnyjump.components.TransportableComponent;
import fr.icat.bunnyjump.components.TransporterComponent;
import fr.icat.bunnyjump.components.VelocityComponent;
import fr.icat.bunnyjump.consts.Mapper;
import fr.icat.bunnyjump.data.BunnyData;

/**
 * Created by Romain on 17/04/2016.
 */
public final class BubblePowerRemovedListener extends AbsPowerRemovedListener{

    private static BubblePowerRemovedListener stock = new BubblePowerRemovedListener();

    public static BubblePowerRemovedListener inst() {
        return stock;
    }

    private BubblePowerRemovedListener() {}

    // --

    @Override
    public void exec(Entity entity) {

        TransporterComponent transporterComponent = Mapper.Transporter.get(entity);

        if(transporterComponent == null) return;

        TransportableComponent transportable
                = transporterComponent.transportables.get(BunnyData.TRANSPORTER.BUBBLE);

        if(transportable == null) return;

        Entity bubble = transportable.parent;
        transporterComponent.remove(BunnyData.TRANSPORTER.BUBBLE);
        bubble.add(new VelocityComponent(bubble)).add(new GravityComponent());
    }
}
