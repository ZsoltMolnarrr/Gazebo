package net.gazebo.neoforge;

import net.gazebo.GazeboMod;
import net.neoforged.fml.common.Mod;

@Mod(GazeboMod.ID)
public final class NeoForgeMod {
    public NeoForgeMod() {
        // Run our common setup.
        GazeboMod.init();
    }
}
