package fr.icat.bunnyjump.utils.active;

import fr.icat.bunnyjump.utils.Random;
import fr.icat.bunnyjump.utils.palier.iPalier;

/**
 * Created by Romain on 17/04/2016.
 */
public class ActiveRandomPalier implements iActiveRandom {

    iPalier<Random> randomPalier;

    public ActiveRandomPalier(iPalier<Random> randomPalier){
        this.randomPalier = randomPalier;
    }

    @Override
    public boolean isSuccess() {
        return randomPalier.get().check();
    }
}
