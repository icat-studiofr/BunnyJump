package fr.icat.bunnyjump.data;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ObjectMap;
import fr.icat.bunnyjump.consts.Mapper;
import fr.icat.bunnyjump.entities.monsters.SpringManEntity;
import fr.icat.bunnyjump.enums.MyRegions;
import fr.icat.bunnyjump.utils.Random;
import fr.icat.bunnyjump.utils.active.ActiveRandomPalier;
import fr.icat.bunnyjump.utils.tsco.TSCO;
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
import fr.icat.bunnyjump.utils.tsco.TSCOTimerInfo;

/**
 * Created by Romain on 10/04/2016.
 */
public final class SpringManData {

    public static final int DISTANCE = 2;

    public static final Rectangle MARGE = new Rectangle(0,3,0,0);

    public static final Vector2 SIZE = new Vector2(6, 7);

    public static final int LIFE = 1;

    public static final int SPEED = 12;

    /**
     * SECURE ZONE
     */
    public static final class SECURE_ZONE {

        public static final Rectangle STATIC = new Rectangle(
                0, -SIZE.y - MARGE.y, PlatformData.SIZE.W, SIZE.y + PlatformData.SIZE.H + MARGE.y);

        public static final Rectangle HORIZON = new Rectangle(
                0, -SIZE.y - MARGE.y, WorldData.SIZE.W, SIZE.y + PlatformData.SIZE.H + MARGE.y);
    }

    /**
     * STATE
     */
    public static final class STATE {

        public static final int SPRING_MAN1 = 1;
        public static final int SPRING_MAN2 = 2;

        public static final ObjectMap<Integer, TSCO> TEXTURE_STATE_MAP = new ObjectMap<Integer, TSCO>()
        {{
            this.put(SPRING_MAN1, new TSCO(
                    MyRegions.springMan_stand.getRegion(),
                    new TSCOTimerInfo(0.2f, SPRING_MAN2))
            );

            this.put(SPRING_MAN2, new TSCO(
                    MyRegions.springMan_hurt.getRegion(),
                    new TSCOTimerInfo(0.2f, SPRING_MAN1))
            );

        }};
    }

    /**
     * COLLISION
     */
    public static final class COLLISION {
        public static final Rectangle ATTACK = new Rectangle(0, 3, SIZE.x, SIZE.y - 3);
        public static final Rectangle PLATFORM = new Rectangle(0, 0, SIZE.x, 3);
        public static final Rectangle BUNNY_DEFENSE = PLATFORM;
        public static final Rectangle CARROT_DEFENSE = new Rectangle(0,0,SIZE.x,SIZE.y);
    }

    /**
     * TRANSPORTABLE
     */
    public static final Vector2 TRANSPORTABLE = new Vector2((PlatformData.SIZE.W - SIZE.x) / 2, -SIZE.y);

    /**
     * RANGE
     */
    public static final iPalier<iRange> RANGE = new Palier<iRange>(
            new Range((int)SIZE.y + (int)MARGE.y + PlatformData.SIZE.H,
                    PlatformData.SIZE.H, 0));

    /**
     * TARGET
     */
    public static final ComponentMapper TARGET = Mapper.PlatformCollision;

    /**
     * SAVE TARGET
     */
    public static final Array<ComponentMapper> SAVE_TARGET = new Array<ComponentMapper>() {{
        this.addAll(Mapper.PlatformCollision, Mapper.Platform);
    }};

    /**
     * SCORE
     */
    public static final class ACTIVE_SCORE {
        public static final iActiveScore STATIC = new ActiveScore(500);
        public static final iActiveScore HORIZON = new ActiveScore(700);
    }

    /**
     * RANDOM
     */
    public static final class ACTIVE_RANDOM {

        public static final iActiveRandom STATIC = new ActiveRandomPalier(
                new Palier<Random>(
                        new Random(7, ACTIVE_SCORE.STATIC.getScore()),
                        new Random(8, ACTIVE_SCORE.STATIC.getScore() * 3),
                        new Random(9, ACTIVE_SCORE.STATIC.getScore() * 4),
                        new Random(10, ACTIVE_SCORE.STATIC.getScore() * 5)
                )
        );

        public static final iActiveRandom HORIZON = new ActiveRandomPalier(
                new Palier<Random>(
                        new Random(5, ACTIVE_SCORE.HORIZON.getScore()),
                        new Random(6, ACTIVE_SCORE.HORIZON.getScore() * 3),
                        new Random(7, ACTIVE_SCORE.HORIZON.getScore() * 4),
                        new Random(8, ACTIVE_SCORE.HORIZON.getScore() * 5)
                )
        );
    }

    /**
     * BUILDER
     */
    public static final class BUILDER {

        public static final AbsBuilder STATIC = new AbsBuilder() {
            @Override
            public Entity build() {
                return new SpringManEntity().statique();
            }
        };

        public static final AbsBuilder HORIZON = new AbsBuilder() {
            @Override
            public Entity build() {
                return new SpringManEntity().horizontal();
            }
        };
    }

    /**
     * BUILDER PACK
     */
    public static final class BUILDER_PACK {

        public static final iBuilderPack STATIC = new BuilderPack(
                TARGET, RANGE, SAVE_TARGET, ACTIVE_RANDOM.STATIC,
                ACTIVE_SCORE.STATIC, SECURE_ZONE.STATIC, BUILDER.STATIC
        );

        public static final iBuilderPack HORIZON = new BuilderPack(
                TARGET, RANGE, SAVE_TARGET, ACTIVE_RANDOM.HORIZON,
                ACTIVE_SCORE.HORIZON, SECURE_ZONE.HORIZON, BUILDER.HORIZON
        );
    }
}
