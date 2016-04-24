package fr.icat.bunnyjump.systems;

import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import fr.icat.bunnyjump.components.CarrotAttackComponent;
import fr.icat.bunnyjump.components.collision.CarrotAttackCollisionComponent;
import fr.icat.bunnyjump.components.collision.CarrotDefenseCollisionComponent;
import fr.icat.bunnyjump.consts.Mapper;

/**
 * Created by Romain on 17/04/2016.
 */
public final class CarrotAttackCollisionSystem extends AbsAttackCollisionSystem {

    public CarrotAttackCollisionSystem() {
        super(Family.all(CarrotAttackCollisionComponent.class).get(),
                Mapper.CarrotAttackCollision, Mapper.CarrotDefenseCollision);
    }

    @Override
    public void addedToEngine(Engine engine) {
        super.addedToEngine(engine);
        passiveEntities = engine.getEntitiesFor(Family.all(CarrotDefenseCollisionComponent.class).get());
    }

    @Override
    public boolean collision(Entity aEntity, Entity pEntity) {
        super.collision(aEntity, pEntity);
        getEngine().removeEntity(aEntity);
        if(!Mapper.Life.get(pEntity).isAlive()) getEngine().removeEntity(pEntity);
        return false;
    }
}
