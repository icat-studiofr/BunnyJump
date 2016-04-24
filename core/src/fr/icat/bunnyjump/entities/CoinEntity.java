package fr.icat.bunnyjump.entities;

import com.badlogic.ashley.core.Entity;
import fr.icat.bunnyjump.components.CoinComponent;
import fr.icat.bunnyjump.components.TSC;
import fr.icat.bunnyjump.components.TextureComponent;
import fr.icat.bunnyjump.components.TransformComponent;
import fr.icat.bunnyjump.components.collision.CoinCollisionComponent;
import fr.icat.bunnyjump.data.CoinData;
import fr.icat.bunnyjump.listeners.state.CoinNewStateListener;

/**
 * Created by Romain on 16/04/2016.
 */
public final class CoinEntity extends Entity{

    public CoinEntity(int type_coin){

        TSC tsc = null;

        this.add(new TextureComponent())
            .add(new TransformComponent(this, CoinData.Z, CoinData.SIZE.STATE1))
            .add(new CoinCollisionComponent(this, CoinData.COIN_COLLISION))
            .add(new CoinComponent(type_coin));

        if(type_coin == CoinData.TYPE.BRONZE){
            tsc = new TSC(this, CoinData.STATES.BRONZE_TEXTURE_STATE_MAP, CoinData.STATES.STATE1);
        } else if(type_coin == CoinData.TYPE.SILVER){
            tsc = new TSC(this, CoinData.STATES.SILVER_TEXTURE_STATE_MAP, CoinData.STATES.STATE1);
        } else if(type_coin == CoinData.TYPE.GOLD){
            tsc = new TSC(this, CoinData.STATES.GOLD_TEXTURE_STATE_MAP, CoinData.STATES.STATE1);
        }

        tsc.newStateSignal.add(CoinNewStateListener.getInstance());

        this.add(tsc);
    }

}
