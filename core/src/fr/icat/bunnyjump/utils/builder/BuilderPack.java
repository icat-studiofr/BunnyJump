package fr.icat.bunnyjump.utils.builder;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;
import fr.icat.bunnyjump.utils.active.iActiveRandom;
import fr.icat.bunnyjump.utils.active.iActiveScore;
import fr.icat.bunnyjump.utils.palier.iPalier;
import fr.icat.bunnyjump.utils.range.iRange;

/**
 * Stocke les données pour l'instanciation dynamique d'entité
 */
public final class BuilderPack implements iBuilderPack {

    ComponentMapper target;

    Array<ComponentMapper> saveTargetList;

    iPalier<iRange> ranges;

    iActiveRandom activeRandom;

    iActiveScore activeScore;

    Rectangle secureZone;

    AbsBuilder builder;

    // --

    public BuilderPack(ComponentMapper target, iPalier<iRange> ranges,
               Array<ComponentMapper> saveTargetList, iActiveRandom activeRandom,
               iActiveScore activeScore, Rectangle secureZone, AbsBuilder builder
    ){
        this.saveTargetList = saveTargetList;
        this.activeRandom = activeRandom;
        this.activeScore = activeScore;
        this.secureZone = secureZone;
        this.builder = builder;
        this.target = target;
        this.ranges = ranges;
    }

    // --

    @Override
    public AbsBuilder getBuilder() {
        return builder;
    }

    @Override
    public Entity getEntity() {
        return builder.build();
    }

    @Override
    public ComponentMapper getTarget() {
        return this.target;
    }

    @Override
    public iPalier<iRange> getRanges() {
        return this.ranges;
    }

    @Override
    public Array<ComponentMapper> getSaveTargetList() {
        return this.saveTargetList;
    }

    @Override
    public Rectangle getSecureZone() {
        return secureZone;
    }

    @Override
    public iActiveRandom getActiveRandom() {
        return activeRandom;
    }

    @Override
    public iActiveScore getActiveScore() {
        return activeScore;
    }
}
