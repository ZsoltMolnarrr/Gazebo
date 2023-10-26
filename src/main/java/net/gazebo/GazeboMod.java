package net.gazebo;

import net.fabric_extras.structure_pool.api.StructurePoolAPI;
import net.fabric_extras.structure_pool.api.StructurePoolConfig;
import net.fabricmc.api.ModInitializer;
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
        StructurePoolAPI.injectAll(villagesConfig.value);
    }
}