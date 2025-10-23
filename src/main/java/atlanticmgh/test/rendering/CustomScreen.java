package atlanticmgh.test.rendering;

import atlanticmgh.test.Items.custom.ArmorCharmItem;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import atlanticmgh.test.network.ApplyEffectPayload;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;

public class CustomScreen extends Screen {

    private PlayerEntity player;
    private Hand hand;

    public CustomScreen(Text title) {
        super(title);
    }

    @Override
    protected void init() {
        ButtonWidget physicalButton = ButtonWidget.builder(Text.translatable("physical_button"), (btn) -> {
            ClientPlayNetworking.send(new ApplyEffectPayload("physical"));
            MinecraftClient.getInstance().setScreen(null);
        }).dimensions(this.width/4, 60 - this.textRenderer.fontHeight - 10, this.width/2, 20).build();
        this.addDrawableChild(physicalButton);

        ButtonWidget undeadMobButton = ButtonWidget.builder(Text.translatable("undead_mobs_button"), (btn) -> {
            ClientPlayNetworking.send(new ApplyEffectPayload("undead_mob"));
            MinecraftClient.getInstance().setScreen(null);
        }).dimensions(this.width/4, 90 - this.textRenderer.fontHeight - 10, this.width/2, 20).build();
        this.addDrawableChild(undeadMobButton);

        ButtonWidget netherMobButton = ButtonWidget.builder(Text.translatable("nether_mobs_button"), (btn) -> {
            ClientPlayNetworking.send(new ApplyEffectPayload("nether_mob"));
            MinecraftClient.getInstance().setScreen(null);
        }).dimensions(this.width/4, 120 - this.textRenderer.fontHeight - 10, this.width/2, 20).build();
        this.addDrawableChild(netherMobButton);

        ButtonWidget piglinMobButton = ButtonWidget.builder(Text.translatable("piglin_mobs_button"), (btn) -> {
            ClientPlayNetworking.send(new ApplyEffectPayload("piglin_mob"));
            MinecraftClient.getInstance().setScreen(null);
        }).dimensions(this.width/4, 150 - this.textRenderer.fontHeight - 10, this.width/2, 20).build();
        this.addDrawableChild(piglinMobButton);
    }

    private PlayerEntity getPlayer(){
        return this.player;
    }
    public void setPlayer(PlayerEntity player){
        this.player = player;
    }

    private Hand getHand(){
        return this.hand;
    }
    public void setHand(Hand hand){
        this.hand = hand;
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        super.render(context, mouseX, mouseY, delta);

        context.drawText(this.textRenderer, Text.translatable("armor_effect_text"),
                this.width/2-this.textRenderer.getWidth(Text.translatable("armor_effect_text"))/2,
                40 - this.textRenderer.fontHeight - 10, 0xFFFFFFFF, true);
    }
}