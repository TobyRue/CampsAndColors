package io.github.tobyrue.camps_and_colors.feature;

import io.github.tobyrue.camps_and_colors.CampsAndColors;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import org.jetbrains.annotations.UnknownNullability;

public class ModFeatures {
    public static final Feature<NoneFeatureConfiguration> FALLEN_POPLAR_LOG = new FallenPoplarLogFeature(NoneFeatureConfiguration.CODEC);

    public static void registerFeatures() {
        Registry.register(BuiltInRegistries.FEATURE,
                Identifier.fromNamespaceAndPath(CampsAndColors.MOD_ID, "fallen_poplar_log"),
                FALLEN_POPLAR_LOG);
    }
}
