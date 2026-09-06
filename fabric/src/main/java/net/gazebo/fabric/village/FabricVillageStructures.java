package net.gazebo.fabric.village;

import net.fabric_extras.structure_pool.api.StructurePoolAPI;
import net.fabric_extras.structure_pool.api.StructurePoolConfig;
import net.gazebo.GazeboMod;
import net.gazebo.Platform;
import net.gazebo.village.VillageStructures;
import net.tiny_config.ConfigManager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/// Fabric-only implementation of {@link VillageStructures}: StructurePoolAPI has no Forge artifact on
/// 1.20.1, so both the `config/gazebo/villages.json` config and the injection call live here (they used
/// to sit in `common`'s `GazeboMod` / `config.Default`).
public final class FabricVillageStructures {
    private FabricVillageStructures() { }

    public static final ConfigManager<StructurePoolConfig> villagesConfig = new ConfigManager<StructurePoolConfig>
            ("villages", defaults())
            .builder()
            .setDirectory(GazeboMod.ID)
            .sanitize(true)
            .build();

    /// Installs the injector and loads (or writes) the config file. Called from the Fabric entrypoint
    /// before {@code GazeboMod.init()}.
    public static void install() {
        villagesConfig.refresh();
        VillageStructures.injector = () -> {
            if (!Platform.util().isModLoaded("lithostitched")) {
                // Only inject the village if the Lithostitched is not present
                StructurePoolAPI.injectAll(villagesConfig.value);
            }
        };
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
