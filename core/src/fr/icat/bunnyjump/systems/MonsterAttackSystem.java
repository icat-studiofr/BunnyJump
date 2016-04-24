package fr.icat.bunnyjump.systems;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import fr.icat.bunnyjump.components.TransformComponent;
import fr.icat.bunnyjump.components.collision.AbsCollisionComponent;
import fr.icat.bunnyjump.components.collision.MonsterAttackCollisionComponent;
import fr.icat.bunnyjump.components.collision.MonsterDefenseCollisionComponent;
import fr.icat.bunnyjump.consts.Mapper;

/**
 * Created by Romain on 24/03/2016.
 */
public final class MonsterAttackSystem extends AbsAttackCollisionSystem{

    public MonsterAttackSystem() {
        super(Family.all(MonsterAttackCollisionComponent.class, TransformComponent.class).get(),
                Mapper.MonsterAttack, Mapper.MonsterDefense);
    }

    @Override
    public void addedToEngine(Engine engine) {
        super.addedToEngine(engine);
        this.passiveEntities = engine.getEntitiesFor(
                Family.all(MonsterDefenseCollisionComponent.class,TransformComponent.class).get());
    }

    @Override
    public boolean collision(Entity aEntity, Entity pEntity) {
        return super.collision(aEntity, pEntity);
    }
}
