package fr.icat.bunnyjump.listeners.power.added;

import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import fr.icat.bunnyjump.components.TransporterComponent;
import fr.icat.bunnyjump.consts.Mapper;
import fr.icat.bunnyjump.data.BunnyData;
import fr.icat.bunnyjump.entities.power.BubbleEntity;

/**
 * Created by Romain on 17/04/2016.
 */
public final class BubblePowerAddedListener implements iPowerAddedListener {

    private static BubblePowerAddedListener stock = new BubblePowerAddedListener();

    public static BubblePowerAddedListener inst() {
        return stock;
    }

    private BubblePowerAddedListener() {}

    // --

    Engine engine;

    @Override
    public void exec(Entity entity) {

        TransporterComponent transporterComponent = Mapper.Transporter.get(entity);

        Entity bubble = new BubbleEntity();
        transporterComponent.add(BunnyData.TRANSPORTER.BUBBLE, Mapper.Transportable.get(bubble));
        engine.addEntity(bubble);
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }
}
