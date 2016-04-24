package fr.icat.bunnyjump.entities;

import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;
import fr.icat.bunnyjump.components.CameraComponent;
import fr.icat.bunnyjump.components.TextureComponent;
import fr.icat.bunnyjump.components.TransformComponent;
import fr.icat.bunnyjump.data.WorldData;
import fr.icat.bunnyjump.enums.MyRegions;

public final class CameraEntity extends Entity{

    private static CameraEntity ourInst = new CameraEntity();

    public static CameraEntity inst(){ return ourInst; }

    private CameraEntity(){}

    // -------------------------- //

    public Entity target;

    public OrthographicCamera camera;


    public CameraEntity init(Entity target, OrthographicCamera camera){

        this.removeAll();

        this.target = target;
        this.camera = camera;

        this.add(new CameraComponent(target, camera))
            .add(new TextureComponent(MyRegions.BACKGROUND.getRegion()))
            .add(new TransformComponent(this, 0, new Vector2(WorldData.SIZE.H, WorldData.SIZE.W)));

        return this;
    }
}
