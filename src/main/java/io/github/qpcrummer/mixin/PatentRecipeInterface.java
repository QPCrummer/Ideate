package io.github.qpcrummer.mixin;

import io.github.qpcrummer.item.PatentBook;
import net.minecraft.world.item.ItemStack;

public interface PatentRecipeInterface {
    boolean isPatented();
    ItemStack getPatentedItem();
    boolean isUnlocked(PatentBook book);
}
