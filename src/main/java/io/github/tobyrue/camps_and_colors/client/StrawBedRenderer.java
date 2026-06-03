//package io.github.tobyrue.camps_and_colors.client;
//
//import com.mojang.blaze3d.vertex.PoseStack;
//import com.mojang.math.Axis;
//import io.github.tobyrue.camps_and_colors.CampsAndColors;
//import io.github.tobyrue.camps_and_colors.ModModelLayers;
//import io.github.tobyrue.camps_and_colors.blocks.StrawBedBlock;
////import io.github.tobyrue.camps_and_colors.blocks.StrawBedBlockEntity;
//import net.fabricmc.api.EnvType;
//import net.fabricmc.api.Environment;
//import net.minecraft.client.model.EntityModel;
//import net.minecraft.client.model.Model;
//import net.minecraft.client.model.geom.ModelLayerLocation;
//import net.minecraft.client.model.geom.ModelPart;
//import net.minecraft.client.model.geom.PartPose;
//import net.minecraft.client.model.geom.builders.*;
//import net.minecraft.client.renderer.Sheets;
//import net.minecraft.client.renderer.SubmitNodeCollector;
//import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
//import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
//import net.minecraft.client.renderer.blockentity.ChestRenderer;
//import net.minecraft.client.renderer.feature.ModelFeatureRenderer;
//import net.minecraft.client.renderer.rendertype.RenderTypes;
//import net.minecraft.client.renderer.state.level.CameraRenderState;
//import net.minecraft.client.renderer.texture.OverlayTexture;
//import net.minecraft.client.resources.model.sprite.SpriteGetter;
//import net.minecraft.client.resources.model.sprite.SpriteId;
//import net.minecraft.core.Direction;
//import net.minecraft.resources.Identifier;
//import net.minecraft.util.Unit;
//import net.minecraft.world.level.block.state.properties.BedPart;
//import net.minecraft.world.phys.Vec3;
//
//public class StrawBedRenderer implements BlockEntityRenderer<StrawBedBlockEntity, StrawBedRenderState> {
//	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(Identifier.fromNamespaceAndPath(CampsAndColors.MOD_ID, "straw_bed"), "main");
//	private final StrawBedModel model;
//	private final SpriteGetter sprites;
//	public static final SpriteId TEXTURE = new SpriteId(
//			Sheets.BED_SHEET, // This points to the Bed Texture Atlas
//			Identifier.fromNamespaceAndPath(CampsAndColors.MOD_ID, "entity/straw_bed")
//	);
//
//	public StrawBedRenderer(BlockEntityRendererProvider.Context context) {
//		this.sprites = context.sprites();
//		this.model = new StrawBedModel(context.bakeLayer(ModModelLayers.STRAW_BED));
//	}
//
//	@Override
//	public StrawBedRenderState createRenderState() {
//		return new StrawBedRenderState();
//	}
//
//	@Override
//	public void extractRenderState(StrawBedBlockEntity entity, StrawBedRenderState state, float partialTicks, Vec3 cameraPos, ModelFeatureRenderer.CrumblingOverlay breakProgress) {
//		BlockEntityRenderer.super.extractRenderState(entity, state, partialTicks, cameraPos, breakProgress);
//		state.facing = entity.getBlockState().getValue(StrawBedBlock.FACING);
//		state.part = entity.getBlockState().getValue(StrawBedBlock.PART);
//	}
//
//	@Override
//	public void submit(StrawBedRenderState state, PoseStack poseStack, SubmitNodeCollector collector, CameraRenderState camera) {
//		poseStack.pushPose();
//
//		poseStack.translate(0.5, 0.5, 0.5);
//		poseStack.mulPose(Axis.YP.rotationDegrees(-state.facing.toYRot()));
//		poseStack.translate(-0.5, -0.5, -0.5);
//		collector.submitModel(model, Unit.INSTANCE, poseStack, state.lightCoords, OverlayTexture.NO_OVERLAY, -1, StrawBedRenderer.TEXTURE, this.sprites, 0, state.breakProgress);
//
//		poseStack.popPose();
//	}
//}