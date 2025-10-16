package atlanticmgh.test.datagen;

import atlanticmgh.test.Items.ModItems;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.client.data.BlockStateModelGenerator;
import net.minecraft.client.data.ItemModelGenerator;
import net.minecraft.client.data.Models;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {

    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.FLYINGCHARM, Models.HANDHELD);
        itemModelGenerator.register(ModItems.WATERCHARM, Models.HANDHELD);
        itemModelGenerator.register(ModItems.ARMORCHARM, Models.HANDHELD);
        itemModelGenerator.register(ModItems.SPEEDCHARM, Models.HANDHELD);
    }
}
