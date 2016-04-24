package fr.icat.bunnyjump.bag;

import com.badlogic.ashley.core.Entity;

/**
 * Created by Romain on 10/04/2016.
 */
public final class ResizeBag {

    public Entity entity;

    public float w;

    public float h;

    public ResizeBag(){}

    public ResizeBag(Entity entity, float w, float h){
        this.entity = entity;
        this.w = w;
        this.h = h;
    }

}
