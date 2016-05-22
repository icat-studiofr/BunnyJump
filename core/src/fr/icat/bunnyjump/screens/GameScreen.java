package fr.icat.bunnyjump.screens;

import com.badlogic.ashley.core.Engine;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import fr.icat.bunnyjump.data.BunnyData;
import fr.icat.bunnyjump.data.WorldData;
import fr.icat.bunnyjump.enums.MyRegions;
import fr.icat.bunnyjump.loaders.screens.AbsScreenLoader;
import fr.icat.bunnyjump.loaders.screens.GameScreenLoader;

public final class GameScreen extends ScreenAdapter {

    private Engine engine;
    private SpriteBatch batch;
    private OrthographicCamera camera;

    @Override
    public void show() {

        engine = new Engine();
        batch = new SpriteBatch();
        camera = new OrthographicCamera();
        camera.setToOrtho(true, WorldData.SIZE.W, WorldData.SIZE.H);

        new GameScreenLoader().load(engine, batch, camera);
    }

    @Override
    public void render(float delta) {

        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        /*batch.begin();
        batch.draw(MyRegions.bubble.getRegion(), 0, 0, 15, 15);
        batch.draw(MyRegions.bunny_jump.getRegion(), 15 / 2 - BunnyData.SIZE.W / 2, 15 / 2 - BunnyData.SIZE.H / 2, BunnyData.SIZE.W, BunnyData.SIZE.H);
        batch.end();*/
        engine.update(delta);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }
}
