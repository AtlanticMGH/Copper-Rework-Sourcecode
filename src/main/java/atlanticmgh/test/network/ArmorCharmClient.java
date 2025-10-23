package atlanticmgh.test.network;

import atlanticmgh.test.rendering.CustomScreen;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;

public class ArmorCharmClient {

    public static void openScreen(PlayerEntity player, Hand hand) {
        MinecraftClient client = MinecraftClient.getInstance();
        CustomScreen screen = new CustomScreen(Text.translatable("armor_charm"));
        screen.setPlayer(player);
        screen.setHand(hand);
        client.setScreen(screen);
    }
}