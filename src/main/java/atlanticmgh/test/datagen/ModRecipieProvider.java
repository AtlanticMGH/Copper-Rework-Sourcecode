package atlanticmgh.test.datagen;

import atlanticmgh.test.Items.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

public class ModRecipieProvider extends FabricRecipeProvider {
    public ModRecipieProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeGenerator getRecipeGenerator(RegistryWrapper.WrapperLookup registryLookup, RecipeExporter exporter) {
        return new RecipeGenerator(registryLookup, exporter) {
            @Override
            public void generate() {
                RegistryWrapper.Impl<Item> itemLookup = registries.getOrThrow(RegistryKeys.ITEM);

                createShaped(RecipeCategory.MISC, ModItems.FLYINGCHARM, 1)
                        .pattern("rcr")
                        .pattern("chc")
                        .pattern("rcr")
                        .input('c', Items.COPPER_INGOT)
                        .input('r', Items.REDSTONE)
                        .input('h', Items.COPPER_HELMET)
                        .group("multi_bench")
                        .criterion(hasItem(Items.CRAFTING_TABLE), conditionsFromItem(Items.CRAFTING_TABLE))
                        .offerTo(exporter);

                createShaped(RecipeCategory.MISC, ModItems.WATERCHARM, 1)
                        .pattern("rcr")
                        .pattern("cbc")
                        .pattern("rcr")
                        .input('c', Items.COPPER_INGOT)
                        .input('r', Items.REDSTONE)
                        .input('b', Items.COPPER_BOOTS)
                        .group("multi_bench")
                        .criterion(hasItem(Items.CRAFTING_TABLE), conditionsFromItem(Items.CRAFTING_TABLE))
                        .offerTo(exporter);

                createShaped(RecipeCategory.MISC, ModItems.ARMORCHARM, 1)
                        .pattern("aca")
                        .pattern("cnc")
                        .pattern("aca")
                        .input('c', Items.COPPER_INGOT)
                        .input('n', Items.NETHER_STAR)
                        .input('a', Items.COPPER_CHESTPLATE)
                        .group("multi_bench")
                        .criterion(hasItem(Items.CRAFTING_TABLE), conditionsFromItem(Items.CRAFTING_TABLE))
                        .offerTo(exporter);

                createShaped(RecipeCategory.MISC, ModItems.SPEEDCHARM, 1)
                        .pattern("rcr")
                        .pattern("clc")
                        .pattern("rcr")
                        .input('c', Items.COPPER_INGOT)
                        .input('r', Items.REDSTONE)
                        .input('l', Items.COPPER_LEGGINGS)
                        .group("multi_bench")
                        .criterion(hasItem(Items.CRAFTING_TABLE), conditionsFromItem(Items.CRAFTING_TABLE))
                        .offerTo(exporter);
            }
        };
    }

    @Override
    public String getName() {
        return "ExampleModRecipeProvider";
    }
}
