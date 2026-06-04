package io.github.tobyrue.camps_and_colors.feature;

import com.mojang.serialization.MapCodec;
import io.github.tobyrue.camps_and_colors.CampsAndColors;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType;
import org.jetbrains.annotations.UnknownNullability;

public class ModFeatures {
    public static final Feature<NoneFeatureConfiguration> FALLEN_POPLAR_LOG = new FallenPoplarLogFeature(NoneFeatureConfiguration.CODEC);

    public static void registerFeatures() {
        Registry.register(BuiltInRegistries.FEATURE,
                Identifier.fromNamespaceAndPath(CampsAndColors.MOD_ID, "fallen_poplar_log"),
                FALLEN_POPLAR_LOG);
    }

    public static final TreeDecoratorType<ShelfMushroomDecorator> SHELF_MUSHROOM_DECORATOR =
            register("shelf_mushrooms", ShelfMushroomDecorator.CODEC);

    private static <P extends TreeDecorator> TreeDecoratorType<P> register(String id, MapCodec<P> codec) {
        return Registry.register(BuiltInRegistries.TREE_DECORATOR_TYPE, Identifier.fromNamespaceAndPath(CampsAndColors.MOD_ID, id), new TreeDecoratorType<>(codec));
    }
}
