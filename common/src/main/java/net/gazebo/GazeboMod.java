package net.gazebo;

import net.rpg_foundation.structure_pool_api.api.StructurePoolAPI;
import net.rpg_foundation.structure_pool_api.api.StructurePoolConfig;
import net.gazebo.config.Default;
import net.tiny_config.ConfigManager;

public class GazeboMod {
    public static final String ID = "gazebo";

    public static ConfigManager<StructurePoolConfig> villagesConfig = new ConfigManager<>
            ("villages", Default.villages)
            .builder()
            .setDirectory(ID)
            .sanitize(true)
            .build();

    public static void init() {
        villagesConfig.refresh();
        if (!Platform.util().isModLoaded("lithostitched")) {
            // Only inject the village if the Lithostitched is not present
            StructurePoolAPI.injectAll(villagesConfig.value);
        }
    }
}