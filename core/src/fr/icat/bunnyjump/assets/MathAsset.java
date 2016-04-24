package fr.icat.bunnyjump.assets;

import com.badlogic.gdx.math.MathUtils;

/**
 *
 */
public final class MathAsset {

    public static boolean percentRandom(int rand){

        if(rand < 1){
            return false;
        } else if(rand >= 100){
            return true;
        }
        return MathUtils.random(1, 100) <= rand;
    }
}
