package fr.icat.bunnyjump.utils.tsco;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * Created by Romain on 09/04/2016.
 */
public final class TSCO {

    public TextureRegion region;

    public TSCOTimerInfo timerInfo;

    public TSCO(TextureRegion region){
        this.region = region;
    }

    public TSCO(TextureRegion region, TSCOTimerInfo timerInfo) {
        this.region = region;
        this.timerInfo = timerInfo;
    }
}
