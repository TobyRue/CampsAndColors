package io.github.tobyrue.camps_and_colors;

import io.github.tobyrue.camps_and_colors.blocks.ModBlockEntities;
import io.github.tobyrue.camps_and_colors.blocks.ModBlocks;
import io.github.tobyrue.camps_and_colors.items.ModItems;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CampsAndColors implements ModInitializer {
	public static final String MOD_ID = "camps_and_colors";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModBlocks.initialize();
		ModItems.initialize();
		ModBlockEntities.initialize();
		StrippableBlockRegistry.register(ModBlocks.POPLAR_LOG, ModBlocks.STRIPPED_POPLAR_LOG);
		StrippableBlockRegistry.register(ModBlocks.POPLAR_WOOD, ModBlocks.STRIPPED_POPLAR_WOOD);
	}
}