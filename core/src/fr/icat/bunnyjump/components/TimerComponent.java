package fr.icat.bunnyjump.components;

import com.badlogic.ashley.core.Component;
import com.badlogic.ashley.signals.Signal;

/**
 * Created by Romain on 09/04/2016.
 */
public final class TimerComponent implements Component{

    public Signal<Object> timerSignal = new Signal<Object>();

    public boolean provide;

    public boolean kill;

    public float time;

    public float temp;

    public Object data; // envoyé par le signal

    // --

    public TimerComponent(float time){ this.time = time; }

    public TimerComponent(float time, Object data){ this.time = time; this.data = data; }

    public TimerComponent(float time, Object data, boolean provide){
        this.provide = provide;
        this.data = data;
        this.time = time;
    }
}
