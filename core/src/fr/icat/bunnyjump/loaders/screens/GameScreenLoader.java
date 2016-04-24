package fr.icat.bunnyjump.loaders.screens;

import com.badlogic.ashley.core.Engine;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import fr.icat.bunnyjump.entities.BunnyEntity;
import fr.icat.bunnyjump.entities.CameraEntity;
import fr.icat.bunnyjump.systems.AccelSystem;
import fr.icat.bunnyjump.systems.BunnyAttackSystem;
import fr.icat.bunnyjump.systems.BunnyJumpSystem;
import fr.icat.bunnyjump.systems.BunnySystem;
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
 * Game Screen Loader */
public final class GameScreenLoader extends AbsScreenLoader {

    @Override
    protected void init() {

        this.addSystem(
                GravitySystem.class,
                VelocitySystem.class,
                RenderSystem.class,
                PlatformCollisionSystem.class,
                SpawnerSystem.class,
                BunnySystem.class,
                ClearSystem.class,
                BunnyAttackSystem.class,
                TimeLifeSystem.class,
                SpringSystem.class,
                TimerSystem.class,
                MonsterAttackSystem.class,
                BunnyJumpSystem.class,
                PowerCollisionSystem.class,
                CoinCollisionSystem.class,
                InputSystem.class,
                CarrotAttackSystem.class,
                CarrotAttackCollisionSystem.class,
                AccelSystem.class
        );
    }

    @Override
    protected void addEntities(Engine e, SpriteBatch b, OrthographicCamera c) {

        e.addEntity(BunnyEntity.inst().init());
        e.addEntity(CameraEntity.inst().init(BunnyEntity.inst(), c));
    }
}
