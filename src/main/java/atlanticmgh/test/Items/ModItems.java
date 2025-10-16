package atlanticmgh.test.Items;

import atlanticmgh.test.CopperRework;
import atlanticmgh.test.Items.custom.ArmorCharmItem;
import atlanticmgh.test.Items.custom.FlyingCharmItem;
import atlanticmgh.test.Items.custom.SpeedCharmItem;
import atlanticmgh.test.Items.custom.WaterCharmItem;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public class ModItems {
    public static Item register(String name, Function<Item.Settings, Item> itemFactory, Item.Settings settings) {
        // Create the item key.
        RegistryKey<Item> itemKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(CopperRework.MOD_ID, name));
        Item item = itemFactory.apply(settings.registryKey(itemKey));
        Registry.register(Registries.ITEM, itemKey, item);
        return item;
    }

    public static final FlyingCharmItem FLYINGCHARM = (FlyingCharmItem) register("flyingcharm", FlyingCharmItem::new, new Item.Settings().maxCount(1).maxDamage(5).useCooldown(60));
    public static final WaterCharmItem WATERCHARM = (WaterCharmItem) register("watercharm", WaterCharmItem::new, new Item.Settings().maxCount(1).maxDamage(5).useCooldown(60));
    public static final ArmorCharmItem ARMORCHARM = (ArmorCharmItem) register("armorcharm", ArmorCharmItem::new, new Item.Settings().maxCount(1).maxDamage(5).useCooldown(60));
    public static final SpeedCharmItem SPEEDCHARM = (SpeedCharmItem) register("speedcharm", SpeedCharmItem::new, new Item.Settings().maxCount(1).maxDamage(5).useCooldown(60));

    public static final RegistryKey<ItemGroup> TEST_ITEM_GROUP_KEY = RegistryKey.of(Registries.ITEM_GROUP.getKey(), Identifier.of(CopperRework.MOD_ID, "item_group"));
    public static final ItemGroup TEST_ITEM_GROUP = FabricItemGroup.builder()
            .icon(() -> new ItemStack(ModItems.FLYINGCHARM))
            .displayName(Text.translatable("Copper rework"))
            .build();

    public static void initialize() {
        Registry.register(Registries.ITEM_GROUP, TEST_ITEM_GROUP_KEY, TEST_ITEM_GROUP);
        ItemGroupEvents.modifyEntriesEvent(TEST_ITEM_GROUP_KEY).register(itemGroup -> {
            itemGroup.add(ModItems.FLYINGCHARM);
            itemGroup.add(ModItems.WATERCHARM);
            itemGroup.add(ModItems.ARMORCHARM);
            itemGroup.add(ModItems.SPEEDCHARM);
        });
    }

}
