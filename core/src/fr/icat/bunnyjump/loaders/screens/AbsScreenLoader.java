package fr.icat.bunnyjump.loaders.screens;

import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.EntitySystem;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;

/**
 * Comportement que doit avoir tout Screen
 */
public abstract class AbsScreenLoader {

    /**
     * Class des systems utilisés par le screen
     */
    private Array<Class<? extends EntitySystem>> classSystems;

    public AbsScreenLoader(){
        this.classSystems = new Array<Class<? extends EntitySystem>>();
        this.init();
    }

    /**
     * A override pour chaque screen, permet d'ajouter des systems à l'instanciation du screen
     */
    protected abstract void init();

    /**
     * A override pout chaque screen, permet d'ajouter des entités au moteur, à appeller
     * dans la méthode Show() du screen
     * @param e Moteur
     * @param b SpriteBatch
     * @param c Camera
     */
    protected abstract void addEntities(Engine e, SpriteBatch b, OrthographicCamera c);

    /**
     * Ajoute une classe à la liste
     */
    protected void addSystem(final Class<? extends EntitySystem>... clazz){
        this.classSystems.addAll(clazz);
    }

    /**
     * Désactive les systems utilisés par le screen et supprime toute les entités du moteur.
     * A appeler dans la méthode Hide() du screen
     * @param e Moteur
     */
    public void deload(final Engine e){

        setProcessing(e, false);
        e.removeAllEntities();
    }

    /**
     * Méthode à executer dans la méthode show du screen, active les systems et ajoute les entités
     * au moteur
     * @param e Moteur
     * @param b SpriteBatch
     * @param c Camera
     */
    public void load(Engine e, SpriteBatch b, OrthographicCamera c){

        setProcessing(e, true);
        addEntities(e, b, c);
    }

    /**
     * Modifier le processing de tous les systems utilisé par le screen
     * @param e Moteur
     * @param process bool isProcess
     */
    private void setProcessing(final Engine e, final boolean process){

        for (Class<? extends EntitySystem> s :
                classSystems) {
            e.getSystem(s).setProcessing(process);
        }
    }

}
