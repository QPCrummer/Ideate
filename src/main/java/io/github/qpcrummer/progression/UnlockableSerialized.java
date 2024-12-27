package io.github.qpcrummer.progression;

import net.minecraft.world.item.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class UnlockableSerialized {
    private final String name;
    private final List<ItemStackSerializable> criteria;
    private boolean completed = false;
    public UnlockableSerialized(String name, List<ItemStackSerializable> criteria, boolean completed) {
        this.name = name;
        this.criteria = criteria;
        this.completed = completed;
    }

    public Unlockable deserialize() {
        List<ItemStack> itemStacks = new ArrayList<>();
        for (ItemStackSerializable item : criteria) {
            itemStacks.add(item.deserialize());
        }
        return new Unlockable(name, itemStacks, completed);
    }
}
