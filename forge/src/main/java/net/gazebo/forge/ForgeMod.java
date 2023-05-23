package net.gazebo.forge;

import net.gazebo.GazeboMod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.registries.RegisterEvent;
import net.minecraftforge.fml.common.Mod;

@Mod(GazeboMod.ID)
public class ForgeMod {
    public ForgeMod() {
        // Submit our event bus to let architectury register our content on the right time
        GazeboMod.init();
    }

    @SubscribeEvent
    public void register(RegisterEvent event) {
        // These don't seem to do anything :D
    }
}