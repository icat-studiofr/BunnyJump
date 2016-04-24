package fr.icat.bunnyjump.entities.power;

import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import fr.icat.bunnyjump.components.TextureComponent;
import fr.icat.bunnyjump.components.TransformComponent;
import fr.icat.bunnyjump.components.TransportableComponent;
import fr.icat.bunnyjump.data.WingData;
import fr.icat.bunnyjump.enums.MyRegions;

/**
 * Created by Romain on 11/04/2016.
 */
public final class WingEntity extends Entity {

    public WingEntity(boolean right) {

        TextureRegion textureRegion = null;
        if(!right) textureRegion = MyRegions.wing_left.getRegion();
        else textureRegion = MyRegions.wing_right.getRegion();

        Vector2 transportable = right ? WingData.TRANSPORTABLE.WING_RIGHT
                : WingData.TRANSPORTABLE.WING_LEFT;

        this.add(new TextureComponent(textureRegion))
            .add(new TransformComponent(this, WingData.Z, WingData.SIZE))
            .add(new TransportableComponent(this, transportable));

    }

}
