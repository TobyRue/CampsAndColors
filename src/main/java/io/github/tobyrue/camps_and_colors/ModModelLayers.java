package io.github.tobyrue.camps_and_colors;

//import io.github.tobyrue.camps_and_colors.client.StrawBedModel;
import net.fabricmc.fabric.api.client.rendering.v1.ModelLayerRegistry;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.Identifier;

public class ModModelLayers {
    public static final ModelLayerLocation POPLAR_BOAT = new ModelLayerLocation(
            Identifier.fromNamespaceAndPath(CampsAndColors.MOD_ID, "boat/poplar"), "main");

    public static final ModelLayerLocation POPLAR_CHEST_BOAT = new ModelLayerLocation(
            Identifier.fromNamespaceAndPath(CampsAndColors.MOD_ID, "chest_boat/poplar"), "main");

//    public static final ModelLayerLocation STRAW_BED = createMain("straw_bed");
//
//    public static ModelLayerLocation createMain(String name) {
//        return new ModelLayerLocation(Identifier.fromNamespaceAndPath(CampsAndColors.MOD_ID, name), "main");
//    }

    public static void registerModelLayers() {
//        ModelLayerRegistry.registerModelLayer(STRAW_BED, StrawBedModel::createBodyLayer);
    }
}