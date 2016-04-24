package fr.icat.bunnyjump.listeners.transform;

import com.badlogic.ashley.signals.Listener;
import com.badlogic.ashley.signals.Signal;
import fr.icat.bunnyjump.components.TransformComponent;
import fr.icat.bunnyjump.components.TransportableComponent;
import fr.icat.bunnyjump.components.TransporterComponent;
import fr.icat.bunnyjump.components.VelocityComponent;
import fr.icat.bunnyjump.consts.Mapper;
import fr.icat.bunnyjump.bag.EntityMoveBag;

/**
 * Lors du déplacement d'une entité ce Listener met à jour la position et le trajet effectué par
 * les entités portées
 */
public final class MoveListener implements Listener<EntityMoveBag> {

    public static MoveListener inst(){ return stock; }

    private static MoveListener stock = new MoveListener();

    private MoveListener(){}

    @Override
    public void receive(Signal<EntityMoveBag> signal, EntityMoveBag bag) {

        if(bag == null || bag.entity == null){ return; }

        final TransporterComponent transporterComponent = Mapper.Transporter.get(bag.entity);
        VelocityComponent velocityComponent;

        if(transporterComponent == null) { return; }

        TransformComponent transformComponent;

        for (TransportableComponent transportable :
                transporterComponent.transportables.values()) {

            transformComponent = Mapper.Transform.get(transportable.parent);
            if(transformComponent == null){ continue; }
            transformComponent.addVelo(bag.x, bag.y);

            velocityComponent = Mapper.Velocity.get(transportable.parent);

            if(velocityComponent == null) continue;

            if(velocityComponent.getDistanceX() != null)
                velocityComponent.getDistanceX().update(bag.x);
            if(velocityComponent.getDistanceY() != null)
                velocityComponent.getDistanceY().update(bag.y);
        }

    }
}
