package fr.icat.bunnyjump.utils.active;

import fr.icat.bunnyjump.assets.MathAsset;

/**
 * Définit une classe ayant une chance d'activation
 */
public class ActiveRandom implements iActiveRandom {

    public static final iActiveRandom ActiveRandomZero = new ActiveRandom(0);
    public static final iActiveRandom ActiveRandomCent = new ActiveRandom();

    int rand = 100;

    public ActiveRandom(){}

    public ActiveRandom(int rand){
        this.setRand(rand);
    }

    public void setRand(int rand) {

        if(rand > 100){
            rand = 100;
        } else if(rand < 0){
            rand = 0;
        }
        this.rand = rand;
    }

    @Override
    public boolean isSuccess() {
        return MathAsset.percentRandom(rand);
    }
}
