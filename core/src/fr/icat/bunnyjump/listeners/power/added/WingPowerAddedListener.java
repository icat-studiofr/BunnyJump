package fr.icat.bunnyjump.listeners.power.added;

import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import fr.icat.bunnyjump.components.TSC;
import fr.icat.bunnyjump.components.TransporterComponent;
import fr.icat.bunnyjump.components.VelocityComponent;
import fr.icat.bunnyjump.consts.Mapper;
import fr.icat.bunnyjump.data.BunnyData;
import fr.icat.bunnyjump.data.WingData;
import fr.icat.bunnyjump.entities.power.WingEntity;

/**
 * Created by Romain on 11/04/2016.
 */
public final class WingPowerAddedListener implements iPowerAddedListener {

    private static WingPowerAddedListener stock = new WingPowerAddedListener();

    public static WingPowerAddedListener inst() {
        return stock;
    }

    private WingPowerAddedListener() {}

    // --

    Engine engine;

    @Override
    public void exec(Entity entity) {

        final TransporterComponent transporterComponent = Mapper.Transporter.get(entity);
        final VelocityComponent velocityComponent = Mapper.Velocity.get(entity);
        final TSC tsc = Mapper.TSC.get(entity);

        tsc.setState(BunnyData.STATES.SKY);
        velocityComponent.getVelo().y = -WingData.SPEED;

        WingEntity wing = new WingEntity(true);
        transporterComponent.add(BunnyData.TRANSPORTER.WING_RIGHT, Mapper.Transportable.get(wing));
        engine.addEntity(wing);

        wing = new WingEntity(false);
        transporterComponent.add(BunnyData.TRANSPORTER.WING_LEFT, Mapper.Transportable.get(wing));
        engine.addEntity(wing);
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }
}
