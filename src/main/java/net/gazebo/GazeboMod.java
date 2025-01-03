package net.gazebo;

import net.fabric_extras.structure_pool.api.StructurePoolAPI;
import net.fabric_extras.structure_pool.api.StructurePoolConfig;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import net.gazebo.config.Default;
import net.tinyconfig.ConfigManager;

public class GazeboMod implements ModInitializer {
    public static final String ID = "gazebo";

    public static ConfigManager<StructurePoolConfig> villagesConfig = new ConfigManager<>
            ("villages", Default.villages)
            .builder()
            .setDirectory(ID)
            .sanitize(true)
            .build();
    @Override
    public void onInitialize() {
        villagesConfig.refresh();
        if (!FabricLoader.getInstance().isModLoaded("lithostitched")) {
            // Only inject the village if the Lithostitched is not present
            StructurePoolAPI.injectAll(villagesConfig.value);
        }
    }
}