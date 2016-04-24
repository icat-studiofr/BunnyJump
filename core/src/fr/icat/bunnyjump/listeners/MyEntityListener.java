package fr.icat.bunnyjump.listeners;

import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.EntityListener;
import fr.icat.bunnyjump.components.TransportableComponent;
import fr.icat.bunnyjump.components.TransporterComponent;
import fr.icat.bunnyjump.consts.Mapper;

/**
 * Created by Romain on 25/03/2016.
 */
public final class MyEntityListener implements EntityListener {

    Engine engine;

    public MyEntityListener(Engine engine){
        this.engine = engine;
    }

    @Override
    public void entityAdded(Entity entity) {

        final TransporterComponent transporterComponent = Mapper.Transporter.get(entity);

        if(transporterComponent == null) { return; }

        for (TransportableComponent transportable :
                transporterComponent.transportables.values()) {
            engine.addEntity(transportable.parent);
        }
    }

    @Override
    public void entityRemoved(Entity entity) {

        final TransporterComponent transporterComponent = Mapper.Transporter.get(entity);

        if(transporterComponent == null) { return; }

        for (TransportableComponent transportable :
                transporterComponent.transportables.values()) {
            engine.removeEntity(transportable.parent);
        }
    }
}
