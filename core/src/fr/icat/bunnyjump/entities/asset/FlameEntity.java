package fr.icat.bunnyjump.entities.asset;

import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.math.Vector2;
import fr.icat.bunnyjump.components.TextureComponent;
import fr.icat.bunnyjump.components.TransformComponent;
import fr.icat.bunnyjump.components.TransportableComponent;
import fr.icat.bunnyjump.data.JetpackData;
import fr.icat.bunnyjump.enums.MyRegions;

/**
 * Created by Romain on 11/04/2016.
 */
public final class FlameEntity extends Entity {

    public FlameEntity(Vector2 pos){

        this.add(new TextureComponent(MyRegions.flame.getRegion()))
            .add(new TransformComponent(this, JetpackData.Z, JetpackData.SIZE.FLAME))
            .add(new TransportableComponent(this, pos));
    }

}
