package fr.icat.bunnyjump.data;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import fr.icat.bunnyjump.consts.Mapper;
import fr.icat.bunnyjump.listeners.power.added.WingPowerAddedListener;
import fr.icat.bunnyjump.listeners.power.removed.WingPowerRemovedListener;

/**
 * Created by Romain on 11/04/2016.
 */
public final class WingData {

    public static final int Z = 49;

    public static final int TIME_LIFE = 5;

    public static final int SPEED = 60;

    public static final Array<ComponentMapper> COMPONENT_TO_REMOVE = new Array<ComponentMapper>()
    {{
        this.addAll(Mapper.Gravity, Mapper.BunnyAttack, Mapper.MagicianCollision, Mapper.MonsterDefense,
                Mapper.Jumper, Mapper.CarrotAttack);
    }};

    public static final WingPowerAddedListener ADDED_LISTENER = WingPowerAddedListener.inst();

    public static final WingPowerRemovedListener REMOVED_LISTENER = WingPowerRemovedListener.inst();

    public static final Vector2 SIZE = new Vector2(6, 5);

    public static final class TRANSPORTABLE {
        public static final Vector2 WING_LEFT = new Vector2(-4, 2);
        public static final Vector2 WING_RIGHT = new Vector2(BunnyData.SIZE.W, 2);
    }
}
