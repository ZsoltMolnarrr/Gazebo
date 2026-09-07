package net.gazebo;

import net.fabric_extras.structure_pool.api.StructurePoolAPI;
import net.fabric_extras.structure_pool.api.StructurePoolConfig;
import net.tiny_config.ConfigManager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GazeboMod {
    public static final String ID = "gazebo";

    public static final ConfigManager<StructurePoolConfig> villagesConfig = new ConfigManager<StructurePoolConfig>
            ("villages", defaults())
            .builder()
            .setDirectory(ID)
            .sanitize(true)
            .build();

    public static void init() {
        villagesConfig.refresh();
        if (!Platform.util().isModLoaded("lithostitched")) {
            // Only inject the gazebo if Lithostitched is not present — otherwise the data-driven
            // worldgen modifiers in `resources/data/gazebo` already do it.
            //
            // `injectAll` only *queues* the entries; StructurePoolAPI's own entrypoint applies them
            // when the server starts (Fabric `SERVER_STARTING` / Forge `ServerAboutToStartEvent`,
            // both before the spawn region generates). The queue is deliberately never cleared, so
            // this must be called exactly once, here at mod init — never per world load.
            StructurePoolAPI.injectAll(villagesConfig.value);
        }
    }

    private static StructurePoolConfig defaults() {
        var config = new StructurePoolConfig();
        var weight = 10;
        var limit = 1;
        config.entries = new ArrayList<>(List.of(
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
                        new StructurePoolConfig.Entry.Structure("gazebo:village/taiga/gazebo", 3, limit)
                ))),
                new StructurePoolConfig.Entry("minecraft:village/snowy/houses", new ArrayList<>(Arrays.asList(
                        new StructurePoolConfig.Entry.Structure("gazebo:village/snowy/gazebo", weight, limit)
                )))
        ));
        return config;
    }
}
