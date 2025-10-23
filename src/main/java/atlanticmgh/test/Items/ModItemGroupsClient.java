package atlanticmgh.test.Items;

import atlanticmgh.test.CopperRework;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroupsClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        RegistryKey<ItemGroup> TEST_ITEM_GROUP_KEY = RegistryKey.of(RegistryKeys.ITEM_GROUP,
                Identifier.of(CopperRework.MOD_ID, "item_group"));

        ItemGroup TEST_ITEM_GROUP = FabricItemGroup.builder()
                .icon(() -> new ItemStack(ModItems.FLYINGCHARM))
                .displayName(Text.translatable("Copper rework"))
                .build();

        Registry.register(Registries.ITEM_GROUP, TEST_ITEM_GROUP_KEY, TEST_ITEM_GROUP);

        ItemGroupEvents.modifyEntriesEvent(TEST_ITEM_GROUP_KEY).register(entries -> {
            entries.add(ModItems.FLYINGCHARM);
            entries.add(ModItems.WATERCHARM);
            entries.add(ModItems.ARMORCHARM);
            entries.add(ModItems.SPEEDCHARM);
        });
    }
}
