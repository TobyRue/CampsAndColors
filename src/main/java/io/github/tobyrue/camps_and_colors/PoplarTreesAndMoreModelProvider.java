package io.github.tobyrue.camps_and_colors;

import io.github.tobyrue.camps_and_colors.blocks.ModBlocks;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.model.TexturedModel;

public class PoplarTreesAndMoreModelProvider extends FabricModelProvider {
    public PoplarTreesAndMoreModelProvider(FabricPackOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators blockModelGenerators) {
        blockModelGenerators.createLeafLitter(ModBlocks.POPLAR_LEAF_LITTER);
    }

    @Override
    public void generateItemModels(ItemModelGenerators itemModelGenerator) {
    }

    @Override
    public String getName() {
        return "PoplarTreesAndMoreModelProvider";
    }
}
