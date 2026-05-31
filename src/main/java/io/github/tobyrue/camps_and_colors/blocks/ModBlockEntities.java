package io.github.tobyrue.camps_and_colors.blocks;

import net.minecraft.world.level.block.entity.BlockEntityType;

public class ModBlockEntities {

    public static void initialize() {

        BlockEntityType.SIGN.addValidBlock(ModBlocks.POPLAR_SIGN);
        BlockEntityType.SIGN.addValidBlock(ModBlocks.POPLAR_WALL_SIGN);
        BlockEntityType.HANGING_SIGN.addValidBlock(ModBlocks.POPLAR_HANGING_SIGN);
        BlockEntityType.HANGING_SIGN.addValidBlock(ModBlocks.POPLAR_WALL_HANGING_SIGN);


        BlockEntityType.SHELF.addValidBlock(ModBlocks.POPLAR_SHELF);

    }
}
