package fr.icat.bunnyjump.data;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import fr.icat.bunnyjump.consts.Mapper;
import fr.icat.bunnyjump.entities.PlatformEntity;
import fr.icat.bunnyjump.utils.Random;
import fr.icat.bunnyjump.utils.Speed;
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
 * Platform Data
 */
public final class PlatformData {

    /**
     * SECURE ZONE
     */
    public static class SECURE_ZONE {
        public static final Rectangle STATIC = new Rectangle(0,0,SIZE.W,SIZE.H);
        public static final Rectangle HORIZONTAL = new Rectangle(0, 0, DISTANCE.MAX_DIST_X + SIZE.W, SIZE.H);
        public static final Rectangle VERTICAL = new Rectangle(0, -DISTANCE.DIST_Y, SIZE.W, DISTANCE.DIST_Y + SIZE.H);
    }

    /**
     * POSITION
     */
    public static class POS {
        public static final int Z = 45;
    }

    /**
     * SIZE
     */
    public static class SIZE {
        public static final int W = 12;
        public static final int H = 3;
        public static final Vector2 VECTOR = new Vector2(W, H);
    }

    public static class DISTANCE {
        public static final int MAX_DIST_X = WorldData.SIZE.W - SIZE.W;
        public static final int DIST_Y = 10;
    }

    public static class SPEED {
        public static final iPalier<Speed> HORIZONTAL = new Palier<Speed>(
                new Speed(12, ACTIVE_SCORE.HORIZONTAL.getScore()),
                new Speed(15, ACTIVE_SCORE.HORIZONTAL.getScore() + 500),
                new Speed(18, ACTIVE_SCORE.HORIZONTAL.getScore() + 1000),
                new Speed(21, ACTIVE_SCORE.HORIZONTAL.getScore() + 1500),
                new Speed(24, ACTIVE_SCORE.HORIZONTAL.getScore() + 2000)
        );
        public static final int VERTICAL = 10;
    }

    /**
     * COLLISION
     */
    public static class COLLISION {
        public static Rectangle PLATFORM = new Rectangle(0,0,SIZE.W, SIZE.H);
        public static Rectangle BUNNY_DEFENSE = PLATFORM;
    }

    public static class TRANSPORTER {
        public static final Integer SPRING = 1;
        public static final Integer SPRING_MAN = 2;
    }

    /**
     * TARGET
     */
    public static class TARGET {
        public static final ComponentMapper STATIC = Mapper.Platform;
        public static final ComponentMapper HORIZONTAL = Mapper.Platform;
        public static final ComponentMapper VERTICAL = Mapper.Platform;
    }

    /**
     * SAVE TARGET
     */
    public static class SAVE_TARGET {
        public static final Array<ComponentMapper> STATIC = new Array<ComponentMapper>(){{
            this.addAll(Mapper.Platform, Mapper.PlatformCollision); }};
        public static final Array<ComponentMapper> HORIZONTAL = STATIC;
        public static final Array<ComponentMapper> VERTICAL = HORIZONTAL;
    }

    /**
     * ACTIVE SCORE
     */
    public static class ACTIVE_SCORE {
        public static final iActiveScore STATIC = ActiveScore.ActiveScoreZero;
        public static final iActiveScore HORIZONTAL = new ActiveScore(500);
        public static final iActiveScore VERTICAL = new ActiveScore(1000);

    }

    /**
     * ACTIVE RANDOM
     */
    public static class ACTIVE_RANDOM {
        public static final iActiveRandom STATIC = ActiveRandom.ActiveRandomCent;
        public static final iActiveRandom HORIZONTAL = new ActiveRandom(30);
        public static final iActiveRandom VERTICAL = new ActiveRandom(20);
    }

    /**
     * RANGE
     */
    public static class RANGE {

