package net.gazebo.config;

import java.util.List;

public class Default {
    public final static WorldGenConfig worldGenConfig;
    static {
        worldGenConfig = new WorldGenConfig();
        worldGenConfig.entries.addAll(List.of(
                new WorldGenConfig.Entry("minecraft:village/desert/houses", "gazebo:village/desert/gazebo", 1),
                new WorldGenConfig.Entry("minecraft:village/savanna/houses", "gazebo:village/savanna/gazebo", 1),
                new WorldGenConfig.Entry("minecraft:village/plains/houses", "gazebo:village/plains/gazebo", 1),
                new WorldGenConfig.Entry("minecraft:village/taiga/houses", "gazebo:village/taiga/gazebo", 1),
                new WorldGenConfig.Entry("minecraft:village/snowy/houses", "gazebo:village/snowy/gazebo", 1)
        ));
    }
}
