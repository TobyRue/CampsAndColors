package io.github.tobyrue.camps_and_colors.mixin;

import io.github.tobyrue.camps_and_colors.blocks.ModBlocks;
import io.github.tobyrue.camps_and_colors.blocks.StrawBedBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BedBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.gamerules.GameRules;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Optional;
import java.util.function.Supplier;

@Mixin(LivingEntity.class)
public abstract class StrawBedMixin {



    @Redirect(method = "startSleeping", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/block/state/BlockState;getBlock()Lnet/minecraft/world/level/block/Block;"))
    private Block campsAndColors$mockBedBlockForStart(BlockState state) {
        if (state.is(BlockTags.BEDS)) {

            return (Block) (Object) net.minecraft.world.level.block.Blocks.BLACK_BED;
        }
        return state.getBlock();
    }

    @Redirect(
            method = "getBedOrientation",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/world/level/block/BedBlock;getBedOrientation(Lnet/minecraft/world/level/BlockGetter;Lnet/minecraft/core/BlockPos;)Lnet/minecraft/core/Direction;"
            )
    )
    private Direction campsAndColors$redirectBedOrientation(BlockGetter level, BlockPos pos) {
        BlockState state = level.getBlockState(pos);

        if (state.getBlock() instanceof StrawBedBlock) {
            return StrawBedBlock.getBedOrientation(level, pos);
        }

        return BedBlock.getBedOrientation(level, pos);
    }

    @Redirect(method = "lambda$checkBedExists$0", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/block/state/BlockState;getBlock()Lnet/minecraft/world/level/block/Block;"), expect = 0)
    private Block campsAndColors$mockBedBlockForExists(BlockState state) {
        if (state.is(BlockTags.BEDS)) {
            return Blocks.BLACK_BED;
        }
        return state.getBlock();
    }


    @Inject(method = "stopSleeping", at = @At(value = "HEAD"))
    public void stopSleeping(CallbackInfo ci) {
        var me = (LivingEntity)((Object) this);
        Level level = me.level();
        me.getSleepingPos().ifPresent(bedPosition -> {
            BlockState state = level.getBlockState(bedPosition);

            if (state.getBlock() instanceof StrawBedBlock strawBedBlock) {
                level.setBlock(bedPosition, state.setValue(StrawBedBlock.OCCUPIED, false), 3);

                BlockPos above = bedPosition.above();
                double x = above.getX() + 0.5D;
                double y = above.getY() + 0.1D;
                double z = above.getZ() + 0.5D;

                me.setPos(x, y, z);
                me.setPose(Pose.STANDING);

                if (!state.getValue(StrawBedBlock.PERSISTENT)) {
                    level.removeBlock(bedPosition, false);
                    popResource(level, bedPosition, new ItemStack(ModBlocks.STRAW_BED));
                }
            }
        });
    }

    private static void popResource(final Level level, final BlockPos pos, final ItemStack itemStack) {
        double halfHeight = (double) EntityType.ITEM.getHeight() / (double)2.0F;
        RandomSource random = level.getRandom();
        double x = (double)pos.getX() + (double)0.5F + Mth.nextDouble(random, (double)-0.25F, (double)0.25F);
        double y = (double)pos.getY() + (double)0.5F + Mth.nextDouble(random, (double)-0.25F, (double)0.25F) - halfHeight;
        double z = (double)pos.getZ() + (double)0.5F + Mth.nextDouble(random, (double)-0.25F, (double)0.25F);
        popResource(level, (Supplier)(() -> new ItemEntity(level, x, y, z, itemStack)), itemStack);
    }

    private static void popResource(final Level level, final Supplier<ItemEntity> entityFactory, final ItemStack itemStack) {
        if (level instanceof ServerLevel serverLevel) {
            if (!itemStack.isEmpty() && (Boolean)serverLevel.getGameRules().get(GameRules.BLOCK_DROPS)) {
                ItemEntity entity = (ItemEntity)entityFactory.get();
                entity.setDefaultPickUpDelay();
                level.addFreshEntity(entity);
                return;
            }
        }

    }

}