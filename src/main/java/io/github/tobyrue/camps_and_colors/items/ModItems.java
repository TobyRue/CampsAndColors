package io.github.tobyrue.camps_and_colors.items;

import io.github.tobyrue.camps_and_colors.CampsAndColors;
import io.github.tobyrue.camps_and_colors.entities.ModEntities;
import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BoatItem;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;

import java.util.function.Function;

public class ModItems {
    public static final Item POPLAR_BOAT_ITEM = registerItem("poplar_boat",
            (properties) -> new BoatItem(ModEntities.POPLAR_BOAT, properties));

    public static final Item POPLAR_CHEST_BOAT_ITEM = registerItem("poplar_chest_boat",
            (properties) -> new BoatItem(ModEntities.POPLAR_CHEST_BOAT, properties));

    private static Item registerItem(String name, Function<Item.Properties, Item> itemFactory) {
        ResourceKey<Item> key = ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(CampsAndColors.MOD_ID, name));
        return Registry.register(BuiltInRegistries.ITEM, key, itemFactory.apply(new Item.Properties().setId(key)));
    }
    public static void initialize() {
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.TOOLS_AND_UTILITIES).register(content -> {
            content.insertAfter(Items.PALE_OAK_CHEST_BOAT, POPLAR_BOAT_ITEM, POPLAR_CHEST_BOAT_ITEM);
        });
    }
}
