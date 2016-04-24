package fr.icat.bunnyjump.entities.monsters;

import com.badlogic.ashley.core.Entity;
import fr.icat.bunnyjump.components.LifeComponent;
import fr.icat.bunnyjump.components.SunComponent;
import fr.icat.bunnyjump.components.TextureComponent;
import fr.icat.bunnyjump.components.TransformComponent;
import fr.icat.bunnyjump.components.TransportableComponent;
import fr.icat.bunnyjump.components.VelocityComponent;
import fr.icat.bunnyjump.components.collision.BunnyDefenseCollisionComponent;
import fr.icat.bunnyjump.components.collision.CarrotDefenseCollisionComponent;
import fr.icat.bunnyjump.components.collision.MonsterAttackCollisionComponent;
import fr.icat.bunnyjump.components.collision.PlatformCollisionComponent;
import fr.icat.bunnyjump.components.TSC;
import fr.icat.bunnyjump.data.MonsterData;
import fr.icat.bunnyjump.data.PlatformData;
import fr.icat.bunnyjump.data.SpringManData;
import fr.icat.bunnyjump.entities.PlatformEntity;
import fr.icat.bunnyjump.listeners.dead.DeadAnimListener;
import fr.icat.bunnyjump.utils.Distance;

/**
 * Created by Romain on 28/03/2016.
 */
public final class SpringManEntity extends AbsMonsterEntity {

    TransportableComponent transportableComponent;

    public SpringManEntity(){
        super();
        init();
    }

    private void init(){

        LifeComponent life = new LifeComponent(this, SpringManData.LIFE);
        life.deadSignal.add(DeadAnimListener.inst());

        transportableComponent = new TransportableComponent(this, SpringManData.TRANSPORTABLE);

        this.add(new SunComponent())
            .add(life)
            .add(new TextureComponent())
            .add(new VelocityComponent(this, 0, -SpringManData.SPEED, null,
                    new Distance(-SpringManData.SIZE.y, -SpringManData.SIZE.y - SpringManData.DISTANCE)))
            .add(new TransformComponent(this, MonsterData.Z, SpringManData.SIZE))
            .add(new TSC(this, SpringManData.STATE.TEXTURE_STATE_MAP, SpringManData.STATE.SPRING_MAN1))
            .add(new MonsterAttackCollisionComponent(this, 1, SpringManData.COLLISION.ATTACK))
            .add(new PlatformCollisionComponent(this, SpringManData.COLLISION.PLATFORM, 3))
            .add(new BunnyDefenseCollisionComponent(this, life, SpringManData.COLLISION.BUNNY_DEFENSE))
            .add(new CarrotDefenseCollisionComponent(this, life, SpringManData.COLLISION.CARROT_DEFENSE))
            .add(transportableComponent);
    }

    public Entity statique(){
        PlatformEntity p = new PlatformEntity(false);
        p.addTransportable(PlatformData.TRANSPORTER.SPRING_MAN, transportableComponent);
        return p;
    }

    public Entity horizontal(){
        PlatformEntity p = new PlatformEntity(false).velo_x();
        p.addTransportable(PlatformData.TRANSPORTER.SPRING_MAN, transportableComponent);
        return p;
    }
}
