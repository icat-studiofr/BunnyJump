package fr.icat.bunnyjump.screens;

import com.badlogic.ashley.core.Engine;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import fr.icat.bunnyjump.loaders.screens.AbsScreenLoader;

/**
 *  */
public abstract class MyScreenAdaptateur extends ScreenAdapter {

    final Engine engine;
    final SpriteBatch batch;
    final OrthographicCamera camera;
    final AbsScreenLoader screenLoader;

    public MyScreenAdaptateur(
            Engine engine,
            SpriteBatch batch,
            OrthographicCamera camera,
            AbsScreenLoader screenLoader)
    {
        this.batch = batch;
        this.camera = camera;
        this.engine = engine;
        this.screenLoader = screenLoader;
    }
}
