package atlanticmgh.test.Items.custom;

import atlanticmgh.test.CopperRework;
import atlanticmgh.test.effect.ModEffects;
import atlanticmgh.test.network.ArmorCharmClient;
import atlanticmgh.test.rendering.CustomScreen;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.codec.PacketCodecs;
import net.minecraft.network.packet.CustomPayload;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;

public class ArmorCharmItem extends Item {
    public ArmorCharmItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        if (world.isClient()) {
            ArmorCharmClient.openScreen(user, hand);
        }
        /*CustomScreen screen = new CustomScreen(Text.empty());
        MinecraftClient.getInstance().setScreen(screen);
        screen.setPlayer(user);
        screen.setHand(hand);*/

        return ActionResult.SUCCESS;
    }

    public record GiveEffectC2SPayload(int entityId) implements CustomPayload {
        public static final Identifier GIVE_GLOWING_EFFECT_PAYLOAD_ID = Identifier.of(CopperRework.MOD_ID, "give_glowing_effect");
        public static final CustomPayload.Id<GiveEffectC2SPayload> ID = new CustomPayload.Id<>(GIVE_GLOWING_EFFECT_PAYLOAD_ID);
        public static final PacketCodec<RegistryByteBuf, GiveEffectC2SPayload> CODEC = PacketCodec.tuple(PacketCodecs.INTEGER, GiveEffectC2SPayload::entityId, GiveEffectC2SPayload::new);

        @Override
        public Id<? extends CustomPayload> getId() {
            return ID;
        }
    }

    public static void setEffect(String chosenEffect, PlayerEntity user, Hand hand){
        ItemStack itemStack = user.getStackInHand(hand);

        if(chosenEffect != null){
            if(!user.getAbilities().creativeMode){
                itemStack.damage(1, user, hand.getEquipmentSlot());
            }
        }
    }


}
