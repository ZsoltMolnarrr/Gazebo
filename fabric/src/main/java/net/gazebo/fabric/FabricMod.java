package net.gazebo.fabric;

import net.fabricmc.api.ModInitializer;

import net.gazebo.GazeboMod;
import net.gazebo.fabric.village.FabricVillageStructures;

public final class FabricMod implements ModInitializer {
    @Override
    public void onInitialize() {
        // This code runs as soon as Minecraft is in a mod-load-ready state.
        // However, some things (like resources) may still be uninitialized.
        // Proceed with mild caution.

        // StructurePoolAPI is Fabric-only on 1.20.1: install the village injector before common init.
        FabricVillageStructures.install();

        // Run our common setup.
        GazeboMod.init();
    }
}
