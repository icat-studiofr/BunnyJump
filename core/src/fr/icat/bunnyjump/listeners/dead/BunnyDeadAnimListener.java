package fr.icat.bunnyjump.listeners.dead;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.signals.Listener;
import com.badlogic.ashley.signals.Signal;
import fr.icat.bunnyjump.components.AccelComponent;
import fr.icat.bunnyjump.components.CarrotAttackComponent;
import fr.icat.bunnyjump.components.GravityComponent;
import fr.icat.bunnyjump.components.TSC;
import fr.icat.bunnyjump.components.VelocityComponent;
import fr.icat.bunnyjump.components.collision.BunnyAttackCollisionComponent;
import fr.icat.bunnyjump.components.collision.JumperCollisionComponent;
import fr.icat.bunnyjump.components.collision.MagicianCollisionComponent;
import fr.icat.bunnyjump.consts.Mapper;
import fr.icat.bunnyjump.data.BunnyData;

/**
 * Created by Romain on 26/03/2016.
 */
public final class BunnyDeadAnimListener implements Listener<Entity> {

    public static BunnyDeadAnimListener inst(){ return stock; }

    private static BunnyDeadAnimListener stock = new BunnyDeadAnimListener();

    private BunnyDeadAnimListener(){}

    // --

    @Override
    public void receive(Signal<Entity> signal, Entity e) {

        final TSC tsc = Mapper.TSC.get(e);
        final VelocityComponent velocityComponent = Mapper.Velocity.get(e);

        tsc.setState(BunnyData.STATES.DEAD);
        velocityComponent.setVelo(0, 50);

        e.remove(JumperCollisionComponent.class);
        e.remove(CarrotAttackComponent.class);
        e.remove(MagicianCollisionComponent.class);
        e.remove(BunnyAttackCollisionComponent.class);
        e.remove(AccelComponent.class);
        e.remove(GravityComponent.class);
    }
}
