package io.github.tobyrue.camps_and_colors;

import io.github.tobyrue.camps_and_colors.blocks.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;

import java.util.concurrent.CompletableFuture;

public class PoplarTagProvider extends FabricTagsProvider.BlockTagsProvider {

    public PoplarTagProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookupFuture) {
        super(output, registryLookupFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider registries) {
        valueLookupBuilder(BlockTags.MINEABLE_WITH_AXE)
                .add(ModBlocks.POPLAR_LOG, ModBlocks.POPLAR_WOOD, ModBlocks.STRIPPED_POPLAR_LOG, ModBlocks.STRIPPED_POPLAR_WOOD)
                .add(ModBlocks.POPLAR_PLANKS, ModBlocks.POPLAR_STAIRS, ModBlocks.POPLAR_SLAB)
                .add(ModBlocks.POPLAR_FENCE, ModBlocks.POPLAR_FENCE_GATE, ModBlocks.POPLAR_DOOR, ModBlocks.POPLAR_TRAPDOOR)
                .add(ModBlocks.POPLAR_BUTTON, ModBlocks.POPLAR_PRESSURE_PLATE, ModBlocks.POPLAR_SHELF);

        var concreteBuilder = valueLookupBuilder(BlockTags.MINEABLE_WITH_PICKAXE);
        for (Block b : ModBlocks.CONCRETE_STAIRS.values()) concreteBuilder.add(b);
        for (Block b : ModBlocks.CONCRETE_SLAB.values()) concreteBuilder.add(b);

        var woolBuilder = valueLookupBuilder(BlockTags.MINEABLE_WITH_HOE);
        for (Block b : ModBlocks.WOOL_STAIRS.values()) woolBuilder.add(b);
        for (Block b : ModBlocks.WOOL_SLAB.values()) woolBuilder.add(b);

        valueLookupBuilder(BlockTags.FENCES).add(ModBlocks.POPLAR_FENCE);
        valueLookupBuilder(BlockTags.FENCE_GATES).add(ModBlocks.POPLAR_FENCE_GATE);

        valueLookupBuilder(BlockTags.WALL_HANGING_SIGNS).add(ModBlocks.POPLAR_WALL_HANGING_SIGN);
        valueLookupBuilder(BlockTags.CEILING_HANGING_SIGNS).add(ModBlocks.POPLAR_HANGING_SIGN);
        valueLookupBuilder(BlockTags.SIGNS).add(ModBlocks.POPLAR_SIGN).add(ModBlocks.POPLAR_WALL_SIGN);

    }
}
