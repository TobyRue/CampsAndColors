package io.github.tobyrue.camps_and_colors.client;

import io.github.tobyrue.camps_and_colors.CampsAndColors;
import io.github.tobyrue.camps_and_colors.blocks.ModBlocks;
import io.github.tobyrue.camps_and_colors.entities.ModEntities;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.particle.v1.ParticleProviderRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.BlockColorRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.BlockTintsFactory;
import net.fabricmc.fabric.api.client.rendering.v1.ModelLayerRegistry;
import net.minecraft.client.Minecraft;
import net.minecraft.client.color.block.BlockTintSource;
import net.minecraft.client.model.object.boat.BoatModel;
import net.minecraft.client.particle.EndRodParticle;
import net.minecraft.client.particle.FallingLeavesParticle;
import net.minecraft.client.renderer.block.BlockAndTintGetter;
import net.minecraft.client.renderer.entity.BoatRenderer;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.client.renderer.rendertype.RenderType;
import net.minecraft.client.renderer.rendertype.RenderTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

import java.util.List;

@Environment(EnvType.CLIENT)
public class CampsAndColorsClient implements ClientModInitializer {
    static {
        EntityRenderers.register(ModEntities.POPLAR_BOAT, (context) -> new BoatRenderer(context, ModModelLayers.POPLAR_BOAT));
        EntityRenderers.register(ModEntities.POPLAR_CHEST_BOAT, (context) -> new BoatRenderer(context, ModModelLayers.POPLAR_CHEST_BOAT));
    }
    @Override
    public void onInitializeClient() {
        ModelLayerRegistry.registerModelLayer(ModModelLayers.POPLAR_BOAT, BoatModel::createBoatModel);
        ModelLayerRegistry.registerModelLayer(ModModelLayers.POPLAR_CHEST_BOAT, BoatModel::createChestBoatModel);

        registerPoplarColor(ModBlocks.RED_POPLAR_LEAVES, 0xFFB22C00);
        registerPoplarColor(ModBlocks.ORANGE_POPLAR_LEAVES, 0xFFC16100);
        registerPoplarColor(ModBlocks.YELLOW_POPLAR_LEAVES, 0xFFFDB400);

        ParticleProviderRegistry.getInstance().register(CampsAndColors.RED_POPLAR_LEAVES_PARTICLE,
                FallingLeavesParticle.CherryProvider::new);

        ParticleProviderRegistry.getInstance().register(CampsAndColors.ORANGE_POPLAR_LEAVES_PARTICLE,
                FallingLeavesParticle.CherryProvider::new);

        ParticleProviderRegistry.getInstance().register(CampsAndColors.YELLOW_POPLAR_LEAVES_PARTICLE,
                FallingLeavesParticle.CherryProvider::new);

    }

    private void registerPoplarColor(Block block, int color) {
        BlockColorRegistry.register(List.of(new BlockTintSource() {
            @Override
            public int colorInWorld(BlockState state, BlockAndTintGetter level, BlockPos pos) {

                return color;
            }

            @Override
            public int color(BlockState state) {
                return color;
            }
        }), block);
    }
}
