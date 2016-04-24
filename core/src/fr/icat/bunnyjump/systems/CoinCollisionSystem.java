package fr.icat.bunnyjump.systems;

import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import fr.icat.bunnyjump.components.CoinComponent;
import fr.icat.bunnyjump.components.collision.BankerCollisionComponent;
import fr.icat.bunnyjump.components.collision.CoinCollisionComponent;
import fr.icat.bunnyjump.consts.Mapper;
import fr.icat.bunnyjump.data.CoinData;

/**
 * Created by Romain on 16/04/2016.
 */
public final class CoinCollisionSystem extends AbsCollisionSystem {

    BankerCollisionComponent bankerCollisionComponent;
    CoinComponent coinComponent;

    public CoinCollisionSystem() {
        super(Family.all(BankerCollisionComponent.class).get(), Mapper.BankerCollision, Mapper.CoinCollision);
    }

    @Override
    public void addedToEngine(Engine engine) {
        super.addedToEngine(engine);
        passiveEntities = engine.getEntitiesFor(Family.all(CoinCollisionComponent.class, CoinComponent.class).get());
    }

    @Override
    public boolean collision(Entity aEntity, Entity pEntity) {
        coinComponent = Mapper.Coin.get(pEntity);

        if(coinComponent.type == CoinData.TYPE.BRONZE){
            bankerCollisionComponent.bronze++;
        } else if(coinComponent.type == CoinData.TYPE.SILVER){
            bankerCollisionComponent.silver++;
        } else if(coinComponent.type == CoinData.TYPE.GOLD){
            bankerCollisionComponent.gold++;
        }

        getEngine().removeEntity(pEntity);
        return true;
    }

    @Override
    public void init() {
        bankerCollisionComponent = (BankerCollisionComponent)activeCollisionComponent;
    }
}
