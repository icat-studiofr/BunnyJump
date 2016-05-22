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
     * A override pout chaque screen, permet d'ajouter des entités au moteur, à appeller
     * dans la méthode Show() du screen
     * @param e Moteur
     * @param b SpriteBatch
     * @param c Camera
     */
    protected abstract void addEntities(Engine e, SpriteBatch b, OrthographicCamera c);

    /**
     * Ajoute les systems au moteur
     * @param e
     * @param b
     * @param c
     */
    protected abstract void addSystems(Engine e, SpriteBatch b, OrthographicCamera c);

    /**
     * Ajoute un entityListener au moteur
     * @param e
     */
    protected abstract void addEntityListeners(Engine e);

    /**
     * Initialise les listeners qui doivent l'être
     * @param e
     */
    protected abstract void initListeners(Engine e);

    /**
     * Méthode à executer dans la méthode show du screen, active les systems et ajoute les entités
     * au moteur
     * @param e Moteur
     * @param b SpriteBatch
     * @param c Camera
     */
    public void load(Engine e, SpriteBatch b, OrthographicCamera c){

        addEntities(e, b, c);
        addSystems(e, b, c);
        addEntityListeners(e);
        initListeners(e);
    }

}
