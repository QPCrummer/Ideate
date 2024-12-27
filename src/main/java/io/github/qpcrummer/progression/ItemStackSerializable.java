package io.github.qpcrummer.progression;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

public class ItemStackSerializable {
    private final String id;
    private final int amount;

    public ItemStackSerializable(String id, int amount) {
        this.amount = amount;
        this.id = id;
    }

    public ItemStack deserialize() {
        return new ItemStack(BuiltInRegistries.ITEM.get(ResourceLocation.tryParse(id)), amount);
    }
}
