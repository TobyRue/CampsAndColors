package io.github.tobyrue.camps_and_colors;

import io.github.tobyrue.camps_and_colors.blocks.ModBlocks;
import io.github.tobyrue.camps_and_colors.items.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {


    public ModRecipeProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }



    @Override
    protected RecipeProvider createRecipeProvider(HolderLookup.Provider registries, RecipeOutput output) {
        return new RecipeProvider(registries, output) {
            @Override
            public void buildRecipes() {
                shaped(RecipeCategory.DECORATIONS, ModBlocks.STRAW_BED)
                        .define('H', Items.HAY_BLOCK)
                        .pattern("HHH")
                        .unlockedBy("has_hay_block", has(Items.HAY_BLOCK))
                        .save(output);

                // --- DYEING RECIPES ---
                for (DyeColor color : DyeColor.values()) {
                    Block woolStairs = ModBlocks.WOOL_STAIRS.get(color);
                    Block woolSlab = ModBlocks.WOOL_SLAB.get(color);
                    Block concreteStairs = ModBlocks.CONCRETE_STAIRS.get(color);
                    Block concreteSlab = ModBlocks.CONCRETE_SLAB.get(color);
                    Item dye = BuiltInRegistries.ITEM.get(Identifier.fromNamespaceAndPath("minecraft", color.getName() + "_dye")).map(Holder.Reference::value).orElse(Items.AIR);;

                    // Dyeing Stairs (8 stairs + 1 dye = 8 dyed stairs)

                    dyeStairOrSlab(output, woolStairs, ModBlocks.WOOL_STAIRS.values(), dye);
                    dyeStairOrSlab(output, concreteStairs, ModBlocks.CONCRETE_STAIRS.values(), dye);

                    // Dyeing Slabs (8 slabs + 1 dye = 8 dyed slabs)
                    dyeStairOrSlab(output, woolSlab, ModBlocks.WOOL_SLAB.values(), dye);
                    dyeStairOrSlab(output, concreteSlab, ModBlocks.CONCRETE_SLAB.values(), dye);
                }
            }
            private void dyeStairOrSlab(RecipeOutput output, Block result, java.util.Collection<Block> ingredients, Item dye) {
                String group = result.getName().getString().contains("wool") ? "wool_dyeing" : "concrete_dyeing";
                shaped(RecipeCategory.BUILDING_BLOCKS, result, 8)
                        .define('#', Ingredient.of(ingredients.stream().map(Block::asItem).toArray(Item[]::new)))
                        .define('D', dye)
                        .pattern("###")
                        .pattern("#D#")
                        .pattern("###")
                        .group(group)
                        .unlockedBy("has_dye", has(dye))
                        .save(output, String.valueOf(Identifier.fromNamespaceAndPath(CampsAndColors.MOD_ID,
                                BuiltInRegistries.BLOCK.getKey(result).getPath() + "_dyeing")));
            }
        };
    }



    @Override
    public String getName() {
        return "ModRecipeProvider";
    }
}
