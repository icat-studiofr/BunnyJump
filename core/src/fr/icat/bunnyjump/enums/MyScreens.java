package fr.icat.bunnyjump.enums;

import com.badlogic.gdx.Screen;
import fr.icat.bunnyjump.loaders.screens.AbsScreenLoader;

/**
 * Created by Romain on 05/02/2016.
 */
public enum MyScreens {

    GAME,
    MENU;

    // ---

    private Screen screen;

    public void setScreen(Screen screen){
        this.screen = screen;
    }

    public Screen getScreen(){
        return this.screen;
    }
}
