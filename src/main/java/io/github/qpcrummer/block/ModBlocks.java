package io.github.qpcrummer.block;

import io.github.qpcrummer.Ideate;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class ModBlocks {
    public static final FabricatorBlock FABRICATOR_BLOCK = register(new FabricatorBlock(BlockBehaviour.Properties.of()), "fabricator", true);
    public static final IdeatorBlock IDEATOR_BLOCK = register(new IdeatorBlock(BlockBehaviour.Properties.of()), "ideator", true);


    public static <T extends Block> T register(T block, String name, boolean shouldRegisterItem) {
        // Register the block and its item.
        ResourceLocation id = ResourceLocation.tryBuild(Ideate.MOD_ID, name);

        // Sometimes, you may not want to register an item for the block.
        // Eg: if it's a technical block like `minecraft:air` or `minecraft:end_gateway`
        if (shouldRegisterItem) {
            BlockItem blockItem = new BlockItem(block, new Item.Properties());
            Registry.register(BuiltInRegistries.ITEM, id, blockItem);
        }

        return Registry.register(BuiltInRegistries.BLOCK, id, block);
    }

    public static void initialize() {}
}
