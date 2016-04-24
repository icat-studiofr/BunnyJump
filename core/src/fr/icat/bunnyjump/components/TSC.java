package fr.icat.bunnyjump.components;

import com.badlogic.ashley.core.Component;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.signals.Signal;
import com.badlogic.gdx.utils.ObjectMap;
import fr.icat.bunnyjump.bag.EntityNewStateBag;
import fr.icat.bunnyjump.bag.EntityNextStateBag;
import fr.icat.bunnyjump.consts.Mapper;
import fr.icat.bunnyjump.listeners.state.NextStateListener;
import fr.icat.bunnyjump.utils.tsco.TSCO;

/**
 * Associe une texture/animation à un état
 */
public final class TSC implements Component {

    public Signal<EntityNewStateBag> newStateSignal = new Signal<EntityNewStateBag>();

    EntityNextStateBag nextBag = new EntityNextStateBag();

    EntityNewStateBag newBag = new EntityNewStateBag();

    TextureComponent textureComponent;

    ObjectMap<Integer, TSCO> TSCOMap;

    TimerComponent timer;

    int state = -1;

    // --

    public TSC(Entity entity, ObjectMap<Integer, TSCO> TSCOMap, Integer state){
        this.textureComponent = Mapper.Texture.get(entity);
        this.timer = new TimerComponent(0, nextBag);
        this.timer.timerSignal.add(NextStateListener.inst());
        this.nextBag.entity = entity;
        this.newBag.entity = entity;
        this.TSCOMap = TSCOMap;

        entity.add(timer);

        this.setState(state);
    }

    public void setState(int state){

        if(this.state == state || !TSCOMap.containsKey(state)) return;

        final TSCO tsco = TSCOMap.get(state);

        if(this.state != -1) {
            this.newBag.actualState = this.state;
            this.newBag.newState = state;
            this.newStateSignal.dispatch(newBag);
        }

        this.state = state;
        this.textureComponent.texture = tsco.region;

        if(tsco.timerInfo != null){
            this.timer.time = tsco.timerInfo.time;
            this.nextBag.nextState = tsco.timerInfo.nextState;
            this.timer.provide = true;
        }
        else if(this.timer.provide){
            this.timer.provide = false;
        }
    }
}
