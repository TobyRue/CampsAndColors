//package io.github.tobyrue.camps_and_colors.client;// Made with Blockbench 5.1.4
//// Exported for Minecraft version 1.17 or later with Mojang mappings
//// Paste this class into your mod and generate all required imports
//
//
//import com.mojang.blaze3d.vertex.PoseStack;
//import com.mojang.blaze3d.vertex.VertexConsumer;
//import io.github.tobyrue.camps_and_colors.CampsAndColors;
//import io.github.tobyrue.camps_and_colors.client.CampsAndColorsClient;
//import net.minecraft.client.model.Model;
//import net.minecraft.client.model.geom.ModelLayerLocation;
//import net.minecraft.client.model.geom.ModelPart;
//import net.minecraft.client.model.geom.PartPose;
//import net.minecraft.client.model.geom.builders.*;
//import net.minecraft.client.renderer.rendertype.RenderTypes;
//import net.minecraft.resources.Identifier;
//
//public class StrawBedModel extends Model.Simple {
//	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(Identifier.fromNamespaceAndPath(CampsAndColors.MOD_ID, "straw_bed"), "main");
//	private final ModelPart bed;
//
//	public StrawBedModel(ModelPart root) {
//		super(root, RenderTypes::entityCutout);
//		this.bed = root.getChild("bed");
//	}
//
//	public static LayerDefinition createBodyLayer() {
//		MeshDefinition meshdefinition = new MeshDefinition();
//		PartDefinition partdefinition = meshdefinition.getRoot();
//
//		PartDefinition bed = partdefinition.addOrReplaceChild("bed", CubeListBuilder.create().texOffs(64, 0).addBox(-17.0F, -2.0F, -4.0F, 16.0F, 2.0F, 7.0F, new CubeDeformation(0.0F))
//		.texOffs(-20, 0).addBox(-19.0F, 3.0F, -4.0F, 2.0F, 0.0F, 32.0F, new CubeDeformation(0.0F))
//		.texOffs(-24, 0).addBox(-1.0F, 3.0F, -4.0F, 2.0F, 0.0F, 32.0F, new CubeDeformation(0.0F))
//		.texOffs(-21, 0).addBox(-19.0F, 0.0F, 3.0F, 2.0F, 0.0F, 25.0F, new CubeDeformation(0.0F))
//		.texOffs(-25, 0).addBox(-1.0F, 0.0F, 3.0F, 2.0F, 0.0F, 25.0F, new CubeDeformation(0.0F))
//		.texOffs(17, 3).addBox(-1.0F, 0.0F, 28.0F, 2.0F, 3.0F, 0.0F, new CubeDeformation(0.0F))
//		.texOffs(17, 0).addBox(-19.0F, 0.0F, 28.0F, 2.0F, 3.0F, 0.0F, new CubeDeformation(0.0F))
//		.texOffs(17, 8).addBox(-1.0F, -2.0F, 3.0F, 2.0F, 2.0F, 0.0F, new CubeDeformation(0.0F))
//		.texOffs(17, 6).addBox(-19.0F, -2.0F, 3.0F, 2.0F, 2.0F, 0.0F, new CubeDeformation(0.0F))
//		.texOffs(17, 10).addBox(-19.0F, -2.0F, -4.0F, 2.0F, 5.0F, 0.0F, new CubeDeformation(0.0F))
//		.texOffs(17, 15).addBox(-1.0F, -2.0F, -4.0F, 2.0F, 5.0F, 0.0F, new CubeDeformation(0.0F))
//		.texOffs(14, 7).addBox(-19.0F, -2.0F, -4.0F, 2.0F, 0.0F, 7.0F, new CubeDeformation(0.0F))
//		.texOffs(14, 0).addBox(-1.0F, -2.0F, -4.0F, 2.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(9.0F, 21.0F, -20.0F));
//
//		PartDefinition cube_r1 = bed.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-8.0F, -3.0F, -24.0F, 16.0F, 3.0F, 32.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-9.0F, 3.0F, 4.0F, 0.0F, 3.1416F, 0.0F));
//
//		return LayerDefinition.create(meshdefinition, 128, 128);
//	}
//}