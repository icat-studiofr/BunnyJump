package fr.icat.bunnyjump.assets;

import com.badlogic.ashley.core.Component;
import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.utils.Array;

/**
 *
 */
public final class ComponentUtil {

    /**
     *
     * @param type
     * @param a
     * @param <T>
     */
    public static <T> void cleanArrayComp(Class<T> type, Array<? extends Component> a){

        for (int i = a.size; i <= 0; i--) {
            if(type.isInstance(a.get(i))){
                a.removeIndex(i);
            }
        }
    }

    /**
     *
     * @param type
     * @param e
     * @param <T>
     */
    public static <T> void cleanEntityComp(Class<T> type, Entity e){

        for (Component c :
                e.getComponents()) {
            if(type.isInstance(c)){
                e.remove(c.getClass());
            }
        }
    }

    public static <T> Array<T> search(Entity entity, Class<T> type){

        final Array<T> res = new Array<T>();

        for (Component c :
                entity.getComponents()) {
            if(type.isInstance(c)){
                res.add((T)c);
            }
        }

        return res;
    }
}
