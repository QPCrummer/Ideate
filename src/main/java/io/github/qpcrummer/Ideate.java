package io.github.qpcrummer;

import io.github.qpcrummer.progression.Unlockable;
import io.github.qpcrummer.utils.Utils;
import net.fabricmc.api.ModInitializer;
import net.minecraft.resources.ResourceLocation;

import java.util.List;

public class Ideate implements ModInitializer {

    public static final String MOD_ID = "ideate";
    public static Unlockable[] unlockables;
    public static List<ResourceLocation> patents;

    @Override
    public void onInitialize() {
        unlockables = Utils.deserializeUnlockables();
        patents = Utils.readPatentFile();
    }
}
