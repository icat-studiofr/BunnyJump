package fr.icat.bunnyjump.entities;

import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.math.Vector2;
import fr.icat.bunnyjump.components.CarrotComponent;
import fr.icat.bunnyjump.components.TextureComponent;
import fr.icat.bunnyjump.components.TransformComponent;
import fr.icat.bunnyjump.components.VelocityComponent;
import fr.icat.bunnyjump.components.collision.CarrotAttackCollisionComponent;
import fr.icat.bunnyjump.data.CarrotData;
import fr.icat.bunnyjump.enums.MyRegions;

/**
 * Created by Romain on 17/04/2016.
 */
public final class CarrotEntity extends Entity{

    public CarrotEntity(Vector2 startPos, float velo_x){

        TransformComponent transformComponent = new TransformComponent(this, CarrotData.Z, CarrotData.SIZE);
        transformComponent.pos.x = startPos.x;
        transformComponent.pos.y = startPos.y;

        VelocityComponent velocityComponent = new VelocityComponent(this,
                velo_x * 3f, -CarrotData.SPEED);

        this.add(new TextureComponent(MyRegions.carrot.getRegion()))
            .add(transformComponent)
            .add(new CarrotAttackCollisionComponent(
                    this, CarrotData.DEGAT, CarrotData.CARROT_ATTACK_COLLISION))
            .add(velocityComponent)
            .add(new CarrotComponent());
    }
}
