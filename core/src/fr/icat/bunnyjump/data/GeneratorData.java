package fr.icat.bunnyjump.data;

import fr.icat.bunnyjump.utils.builder.iBuilderPack;
import fr.icat.bunnyjump.utils.generator.Generator;
import fr.icat.bunnyjump.utils.generator.iGenerator;

/**
 *
 */
public final class GeneratorData {

    /** PLAT_RANGE GENERATOR */
    public static final iGenerator<iBuilderPack> DEFAULT = new Generator<iBuilderPack>(
            GrouperData.BUILDER_PACK.DEFAULT_GENERATOR.DEFAULT,
            GrouperData.BUILDER_PACK.DEFAULT_GENERATOR.PLATFORM,
            GrouperData.BUILDER_PACK.DEFAULT_GENERATOR.MONSTER,
            GrouperData.BUILDER_PACK.DEFAULT_GENERATOR.BONUS
    );
}
