package io.github.qpcrummer.item;

import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.Tag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class PatentBook extends Item {

    private final List<ResourceLocation> bookUnlockables = new ArrayList<>();

    public PatentBook(Properties properties) {
        super(properties);
    }

    public boolean isUnlocked(ResourceLocation id) {
        return bookUnlockables.contains(id);
    }

    public void getUnlockablesFromStack(ItemStack stack) {
        ListTag tag = stack.getTag().getList("unlockables", Tag.TAG_STRING);
        for (Tag unlockable : tag) {
            bookUnlockables.add(ResourceLocation.tryParse(unlockable.toString()));
        }
    }
}
