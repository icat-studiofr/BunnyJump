package fr.icat.bunnyjump.loaders.screens;

import com.badlogic.ashley.core.Engine;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import fr.icat.bunnyjump.entities.BunnyEntity;
import fr.icat.bunnyjump.entities.asset.BackgroundEntity;
import fr.icat.bunnyjump.listeners.MyEntityListener;
import fr.icat.bunnyjump.listeners.power.added.BubblePowerAddedListener;
import fr.icat.bunnyjump.listeners.power.added.JetpackPowerAddedListener;
import fr.icat.bunnyjump.listeners.power.added.WingPowerAddedListener;
import fr.icat.bunnyjump.listeners.power.removed.JetpackPowerRemovedListener;
import fr.icat.bunnyjump.systems.AccelSystem;
import fr.icat.bunnyjump.systems.BunnyAttackSystem;
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
import fr.icat.bunnyjump.systems.TimerSystem;
import fr.icat.bunnyjump.systems.VelocitySystem;

/**
 * Game Screen Loader */
public final class GameScreenLoader extends AbsScreenLoader {

    @Override
    protected void addEntities(Engine e, SpriteBatch b, OrthographicCamera c) {

        e.addEntity(new BunnyEntity());
        e.addEntity(new BackgroundEntity());
    }

    @Override
    protected void addSystems(Engine e, SpriteBatch b, OrthographicCamera c) {

        SpawnerSystem spawnerSystem = new SpawnerSystem(c);
        InputSystem inputSystem = new InputSystem(c);

        e.addSystem(spawnerSystem);
        e.addSystem(inputSystem);

        e.addSystem(new BunnySystem(c));
        e.addSystem(new SpringSystem());
        e.addSystem(new CarrotAttackSystem(inputSystem));
        e.addSystem(new AccelSystem());

        e.addSystem(new GravitySystem());
        e.addSystem(new VelocitySystem());

        e.addSystem(new TimerSystem());
        e.addSystem(new ClearSystem(c));

        e.addSystem(new CameraSystem(c));
        e.addSystem(new RenderSystem(b, c));

        e.addSystem(new BunnyAttackSystem());
        e.addSystem(new MonsterAttackSystem());
        e.addSystem(new CarrotAttackCollisionSystem());
        e.addSystem(new PlatformCollisionSystem());
        e.addSystem(new PowerCollisionSystem());
        e.addSystem(new CoinCollisionSystem());
    }

    @Override
    protected void addEntityListeners(Engine e){

        e.addEntityListener(new MyEntityListener(e));
    }

    @Override
    protected void initListeners(Engine e){

        JetpackPowerRemovedListener.inst().setEngine(e);
        JetpackPowerAddedListener.inst().setEngine(e);
        WingPowerAddedListener.inst().setEngine(e);
        BubblePowerAddedListener.inst().setEngine(e);
    }
}
