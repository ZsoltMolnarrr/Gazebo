package net.gazebo.forge;

import net.gazebo.GazeboMod;
import net.minecraftforge.fml.common.Mod;

@Mod(GazeboMod.ID)
public final class ForgeMod {
    public ForgeMod() {
        // Run our common setup.
        // Note: no village injector is installed on Forge - StructurePoolAPI has no 1.20.1 Forge
        // artifact, so `GazeboMod.init()` is a no-op here and the gazebo is placed only by the
        // data-driven paths (Lithostitched worldgen modifiers, Repurposed Structures pool additions).
        GazeboMod.init();
    }
}
