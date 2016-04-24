package fr.icat.bunnyjump.listeners.transform;

import com.badlogic.ashley.signals.Listener;
import com.badlogic.ashley.signals.Signal;
import com.badlogic.gdx.utils.Array;
import fr.icat.bunnyjump.assets.ComponentUtil;
import fr.icat.bunnyjump.bag.ResizeBag;
import fr.icat.bunnyjump.components.collision.AbsCollisionComponent;

/**
 *
 */
public final class ResizeListener implements Listener<ResizeBag> {

    private static ResizeListener ourInstance = new ResizeListener();

    public static ResizeListener inst() {
        return ourInstance;
    }

    private ResizeListener() {}

    // --

    @Override
    public void receive(Signal<ResizeBag> signal, ResizeBag bag) {

        final Array<AbsCollisionComponent> colCompArray
                = ComponentUtil.search(bag.entity, AbsCollisionComponent.class);

        for (AbsCollisionComponent comp :
                colCompArray) {
            comp.area.width += bag.w;
            comp.area.height += bag.h;
        }
    }
}
