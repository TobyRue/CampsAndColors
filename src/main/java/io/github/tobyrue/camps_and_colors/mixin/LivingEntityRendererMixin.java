package io.github.tobyrue.camps_and_colors.mixin;

import io.github.tobyrue.camps_and_colors.blocks.StrawBedBlock;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.client.renderer.state.level.CameraRenderState;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import org.spongepowered.asm.mixin.Debug;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LivingEntityRenderer.class)
public class LivingEntityRendererMixin<T extends LivingEntity, S extends LivingEntityRenderState> {

    @Inject(
            method = "submit(Lnet/minecraft/client/renderer/entity/state/LivingEntityRenderState;Lcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/SubmitNodeCollector;Lnet/minecraft/client/renderer/state/level/CameraRenderState;)V",
            at = @At(value = "INVOKE", target = "Lcom/mojang/blaze3d/vertex/PoseStack;translate(FFF)V", shift = At.Shift.AFTER, ordinal = 0)
    )
    private void campsAndColors$sinkPlayerInStrawBed(S state, PoseStack poseStack, SubmitNodeCollector collector, CameraRenderState camera, CallbackInfo ci) {
        if (state.hasPose(Pose.SLEEPING)) {
            var x = (int) state.x;
            var y = (int) state.y;
            var z = (int) state.z;
            BlockPos sleepPos = new BlockPos(x < 0 ? x - 1 : x, y < 0 ? y - 1 : y, z < 0 ? z - 1 : z);
            if (sleepPos != null) {
                var level = Minecraft.getInstance().level;
                if (level.getBlockState(sleepPos).getBlock() instanceof StrawBedBlock) {
                    poseStack.translate(0, 0.0F, 0.0F);
                }
            }
        }
    }

//    @Inject(
//            method = "submit",
//            at = @At(value = "INVOKE", target = "Lcom/mojang/blaze3d/vertex/PoseStack;popPose()V")
//    )
//    private void campsAndColors$nudgeInModelSpace(S state, PoseStack poseStack, SubmitNodeCollector collector, CameraRenderState camera, CallbackInfo ci) {
//        if (state.hasPose(Pose.SLEEPING)) {
//            var x = (int) state.x;
//            var y = (int) state.y;
//            var z = (int) state.z;
//            BlockPos sleepPos = new BlockPos(x < 0 ? x - 1 : x, y < 0 ? y - 1 : y, z < 0 ? z - 1 : z);
//
//            var level = Minecraft.getInstance().level;
//
//            float sinkIntoBed = -0.375F;
//            float shiftTowardsFeet = 0.1875F;
//
//            if (level.getBlockState(sleepPos).getBlock() instanceof StrawBedBlock) {
//                System.out.println("true");
//                poseStack.translate(sinkIntoBed, 0.0F, shiftTowardsFeet);
//            }
//        }
//    }
}