package io.github.tobyrue.camps_and_colors.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.LeafLitterBlock;
import net.minecraft.world.level.block.SegmentableBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import org.jspecify.annotations.Nullable;

public class PoplarLeafLitterBlock extends LeafLitterBlock {
    public PoplarLeafLitterBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(this.getSegmentAmountProperty(), 1));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, getSegmentAmountProperty());
    }

    @Override
    public void playerDestroy(Level level, Player player, BlockPos pos, BlockState state, @Nullable BlockEntity blockEntity, ItemStack destroyedWith) {
        super.playerDestroy(level, player, pos, state, blockEntity, destroyedWith);
        System.out.println(state);
        if (state.is(ModBlocks.POPLAR_LEAF_LITTER)) {
            Block dropBlock = getLitterDrop(level, pos);

            popResource(level, pos, new ItemStack(dropBlock, state.getValue(getSegmentAmountProperty())));
        }
    }

    private Block getLitterDrop(Level level, BlockPos pos) {
        for (int i = 1; i <= 24; i++) {
            BlockState aboveState = level.getBlockState(pos.above(i));

            if (aboveState.is(ModBlocks.RED_POPLAR_LEAVES)) {
                return ModBlocks.RED_POPLAR_LEAF_LITTER;
            } else if (aboveState.is(ModBlocks.ORANGE_POPLAR_LEAVES)) {
                return ModBlocks.ORANGE_POPLAR_LEAF_LITTER;
            } else if (aboveState.is(ModBlocks.YELLOW_POPLAR_LEAVES)) {
                return ModBlocks.YELLOW_POPLAR_LEAF_LITTER;
            }

            if (!aboveState.isAir() && !aboveState.getCollisionShape(level, pos.above(i)).isEmpty()) {
                break;
            }
        }

        double scale = 0.15;
        double x = pos.getX() * scale;
        double z = pos.getZ() * scale;

        double noise = Math.sin(x) + Math.sin(z) + Math.sin(x * 0.5 + z * 0.8);
        int choice = (int) Math.floor(Math.abs(noise * 10)) % 3;

        return switch (choice) {
            case 0 -> ModBlocks.RED_POPLAR_LEAF_LITTER;
            case 1 -> ModBlocks.ORANGE_POPLAR_LEAF_LITTER;
            default -> ModBlocks.YELLOW_POPLAR_LEAF_LITTER;
        };
    }
}
