package fr.icat.bunnyjump.data;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.ObjectMap;
import fr.icat.bunnyjump.components.GravityComponent;
import fr.icat.bunnyjump.enums.MyPositions;
import fr.icat.bunnyjump.enums.MyRegions;
import fr.icat.bunnyjump.assets.PositioningUtil;
import fr.icat.bunnyjump.utils.tsco.TSCO;
import fr.icat.bunnyjump.utils.tsco.TSCOTimerInfo;

/**
 * Bunny Data
 */
public final class BunnyData {

    public static final int LIFE = 1;
    public static final int DEGAT = 1;

    /**
     * POS */
    public static class POS {
        public static final int Z = 50;
        public static final Vector3 START = new Vector3(
                PositioningUtil.getFor(
                        WorldData.SIZE.VECTOR, BunnyData.SIZE.VECTOR, MyPositions.BOTTOM), Z);
    }

    /**
     * DIST */
    public static class MOVE {
        public static final float DIST = 30;
        public static final float X = 40;
        public static final float Y = Math.round(Math.sqrt((GravityComponent.GRAVITY * 2) * DIST));
    }

    /**
     * SIZE */
    public static class SIZE {
        public static final int W = 8;
        public static final int H = 9;
        public static final Vector2 VECTOR = new Vector2(W, H);
    }

    /**
     * TEXTURE TEXTURE_STATE */
    public static class STATES {

        public static final Integer STAND = 1;
        public static final Integer JUMP = 2;
        public static final Integer DEAD = 3;
        public static final Integer SKY = 4;

        public static final ObjectMap<Integer, TSCO> TEXTURE_STATE_MAP = new ObjectMap<Integer, TSCO>()
        {{
            this.put(JUMP, new TSCO(MyRegions.bunny_jump.getRegion()));
            this.put(DEAD, new TSCO(MyRegions.bunny_dead.getRegion()));
            this.put(SKY, new TSCO(MyRegions.bunny_sky.getRegion()));
            this.put(STAND, new TSCO(MyRegions.bunny_stand.getRegion(), new TSCOTimerInfo(0.1f, JUMP)));
        }};
    }

    /**
     * TRANSPORTER */
    public static class TRANSPORTER {

        /** TRANSPORTER KEYS **/
        public static final Integer WING_LEFT = 1;
        public static final Integer WING_RIGHT = 2;
        public static final Integer JETPACK = 3;
        public static final Integer BUBBLE = 4;
    }

    /**
     * COLLISION */
    public static class COLLISION {
        public static final Rectangle JUMPER = new Rectangle(0, SIZE.H - 3, SIZE.W, 3);
        public static final Rectangle ATTACK = JUMPER;
        public static final Rectangle MONSTER_DEFENSE = new Rectangle(0, 0, SIZE.W, SIZE.H - 2);
        public static final Rectangle MAGICIAN = new Rectangle(0,0,SIZE.W,SIZE.H);
        public static final Rectangle BANKER = new Rectangle(0,0,SIZE.W,SIZE.H);
    }
}
