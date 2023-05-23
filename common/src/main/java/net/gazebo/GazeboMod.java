package net.gazebo;

import net.gazebo.config.Default;
import net.gazebo.config.WorldGenConfig;
import net.tinyconfig.ConfigManager;

public class GazeboMod {
    public static final String ID = "gazebo";

    public static ConfigManager<WorldGenConfig> worldGenConfig = new ConfigManager<WorldGenConfig>
            ("world_gen", Default.worldGenConfig)
            .builder()
            .setDirectory(ID)
            .sanitize(true)
            .build();

    public static void init() {
        worldGenConfig.refresh();
    }
}