package fr.icat.bunnyjump.components;

import com.badlogic.ashley.core.Component;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.signals.Listener;
import com.badlogic.ashley.signals.Signal;

/**
 * Composant qui donne un nombre de vie limité à une entité
 */
public final class LifeComponent implements Component {

    /* Ptn de vie */
    private int life;

    /* Entité parent */
    private Entity entity;

    /* Dead signal */
    public Signal<Entity> deadSignal = new Signal<Entity>();

    public LifeComponent(Entity entity, int life){
        this.life = life;
        this.entity = entity;
    }

    /**
     * Ajoute ptn de vie
     * @param lifePoint
     */
    public void addLifePoint(int lifePoint){
        this.life += lifePoint;
    }

    /**
     * Enleve point de vie
     * @param lifePoint
     */
    public void removeLifePoint(int lifePoint){
        this.life -= lifePoint;
        if(this.life <= 0) { deadSignal.dispatch(this.entity); }
    }

    /**
     * Détermine si l'entité est en vie
     * @return
     */
    public boolean isAlive(){
        return life > 0;
    }
}
