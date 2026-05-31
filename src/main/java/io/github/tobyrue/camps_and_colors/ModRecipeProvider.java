package io.github.tobyrue.camps_and_colors;

import io.github.tobyrue.camps_and_colors.blocks.ModBlocks;
import io.github.tobyrue.camps_and_colors.items.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;

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
                for (DyeColor color : DyeColor.values()) {
                    Block wool = ModBlocks.WOOL.get(color);
                    Block woolStairs = ModBlocks.WOOL_STAIRS.get(color);
                    Block woolSlab = ModBlocks.WOOL_SLAB.get(color);

                    Block concrete = ModBlocks.CONCRETE.get(color);
                    Block concreteStairs = ModBlocks.CONCRETE_STAIRS.get(color);
                    Block concreteSlab = ModBlocks.CONCRETE_SLAB.get(color);

                    stairBuilder(woolStairs, Ingredient.of(wool));
                    slabBuilder(RecipeCategory.BUILDING_BLOCKS, woolSlab, Ingredient.of(wool));

                    stairBuilder(concreteStairs, Ingredient.of(concrete));
                    slabBuilder(RecipeCategory.BUILDING_BLOCKS, concreteSlab, Ingredient.of(concrete));
                    stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, concreteStairs, concrete);
                    stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, concreteSlab, concrete, 2);
                }

                planksFromLog(ModBlocks.POPLAR_PLANKS, ItemTags.PLANKS, 4);
                smeltingResultFromBase(Items.CHARCOAL, ModBlocks.POPLAR_LOG);



                stairBuilder(ModBlocks.POPLAR_STAIRS, Ingredient.of(ModBlocks.POPLAR_PLANKS));
                slabBuilder(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POPLAR_SLAB, Ingredient.of(ModBlocks.POPLAR_PLANKS));
                fenceBuilder(ModBlocks.POPLAR_FENCE, Ingredient.of(ModBlocks.POPLAR_PLANKS));
                fenceGateBuilder(ModBlocks.POPLAR_FENCE_GATE, Ingredient.of(ModBlocks.POPLAR_PLANKS));
                pressurePlateBuilder(RecipeCategory.REDSTONE, ModBlocks.POPLAR_PRESSURE_PLATE, Ingredient.of(ModBlocks.POPLAR_PLANKS));
                buttonBuilder(ModBlocks.POPLAR_BUTTON, Ingredient.of(ModBlocks.POPLAR_PLANKS));
                shelf(ModBlocks.POPLAR_SHELF, ModBlocks.STRIPPED_POPLAR_LOG);
                woodenBoat(ModItems.POPLAR_BOAT_ITEM, ModBlocks.POPLAR_PLANKS);
                chestBoat(ModItems.POPLAR_CHEST_BOAT_ITEM, ModBlocks.POPLAR_PLANKS);
                woodFromLogs(ModBlocks.POPLAR_WOOD, ModBlocks.POPLAR_LOG);
                woodFromLogs(ModBlocks.STRIPPED_POPLAR_WOOD, ModBlocks.STRIPPED_POPLAR_LOG);
                signBuilder(ModBlocks.POPLAR_SIGN, Ingredient.of(ModBlocks.POPLAR_PLANKS));
                hangingSign(ModBlocks.POPLAR_HANGING_SIGN, ModBlocks.POPLAR_PLANKS);


                doorBuilder(ModBlocks.POPLAR_DOOR, Ingredient.of(ModBlocks.POPLAR_PLANKS));
                trapdoorBuilder(ModBlocks.POPLAR_TRAPDOOR, Ingredient.of(ModBlocks.POPLAR_PLANKS));
            }
        };
    }

    @Override
    public String getName() {
        return "ModRecipeProvider";
    }
}
