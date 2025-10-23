package atlanticmgh.test.network;

import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import atlanticmgh.test.effect.ModEffects;
import net.minecraft.entity.effect.StatusEffectInstance;

public class ArmorCharmNetworking {

    public static void registerCommon() {
        PayloadTypeRegistry.playC2S().register(ApplyEffectPayload.ID, ApplyEffectPayload.CODEC);
    }

    public static void registerServer() {
        ServerPlayNetworking.registerGlobalReceiver(ApplyEffectPayload.ID, (payload, context) -> {
            ServerPlayerEntity player = context.player();
            String effect = payload.effect();
            context.server().execute(() -> applyEffect(player, effect));
        });
    }

    private static void applyEffect(ServerPlayerEntity player, String effect) {
        ItemStack itemStack = player.getStackInHand(player.getActiveHand());
        if (!player.getAbilities().creativeMode) {
            itemStack.damage(1, player, player.getActiveHand().getEquipmentSlot());
        }

        switch (effect) {
            case "physical" ->
                    player.addStatusEffect(new StatusEffectInstance(ModEffects.ARMOR_PHYSICAL_DEBUFF, 1800, 0, false, false));
            case "undead_mob" ->
                    player.addStatusEffect(new StatusEffectInstance(ModEffects.ARMOR_UNDEAD_MOB_DEBUFF, 1800, 0, false, false));
            case "nether_mob" ->
                    player.addStatusEffect(new StatusEffectInstance(ModEffects.ARMOR_NETHER_MOB_DEBUFF, 1800, 0, false, false));
            case "piglin_mob" ->
                    player.addStatusEffect(new StatusEffectInstance(ModEffects.ARMOR_PIGLIN_MOB_DEBUFF, 1800, 0, false, false));
        }
    }
}
