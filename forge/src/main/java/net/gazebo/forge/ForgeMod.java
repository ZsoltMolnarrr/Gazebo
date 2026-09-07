package net.gazebo.forge;

import net.gazebo.GazeboMod;
import net.minecraftforge.fml.common.Mod;

@Mod(GazeboMod.ID)
public final class ForgeMod {
    public ForgeMod() {
        // Run our common setup (also queues the vanilla-village structure injection — StructurePoolAPI
        // has a Forge artifact since 1.2.1, so the gazebo now reaches vanilla villages on both loaders,
        // not only through the data-driven paths in `resources/data/gazebo`).
        GazeboMod.init();
    }
}