        public static final iPalier<iRange> STATIC = new Palier<iRange>(
                new Range(PlatformData.SIZE.H, PlatformData.SIZE.H),
                new Range(PlatformData.SIZE.H * 2, PlatformData.SIZE.H, 500),
                new Range(PlatformData.SIZE.H * 3, PlatformData.SIZE.H, 1000),
                new Range(PlatformData.SIZE.H * 4, PlatformData.SIZE.H, 2000),
                new Range(PlatformData.SIZE.H * 3, PlatformData.SIZE.H * 2, 3000)
        );

        public static final iPalier<iRange> HORIZONTAL = new Palier<iRange>(
                new Range(PlatformData.SIZE.H * 3, PlatformData.SIZE.H,
                            ACTIVE_SCORE.HORIZONTAL.getScore()),
                new Range(PlatformData.SIZE.H * 4, PlatformData.SIZE.H,
                            ACTIVE_SCORE.HORIZONTAL.getScore() + 1000),
                new Range(PlatformData.SIZE.H * 5, PlatformData.SIZE.H,
                            ACTIVE_SCORE.HORIZONTAL.getScore() + 2000),
                new Range(PlatformData.SIZE.H * 6, PlatformData.SIZE.H,
                            ACTIVE_SCORE.HORIZONTAL.getScore() + 3000),
                new Range(PlatformData.SIZE.H * 5, PlatformData.SIZE.H * 2,
                            ACTIVE_SCORE.HORIZONTAL.getScore() + 4000),
                new Range(PlatformData.SIZE.H * 4, PlatformData.SIZE.H * 3,
                            ACTIVE_SCORE.HORIZONTAL.getScore() + 5000),
                new Range(PlatformData.SIZE.H * 3, PlatformData.SIZE.H * 4,
                            ACTIVE_SCORE.HORIZONTAL.getScore() + 6000)
        );

        public static final iPalier<iRange> VERTICAL = new Palier<iRange>(
                new Range(DISTANCE.DIST_Y + PlatformData.SIZE.H, PlatformData.SIZE.H, 0)
        );
    }

    /**
     * BUILDER
     */
    public static class BUILDER {
        public static final AbsBuilder STATIC = new AbsBuilder() {
            @Override public Entity build() {
                return new PlatformEntity(true);
            }
        };
        public static final AbsBuilder HORIZONTAL = new AbsBuilder() {
            @Override
            public Entity build() {
                return new PlatformEntity(true).velo_x();
            }
        };
        public static final AbsBuilder VERTICAL = new AbsBuilder() {
            @Override
            public Entity build() {
                return new PlatformEntity(true).velo_y();
            }
        };
    }

    /**
     * BUILDER PACK
     */
    public static class BUILDER_PACK {
        public static final iBuilderPack STATIC = new BuilderPack(
                TARGET.STATIC, RANGE.STATIC, SAVE_TARGET.STATIC, ACTIVE_RANDOM.STATIC,
                ACTIVE_SCORE.STATIC, SECURE_ZONE.STATIC, BUILDER.STATIC
        );
        public static final iBuilderPack HORIZONTAL = new BuilderPack(
                TARGET.HORIZONTAL, RANGE.HORIZONTAL, SAVE_TARGET.HORIZONTAL, ACTIVE_RANDOM.HORIZONTAL,
                ACTIVE_SCORE.HORIZONTAL, SECURE_ZONE.HORIZONTAL, BUILDER.HORIZONTAL
        );

        public static final iBuilderPack VERTICAL = new BuilderPack(
                TARGET.VERTICAL, RANGE.VERTICAL, SAVE_TARGET.VERTICAL, ACTIVE_RANDOM.VERTICAL,
                ACTIVE_SCORE.VERTICAL, SECURE_ZONE.VERTICAL, BUILDER.VERTICAL
        );
    }

    public static iPalier<Random> BROKEN_RANDOM = new Palier<Random>(
            new Random(10, 0), new Random(20, 500), new Random(30, 1500),
            new Random(40, 2000), new Random(50, 2500), new Random(60, 5000),
            new Random(70, 8000), new Random(80, 15000)
    );
}
