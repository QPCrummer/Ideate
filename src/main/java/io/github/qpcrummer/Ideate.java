package io.github.qpcrummer;

import io.github.qpcrummer.block.FabricatorScreenHandler;
import io.github.qpcrummer.block.ModBlockEntityTypes;
import io.github.qpcrummer.block.ModBlocks;
import io.github.qpcrummer.progression.Unlockable;
import io.github.qpcrummer.utils.Utils;
import net.fabricmc.api.ModInitializer;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.inventory.MenuType;

import java.util.List;

public class Ideate implements ModInitializer {

    public static final String MOD_ID = "assets/ideate";
    public static Unlockable[] unlockables;
    public static List<ResourceLocation> patents;

    public static final MenuType<FabricatorScreenHandler> FABRICATOR_SCREEN_HANDLER = Registry.register(BuiltInRegistries.MENU, ResourceLocation.tryBuild(MOD_ID, "fabricator_screen"), new MenuType<>(FabricatorScreenHandler::new, FeatureFlagSet.of()));

    @Override
    public void onInitialize() {
        unlockables = Utils.deserializeUnlockables();
        patents = Utils.readPatentFile();
        ModBlocks.initialize();
        ModBlockEntityTypes.initialize();
    }
}
