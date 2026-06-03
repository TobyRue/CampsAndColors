package io.github.tobyrue.camps_and_colors.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.ScheduledTickAccess;
import net.minecraft.world.level.block.BedBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HayBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.*;
import net.minecraft.world.phys.BlockHitResult;
import org.jspecify.annotations.NonNull;

public class StrawBedBlock extends BedBlock {
    public static final EnumProperty<BedPart> PART = BlockStateProperties.BED_PART;;
    public static final BooleanProperty OCCUPIED = BlockStateProperties.OCCUPIED;;

    public StrawBedBlock(Properties properties) {
        super(DyeColor.BROWN, properties);
        this.registerDefaultState((BlockState)((BlockState)((BlockState)this.stateDefinition.any()).setValue(PART, BedPart.FOOT)).setValue(OCCUPIED, false));
    }
    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult) {
        if (level.isClientSide()) {
            return InteractionResult.SUCCESS_SERVER;
        } else {
            if (state.getValue(PART) != BedPart.HEAD) {
                pos = pos.relative(state.getValue(FACING));
                state = level.getBlockState(pos);
                if (!state.is(this)) {
                    return InteractionResult.CONSUME;
                }
            }

            if (state.getValue(OCCUPIED)) {
                return InteractionResult.SUCCESS_SERVER;
            } else {
                player.startSleepInBed(pos).ifLeft((problem) -> {
                    if (problem.message() != null) {
                        player.sendOverlayMessage(problem.message());
                    }
                });
                return InteractionResult.SUCCESS_SERVER;
            }
        }
    }

    @Override
    public void fallOn(final Level level, final BlockState state, final BlockPos pos, final Entity entity, final double fallDistance) {
        super.fallOn(level, state, pos, entity, fallDistance * (double)0.2F);
    }

    @Override
    protected BlockState updateShape(BlockState state, LevelReader level, ScheduledTickAccess ticks, BlockPos pos, Direction direction, BlockPos neighbourPos, BlockState neighbourState, RandomSource random) {
        if (state.getValue(OCCUPIED) && neighbourState.is(this) && !neighbourState.getValue(OCCUPIED)) {
            ticks.scheduleTick(pos, this, 1);
        }

        return super.updateShape(state, level, ticks, pos, direction, neighbourPos, neighbourState, random);
    }

    @Override
    protected void tick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        BlockPos otherPos = pos.relative(getConnectedDirection(state).getOpposite());
        level.removeBlock(pos, false);
        if (level.getBlockState(otherPos).is(this)) {
            level.removeBlock(otherPos, false);
        }
    }

    @Override
    public @NonNull BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new StrawBedBlockEntity(pos, state);
    }

    protected void createBlockStateDefinition(final StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(new Property[]{FACING, PART, OCCUPIED});
    }
}