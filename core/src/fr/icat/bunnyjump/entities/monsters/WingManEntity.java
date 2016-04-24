package fr.icat.bunnyjump.entities.monsters;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import fr.icat.bunnyjump.components.LifeComponent;
import fr.icat.bunnyjump.components.SunComponent;
import fr.icat.bunnyjump.components.TextureComponent;
import fr.icat.bunnyjump.components.TransformComponent;
import fr.icat.bunnyjump.components.VelocityComponent;
import fr.icat.bunnyjump.components.collision.BunnyDefenseCollisionComponent;
import fr.icat.bunnyjump.components.collision.CarrotDefenseCollisionComponent;
import fr.icat.bunnyjump.components.collision.MonsterAttackCollisionComponent;
import fr.icat.bunnyjump.components.collision.PlatformCollisionComponent;
import fr.icat.bunnyjump.components.TSC;
import fr.icat.bunnyjump.data.MonsterData;
import fr.icat.bunnyjump.data.WingManData;
import fr.icat.bunnyjump.listeners.dead.DeadAnimListener;
import fr.icat.bunnyjump.utils.Distance;

/**
 * Created by Romain on 28/03/2016.
 */
public final class WingManEntity extends AbsMonsterEntity {

    Vector2 temp = new Vector2();

    public WingManEntity() {

        LifeComponent life = new LifeComponent(this, WingManData.LIFE);
        life.deadSignal.add(DeadAnimListener.inst());

        Distance distance = new Distance(0, WingManData.DISTANCE);

        VelocityComponent velocityComponent = new VelocityComponent(this,
                WingManData.SPEED, 0, distance, null);

        TransformComponent transformComponent = new TransformComponent(this, MonsterData.Z, WingManData.SIZE);
        transformComponent.addVelo(temp.set(MathUtils.random(0, distance.end), 0));

        this.add(new SunComponent())
            .add(life)
            .add(velocityComponent)
            .add(new TextureComponent())
            .add(transformComponent)
            .add(new TSC(this, WingManData.STATE.TEXTURE_STATE_MAP, WingManData.STATE.WING_MAN1))
            .add(new MonsterAttackCollisionComponent(this, 1, WingManData.COLLISION.ATTACK))
            .add(new PlatformCollisionComponent(this, WingManData.COLLISION.PLATFORM, 3))
            .add(new BunnyDefenseCollisionComponent(this, life, WingManData.COLLISION.BUNNY_DEFENSE))
            .add(new CarrotDefenseCollisionComponent(this, life, WingManData.COLLISION.CARROT_DEFENSE));
    }

}
