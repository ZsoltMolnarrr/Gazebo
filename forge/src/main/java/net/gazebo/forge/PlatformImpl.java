package net.gazebo.forge;

import net.minecraftforge.fml.ModList;
import net.gazebo.Platform;

import static net.gazebo.Platform.Type.FORGE;

public class PlatformImpl {
    public static Platform.Type getPlatformType() {
        return FORGE;
    }

    public static boolean isModLoaded(String modid) {
        return ModList.get().isLoaded(modid);
    }
}
