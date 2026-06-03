package io.github.tobyrue.camps_and_colors.blocks;

import io.github.tobyrue.camps_and_colors.CampsAndColors;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BedBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;

public class ModBlockEntities {

    public static final BlockEntityType<StrawBedBlockEntity> STRAW_BED_ENTITY =
            register("straw_bed_entity", StrawBedBlockEntity::new, ModBlocks.STRAW_BED);

    private static <T extends BlockEntity> BlockEntityType<T> register(
            String name,
            FabricBlockEntityTypeBuilder.Factory<? extends T> entityFactory,
            Block... blocks
    ) {
        Identifier id = Identifier.fromNamespaceAndPath(CampsAndColors.MOD_ID, name);
        return Registry.register(BuiltInRegistries.BLOCK_ENTITY_TYPE, id, FabricBlockEntityTypeBuilder.<T>create(entityFactory, blocks).build());
    }

    public static void initialize() {

        BlockEntityType.SIGN.addValidBlock(ModBlocks.POPLAR_SIGN);
        BlockEntityType.SIGN.addValidBlock(ModBlocks.POPLAR_WALL_SIGN);

        BlockEntityType.HANGING_SIGN.addValidBlock(ModBlocks.POPLAR_HANGING_SIGN);
        BlockEntityType.HANGING_SIGN.addValidBlock(ModBlocks.POPLAR_WALL_HANGING_SIGN);


        BlockEntityType.SHELF.addValidBlock(ModBlocks.POPLAR_SHELF);

    }
}
