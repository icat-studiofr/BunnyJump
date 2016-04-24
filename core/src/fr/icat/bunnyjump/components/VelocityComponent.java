package fr.icat.bunnyjump.components;

import com.badlogic.ashley.core.Component;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.signals.Signal;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import fr.icat.bunnyjump.bag.ReverseBag;
import fr.icat.bunnyjump.utils.Distance;

/**
 * Vitesse de déplacement d'une entité par seconde
 */
public final class VelocityComponent implements Component {

    private Vector2 velo;

    private Distance distanceX;

    private Distance distanceY;

    private ReverseBag reverseBag = new ReverseBag();

    public Signal<ReverseBag> reverseXSignal = new Signal<ReverseBag>();

    public Signal<ReverseBag> reverseYSignal = new Signal<ReverseBag>();

    // --

    public VelocityComponent(Entity entity){
        this.velo = new Vector2(0,0);
        reverseBag.entity = entity;
    }

    public VelocityComponent(Entity entity, float x, float y){
        this.velo = new Vector2(x, y);
        this.reverseBag.entity = entity;
    }

    public VelocityComponent(Entity entity, float x, float y, Distance distX, Distance distY){
        this.velo = new Vector2(x,y);
        this.distanceX = distX;
        this.distanceY = distY;
        this.reverseBag.entity = entity;
    }

    // --

    public void setVelo(float x, float y){

        if(checkReverse(this.velo.x, x)){
            reverseBag.velo = x;
            this.reverseXSignal.dispatch(reverseBag);}

        if(checkReverse(this.velo.y, y)){
            reverseBag.velo = y;
            this.reverseYSignal.dispatch(reverseBag);}

        this.velo.set(x, y);
    }

    public void addVelo(float x, float y){
        float xbis = this.velo.x, ybis = this.velo.y;
        this.velo.add(x, y);

        if(this.checkReverse(xbis, this.velo.x)) {
            reverseBag.velo = this.velo.x;
            reverseXSignal.dispatch(reverseBag);}

        if(this.checkReverse(ybis, this.velo.y)) {
            reverseBag.velo = this.velo.y;
            reverseYSignal.dispatch(reverseBag);}
    }

    public void reverseX(){
        this.velo.x *= -1;
        reverseBag.velo = this.velo.x;
        this.reverseXSignal.dispatch(reverseBag);
    }

    public void reverseY(){
        this.velo.y *= -1;
        reverseBag.velo = this.velo.y;
        this.reverseYSignal.dispatch(reverseBag);
    }

    public void checkDistanceX(Vector3 pos){
        if(this.distanceX == null || !this.distanceX.check(pos.x)){ return; }
        pos.x = pos.x < distanceX.start ? distanceX.start : distanceX.end;
        this.reverseX();
    }

    public void checkDistanceY(Vector3 pos){
        if(this.distanceY == null || !this.distanceY.check(pos.y)){ return; }
        pos.y = pos.y > distanceY.start ? distanceY.start : distanceY.end;
        this.reverseY();
    }

    public void checkDistances(Vector3 pos){
        this.checkDistanceX(pos);
        this.checkDistanceY(pos);
    }

    private boolean checkReverse(float a, float b){
        if(a >= 0 && b < 0 || a < 0 && b >= 0){
            return true;
        }
        return false;
    }

    public Vector2 getVelo(){
        return this.velo;
    }

    public Distance getDistanceX() {
        return distanceX;
    }

    public Distance getDistanceY() {
        return distanceY;
    }

    public void setDistanceX(Distance distanceX) {
        this.distanceX = distanceX;
    }

    public void setDistanceY(Distance distanceY) {
        this.distanceY = distanceY;
    }
}
