package fr.icat.bunnyjump.screens;

import com.badlogic.ashley.core.Engine;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import fr.icat.bunnyjump.data.BunnyData;
import fr.icat.bunnyjump.enums.MyRegions;
import fr.icat.bunnyjump.loaders.screens.AbsScreenLoader;

public final class GameScreen extends MyScreenAdaptateur {

    public GameScreen(
            Engine engine,
            SpriteBatch batch,
            OrthographicCamera camera,
            AbsScreenLoader screenLoader)
    {
        super(engine, batch, camera, screenLoader);
    }

    @Override
    public void show() {

        screenLoader.load(engine, batch, camera);
    }

    @Override
    public void render(float delta) {

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

    @Override
    public void hide() {

        screenLoader.deload(engine);
    }

    @Override
    public void dispose() {

    }
}
