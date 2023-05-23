package net.gazebo.fabric;

import net.fabricmc.loader.api.FabricLoader;
import net.gazebo.Platform;

import static net.gazebo.Platform.Type.FABRIC;

public class PlatformImpl {
    public static Platform.Type getPlatformType() {
        return FABRIC;
    }

    public static boolean isModLoaded(String modid) {
        return FabricLoader.getInstance().isModLoaded(modid);
    }
}
