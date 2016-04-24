package fr.icat.bunnyjump.listeners.power.added;

import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import fr.icat.bunnyjump.components.TSC;
import fr.icat.bunnyjump.components.TransporterComponent;
import fr.icat.bunnyjump.components.VelocityComponent;
import fr.icat.bunnyjump.consts.Mapper;
import fr.icat.bunnyjump.data.BunnyData;
import fr.icat.bunnyjump.data.JetpackData;
import fr.icat.bunnyjump.entities.power.JetpackEntity;

/**
 * Created by Romain on 10/04/2016.
 */
public final class JetpackPowerAddedListener implements iPowerAddedListener {

    private static JetpackPowerAddedListener stock = new JetpackPowerAddedListener();

    public static JetpackPowerAddedListener inst() {
        return stock;
    }

    private JetpackPowerAddedListener() {}

    // --

    Engine engine;

    @Override
    public void exec(Entity entity) {

        final VelocityComponent velocityComponent = Mapper.Velocity.get(entity);
        final TransporterComponent transporterComponent = Mapper.Transporter.get(entity);
        final TSC TSC = Mapper.TSC.get(entity);

        velocityComponent.setVelo(0, -JetpackData.SPEED);

        TSC.setState(BunnyData.STATES.SKY);

        // Ajout jetpack
        final Entity jetpack = new JetpackEntity();
        transporterComponent.add(BunnyData.TRANSPORTER.JETPACK,
                Mapper.Transportable.get(jetpack));
        engine.addEntity(jetpack);
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }
}
