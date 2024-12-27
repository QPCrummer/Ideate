package io.github.qpcrummer.mixin;

import io.github.qpcrummer.item.PatentBook;
import io.github.qpcrummer.utils.Utils;
import net.minecraft.core.RegistryAccess;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.ShapedRecipe;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(ShapedRecipe.class)
public class PatentShapedRecipes implements PatentRecipeInterface {
    @Shadow @Final private ResourceLocation id;
    @Shadow @Final
    ItemStack result;
    private final boolean patented = Utils.isInPatentFile(this.id);
    @Override
    public boolean isPatented() {
        return patented;
    }

    /**
     * @author QPCrummer
     * @reason Must use the Patented technology
     */
    @Overwrite
    public ItemStack getResultItem(RegistryAccess registryAccess) {
        if (isPatented()) {
            return ItemStack.EMPTY;
        } else {
            return this.result;
        }
    }

    @Override
    public ItemStack getPatentedItem() {
        return this.result;
    }

    @Override
    public boolean isUnlocked(PatentBook book) {
        return book.isUnlocked(this.id);
    }
}
