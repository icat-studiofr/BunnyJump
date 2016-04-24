package fr.icat.bunnyjump.entities.power;

import com.badlogic.ashley.core.Entity;
import fr.icat.bunnyjump.components.TextureComponent;
import fr.icat.bunnyjump.components.TransformComponent;
import fr.icat.bunnyjump.components.TransportableComponent;
import fr.icat.bunnyjump.data.BubbleData;
import fr.icat.bunnyjump.enums.MyRegions;

/**
 * Created by Romain on 17/04/2016.
 */
public final class BubbleEntity extends Entity {

    public BubbleEntity(){

        this.add(new TextureComponent(MyRegions.bubble.getRegion()))
            .add(new TransformComponent(this, BubbleData.Z, BubbleData.SIZE))
            .add(new TransportableComponent(this, BubbleData.TRANSPORTABLE.BUBBLE));

    }
}
