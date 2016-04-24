package fr.icat.bunnyjump.components;

import com.badlogic.ashley.core.Component;

/**
 * L'entité sera touché par la Gravité.
 * A utiliser avec une entité gérant les colision (sinon chute infinie)
 */
public final class GravityComponent implements Component {

    public final static float GRAVITY = 110;
}
