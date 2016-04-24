package fr.icat.bunnyjump.systems;

import com.badlogic.ashley.core.EntitySystem;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector3;

/**
 * Created by Romain on 17/04/2016.
 */
public final class InputSystem extends EntitySystem {

    OrthographicCamera camera;

    boolean isTouch = false;
    boolean isLastTouch = false;

    Vector3 v3 = new Vector3();

    public InputSystem(OrthographicCamera camera){
        this.camera = camera;
    }

    @Override
    public void update(float deltaTime) {
        this.isLastTouch = this.isTouch;
        this.isTouch = Gdx.input.isTouched();
    }

    public Vector3 getPressedPos(){
        if(!isTouch) return null;
        return camera.unproject(v3.set(Gdx.input.getX(), Gdx.input.getY(), 0));
    }

    public Vector3 getContinuePressedPos(){
        if(!isLastTouch && isTouch) {
            return camera.unproject(v3.set(Gdx.input.getX(), Gdx.input.getY(), 0));
        }
        return null;
    }
}
