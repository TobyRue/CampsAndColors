package io.github.tobyrue.camps_and_colors.blocks;

import io.github.tobyrue.camps_and_colors.CampsAndColors;
import net.fabricmc.fabric.api.object.builder.v1.block.type.BlockSetTypeBuilder;
import net.fabricmc.fabric.api.object.builder.v1.block.type.WoodTypeBuilder;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;

public class ModWoodTypes {
    public static final BlockSetType POPLAR_BLOCK_SET_TYPE = BlockSetTypeBuilder.copyOf(BlockSetType.OAK)
            .register(Identifier.fromNamespaceAndPath(CampsAndColors.MOD_ID, "poplar"));

    public static final WoodType POPLAR = WoodTypeBuilder.copyOf(WoodType.OAK)
            .register(Identifier.fromNamespaceAndPath(CampsAndColors.MOD_ID, "poplar"), POPLAR_BLOCK_SET_TYPE);
}
