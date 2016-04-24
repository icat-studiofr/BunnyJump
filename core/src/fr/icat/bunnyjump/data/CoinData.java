package fr.icat.bunnyjump.data;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.ObjectMap;
import fr.icat.bunnyjump.consts.Mapper;
import fr.icat.bunnyjump.entities.CoinEntity;
import fr.icat.bunnyjump.enums.MyRegions;
import fr.icat.bunnyjump.utils.active.ActiveRandom;
import fr.icat.bunnyjump.utils.active.ActiveScore;
import fr.icat.bunnyjump.utils.builder.AbsBuilder;
import fr.icat.bunnyjump.utils.builder.BuilderPack;
import fr.icat.bunnyjump.utils.palier.Palier;
import fr.icat.bunnyjump.utils.palier.iPalier;
import fr.icat.bunnyjump.utils.range.Range;
import fr.icat.bunnyjump.utils.range.iRange;
import fr.icat.bunnyjump.utils.tsco.TSCO;
import fr.icat.bunnyjump.utils.tsco.TSCOTimerInfo;

/**
 * Created by Romain on 16/04/2016.
 */
public final class CoinData {

    public static final int Z = 45;

    public static final float SPEED_ROTATE = 0.1f;

    /**
     * SIZE
     */
    public static final class SIZE {
        public static final Vector2 STATE1 = new Vector2(6, 6);
        public static final Vector2 STATE2 = new Vector2(4, 6);
        public static final Vector2 STATE3 = new Vector2(3, 6);
        public static final Vector2 STATE4 = new Vector2(1, 6);
    }

    /**
     * COLLISION
     */
    public static final Rectangle COIN_COLLISION = new Rectangle(0,0,SIZE.STATE1.x,SIZE.STATE1.y);

    /**
     * SECURE ZONE
     */
    public static final Rectangle SECURE_ZONE = new Rectangle(0,0,SIZE.STATE1.x,SIZE.STATE1.y);

    /**
     * RANGE
     */
    public static final iPalier<iRange> RANGE = new Palier<iRange>(
            new Range(9, 3, 0)
    );

    /**
     * TARGET
     */
    public static final ComponentMapper TARGET = Mapper.PlatformCollision;

    /**
     * TYPE
     */
    public static final class TYPE {
        public static final int BRONZE = 3;
        public static final int SILVER = 2;
        public static final int GOLD = 1;
    }

    /**
     * VALUE
     */
    public static final class VALUE {
        public static final int BRONZE = 30;
        public static final int SILVER = 70;
        public static final int GOLD = 100;
    }

    /**
     * STATE
     */
    public static final class STATES {

        public static final int STATE1 = 1;
        public static final int STATE2 = 2;
        public static final int STATE3 = 3;
        public static final int STATE4 = 4;
        public static final int STATE5 = 5; // = 3
        public static final int STATE6 = 6; // = 2

        public static final ObjectMap<Integer, TSCO> GOLD_TEXTURE_STATE_MAP = new ObjectMap<Integer, TSCO>()
        {{
            this.put(STATE1,
                    new TSCO(MyRegions.gold1.getRegion(), new TSCOTimerInfo(SPEED_ROTATE, STATE2)));
            this.put(STATE2,
                    new TSCO(MyRegions.gold2.getRegion(), new TSCOTimerInfo(SPEED_ROTATE, STATE3)));
            this.put(STATE3,
                    new TSCO(MyRegions.gold3.getRegion(), new TSCOTimerInfo(SPEED_ROTATE, STATE4)));
            this.put(STATE4,
                    new TSCO(MyRegions.gold4.getRegion(), new TSCOTimerInfo(SPEED_ROTATE, STATE5)));
            this.put(STATE5,
                    new TSCO(MyRegions.gold3.getRegion(), new TSCOTimerInfo(SPEED_ROTATE, STATE6)));
            this.put(STATE6,
                    new TSCO(MyRegions.gold2.getRegion(), new TSCOTimerInfo(SPEED_ROTATE, STATE1)));
        }};

