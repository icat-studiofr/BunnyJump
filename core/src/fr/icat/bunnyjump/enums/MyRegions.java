package fr.icat.bunnyjump.enums;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import fr.icat.bunnyjump.consts.PathConst;

public enum MyRegions {

    BACKGROUND("background.png", true),

    /**
     * Bunny
     */
    bunny_dead,
    bunny_jump,
    bunny_stand,
    bunny_sky,

    /**
     * Platforms
     */
    platform,
    platform_broken,

    /**
     * Platform assets
     */
    spring,
    spring_out,
    spring_in,

    /**
     * Powerup
     */
    powerup_jetpack,
    powerup_wings,
    powerup_bubble,

    /**
     * Items
     */
    wing_left,
    wing_right,
    bubble,
    jetpack,
    flame,
    carrot,

    /**
     * Monsters
     */
    sun1,
    sun2,
    wingMan2,
    wingMan3,
    wingMan4,
    springMan_stand,
    springMan_hurt,
    flyMan_fly,
    flyMan_jump,
    flyMan_stand,

    /**
     * Coins
     */
    gold1,
    gold2,
    gold3,
    gold4,
    silver1,
    silver2,
    silver3,
    silver4,
    bronze1,
    bronze2,
    bronze3,
    bronze4;

    // ---

    private TextureRegion region;

    MyRegions(){}

    MyRegions(String path, boolean flip){
        region = new TextureRegion(new Texture(Gdx.files.internal(PathConst.TEXTURE + path)));
        region.flip(false, flip);
    }

    public TextureRegion getRegion(){
        return region;
    }

    public void setRegion(TextureRegion region){
        if(region == null) throw new NullPointerException(this.name() + " : region cannot be null");
        this.region = region;
        this.region.flip(false, true);
    }
}
