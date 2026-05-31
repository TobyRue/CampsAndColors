package io.github.tobyrue.camps_and_colors.entities;

import io.github.tobyrue.camps_and_colors.CampsAndColors;
import io.github.tobyrue.camps_and_colors.items.ModItems;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.vehicle.boat.Boat;
import net.minecraft.world.entity.vehicle.boat.ChestBoat;
import net.minecraft.world.item.Item;

import java.util.function.Supplier;

public class ModEntities {
    public static final EntityType<Boat> POPLAR_BOAT = register("poplar_boat", EntityType.Builder.of(boatFactory(() -> ModItems.POPLAR_BOAT_ITEM), MobCategory.MISC).noLootTable().sized(1.375F, 0.5625F).eyeHeight(0.5625F).clientTrackingRange(10));

    public static final EntityType<ChestBoat> POPLAR_CHEST_BOAT = register("poplar_chest_boat", EntityType.Builder.of(chestBoatFactory(() -> ModItems.POPLAR_CHEST_BOAT_ITEM), MobCategory.MISC).noLootTable().sized(1.375F, 0.5625F).eyeHeight(0.5625F).clientTrackingRange(10));

    private static EntityType.EntityFactory<Boat> boatFactory(final Supplier<Item> boatItem) {
        return (entityType, level) -> new Boat(entityType, level, boatItem);
    }

    private static EntityType.EntityFactory<ChestBoat> chestBoatFactory(final Supplier<Item> dropItem) {
        return (entityType, level) -> new ChestBoat(entityType, level, dropItem);
    }


    private static ResourceKey<EntityType<?>> entityId(final String id) {
        return ResourceKey.create(Registries.ENTITY_TYPE, Identifier.fromNamespaceAndPath(CampsAndColors.MOD_ID, id));
    }

    private static <T extends Entity> EntityType<T> register(final String vanillaId, final EntityType.Builder<T> builder) {
        return register(entityId(vanillaId), builder);
    }
    private static <T extends Entity> EntityType<T> register(final ResourceKey<EntityType<?>> id, final EntityType.Builder<T> builder) {
        return Registry.register(BuiltInRegistries.ENTITY_TYPE, id, builder.build(id));
    }


}
