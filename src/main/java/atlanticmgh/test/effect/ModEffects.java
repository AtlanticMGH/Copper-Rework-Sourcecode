package atlanticmgh.test.effect;

import atlanticmgh.test.CopperRework;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;

public class ModEffects{

    public static final RegistryEntry<StatusEffect> FLY =
            Registry.registerReference(Registries.STATUS_EFFECT, Identifier.of(CopperRework.MOD_ID, "fly"), new FlyEffect());
    public static final RegistryEntry<StatusEffect> ARMOR_PHYSICAL_DEBUFF =
            Registry.registerReference(Registries.STATUS_EFFECT, Identifier.of(CopperRework.MOD_ID, "armor_physical_debuff"), new ArmorPhysicalEffect());
    public static final RegistryEntry<StatusEffect> ARMOR_UNDEAD_MOB_DEBUFF =
            Registry.registerReference(Registries.STATUS_EFFECT, Identifier.of(CopperRework.MOD_ID, "armor_undead_mob_debuff"), new ArmorUndeadMobEffect());
    public static final RegistryEntry<StatusEffect> ARMOR_NETHER_MOB_DEBUFF =
            Registry.registerReference(Registries.STATUS_EFFECT, Identifier.of(CopperRework.MOD_ID, "armor_nether_mob_debuff"), new ArmorNetherMobEffect());
    public static final RegistryEntry<StatusEffect> ARMOR_PIGLIN_MOB_DEBUFF =
            Registry.registerReference(Registries.STATUS_EFFECT, Identifier.of(CopperRework.MOD_ID, "armor_piglin_mob_debuff"), new ArmorPiglinMobEffect());

    public static void initialize() {
        //
    }
}
