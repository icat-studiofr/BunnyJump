package fr.icat.bunnyjump.components;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * Texture Component
 */
public final class TextureComponent implements Component{

    /**
     * Texture */
    public TextureRegion texture;

    // ------------------------------------------------------------------------------------ //

    public TextureComponent(){}

    public TextureComponent(TextureRegion texture){
        this.texture = texture;
    }
}
