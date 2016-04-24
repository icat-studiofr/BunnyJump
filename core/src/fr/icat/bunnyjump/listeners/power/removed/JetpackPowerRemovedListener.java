package fr.icat.bunnyjump.listeners.power.removed;

import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import fr.icat.bunnyjump.components.GravityComponent;
import fr.icat.bunnyjump.components.TSC;
import fr.icat.bunnyjump.components.TransporterComponent;
import fr.icat.bunnyjump.components.VelocityComponent;
import fr.icat.bunnyjump.consts.Mapper;
import fr.icat.bunnyjump.data.BunnyData;
import fr.icat.bunnyjump.data.JetpackData;

/**
 * Created by Romain on 10/04/2016.
 */
public final class JetpackPowerRemovedListener extends AbsPowerRemovedListener {

    private static JetpackPowerRemovedListener stock = new JetpackPowerRemovedListener();

    public static JetpackPowerRemovedListener inst() {
        return stock;
    }

    private JetpackPowerRemovedListener() {}

    // --

    Engine engine;

    @Override
    public void exec(Entity entity) {

        // Update Bunny
        TransporterComponent transporterComponent = Mapper.Transporter.get(entity);
        TSC tsc = Mapper.TSC.get(entity);
        tsc.setState(BunnyData.STATES.JUMP);

        // Update jetpack
        Entity jetpack = transporterComponent.transportables.get(
                BunnyData.TRANSPORTER.JETPACK).parent;
        transporterComponent.transportables.remove(BunnyData.TRANSPORTER.JETPACK);
        transporterComponent = Mapper.Transporter.get(jetpack);
        jetpack.add(new GravityComponent()).add(new VelocityComponent(jetpack));

        // Clear flame
        Entity flame = transporterComponent.transportables.get(JetpackData.TRANSPORTER.FLAME1).parent;
        transporterComponent.transportables.remove(JetpackData.TRANSPORTER.FLAME1);
        engine.removeEntity(flame);

        flame = transporterComponent.transportables.get(JetpackData.TRANSPORTER.FLAME2).parent;
        transporterComponent.transportables.remove(JetpackData.TRANSPORTER.FLAME2);
        engine.removeEntity(flame);
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }
}
