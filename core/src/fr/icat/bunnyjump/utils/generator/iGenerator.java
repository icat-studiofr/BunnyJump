package fr.icat.bunnyjump.utils.generator;

import com.badlogic.ashley.utils.ImmutableArray;
import fr.icat.bunnyjump.utils.active.iActiveRandomScoreComp;
import fr.icat.bunnyjump.utils.grouper.iGrouper;

/**
 *
 */
public interface iGenerator<T extends iActiveRandomScoreComp> extends iActiveRandomScoreComp {

    ImmutableArray<iGrouper<T>> getGroupers();

    iGrouper<T> get(int index);

    int getLoop();

    int getSize();

    void setLoop(int loop);

    void add(iGrouper<T> grouper);

    void remove(iGrouper<T> grouper);
}
