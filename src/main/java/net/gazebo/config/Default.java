package net.gazebo.config;

import net.fabric_extras.structure_pool.api.StructurePoolConfig;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Default {
    public static final StructurePoolConfig villages;

    static {
        villages = new StructurePoolConfig();
        var weight = 3;
        var limit = 1;
        villages.entries = new ArrayList<>(List.of(
                new StructurePoolConfig.Entry("minecraft:village/desert/houses", new ArrayList<>(Arrays.asList(
                        new StructurePoolConfig.Entry.Structure("gazebo:village/desert/gazebo", weight, limit)
                ))),
                new StructurePoolConfig.Entry("minecraft:village/savanna/houses", new ArrayList<>(Arrays.asList(
                        new StructurePoolConfig.Entry.Structure("gazebo:village/savanna/gazebo", weight, limit)
                ))),
                new StructurePoolConfig.Entry("minecraft:village/plains/houses", new ArrayList<>(Arrays.asList(
                        new StructurePoolConfig.Entry.Structure("gazebo:village/plains/gazebo", weight, limit)
                ))),
                new StructurePoolConfig.Entry("minecraft:village/taiga/houses", new ArrayList<>(Arrays.asList(
                        new StructurePoolConfig.Entry.Structure("gazebo:village/taiga/gazebo", weight, limit)
                ))),
                new StructurePoolConfig.Entry("minecraft:village/snowy/houses", new ArrayList<>(Arrays.asList(
                        new StructurePoolConfig.Entry.Structure("gazebo:village/snowy/gazebo", weight, limit)
                )))
        ));
    }

}
