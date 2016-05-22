package fr.icat.bunnyjump;

import com.badlogic.gdx.Game;
import fr.icat.bunnyjump.loaders.GameLoader;
import fr.icat.bunnyjump.screens.GameScreen;

public final class BunnyJump extends Game {

	@Override
	public void create () {

        GameLoader.load();

        this.setScreen(new GameScreen());
	}

	@Override
	public void render () {

        super.render();
	}

    @Override
    public void dispose() {

        GameLoader.dispose();
    }
}
