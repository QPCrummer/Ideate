package io.github.qpcrummer.block;

import io.github.qpcrummer.utils.ImplementedInventory;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public class FabricatorBlockEntity extends BlockEntity implements BlockEntityTicker<FabricatorBlockEntity>, MenuProvider, ImplementedInventory {
    public FabricatorBlockEntity(BlockPos pos, BlockState blockState) {
        super(ModBlockEntityTypes.FABRICATOR_BLOCK, pos, blockState);
    }

    private final NonNullList<ItemStack> items = NonNullList.withSize(2, ItemStack.EMPTY);

    @Override
    public void tick(Level level, BlockPos blockPos, BlockState blockState, FabricatorBlockEntity blockEntity) {

    }

    @Override
    public NonNullList<ItemStack> getItems() {
        return items;
    }

    @Override
    public void load(CompoundTag tag) {
        super.load(tag);
        ContainerHelper.loadAllItems(tag, items);
    }

    @Override
    public void saveAdditional(CompoundTag nbt) {
        ContainerHelper.saveAllItems(nbt, items);
        super.saveAdditional(nbt);
    }

    @Override
    public Component getDisplayName() {
        return Component.translatable(getBlockState().getBlock().getDescriptionId());
    }

    @Override
    public @Nullable AbstractContainerMenu createMenu(int syncId, Inventory playerInventory, Player player) {
        return new FabricatorScreenHandler(syncId, playerInventory, this);
    }
}
