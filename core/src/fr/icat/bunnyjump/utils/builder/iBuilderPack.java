package fr.icat.bunnyjump.utils.builder;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;
import fr.icat.bunnyjump.utils.active.iActiveRandomScoreComp;
import fr.icat.bunnyjump.utils.palier.iPalier;
import fr.icat.bunnyjump.utils.range.iRange;

/**
 * Objet qui contient un builder et les données définissa
 */
public interface iBuilderPack extends iActiveRandomScoreComp{

    AbsBuilder getBuilder();

    Entity getEntity();

    ComponentMapper getTarget();

    iPalier<iRange> getRanges();

    Array<ComponentMapper> getSaveTargetList();

    Rectangle getSecureZone();
}