        public static final ObjectMap<Integer, TSCO> SILVER_TEXTURE_STATE_MAP = new ObjectMap<Integer, TSCO>()
        {{
            this.put(STATE1,
                    new TSCO(MyRegions.silver1.getRegion(), new TSCOTimerInfo(SPEED_ROTATE, STATE2)));
            this.put(STATE2,
                    new TSCO(MyRegions.silver2.getRegion(), new TSCOTimerInfo(SPEED_ROTATE, STATE3)));
            this.put(STATE3,
                    new TSCO(MyRegions.silver3.getRegion(), new TSCOTimerInfo(SPEED_ROTATE, STATE4)));
            this.put(STATE4,
                    new TSCO(MyRegions.silver4.getRegion(), new TSCOTimerInfo(SPEED_ROTATE, STATE5)));
            this.put(STATE5,
                    new TSCO(MyRegions.silver3.getRegion(), new TSCOTimerInfo(SPEED_ROTATE, STATE6)));
            this.put(STATE6,
                    new TSCO(MyRegions.silver2.getRegion(), new TSCOTimerInfo(SPEED_ROTATE, STATE1)));
        }};

        public static final ObjectMap<Integer, TSCO> BRONZE_TEXTURE_STATE_MAP = new ObjectMap<Integer, TSCO>()
        {{
            this.put(STATE1,
                    new TSCO(MyRegions.bronze1.getRegion(), new TSCOTimerInfo(SPEED_ROTATE, STATE2)));
            this.put(STATE2,
                    new TSCO(MyRegions.bronze2.getRegion(), new TSCOTimerInfo(SPEED_ROTATE, STATE3)));
            this.put(STATE3,
                    new TSCO(MyRegions.bronze3.getRegion(), new TSCOTimerInfo(SPEED_ROTATE, STATE4)));
            this.put(STATE4,
                    new TSCO(MyRegions.bronze4.getRegion(), new TSCOTimerInfo(SPEED_ROTATE, STATE5)));
            this.put(STATE5,
                    new TSCO(MyRegions.bronze3.getRegion(), new TSCOTimerInfo(SPEED_ROTATE, STATE6)));
            this.put(STATE6,
                    new TSCO(MyRegions.bronze2.getRegion(), new TSCOTimerInfo(SPEED_ROTATE, STATE1)));
        }};
    }

    /**
     * ACTIVE SCORE
     */
    public static final class ACTIVE_SCORE {
        public static final ActiveScore BRONZE = new ActiveScore(1000);
        public static final ActiveScore SILVER = new ActiveScore(3000);
        public static final ActiveScore GOLD = new ActiveScore(5000);
    }

    /**
     * ACTIVE RANDOM
     */
    public static final class ACTIVE_RANDOM {
        public static final ActiveRandom BRONZE = new ActiveRandom(9);
        public static final ActiveRandom SILVER = new ActiveRandom(5);
        public static final ActiveRandom GOLD = new ActiveRandom(3);
    }

    /**
     * BUILDER
     */
    public static final class BUILDER{
        public static final AbsBuilder BRONZE = new AbsBuilder() {
            @Override
            public Entity build() {
                return new CoinEntity(TYPE.BRONZE);
            }
        };
        public static final AbsBuilder SILVER = new AbsBuilder() {
            @Override
            public Entity build() {
                return new CoinEntity(TYPE.SILVER);
            }
        };
        public static final AbsBuilder GOLD = new AbsBuilder() {
            @Override
            public Entity build() {
                return new CoinEntity(TYPE.GOLD);
            }
        };
    }

    /**
     * BUILDER PACK
     */
    public static final class BUILDER_PACK{
        public static final BuilderPack BRONZE = new BuilderPack(
                TARGET, RANGE, null, ACTIVE_RANDOM.BRONZE, ACTIVE_SCORE.BRONZE,
                SECURE_ZONE, BUILDER.BRONZE
        );
        public static final BuilderPack SILVER = new BuilderPack(
                TARGET, RANGE, null, ACTIVE_RANDOM.SILVER, ACTIVE_SCORE.SILVER,
                SECURE_ZONE, BUILDER.SILVER
        );
        public static final BuilderPack GOLD = new BuilderPack(
                TARGET, RANGE, null, ACTIVE_RANDOM.GOLD, ACTIVE_SCORE.GOLD,
                SECURE_ZONE, BUILDER.GOLD
        );
    }
}
