package fr.icat.bunnyjump.entities.monsters;

import fr.icat.bunnyjump.components.FlyManComponent;
import fr.icat.bunnyjump.components.LifeComponent;
import fr.icat.bunnyjump.components.TSC;
import fr.icat.bunnyjump.components.TextureComponent;
import fr.icat.bunnyjump.components.TransformComponent;
import fr.icat.bunnyjump.components.VelocityComponent;
import fr.icat.bunnyjump.components.collision.BunnyDefenseCollisionComponent;
import fr.icat.bunnyjump.components.collision.CarrotDefenseCollisionComponent;
import fr.icat.bunnyjump.components.collision.MonsterAttackCollisionComponent;
import fr.icat.bunnyjump.components.collision.PlatformCollisionComponent;
import fr.icat.bunnyjump.data.FlyManData;
import fr.icat.bunnyjump.data.MonsterData;
import fr.icat.bunnyjump.listeners.dead.DeadAnimListener;
import fr.icat.bunnyjump.utils.Distance;

/**
 * Created by Romain on 18/04/2016.
 */
public final class FlyManEntity extends AbsMonsterEntity {

    public FlyManEntity(){

        LifeComponent life = new LifeComponent(this, FlyManData.LIFE);
        life.deadSignal.add(DeadAnimListener.inst());

        this.add(new FlyManComponent())
            .add(new TextureComponent())
            .add(new TSC(this, FlyManData.STATE.TEXTURE_STATE_MAP, FlyManData.STATE.FLYMAN_FLY))
            .add(new TransformComponent(this, MonsterData.Z, FlyManData.SIZE))
            .add(life)
            .add(new PlatformCollisionComponent(this, FlyManData.COLLISION.PLATFORM))
            .add(new MonsterAttackCollisionComponent(this, FlyManData.DEGAT, FlyManData.COLLISION.ATTACK))
            .add(new BunnyDefenseCollisionComponent(this, life, FlyManData.COLLISION.BUNNY_DEFENSE))
            .add(new CarrotDefenseCollisionComponent(this, life, FlyManData.COLLISION.CARROT_DEFENSE))
            .add(new VelocityComponent(this, 0, FlyManData.SPEED, null, new Distance(0, -FlyManData.DISTANCE)));
    }
}
