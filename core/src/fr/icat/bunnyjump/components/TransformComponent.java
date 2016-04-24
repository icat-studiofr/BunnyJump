package fr.icat.bunnyjump.components;

import com.badlogic.ashley.core.Component;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.signals.Signal;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import fr.icat.bunnyjump.bag.EntityMoveBag;
import fr.icat.bunnyjump.bag.ResizeBag;

/**
 * Component qui stocke les données liées à l'affichage de l'entité
 */
public final class TransformComponent implements Component {

    public Vector3 pos = new Vector3();

    public Vector2 size = new Vector2();

    public Vector2 scale = new Vector2(1, 1);

    public int rotation = 0;

    public boolean flipX = false;

    public Signal moveSignal = new Signal();

    public Signal resizeSignal = new Signal();

    public EntityMoveBag entityMoveBag = new EntityMoveBag();

    public ResizeBag resizeBag = new ResizeBag();

    // --

    public TransformComponent(Entity parent, int z){
        pos.z = z;
        this.entityMoveBag.entity = parent;
        this.resizeBag.entity = parent;
    }

    public TransformComponent(Entity parent, int z, Vector2 size){
        this.entityMoveBag.entity = parent;
        this.resizeBag.entity = parent;
        this.pos.z = z;
        this.size = new Vector2(size);
    }

    public TransformComponent(Entity parent, Vector3 pos, Vector2 size) {
        this.entityMoveBag.entity = parent;
        this.resizeBag.entity = parent;
        this.pos = pos;
        this.size = new Vector2(size);
    }

    public TransformComponent(Entity parent, Vector3 pos, Vector2 size, Vector2 scale, int rotation){
        this.scale = new Vector2(scale);
        this.size = new Vector2(size);
        this.pos = new Vector3(pos);
        this.rotation = rotation;
        this.entityMoveBag.entity = parent;
        this.resizeBag.entity = parent;
    }

    // --

    public void addVelo(Vector2 velo){
        this.pos.x += velo.x;
        this.pos.y += velo.y;

        entityMoveBag.x = velo.x;
        entityMoveBag.y = velo.y;
        this.moveSignal.dispatch(entityMoveBag);
    }

    public void addVelo(float x, float y){
        this.pos.x += x;
        this.pos.y += y;

        entityMoveBag.x = x;
        entityMoveBag.y = y;
        this.moveSignal.dispatch(entityMoveBag);
    }

    public void setPos(Vector2 velo) {
        this.addVelo(velo.x - pos.x, velo.y - pos.y);
    }

    public void setPos(float x, float y) {
        this.addVelo(x - pos.x, y - pos.y);
    }

    public void addSize(float w, float h){
        this.size.add(w, h);
        this.resizeBag.w = w;
        this.resizeBag.h = h;
        resizeSignal.dispatch(resizeBag);
    }

    public void setSize(Vector2 size){
        if(this.size.equals(size)) return;
        this.size.set(size);
        this.resizeBag.w = size.x;
        this.resizeBag.h = size.y;
        resizeSignal.dispatch(resizeBag);
    }
}
