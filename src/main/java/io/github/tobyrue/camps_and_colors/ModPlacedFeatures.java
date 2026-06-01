package io.github.tobyrue.camps_and_colors;

import io.github.tobyrue.camps_and_colors.blocks.ModBlocks;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.filefix.fixes.ResourcePackLocationFileFix;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;

import java.util.List;

public class ModPlacedFeatures {
    public static final ResourceKey<PlacedFeature> RED_POPLAR_OAK_PLACED = registerKey("red_poplar_oak_placed");
    public static final ResourceKey<PlacedFeature> RED_POPLAR_FANCY_PLACED = registerKey("red_poplar_fancy_placed");
    public static final ResourceKey<PlacedFeature> RED_POPLAR_DIAMOND_PLACED = registerKey("red_poplar_diamond_placed");
    public static final ResourceKey<PlacedFeature> RED_POPLAR_CHERRY_PLACED = registerKey("red_poplar_cherry_placed");
    public static final ResourceKey<PlacedFeature> RED_POPLAR_SLENDER_PLACED = registerKey("red_poplar_slender_placed");

    public static final ResourceKey<PlacedFeature> ORANGE_POPLAR_OAK_PLACED = registerKey("orange_poplar_oak_placed");
    public static final ResourceKey<PlacedFeature> ORANGE_POPLAR_FANCY_PLACED = registerKey("orange_poplar_fancy_placed");
    public static final ResourceKey<PlacedFeature> ORANGE_POPLAR_DIAMOND_PLACED = registerKey("orange_poplar_diamond_placed");
    public static final ResourceKey<PlacedFeature> ORANGE_POPLAR_CHERRY_PLACED = registerKey("orange_poplar_cherry_placed");
    public static final ResourceKey<PlacedFeature> ORANGE_POPLAR_SLENDER_PLACED = registerKey("orange_poplar_slender_placed");

    public static final ResourceKey<PlacedFeature> YELLOW_POPLAR_OAK_PLACED = registerKey("yellow_poplar_oak_placed");
    public static final ResourceKey<PlacedFeature> YELLOW_POPLAR_FANCY_PLACED = registerKey("yellow_poplar_fancy_placed");
    public static final ResourceKey<PlacedFeature> YELLOW_POPLAR_DIAMOND_PLACED = registerKey("yellow_poplar_diamond_placed");
    public static final ResourceKey<PlacedFeature> YELLOW_POPLAR_CHERRY_PLACED = registerKey("yellow_poplar_cherry_placed");
    public static final ResourceKey<PlacedFeature> YELLOW_POPLAR_SLENDER_PLACED = registerKey("yellow_poplar_slender_placed");

    public static void configure(BootstrapContext<PlacedFeature> context) {
        var cfg = context.lookup(Registries.CONFIGURED_FEATURE);

        register(context, RED_POPLAR_OAK_PLACED, cfg.getOrThrow(ModConfiguredFeatures.RED_POPLAR_OAK), ModBlocks.RED_POPLAR_SAPLING);
        register(context, RED_POPLAR_FANCY_PLACED, cfg.getOrThrow(ModConfiguredFeatures.RED_POPLAR_FANCY), ModBlocks.RED_POPLAR_SAPLING);
        register(context, RED_POPLAR_DIAMOND_PLACED, cfg.getOrThrow(ModConfiguredFeatures.RED_POPLAR_DIAMOND), ModBlocks.RED_POPLAR_SAPLING);
        register(context, RED_POPLAR_CHERRY_PLACED, cfg.getOrThrow(ModConfiguredFeatures.RED_POPLAR_CHERRY), ModBlocks.RED_POPLAR_SAPLING);
        register(context, RED_POPLAR_SLENDER_PLACED, cfg.getOrThrow(ModConfiguredFeatures.RED_POPLAR_SLENDER), ModBlocks.RED_POPLAR_SAPLING);

        register(context, ORANGE_POPLAR_OAK_PLACED, cfg.getOrThrow(ModConfiguredFeatures.ORANGE_POPLAR_OAK), ModBlocks.ORANGE_POPLAR_SAPLING);
        register(context, ORANGE_POPLAR_FANCY_PLACED, cfg.getOrThrow(ModConfiguredFeatures.ORANGE_POPLAR_FANCY), ModBlocks.ORANGE_POPLAR_SAPLING);
        register(context, ORANGE_POPLAR_DIAMOND_PLACED, cfg.getOrThrow(ModConfiguredFeatures.ORANGE_POPLAR_DIAMOND), ModBlocks.ORANGE_POPLAR_SAPLING);
        register(context, ORANGE_POPLAR_CHERRY_PLACED, cfg.getOrThrow(ModConfiguredFeatures.ORANGE_POPLAR_CHERRY), ModBlocks.ORANGE_POPLAR_SAPLING);
        register(context, ORANGE_POPLAR_SLENDER_PLACED, cfg.getOrThrow(ModConfiguredFeatures.ORANGE_POPLAR_SLENDER), ModBlocks.ORANGE_POPLAR_SAPLING);

        register(context, YELLOW_POPLAR_OAK_PLACED, cfg.getOrThrow(ModConfiguredFeatures.YELLOW_POPLAR_OAK), ModBlocks.YELLOW_POPLAR_SAPLING);
        register(context, YELLOW_POPLAR_FANCY_PLACED, cfg.getOrThrow(ModConfiguredFeatures.YELLOW_POPLAR_FANCY), ModBlocks.YELLOW_POPLAR_SAPLING);
        register(context, YELLOW_POPLAR_DIAMOND_PLACED, cfg.getOrThrow(ModConfiguredFeatures.YELLOW_POPLAR_DIAMOND), ModBlocks.YELLOW_POPLAR_SAPLING);
        register(context, YELLOW_POPLAR_CHERRY_PLACED, cfg.getOrThrow(ModConfiguredFeatures.YELLOW_POPLAR_CHERRY), ModBlocks.YELLOW_POPLAR_SAPLING);
        register(context, YELLOW_POPLAR_SLENDER_PLACED, cfg.getOrThrow(ModConfiguredFeatures.YELLOW_POPLAR_SLENDER), ModBlocks.YELLOW_POPLAR_SAPLING);
    }

    private static void register(BootstrapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> feature, Block sapling) {
        context.register(key, new PlacedFeature(feature, List.of(PlacementUtils.filteredByBlockSurvival(sapling))));
    }

    public static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, Identifier.fromNamespaceAndPath(CampsAndColors.MOD_ID, name));
    }
}
