package fr.icat.bunnyjump.data;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ObjectMap;
import fr.icat.bunnyjump.consts.Mapper;
import fr.icat.bunnyjump.entities.SpringEntity;
import fr.icat.bunnyjump.enums.MyRegions;
import fr.icat.bunnyjump.utils.tsco.TSCO;
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
import fr.icat.bunnyjump.utils.tsco.TSCOTimerInfo;

/**
 * Created by Romain on 22/03/2016.
 */
public final class SpringData {

    public static final int Z = 45;

    /**
     * SECURE ZONE
     */
    public static final class SECURE_ZONE {
        public static final Rectangle STATIC = new Rectangle(
                0,
                -SIZE.H - MARGE.TOP,
                PlatformData.SIZE.W,
                SIZE.H + PlatformData.SIZE.H + MARGE.TOP);
    }

    /**
     * SPEED
     */
    public static final class SPEED {
        public static final float ANIMATION = 0.1f;
        public static final int BONUS_PLATFORM_COL = 30;
    }

    /**
     * SIZE
     */
    public static final class SIZE{
        public static final int W = 8;
        public static final int H = 4;
        public static Vector2 VECTOR = new Vector2(W, H);

        public static Vector2 SPRING_IN = new Vector2(W, 2);
        public static Vector2 SPRING_OUT = new Vector2(W, 6);
    }

    /**
     * STATE
     */
    public static final class STATES {
        public static int SPRING = 1;
        public static int SPRING_IN = 2;
        public static int SPRING_OUT = 3;

        public static final ObjectMap<Integer, TSCO> TEXTURE_STATE_MAP = new ObjectMap<Integer, TSCO>()
        {{
                this.put(SPRING, new TSCO(MyRegions.spring.getRegion()));
                this.put(SPRING_IN,
                    new TSCO(MyRegions.spring_in.getRegion(),
                        new TSCOTimerInfo(0.15f, SPRING_OUT)));
                this.put(SPRING_OUT, new TSCO(MyRegions.spring_out.getRegion()));
        }};
    }

    /**
     * TARGET
     */
    public static class TARGET {
        public static final ComponentMapper STATIC = Mapper.PlatformCollision;
    }

    /**
     * SAVE TARGET
     */
    public static class SAVE_TARGET {
        public static final Array<ComponentMapper> STATIC = new Array<ComponentMapper>() {{
            this.addAll(Mapper.Platform, Mapper.PlatformCollision);
        }};
    }

    /**
     * RANGE
     */
    public static class RANGE {
        public static final iPalier<iRange> STATIC = new Palier<iRange>(
                new Range(PlatformData.SIZE.H + SIZE.H + MARGE.TOP, PlatformData.SIZE.H, 0)
        );
    }

    public static class MARGE {
        public static int TOP = 12;
    }

    /**
     * COLLISION
     */
    public static class COLLISION {
        public static final Rectangle PLATFORM = new Rectangle(0, 0, SIZE.W, 3);
    }

    /**
     * TRANSPORTABKE
     */
    public static class TRANSPORTABLE {
        public static final Vector2 PLATFORM = new Vector2(
                (PlatformData.SIZE.W - SIZE.W) / 2, -SIZE.H);
    }

    /**
     * ACTIVE RANDOM
     */
    public static class ACTIVE_RANDOM {
        public static final iActiveRandom STATIC = new ActiveRandom(15);
    }

    /**
     * ACTIVE SCORE
     */
    public static class ACTIVE_SCORE {
        public static final iActiveScore STATIC = new ActiveScore(300);
    }

    /**
     * BUILDER
     */
    public static class BUILDER {
        public static final AbsBuilder STATIC = new AbsBuilder() {
            @Override public Entity build() {
                return new SpringEntity().statique();
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
    }
}
