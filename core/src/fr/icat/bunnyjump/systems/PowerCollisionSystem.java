package fr.icat.bunnyjump.systems;

import com.badlogic.ashley.core.Component;
import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.signals.Listener;
import com.badlogic.gdx.utils.Array;
import fr.icat.bunnyjump.bag.EntityPowerBag;
import fr.icat.bunnyjump.components.TimerComponent;
import fr.icat.bunnyjump.components.collision.MagicianCollisionComponent;
import fr.icat.bunnyjump.components.collision.PowerCollisionComponent;
import fr.icat.bunnyjump.consts.Mapper;

/**
 * Created by Romain on 10/04/2016.
 */
public final class PowerCollisionSystem extends AbsCollisionSystem {

    MagicianCollisionComponent magicianCollisionComponent;

    PowerCollisionComponent powerCollisionComponent;

    public PowerCollisionSystem() {
        super(
                Family.all(MagicianCollisionComponent.class).get(),
                Mapper.MagicianCollision, Mapper.PowerCollision
        );
    }

    @Override
    public void addedToEngine(Engine engine) {
        super.addedToEngine(engine);
        this.passiveEntities = engine.getEntitiesFor(Family.all(PowerCollisionComponent.class).get());
    }

    @Override
    public void init() {
        magicianCollisionComponent = (MagicianCollisionComponent)activeCollisionComponent;
        powerCollisionComponent = (PowerCollisionComponent)passiveCollisionComponent;
    }

    @Override
    public boolean collision(Entity aEntity, Entity pEntity) {

        final EntityPowerBag bag = new EntityPowerBag(aEntity, new Array<Component>());

        for (ComponentMapper mapper :
                powerCollisionComponent.componentToRemove) {

            Component c = mapper.get(aEntity);
            if(c == null) continue;
            bag.componentRemoved.add(c);
            aEntity.remove(c.getClass());
        }

        powerCollisionComponent.powerAdded.exec(aEntity);

        TimerComponent timer = new TimerComponent(
                powerCollisionComponent.time, bag, true);
        timer.timerSignal.add(
                (Listener)powerCollisionComponent.powerRemoved);
        timer.kill = true;

        getEngine().addEntity(new Entity().add(timer));
        
        getEngine().removeEntity(pEntity);

        return true;
    }
}
