package io.github.tobyrue.camps_and_colors;

import io.github.tobyrue.camps_and_colors.blocks.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.WeightedPlacedFeature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.RandomFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.CherryFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FancyFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.SpruceFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.CherryTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.FancyTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;

import java.util.List;
import java.util.OptionalInt;

public class ModConfiguredFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> RED_POPLAR_OAK = registerKey("red_poplar_oak");
    public static final ResourceKey<ConfiguredFeature<?, ?>> RED_POPLAR_FANCY = registerKey("red_poplar_fancy");
    public static final ResourceKey<ConfiguredFeature<?, ?>> RED_POPLAR_DIAMOND = registerKey("red_poplar_diamond");
    public static final ResourceKey<ConfiguredFeature<?, ?>> RED_POPLAR_CHERRY = registerKey("red_poplar_cherry");
    public static final ResourceKey<ConfiguredFeature<?, ?>> RED_POPLAR_SLENDER = registerKey("red_poplar_slender");

    public static final ResourceKey<ConfiguredFeature<?, ?>> ORANGE_POPLAR_OAK = registerKey("orange_poplar_oak");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORANGE_POPLAR_FANCY = registerKey("orange_poplar_fancy");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORANGE_POPLAR_DIAMOND = registerKey("orange_poplar_diamond");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORANGE_POPLAR_CHERRY = registerKey("orange_poplar_cherry");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORANGE_POPLAR_SLENDER = registerKey("orange_poplar_slender");

    public static final ResourceKey<ConfiguredFeature<?, ?>> YELLOW_POPLAR_OAK = registerKey("yellow_poplar_oak");
    public static final ResourceKey<ConfiguredFeature<?, ?>> YELLOW_POPLAR_FANCY = registerKey("yellow_poplar_fancy");
    public static final ResourceKey<ConfiguredFeature<?, ?>> YELLOW_POPLAR_DIAMOND = registerKey("yellow_poplar_diamond");
    public static final ResourceKey<ConfiguredFeature<?, ?>> YELLOW_POPLAR_CHERRY = registerKey("yellow_poplar_cherry");
    public static final ResourceKey<ConfiguredFeature<?, ?>> YELLOW_POPLAR_SLENDER = registerKey("yellow_poplar_slender");



    public static final ResourceKey<ConfiguredFeature<?, ?>> RED_POPLAR_ALL_VARIANTS = registerKey("red_poplar_all_variants");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORANGE_POPLAR_ALL_VARIANTS = registerKey("orange_poplar_all_variants");
    public static final ResourceKey<ConfiguredFeature<?, ?>> YELLOW_POPLAR_ALL_VARIANTS = registerKey("yellow_poplar_all_variants");


    public static void configure(BootstrapContext<ConfiguredFeature<?, ?>> context) {
        var placed = context.lookup(Registries.PLACED_FEATURE);

        context.register(RED_POPLAR_ALL_VARIANTS, new ConfiguredFeature<>(Feature.RANDOM_SELECTOR,
                new RandomFeatureConfiguration(List.of(
                        new WeightedPlacedFeature(placed.getOrThrow(ModPlacedFeatures.RED_POPLAR_FANCY_PLACED), 0.1f),
                        new WeightedPlacedFeature(placed.getOrThrow(ModPlacedFeatures.RED_POPLAR_CHERRY_PLACED), 0.15f),
                        new WeightedPlacedFeature(placed.getOrThrow(ModPlacedFeatures.RED_POPLAR_DIAMOND_PLACED), 0.2f),
                        new WeightedPlacedFeature(placed.getOrThrow(ModPlacedFeatures.RED_POPLAR_OAK_PLACED), 0.25f)
                ), placed.getOrThrow(ModPlacedFeatures.RED_POPLAR_SLENDER_PLACED))
        ));
        context.register(ORANGE_POPLAR_ALL_VARIANTS, new ConfiguredFeature<>(Feature.RANDOM_SELECTOR,
                new RandomFeatureConfiguration(List.of(
                        new WeightedPlacedFeature(placed.getOrThrow(ModPlacedFeatures.ORANGE_POPLAR_FANCY_PLACED), 0.1f),
                        new WeightedPlacedFeature(placed.getOrThrow(ModPlacedFeatures.ORANGE_POPLAR_CHERRY_PLACED), 0.15f),
                        new WeightedPlacedFeature(placed.getOrThrow(ModPlacedFeatures.ORANGE_POPLAR_DIAMOND_PLACED), 0.2f),
                        new WeightedPlacedFeature(placed.getOrThrow(ModPlacedFeatures.ORANGE_POPLAR_OAK_PLACED), 0.25f)
                ), placed.getOrThrow(ModPlacedFeatures.ORANGE_POPLAR_SLENDER_PLACED))
        ));
        context.register(YELLOW_POPLAR_ALL_VARIANTS, new ConfiguredFeature<>(Feature.RANDOM_SELECTOR,
                new RandomFeatureConfiguration(List.of(
                        new WeightedPlacedFeature(placed.getOrThrow(ModPlacedFeatures.YELLOW_POPLAR_FANCY_PLACED), 0.1f),
                        new WeightedPlacedFeature(placed.getOrThrow(ModPlacedFeatures.YELLOW_POPLAR_CHERRY_PLACED), 0.15f),
                        new WeightedPlacedFeature(placed.getOrThrow(ModPlacedFeatures.YELLOW_POPLAR_DIAMOND_PLACED), 0.2f),
                        new WeightedPlacedFeature(placed.getOrThrow(ModPlacedFeatures.YELLOW_POPLAR_OAK_PLACED), 0.25f)
                ), placed.getOrThrow(ModPlacedFeatures.YELLOW_POPLAR_SLENDER_PLACED))
        ));


        register(context, RED_POPLAR_OAK, Feature.TREE, oak(ModBlocks.RED_POPLAR_LEAVES));
        register(context, RED_POPLAR_FANCY, Feature.TREE, fancy(ModBlocks.RED_POPLAR_LEAVES));
        register(context, RED_POPLAR_DIAMOND, Feature.TREE, diamond(ModBlocks.RED_POPLAR_LEAVES));
        register(context, RED_POPLAR_CHERRY, Feature.TREE, cherry(ModBlocks.RED_POPLAR_LEAVES));
        register(context, RED_POPLAR_SLENDER, Feature.TREE, slender(ModBlocks.RED_POPLAR_LEAVES));
        register(context, YELLOW_POPLAR_OAK, Feature.TREE, oak(ModBlocks.YELLOW_POPLAR_LEAVES));
        register(context, YELLOW_POPLAR_FANCY, Feature.TREE, fancy(ModBlocks.YELLOW_POPLAR_LEAVES));
        register(context, YELLOW_POPLAR_DIAMOND, Feature.TREE, diamond(ModBlocks.YELLOW_POPLAR_LEAVES));
        register(context, YELLOW_POPLAR_CHERRY, Feature.TREE, cherry(ModBlocks.YELLOW_POPLAR_LEAVES));
        register(context, YELLOW_POPLAR_SLENDER, Feature.TREE, slender(ModBlocks.YELLOW_POPLAR_LEAVES));
        register(context, ORANGE_POPLAR_OAK, Feature.TREE, oak(ModBlocks.ORANGE_POPLAR_LEAVES));
        register(context, ORANGE_POPLAR_FANCY, Feature.TREE, fancy(ModBlocks.ORANGE_POPLAR_LEAVES));
        register(context, ORANGE_POPLAR_DIAMOND, Feature.TREE, diamond(ModBlocks.ORANGE_POPLAR_LEAVES));
        register(context, ORANGE_POPLAR_CHERRY, Feature.TREE, cherry(ModBlocks.ORANGE_POPLAR_LEAVES));
        register(context, ORANGE_POPLAR_SLENDER, Feature.TREE, slender(ModBlocks.ORANGE_POPLAR_LEAVES));
    }

    private static TreeConfiguration oak(Block leaves) {
        return new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(ModBlocks.POPLAR_LOG),
                new StraightTrunkPlacer(4, 2, 0),
                BlockStateProvider.simple(leaves),
                new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3),
                new TwoLayersFeatureSize(1, 0, 1)
        ).ignoreVines().build();
    }

    private static TreeConfiguration fancy(Block leaves) {
        return new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(ModBlocks.POPLAR_LOG),
                new FancyTrunkPlacer(3, 11, 0),
                BlockStateProvider.simple(leaves),
                new FancyFoliagePlacer(ConstantInt.of(2), ConstantInt.of(4), 4),
                new TwoLayersFeatureSize(0, 0, 0, OptionalInt.of(4))
        ).ignoreVines().build();
    }

    private static TreeConfiguration diamond(Block leaves) {
        return new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(ModBlocks.POPLAR_LOG),
                new StraightTrunkPlacer(5, 2, 1),
                BlockStateProvider.simple(leaves),
                new SpruceFoliagePlacer(UniformInt.of(2, 3), ConstantInt.of(0), UniformInt.of(1, 2)),
                new TwoLayersFeatureSize(2, 0, 2)
        ).ignoreVines().build();
    }

    private static TreeConfiguration cherry(Block leaves) {
        return new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(ModBlocks.POPLAR_LOG),
                new CherryTrunkPlacer(7, 1, 0, ConstantInt.of(3), ConstantInt.of(2), UniformInt.of(1, 2), ConstantInt.of(1)),
                BlockStateProvider.simple(leaves),
                new CherryFoliagePlacer(ConstantInt.of(4), ConstantInt.of(0), ConstantInt.of(5), 0.25f, 0.5f, 0.16f, 0.11f),
                new TwoLayersFeatureSize(1, 0, 2)
        ).ignoreVines().build();
    }

    private static TreeConfiguration slender(Block leaves) {
        return new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(ModBlocks.POPLAR_LOG),
                new StraightTrunkPlacer(10, 3, 0),
                BlockStateProvider.simple(leaves),
                new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 5), // Height 5 makes it slender
                new TwoLayersFeatureSize(1, 0, 1)
        ).ignoreVines().build();
    }
    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, Identifier.fromNamespaceAndPath(CampsAndColors.MOD_ID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstrapContext<ConfiguredFeature<?, ?>> context, ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
