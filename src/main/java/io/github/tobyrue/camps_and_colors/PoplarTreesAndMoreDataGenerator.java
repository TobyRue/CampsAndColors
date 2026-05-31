package io.github.tobyrue.camps_and_colors;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class PoplarTreesAndMoreDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
//		pack.addProvider(PoplarTreesAndMoreModelProvider::new);
//		pack.addProvider(ModRecipeProvider::new);
//		pack.addProvider(ModLootTableProvider::new);
//		pack.addProvider(PoplarTagProvider::new);
	}
}
