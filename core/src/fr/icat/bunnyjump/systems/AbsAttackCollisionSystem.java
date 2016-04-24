package fr.icat.bunnyjump.systems;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import fr.icat.bunnyjump.components.collision.AbsAttackCollisionComponent;
import fr.icat.bunnyjump.components.collision.AbsCollisionComponent;
import fr.icat.bunnyjump.components.collision.AbsDefenseCollisionComponent;

/**
 * Created by Romain on 24/03/2016.
 */
public abstract class AbsAttackCollisionSystem extends AbsCollisionSystem{

    AbsAttackCollisionComponent attackCollision;
    AbsDefenseCollisionComponent defenseCollision;

    public AbsAttackCollisionSystem(
            Family family, ComponentMapper<? extends AbsCollisionComponent> activeMapper,
            ComponentMapper<? extends AbsCollisionComponent> passiveMapper
    ){
        super(family, activeMapper, passiveMapper);
    }

    @Override
    public void init() {
        attackCollision = (AbsAttackCollisionComponent)this.activeCollisionComponent;
        defenseCollision = (AbsDefenseCollisionComponent)this.passiveCollisionComponent;
    }

    @Override
    public boolean collision(Entity aEntity, Entity pEntity) {
        defenseCollision.lifeComponent.removeLifePoint(attackCollision.degat);
        return true;
    }
}
