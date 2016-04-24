package fr.icat.bunnyjump.utils.grouper;

import com.badlogic.ashley.utils.ImmutableArray;
import fr.icat.bunnyjump.utils.active.iActiveRandomScoreComp;

/**
 *
 */
public interface iGrouper<T extends iActiveRandomScoreComp> {

    T exec();

    T getDefault();

    ImmutableArray<T> getReadyList();

    ImmutableArray<T> getWaitingList();

    void add(T obj);

    void addAll(T... objs);
}
