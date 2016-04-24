package fr.icat.bunnyjump.listeners.state;

import com.badlogic.ashley.signals.Listener;
import com.badlogic.ashley.signals.Signal;
import fr.icat.bunnyjump.bag.EntityNewStateBag;
import fr.icat.bunnyjump.components.TransformComponent;
import fr.icat.bunnyjump.consts.Mapper;
import fr.icat.bunnyjump.data.CoinData;

/**
 * Fait tourner les pieces
 */
public final class CoinNewStateListener implements Listener<EntityNewStateBag>{

    private static CoinNewStateListener ourInstance = new CoinNewStateListener();

    public static CoinNewStateListener getInstance() {
        return ourInstance;
    }

    private CoinNewStateListener() {}

    // --

    @Override
    public void receive(Signal<EntityNewStateBag> signal, EntityNewStateBag bag) {

        TransformComponent transformComponent = Mapper.Transform.get(bag.entity);

        if(bag.newState.equals(CoinData.STATES.STATE1)){

            transformComponent.setSize(CoinData.SIZE.STATE1);
            transformComponent.flipX = false;
            transformComponent.addVelo(
                    CoinData.SIZE.STATE2.x - CoinData.SIZE.STATE1.x, 0);
        }
        else if(bag.newState.equals(CoinData.STATES.STATE2)
                || bag.newState.equals(CoinData.STATES.STATE6)){

            transformComponent.setSize(CoinData.SIZE.STATE2);

            if(bag.actualState.equals(CoinData.STATES.STATE1)) {
                transformComponent.flipX = false;
                transformComponent.addVelo(
                        CoinData.SIZE.STATE1.x - CoinData.SIZE.STATE2.x, 0);
            } else {
                transformComponent.flipX = true;
                transformComponent.addVelo(
                        CoinData.SIZE.STATE3.x - CoinData.SIZE.STATE2.x, 0);
            }
        }
        else if(bag.newState.equals(CoinData.STATES.STATE3)
                || bag.newState.equals(CoinData.STATES.STATE5)){

            transformComponent.setSize(CoinData.SIZE.STATE3);

            if(bag.actualState.equals(CoinData.STATES.STATE2)) {
                transformComponent.flipX = false;
                transformComponent.addVelo(
                        CoinData.SIZE.STATE2.x - CoinData.SIZE.STATE3.x, 0);
            } else {
                transformComponent.flipX = true;
                transformComponent.addVelo(
                        CoinData.SIZE.STATE4.x - CoinData.SIZE.STATE3.x, 0);
            }
        }
        else if(bag.newState.equals(CoinData.STATES.STATE4)) {
            transformComponent.setSize(CoinData.SIZE.STATE4);
            transformComponent.flipX = false;
            transformComponent.addVelo(
                    CoinData.SIZE.STATE3.x - CoinData.SIZE.STATE4.x, 0);
        }
    }
}
