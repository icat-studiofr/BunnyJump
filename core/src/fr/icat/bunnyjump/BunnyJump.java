package fr.icat.bunnyjump;

import com.badlogic.ashley.core.Engine;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import fr.icat.bunnyjump.data.WorldData;
import fr.icat.bunnyjump.enums.MyScreens;
import fr.icat.bunnyjump.loaders.GameLoader;

public final class BunnyJump extends Game {

    OrthographicCamera camera;
    SpriteBatch batch;
    Engine engine;

	@Override
	public void create () {
        engine = new Engine();
        camera = new OrthographicCamera();
        camera.setToOrtho(true, WorldData.SIZE.W, WorldData.SIZE.H);
        batch = new SpriteBatch();

        GameLoader.load(engine, batch, camera);

        this.setScreen(MyScreens.GAME.getScreen());
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();
        batch.setProjectionMatrix(camera.combined);

        super.render();
	}
}
