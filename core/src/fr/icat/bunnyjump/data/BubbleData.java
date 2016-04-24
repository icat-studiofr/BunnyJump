package fr.icat.bunnyjump.data;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import fr.icat.bunnyjump.consts.Mapper;
import fr.icat.bunnyjump.listeners.power.added.BubblePowerAddedListener;
import fr.icat.bunnyjump.listeners.power.added.iPowerAddedListener;
import fr.icat.bunnyjump.listeners.power.removed.BubblePowerRemovedListener;
import fr.icat.bunnyjump.listeners.power.removed.iPowerRemovedListener;

/**
 * Created by Romain on 17/04/2016.
 */
public final class BubbleData {

    public static final int Z = 49;

    public static final int TIME_LIFE = 8;

    public static final Vector2 SIZE = new Vector2(15,15);

    public static final Array<ComponentMapper> COMPONENT_TO_REMOVE = new Array<ComponentMapper>()
    {{
       this.add(Mapper.MonsterDefense); this.add(Mapper.MagicianCollision);
    }};

    public static final iPowerAddedListener ADDED_LISTENER = BubblePowerAddedListener.inst();

    public static final iPowerRemovedListener REMOVED_LISTENER = BubblePowerRemovedListener.inst();

    public static final class TRANSPORTABLE {
        public static final Vector2 BUBBLE = new Vector2(
                - SIZE.x / 2 + BunnyData.SIZE.W / 2,
                - SIZE.y / 2 + BunnyData.SIZE.H / 2);
    }
}
