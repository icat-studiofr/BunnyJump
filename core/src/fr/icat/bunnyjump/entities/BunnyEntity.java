package fr.icat.bunnyjump.entities;

import com.badlogic.ashley.core.Entity;
import fr.icat.bunnyjump.components.AccelComponent;
import fr.icat.bunnyjump.components.CarrotAttackComponent;
import fr.icat.bunnyjump.components.LifeComponent;
import fr.icat.bunnyjump.components.TextureComponent;
import fr.icat.bunnyjump.components.TransporterComponent;
import fr.icat.bunnyjump.components.collision.BankerCollisionComponent;
import fr.icat.bunnyjump.components.collision.MagicianCollisionComponent;
import fr.icat.bunnyjump.components.collision.MonsterDefenseCollisionComponent;
import fr.icat.bunnyjump.components.TSC;
import fr.icat.bunnyjump.components.TransformComponent;
import fr.icat.bunnyjump.components.collision.BunnyAttackCollisionComponent;
import fr.icat.bunnyjump.components.collision.JumperCollisionComponent;
import fr.icat.bunnyjump.data.BunnyData;
import fr.icat.bunnyjump.components.GravityComponent;
import fr.icat.bunnyjump.components.BunnyComponent;
import fr.icat.bunnyjump.components.VelocityComponent;
import fr.icat.bunnyjump.listeners.collision.BunnyJumpCollisionListener;
import fr.icat.bunnyjump.listeners.dead.BunnyDeadAnimListener;
import fr.icat.bunnyjump.listeners.transform.MoveListener;
import fr.icat.bunnyjump.listeners.state.BunnyNewStateListener;
import fr.icat.bunnyjump.listeners.transform.FlipTextureListener;

/**
 * Singleton : Personnage controllé par le joueur unique
 */
public final class BunnyEntity extends Entity{

    public static int score = 0;

    public BunnyEntity() {
        init();
    }

    public void init(){

        score = 0;

        this.add(new BunnyComponent())
            .add(new TextureComponent())
            .add(new GravityComponent())
            .add(new CarrotAttackComponent())
            .add(new TransporterComponent(this))
            .add(new BunnyAttackCollisionComponent(this, BunnyData.DEGAT, BunnyData.COLLISION.ATTACK))
            .add(new MagicianCollisionComponent(this, BunnyData.COLLISION.MAGICIAN))
            .add(new BankerCollisionComponent(this, BunnyData.COLLISION.BANKER))
            .add(new AccelComponent(BunnyData.MOVE.X));

        LifeComponent lifeComponent = new LifeComponent(this, BunnyData.LIFE);
        lifeComponent.deadSignal.add(BunnyDeadAnimListener.inst());

        VelocityComponent velocityComponent = new VelocityComponent(this, 0, -BunnyData.MOVE.Y);
        velocityComponent.reverseXSignal.add(FlipTextureListener.inst());

        JumperCollisionComponent jumperCollisionComponent = new JumperCollisionComponent(
                this, BunnyData.COLLISION.JUMPER, BunnyData.MOVE.Y);
        jumperCollisionComponent.collisionSignal.add(BunnyJumpCollisionListener.inst());

        TransformComponent transformComponent =
                new TransformComponent(this, BunnyData.POS.START, BunnyData.SIZE.VECTOR);
        transformComponent.moveSignal.add(MoveListener.inst());

        TSC tsc = new TSC(this, BunnyData.STATES.TEXTURE_STATE_MAP, BunnyData.STATES.JUMP);
        tsc.newStateSignal.add(BunnyNewStateListener.inst());

        this.add(lifeComponent)
            .add(tsc)
            .add(velocityComponent)
            .add(transformComponent)
            .add(jumperCollisionComponent)
            .add(new MonsterDefenseCollisionComponent(this, lifeComponent, BunnyData.COLLISION.MONSTER_DEFENSE));

    }
}
