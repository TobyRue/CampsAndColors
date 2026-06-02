package io.github.tobyrue.camps_and_colors;

import io.github.tobyrue.camps_and_colors.blocks.ModBlockEntities;
import io.github.tobyrue.camps_and_colors.blocks.ModBlocks;
import io.github.tobyrue.camps_and_colors.feature.FallenPoplarLogFeature;
import io.github.tobyrue.camps_and_colors.feature.ModFeatures;
import io.github.tobyrue.camps_and_colors.items.ModItems;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.minecraft.core.Registry;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CampsAndColors implements ModInitializer {
	public static final String MOD_ID = "camps_and_colors";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	public static final SimpleParticleType RED_POPLAR_LEAVES_PARTICLE =
			FabricParticleTypes.simple();
	public static final SimpleParticleType ORANGE_POPLAR_LEAVES_PARTICLE =
			FabricParticleTypes.simple();
	public static final SimpleParticleType YELLOW_POPLAR_LEAVES_PARTICLE =
			FabricParticleTypes.simple();


	@Override
	public void onInitialize() {
		ModBlocks.initialize();
		ModItems.initialize();
		ModBlockEntities.initialize();
		ModFeatures.registerFeatures();
		StrippableBlockRegistry.register(ModBlocks.POPLAR_LOG, ModBlocks.STRIPPED_POPLAR_LOG);
		StrippableBlockRegistry.register(ModBlocks.POPLAR_WOOD, ModBlocks.STRIPPED_POPLAR_WOOD);

		Registry.register(BuiltInRegistries.PARTICLE_TYPE,
				Identifier.fromNamespaceAndPath(MOD_ID, "red_poplar_leaves"), RED_POPLAR_LEAVES_PARTICLE);

		Registry.register(BuiltInRegistries.PARTICLE_TYPE,
				Identifier.fromNamespaceAndPath(MOD_ID, "orange_poplar_leaves"), ORANGE_POPLAR_LEAVES_PARTICLE);

		Registry.register(BuiltInRegistries.PARTICLE_TYPE,
				Identifier.fromNamespaceAndPath(MOD_ID, "yellow_poplar_leaves"), YELLOW_POPLAR_LEAVES_PARTICLE);
	}
}