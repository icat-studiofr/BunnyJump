package fr.icat.bunnyjump.data;

import fr.icat.bunnyjump.utils.builder.iBuilderPack;
import fr.icat.bunnyjump.utils.generator.iGenerator;
import fr.icat.bunnyjump.utils.grouper.Grouper;
import fr.icat.bunnyjump.utils.grouper.iGrouper;

/**
 * C
 */
public final class GrouperData {

    /** GROUPER DE GENERATEURS */
    public static final iGrouper<iGenerator<iBuilderPack>> GENERATORS
            = new Grouper<iGenerator<iBuilderPack>>(GeneratorData.DEFAULT);

    /** GROUPER DE BUILDER PACK */
    public static class BUILDER_PACK {

        public static class DEFAULT_GENERATOR {

            public static final iGrouper<iBuilderPack> DEFAULT = new Grouper<iBuilderPack>(
                    PlatformData.BUILDER_PACK.STATIC, true
            );

            public static final iGrouper<iBuilderPack> PLATFORM = new Grouper<iBuilderPack>(
                    null, PlatformData.BUILDER_PACK.HORIZONTAL, PlatformData.BUILDER_PACK.VERTICAL,
                    SpringData.BUILDER_PACK.STATIC
            );

            public static final iGrouper<iBuilderPack> MONSTER = new Grouper<iBuilderPack>(
                    null, SpringManData.BUILDER_PACK.HORIZON, SpringManData.BUILDER_PACK.STATIC,
                    SunData.BUILDER_PACK, WingManData.BUILDER_PACK, FlyManData.BUILDER_PACK
            );

            public static final iGrouper<iBuilderPack> BONUS = new Grouper<iBuilderPack>(
                    null, PowerData.BUILDER_PACK.JETPACK, PowerData.BUILDER_PACK.WING,
                    CoinData.BUILDER_PACK.BRONZE, CoinData.BUILDER_PACK.SILVER,
                    CoinData.BUILDER_PACK.GOLD, PowerData.BUILDER_PACK.BUBBLE
            );
        }
    }
}
