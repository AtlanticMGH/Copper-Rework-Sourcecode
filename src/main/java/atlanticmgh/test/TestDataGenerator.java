package atlanticmgh.test;

import atlanticmgh.test.datagen.ModModelProvider;
import atlanticmgh.test.datagen.ModRecipieProvider;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class TestDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

        pack.addProvider(ModRecipieProvider::new);
        pack.addProvider(ModModelProvider::new);
	}
}
