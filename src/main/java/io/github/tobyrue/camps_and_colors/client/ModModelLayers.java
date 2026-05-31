package io.github.tobyrue.camps_and_colors.client;

import io.github.tobyrue.camps_and_colors.CampsAndColors;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.Identifier;

public class ModModelLayers {
    public static final ModelLayerLocation POPLAR_BOAT = new ModelLayerLocation(
            Identifier.fromNamespaceAndPath(CampsAndColors.MOD_ID, "boat/poplar"), "main");

    public static final ModelLayerLocation POPLAR_CHEST_BOAT = new ModelLayerLocation(
            Identifier.fromNamespaceAndPath(CampsAndColors.MOD_ID, "chest_boat/poplar"), "main");
}