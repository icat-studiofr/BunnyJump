package fr.icat.bunnyjump.loaders;

import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.EntitySystem;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import fr.icat.bunnyjump.consts.PathConst;
import fr.icat.bunnyjump.enums.MyRegions;
import fr.icat.bunnyjump.enums.MyScreens;
import fr.icat.bunnyjump.listeners.MyEntityListener;
import fr.icat.bunnyjump.listeners.power.added.BubblePowerAddedListener;
import fr.icat.bunnyjump.listeners.power.added.JetpackPowerAddedListener;
import fr.icat.bunnyjump.listeners.power.added.WingPowerAddedListener;
import fr.icat.bunnyjump.listeners.power.removed.JetpackPowerRemovedListener;
import fr.icat.bunnyjump.loaders.screens.GameScreenLoader;
import fr.icat.bunnyjump.screens.GameScreen;
import fr.icat.bunnyjump.systems.AccelSystem;
import fr.icat.bunnyjump.systems.BunnyAttackSystem;
import fr.icat.bunnyjump.systems.BunnyJumpSystem;
import fr.icat.bunnyjump.systems.BunnySystem;
import fr.icat.bunnyjump.systems.CameraSystem;
import fr.icat.bunnyjump.systems.CarrotAttackCollisionSystem;
import fr.icat.bunnyjump.systems.CarrotAttackSystem;
import fr.icat.bunnyjump.systems.ClearSystem;
import fr.icat.bunnyjump.systems.CoinCollisionSystem;
import fr.icat.bunnyjump.systems.GravitySystem;
import fr.icat.bunnyjump.systems.InputSystem;
import fr.icat.bunnyjump.systems.PlatformCollisionSystem;
import fr.icat.bunnyjump.systems.MonsterAttackSystem;
import fr.icat.bunnyjump.systems.PowerCollisionSystem;
import fr.icat.bunnyjump.systems.RenderSystem;
import fr.icat.bunnyjump.systems.SpawnerSystem;
import fr.icat.bunnyjump.systems.SpringSystem;
import fr.icat.bunnyjump.systems.TimeLifeSystem;
import fr.icat.bunnyjump.systems.TimerSystem;
import fr.icat.bunnyjump.systems.VelocitySystem;

/**
 * Chargement des ressources du jeu
 */
public final class GameLoader {

    private static boolean exec = false;

    public static void load(Engine e, SpriteBatch b, OrthographicCamera c){

        if(exec) return;

        textureLoader(new TextureAtlas(Gdx.files.internal(PathConst.ATLAS)));
        addScreen(e, b, c);
        addSystems(e, b, c);
        addEntityListeners(e);
        initListeners(e);

        exec = true;
    }

    /**
     * Instanciation des Screen
     * @param e Moteur
     * @param b Batch
     * @param c Camera
     */
    private static void addScreen(Engine e, SpriteBatch b, OrthographicCamera c){

        MyScreens.GAME.setScreen(new GameScreen(e, b, c, new GameScreenLoader()));
    }

    /**
     * Instanciation des System
     * @param e Moteur
     * @param b Batch
     * @param c Camera
     */
    private static void addSystems(Engine e, SpriteBatch b, OrthographicCamera c){

        SpawnerSystem spawnerSystem = new SpawnerSystem();
        InputSystem inputSystem = new InputSystem(c);

        e.addSystem(spawnerSystem);
        e.addSystem(inputSystem);

        e.addSystem(new BunnySystem());
        e.addSystem(new SpringSystem());
        e.addSystem(new CarrotAttackSystem(inputSystem));
        e.addSystem(new AccelSystem());

        e.addSystem(new GravitySystem());
        e.addSystem(new VelocitySystem());
        e.addSystem(new BunnyJumpSystem(c, spawnerSystem));

        e.addSystem(new TimerSystem());
        e.addSystem(new TimeLifeSystem());
        e.addSystem(new ClearSystem(c));

        e.addSystem(new RenderSystem(b));

        e.addSystem(new BunnyAttackSystem());
        e.addSystem(new MonsterAttackSystem());
        e.addSystem(new CarrotAttackCollisionSystem());
        e.addSystem(new PlatformCollisionSystem());
        e.addSystem(new PowerCollisionSystem());
        e.addSystem(new CoinCollisionSystem());

        for (EntitySystem s :
            e.getSystems()) {
            s.setProcessing(false);
        }
    }

    public static void addEntityListeners(Engine e){

        e.addEntityListener(new MyEntityListener(e));
    }

    public static void initListeners(Engine e){

        JetpackPowerRemovedListener.inst().setEngine(e);
        JetpackPowerAddedListener.inst().setEngine(e);
        WingPowerAddedListener.inst().setEngine(e);
        BubblePowerAddedListener.inst().setEngine(e);
    }

    /**
     * Charge les texture depuis le fichier atlas dans MyRegion
     * @param atlas
     */
    private static void textureLoader(final TextureAtlas atlas){

        for (MyRegions regionEnum :
                MyRegions.values()) {
            if (regionEnum.getRegion() == null) {
                regionEnum.setRegion(atlas.findRegion(regionEnum.name()));
            }
        }
    }
}
