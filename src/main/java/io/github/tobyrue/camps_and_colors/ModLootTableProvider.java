package io.github.tobyrue.camps_and_colors;

import io.github.tobyrue.camps_and_colors.blocks.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootSubProvider;
import net.minecraft.core.HolderLookup;

import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootSubProvider {


    protected ModLootTableProvider(FabricPackOutput packOutput, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(packOutput, registriesFuture);
    }

    @Override
    public void generate() {
//        dropSelf(ModBlocks.POPLAR_FENCE);
//        dropSelf(ModBlocks.POPLAR_PLANKS);
//        add(ModBlocks.POPLAR_DOOR, this::createDoorTable);
//        dropSelf(ModBlocks.POPLAR_LOG);
//        dropSelf(ModBlocks.POPLAR_WOOD);
//        dropSelf(ModBlocks.POPLAR_FENCE_GATE);
//        dropSelf(ModBlocks.POPLAR_WALL_SIGN);
//        dropSelf(ModBlocks.POPLAR_SIGN);
//        dropSelf(ModBlocks.POPLAR_HANGING_SIGN);
//        dropSelf(ModBlocks.POPLAR_WALL_HANGING_SIGN);
//        dropSelf(ModBlocks.POPLAR_BUTTON);
//        dropSelf(ModBlocks.POPLAR_PRESSURE_PLATE);
//        add(ModBlocks.POPLAR_SLAB, this::createSlabItemTable);
//        dropSelf(ModBlocks.POPLAR_TRAPDOOR);
//        dropSelf(ModBlocks.STRIPPED_POPLAR_LOG);
//        dropSelf(ModBlocks.STRIPPED_POPLAR_WOOD);
//        dropSelf(ModBlocks.POPLAR_STAIRS);
//        dropSelf(ModBlocks.POPLAR_SHELF);
//        dropSelf(ModBlocks.YELLOW_POPLAR_LEAVES);
//
//
//        ModBlocks.WOOL_STAIRS.values().forEach(this::dropSelf);
//        for (DyeColor color : DyeColor.values()) {
//            add(ModBlocks.WOOL_SLAB.get(color), this::createSlabItemTable);
//            add(ModBlocks.CONCRETE_SLAB.get(color), this::createSlabItemTable);
//        }
//        ModBlocks.CONCRETE_STAIRS.values().forEach(this::dropSelf);
//        ModBlocks.CONCRETE_SLAB.values().forEach(this::createSlabItemTable);

        dropSelf(ModBlocks.RED_POPLAR_SAPLING);
        dropSelf(ModBlocks.ORANGE_POPLAR_SAPLING);
        dropSelf(ModBlocks.YELLOW_POPLAR_SAPLING);

        createLeavesDrops(ModBlocks.RED_POPLAR_LEAVES, ModBlocks.RED_POPLAR_SAPLING, 0.1F);
        createLeavesDrops(ModBlocks.ORANGE_POPLAR_LEAVES, ModBlocks.ORANGE_POPLAR_SAPLING, 0.1F);
        createLeavesDrops(ModBlocks.YELLOW_POPLAR_LEAVES, ModBlocks.YELLOW_POPLAR_SAPLING, 0.1F);
    }
}