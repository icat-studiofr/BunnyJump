package fr.icat.bunnyjump.entities.monsters;

import fr.icat.bunnyjump.components.LifeComponent;
import fr.icat.bunnyjump.components.SunComponent;
import fr.icat.bunnyjump.components.TextureComponent;
import fr.icat.bunnyjump.components.TransformComponent;
import fr.icat.bunnyjump.components.collision.BunnyDefenseCollisionComponent;
import fr.icat.bunnyjump.components.collision.CarrotDefenseCollisionComponent;
import fr.icat.bunnyjump.components.collision.MonsterAttackCollisionComponent;
import fr.icat.bunnyjump.components.collision.PlatformCollisionComponent;
import fr.icat.bunnyjump.components.TSC;
import fr.icat.bunnyjump.data.MonsterData;
import fr.icat.bunnyjump.data.SunData;
import fr.icat.bunnyjump.listeners.dead.DeadAnimListener;

/**
 * Created by Romain on 24/03/2016.
 */
public final class SunEntity extends AbsMonsterEntity {

    public SunEntity(){
        super();
        init();
    }

    private void init(){

        LifeComponent life = new LifeComponent(this, SunData.LIFE);
        life.deadSignal.add(DeadAnimListener.inst());

        this.add(new SunComponent())
            .add(life)
            .add(new TextureComponent())
            .add(new TransformComponent(this, MonsterData.Z, SunData.SIZE))
            .add(new TSC(this, SunData.STATE.TEXTURE_STATE_MAP, SunData.STATE.SUN1))
            .add(new MonsterAttackCollisionComponent(this, 1, SunData.COLLISION.ATTACK))
            .add(new PlatformCollisionComponent(this, SunData.COLLISION.PLATFORM, 3))
            .add(new BunnyDefenseCollisionComponent(this, life, SunData.COLLISION.BUNNY_DEFENSE))
            .add(new CarrotDefenseCollisionComponent(this, life, SunData.COLLISION.CARROT_DEFENSE));
    }
}
