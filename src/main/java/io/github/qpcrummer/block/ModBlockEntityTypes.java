package io.github.qpcrummer.block;

import io.github.qpcrummer.Ideate;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.entity.BlockEntityType;

public class ModBlockEntityTypes {
    public static <T extends BlockEntityType<?>> T register(String path, T blockEntityType) {
        return Registry.register(BuiltInRegistries.BLOCK_ENTITY_TYPE, ResourceLocation.tryBuild(Ideate.MOD_ID, path), blockEntityType);
    }

    public static final BlockEntityType<FabricatorBlockEntity> FABRICATOR_BLOCK = register(
            "fabricator",
            BlockEntityType.Builder.of(FabricatorBlockEntity::new, ModBlocks.FABRICATOR_BLOCK).build(null)
    );

    public static final BlockEntityType<IdeatorBlockEntity> IDEATOR_BLOCK = register(
            "ideator",
            BlockEntityType.Builder.of(IdeatorBlockEntity::new, ModBlocks.IDEATOR_BLOCK).build(null)
    );

    public static void initialize() {
    }
}
