package fr.icat.bunnyjump.entities.asset;

import com.badlogic.ashley.core.Entity;

import fr.icat.bunnyjump.components.BackgroundComponent;
import fr.icat.bunnyjump.components.TextureComponent;
import fr.icat.bunnyjump.components.TransformComponent;
import fr.icat.bunnyjump.data.WorldData;
import fr.icat.bunnyjump.enums.MyRegions;

/**
 * Created by Romain on 22/05/2016.
 */
public final class BackgroundEntity extends Entity {

    public BackgroundEntity(){

        this.add(new TextureComponent(MyRegions.BACKGROUND.getRegion()))
            .add(new TransformComponent(this, 0, WorldData.SIZE.VECTOR))
            .add(new BackgroundComponent());
    }
}
