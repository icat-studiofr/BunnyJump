package fr.icat.bunnyjump.data;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import fr.icat.bunnyjump.consts.Mapper;
import fr.icat.bunnyjump.entities.power.powerup.BubblePowerEntity;
import fr.icat.bunnyjump.entities.power.powerup.JetpackPowerEntity;
import fr.icat.bunnyjump.entities.power.powerup.WingPowerEntity;
import fr.icat.bunnyjump.utils.active.ActiveRandom;
import fr.icat.bunnyjump.utils.active.ActiveScore;
import fr.icat.bunnyjump.utils.active.iActiveRandom;
import fr.icat.bunnyjump.utils.active.iActiveScore;
import fr.icat.bunnyjump.utils.builder.AbsBuilder;
import fr.icat.bunnyjump.utils.builder.BuilderPack;
import fr.icat.bunnyjump.utils.builder.iBuilderPack;
import fr.icat.bunnyjump.utils.palier.Palier;
import fr.icat.bunnyjump.utils.palier.iPalier;
import fr.icat.bunnyjump.utils.range.Range;
import fr.icat.bunnyjump.utils.range.iRange;

/**
 * Created by Romain on 09/04/2016.
 */
public final class PowerData {

    public static final int Z = 45;

    public static final Rectangle SECURE_ZONE = new Rectangle(-3,-3,SIZE.W+3, SIZE.H+3);

    /**
     * SIZE
     */
    public static class SIZE {
        public static final int W = 8;
        public static final int H = 6;
        public static final Vector2 VECTOR = new Vector2(W, H);
    }

    /**
     * COLLISION
     */
    public static final Rectangle POWER_COLLISION = new Rectangle(0,0,SIZE.W,SIZE.H);

    /**
     * RANGE
     */
    public static final iPalier<iRange> RANGES = new Palier<iRange>(
            new Range((int)SECURE_ZONE.height + 6, PlatformData.SIZE.H, 0)
    );

    /**
     * TARGET
     */
    public static ComponentMapper TARGET = Mapper.PlatformCollision;

    public static final Array<ComponentMapper> SAVE_TARGET = null;

    /**
     * ACTUVE SCORE
     */
    public static class ACTIVE_SCORE {
        public static final iActiveScore JETPACK = new ActiveScore(1000);
        public static final iActiveScore WING = new ActiveScore(500);
        public static final iActiveScore BUBBLE = new ActiveScore(300);
    }

    /**
     * ACTIVE RANDOM
     */
    public static class ACTIVE_RANDOM {
        public static final iActiveRandom JETPACK = new ActiveRandom(2);
        public static final iActiveRandom WING = new ActiveRandom(3);
        public static final iActiveRandom BUBBLE = new ActiveRandom(4);
    }

    /**
     * BUILDER
     */
    public static final class BUILDER {
        public static final AbsBuilder JETPACK = new AbsBuilder() {
            @Override
            public Entity build() {
                return new JetpackPowerEntity();
            }
        };
        public static final AbsBuilder WING = new AbsBuilder() {
            @Override
            public Entity build() {
                return new WingPowerEntity();
            }
        };
        public static final AbsBuilder BUBBLE = new AbsBuilder() {
            @Override
            public Entity build() {
                return new BubblePowerEntity();
            }
        };
    }

    /**
     * BUILDER PACK
     */
    public static final class BUILDER_PACK {

        public static final iBuilderPack JETPACK = new BuilderPack(
            TARGET, RANGES, SAVE_TARGET, ACTIVE_RANDOM.JETPACK, ACTIVE_SCORE.JETPACK,
            SECURE_ZONE, BUILDER.JETPACK
        );

        public static final iBuilderPack WING = new BuilderPack(
                TARGET, RANGES, SAVE_TARGET, ACTIVE_RANDOM.WING, ACTIVE_SCORE.WING,
                SECURE_ZONE, BUILDER.WING
        );
        public static final iBuilderPack BUBBLE = new BuilderPack(
                TARGET, RANGES, SAVE_TARGET, ACTIVE_RANDOM.BUBBLE, ACTIVE_SCORE.BUBBLE,
                SECURE_ZONE, BUILDER.BUBBLE
        );
    }
}

