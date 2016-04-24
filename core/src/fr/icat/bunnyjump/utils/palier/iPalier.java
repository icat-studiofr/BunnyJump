package fr.icat.bunnyjump.utils.palier;

import fr.icat.bunnyjump.utils.active.iActiveScoreComp;

/**
 *
 */
public interface iPalier<T extends iActiveScoreComp> {

    T get();

    void add(T actObj);
}
