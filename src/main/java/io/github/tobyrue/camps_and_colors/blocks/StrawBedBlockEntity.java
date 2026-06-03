package io.github.tobyrue.camps_and_colors.blocks;

import net.minecraft.client.renderer.blockentity.BedRenderer;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BedBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class StrawBedBlockEntity extends BlockEntity {
    public StrawBedBlockEntity(BlockPos worldPosition, BlockState blockState) {
        super(ModBlockEntities.STRAW_BED_ENTITY, worldPosition, blockState);
    }
}
