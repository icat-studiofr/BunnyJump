package fr.icat.bunnyjump.entities;

import com.badlogic.ashley.core.Entity;
import fr.icat.bunnyjump.components.SpringComponent;
import fr.icat.bunnyjump.components.TextureComponent;
import fr.icat.bunnyjump.components.TransformComponent;
import fr.icat.bunnyjump.components.TransportableComponent;
import fr.icat.bunnyjump.components.collision.PlatformCollisionComponent;
import fr.icat.bunnyjump.components.TSC;
import fr.icat.bunnyjump.data.PlatformData;
import fr.icat.bunnyjump.data.SpringData;
import fr.icat.bunnyjump.listeners.collision.SpringPlatformCollisionListener;
import fr.icat.bunnyjump.listeners.state.SpringNewStateListener;

/**
 * Created by Romain on 27/03/2016.
 */
public final class SpringEntity extends Entity{

    TransportableComponent transportable;

    public SpringEntity(){

        transportable = new TransportableComponent(this, SpringData.TRANSPORTABLE.PLATFORM);

        PlatformCollisionComponent collisionComponent
                = new PlatformCollisionComponent(
                        this, SpringData.COLLISION.PLATFORM, SpringData.SPEED.BONUS_PLATFORM_COL);
        collisionComponent.collisionSignal.add(SpringPlatformCollisionListener.inst());

        this.add(new SpringComponent())
            .add(new TextureComponent())
            .add(new TransformComponent(this, SpringData.Z, SpringData.SIZE.VECTOR))
            .add(collisionComponent)
            .add(transportable);

        TSC tsc = new TSC(this, SpringData.STATES.TEXTURE_STATE_MAP, SpringData.STATES.SPRING);
        tsc.newStateSignal.add(SpringNewStateListener.inst());

        this.add(tsc);
    }

    public PlatformEntity statique(){
        PlatformEntity pEntity = new PlatformEntity(false);
        pEntity.addTransportable(PlatformData.TRANSPORTER.SPRING, transportable);
        return pEntity;
    }

}
