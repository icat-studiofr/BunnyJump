package fr.icat.bunnyjump.entities.power.powerup;

import com.badlogic.ashley.core.Entity;
import fr.icat.bunnyjump.components.PowerComponent;
import fr.icat.bunnyjump.components.TextureComponent;
import fr.icat.bunnyjump.components.TransformComponent;
import fr.icat.bunnyjump.components.collision.PowerCollisionComponent;
import fr.icat.bunnyjump.data.BubbleData;
import fr.icat.bunnyjump.data.PowerData;
import fr.icat.bunnyjump.enums.MyRegions;

/**
 * Created by Romain on 10/04/2016.
 */
public final class BubblePowerEntity extends Entity {

    public BubblePowerEntity(){

        this.add(new PowerComponent())
                .add(new TransformComponent(this, PowerData.Z, PowerData.SIZE.VECTOR))
                .add(new TextureComponent(MyRegions.powerup_bubble.getRegion()))
                .add(new PowerCollisionComponent(
                        this, PowerData.POWER_COLLISION, BubbleData.TIME_LIFE,
                        BubbleData.COMPONENT_TO_REMOVE, BubbleData.ADDED_LISTENER,
                        BubbleData.REMOVED_LISTENER));
    }
}
