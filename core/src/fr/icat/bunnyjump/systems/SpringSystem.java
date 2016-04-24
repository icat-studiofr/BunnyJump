package fr.icat.bunnyjump.systems;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import fr.icat.bunnyjump.components.SpringComponent;

/**
 * Created by Romain on 22/03/2016.
 */
public final class SpringSystem extends IteratingSystem {


    public SpringSystem() {
        super(Family.all(SpringComponent.class).get());
    }

    @Override
    protected void processEntity(Entity entity, float deltaTime) {

    }
}
