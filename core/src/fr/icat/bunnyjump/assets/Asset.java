package fr.icat.bunnyjump.assets;

import com.badlogic.ashley.signals.Listener;
import com.badlogic.ashley.signals.Signal;

/**
 * Created by Romain on 24/03/2016.
 */
public final class Asset {

    public static <T> void dispatchSignal(Signal<T> signal, T obj){
        if(signal != null){
            signal.dispatch(obj);
        }
    }

    public static <T> void addListener(Signal<T> signal, Listener<T> listener){
        if(signal == null){
            signal = new Signal<T>();
        }
        signal.add(listener);
    }

}
