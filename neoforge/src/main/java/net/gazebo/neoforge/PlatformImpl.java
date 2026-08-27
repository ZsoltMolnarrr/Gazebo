package net.gazebo.neoforge;

import net.gazebo.Platform;
import net.neoforged.fml.loading.FMLLoader;

public class PlatformImpl {
    public static class NeoForgeUtil implements Platform.Util {
        @Override
        public boolean isModLoaded(String modid) {
            // Exact same check as SpellEngine's Platform.Util: LoadingModList (not ModList) is populated
            // during mod discovery, before any constructor runs, matching Fabric's "resolved up front" timing.
            // 26.1: the static `LoadingModList.get()` is deprecated for removal -- go through FMLLoader.
            return FMLLoader.getCurrent().getLoadingModList().getModFileById(modid) != null;
        }
    }
    private static final Platform.Util UTIL = new NeoForgeUtil();
    public static Platform.Util util() {
        return UTIL;
    }
}
