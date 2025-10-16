package atlanticmgh.test.Items.custom;

import atlanticmgh.test.effect.ModEffects;
import atlanticmgh.test.rendering.CustomScreen;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class ArmorCharmItem extends Item {
    public ArmorCharmItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);

        CustomScreen screen = new CustomScreen(Text.empty());
        MinecraftClient.getInstance().setScreen(screen);
        screen.setPlayer(user);
        screen.setHand(hand);

        return ActionResult.SUCCESS;
    }


    public static void setEffect(String chosenEffect, PlayerEntity user, Hand hand){
        ItemStack itemStack = user.getStackInHand(hand);

        if(chosenEffect != null){
            if(!user.getAbilities().creativeMode){
                itemStack.damage(1, user, hand.getEquipmentSlot());
            }
            switch (chosenEffect){
                case "physical":
                    user.addStatusEffect(new StatusEffectInstance(ModEffects.ARMOR_PHYSICAL_DEBUFF, 1800, 0, false, false));
                    break;
                case "undead_mob":
                    user.addStatusEffect(new StatusEffectInstance(ModEffects.ARMOR_UNDEAD_MOB_DEBUFF, 1800, 0, false, false));
                    break;
                case "nether_mob":
                    user.addStatusEffect(new StatusEffectInstance(ModEffects.ARMOR_NETHER_MOB_DEBUFF, 1800, 0, false, false));
                    break;
                case "piglin_mob":
                    user.addStatusEffect(new StatusEffectInstance(ModEffects.ARMOR_PIGLIN_MOB_DEBUFF, 1800, 0, false, false));
                    break;
            }
        }
    }


}
