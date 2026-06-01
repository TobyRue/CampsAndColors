package io.github.tobyrue.camps_and_colors.blocks;

import io.github.tobyrue.camps_and_colors.CampsAndColors;
import io.github.tobyrue.camps_and_colors.ModConfiguredFeatures;
import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.minecraft.client.color.block.BlockColors;
import net.minecraft.core.Direction;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.grower.TreeGrower;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;

import java.util.HashMap;
import java.util.Optional;
import java.util.function.Function;

public class ModBlocks {
    private static Block register(String name, Function<BlockBehaviour.Properties, Block> blockFactory, BlockBehaviour.Properties settings, boolean shouldRegisterItem) {
        ResourceKey<Block> blockKey = keyOfBlock(name);
        Block block = blockFactory.apply(settings.setId(blockKey));

        if (shouldRegisterItem) {
            ResourceKey<Item> itemKey = keyOfItem(name);

            BlockItem blockItem = new BlockItem(block, new Item.Properties().setId(itemKey).useBlockDescriptionPrefix());
            Registry.register(BuiltInRegistries.ITEM, itemKey, blockItem);
        }

        return Registry.register(BuiltInRegistries.BLOCK, blockKey, block);
    }

    private static ResourceKey<Block> keyOfBlock(String name) {
        return ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(CampsAndColors.MOD_ID, name));
    }

    private static ResourceKey<Item> keyOfItem(String name) {
        return ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(CampsAndColors.MOD_ID, name));
    }

    private static Block registerStair(final String id, final Block base, final boolean shouldRegisterItem) {
        return register(id, (p) -> new StairBlock(base.defaultBlockState(), p), BlockBehaviour.Properties.ofFullCopy(base), shouldRegisterItem);
    }


    public static final HashMap<DyeColor, Block> WOOL = new HashMap<>() {{
        put(DyeColor.BLACK, Blocks.BLACK_WOOL);
        put(DyeColor.WHITE, Blocks.WHITE_WOOL);
        put(DyeColor.LIGHT_GRAY, Blocks.LIGHT_GRAY_WOOL);
        put(DyeColor.GRAY, Blocks.GRAY_WOOL);
        put(DyeColor.RED, Blocks.RED_WOOL);
        put(DyeColor.ORANGE, Blocks.ORANGE_WOOL);
        put(DyeColor.YELLOW, Blocks.YELLOW_WOOL);
        put(DyeColor.LIME, Blocks.LIME_WOOL);
        put(DyeColor.GREEN, Blocks.GREEN_WOOL);
        put(DyeColor.BLUE, Blocks.BLUE_WOOL);
        put(DyeColor.LIGHT_BLUE, Blocks.LIGHT_BLUE_WOOL);
        put(DyeColor.CYAN, Blocks.CYAN_WOOL);
        put(DyeColor.MAGENTA, Blocks.MAGENTA_WOOL);
        put(DyeColor.PINK, Blocks.PINK_WOOL);
        put(DyeColor.PURPLE, Blocks.PURPLE_WOOL);
        put(DyeColor.BROWN, Blocks.BROWN_WOOL);
    }};

    public static final HashMap<DyeColor, Block> WOOL_STAIRS = new HashMap<>() {{
        for (var color : DyeColor.values()) {
            this.put(color, registerStair(color.getName() + "_wool_stairs", WOOL.get(color), true));
        }
    }};
    public static final HashMap<DyeColor, Block> WOOL_SLAB = new HashMap<>() {{
        for (var color : DyeColor.values()) {
            this.put(color, register(color.getName() + "_wool_slab", SlabBlock::new, BlockBehaviour.Properties.ofFullCopy(WOOL.get(color)), true));
        }
    }};

    public static final HashMap<DyeColor, Block> CONCRETE = new HashMap<>() {{
        put(DyeColor.BLACK, Blocks.BLACK_CONCRETE);
        put(DyeColor.WHITE, Blocks.WHITE_CONCRETE);
        put(DyeColor.LIGHT_GRAY, Blocks.LIGHT_GRAY_CONCRETE);
        put(DyeColor.GRAY, Blocks.GRAY_CONCRETE);
        put(DyeColor.RED, Blocks.RED_CONCRETE);
        put(DyeColor.ORANGE, Blocks.ORANGE_CONCRETE);
        put(DyeColor.YELLOW, Blocks.YELLOW_CONCRETE);
        put(DyeColor.LIME, Blocks.LIME_CONCRETE);
        put(DyeColor.GREEN, Blocks.GREEN_CONCRETE);
        put(DyeColor.BLUE, Blocks.BLUE_CONCRETE);
        put(DyeColor.LIGHT_BLUE, Blocks.LIGHT_BLUE_CONCRETE);
        put(DyeColor.CYAN, Blocks.CYAN_CONCRETE);
        put(DyeColor.MAGENTA, Blocks.MAGENTA_CONCRETE);
        put(DyeColor.PINK, Blocks.PINK_CONCRETE);
        put(DyeColor.PURPLE, Blocks.PURPLE_CONCRETE);
        put(DyeColor.BROWN, Blocks.BROWN_CONCRETE);
    }};

    public static final HashMap<DyeColor, Block> CONCRETE_STAIRS = new HashMap<>() {{
        for (var color : DyeColor.values()) {
            this.put(color, registerStair(color.getName() + "_concrete_stairs", CONCRETE.get(color), true));
        }
    }};
    public static final HashMap<DyeColor, Block> CONCRETE_SLAB = new HashMap<>() {{
        for (var color : DyeColor.values()) {
            this.put(color, register(color.getName() + "_concrete_slab", SlabBlock::new, BlockBehaviour.Properties.ofFullCopy(CONCRETE.get(color)), true));
        }
    }};

    public static final Block POPLAR_LOG = registerLog("poplar_log", MapColor.WOOD, MapColor.PODZOL);
    public static final Block POPLAR_WOOD = registerLog("poplar_wood", MapColor.WOOD, MapColor.WOOD);
    public static final Block STRIPPED_POPLAR_LOG = registerLog("stripped_poplar_log", MapColor.WOOD, MapColor.WOOD);
    public static final Block STRIPPED_POPLAR_WOOD = registerLog("stripped_poplar_wood", MapColor.WOOD, MapColor.WOOD);

    public static final Block POPLAR_PLANKS = register("poplar_planks", Block::new, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS), true);
    public static final Block POPLAR_STAIRS = registerStair("poplar_stairs", POPLAR_PLANKS, true);
    public static final Block POPLAR_SLAB = register("poplar_slab", SlabBlock::new, BlockBehaviour.Properties.ofFullCopy(POPLAR_PLANKS), true);
    public static final Block POPLAR_FENCE = register("poplar_fence", FenceBlock::new, BlockBehaviour.Properties.ofFullCopy(POPLAR_PLANKS), true);
    public static final Block POPLAR_FENCE_GATE = register("poplar_fence_gate", (p) -> new FenceGateBlock(ModWoodTypes.POPLAR, p), BlockBehaviour.Properties.ofFullCopy(POPLAR_PLANKS), true);
    public static final Block POPLAR_PRESSURE_PLATE = register("poplar_pressure_plate", (p) -> new PressurePlateBlock(BlockSetType.OAK, p), BlockBehaviour.Properties.ofFullCopy(POPLAR_PLANKS), true);
    public static final Block POPLAR_BUTTON = register("poplar_button", (p) -> new ButtonBlock(BlockSetType.OAK, 15, p), BlockBehaviour.Properties.ofFullCopy(POPLAR_PLANKS), true);
    public static final Block POPLAR_DOOR = register("poplar_door", (p) -> new DoorBlock(BlockSetType.OAK, p), BlockBehaviour.Properties.of().mapColor(POPLAR_PLANKS.defaultMapColor()).instrument(NoteBlockInstrument.BASS).strength(3.0F).noOcclusion().ignitedByLava().pushReaction(PushReaction.DESTROY), true);
    public static final Block POPLAR_TRAPDOOR = register("poplar_trapdoor", (p) -> new TrapDoorBlock(BlockSetType.OAK, p), BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).instrument(NoteBlockInstrument.BASS).strength(3.0F).noOcclusion().isValidSpawn(Blocks::never).ignitedByLava(), true);
    public static final Block POPLAR_SHELF = register("poplar_shelf", ShelfBlock::new, BlockBehaviour.Properties.of().mapColor(POPLAR_PLANKS.defaultMapColor()).instrument(NoteBlockInstrument.BASS).sound(SoundType.SHELF).ignitedByLava().strength(2.0F, 3.0F), true);

    public static final Block POPLAR_WALL_SIGN = register("poplar_wall_sign",
            (p) -> new WallSignBlock(ModWoodTypes.POPLAR, p),
            BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WALL_SIGN), false);

    public static final Block POPLAR_WALL_HANGING_SIGN = register("poplar_wall_hanging_sign",
            (p) -> new WallHangingSignBlock(ModWoodTypes.POPLAR, p),
            BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WALL_HANGING_SIGN), false);

    public static final Block POPLAR_SIGN = registerSign("poplar_sign", POPLAR_WALL_SIGN);

    public static final Block POPLAR_HANGING_SIGN = registerHangingSign("poplar_hanging_sign", POPLAR_WALL_HANGING_SIGN);


    public static final Block RED_POPLAR_LEAVES = register("red_poplar_leaves", (p) -> new UntintedParticleLeavesBlock(0.1F, CampsAndColors.RED_POPLAR_LEAVES_PARTICLE, p), leavesProperties(SoundType.GRASS), true);
    public static final Block ORANGE_POPLAR_LEAVES = register("orange_poplar_leaves", (p) -> new UntintedParticleLeavesBlock(0.1F, CampsAndColors.ORANGE_POPLAR_LEAVES_PARTICLE, p), leavesProperties(SoundType.GRASS), true);
    public static final Block YELLOW_POPLAR_LEAVES = register("yellow_poplar_leaves", (p) -> new UntintedParticleLeavesBlock(0.1F, CampsAndColors.YELLOW_POPLAR_LEAVES_PARTICLE, p), leavesProperties(SoundType.GRASS), true);

    public static final Block RED_POPLAR_SAPLING = register("red_poplar_sapling",
            (p) -> new SaplingBlock(PoplarTreeGrower.RED, p),
            BlockBehaviour.Properties.of()
                    .mapColor(MapColor.PLANT)
                    .noCollision()
                    .randomTicks()
                    .instabreak()
                    .sound(SoundType.GRASS)
                    .pushReaction(PushReaction.DESTROY),
            true);


    public static final Block ORANGE_POPLAR_SAPLING = register("orange_poplar_sapling",
            (p) -> new SaplingBlock(PoplarTreeGrower.ORANGE, p),
            BlockBehaviour.Properties.of()
                    .mapColor(MapColor.PLANT)
                    .noCollision()
                    .randomTicks()
                    .instabreak()
                    .sound(SoundType.GRASS)
                    .pushReaction(PushReaction.DESTROY),
            true);

    public static final Block YELLOW_POPLAR_SAPLING = register("yellow_poplar_sapling",
            (p) -> new SaplingBlock(PoplarTreeGrower.YELLOW, p),
            BlockBehaviour.Properties.of()
                    .mapColor(MapColor.PLANT)
                    .noCollision()
                    .randomTicks()
                    .instabreak()
                    .sound(SoundType.GRASS)
                    .pushReaction(PushReaction.DESTROY),
            true);

    public static BlockBehaviour.Properties leavesProperties(final SoundType soundType) {
        return BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).strength(0.2F).randomTicks().sound(soundType).noOcclusion().isValidSpawn(Blocks::ocelotOrParrot).isSuffocating(Blocks::never).isViewBlocking(Blocks::never).ignitedByLava().pushReaction(PushReaction.DESTROY).isRedstoneConductor(Blocks::never);
    }


    private static Block registerSign(String name, Block wallVariant) {
        ResourceKey<Block> blockKey = keyOfBlock(name);
        Block block = new StandingSignBlock(ModWoodTypes.POPLAR, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SIGN).setId(blockKey));

        ResourceKey<Item> itemKey = keyOfItem(name);
        Registry.register(BuiltInRegistries.ITEM, itemKey, new SignItem(block, wallVariant, new Item.Properties().setId(itemKey)));

        return Registry.register(BuiltInRegistries.BLOCK, blockKey, block);
    }

    private static Block registerHangingSign(String name, Block wallVariant) {
        ResourceKey<Block> blockKey = keyOfBlock(name);
        Block block = new CeilingHangingSignBlock(ModWoodTypes.POPLAR, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_HANGING_SIGN).setId(blockKey));

        ResourceKey<Item> itemKey = keyOfItem(name);
        Registry.register(BuiltInRegistries.ITEM, itemKey, new HangingSignItem(block, wallVariant, new Item.Properties().setId(itemKey)));

        return Registry.register(BuiltInRegistries.BLOCK, blockKey, block);
    }

    private static Block registerLog(String name, MapColor topColor, MapColor sideColor) {
        return register(name, RotatedPillarBlock::new,
                BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG).mapColor(state ->
                        state.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? topColor : sideColor), true);
    }

    public static void initialize() {
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.COLORED_BLOCKS).register(content -> {
            for (DyeColor color : DyeColor.values()) {
                Item vanillaWool = Item.byBlock(WOOL.get(color));
                content.insertAfter(vanillaWool, WOOL_STAIRS.get(color));
                content.insertAfter(WOOL_STAIRS.get(color), WOOL_SLAB.get(color));
            }
        });
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.COLORED_BLOCKS).register(content -> {
            for (DyeColor color : DyeColor.values()) {
                Item vanillaWool = Item.byBlock(CONCRETE.get(color));
                content.insertAfter(vanillaWool, CONCRETE_STAIRS.get(color));
                content.insertAfter(CONCRETE_STAIRS.get(color), CONCRETE_SLAB.get(color));
            }
        });
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.BUILDING_BLOCKS).register(content -> {
            content.insertAfter(Items.PALE_OAK_BUTTON, POPLAR_LOG, POPLAR_WOOD,
                    STRIPPED_POPLAR_LOG, STRIPPED_POPLAR_WOOD, POPLAR_PLANKS,
                    POPLAR_STAIRS, POPLAR_SLAB, POPLAR_FENCE, POPLAR_FENCE_GATE,
                    POPLAR_DOOR, POPLAR_TRAPDOOR, POPLAR_PRESSURE_PLATE, POPLAR_BUTTON);
        });
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.FUNCTIONAL_BLOCKS).register(content -> {
            content.insertAfter(Items.PALE_OAK_SHELF, POPLAR_SHELF);
            content.insertAfter(Items.PALE_OAK_HANGING_SIGN, POPLAR_SIGN, POPLAR_HANGING_SIGN);
        });
    }
    public static class PoplarTreeGrower {
        public static final TreeGrower RED = new TreeGrower(
                "red_poplar",        // Name
                0.0f,                // secondaryChance
                Optional.empty(),    // megaTree
                Optional.empty(),    // secondaryMegaTree
                Optional.of(ModConfiguredFeatures.RED_POPLAR_ALL_VARIANTS),
                Optional.empty(),    // secondaryTree
                Optional.empty(),    // flowers
                Optional.empty()     // secondaryFlowers
        );
        public static final TreeGrower ORANGE = new TreeGrower(
                "orange_poplar",        // Name
                0.0f,                // secondaryChance
                Optional.empty(),    // megaTree
                Optional.empty(),    // secondaryMegaTree
                Optional.of(ModConfiguredFeatures.ORANGE_POPLAR_ALL_VARIANTS),
                Optional.empty(),    // secondaryTree
                Optional.empty(),    // flowers
                Optional.empty()     // secondaryFlowers
        );
        public static final TreeGrower YELLOW = new TreeGrower(
                "yellow_poplar",        // Name
                0.0f,                // secondaryChance
                Optional.empty(),    // megaTree
                Optional.empty(),    // secondaryMegaTree
                Optional.of(ModConfiguredFeatures.YELLOW_POPLAR_ALL_VARIANTS),
                Optional.empty(),    // secondaryTree
                Optional.empty(),    // flowers
                Optional.empty()     // secondaryFlowers
        );

    }
}
