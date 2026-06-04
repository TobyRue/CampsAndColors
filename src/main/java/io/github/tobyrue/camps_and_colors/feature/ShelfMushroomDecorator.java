package io.github.tobyrue.camps_and_colors.feature;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.github.tobyrue.camps_and_colors.blocks.ModBlocks;
import io.github.tobyrue.camps_and_colors.blocks.ShelfMushroomBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType;

import javax.naming.Context;
import java.util.ArrayList;
import java.util.List;

public class ShelfMushroomDecorator extends TreeDecorator {
    public static final MapCodec<ShelfMushroomDecorator> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(
            Codec.floatRange(0.0F, 1.0F).fieldOf("probability").forGetter(d -> d.probability),
            Codec.floatRange(0.0F, 1.0F).fieldOf("large_probability").forGetter(d -> d.largeProbability)
    ).apply(instance, ShelfMushroomDecorator::new));

    private final float probability;
    private final float largeProbability;

    public ShelfMushroomDecorator(float probability, float largeProbability) {
        this.probability = probability;
        this.largeProbability = largeProbability;
    }

    @Override
    protected TreeDecoratorType<?> type() {
        return ModFeatures.SHELF_MUSHROOM_DECORATOR;
    }

    @Override
    public void place(Context context) {
        RandomSource random = context.random();
        List<BlockPos> logs = context.logs();
        List<BlockPos> placedPositions = new ArrayList<>();

        for (BlockPos logPos : logs) {
            if (random.nextFloat() < this.probability) {
                Direction side = Direction.Plane.HORIZONTAL.getRandomDirection(random);
                BlockPos targetPos = logPos.relative(side);
                BlockState logState = context.level().getBlockState(logPos);

                if (!logState.is(BlockTags.LOGS)) {
                    continue;
                }

                if (context.isAir(targetPos) && isSpaceValid(targetPos, placedPositions)) {
                    boolean isLarge = random.nextFloat() < this.largeProbability;

                    BlockState state = isLarge ? ModBlocks.BIG_SHELF_MUSHROOM.defaultBlockState() : ModBlocks.SMALL_SHELF_MUSHROOM.defaultBlockState();

                    context.setBlock(targetPos, state.setValue(ShelfMushroomBlock.FACING, side));
                    placedPositions.add(targetPos);
                }
            }
        }
    }

    private boolean isSpaceValid(BlockPos pos, List<BlockPos> existing) {
        for (BlockPos placed : existing) {
            if (pos.closerThan(placed, 1.5D)) {
                return false;
            }
        }
        return true;
    }
}
