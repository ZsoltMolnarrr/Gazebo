package net.gazebo.fabric;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.gazebo.GazeboMod;
import net.gazebo.worldgen.GazeboWorldGen;

public class FabricMod implements ModInitializer {
    @Override
    public void onInitialize() {
        preInit();
        GazeboMod.init();
        subscribeEvents();
    }

    private void preInit() {
    }

    private void subscribeEvents() {
        ServerLifecycleEvents.SERVER_STARTING.register(GazeboWorldGen::init);
    }

}