package io.github.tobyrue.camps_and_colors.biome;

import io.github.tobyrue.camps_and_colors.CampsAndColors;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Climate;
import oshi.util.tuples.Pair;
import terrablender.api.ParameterUtils;
import terrablender.api.Region;
import terrablender.api.RegionType;
import terrablender.api.VanillaParameterOverlayBuilder;

import java.util.List;
import java.util.function.Consumer;

public class ModOverworldRegion extends Region {
    public ModOverworldRegion(Identifier name, int weight) {
        super(name, RegionType.OVERWORLD, weight);
    }

//    @Override
//    public void addBiomes(net.minecraft.core.Registry<Biome> registry, Consumer<com.mojang.datafixers.util.Pair<Climate.ParameterPoint, ResourceKey<Biome>>> mapper) {
//        super.addBiomes(registry, mapper);
//        this.addModifiedVanillaOverworldBiomes(mapper, builder -> {
////            List<Climate.ParameterPoint> dappledForestPoints = new ParameterUtils.ParameterPointListBuilder()
////                    .temperature(ParameterUtils.Temperature.span(ParameterUtils.Temperature.COOL, ParameterUtils.Temperature.NEUTRAL))
////                    .humidity(ParameterUtils.Humidity.span(ParameterUtils.Humidity.NEUTRAL, ParameterUtils.Humidity.HUMID))
////                    .continentalness(ParameterUtils.Continentalness.INLAND, ParameterUtils.Continentalness.FAR_INLAND, ParameterUtils.Continentalness.MID_INLAND)
////                    .erosion(ParameterUtils.Erosion.span(ParameterUtils.Erosion.EROSION_0, ParameterUtils.Erosion.EROSION_4))
////                    .depth(ParameterUtils.Depth.SURFACE)
////                    .weirdness(ParameterUtils.Weirdness.span(ParameterUtils.Weirdness.MID_SLICE_NORMAL_ASCENDING, ParameterUtils.Weirdness.MID_SLICE_NORMAL_DESCENDING))
////                    .build();
//
//
////            dappledForestPoints.forEach(point -> builder.replaceBiome(point, Biomes.DAPPLED_FOREST));
//            builder.replaceBiome(net.minecraft.world.level.biome.Biomes.FOREST, Biomes.DAPPLED_FOREST);
////            builder.replaceBiome(net.minecraft.world.level.biome.Biomes.PLAINS, dappledForestKey);
//        });
//    }

    @Override
    public void addBiomes(net.minecraft.core.Registry<Biome> registry, Consumer<com.mojang.datafixers.util.Pair<Climate.ParameterPoint, ResourceKey<Biome>>> mapper) {
        VanillaParameterOverlayBuilder builder = new VanillaParameterOverlayBuilder();
        new ParameterUtils.ParameterPointListBuilder()
                .temperature(ParameterUtils.Temperature.FULL_RANGE)
                .humidity(ParameterUtils.Humidity.FULL_RANGE)
                .continentalness(ParameterUtils.Continentalness.INLAND)
                .erosion(ParameterUtils.Erosion.EROSION_0, ParameterUtils.Erosion.EROSION_1)
                .depth(ParameterUtils.Depth.SURFACE, ParameterUtils.Depth.FLOOR)
                .weirdness(ParameterUtils.Weirdness.MID_SLICE_NORMAL_ASCENDING, ParameterUtils.Weirdness.MID_SLICE_NORMAL_DESCENDING)
                .build().forEach(point -> builder.add(point, Biomes.DAPPLED_FOREST));

        builder.build().forEach(mapper);
    }
}