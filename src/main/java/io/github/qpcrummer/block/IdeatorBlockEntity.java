package io.github.qpcrummer.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class IdeatorBlockEntity extends BlockEntity {
    public IdeatorBlockEntity(BlockPos pos, BlockState blockState) {
        super(ModBlockEntityTypes.IDEATOR_BLOCK, pos, blockState);
    }
}
