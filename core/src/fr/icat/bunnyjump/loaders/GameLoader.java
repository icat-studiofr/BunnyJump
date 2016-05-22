package fr.icat.bunnyjump.loaders;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import fr.icat.bunnyjump.consts.PathConst;
import fr.icat.bunnyjump.enums.MyRegions;

/**
 * Chargement des ressources du jeu
 */
public final class GameLoader {

    static TextureAtlas textureAtlas;

    private static boolean exec = false;

    public static void load(){

        if(exec) return;

        textureAtlas = new TextureAtlas(Gdx.files.internal(PathConst.ATLAS));
        textureLoader(textureAtlas);

        exec = true;
    }

    /**
     * Charge les texture depuis le fichier atlas dans MyRegion
     * @param atlas
     */
    private static void textureLoader(final TextureAtlas atlas){

        for (MyRegions regionEnum :
                MyRegions.values()) {
            if (regionEnum.getRegion() == null) {
                regionEnum.setRegion(atlas.findRegion(regionEnum.name()));
            }
        }
    }

    /**
     * Dispose
     */
    public static void dispose() {
        textureAtlas.dispose();
        MyRegions.BACKGROUND.getRegion().getTexture().dispose();
    }

}
