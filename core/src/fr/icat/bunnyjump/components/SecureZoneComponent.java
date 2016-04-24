package fr.icat.bunnyjump.components;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import fr.icat.bunnyjump.utils.Marge;

/**
 * Marge d'une entité à la position 0 en cas de mouvement (dist.temp = 0)
 */
public final class SecureZoneComponent implements Component{

    private Marge marge;

    // --

    public SecureZoneComponent(Marge marge){
        this.marge = marge;
    }

    // --

    public Rectangle getSecureZone(Vector3 pos, Vector2 size){
        return marge.merge(pos, size);
    }
}
