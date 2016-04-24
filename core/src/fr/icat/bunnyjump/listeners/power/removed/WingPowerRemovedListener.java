package fr.icat.bunnyjump.listeners.power.removed;

import com.badlogic.ashley.core.Entity;
import fr.icat.bunnyjump.components.GravityComponent;
import fr.icat.bunnyjump.components.TransporterComponent;
import fr.icat.bunnyjump.components.VelocityComponent;
import fr.icat.bunnyjump.consts.Mapper;
import fr.icat.bunnyjump.data.BunnyData;

/**
 * Created by Romain on 11/04/2016.
 */
public final class WingPowerRemovedListener extends AbsPowerRemovedListener{

    private static WingPowerRemovedListener stock = new WingPowerRemovedListener();

    public static WingPowerRemovedListener inst() {
        return stock;
    }

    private WingPowerRemovedListener() {}

    // --

    @Override
    public void exec(Entity entity) {

        final TransporterComponent transporterComponent = Mapper.Transporter.get(entity);

        if(transporterComponent == null) return;

        Entity wing = transporterComponent.transportables.get(BunnyData.TRANSPORTER.WING_LEFT).parent;
        transporterComponent.transportables.remove(BunnyData.TRANSPORTER.WING_LEFT);
        wing.add(new GravityComponent()).add(new VelocityComponent(wing));

        wing = transporterComponent.transportables.get(BunnyData.TRANSPORTER.WING_RIGHT).parent;
        transporterComponent.transportables.remove(BunnyData.TRANSPORTER.WING_RIGHT);
        wing.add(new GravityComponent()).add(new VelocityComponent(wing));
    }
}
