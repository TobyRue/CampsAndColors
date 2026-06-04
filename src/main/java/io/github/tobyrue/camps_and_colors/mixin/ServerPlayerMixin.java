package io.github.tobyrue.camps_and_colors.mixin;

import io.github.tobyrue.camps_and_colors.blocks.StrawBedBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(ServerPlayer.class)
public class ServerPlayerMixin {
    @ModifyVariable(
            method = "startSleepInBed",
            at = @At("STORE"),
            name = "canSetSpawn"
    )
    private boolean campsAndColors$disableStrawBedSpawn(boolean canSetSpawn, BlockPos pos) {
        var me = ((ServerPlayer) ((Object) this));
        if (me.level().getBlockState(pos).getBlock() instanceof StrawBedBlock) {
            return false;
        }
        return canSetSpawn;
    }
}
