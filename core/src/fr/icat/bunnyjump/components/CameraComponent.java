package fr.icat.bunnyjump.components;

import com.badlogic.ashley.core.Component;
import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.graphics.OrthographicCamera;

/**
 * Indique que l'entité est de type Camera
 */
public final class CameraComponent implements Component{

    /**
     * Cible de la camera
     */
    public Entity target;

    /**
     * Orthographique Camera
     */
    public OrthographicCamera camera;

    public CameraComponent(Entity target, OrthographicCamera camera){

        this.target = target;
        this.camera = camera;
    }

}
