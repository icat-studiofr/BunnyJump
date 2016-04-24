package fr.icat.bunnyjump.entities;

import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import fr.icat.bunnyjump.components.LifeComponent;
import fr.icat.bunnyjump.components.PlatformComponent;
import fr.icat.bunnyjump.components.TextureComponent;
import fr.icat.bunnyjump.components.TransformComponent;
import fr.icat.bunnyjump.components.TransportableComponent;
import fr.icat.bunnyjump.components.TransporterComponent;
import fr.icat.bunnyjump.components.VelocityComponent;
import fr.icat.bunnyjump.components.collision.BunnyDefenseCollisionComponent;
import fr.icat.bunnyjump.components.collision.PlatformCollisionComponent;
import fr.icat.bunnyjump.data.PlatformData;
import fr.icat.bunnyjump.enums.MyRegions;
import fr.icat.bunnyjump.listeners.dead.DeadAnimListener;
import fr.icat.bunnyjump.listeners.transform.MoveListener;
import fr.icat.bunnyjump.utils.Distance;

/**
 * Entity qui représente toute les platformes du Game
 */
public final class PlatformEntity extends Entity{

    TransporterComponent transporterComponent;
    TransformComponent transformComponent;
    VelocityComponent velocityComponent;
    TextureComponent textureComponent;
    LifeComponent lifeComponent;
    Distance distanceX;
    Distance distanceY;
    boolean broken;
    Vector2 vTemp;
    boolean move;

    // --

    public PlatformEntity(boolean broken){
        this.broken = broken;
        this.vTemp = new Vector2();

        transformComponent = new TransformComponent(
                this, PlatformData.POS.Z, PlatformData.SIZE.VECTOR);

        textureComponent = new TextureComponent(MyRegions.platform.getRegion());

        this.add(new PlatformComponent())
                .add(transformComponent)
                .add(textureComponent)
                .add(new PlatformCollisionComponent(this, PlatformData.COLLISION.PLATFORM));

        if(broken) broken();
    }

    // --

    private void broken(){

        if(!PlatformData.BROKEN_RANDOM.get().check()){ return; }

        textureComponent.texture = MyRegions.platform_broken.getRegion();

        lifeComponent = new LifeComponent(this, 1);
        lifeComponent.deadSignal.add(DeadAnimListener.inst());

        this.add(lifeComponent)
            .add(new BunnyDefenseCollisionComponent(
                    this, lifeComponent, PlatformData.COLLISION.BUNNY_DEFENSE));
    }

    public PlatformEntity velo_x(){
        distanceX = new Distance(0, PlatformData.DISTANCE.MAX_DIST_X);

        if(velocityComponent == null) velocityComponent = new VelocityComponent(this);
        velocityComponent.getVelo().x = PlatformData.SPEED.HORIZONTAL.get().speed;
        velocityComponent.setDistanceX(distanceX);
        transformComponent.addVelo(
                vTemp.set(MathUtils.random(0, distanceX.end), 0));
        this.add(velocityComponent);

        return this;
    }

    public PlatformEntity velo_y(){
        distanceY = new Distance(0, -PlatformData.DISTANCE.DIST_Y);

        if(velocityComponent == null) velocityComponent = new VelocityComponent(this);
        velocityComponent.getVelo().y = -PlatformData.SPEED.VERTICAL;
        velocityComponent.setDistanceY(distanceY);
        transformComponent.addVelo(
                vTemp.set(0, (int) MathUtils.random(0, distanceY.end)));
        this.add(velocityComponent);

        return this;
    }

    public void addTransportable(int key, TransportableComponent transportableComponent){

        if(transporterComponent == null){
            transporterComponent = new TransporterComponent(this);
            transformComponent.moveSignal.add(MoveListener.inst());
            this.add(transporterComponent);
        }
        transporterComponent.add(key, transportableComponent);
    }
}
