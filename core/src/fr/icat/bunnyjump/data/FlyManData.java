package fr.icat.bunnyjump.data;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ObjectMap;
import fr.icat.bunnyjump.consts.Mapper;
import fr.icat.bunnyjump.entities.monsters.FlyManEntity;
import fr.icat.bunnyjump.enums.MyRegions;
import fr.icat.bunnyjump.utils.Random;
import fr.icat.bunnyjump.utils.active.ActiveRandomPalier;
import fr.icat.bunnyjump.utils.active.ActiveScore;
import fr.icat.bunnyjump.utils.active.iActiveScore;
import fr.icat.bunnyjump.utils.builder.AbsBuilder;
import fr.icat.bunnyjump.utils.builder.BuilderPack;
import fr.icat.bunnyjump.utils.builder.iBuilderPack;
import fr.icat.bunnyjump.utils.palier.Palier;
import fr.icat.bunnyjump.utils.palier.iPalier;
import fr.icat.bunnyjump.utils.range.Range;
import fr.icat.bunnyjump.utils.range.iRange;
import fr.icat.bunnyjump.utils.tsco.TSCO;
import fr.icat.bunnyjump.utils.tsco.TSCOTimerInfo;

/**
 * Created by Romain on 18/04/2016.
 */
public final class FlyManData {

    public static final Vector2 SIZE = new Vector2(9,9);

    public static final int DISTANCE = 8;

    public static final int SPEED = 15;

    public static final int LIFE = 1;

    public static final int DEGAT = 1;

    /**
     * SECURE ZONE
     */
    public static final Rectangle SECURE_ZONE = new Rectangle(
            0, -DISTANCE, SIZE.x, DISTANCE + SIZE.y
    );

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
     * STATE
     */
    public static final class STATE {

        public static final int FLYMAN_FLY = 1;
        public static final int FLYMAN_JUMP = 2;
        public static final int FLYMAN_STAND = 3;

        public static final ObjectMap<Integer, TSCO> TEXTURE_STATE_MAP = new ObjectMap<Integer, TSCO>()
        {{
                this.put(FLYMAN_FLY, new TSCO(
                                MyRegions.flyMan_fly.getRegion(),
                                new TSCOTimerInfo(0.2f, FLYMAN_JUMP))
                );

                this.put(FLYMAN_JUMP, new TSCO(
                                MyRegions.flyMan_jump.getRegion(),
                                new TSCOTimerInfo(0.2f, FLYMAN_STAND))
                );

                this.put(FLYMAN_STAND, new TSCO(
                                MyRegions.flyMan_stand.getRegion(),
                                new TSCOTimerInfo(0.2f, FLYMAN_FLY))
                );
            }};
    }

    /**
     * RANGE
     */
    public static final iPalier<iRange> RANGE = new Palier<iRange>(
            new Range((int)SECURE_ZONE.height, PlatformData.SIZE.H, 0)
    );

    /**
     * TARGET
     */
    public static final ComponentMapper TARGET = Mapper.PlatformCollision;

    /**
     * SAVE
     */
    public static final Array<ComponentMapper> SAVE_TARGET = new Array<ComponentMapper>() {{
        this.addAll(Mapper.PlatformCollision);
    }};

    /**
     * ACTIVE SCORE
     */
    public static final iActiveScore ACTIVE_SCORE = new ActiveScore(400);

    /**
     * ACTIVE RANDOM
     */
    public static final ActiveRandomPalier ACTIVE_RANDOM_PALIER = new ActiveRandomPalier(
            new Palier<Random>(
                    new Random(8, ACTIVE_SCORE.getScore()),
                    new Random(9, ACTIVE_SCORE.getScore() * 2),
                    new Random(10, ACTIVE_SCORE.getScore() * 3),
                    new Random(11, ACTIVE_SCORE.getScore() * 4)
            )
    );

    /**
     * BUILDER
     */
    public static final AbsBuilder BUILDER = new AbsBuilder() {
        @Override public Entity build() {
            return new FlyManEntity();
        }
    };

    /**
     * BUILDER PACK
     */
    public static final iBuilderPack BUILDER_PACK = new BuilderPack(
            TARGET, RANGE, SAVE_TARGET, ACTIVE_RANDOM_PALIER,
            ACTIVE_SCORE, SECURE_ZONE, BUILDER
    );

}
