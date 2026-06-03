package io.github.tobyrue.camps_and_colors.mixin;

import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.block.BedBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(LivingEntity.class)
public class StrawBedMixin {

    @Redirect(method = "startSleeping", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/block/state/BlockState;getBlock()Lnet/minecraft/world/level/block/Block;"))
    private Block campsAndColors$mockBedBlockForStart(BlockState state) {
        if (state.is(BlockTags.BEDS)) {

            return (Block) (Object) net.minecraft.world.level.block.Blocks.BLACK_BED;
        }
        return state.getBlock();
    }

    //TODO   .getBedOrientation mixin next

    @Redirect(method = "lambda$checkBedExists$0", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/block/state/BlockState;getBlock()Lnet/minecraft/world/level/block/Block;"), expect = 0)
    private Block campsAndColors$mockBedBlockForExists(BlockState state) {
        if (state.is(BlockTags.BEDS)) {
            return Blocks.BLACK_BED;
        }
        return state.getBlock();
    }
}