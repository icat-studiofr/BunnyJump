package fr.icat.bunnyjump.data;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import fr.icat.bunnyjump.consts.Mapper;
import fr.icat.bunnyjump.listeners.power.added.JetpackPowerAddedListener;
import fr.icat.bunnyjump.listeners.power.removed.JetpackPowerRemovedListener;

/**
 * Created by Romain on 10/04/2016.
 */
public final class JetpackData {

    public static final int Z = 49;

    public static final int TIME_LIFE = 5;

    public static final int SPEED = 100;

    public static final Array<ComponentMapper> COMPONENT_TO_REMOVE = new Array<ComponentMapper>()
    {{
        this.addAll(Mapper.Gravity, Mapper.BunnyAttack, Mapper.MagicianCollision, Mapper.MonsterDefense,
                Mapper.Jumper, Mapper.CarrotAttack);
    }};

    public static final JetpackPowerAddedListener ADDED_LISTENER = JetpackPowerAddedListener.inst();

    public static final JetpackPowerRemovedListener REMOVED_LISTENER = JetpackPowerRemovedListener.inst();

    public static final class SIZE {
        public static final Vector2 JETPACK = new Vector2(10, 8);
        public static final Vector2 FLAME = new Vector2(2, 4);
    }

    public static final class TRANSPORTABLE {
        public static final Vector2 JETPACK = new Vector2(0,2);
        public static final Vector2 FLAME1 = new Vector2(1,8);
        public static final Vector2 FLAME2 = new Vector2(7,8);
    }

    public static final class TRANSPORTER {
        public static final int FLAME1 = 1;
        public static final int FLAME2 = 2;
    }
}
