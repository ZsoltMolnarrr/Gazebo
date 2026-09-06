package net.gazebo;

import net.gazebo.village.VillageStructures;

public class GazeboMod {
    public static final String ID = "gazebo";

    public static void init() {
        // Vanilla-village injection is a Fabric-only feature on the 1.20.1 line: StructurePoolAPI has
        // no Forge artifact, so the config and the API calls live behind `VillageStructures`, installed
        // by the Fabric entrypoint. On Forge the injector stays null and the gazebo is placed only by
        // the data-driven paths shipped in `resources/data/gazebo`
        // (Lithostitched worldgen modifiers, Repurposed Structures pool additions).
        VillageStructures.injectIfAvailable();
    }
}
