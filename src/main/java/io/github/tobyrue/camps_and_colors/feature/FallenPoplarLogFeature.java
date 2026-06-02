package io.github.tobyrue.camps_and_colors.feature;

import com.mojang.serialization.Codec;
import io.github.tobyrue.camps_and_colors.blocks.ModBlocks;
import io.github.tobyrue.camps_and_colors.blocks.ShelfMushroomBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;


public class FallenPoplarLogFeature extends Feature<NoneFeatureConfiguration> {
    public FallenPoplarLogFeature(Codec<NoneFeatureConfiguration> codec) {
        super(codec);
    }

    @Override
    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> context) {
        WorldGenLevel level = context.level();
        BlockPos origin = context.origin();
        RandomSource random = context.random();

        Direction logDir = random.nextBoolean() ? Direction.EAST : Direction.SOUTH;
        int length = random.nextInt(4, 8);

        BlockPos currentPos = origin;

        for (int i = 0; i < length; i++) {
            BlockPos logPos = currentPos.relative(logDir, i);

            logPos = findGround(level, logPos, 3);

            BlockState currentState = level.getBlockState(logPos);
            BlockState floorState = level.getBlockState(logPos.below());

            if (!currentState.canBeReplaced()) {
                break;
            }

            if (!floorState.getFluidState().isEmpty() || floorState.isAir()) {
                break;
            }

            level.setBlock(logPos, ModBlocks.POPLAR_LOG.defaultBlockState()
                    .setValue(RotatedPillarBlock.AXIS, logDir.getAxis()), 3);

            for (Direction side : Direction.values()) {
                if (side.getAxis() != Direction.Axis.Y && side.getAxis() != logDir.getAxis()) {
                    if (random.nextFloat() < 0.25f) {
                        BlockPos shroomPos = logPos.relative(side);

                        if (level.getBlockState(shroomPos).canBeReplaced()) {
                            if (canPlaceMushroomHere(level, shroomPos, logDir)) {
                                Block shroom = random.nextInt(3) == 0 ?
                                        ModBlocks.BIG_SHELF_MUSHROOM : ModBlocks.SMALL_SHELF_MUSHROOM;

                                level.setBlock(shroomPos, shroom.defaultBlockState()
                                        .setValue(ShelfMushroomBlock.FACING, side), 3);
                            }
                        }
                    }
                }
            }
        }
        return true;
    }

    private BlockPos findGround(WorldGenLevel level, BlockPos pos, int maxFall) {
        BlockPos mutable = pos;
        for (int j = 0; j < maxFall; j++) {
            if (level.getBlockState(mutable.below()).isAir() || level.getBlockState(mutable.below()).canBeReplaced()) {
                mutable = mutable.below();
            } else {
                break;
            }
        }
        return mutable;
    }

    private boolean canPlaceMushroomHere(WorldGenLevel level, BlockPos pos, Direction logDir) {
        return level.getBlockState(pos.relative(logDir)).isAir() &&
                level.getBlockState(pos.relative(logDir.getOpposite())).isAir();
    }
}