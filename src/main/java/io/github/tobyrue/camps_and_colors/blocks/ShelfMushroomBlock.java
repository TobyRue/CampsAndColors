package io.github.tobyrue.camps_and_colors.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.SlimeBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class ShelfMushroomBlock extends SlimeBlock {
    public static final EnumProperty<Direction> FACING = HorizontalDirectionalBlock.FACING;

    public enum MushroomType {
        SMALL,
        BIG
    }

    private final MushroomType type;

    private static final VoxelShape SMALL_NORTH = Shapes.box(0.1875, 0.4375, 0.625, 0.8125, 0.5625, 1.0);
    private static final VoxelShape SMALL_SOUTH = Shapes.box(0.1875, 0.4375, 0.0, 0.8125, 0.5625, 0.375);
    private static final VoxelShape SMALL_EAST = Shapes.box(0.0, 0.4375, 0.1875, 0.375, 0.5625, 0.8125);
    private static final VoxelShape SMALL_WEST = Shapes.box(0.625, 0.4375, 0.1875, 1.0, 0.5625, 0.8125);

    private static final VoxelShape BIG_NORTH = Shapes.or(
            Shapes.box(0.1875, 0.3125, 0.625, 0.8125, 0.4375, 1.0),
            Shapes.box(0.0625, 0.4375, 0.375, 0.9375, 0.625, 1.0)
    );

    private static final VoxelShape BIG_SOUTH = Shapes.or(
            Shapes.box(0.1875, 0.3125, 0.0, 0.8125, 0.4375, 0.375),
            Shapes.box(0.0625, 0.4375, 0.0, 0.9375, 0.625, 0.625)
    );

    private static final VoxelShape BIG_EAST = Shapes.or(
            Shapes.box(0.0, 0.3125, 0.1875, 0.375, 0.4375, 0.8125),
            Shapes.box(0.0, 0.4375, 0.0625, 0.625, 0.625, 0.9375)
    );

    private static final VoxelShape BIG_WEST = Shapes.or(
            Shapes.box(0.625, 0.3125, 0.1875, 1.0, 0.4375, 0.8125),
            Shapes.box(0.375, 0.4375, 0.0625, 1.0, 0.625, 0.9375)
    );

    public ShelfMushroomBlock(Properties properties, MushroomType type) {
        super(properties);
        this.type = type;
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        Direction dir = state.getValue(FACING);
        if (this.type == MushroomType.SMALL) {
            return switch (dir) {
                case SOUTH -> SMALL_SOUTH;
                case EAST -> SMALL_EAST;
                case WEST -> SMALL_WEST;
                default -> SMALL_NORTH;
            };
        } else {
            return switch (dir) {
                case SOUTH -> BIG_SOUTH;
                case EAST -> BIG_EAST;
                case WEST -> BIG_WEST;
                default -> BIG_NORTH;
            };
        }
    }


    @Override
    public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        Direction direction = state.getValue(FACING);
        BlockPos supportPos = pos.relative(direction.getOpposite());
        return level.getBlockState(supportPos).isFaceSturdy(level, supportPos, direction);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        Direction clickedFace = context.getClickedFace();

        if (clickedFace.getAxis().isVertical()) {
            return null;
        }

        BlockState state = this.defaultBlockState().setValue(FACING, clickedFace);

        if (state.canSurvive(context.getLevel(), context.getClickedPos())) {
            return state;
        }

        return null;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }
}