package fr.icat.bunnyjump.components;

import com.badlogic.ashley.core.Component;

/**
 * Created by Romain on 16/04/2016.
 */
public final class CoinComponent implements Component {

    public int type;

    public CoinComponent(int type){
        this.type = type;
    }
}
