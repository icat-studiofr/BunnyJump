package fr.icat.bunnyjump.utils.range;

import com.badlogic.gdx.math.Vector2;
import fr.icat.bunnyjump.utils.active.iActiveScoreComp;

/**
 * Range utilisé par un builder pack afin de définir la hauteur de la zone de spawnage
 * au dessus de la derniere cible.
 */
public interface iRange extends iActiveScoreComp{

    int getMin();

    int getMax();

    void setMin(int min);

    void setMax(int max);

    void set(int min, int max);

    void set(Vector2 range);
}
