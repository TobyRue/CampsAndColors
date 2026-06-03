package io.github.tobyrue.camps_and_colors.client;

import io.github.tobyrue.camps_and_colors.CampsAndColors;
import io.github.tobyrue.camps_and_colors.ModModelLayers;
import io.github.tobyrue.camps_and_colors.blocks.ModBlockEntities;
import io.github.tobyrue.camps_and_colors.blocks.ModBlocks;
import io.github.tobyrue.camps_and_colors.entities.ModEntities;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.particle.v1.ParticleProviderRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.BlockColorRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.ModelLayerRegistry;
import net.minecraft.client.color.block.BlockTintSource;
import net.minecraft.client.model.object.boat.BoatModel;
import net.minecraft.client.particle.FallingLeavesParticle;
import net.minecraft.client.renderer.block.BlockAndTintGetter;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.client.renderer.entity.BoatRenderer;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.Block;
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
        registerPoplarColor(ModBlocks.RED_FIREFLY_POPLAR_LEAVES, 0xFFB22C00);
        registerPoplarColor(ModBlocks.ORANGE_FIREFLY_POPLAR_LEAVES, 0xFFC16100);
        registerPoplarColor(ModBlocks.YELLOW_FIREFLY_POPLAR_LEAVES, 0xFFFDB400);


//        BlockEntityRenderers.register(ModBlockEntities.STRAW_BED_ENTITY, StrawBedRenderer::new);

        ParticleProviderRegistry.getInstance().register(CampsAndColors.RED_POPLAR_LEAVES_PARTICLE,
                FallingLeavesParticle.CherryProvider::new);

        ParticleProviderRegistry.getInstance().register(CampsAndColors.ORANGE_POPLAR_LEAVES_PARTICLE,
                FallingLeavesParticle.CherryProvider::new);

        ParticleProviderRegistry.getInstance().register(CampsAndColors.YELLOW_POPLAR_LEAVES_PARTICLE,
                FallingLeavesParticle.CherryProvider::new);




        BlockColorRegistry.register(List.of(new BlockTintSource() {
            @Override
            public int colorInWorld(BlockState state, BlockAndTintGetter level, BlockPos pos) {
                return 0xFFB22C00;
            }

            @Override
            public int color(BlockState state) {
                return 0xFFB22C00;
            }
        }), ModBlocks.RED_POPLAR_LEAF_LITTER);

        BlockColorRegistry.register(List.of(new BlockTintSource() {
            @Override
            public int colorInWorld(BlockState state, BlockAndTintGetter level, BlockPos pos) {
                return 0xFF874300;
            }

            @Override
            public int color(BlockState state) {
                return 0xFF874300;
            }
        }), ModBlocks.ORANGE_POPLAR_LEAF_LITTER);

        BlockColorRegistry.register(List.of(new BlockTintSource() {
            @Override
            public int colorInWorld(BlockState state, BlockAndTintGetter level, BlockPos pos) {
                return 0xFFFDB400;
            }

            @Override
            public int color(BlockState state) {
                return 0xFFFDB400;
            }
        }), ModBlocks.YELLOW_POPLAR_LEAF_LITTER);

        BlockColorRegistry.register(List.of(new BlockTintSource() {
            @Override
            public int colorInWorld(BlockState state, BlockAndTintGetter level, BlockPos pos) {

                for (int i = 1; i <= 24; i++) {
                    BlockState aboveState = level.getBlockState(pos.above(i));

                    if (aboveState.is(ModBlocks.RED_POPLAR_LEAVES)) {
                        return 0xFFB22C00;
                    } else if (aboveState.is(ModBlocks.ORANGE_POPLAR_LEAVES)) {
                        return 0xFF874300;
                    } else if (aboveState.is(ModBlocks.YELLOW_POPLAR_LEAVES)) {
                        return 0xFFFDB400;
                    }
                    if (!aboveState.getCollisionShape(level, pos.above(i)).isEmpty()) {
                        break;
                    }
                }

                double scale = 0.15;
                double x = pos.getX() * scale;
                double z = pos.getZ() * scale;

                double noise = Math.sin(x) + Math.sin(z) + Math.sin(x * 0.5 + z * 0.8);

                int choice = (int) Math.floor(Math.abs(noise * 10)) % 3;

                return switch (choice) {
                    case 0 -> 0xFFB22C00; // Red
                    case 1 -> 0xFF874300; // Orange
                    default -> 0xFFFDB400; // Yellow
                };

            }

            @Override
            public int color(BlockState state) {
                return 0xFF874300;
            }
        }), ModBlocks.POPLAR_LEAF_LITTER);
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
