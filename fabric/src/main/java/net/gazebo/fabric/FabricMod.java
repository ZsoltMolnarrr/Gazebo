package net.gazebo.fabric;

import net.fabricmc.api.ModInitializer;

import net.gazebo.GazeboMod;

public final class FabricMod implements ModInitializer {
    @Override
    public void onInitialize() {
        // This code runs as soon as Minecraft is in a mod-load-ready state.
        // However, some things (like resources) may still be uninitialized.
        // Proceed with mild caution.

        // Run our common setup (also queues the vanilla-village structure injection).
        GazeboMod.init();
    }
}
