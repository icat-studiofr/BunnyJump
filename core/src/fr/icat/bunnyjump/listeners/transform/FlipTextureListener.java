package fr.icat.bunnyjump.listeners.transform;

import com.badlogic.ashley.signals.Listener;
import com.badlogic.ashley.signals.Signal;
import fr.icat.bunnyjump.components.TransformComponent;
import fr.icat.bunnyjump.consts.Mapper;
import fr.icat.bunnyjump.bag.ReverseBag;

/**
 * Created by Romain on 26/03/2016.
 */
public final class FlipTextureListener implements Listener<ReverseBag> {

    private static FlipTextureListener stock = new FlipTextureListener();

    public static FlipTextureListener inst() {
        return stock;
    }

    private FlipTextureListener() {}

    // --

    @Override
    public void receive(Signal<ReverseBag> signal, ReverseBag bag) {

        if(bag.entity == null || bag.velo == null){ return; }

        final TransformComponent transformComponent = Mapper.Transform.get(bag.entity);

        if(transformComponent == null) { return; }

        transformComponent.flipX = !transformComponent.flipX;
    }
}
