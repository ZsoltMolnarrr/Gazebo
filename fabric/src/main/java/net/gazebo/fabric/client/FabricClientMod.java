package net.gazebo.fabric.client;

import net.fabricmc.api.ClientModInitializer;
import net.gazebo.client.GazeboClientMod;

public class FabricClientMod implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        GazeboClientMod.initialize();
    }
}
