package io.github.tobyrue.camps_and_colors.biome;

import io.github.tobyrue.camps_and_colors.CampsAndColors;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;

public class Biomes {
    public static final ResourceKey<Biome> DAPPLED_FOREST = register("dappled_forest");

    private static ResourceKey<Biome> register(String name)
    {
        return ResourceKey.create(Registries.BIOME, Identifier.fromNamespaceAndPath(CampsAndColors.MOD_ID, name));
    }
}
