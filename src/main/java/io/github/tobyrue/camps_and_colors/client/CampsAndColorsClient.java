package io.github.tobyrue.camps_and_colors.client;

import io.github.tobyrue.camps_and_colors.entities.ModEntities;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.ModelLayerRegistry;
import net.minecraft.client.model.object.boat.BoatModel;
import net.minecraft.client.renderer.entity.BoatRenderer;
import net.minecraft.client.renderer.entity.EntityRenderers;

public class CampsAndColorsClient implements ClientModInitializer {
    static {
        EntityRenderers.register(ModEntities.POPLAR_BOAT, (context) -> new BoatRenderer(context, ModModelLayers.POPLAR_BOAT));
        EntityRenderers.register(ModEntities.POPLAR_CHEST_BOAT, (context) -> new BoatRenderer(context, ModModelLayers.POPLAR_CHEST_BOAT));
    }
    @Override
    public void onInitializeClient() {
        ModelLayerRegistry.registerModelLayer(ModModelLayers.POPLAR_BOAT, BoatModel::createBoatModel);
        ModelLayerRegistry.registerModelLayer(ModModelLayers.POPLAR_CHEST_BOAT, BoatModel::createChestBoatModel);
    }
}
